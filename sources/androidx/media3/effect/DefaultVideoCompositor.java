package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.SparseArray;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoCompositor;
import androidx.media3.effect.GlTextureProducer;
import androidx.media3.effect.VideoCompositor;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultVideoCompositor implements VideoCompositor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VideoCompositor.Listener f42304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlTextureProducer.Listener f42305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GlObjectsProvider f42306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoCompositorSettings f42307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CompositorGlProgram f42308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final VideoFrameProcessingTaskExecutor f42309f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f42311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TexturePool f42312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LongArrayQueue f42313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LongArrayQueue f42314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorInfo f42315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private EGLDisplay f42316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private EGLSurface f42317n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f42318o = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SparseArray f42310g = new SparseArray();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CompositorGlProgram {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f42319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OverlayMatrixProvider f42320b = new OverlayMatrixProvider();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private GlProgram f42321c;

        public CompositorGlProgram(Context context) {
            this.f42319a = context;
        }

        private void a(InputFrameInfo inputFrameInfo) throws GlUtil.GlException {
            GlProgram glProgram = (GlProgram) Assertions.e(this.f42321c);
            GlTextureInfo glTextureInfo = inputFrameInfo.f42323b;
            glProgram.s("uTexSampler", glTextureInfo.f40690a, 0);
            glProgram.p("uTransformationMatrix", this.f42320b.b(new Size(glTextureInfo.f40693d, glTextureInfo.f40694e), inputFrameInfo.f42325d));
            glProgram.o("uAlphaScale", inputFrameInfo.f42325d.b());
            glProgram.e();
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.e();
        }

        private void c() throws VideoFrameProcessingException {
            if (this.f42321c != null) {
                return;
            }
            try {
                GlProgram glProgram = new GlProgram(this.f42319a, "shaders/vertex_shader_transformation_es2.glsl", "shaders/fragment_shader_alpha_scale_es2.glsl");
                this.f42321c = glProgram;
                glProgram.m("aFramePosition", GlUtil.O(), 4);
                this.f42321c.p("uTexTransformationMatrix", GlUtil.h());
            } catch (IOException e3) {
                throw new VideoFrameProcessingException(e3);
            }
        }

        public void b(List list, GlTextureInfo glTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
            c();
            GlUtil.H(glTextureInfo.f40691b, glTextureInfo.f40693d, glTextureInfo.f40694e);
            this.f42320b.a(new Size(glTextureInfo.f40693d, glTextureInfo.f40694e));
            GlUtil.g();
            ((GlProgram) Assertions.e(this.f42321c)).u();
            GLES20.glEnable(3042);
            GLES20.glBlendFuncSeparate(770, 771, 1, 771);
            GlUtil.e();
            for (int size = list.size() - 1; size >= 0; size--) {
                a((InputFrameInfo) list.get(size));
            }
            GLES20.glDisable(3042);
            GlUtil.e();
        }

        public void d() {
            try {
                GlProgram glProgram = this.f42321c;
                if (glProgram != null) {
                    glProgram.f();
                }
            } catch (GlUtil.GlException e3) {
                Log.e("CompositorGlProgram", "Error releasing GL Program", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InputFrameInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GlTextureProducer f42322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final GlTextureInfo f42323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f42324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final OverlaySettings f42325d;

        public InputFrameInfo(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j3, OverlaySettings overlaySettings) {
            this.f42322a = glTextureProducer;
            this.f42323b = glTextureInfo;
            this.f42324c = j3;
            this.f42325d = overlaySettings;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InputSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue f42326a = new ArrayDeque();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f42327b;
    }

    public DefaultVideoCompositor(Context context, GlObjectsProvider glObjectsProvider, VideoCompositorSettings videoCompositorSettings, ExecutorService executorService, final VideoCompositor.Listener listener, GlTextureProducer.Listener listener2, int i3) {
        this.f42304a = listener;
        this.f42305b = listener2;
        this.f42306c = glObjectsProvider;
        this.f42307d = videoCompositorSettings;
        this.f42308e = new CompositorGlProgram(context);
        this.f42312i = new TexturePool(false, i3);
        this.f42313j = new LongArrayQueue(i3);
        this.f42314k = new LongArrayQueue(i3);
        Objects.requireNonNull(listener);
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = new VideoFrameProcessingTaskExecutor(executorService, false, new VideoFrameProcessingTaskExecutor.ErrorListener() { // from class: androidx.media3.effect.u
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.ErrorListener
            public final void a(VideoFrameProcessingException videoFrameProcessingException) {
                listener.a(videoFrameProcessingException);
            }
        });
        this.f42309f = videoFrameProcessingTaskExecutor;
        videoFrameProcessingTaskExecutor.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.v
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws GlUtil.GlException {
                this.f42802a.q();
            }
        });
    }

    public static /* synthetic */ boolean c(long j3, InputFrameInfo inputFrameInfo) {
        return inputFrameInfo.f42324c <= j3;
    }

    private synchronized ImmutableList i() {
        if (this.f42312i.h() == 0) {
            return ImmutableList.y();
        }
        for (int i3 = 0; i3 < this.f42310g.size(); i3++) {
            if (((InputSource) this.f42310g.valueAt(i3)).f42326a.isEmpty()) {
                return ImmutableList.y();
            }
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        InputFrameInfo inputFrameInfo = (InputFrameInfo) ((InputSource) this.f42310g.get(this.f42318o)).f42326a.element();
        builder.a(inputFrameInfo);
        for (int i4 = 0; i4 < this.f42310g.size(); i4++) {
            if (this.f42310g.keyAt(i4) != this.f42318o) {
                InputSource inputSource = (InputSource) this.f42310g.valueAt(i4);
                if (inputSource.f42326a.size() == 1 && !inputSource.f42327b) {
                    return ImmutableList.y();
                }
                Iterator it = inputSource.f42326a.iterator();
                long j3 = Long.MAX_VALUE;
                InputFrameInfo inputFrameInfo2 = null;
                while (it.hasNext()) {
                    InputFrameInfo inputFrameInfo3 = (InputFrameInfo) it.next();
                    long j4 = inputFrameInfo3.f42324c;
                    long jAbs = Math.abs(j4 - inputFrameInfo.f42324c);
                    if (jAbs < j3) {
                        inputFrameInfo2 = inputFrameInfo3;
                        j3 = jAbs;
                    }
                    if (j4 > inputFrameInfo.f42324c || (!it.hasNext() && inputSource.f42327b)) {
                        builder.a((InputFrameInfo) Assertions.e(inputFrameInfo2));
                        break;
                    }
                }
            }
        }
        ImmutableList immutableListM = builder.m();
        if (immutableListM.size() == this.f42310g.size()) {
            return immutableListM;
        }
        return ImmutableList.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void k() throws Throwable {
        try {
            try {
                ImmutableList immutableListI = i();
                if (immutableListI.isEmpty()) {
                    return;
                }
                InputFrameInfo inputFrameInfo = (InputFrameInfo) immutableListI.get(this.f42318o);
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (int i3 = 0; i3 < immutableListI.size(); i3++) {
                    GlTextureInfo glTextureInfo = ((InputFrameInfo) immutableListI.get(i3)).f42323b;
                    builder.a(new Size(glTextureInfo.f40693d, glTextureInfo.f40694e));
                }
                Size sizeB = this.f42307d.b(builder.m());
                this.f42312i.d(this.f42306c, sizeB.b(), sizeB.a());
                GlTextureInfo glTextureInfoL = this.f42312i.l();
                long j3 = inputFrameInfo.f42324c;
                this.f42313j.a(j3);
                this.f42308e.b(immutableListI, glTextureInfoL);
                long jQ = GlUtil.q();
                this.f42314k.a(jQ);
                this.f42305b.a(this, glTextureInfoL, j3, jQ);
                InputSource inputSource = (InputSource) this.f42310g.get(this.f42318o);
                n(inputSource, 1);
                l();
                if (this.f42311h && inputSource.f42326a.isEmpty()) {
                    this.f42304a.b();
                }
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    private synchronized void l() {
        for (int i3 = 0; i3 < this.f42310g.size(); i3++) {
            if (this.f42310g.keyAt(i3) != this.f42318o) {
                m((InputSource) this.f42310g.valueAt(i3));
            }
        }
    }

    private synchronized void m(InputSource inputSource) {
        InputSource inputSource2 = (InputSource) this.f42310g.get(this.f42318o);
        if (inputSource2.f42326a.isEmpty() && inputSource2.f42327b) {
            n(inputSource, inputSource.f42326a.size());
            return;
        }
        InputFrameInfo inputFrameInfo = (InputFrameInfo) inputSource2.f42326a.peek();
        final long j3 = inputFrameInfo != null ? inputFrameInfo.f42324c : -9223372036854775807L;
        n(inputSource, Math.max(Iterables.r(Iterables.e(inputSource.f42326a, new Predicate() { // from class: androidx.media3.effect.y
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return DefaultVideoCompositor.c(j3, (DefaultVideoCompositor.InputFrameInfo) obj);
            }
        })) - 1, 0));
    }

    private synchronized void n(InputSource inputSource, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            InputFrameInfo inputFrameInfo = (InputFrameInfo) inputSource.f42326a.remove();
            inputFrameInfo.f42322a.j(inputFrameInfo.f42324c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            this.f42308e.d();
            this.f42312i.c();
            GlUtil.F(this.f42316m, this.f42317n);
        } catch (GlUtil.GlException e3) {
            Log.e("DefaultVideoCompositor", "Error releasing GL resources", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(long j3) {
        while (this.f42312i.h() < this.f42312i.a() && this.f42313j.d() <= j3) {
            try {
                this.f42312i.f();
                this.f42313j.f();
                GlUtil.B(this.f42314k.f());
            } catch (Throwable th) {
                throw th;
            }
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() throws GlUtil.GlException {
        EGLDisplay eGLDisplayM = GlUtil.M();
        this.f42316m = eGLDisplayM;
        this.f42317n = this.f42306c.c(this.f42306c.d(eGLDisplayM, 2, GlUtil.f41535a), this.f42316m);
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void b(int i3, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, ColorInfo colorInfo, long j3) {
        try {
            Assertions.g(Util.t(this.f42310g, i3));
            InputSource inputSource = (InputSource) this.f42310g.get(i3);
            Assertions.g(!inputSource.f42327b);
            Assertions.j(Boolean.valueOf(!ColorInfo.l(colorInfo)), "HDR input is not supported.");
            if (this.f42315l == null) {
                this.f42315l = colorInfo;
            }
            Assertions.h(this.f42315l.equals(colorInfo), "Mixing different ColorInfos is not supported.");
            inputSource.f42326a.add(new InputFrameInfo(glTextureProducer, glTextureInfo, j3, this.f42307d.a(i3, j3)));
            if (i3 == this.f42318o) {
                l();
            } else {
                m(inputSource);
            }
            this.f42309f.j(new w(this));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void e(int i3) {
        Assertions.g(!Util.t(this.f42310g, i3));
        this.f42310g.put(i3, new InputSource());
        if (this.f42318o == -1) {
            this.f42318o = i3;
        }
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void f(int i3) {
        try {
            Assertions.g(Util.t(this.f42310g, i3));
            boolean z2 = false;
            Assertions.g(this.f42318o != -1);
            ((InputSource) this.f42310g.get(i3)).f42327b = true;
            int i4 = 0;
            while (true) {
                if (i4 >= this.f42310g.size()) {
                    z2 = true;
                    break;
                } else if (!((InputSource) this.f42310g.valueAt(i4)).f42327b) {
                    break;
                } else {
                    i4++;
                }
            }
            this.f42311h = z2;
            if (((InputSource) this.f42310g.get(this.f42318o)).f42326a.isEmpty()) {
                if (i3 == this.f42318o) {
                    l();
                }
                if (z2) {
                    this.f42304a.b();
                    return;
                }
            }
            if (i3 != this.f42318o && ((InputSource) this.f42310g.get(i3)).f42326a.size() == 1) {
                this.f42309f.j(new w(this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.effect.GlTextureProducer
    public void j(final long j3) {
        this.f42309f.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.x
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f42809a.p(j3);
            }
        });
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void release() {
        try {
            this.f42309f.i(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.t
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f42792a.o();
                }
            });
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e3);
        }
    }
}

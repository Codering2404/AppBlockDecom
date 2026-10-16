package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.Size;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.GlTextureProducer;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FinalShaderProgramWrapper implements GlShaderProgram, GlTextureProducer {
    private SurfaceInfo A;
    private EGLSurface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42396a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EGLDisplay f42399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EGLContext f42400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EGLSurface f42401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ColorInfo f42402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final VideoFrameProcessingTaskExecutor f42403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f42404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final VideoFrameProcessor.Listener f42405j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TexturePool f42407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LongArrayQueue f42408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final LongArrayQueue f42409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final GlTextureProducer.Listener f42410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f42411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f42412q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f42413r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f42414s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private DefaultShaderProgram f42415t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f42416u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Size f42418w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private OnInputStreamProcessedListener f42419x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f42420y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f42421z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f42397b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f42398c = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private GlShaderProgram.InputListener f42417v = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.FinalShaderProgramWrapper.1
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Queue f42406k = new ConcurrentLinkedQueue();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnInputStreamProcessedListener {
        void a();
    }

    public FinalShaderProgramWrapper(Context context, EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, ColorInfo colorInfo, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, GlTextureProducer.Listener listener2, int i3, int i4, boolean z2) {
        this.f42396a = context;
        this.f42399d = eGLDisplay;
        this.f42400e = eGLContext;
        this.f42401f = eGLSurface;
        this.f42402g = colorInfo;
        this.f42403h = videoFrameProcessingTaskExecutor;
        this.f42404i = executor;
        this.f42405j = listener;
        this.f42410o = listener2;
        this.f42411p = i4;
        this.f42412q = z2;
        this.f42407l = new TexturePool(ColorInfo.l(colorInfo), i3);
        this.f42408m = new LongArrayQueue(i3);
        this.f42409n = new LongArrayQueue(i3);
    }

    private void A(GlTextureInfo glTextureInfo, long j3, long j4) throws VideoFrameProcessingException, GlUtil.GlException {
        EGLSurface eGLSurface = (EGLSurface) Assertions.e(this.B);
        SurfaceInfo surfaceInfo = (SurfaceInfo) Assertions.e(this.A);
        DefaultShaderProgram defaultShaderProgram = (DefaultShaderProgram) Assertions.e(this.f42415t);
        GlUtil.G(this.f42399d, this.f42400e, eGLSurface, surfaceInfo.f41097b, surfaceInfo.f41098c);
        GlUtil.g();
        defaultShaderProgram.n(glTextureInfo.f40690a, j3);
        if (j4 == -1) {
            j4 = System.nanoTime();
        } else if (j4 == -3) {
            Assertions.g(j3 != -9223372036854775807L);
            j4 = 1000 * j3;
        }
        EGLExt.eglPresentationTimeANDROID(this.f42399d, eGLSurface, j4);
        EGL14.eglSwapBuffers(this.f42399d, eGLSurface);
        DebugTraceUtil.e("VideoFrameProcessor", "RenderedToOutputSurface", j3);
    }

    private void B(GlTextureInfo glTextureInfo, long j3) throws VideoFrameProcessingException, GlUtil.GlException {
        GlTextureInfo glTextureInfoL = this.f42407l.l();
        this.f42408m.a(j3);
        GlUtil.H(glTextureInfoL.f40691b, glTextureInfoL.f40693d, glTextureInfoL.f40694e);
        GlUtil.g();
        ((DefaultShaderProgram) Assertions.e(this.f42415t)).n(glTextureInfo.f40690a, j3);
        long jQ = GlUtil.q();
        this.f42409n.a(jQ);
        ((GlTextureProducer.Listener) Assertions.e(this.f42410o)).a(this, glTextureInfoL, j3, jQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(SurfaceInfo surfaceInfo) {
        if (this.f42410o == null && !Objects.equals(this.A, surfaceInfo)) {
            SurfaceInfo surfaceInfo2 = this.A;
            if (surfaceInfo2 != null && (surfaceInfo == null || !surfaceInfo2.f41096a.equals(surfaceInfo.f41096a))) {
                v();
            }
            SurfaceInfo surfaceInfo3 = this.A;
            this.f42421z = (surfaceInfo3 != null && surfaceInfo != null && surfaceInfo3.f41097b == surfaceInfo.f41097b && surfaceInfo3.f41098c == surfaceInfo.f41098c && surfaceInfo3.f41099d == surfaceInfo.f41099d) ? false : true;
            this.A = surfaceInfo;
        }
    }

    private DefaultShaderProgram u(int i3, int i4, int i5) throws VideoFrameProcessingException {
        ImmutableList.Builder builderK = new ImmutableList.Builder().k(this.f42397b);
        if (i3 != 0) {
            builderK.a(new ScaleAndRotateTransformation.Builder().b(i3).a());
        }
        builderK.a(Presentation.m(i4, i5, 0));
        DefaultShaderProgram defaultShaderProgramU = DefaultShaderProgram.u(this.f42396a, builderK.m(), this.f42398c, this.f42402g, this.f42411p);
        Size sizeJ = defaultShaderProgramU.j(this.f42413r, this.f42414s);
        SurfaceInfo surfaceInfo = this.A;
        if (surfaceInfo != null) {
            SurfaceInfo surfaceInfo2 = (SurfaceInfo) Assertions.e(surfaceInfo);
            Assertions.g(sizeJ.b() == surfaceInfo2.f41097b);
            Assertions.g(sizeJ.a() == surfaceInfo2.f41098c);
        }
        return defaultShaderProgramU;
    }

    private void v() {
        if (this.B == null) {
            return;
        }
        try {
            GlUtil.G(this.f42399d, this.f42400e, this.f42401f, 1, 1);
            GlUtil.F(this.f42399d, this.B);
        } catch (GlUtil.GlException e3) {
            this.f42404i.execute(new Runnable() { // from class: androidx.media3.effect.a1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42688a.f42405j.a(VideoFrameProcessingException.a(e3));
                }
            });
        } finally {
            this.B = null;
        }
    }

    private boolean w(GlObjectsProvider glObjectsProvider, int i3, int i4) throws VideoFrameProcessingException {
        boolean z2 = (this.f42413r == i3 && this.f42414s == i4 && this.f42418w != null) ? false : true;
        if (z2) {
            this.f42413r = i3;
            this.f42414s = i4;
            final Size sizeC = MatrixUtils.c(i3, i4, this.f42397b);
            if (!Objects.equals(this.f42418w, sizeC)) {
                this.f42418w = sizeC;
                this.f42404i.execute(new Runnable() { // from class: androidx.media3.effect.b1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FinalShaderProgramWrapper finalShaderProgramWrapper = this.f42691a;
                        Size size = sizeC;
                        finalShaderProgramWrapper.f42405j.d(size.b(), size.a());
                    }
                });
            }
        }
        Assertions.e(this.f42418w);
        SurfaceInfo surfaceInfo = this.A;
        if (surfaceInfo == null && this.f42410o == null) {
            Assertions.g(this.B == null);
            DefaultShaderProgram defaultShaderProgram = this.f42415t;
            if (defaultShaderProgram != null) {
                defaultShaderProgram.release();
                this.f42415t = null;
            }
            Log.i("FinalShaderWrapper", "Output surface and size not set, dropping frame.");
            return false;
        }
        int iB = surfaceInfo == null ? this.f42418w.b() : surfaceInfo.f41097b;
        SurfaceInfo surfaceInfo2 = this.A;
        int iA = surfaceInfo2 == null ? this.f42418w.a() : surfaceInfo2.f41098c;
        SurfaceInfo surfaceInfo3 = this.A;
        if (surfaceInfo3 != null && this.B == null) {
            this.B = glObjectsProvider.a(this.f42399d, surfaceInfo3.f41096a, this.f42402g.f40556c, surfaceInfo3.f41100e);
        }
        if (this.f42410o != null) {
            this.f42407l.d(glObjectsProvider, iB, iA);
        }
        DefaultShaderProgram defaultShaderProgram2 = this.f42415t;
        if (defaultShaderProgram2 != null && (this.f42421z || z2 || this.f42420y)) {
            defaultShaderProgram2.release();
            this.f42415t = null;
            this.f42421z = false;
            this.f42420y = false;
        }
        if (this.f42415t == null) {
            SurfaceInfo surfaceInfo4 = this.A;
            this.f42415t = u(surfaceInfo4 == null ? 0 : surfaceInfo4.f41099d, iB, iA);
            this.f42421z = false;
        }
        return true;
    }

    private int x() {
        if (this.f42410o == null) {
            return 1;
        }
        return this.f42407l.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j3) throws GlUtil.GlException {
        Assertions.g(this.f42410o != null);
        while (this.f42407l.h() < this.f42407l.a() && this.f42408m.d() <= j3) {
            this.f42407l.f();
            this.f42408m.f();
            GlUtil.B(this.f42409n.f());
            this.f42417v.f();
        }
    }

    private void z(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j3, long j4) {
        GlTextureInfo glTextureInfo2;
        FinalShaderProgramWrapper finalShaderProgramWrapper;
        try {
        } catch (VideoFrameProcessingException e3) {
            e = e3;
        } catch (GlUtil.GlException e4) {
            e = e4;
        }
        if (j4 != -2) {
            try {
            } catch (VideoFrameProcessingException e5) {
                e = e5;
                finalShaderProgramWrapper = this;
                glTextureInfo2 = glTextureInfo;
                final Exception exc = e;
                finalShaderProgramWrapper.f42404i.execute(new Runnable() { // from class: androidx.media3.effect.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42820a.f42405j.a(VideoFrameProcessingException.b(exc, j3));
                    }
                });
            } catch (GlUtil.GlException e6) {
                e = e6;
                finalShaderProgramWrapper = this;
                glTextureInfo2 = glTextureInfo;
                final Exception exc2 = e;
                finalShaderProgramWrapper.f42404i.execute(new Runnable() { // from class: androidx.media3.effect.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42820a.f42405j.a(VideoFrameProcessingException.b(exc2, j3));
                    }
                });
            }
            if (w(glObjectsProvider, glTextureInfo.f40693d, glTextureInfo.f40694e)) {
                if (this.A != null) {
                    finalShaderProgramWrapper = this;
                    glTextureInfo2 = glTextureInfo;
                    finalShaderProgramWrapper.A(glTextureInfo2, j3, j4);
                } else {
                    finalShaderProgramWrapper = this;
                    glTextureInfo2 = glTextureInfo;
                    if (finalShaderProgramWrapper.f42410o != null) {
                        B(glTextureInfo2, j3);
                    }
                }
                finalShaderProgramWrapper.f42417v.e(glTextureInfo2);
                return;
            }
        }
        this.f42417v.e(glTextureInfo);
    }

    public void C(GlObjectsProvider glObjectsProvider, long j3) {
        this.f42403h.m();
        if (this.f42410o != null) {
            return;
        }
        Assertions.g(!this.f42412q);
        Pair pair = (Pair) this.f42406k.remove();
        z(glObjectsProvider, (GlTextureInfo) pair.first, ((Long) pair.second).longValue(), j3);
        if (this.f42406k.isEmpty() && this.f42416u) {
            ((OnInputStreamProcessedListener) Assertions.e(this.f42419x)).a();
            this.f42416u = false;
        }
    }

    public void D(List list, List list2) {
        this.f42403h.m();
        this.f42397b.clear();
        this.f42397b.addAll(list);
        this.f42398c.clear();
        this.f42398c.addAll(list2);
        this.f42420y = true;
    }

    public void E(OnInputStreamProcessedListener onInputStreamProcessedListener) {
        this.f42403h.m();
        this.f42419x = onInputStreamProcessedListener;
    }

    public void F(final SurfaceInfo surfaceInfo) {
        try {
            this.f42403h.g(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.x0
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f42811a.G(surfaceInfo);
                }
            });
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            this.f42404i.execute(new Runnable() { // from class: androidx.media3.effect.y0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42814a.f42405j.a(VideoFrameProcessingException.a(e3));
                }
            });
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void c() {
        this.f42403h.m();
        if (this.f42406k.isEmpty()) {
            ((OnInputStreamProcessedListener) Assertions.e(this.f42419x)).a();
            this.f42416u = false;
        } else {
            Assertions.g(!this.f42412q);
            this.f42416u = true;
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j3) {
        this.f42403h.m();
        this.f42404i.execute(new Runnable() { // from class: androidx.media3.effect.c1
            @Override // java.lang.Runnable
            public final void run() {
                this.f42700a.f42405j.c(j3);
            }
        });
        if (this.f42410o != null) {
            Assertions.g(this.f42407l.h() > 0);
            z(glObjectsProvider, glTextureInfo, j3, 1000 * j3);
        } else {
            if (this.f42412q) {
                z(glObjectsProvider, glTextureInfo, j3, j3 * 1000);
            } else {
                this.f42406k.add(Pair.create(glTextureInfo, Long.valueOf(j3)));
            }
            this.f42417v.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.f42403h.m();
        if (this.f42410o != null) {
            this.f42407l.e();
            this.f42408m.b();
            this.f42409n.b();
        }
        this.f42406k.clear();
        this.f42416u = false;
        DefaultShaderProgram defaultShaderProgram = this.f42415t;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.flush();
        }
        this.f42417v.b();
        for (int i3 = 0; i3 < x(); i3++) {
            this.f42417v.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.effect.GlTextureProducer
    public void j(final long j3) {
        this.f42403h.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.d1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws GlUtil.GlException {
                this.f42703a.y(j3);
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void k(GlShaderProgram.OutputListener outputListener) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void l(GlTextureInfo glTextureInfo) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void m(GlShaderProgram.InputListener inputListener) {
        this.f42403h.m();
        this.f42417v = inputListener;
        for (int i3 = 0; i3 < x(); i3++) {
            inputListener.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.f42403h.m();
        DefaultShaderProgram defaultShaderProgram = this.f42415t;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.release();
        }
        try {
            this.f42407l.c();
            GlUtil.F(this.f42399d, this.B);
            GlUtil.e();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}

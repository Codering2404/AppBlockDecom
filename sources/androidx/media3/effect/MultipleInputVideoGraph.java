package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.SparseArray;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.effect.GlTextureProducer;
import androidx.media3.effect.MultipleInputVideoGraph;
import androidx.media3.effect.VideoCompositor;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MultipleInputVideoGraph implements VideoGraph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorInfo f42471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GlObjectsProvider f42472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DebugViewProvider f42473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final VideoGraph.Listener f42474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f42475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final VideoCompositorSettings f42476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f42477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseArray f42478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ExecutorService f42479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final DefaultVideoFrameProcessor.Factory f42480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Queue f42481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SparseArray f42482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f42483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f42484o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private VideoFrameProcessor f42485p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private VideoCompositor f42486q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f42487r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f42488s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f42489t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f42490u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f42491v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile boolean f42492w;

    /* JADX INFO: renamed from: androidx.media3.effect.MultipleInputVideoGraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements VideoFrameProcessor.Listener {
        AnonymousClass1() {
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void a(VideoFrameProcessingException videoFrameProcessingException) {
            MultipleInputVideoGraph.this.y(videoFrameProcessingException);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void b() {
            MultipleInputVideoGraph.this.f42475f.execute(new Runnable() { // from class: androidx.media3.effect.w1
                @Override // java.lang.Runnable
                public final void run() {
                    MultipleInputVideoGraph.AnonymousClass1 anonymousClass1 = this.f42808a;
                    MultipleInputVideoGraph.this.f42474e.k(MultipleInputVideoGraph.this.f42491v);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void c(final long j3) {
            if (j3 == 0) {
                MultipleInputVideoGraph.this.f42492w = true;
            }
            MultipleInputVideoGraph.this.f42491v = j3;
            MultipleInputVideoGraph.this.f42475f.execute(new Runnable() { // from class: androidx.media3.effect.v1
                @Override // java.lang.Runnable
                public final void run() {
                    MultipleInputVideoGraph.this.f42474e.c(j3);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void d(final int i3, final int i4) {
            MultipleInputVideoGraph.this.f42475f.execute(new Runnable() { // from class: androidx.media3.effect.u1
                @Override // java.lang.Runnable
                public final void run() {
                    MultipleInputVideoGraph.this.f42474e.d(i3, i4);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void e(final float f3) {
            MultipleInputVideoGraph.this.f42475f.execute(new Runnable() { // from class: androidx.media3.effect.t1
                @Override // java.lang.Runnable
                public final void run() {
                    MultipleInputVideoGraph.this.f42474e.e(f3);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void f(int i3, Format format, List list) {
            MultipleInputVideoGraph.this.f42488s = true;
            MultipleInputVideoGraph.this.D();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CompositorOutputTextureInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GlTextureInfo f42497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f42498b;

        /* synthetic */ CompositorOutputTextureInfo(GlTextureInfo glTextureInfo, long j3, AnonymousClass1 anonymousClass1) {
            this(glTextureInfo, j3);
        }

        private CompositorOutputTextureInfo(GlTextureInfo glTextureInfo, long j3) {
            this.f42497a = glTextureInfo;
            this.f42498b = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CompositorOutputTextureRelease {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GlTextureProducer f42499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f42500b;

        public CompositorOutputTextureRelease(GlTextureProducer glTextureProducer, long j3) {
            this.f42499a = glTextureProducer;
            this.f42500b = j3;
        }

        public void a() {
            this.f42499a.j(this.f42500b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SingleContextGlObjectsProvider implements GlObjectsProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GlObjectsProvider f42501a = new DefaultGlObjectsProvider();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private EGLContext f42502b;

        @Override // androidx.media3.common.GlObjectsProvider
        public EGLSurface a(EGLDisplay eGLDisplay, Object obj, int i3, boolean z2) {
            return this.f42501a.a(eGLDisplay, obj, i3, z2);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public GlTextureInfo b(int i3, int i4, int i5) {
            return this.f42501a.b(i3, i4, i5);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public EGLSurface c(EGLContext eGLContext, EGLDisplay eGLDisplay) {
            return this.f42501a.c(eGLContext, eGLDisplay);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public EGLContext d(EGLDisplay eGLDisplay, int i3, int[] iArr) {
            if (this.f42502b == null) {
                this.f42502b = this.f42501a.d(eGLDisplay, i3, iArr);
            }
            return this.f42502b;
        }

        @Override // androidx.media3.common.GlObjectsProvider
        public void e(EGLDisplay eGLDisplay) throws GlUtil.GlException {
            EGLContext eGLContext = this.f42502b;
            if (eGLContext != null) {
                GlUtil.E(eGLDisplay, eGLContext);
            }
        }
    }

    protected MultipleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List list, long j3, boolean z2) {
        Assertions.a(factory instanceof DefaultVideoFrameProcessor.Factory);
        this.f42470a = context;
        this.f42471b = colorInfo;
        this.f42473d = debugViewProvider;
        this.f42474e = listener;
        this.f42475f = executor;
        this.f42476g = videoCompositorSettings;
        this.f42477h = new ArrayList(list);
        this.f42483n = j3;
        this.f42484o = z2;
        this.f42491v = -9223372036854775807L;
        this.f42478i = new SparseArray();
        ScheduledExecutorService scheduledExecutorServiceR0 = Util.R0("Effect:MultipleInputVideoGraph:Thread");
        this.f42479j = scheduledExecutorServiceR0;
        SingleContextGlObjectsProvider singleContextGlObjectsProvider = new SingleContextGlObjectsProvider();
        this.f42472c = singleContextGlObjectsProvider;
        this.f42480k = ((DefaultVideoFrameProcessor.Factory) factory).k().b(singleContextGlObjectsProvider).a(scheduledExecutorServiceR0).build();
        this.f42481l = new ArrayDeque();
        this.f42482m = new SparseArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3) {
        ((VideoCompositor) Assertions.e(this.f42486q)).f(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.f42489t = true;
        if (this.f42481l.isEmpty()) {
            ((VideoFrameProcessor) Assertions.e(this.f42485p)).d();
        } else {
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j3, long j4) {
        Assertions.i(this.f42485p);
        Assertions.g(!this.f42489t);
        DebugTraceUtil.e("Compositor", "OutputTextureRendered", j3);
        this.f42481l.add(new CompositorOutputTextureInfo(glTextureInfo, j3, null));
        this.f42482m.put(glTextureInfo.f40690a, new CompositorOutputTextureRelease(glTextureProducer, j3));
        if (this.f42487r) {
            D();
        } else {
            ((VideoFrameProcessor) Assertions.e(this.f42485p)).j(3, new Format.Builder().T(this.f42471b).B0(glTextureInfo.f40693d).d0(glTextureInfo.f40694e).N(), this.f42477h, 0L);
            this.f42487r = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        CompositorOutputTextureInfo compositorOutputTextureInfo;
        Assertions.i(this.f42485p);
        if (this.f42488s && (compositorOutputTextureInfo = (CompositorOutputTextureInfo) this.f42481l.peek()) != null) {
            Assertions.g(((VideoFrameProcessor) Assertions.e(this.f42485p)).h(compositorOutputTextureInfo.f42497a.f40690a, compositorOutputTextureInfo.f42498b));
            this.f42481l.remove();
            if (this.f42489t && this.f42481l.isEmpty()) {
                ((VideoFrameProcessor) Assertions.e(this.f42485p)).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j3) {
        DebugTraceUtil.e("VideoFrameProcessor", "OutputTextureRendered", j3);
        ((VideoCompositor) Assertions.e(this.f42486q)).b(i3, glTextureProducer, glTextureInfo, this.f42471b, j3);
    }

    public static /* synthetic */ void d(MultipleInputVideoGraph multipleInputVideoGraph) {
        multipleInputVideoGraph.getClass();
        try {
            multipleInputVideoGraph.f42472c.e(GlUtil.M());
        } catch (Exception e3) {
            Log.e("MultiInputVG", "Error releasing GlObjectsProvider", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final Exception exc) {
        this.f42475f.execute(new Runnable() { // from class: androidx.media3.effect.p1
            @Override // java.lang.Runnable
            public final void run() {
                MultipleInputVideoGraph multipleInputVideoGraph = this.f42778a;
                Exception exc2 = exc;
                multipleInputVideoGraph.f42474e.a(exc2 instanceof VideoFrameProcessingException ? (VideoFrameProcessingException) exc2 : VideoFrameProcessingException.a(exc2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i3, long j3) {
        Assertions.g(Util.t(this.f42482m, i3));
        ((CompositorOutputTextureRelease) this.f42482m.get(i3)).a();
        this.f42482m.remove(i3);
        D();
    }

    @Override // androidx.media3.common.VideoGraph
    public void f(SurfaceInfo surfaceInfo) {
        ((VideoFrameProcessor) Assertions.e(this.f42485p)).f(surfaceInfo);
    }

    @Override // androidx.media3.common.VideoGraph
    public VideoFrameProcessor h(int i3) {
        Assertions.g(Util.t(this.f42478i, i3));
        return (VideoFrameProcessor) this.f42478i.get(i3);
    }

    @Override // androidx.media3.common.VideoGraph
    public void initialize() throws VideoFrameProcessingException {
        Assertions.g(this.f42478i.size() == 0 && this.f42486q == null && this.f42485p == null && !this.f42490u);
        DefaultVideoFrameProcessor defaultVideoFrameProcessorA = this.f42480k.a(this.f42470a, this.f42473d, this.f42471b, this.f42484o, MoreExecutors.a(), new AnonymousClass1());
        this.f42485p = defaultVideoFrameProcessorA;
        defaultVideoFrameProcessorA.i(new OnInputFrameProcessedListener() { // from class: androidx.media3.effect.q1
            @Override // androidx.media3.common.OnInputFrameProcessedListener
            public final void a(int i3, long j3) {
                this.f42781a.z(i3, j3);
            }
        });
        this.f42486q = new DefaultVideoCompositor(this.f42470a, this.f42472c, this.f42476g, this.f42479j, new VideoCompositor.Listener() { // from class: androidx.media3.effect.MultipleInputVideoGraph.2
            @Override // androidx.media3.effect.VideoCompositor.Listener
            public void a(VideoFrameProcessingException videoFrameProcessingException) {
                MultipleInputVideoGraph.this.y(videoFrameProcessingException);
            }

            @Override // androidx.media3.effect.VideoCompositor.Listener
            public void b() {
                MultipleInputVideoGraph.this.B();
            }
        }, new GlTextureProducer.Listener() { // from class: androidx.media3.effect.r1
            @Override // androidx.media3.effect.GlTextureProducer.Listener
            public final void a(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j3, long j4) {
                this.f42785a.C(glTextureProducer, glTextureInfo, j3, j4);
            }
        }, 1);
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean j() {
        return this.f42492w;
    }

    @Override // androidx.media3.common.VideoGraph
    public void l(final int i3) throws VideoFrameProcessingException {
        Assertions.g(!Util.t(this.f42478i, i3));
        ((VideoCompositor) Assertions.e(this.f42486q)).e(i3);
        this.f42478i.put(i3, this.f42480k.k().c(new GlTextureProducer.Listener() { // from class: androidx.media3.effect.s1
            @Override // androidx.media3.effect.GlTextureProducer.Listener
            public final void a(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j3, long j4) {
                this.f42790a.E(i3, glTextureProducer, glTextureInfo, j3);
            }
        }, 2).build().a(this.f42470a, DebugViewProvider.f40567a, this.f42471b, true, this.f42475f, new VideoFrameProcessor.Listener() { // from class: androidx.media3.effect.MultipleInputVideoGraph.3
            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public void a(VideoFrameProcessingException videoFrameProcessingException) {
                MultipleInputVideoGraph.this.y(videoFrameProcessingException);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public void b() {
                MultipleInputVideoGraph.this.A(i3);
            }
        }));
    }

    @Override // androidx.media3.common.VideoGraph
    public void release() {
        if (this.f42490u) {
            return;
        }
        for (int i3 = 0; i3 < this.f42478i.size(); i3++) {
            SparseArray sparseArray = this.f42478i;
            ((VideoFrameProcessor) sparseArray.get(sparseArray.keyAt(i3))).release();
        }
        this.f42478i.clear();
        VideoCompositor videoCompositor = this.f42486q;
        if (videoCompositor != null) {
            videoCompositor.release();
            this.f42486q = null;
        }
        VideoFrameProcessor videoFrameProcessor = this.f42485p;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.release();
            this.f42485p = null;
        }
        this.f42479j.submit(new Runnable() { // from class: androidx.media3.effect.o1
            @Override // java.lang.Runnable
            public final void run() {
                MultipleInputVideoGraph.d(this.f42770a);
            }
        });
        this.f42479j.shutdown();
        try {
            this.f42479j.awaitTermination(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Log.d("MultiInputVG", "Thread interrupted while waiting for executor service termination");
        }
        this.f42490u = true;
    }

    protected VideoFrameProcessor w() {
        return (VideoFrameProcessor) Assertions.i(this.f42485p);
    }

    protected long x() {
        return this.f42483n;
    }
}

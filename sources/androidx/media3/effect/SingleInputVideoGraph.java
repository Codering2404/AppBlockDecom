package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.Assertions;
import androidx.media3.effect.SingleInputVideoGraph;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SingleInputVideoGraph implements VideoGraph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VideoFrameProcessor.Factory f42601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorInfo f42602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoGraph.Listener f42603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DebugViewProvider f42604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f42605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f42606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f42607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private VideoFrameProcessor f42608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SurfaceInfo f42609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f42610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f42611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42612m;

    /* JADX INFO: renamed from: androidx.media3.effect.SingleInputVideoGraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements VideoFrameProcessor.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f42613a;

        AnonymousClass1() {
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void a(final VideoFrameProcessingException videoFrameProcessingException) {
            SingleInputVideoGraph.this.f42605f.execute(new Runnable() { // from class: androidx.media3.effect.d2
                @Override // java.lang.Runnable
                public final void run() {
                    SingleInputVideoGraph.this.f42603d.a(videoFrameProcessingException);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void b() {
            SingleInputVideoGraph.this.f42605f.execute(new Runnable() { // from class: androidx.media3.effect.h2
                @Override // java.lang.Runnable
                public final void run() {
                    SingleInputVideoGraph.AnonymousClass1 anonymousClass1 = this.f42731a;
                    SingleInputVideoGraph.this.f42603d.k(anonymousClass1.f42613a);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void c(final long j3) {
            if (j3 == 0) {
                SingleInputVideoGraph.this.f42611l = true;
            }
            this.f42613a = j3;
            SingleInputVideoGraph.this.f42605f.execute(new Runnable() { // from class: androidx.media3.effect.f2
                @Override // java.lang.Runnable
                public final void run() {
                    SingleInputVideoGraph.this.f42603d.c(j3);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void d(final int i3, final int i4) {
            SingleInputVideoGraph.this.f42605f.execute(new Runnable() { // from class: androidx.media3.effect.g2
                @Override // java.lang.Runnable
                public final void run() {
                    SingleInputVideoGraph.this.f42603d.d(i3, i4);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void e(final float f3) {
            SingleInputVideoGraph.this.f42605f.execute(new Runnable() { // from class: androidx.media3.effect.e2
                @Override // java.lang.Runnable
                public final void run() {
                    SingleInputVideoGraph.this.f42603d.e(f3);
                }
            });
        }
    }

    public SingleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, VideoGraph.Listener listener, DebugViewProvider debugViewProvider, Executor executor, VideoCompositorSettings videoCompositorSettings, boolean z2, long j3) {
        Assertions.h(VideoCompositorSettings.f41251a.equals(videoCompositorSettings), "SingleInputVideoGraph does not use VideoCompositor, and therefore cannot apply VideoCompositorSettings");
        this.f42600a = context;
        this.f42601b = factory;
        this.f42602c = colorInfo;
        this.f42603d = listener;
        this.f42604e = debugViewProvider;
        this.f42605f = executor;
        this.f42606g = z2;
        this.f42607h = j3;
        this.f42612m = -1;
    }

    protected long e() {
        return this.f42607h;
    }

    @Override // androidx.media3.common.VideoGraph
    public void f(SurfaceInfo surfaceInfo) {
        this.f42609j = surfaceInfo;
        VideoFrameProcessor videoFrameProcessor = this.f42608i;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.f(surfaceInfo);
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public VideoFrameProcessor h(int i3) {
        int i4 = this.f42612m;
        Assertions.a(i4 != -1 && i4 == i3);
        return (VideoFrameProcessor) Assertions.i(this.f42608i);
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean j() {
        return this.f42611l;
    }

    protected int k() {
        return this.f42612m;
    }

    @Override // androidx.media3.common.VideoGraph
    public void l(int i3) {
        Assertions.i(Boolean.valueOf(this.f42608i == null && !this.f42610k));
        Assertions.h(this.f42612m == -1, "This VideoGraph supports only one input.");
        this.f42612m = i3;
        VideoFrameProcessor videoFrameProcessorA = this.f42601b.a(this.f42600a, this.f42604e, this.f42602c, this.f42606g, MoreExecutors.a(), new AnonymousClass1());
        this.f42608i = videoFrameProcessorA;
        SurfaceInfo surfaceInfo = this.f42609j;
        if (surfaceInfo != null) {
            videoFrameProcessorA.f(surfaceInfo);
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public void release() {
        if (this.f42610k) {
            return;
        }
        VideoFrameProcessor videoFrameProcessor = this.f42608i;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.release();
            this.f42608i = null;
        }
        this.f42610k = true;
    }

    @Override // androidx.media3.common.VideoGraph
    public void initialize() {
    }
}

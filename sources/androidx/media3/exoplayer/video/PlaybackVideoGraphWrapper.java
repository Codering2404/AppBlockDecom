package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.effect.PreviewingSingleInputVideoGraph;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import androidx.media3.exoplayer.video.VideoSink;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaybackVideoGraphWrapper implements VideoSinkProvider, VideoGraph.Listener {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Executor f45758z = new Executor() { // from class: androidx.media3.exoplayer.video.h
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            PlaybackVideoGraphWrapper.b(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f45759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimedValueQueue f45760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PreviewingVideoGraph.Factory f45761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray f45762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f45763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final VideoCompositorSettings f45764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final VideoSink f45765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final VideoSink.VideoFrameHandler f45766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Clock f45767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArraySet f45768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f45769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Format f45770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private HandlerWrapper f45771m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private PreviewingVideoGraph f45772n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f45773o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Pair f45774p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f45775q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f45776r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Renderer.WakeupListener f45777s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f45778t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f45779u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f45780v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f45781w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f45782x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f45783y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f45785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final VideoFrameReleaseControl f45786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private VideoFrameProcessor.Factory f45787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private PreviewingVideoGraph.Factory f45788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List f45789e = ImmutableList.y();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private VideoCompositorSettings f45790f = VideoCompositorSettings.f41251a;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Clock f45791g = Clock.f41485a;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f45792h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f45793i;

        public Builder(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
            this.f45785a = context.getApplicationContext();
            this.f45786b = videoFrameReleaseControl;
        }

        public PlaybackVideoGraphWrapper h() {
            Assertions.g(!this.f45793i);
            if (this.f45788d == null) {
                if (this.f45787c == null) {
                    this.f45787c = new ReflectiveDefaultVideoFrameProcessorFactory();
                }
                this.f45788d = new ReflectivePreviewingSingleInputVideoGraphFactory(this.f45787c);
            }
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = new PlaybackVideoGraphWrapper(this);
            this.f45793i = true;
            return playbackVideoGraphWrapper;
        }

        public Builder i(Clock clock) {
            this.f45791g = clock;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class DefaultVideoSinkListener implements VideoSink.Listener {
        private DefaultVideoSinkListener() {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void a(VideoSink videoSink) {
            Iterator it = PlaybackVideoGraphWrapper.this.f45768j.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).b0(PlaybackVideoGraphWrapper.this);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void b(VideoSink videoSink, VideoSize videoSize) {
            Iterator it = PlaybackVideoGraphWrapper.this.f45768j.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).z(PlaybackVideoGraphWrapper.this, videoSize);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void c(VideoSink videoSink, VideoSink.VideoSinkException videoSinkException) {
            Iterator it = PlaybackVideoGraphWrapper.this.f45768j.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).w(PlaybackVideoGraphWrapper.this, VideoFrameProcessingException.a(videoSinkException));
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.Listener
        public void d(VideoSink videoSink) {
            Iterator it = PlaybackVideoGraphWrapper.this.f45768j.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).e0(PlaybackVideoGraphWrapper.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class InputVideoSink implements VideoSink, Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f45796b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private VideoFrameProcessor f45798d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Format f45799f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f45800g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f45801h;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f45805l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImmutableList f45797c = ImmutableList.y();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f45802i = -9223372036854775807L;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private VideoSink.Listener f45803j = VideoSink.Listener.f45879a;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Executor f45804k = PlaybackVideoGraphWrapper.f45758z;

        public InputVideoSink(Context context, int i3) {
            this.f45796b = i3;
            this.f45795a = Util.e0(context);
        }

        public static /* synthetic */ void C(InputVideoSink inputVideoSink, VideoSink.Listener listener, VideoFrameProcessingException videoFrameProcessingException) {
            inputVideoSink.getClass();
            listener.c(inputVideoSink, new VideoSink.VideoSinkException(videoFrameProcessingException, (Format) Assertions.i(inputVideoSink.f45799f)));
        }

        public static /* synthetic */ void D(InputVideoSink inputVideoSink, VideoSink.Listener listener, VideoSize videoSize) {
            inputVideoSink.getClass();
            listener.b(inputVideoSink, videoSize);
        }

        public static /* synthetic */ void E(InputVideoSink inputVideoSink, VideoSink.Listener listener) {
            inputVideoSink.getClass();
            listener.d((VideoSink) Assertions.i(inputVideoSink));
        }

        public static /* synthetic */ void F(InputVideoSink inputVideoSink, VideoSink.Listener listener) {
            inputVideoSink.getClass();
            listener.a(inputVideoSink);
        }

        private void G(Format format) {
            ((VideoFrameProcessor) Assertions.i(this.f45798d)).j(this.f45800g, format.b().T(PlaybackVideoGraphWrapper.G(format.C)).N(), this.f45797c, 0L);
        }

        private void H(List list) {
            if (PlaybackVideoGraphWrapper.this.f45761c.a()) {
                this.f45797c = ImmutableList.t(list);
            } else {
                this.f45797c = new ImmutableList.Builder().k(list).k(PlaybackVideoGraphWrapper.this.f45763e).m();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void A(boolean z2) {
            PlaybackVideoGraphWrapper.this.f45765g.A(z2);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void B(VideoSink.Listener listener, Executor executor) {
            this.f45803j = listener;
            this.f45804k = executor;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public Surface a() {
            Assertions.g(isInitialized());
            return ((VideoFrameProcessor) Assertions.i(this.f45798d)).a();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean b() {
            return isInitialized() && PlaybackVideoGraphWrapper.this.I();
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void b0(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
            final VideoSink.Listener listener = this.f45803j;
            this.f45804k.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.j
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.F(this.f45890a, listener);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void c() {
            PlaybackVideoGraphWrapper.this.f45779u = this.f45802i;
            if (PlaybackVideoGraphWrapper.this.f45778t >= PlaybackVideoGraphWrapper.this.f45779u) {
                PlaybackVideoGraphWrapper.this.f45765g.c();
                PlaybackVideoGraphWrapper.this.f45780v = true;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void d() {
            if (!this.f45805l && isInitialized()) {
                this.f45798d.d();
                this.f45805l = true;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean e(long j3, boolean z2, VideoSink.VideoFrameHandler videoFrameHandler) {
            Assertions.g(isInitialized());
            if (!PlaybackVideoGraphWrapper.this.U() || ((VideoFrameProcessor) Assertions.i(this.f45798d)).l() >= this.f45795a || !((VideoFrameProcessor) Assertions.i(this.f45798d)).k()) {
                return false;
            }
            this.f45802i = j3 - this.f45801h;
            videoFrameHandler.a(j3 * 1000);
            return true;
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void e0(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
            final VideoSink.Listener listener = this.f45803j;
            this.f45804k.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.k
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.E(this.f45892a, listener);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void f() {
            PlaybackVideoGraphWrapper.this.f45765g.f();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void g(VideoFrameMetadataListener videoFrameMetadataListener) {
            PlaybackVideoGraphWrapper.this.T(videoFrameMetadataListener);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void h(long j3, long j4) {
            PlaybackVideoGraphWrapper.this.O(j3, j4);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void i(long j3, long j4) {
            TimedValueQueue timedValueQueue = PlaybackVideoGraphWrapper.this.f45760b;
            long j5 = this.f45802i;
            timedValueQueue.a(j5 == -9223372036854775807L ? 0L : j5 + 1, Long.valueOf(j3));
            this.f45801h = j4;
            PlaybackVideoGraphWrapper.this.P(j4);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isInitialized() {
            return this.f45798d != null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void j() {
            PlaybackVideoGraphWrapper.this.f45765g.j();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void k(Renderer.WakeupListener wakeupListener) {
            PlaybackVideoGraphWrapper.this.f45777s = wakeupListener;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void l(List list) {
            if (this.f45797c.equals(list)) {
                return;
            }
            H(list);
            Format format = this.f45799f;
            if (format != null) {
                G(format);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean m(boolean z2) {
            return PlaybackVideoGraphWrapper.this.K(z2 && isInitialized());
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean n(Format format) throws VideoSink.VideoSinkException {
            Assertions.g(!isInitialized());
            VideoFrameProcessor videoFrameProcessorM = PlaybackVideoGraphWrapper.this.M(format, this.f45796b);
            this.f45798d = videoFrameProcessorM;
            return videoFrameProcessorM != null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void o(boolean z2) {
            PlaybackVideoGraphWrapper.this.f45765g.o(z2);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void p() {
            PlaybackVideoGraphWrapper.this.f45765g.p();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void q(int i3, Format format, List list) {
            Assertions.g(isInitialized());
            if (i3 != 1 && i3 != 2) {
                throw new UnsupportedOperationException("Unsupported input type " + i3);
            }
            H(list);
            this.f45800g = i3;
            this.f45799f = format;
            PlaybackVideoGraphWrapper.this.f45779u = -9223372036854775807L;
            PlaybackVideoGraphWrapper.this.f45780v = false;
            G(format);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void r(Surface surface, Size size) {
            PlaybackVideoGraphWrapper.this.Q(surface, size);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void release() {
            PlaybackVideoGraphWrapper.this.N();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void s() {
            PlaybackVideoGraphWrapper.this.f45765g.s();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void t(int i3) {
            PlaybackVideoGraphWrapper.this.f45765g.t(i3);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void u(float f3) {
            PlaybackVideoGraphWrapper.this.R(f3);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void v() {
            PlaybackVideoGraphWrapper.this.E();
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void w(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, final VideoFrameProcessingException videoFrameProcessingException) {
            final VideoSink.Listener listener = this.f45803j;
            this.f45804k.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.l
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.C(this.f45894a, listener, videoFrameProcessingException);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void x(boolean z2) {
            if (isInitialized()) {
                this.f45798d.flush();
            }
            this.f45802i = -9223372036854775807L;
            PlaybackVideoGraphWrapper.this.F(z2);
            this.f45805l = false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean y(Bitmap bitmap, TimestampIterator timestampIterator) {
            Assertions.g(isInitialized());
            if (!PlaybackVideoGraphWrapper.this.U() || !((VideoFrameProcessor) Assertions.e(this.f45798d)).g(bitmap, timestampIterator)) {
                return false;
            }
            long jA = timestampIterator.a() - this.f45801h;
            Assertions.g(jA != -9223372036854775807L);
            this.f45802i = jA;
            return true;
        }

        @Override // androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.Listener
        public void z(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, final VideoSize videoSize) {
            final VideoSink.Listener listener = this.f45803j;
            this.f45804k.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.i
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.InputVideoSink.D(this.f45887a, listener, videoSize);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void b0(PlaybackVideoGraphWrapper playbackVideoGraphWrapper);

        void e0(PlaybackVideoGraphWrapper playbackVideoGraphWrapper);

        void w(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoFrameProcessingException videoFrameProcessingException);

        void z(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoSize videoSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Supplier f45807a = Suppliers.a(new Supplier() { // from class: androidx.media3.exoplayer.video.m
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return PlaybackVideoGraphWrapper.ReflectiveDefaultVideoFrameProcessorFactory.b();
            }
        });

        private ReflectiveDefaultVideoFrameProcessorFactory() {
        }

        public static /* synthetic */ VideoFrameProcessor.Factory b() {
            try {
                return (VideoFrameProcessor.Factory) Assertions.e(DefaultVideoFrameProcessor.Factory.Builder.class.getMethod(InAppPurchaseConstants.METHOD_BUILD, null).invoke(DefaultVideoFrameProcessor.Factory.Builder.class.getConstructor(null).newInstance(null), null));
            } catch (Exception e3) {
                throw new IllegalStateException(e3);
            }
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Factory
        public VideoFrameProcessor a(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z2, Executor executor, VideoFrameProcessor.Listener listener) {
            return ((VideoFrameProcessor.Factory) f45807a.get()).a(context, debugViewProvider, colorInfo, z2, executor, listener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final VideoFrameProcessor.Factory f45808a;

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.f45808a = factory;
        }

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public boolean a() {
            return false;
        }

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public PreviewingVideoGraph b(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List list, long j3) throws VideoFrameProcessingException {
            try {
                return ((PreviewingVideoGraph.Factory) PreviewingSingleInputVideoGraph.Factory.class.getConstructor(VideoFrameProcessor.Factory.class).newInstance(this.f45808a)).b(context, colorInfo, debugViewProvider, listener, executor, videoCompositorSettings, list, j3);
            } catch (Exception e3) {
                throw VideoFrameProcessingException.a(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z2) {
        if (J()) {
            this.f45775q++;
            this.f45765g.x(z2);
            while (this.f45760b.l() > 1) {
                this.f45760b.i();
            }
            if (this.f45760b.l() == 1) {
                this.f45765g.i(((Long) Assertions.e((Long) this.f45760b.i())).longValue(), this.f45781w);
            }
            this.f45778t = -9223372036854775807L;
            this.f45779u = -9223372036854775807L;
            this.f45780v = false;
            ((HandlerWrapper) Assertions.i(this.f45771m)).j(new Runnable() { // from class: androidx.media3.exoplayer.video.g
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackVideoGraphWrapper.f(this.f45886a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ColorInfo G(ColorInfo colorInfo) {
        return (colorInfo == null || !colorInfo.j()) ? ColorInfo.f40546h : colorInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I() {
        return this.f45775q == 0 && this.f45780v && this.f45765g.b();
    }

    private boolean J() {
        return this.f45776r == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K(boolean z2) {
        return this.f45765g.m(z2 && this.f45775q == 0);
    }

    private void L(Surface surface, int i3, int i4) {
        PreviewingVideoGraph previewingVideoGraph = this.f45772n;
        if (previewingVideoGraph == null) {
            return;
        }
        if (surface != null) {
            previewingVideoGraph.f(new SurfaceInfo(surface, i3, i4));
            this.f45765g.r(surface, new Size(i3, i4));
        } else {
            previewingVideoGraph.f(null);
            this.f45765g.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoFrameProcessor M(Format format, int i3) throws VideoSink.VideoSinkException {
        PlaybackVideoGraphWrapper playbackVideoGraphWrapper;
        if (i3 == 0) {
            Assertions.g(this.f45776r == 0);
            ColorInfo colorInfoG = G(format.C);
            if (this.f45769k) {
                colorInfoG = ColorInfo.f40546h;
            } else if (colorInfoG.f40556c == 7 && Util.f41609a < 34) {
                colorInfoG = colorInfoG.a().e(6).a();
            }
            ColorInfo colorInfo = colorInfoG;
            HandlerWrapper handlerWrapperD = this.f45767i.d((Looper) Assertions.i(Looper.myLooper()), null);
            this.f45771m = handlerWrapperD;
            try {
                PreviewingVideoGraph.Factory factory = this.f45761c;
                Context context = this.f45759a;
                DebugViewProvider debugViewProvider = DebugViewProvider.f40567a;
                Objects.requireNonNull(handlerWrapperD);
                playbackVideoGraphWrapper = this;
                try {
                    PreviewingVideoGraph previewingVideoGraphB = factory.b(context, colorInfo, debugViewProvider, playbackVideoGraphWrapper, new f(handlerWrapperD), this.f45764f, this.f45763e, 0L);
                    playbackVideoGraphWrapper.f45772n = previewingVideoGraphB;
                    previewingVideoGraphB.initialize();
                    Pair pair = playbackVideoGraphWrapper.f45774p;
                    if (pair != null) {
                        Surface surface = (Surface) pair.first;
                        Size size = (Size) pair.second;
                        L(surface, size.b(), size.a());
                    }
                    playbackVideoGraphWrapper.f45765g.n(format);
                    playbackVideoGraphWrapper.f45776r = 1;
                } catch (VideoFrameProcessingException e3) {
                    e = e3;
                    throw new VideoSink.VideoSinkException(e, format);
                }
            } catch (VideoFrameProcessingException e4) {
                e = e4;
            }
        } else {
            playbackVideoGraphWrapper = this;
            if (!J()) {
                return null;
            }
        }
        try {
            ((PreviewingVideoGraph) Assertions.e(playbackVideoGraphWrapper.f45772n)).l(i3);
            playbackVideoGraphWrapper.f45783y++;
            VideoSink videoSink = playbackVideoGraphWrapper.f45765g;
            DefaultVideoSinkListener defaultVideoSinkListener = new DefaultVideoSinkListener();
            HandlerWrapper handlerWrapper = (HandlerWrapper) Assertions.e(playbackVideoGraphWrapper.f45771m);
            Objects.requireNonNull(handlerWrapper);
            videoSink.B(defaultVideoSinkListener, new f(handlerWrapper));
            return playbackVideoGraphWrapper.f45772n.h(i3);
        } catch (VideoFrameProcessingException e5) {
            throw new VideoSink.VideoSinkException(e5, format);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(long j3, long j4) {
        this.f45765g.h(j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(long j3) {
        this.f45781w = j3;
        this.f45765g.i(this.f45773o, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(float f3) {
        this.f45765g.u(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.f45765g.g(videoFrameMetadataListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        int i3 = this.f45782x;
        return i3 != -1 && i3 == this.f45783y;
    }

    public static /* synthetic */ void f(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
        playbackVideoGraphWrapper.f45775q--;
    }

    public void D(Listener listener) {
        this.f45768j.add(listener);
    }

    public void E() {
        Size size = Size.f41593c;
        L(null, size.b(), size.a());
        this.f45774p = null;
    }

    public VideoSink H(int i3) {
        Assertions.g(!Util.t(this.f45762d, i3));
        InputVideoSink inputVideoSink = new InputVideoSink(this.f45759a, i3);
        D(inputVideoSink);
        this.f45762d.put(i3, inputVideoSink);
        return inputVideoSink;
    }

    public void N() {
        if (this.f45776r == 2) {
            return;
        }
        HandlerWrapper handlerWrapper = this.f45771m;
        if (handlerWrapper != null) {
            handlerWrapper.f(null);
        }
        PreviewingVideoGraph previewingVideoGraph = this.f45772n;
        if (previewingVideoGraph != null) {
            previewingVideoGraph.release();
        }
        this.f45774p = null;
        this.f45776r = 2;
    }

    public void Q(Surface surface, Size size) {
        Pair pair = this.f45774p;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) this.f45774p.second).equals(size)) {
            return;
        }
        this.f45774p = Pair.create(surface, size);
        L(surface, size.b(), size.a());
    }

    public void S(int i3) {
        this.f45782x = i3;
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void a(VideoFrameProcessingException videoFrameProcessingException) {
        Iterator it = this.f45768j.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).w(this, videoFrameProcessingException);
        }
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void c(long j3) {
        if (this.f45775q > 0) {
            return;
        }
        Renderer.WakeupListener wakeupListener = this.f45777s;
        if (wakeupListener != null) {
            wakeupListener.b();
        }
        long j4 = j3 - this.f45781w;
        this.f45778t = j4;
        Long l3 = (Long) this.f45760b.j(j4);
        if (l3 != null && l3.longValue() != this.f45773o) {
            this.f45765g.i(l3.longValue(), this.f45781w);
            this.f45773o = l3.longValue();
        }
        long j5 = this.f45779u;
        boolean z2 = j5 != -9223372036854775807L && j4 >= j5;
        this.f45765g.e(j3, z2, this.f45766h);
        if (z2) {
            this.f45765g.c();
            this.f45780v = true;
        }
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void d(int i3, int i4) {
        Format formatN = this.f45770l.b().B0(i3).d0(i4).N();
        this.f45770l = formatN;
        this.f45765g.q(1, formatN, ImmutableList.y());
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void e(float f3) {
        Format formatN = this.f45770l.b().b0(f3).N();
        this.f45770l = formatN;
        this.f45765g.q(1, formatN, ImmutableList.y());
    }

    private PlaybackVideoGraphWrapper(Builder builder) {
        this.f45759a = builder.f45785a;
        this.f45760b = new TimedValueQueue();
        this.f45761c = (PreviewingVideoGraph.Factory) Assertions.i(builder.f45788d);
        this.f45762d = new SparseArray();
        this.f45763e = builder.f45789e;
        this.f45764f = builder.f45790f;
        Clock clock = builder.f45791g;
        this.f45767i = clock;
        this.f45765g = new DefaultVideoSink(builder.f45786b, clock);
        this.f45766h = new VideoSink.VideoFrameHandler() { // from class: androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.1
            @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
            public void a(long j3) {
                ((PreviewingVideoGraph) Assertions.i(PlaybackVideoGraphWrapper.this.f45772n)).b(j3);
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
            public void b() {
                ((PreviewingVideoGraph) Assertions.i(PlaybackVideoGraphWrapper.this.f45772n)).b(-2L);
            }
        };
        this.f45768j = new CopyOnWriteArraySet();
        this.f45769k = builder.f45792h;
        this.f45770l = new Format.Builder().N();
        this.f45778t = -9223372036854775807L;
        this.f45779u = -9223372036854775807L;
        this.f45782x = -1;
        this.f45776r = 0;
    }

    public static /* synthetic */ void b(Runnable runnable) {
    }

    @Override // androidx.media3.common.VideoGraph.Listener
    public void k(long j3) {
    }
}

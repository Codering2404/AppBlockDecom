package androidx.media3.exoplayer.video;

import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.video.DefaultVideoSink;
import androidx.media3.exoplayer.video.VideoFrameRenderControl;
import androidx.media3.exoplayer.video.VideoSink;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DefaultVideoSink implements VideoSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VideoFrameReleaseControl f45672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f45673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VideoFrameRenderControl f45674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f45675d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Surface f45676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Format f45677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f45678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f45679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VideoSink.Listener f45680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Executor f45681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VideoFrameMetadataListener f45682l;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class FrameRendererImpl implements VideoFrameRenderControl.FrameRenderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Format f45683a;

        private FrameRendererImpl() {
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
        public void a() {
            DefaultVideoSink.this.f45681k.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.d
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultVideoSink.FrameRendererImpl frameRendererImpl = this.f45882a;
                    DefaultVideoSink.this.f45680j.d(DefaultVideoSink.this);
                }
            });
            ((VideoSink.VideoFrameHandler) DefaultVideoSink.this.f45675d.remove()).b();
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
        public void b(final VideoSize videoSize) {
            this.f45683a = new Format.Builder().B0(videoSize.f41258a).d0(videoSize.f41259b).u0("video/raw").N();
            DefaultVideoSink.this.f45681k.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.e
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultVideoSink.FrameRendererImpl frameRendererImpl = this.f45883a;
                    DefaultVideoSink.this.f45680j.b(DefaultVideoSink.this, videoSize);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
        public void c(long j3, long j4, boolean z2) {
            if (z2 && DefaultVideoSink.this.f45676f != null) {
                DefaultVideoSink.this.f45681k.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultVideoSink.FrameRendererImpl frameRendererImpl = this.f45881a;
                        DefaultVideoSink.this.f45680j.a(DefaultVideoSink.this);
                    }
                });
            }
            Format formatN = this.f45683a;
            if (formatN == null) {
                formatN = new Format.Builder().N();
            }
            DefaultVideoSink.this.f45682l.e(j4, DefaultVideoSink.this.f45673b.b(), formatN, null);
            ((VideoSink.VideoFrameHandler) DefaultVideoSink.this.f45675d.remove()).a(j3);
        }
    }

    public DefaultVideoSink(VideoFrameReleaseControl videoFrameReleaseControl, Clock clock) {
        this.f45672a = videoFrameReleaseControl;
        videoFrameReleaseControl.o(clock);
        this.f45673b = clock;
        this.f45674c = new VideoFrameRenderControl(new FrameRendererImpl(), videoFrameReleaseControl);
        this.f45675d = new ArrayDeque();
        this.f45677g = new Format.Builder().N();
        this.f45678h = -9223372036854775807L;
        this.f45680j = VideoSink.Listener.f45879a;
        this.f45681k = new Executor() { // from class: androidx.media3.exoplayer.video.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                DefaultVideoSink.w(runnable);
            }
        };
        this.f45682l = new VideoFrameMetadataListener() { // from class: androidx.media3.exoplayer.video.b
            @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
            public final void e(long j3, long j4, Format format, MediaFormat mediaFormat) {
                DefaultVideoSink.z(j3, j4, format, mediaFormat);
            }
        };
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void A(boolean z2) {
        this.f45672a.e(z2);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void B(VideoSink.Listener listener, Executor executor) {
        this.f45680j = listener;
        this.f45681k = executor;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public Surface a() {
        return (Surface) Assertions.i(this.f45676f);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean b() {
        return this.f45674c.d();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void c() {
        this.f45674c.l();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean e(long j3, boolean z2, VideoSink.VideoFrameHandler videoFrameHandler) {
        this.f45675d.add(videoFrameHandler);
        this.f45674c.g(j3 - this.f45679i);
        return true;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void f() {
        this.f45672a.a();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void g(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.f45682l = videoFrameMetadataListener;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void h(long j3, long j4) throws VideoSink.VideoSinkException {
        try {
            this.f45674c.j(j3, j4);
        } catch (ExoPlaybackException e3) {
            throw new VideoSink.VideoSinkException(e3, this.f45677g);
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void i(long j3, long j4) {
        if (j3 != this.f45678h) {
            this.f45674c.h(j3);
            this.f45678h = j3;
        }
        this.f45679i = j4;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean isInitialized() {
        return true;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void j() {
        this.f45672a.l();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void k(Renderer.WakeupListener wakeupListener) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void l(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean m(boolean z2) {
        return this.f45672a.d(z2);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean n(Format format) {
        return true;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void o(boolean z2) {
        this.f45672a.h(z2);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void p() {
        this.f45672a.k();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void q(int i3, Format format, List list) {
        Assertions.g(list.isEmpty());
        int i4 = format.f40639v;
        Format format2 = this.f45677g;
        if (i4 != format2.f40639v || format.f40640w != format2.f40640w) {
            this.f45674c.i(i4, format.f40640w);
        }
        float f3 = format.f40641x;
        if (f3 != this.f45677g.f40641x) {
            this.f45672a.p(f3);
        }
        this.f45677g = format;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void r(Surface surface, Size size) {
        this.f45676f = surface;
        this.f45672a.q(surface);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void s() {
        this.f45672a.g();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void t(int i3) {
        this.f45672a.n(i3);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void u(float f3) {
        this.f45672a.r(f3);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void v() {
        this.f45676f = null;
        this.f45672a.q(null);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void x(boolean z2) {
        if (z2) {
            this.f45672a.m();
        }
        this.f45674c.b();
        this.f45675d.clear();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean y(Bitmap bitmap, TimestampIterator timestampIterator) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void d() {
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void release() {
    }

    public static /* synthetic */ void w(Runnable runnable) {
    }

    public static /* synthetic */ void z(long j3, long j4, Format format, MediaFormat mediaFormat) {
    }
}

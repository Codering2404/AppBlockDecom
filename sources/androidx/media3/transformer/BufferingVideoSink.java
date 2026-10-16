package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.video.PlaceholderSurface;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.VideoSink;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class BufferingVideoSink implements VideoSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f47957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f47958b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VideoSink f47959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f47960d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PlaceholderSurface f47961f;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface VideoSinkOperation {
        void a(VideoSink videoSink);
    }

    public BufferingVideoSink(Context context) {
        this.f47957a = context;
    }

    private void N(VideoSinkOperation videoSinkOperation) {
        VideoSink videoSink = this.f47959c;
        if (videoSink != null) {
            videoSinkOperation.a(videoSink);
        } else {
            this.f47958b.add(videoSinkOperation);
        }
    }

    private PlaceholderSurface O() {
        if (this.f47961f == null) {
            this.f47961f = PlaceholderSurface.d(this.f47957a, false);
        }
        return this.f47961f;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void A(final boolean z2) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.i
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.A(z2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void B(final VideoSink.Listener listener, final Executor executor) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.u
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.B(listener, executor);
            }
        });
    }

    public void M() {
        this.f47958b.clear();
    }

    public VideoSink P() {
        return this.f47959c;
    }

    public void Q(VideoSink videoSink) {
        this.f47959c = videoSink;
        if (videoSink == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f47958b.size(); i3++) {
            ((VideoSinkOperation) this.f47958b.get(i3)).a(videoSink);
        }
        this.f47958b.clear();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public Surface a() {
        VideoSink videoSink = this.f47959c;
        return videoSink == null ? O() : videoSink.a();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean b() {
        VideoSink videoSink = this.f47959c;
        return videoSink != null && videoSink.b();
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void c() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.e
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.c();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void d() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.o
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.d();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean e(long j3, boolean z2, VideoSink.VideoFrameHandler videoFrameHandler) {
        VideoSink videoSink = this.f47959c;
        return videoSink != null && videoSink.e(j3, z2, videoFrameHandler);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void f() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.a
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.f();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void g(final VideoFrameMetadataListener videoFrameMetadataListener) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.t
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.g(videoFrameMetadataListener);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void h(long j3, long j4) {
        VideoSink videoSink = this.f47959c;
        if (videoSink != null) {
            videoSink.h(j3, j4);
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void i(final long j3, final long j4) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.d
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.i(j3, j4);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean isInitialized() {
        return this.f47960d;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void j() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.l
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.j();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void k(final Renderer.WakeupListener wakeupListener) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.n
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.k(wakeupListener);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void l(final List list) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.p
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.l(list);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean m(boolean z2) {
        VideoSink videoSink = this.f47959c;
        return videoSink == null || videoSink.m(z2);
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean n(Format format) {
        VideoSink videoSink = this.f47959c;
        boolean z2 = videoSink == null || videoSink.n(format);
        this.f47960d = z2;
        return z2;
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void o(final boolean z2) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.m
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.o(z2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void p() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.s
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.p();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void q(final int i3, final Format format, final List list) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.g
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.q(i3, format, list);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void r(final Surface surface, final Size size) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.h
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.r(surface, size);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void release() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.b
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.release();
            }
        });
        PlaceholderSurface placeholderSurface = this.f47961f;
        if (placeholderSurface != null) {
            placeholderSurface.release();
        }
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void s() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.q
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.s();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void t(final int i3) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.c
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.t(i3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void u(final float f3) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.j
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.u(f3);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void v() {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.f
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.v();
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public void x(final boolean z2) {
        N(new VideoSinkOperation() { // from class: androidx.media3.transformer.k
            @Override // androidx.media3.transformer.BufferingVideoSink.VideoSinkOperation
            public final void a(VideoSink videoSink) {
                videoSink.x(z2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.video.VideoSink
    public boolean y(Bitmap bitmap, TimestampIterator timestampIterator) {
        VideoSink videoSink = this.f47959c;
        return videoSink != null && videoSink.y(bitmap, timestampIterator);
    }
}

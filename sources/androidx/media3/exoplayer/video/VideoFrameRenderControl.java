package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VideoFrameRenderControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameRenderer f45866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VideoFrameReleaseControl f45867b;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f45876k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VideoFrameReleaseControl.FrameReleaseInfo f45868c = new VideoFrameReleaseControl.FrameReleaseInfo();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimedValueQueue f45869d = new TimedValueQueue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimedValueQueue f45870e = new TimedValueQueue();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LongArrayQueue f45871f = new LongArrayQueue();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f45872g = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VideoSize f45875j = VideoSize.f41254e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f45873h = -9223372036854775807L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f45874i = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface FrameRenderer {
        void a();

        void b(VideoSize videoSize);

        void c(long j3, long j4, boolean z2);
    }

    public VideoFrameRenderControl(FrameRenderer frameRenderer, VideoFrameReleaseControl videoFrameReleaseControl) {
        this.f45866a = frameRenderer;
        this.f45867b = videoFrameReleaseControl;
    }

    private void a() {
        this.f45871f.f();
        this.f45866a.a();
    }

    private static Object c(TimedValueQueue timedValueQueue) {
        Assertions.a(timedValueQueue.l() > 0);
        while (timedValueQueue.l() > 1) {
            timedValueQueue.i();
        }
        return Assertions.e(timedValueQueue.i());
    }

    private boolean e(long j3) {
        Long l3 = (Long) this.f45870e.j(j3);
        if (l3 == null || l3.longValue() == this.f45876k) {
            return false;
        }
        this.f45876k = l3.longValue();
        return true;
    }

    private boolean f(long j3) {
        VideoSize videoSize = (VideoSize) this.f45869d.j(j3);
        if (videoSize == null || videoSize.equals(VideoSize.f41254e) || videoSize.equals(this.f45875j)) {
            return false;
        }
        this.f45875j = videoSize;
        return true;
    }

    private void k(boolean z2) {
        long jF = this.f45871f.f();
        if (f(jF)) {
            this.f45866a.b(this.f45875j);
        }
        this.f45866a.c(z2 ? -1L : this.f45868c.g(), jF, this.f45867b.i());
    }

    public void b() {
        this.f45871f.b();
        this.f45872g = -9223372036854775807L;
        this.f45873h = -9223372036854775807L;
        this.f45874i = -9223372036854775807L;
        if (this.f45870e.l() > 0) {
            Long l3 = (Long) c(this.f45870e);
            l3.longValue();
            this.f45870e.a(0L, l3);
        }
        if (this.f45869d.l() > 0) {
            this.f45869d.a(0L, (VideoSize) c(this.f45869d));
        }
    }

    public boolean d() {
        long j3 = this.f45874i;
        return j3 != -9223372036854775807L && this.f45873h == j3;
    }

    public void g(long j3) {
        this.f45871f.a(j3);
        this.f45872g = j3;
        this.f45874i = -9223372036854775807L;
    }

    public void h(long j3) {
        TimedValueQueue timedValueQueue = this.f45870e;
        long j4 = this.f45872g;
        timedValueQueue.a(j4 == -9223372036854775807L ? 0L : j4 + 1, Long.valueOf(j3));
    }

    public void i(int i3, int i4) {
        TimedValueQueue timedValueQueue = this.f45869d;
        long j3 = this.f45872g;
        timedValueQueue.a(j3 == -9223372036854775807L ? 0L : j3 + 1, new VideoSize(i3, i4));
    }

    public void j(long j3, long j4) {
        while (!this.f45871f.e()) {
            long jD = this.f45871f.d();
            if (e(jD)) {
                this.f45867b.j();
            }
            int iC = this.f45867b.c(jD, j3, j4, this.f45876k, false, false, this.f45868c);
            if (iC == 0 || iC == 1) {
                this.f45873h = jD;
                k(iC == 0);
            } else if (iC == 2 || iC == 3) {
                this.f45873h = jD;
                a();
            } else {
                if (iC != 4) {
                    if (iC != 5) {
                        throw new IllegalStateException(String.valueOf(iC));
                    }
                    return;
                }
                this.f45873h = jD;
            }
        }
    }

    public void l() {
        this.f45874i = this.f45872g;
    }
}

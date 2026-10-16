package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DefaultMediaClock implements MediaClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StandaloneMediaClock f42927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PlaybackParametersListener f42928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Renderer f42929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaClock f42930d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f42931f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f42932g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PlaybackParametersListener {
        void j(PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(PlaybackParametersListener playbackParametersListener, Clock clock) {
        this.f42928b = playbackParametersListener;
        this.f42927a = new StandaloneMediaClock(clock);
    }

    private boolean f(boolean z2) {
        Renderer renderer = this.f42929c;
        if (renderer == null || renderer.b()) {
            return true;
        }
        if (z2 && this.f42929c.getState() != 2) {
            return true;
        }
        if (this.f42929c.isReady()) {
            return false;
        }
        return z2 || this.f42929c.k();
    }

    private void j(boolean z2) {
        if (f(z2)) {
            this.f42931f = true;
            if (this.f42932g) {
                this.f42927a.b();
                return;
            }
            return;
        }
        MediaClock mediaClock = (MediaClock) Assertions.e(this.f42930d);
        long jK = mediaClock.K();
        if (this.f42931f) {
            if (jK < this.f42927a.K()) {
                this.f42927a.c();
                return;
            } else {
                this.f42931f = false;
                if (this.f42932g) {
                    this.f42927a.b();
                }
            }
        }
        this.f42927a.a(jK);
        PlaybackParameters playbackParametersD = mediaClock.d();
        if (playbackParametersD.equals(this.f42927a.d())) {
            return;
        }
        this.f42927a.e(playbackParametersD);
        this.f42928b.j(playbackParametersD);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public long K() {
        return this.f42931f ? this.f42927a.K() : ((MediaClock) Assertions.e(this.f42930d)).K();
    }

    public void a(Renderer renderer) {
        if (renderer == this.f42929c) {
            this.f42930d = null;
            this.f42929c = null;
            this.f42931f = true;
        }
    }

    public void b(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock mediaClockQ = renderer.Q();
        if (mediaClockQ == null || mediaClockQ == (mediaClock = this.f42930d)) {
            return;
        }
        if (mediaClock != null) {
            throw ExoPlaybackException.f(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.f42930d = mediaClockQ;
        this.f42929c = renderer;
        mediaClockQ.e(this.f42927a.d());
    }

    public void c(long j3) {
        this.f42927a.a(j3);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public PlaybackParameters d() {
        MediaClock mediaClock = this.f42930d;
        return mediaClock != null ? mediaClock.d() : this.f42927a.d();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public void e(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.f42930d;
        if (mediaClock != null) {
            mediaClock.e(playbackParameters);
            playbackParameters = this.f42930d.d();
        }
        this.f42927a.e(playbackParameters);
    }

    public void g() {
        this.f42932g = true;
        this.f42927a.b();
    }

    public void h() {
        this.f42932g = false;
        this.f42927a.c();
    }

    public long i(boolean z2) {
        j(z2);
        return K();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public boolean v() {
        return this.f42931f ? this.f42927a.v() : ((MediaClock) Assertions.e(this.f42930d)).v();
    }
}

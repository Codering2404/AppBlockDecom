package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class StandaloneMediaClock implements MediaClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f43305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f43306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f43307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f43308d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PlaybackParameters f43309f = PlaybackParameters.f40950d;

    public StandaloneMediaClock(Clock clock) {
        this.f43305a = clock;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public long K() {
        long j3 = this.f43307c;
        if (!this.f43306b) {
            return j3;
        }
        long jA = this.f43305a.a() - this.f43308d;
        PlaybackParameters playbackParameters = this.f43309f;
        return j3 + (playbackParameters.f40953a == 1.0f ? Util.P0(jA) : playbackParameters.a(jA));
    }

    public void a(long j3) {
        this.f43307c = j3;
        if (this.f43306b) {
            this.f43308d = this.f43305a.a();
        }
    }

    public void b() {
        if (this.f43306b) {
            return;
        }
        this.f43308d = this.f43305a.a();
        this.f43306b = true;
    }

    public void c() {
        if (this.f43306b) {
            a(K());
            this.f43306b = false;
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public PlaybackParameters d() {
        return this.f43309f;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public void e(PlaybackParameters playbackParameters) {
        if (this.f43306b) {
            a(K());
        }
        this.f43309f = playbackParameters;
    }
}

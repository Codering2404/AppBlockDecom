package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioTimestampPoller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioTimestampWrapper f43717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f43719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f43720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f43721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f43722f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AudioTimestampWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioTrack f43723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f43724b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f43725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f43726d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f43727e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f43728f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f43729g;

        public AudioTimestampWrapper(AudioTrack audioTrack) {
            this.f43723a = audioTrack;
        }

        public void a() {
            this.f43728f = true;
        }

        public long b() {
            return this.f43727e;
        }

        public long c() {
            return this.f43724b.nanoTime / 1000;
        }

        public boolean d() {
            boolean timestamp = this.f43723a.getTimestamp(this.f43724b);
            if (timestamp) {
                long j3 = this.f43724b.framePosition;
                long j4 = this.f43726d;
                if (j4 > j3) {
                    if (this.f43728f) {
                        this.f43729g += j4;
                        this.f43728f = false;
                    } else {
                        this.f43725c++;
                    }
                }
                this.f43726d = j3;
                this.f43727e = j3 + this.f43729g + (this.f43725c << 32);
            }
            return timestamp;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        this.f43717a = new AudioTimestampWrapper(audioTrack);
        h();
    }

    private void i(int i3) {
        this.f43718b = i3;
        if (i3 == 0) {
            this.f43721e = 0L;
            this.f43722f = -1L;
            this.f43719c = System.nanoTime() / 1000;
            this.f43720d = 10000L;
            return;
        }
        if (i3 == 1) {
            this.f43720d = 10000L;
            return;
        }
        if (i3 == 2 || i3 == 3) {
            this.f43720d = 10000000L;
        } else {
            if (i3 != 4) {
                throw new IllegalStateException();
            }
            this.f43720d = 500000L;
        }
    }

    public void a() {
        if (this.f43718b == 4) {
            h();
        }
    }

    public void b() {
        AudioTimestampWrapper audioTimestampWrapper = this.f43717a;
        if (audioTimestampWrapper != null) {
            audioTimestampWrapper.a();
        }
    }

    public long c() {
        AudioTimestampWrapper audioTimestampWrapper = this.f43717a;
        if (audioTimestampWrapper != null) {
            return audioTimestampWrapper.b();
        }
        return -1L;
    }

    public long d() {
        AudioTimestampWrapper audioTimestampWrapper = this.f43717a;
        if (audioTimestampWrapper != null) {
            return audioTimestampWrapper.c();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f43718b == 2;
    }

    public boolean f(long j3) {
        AudioTimestampWrapper audioTimestampWrapper = this.f43717a;
        if (audioTimestampWrapper == null || j3 - this.f43721e < this.f43720d) {
            return false;
        }
        this.f43721e = j3;
        boolean zD = audioTimestampWrapper.d();
        int i3 = this.f43718b;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zD) {
                        h();
                        return zD;
                    }
                } else if (!zD) {
                    h();
                    return zD;
                }
            } else {
                if (!zD) {
                    h();
                    return zD;
                }
                if (this.f43717a.b() > this.f43722f) {
                    i(2);
                    return zD;
                }
            }
        } else {
            if (zD) {
                if (this.f43717a.c() < this.f43719c) {
                    return false;
                }
                this.f43722f = this.f43717a.b();
                i(1);
                return zD;
            }
            if (j3 - this.f43719c > 500000) {
                i(3);
            }
        }
        return zD;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f43717a != null) {
            i(0);
        }
    }
}

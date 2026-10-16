package com.applovin.impl;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f63848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f63849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f63850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f63851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f63852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f63853f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioTrack f63854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f63855b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f63856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f63857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f63858e;

        public a(AudioTrack audioTrack) {
            this.f63854a = audioTrack;
        }

        public long a() {
            return this.f63858e;
        }

        public long b() {
            return this.f63855b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f63854a.getTimestamp(this.f63855b);
            if (timestamp) {
                long j3 = this.f63855b.framePosition;
                if (this.f63857d > j3) {
                    this.f63856c++;
                }
                this.f63857d = j3;
                this.f63858e = j3 + (this.f63856c << 32);
            }
            return timestamp;
        }
    }

    public t1(AudioTrack audioTrack) {
        if (xp.f65027a >= 19) {
            this.f63848a = new a(audioTrack);
            f();
        } else {
            this.f63848a = null;
            a(3);
        }
    }

    public void a() {
        if (this.f63849b == 4) {
            f();
        }
    }

    public long b() {
        a aVar = this.f63848a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    public long c() {
        a aVar = this.f63848a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.f63849b == 2;
    }

    public void e() {
        a(4);
    }

    public void f() {
        if (this.f63848a != null) {
            a(0);
        }
    }

    public boolean a(long j3) {
        a aVar = this.f63848a;
        if (aVar == null || j3 - this.f63852e < this.f63851d) {
            return false;
        }
        this.f63852e = j3;
        boolean zC = aVar.c();
        int i3 = this.f63849b;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zC) {
                        f();
                        return zC;
                    }
                } else if (!zC) {
                    f();
                    return zC;
                }
            } else {
                if (!zC) {
                    f();
                    return zC;
                }
                if (this.f63848a.a() > this.f63853f) {
                    a(2);
                    return zC;
                }
            }
        } else {
            if (zC) {
                if (this.f63848a.b() < this.f63850c) {
                    return false;
                }
                this.f63853f = this.f63848a.a();
                a(1);
                return zC;
            }
            if (j3 - this.f63850c > 500000) {
                a(3);
            }
        }
        return zC;
    }

    private void a(int i3) {
        this.f63849b = i3;
        if (i3 == 0) {
            this.f63852e = 0L;
            this.f63853f = -1L;
            this.f63850c = System.nanoTime() / 1000;
            this.f63851d = 10000L;
            return;
        }
        if (i3 == 1) {
            this.f63851d = 10000L;
            return;
        }
        if (i3 == 2 || i3 == 3) {
            this.f63851d = 10000000L;
        } else {
            if (i3 == 4) {
                this.f63851d = 500000L;
                return;
            }
            throw new IllegalStateException();
        }
    }
}

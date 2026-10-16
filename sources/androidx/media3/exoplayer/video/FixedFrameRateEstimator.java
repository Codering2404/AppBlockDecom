package androidx.media3.exoplayer.video;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FixedFrameRateEstimator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45688d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45690f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Matcher f45685a = new Matcher();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Matcher f45686b = new Matcher();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f45689e = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Matcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f45691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f45692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f45693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f45694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f45695e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f45696f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean[] f45697g = new boolean[15];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f45698h;

        private static int c(long j3) {
            return (int) (j3 % 15);
        }

        public long a() {
            long j3 = this.f45695e;
            if (j3 == 0) {
                return 0L;
            }
            return this.f45696f / j3;
        }

        public long b() {
            return this.f45696f;
        }

        public boolean d() {
            long j3 = this.f45694d;
            if (j3 == 0) {
                return false;
            }
            return this.f45697g[c(j3 - 1)];
        }

        public boolean e() {
            return this.f45694d > 15 && this.f45698h == 0;
        }

        public void f(long j3) {
            long j4 = this.f45694d;
            if (j4 == 0) {
                this.f45691a = j3;
            } else if (j4 == 1) {
                long j5 = j3 - this.f45691a;
                this.f45692b = j5;
                this.f45696f = j5;
                this.f45695e = 1L;
            } else {
                long j6 = j3 - this.f45693c;
                int iC = c(j4);
                if (Math.abs(j6 - this.f45692b) <= 1000000) {
                    this.f45695e++;
                    this.f45696f += j6;
                    boolean[] zArr = this.f45697g;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f45698h--;
                    }
                } else {
                    boolean[] zArr2 = this.f45697g;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f45698h++;
                    }
                }
            }
            this.f45694d++;
            this.f45693c = j3;
        }

        public void g() {
            this.f45694d = 0L;
            this.f45695e = 0L;
            this.f45696f = 0L;
            this.f45698h = 0;
            Arrays.fill(this.f45697g, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f45685a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f45685a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f45690f;
    }

    public long d() {
        if (e()) {
            return this.f45685a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f45685a.e();
    }

    public void f(long j3) {
        this.f45685a.f(j3);
        if (this.f45685a.e() && !this.f45688d) {
            this.f45687c = false;
        } else if (this.f45689e != -9223372036854775807L) {
            if (!this.f45687c || this.f45686b.d()) {
                this.f45686b.g();
                this.f45686b.f(this.f45689e);
            }
            this.f45687c = true;
            this.f45686b.f(j3);
        }
        if (this.f45687c && this.f45686b.e()) {
            Matcher matcher = this.f45685a;
            this.f45685a = this.f45686b;
            this.f45686b = matcher;
            this.f45687c = false;
            this.f45688d = false;
        }
        this.f45689e = j3;
        this.f45690f = this.f45685a.e() ? 0 : this.f45690f + 1;
    }

    public void g() {
        this.f45685a.g();
        this.f45686b.g();
        this.f45687c = false;
        this.f45689e = -9223372036854775807L;
        this.f45690f = 0;
    }
}

package androidx.media3.common.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TimestampAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f41605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f41606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f41607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal f41608d = new ThreadLocal();

    public TimestampAdjuster(long j3) {
        i(j3);
    }

    public static long h(long j3) {
        return Util.Z0(j3, 1000000L, 90000L);
    }

    public static long j(long j3) {
        return Util.Z0(j3, 90000L, 1000000L);
    }

    public synchronized long a(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!g()) {
                long jLongValue = this.f41605a;
                if (jLongValue == 9223372036854775806L) {
                    jLongValue = ((Long) Assertions.e((Long) this.f41608d.get())).longValue();
                }
                this.f41606b = jLongValue - j3;
                notifyAll();
            }
            this.f41607c = j3;
            return j3 + this.f41606b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long b(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j4 = this.f41607c;
            if (j4 != -9223372036854775807L) {
                long j5 = j(j4);
                long j6 = (4294967296L + j5) / 8589934592L;
                long j7 = ((j6 - 1) * 8589934592L) + j3;
                j3 += j6 * 8589934592L;
                if (Math.abs(j7 - j5) < Math.abs(j3 - j5)) {
                    j3 = j7;
                }
            }
            return a(h(j3));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long c(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j4 = this.f41607c;
            if (j4 != -9223372036854775807L) {
                long j5 = j(j4);
                long j6 = j5 / 8589934592L;
                long j7 = (j6 * 8589934592L) + j3;
                j3 += (j6 + 1) * 8589934592L;
                if (j7 >= j5) {
                    j3 = j7;
                }
            }
            return a(h(j3));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long d() {
        long j3;
        j3 = this.f41605a;
        if (j3 == Long.MAX_VALUE || j3 == 9223372036854775806L) {
            j3 = -9223372036854775807L;
        }
        return j3;
    }

    public synchronized long e() {
        long j3;
        try {
            j3 = this.f41607c;
        } catch (Throwable th) {
            throw th;
        }
        return j3 != -9223372036854775807L ? j3 + this.f41606b : d();
    }

    public synchronized long f() {
        return this.f41606b;
    }

    public synchronized boolean g() {
        return this.f41606b != -9223372036854775807L;
    }

    public synchronized void i(long j3) {
        this.f41605a = j3;
        this.f41606b = j3 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f41607c = -9223372036854775807L;
    }
}

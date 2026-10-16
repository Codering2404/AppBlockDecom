package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ho {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f60229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f60230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f60231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal f60232d = new ThreadLocal();

    public ho(long j3) {
        d(j3);
    }

    public static long e(long j3) {
        return (j3 * 90000) / 1000000;
    }

    public synchronized long a(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (this.f60230b == -9223372036854775807L) {
                long jLongValue = this.f60229a;
                if (jLongValue == 9223372036854775806L) {
                    jLongValue = ((Long) b1.a((Long) this.f60232d.get())).longValue();
                }
                this.f60230b = jLongValue - j3;
                notifyAll();
            }
            this.f60231c = j3;
            return j3 + this.f60230b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long b(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j4 = this.f60231c;
            if (j4 != -9223372036854775807L) {
                long jE = e(j4);
                long j5 = (4294967296L + jE) / 8589934592L;
                long j6 = ((j5 - 1) * 8589934592L) + j3;
                j3 += j5 * 8589934592L;
                if (Math.abs(j6 - jE) < Math.abs(j3 - jE)) {
                    j3 = j6;
                }
            }
            return a(c(j3));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long c() {
        return this.f60230b;
    }

    public synchronized void d(long j3) {
        this.f60229a = j3;
        this.f60230b = j3 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f60231c = -9223372036854775807L;
    }

    public static long c(long j3) {
        return (j3 * 1000000) / 90000;
    }

    public synchronized long b() {
        long jA;
        try {
            long j3 = this.f60231c;
            if (j3 != -9223372036854775807L) {
                jA = j3 + this.f60230b;
            } else {
                jA = a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jA;
    }

    public synchronized long a() {
        long j3;
        j3 = this.f60229a;
        if (j3 == Long.MAX_VALUE || j3 == 9223372036854775806L) {
            j3 = -9223372036854775807L;
        }
        return j3;
    }
}

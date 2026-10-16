package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.53, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass53 {
    public long A00;
    public long A01;
    public long A02;
    public final ThreadLocal<Long> A03 = new ThreadLocal<>();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized long A06(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A01 != -9223372036854775807L) {
            long jA01 = A01(this.A01);
            long j4 = (4294967296L + jA01) / 8589934592L;
            long j5 = ((j4 - 1) * 8589934592L) + j3;
            long j6 = (8589934592L * j4) + j3;
            if (Math.abs(j5 - jA01) >= Math.abs(j6 - jA01)) {
                j5 = j6;
            }
            j3 = j5;
        }
        return A05(A00(j3));
    }

    public AnonymousClass53(long j3) {
        A07(j3);
    }

    public static long A00(long j3) {
        return (1000000 * j3) / 90000;
    }

    public static long A01(long j3) {
        return (90000 * j3) / 1000000;
    }

    public final synchronized long A02() {
        long j3;
        if (this.A00 != Long.MAX_VALUE && this.A00 != 9223372036854775806L) {
            j3 = this.A00;
        } else {
            j3 = -9223372036854775807L;
        }
        return j3;
    }

    public final synchronized long A03() {
        long jA02;
        if (this.A01 != -9223372036854775807L) {
            jA02 = this.A01 + this.A02;
        } else {
            jA02 = A02();
        }
        return jA02;
    }

    public final synchronized long A04() {
        return this.A02;
    }

    public final synchronized long A05(long j3) {
        long desiredSampleTimestampUs;
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 == -9223372036854775807L) {
            if (this.A00 == 9223372036854775806L) {
                desiredSampleTimestampUs = ((Long) AbstractC04323y.A01(this.A03.get())).longValue();
            } else {
                desiredSampleTimestampUs = this.A00;
            }
            this.A02 = desiredSampleTimestampUs - j3;
            notifyAll();
        }
        this.A01 = j3;
        return this.A02 + j3;
    }

    public final synchronized void A07(long j3) {
        this.A00 = j3;
        this.A02 = j3 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.A01 = -9223372036854775807L;
    }
}

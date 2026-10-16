package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05327u {
    public final long A00;
    public final long A01;
    public static final C05327u A04 = new C05327u(0, 0);
    public static final C05327u A02 = new C05327u(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final C05327u A06 = new C05327u(Long.MAX_VALUE, 0);
    public static final C05327u A05 = new C05327u(0, Long.MAX_VALUE);
    public static final C05327u A03 = A04;

    public C05327u(long j3, long j4) {
        AbstractC04323y.A07(j3 >= 0);
        AbstractC04323y.A07(j4 >= 0);
        this.A01 = j3;
        this.A00 = j4;
    }

    public final long A00(long minPositionUs, long j3, long j4) {
        if (this.A01 == 0 && this.A00 == 0) {
            return minPositionUs;
        }
        long jA0V = C5C.A0V(minPositionUs, this.A01, Long.MIN_VALUE);
        long jA0S = C5C.A0S(minPositionUs, this.A00, Long.MAX_VALUE);
        boolean z2 = true;
        boolean z3 = jA0V <= j3 && j3 <= jA0S;
        if (jA0V > j4 || j4 > jA0S) {
            z2 = false;
        }
        if (z3 && z2) {
            long jAbs = Math.abs(j3 - minPositionUs);
            long maxPositionUs = Math.abs(j4 - minPositionUs);
            if (jAbs <= maxPositionUs) {
                return j3;
            }
            return j4;
        }
        if (z3) {
            return j3;
        }
        if (z2) {
            return j4;
        }
        return jA0V;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C05327u c05327u = (C05327u) obj;
        return this.A01 == c05327u.A01 && this.A00 == c05327u.A00;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}

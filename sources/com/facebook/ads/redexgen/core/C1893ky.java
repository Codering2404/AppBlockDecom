package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ky, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1893ky implements HY {
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final LN A04;

    public C1893ky(LN ln, int i3, long j3, long j4) {
        this.A04 = ln;
        this.A00 = i3;
        this.A03 = j3;
        this.A01 = (j4 - j3) / ((long) ln.A02);
        this.A02 = A00(this.A01);
    }

    private long A00(long j3) {
        return C5C.A0U(j3 * ((long) this.A00), 1000000L, this.A04.A04);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        long jA0T = C5C.A0T((((long) this.A04.A04) * j3) / (((long) this.A00) * 1000000), 0L, this.A01 - 1);
        long j4 = this.A03 + (((long) this.A04.A02) * jA0T);
        long jA00 = A00(jA0T);
        HZ hz = new HZ(jA00, j4);
        if (jA00 >= j3 || jA0T == this.A01 - 1) {
            return new HX(hz);
        }
        long j5 = 1 + jA0T;
        return new HX(hz, new HZ(A00(j5), this.A03 + (((long) this.A04.A02) * j5)));
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}

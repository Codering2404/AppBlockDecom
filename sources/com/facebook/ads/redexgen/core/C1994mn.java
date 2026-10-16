package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1994mn implements HY {
    public final long A00;
    public final HX A01;

    public C1994mn(long j3) {
        this(j3, 0L);
    }

    public C1994mn(long j3, long j4) {
        this.A00 = j3;
        this.A01 = new HX(j4 == 0 ? HZ.A04 : new HZ(0L, j4));
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return false;
    }
}

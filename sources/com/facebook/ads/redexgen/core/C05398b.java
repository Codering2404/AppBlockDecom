package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05398b implements InterfaceC1972mF {
    public long A00;
    public final long A01;
    public final C04414h A03 = new C04414h();
    public final C04414h A02 = new C04414h();

    public C05398b(long j3, long j4, long j5) {
        this.A00 = j3;
        this.A01 = j5;
        this.A03.A04(0L);
        this.A02.A04(j4);
    }

    public final void A00(long j3) {
        this.A00 = j3;
    }

    public final void A01(long j3, long j4) {
        if (A02(j3)) {
            return;
        }
        this.A03.A04(j3);
        this.A02.A04(j4);
    }

    public final boolean A02(long j3) {
        long lastIndexedTimeUs = this.A03.A03(this.A03.A02() - 1);
        return j3 - lastIndexedTimeUs < 100000;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A7j() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        int iA0C = C5C.A0C(this.A03, j3, true, true);
        HZ hz = new HZ(this.A03.A03(iA0C), this.A02.A03(iA0C));
        if (hz.A01 != j3) {
            int targetIndex = this.A03.A02();
            if (iA0C != targetIndex - 1) {
                int targetIndex2 = iA0C + 1;
                long jA03 = this.A03.A03(targetIndex2);
                int targetIndex3 = iA0C + 1;
                HZ nextSeekPoint = new HZ(jA03, this.A02.A03(targetIndex3));
                return new HX(hz, nextSeekPoint);
            }
        }
        return new HX(hz);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A9H(long j3) {
        return this.A03.A03(C5C.A0C(this.A02, j3, true, true));
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}

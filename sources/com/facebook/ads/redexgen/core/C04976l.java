package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04976l implements Comparable<C04976l> {
    public int A00;
    public long A01;
    public Object A02;
    public final C05157d A03;

    public C04976l(C05157d c05157d) {
        this.A03 = c05157d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C04976l c04976l) {
        if ((this.A02 == null) != (c04976l.A02 == null)) {
            return this.A02 != null ? -1 : 1;
        }
        if (this.A02 == null) {
            return 0;
        }
        int i3 = this.A00 - c04976l.A00;
        if (i3 != 0) {
            return i3;
        }
        int comparePeriodIndex = C5C.A08(this.A01, c04976l.A01);
        return comparePeriodIndex;
    }

    public final void A01(int i3, long j3, Object obj) {
        this.A00 = i3;
        this.A01 = j3;
        this.A02 = obj;
    }
}

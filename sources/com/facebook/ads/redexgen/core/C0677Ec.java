package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0677Ec implements Comparable<C0677Ec> {
    public final boolean A00;
    public final boolean A01;

    public C0677Ec(C2208qI c2208qI, int i3) {
        this.A00 = (c2208qI.A0H & 1) != 0;
        this.A01 = C05659h.A0S(i3, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0677Ec c0677Ec) {
        return AbstractC2060ns.A01().A09(this.A01, c0677Ec.A01).A09(this.A00, c0677Ec.A00).A05();
    }
}

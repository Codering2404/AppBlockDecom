package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0839Kk implements Comparable<C0839Kk> {
    public final int A00;
    public final C0830Kb A01;

    public C0839Kk(int i3, C0830Kb c0830Kb) {
        this.A00 = i3;
        this.A01 = c0830Kb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0839Kk c0839Kk) {
        return Integer.compare(this.A00, c0839Kk.A00);
    }
}

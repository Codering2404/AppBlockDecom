package com.facebook.ads.redexgen.core;

import android.util.SparseArray;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K1 {
    public C0824Jv A00;
    public C0826Jx A01;
    public final int A02;
    public final int A03;
    public final SparseArray<C0828Jz> A08 = new SparseArray<>();
    public final SparseArray<C0823Ju> A06 = new SparseArray<>();
    public final SparseArray<C0825Jw> A07 = new SparseArray<>();
    public final SparseArray<C0823Ju> A04 = new SparseArray<>();
    public final SparseArray<C0825Jw> A05 = new SparseArray<>();

    public K1(int i3, int i4) {
        this.A03 = i3;
        this.A02 = i4;
    }

    public final void A00() {
        this.A08.clear();
        this.A06.clear();
        this.A07.clear();
        this.A04.clear();
        this.A05.clear();
        this.A00 = null;
        this.A01 = null;
    }
}

package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ui, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1091Ui {
    public final int A00;
    public final C1088Uf A01;

    public C1091Ui(int i3, C1088Uf c1088Uf) {
        this.A00 = i3;
        this.A01 = c1088Uf;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() throws IOException {
        return this.A01.A05();
    }

    public final UW A02(int i3, byte[] bArr, int i4, int[] iArr, int i5) throws IOException {
        return this.A01.A06(i3, bArr, i4, iArr, i5);
    }

    public final void A03() throws IOException {
        this.A01.A07();
    }

    public final void A04() throws IOException {
        this.A01.A08();
    }

    public final boolean A05(byte[] bArr) throws IOException {
        return this.A01.A09(bArr);
    }
}

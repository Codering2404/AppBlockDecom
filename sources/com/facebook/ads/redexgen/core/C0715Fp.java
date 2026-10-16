package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0715Fp extends AbstractC0996Qq<FY> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public AbstractC1183Yb A04;
    public InterfaceC1189Yh A05;
    public String A06;
    public List<C1486e5> A07;
    public boolean A08;
    public final SparseBooleanArray A09 = new SparseBooleanArray();
    public final AbstractC1813jd A0A;
    public final C1054Sx A0B;
    public final C1648gi A0C;
    public final VA A0D;
    public final Y2 A0E;
    public final C0724Fy A0F;
    public final C1593fp A0G;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C0715Fp(C1648gi c1648gi, List<C1486e5> list, AbstractC1813jd abstractC1813jd, VA va, C1054Sx c1054Sx, C1593fp c1593fp, Y2 y2, InterfaceC1189Yh interfaceC1189Yh, String str, int i3, int i4, int i5, int i6, C0724Fy c0724Fy, AbstractC1183Yb abstractC1183Yb) {
        this.A0C = c1648gi;
        this.A0D = va;
        this.A0B = c1054Sx;
        this.A0G = c1593fp;
        this.A0E = y2;
        this.A05 = interfaceC1189Yh;
        this.A0A = abstractC1813jd;
        this.A07 = list;
        this.A00 = i3;
        this.A03 = i6;
        this.A06 = str;
        this.A01 = i5;
        this.A02 = i4;
        this.A0F = c0724Fy;
        this.A04 = abstractC1183Yb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final FY A0F(ViewGroup viewGroup, int i3) {
        return new FY(AbstractC1418cy.A00(new C1364c6(this.A0C, this.A0D, this.A05, this.A0A, null, this.A0G, this.A0E).A0P(this.A04).A0U(), this.A03, this.A06, this.A0F), this.A09, this.A0G, this.A00, this.A01, this.A02, this.A07.size(), this.A0C, this.A0A.A2A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(FY fy, int i3) {
        fy.A0q(this.A07.get(i3), this.A0D, this.A0B, this.A0E, this.A06);
        if (!this.A08 && i3 == 0) {
            fy.AJF();
            this.A08 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    public final int A0B() {
        return this.A07.size();
    }
}

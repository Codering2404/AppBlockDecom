package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class M1 extends AbstractC0996Qq<C0716Fq> {
    public int A00;
    public int A01;
    public int A02;
    public InterfaceC1189Yh A03;
    public C1593fp A04;
    public String A05;
    public List<C1486e5> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC1813jd A08;
    public final C1054Sx A09;
    public final C1648gi A0A;
    public final VA A0B;
    public final UK A0C;
    public final Y2 A0D;
    public final C6X A0E;
    public final DZ A0F;

    public M1(C1648gi c1648gi, List<C1486e5> list, AbstractC1813jd abstractC1813jd, VA va, UK uk, InterfaceC1189Yh interfaceC1189Yh, String str, C6X c6x, DZ dz) {
        this.A0A = c1648gi;
        this.A0B = va;
        this.A0C = uk;
        this.A09 = uk.A14();
        this.A04 = uk.A1G();
        this.A0D = uk.A1E();
        this.A03 = interfaceC1189Yh;
        this.A08 = abstractC1813jd;
        this.A06 = list;
        this.A05 = str;
        this.A0E = c6x;
        this.A0F = dz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C0716Fq A0F(ViewGroup viewGroup, int i3) {
        return new C0716Fq(AbstractC1328bW.A00(new C1364c6(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0R(this.A0F).A0N(this.A0C).A0U(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A2A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(C0716Fq c0716Fq, int i3) {
        C1486e5 c1486e5 = this.A06.get(i3);
        c0716Fq.A0q(this.A04);
        c0716Fq.A0p(c1486e5, this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    public final int A0B() {
        return this.A06.size();
    }

    public final void A0O(int i3, int i4, int i5) {
        boolean needsUpdate = i3 != this.A00;
        this.A00 = i3;
        this.A02 = i4;
        this.A01 = i5;
        if (needsUpdate) {
            A0G();
        }
    }

    public final void A0P(C1593fp c1593fp) {
        this.A04 = c1593fp;
    }
}

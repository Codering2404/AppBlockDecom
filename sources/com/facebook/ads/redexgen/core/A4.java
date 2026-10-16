package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class A4 implements InterfaceC04193l {
    public final C05759y A00;
    public final C2086oJ A01;
    public final InterfaceC04183k[] A02;

    public A4(InterfaceC04183k... interfaceC04183kArr) {
        this(interfaceC04183kArr, new C05759y(), new C2086oJ());
    }

    public A4(InterfaceC04183k[] interfaceC04183kArr, C05759y c05759y, C2086oJ c2086oJ) {
        this.A02 = new InterfaceC04183k[interfaceC04183kArr.length + 2];
        System.arraycopy(interfaceC04183kArr, 0, this.A02, 0, interfaceC04183kArr.length);
        this.A00 = c05759y;
        this.A01 = c2086oJ;
        this.A02[interfaceC04183kArr.length] = c05759y;
        this.A02[interfaceC04183kArr.length + 1] = c2086oJ;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04193l
    public final C2187px A4F(C2187px c2187px) {
        this.A01.A02(c2187px.A01);
        this.A01.A01(c2187px.A00);
        return c2187px;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04193l
    public final boolean A4G(boolean z2) {
        this.A00.A0D(z2);
        return z2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04193l
    public final InterfaceC04183k[] A6z() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04193l
    public final long A8U(long j3) {
        return this.A01.A00(j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04193l
    public final long A98() {
        return this.A00.A0C();
    }
}

package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Za, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1208Za {
    public int A00;
    public YM A01;
    public InterfaceC1213Zf A02;
    public String A03;
    public String A04;
    public String A05;
    public String A06;
    public final C1648gi A0B;
    public boolean A09 = true;
    public boolean A0A = true;
    public boolean A08 = true;
    public boolean A07 = true;
    public final boolean A0C = true;

    public C1208Za(C1648gi c1648gi, InterfaceC1213Zf interfaceC1213Zf) {
        this.A0B = c1648gi;
        this.A02 = interfaceC1213Zf;
    }

    public final C1208Za A0C(int i3) {
        this.A00 = i3;
        return this;
    }

    public final C1208Za A0D(YM ym) {
        this.A01 = ym;
        return this;
    }

    public final C1208Za A0E(String str) {
        this.A03 = str;
        return this;
    }

    public final C1208Za A0F(String str) {
        this.A04 = str;
        return this;
    }

    public final C1208Za A0G(String str) {
        this.A05 = str;
        return this;
    }

    public final C1208Za A0H(String str) {
        this.A06 = str;
        return this;
    }

    public final C1208Za A0I(boolean z2) {
        this.A08 = z2;
        return this;
    }

    public final C1208Za A0J(boolean z2) {
        this.A09 = z2;
        return this;
    }

    public final C1208Za A0K(boolean z2) {
        this.A0A = z2;
        return this;
    }

    public final C1209Zb A0L() {
        return new C1209Zb(this, null);
    }
}

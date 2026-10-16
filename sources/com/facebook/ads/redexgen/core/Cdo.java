package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.do, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Cdo {
    public String A02;
    public String A03;
    public String A04;
    public final NY A06;
    public final C0918Nm A07;
    public final C1648gi A08;
    public C0906Na A01 = C0906Na.A01(null);
    public int A00 = 1000;
    public boolean A05 = false;

    public Cdo(C1648gi c1648gi, NY ny, C0918Nm c0918Nm) {
        this.A08 = c1648gi;
        this.A06 = ny;
        this.A07 = c0918Nm;
    }

    public final Cdo A09(int i3) {
        this.A00 = i3;
        return this;
    }

    public final Cdo A0A(C0906Na c0906Na) {
        this.A01 = c0906Na;
        return this;
    }

    public final Cdo A0B(String str) {
        this.A04 = str;
        return this;
    }

    public final Cdo A0C(String str) {
        this.A02 = str;
        return this;
    }

    public final Cdo A0D(String str) {
        this.A03 = str;
        return this;
    }

    public final Cdo A0E(boolean z2) {
        this.A05 = z2;
        return this;
    }

    public final C1471dq A0F() {
        return new C1471dq(this, null);
    }
}

package com.facebook.ads.redexgen.core;

import java.io.Serializable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Of, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0937Of implements Serializable {
    public C0936Oe A00;
    public C0936Oe A01;

    public C0937Of() {
        this(0.5d, 0.5d);
    }

    public C0937Of(double d3) {
        this(d3, 0.5d);
    }

    public C0937Of(double d3, double d4) {
        this.A00 = new C0936Oe(d3);
        this.A01 = new C0936Oe(d4);
        A02();
    }

    public final C0936Oe A00() {
        return this.A00;
    }

    public final C0936Oe A01() {
        return this.A01;
    }

    public final void A02() {
        this.A00.A07();
        this.A01.A07();
    }

    public final void A03() {
        this.A00.A08();
        this.A01.A08();
    }

    public final void A04(double d3, double d4) {
        this.A00.A09(d3, d4);
    }

    public final void A05(double d3, double d4) {
        this.A01.A09(d3, d4);
    }
}

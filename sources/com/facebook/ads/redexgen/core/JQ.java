package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class JQ {
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public J1 A06;
    public JP A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public long[] A0E = new long[0];
    public int[] A0C = new int[0];
    public int[] A0B = new int[0];
    public long[] A0D = new long[0];
    public boolean[] A0G = new boolean[0];
    public boolean[] A0F = new boolean[0];
    public final C04554v A0H = new C04554v();

    public final long A00(int i3) {
        return this.A0D[i3];
    }

    public final void A01() {
        this.A01 = 0;
        this.A05 = 0L;
        this.A09 = false;
        this.A08 = false;
        this.A0A = false;
        this.A07 = null;
    }

    public final void A02(int i3) {
        this.A0H.A0d(i3);
        this.A08 = true;
        this.A0A = true;
    }

    public final void A03(int i3, int i4) {
        this.A01 = i3;
        this.A00 = i4;
        if (this.A0C.length < i3) {
            this.A0E = new long[i3];
            this.A0C = new int[i3];
        }
        if (this.A0B.length < i4) {
            int i5 = (i4 * 125) / 100;
            this.A0B = new int[i5];
            this.A0D = new long[i5];
            this.A0G = new boolean[i5];
            this.A0F = new boolean[i5];
        }
    }

    public final void A04(C04554v c04554v) {
        c04554v.A0k(this.A0H.A0l(), 0, this.A0H.A0A());
        this.A0H.A0f(0);
        this.A0A = false;
    }

    public final void A05(InterfaceC1999ms interfaceC1999ms) throws IOException {
        interfaceC1999ms.readFully(this.A0H.A0l(), 0, this.A0H.A0A());
        this.A0H.A0f(0);
        this.A0A = false;
    }

    public final boolean A06(int i3) {
        return this.A08 && this.A0F[i3];
    }
}

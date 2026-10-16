package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class JO {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C2208qI A07;
    public final long[] A08;
    public final long[] A09;
    public final JP[] A0A;

    public JO(int i3, int i4, long j3, long j4, long j5, C2208qI c2208qI, int i5, JP[] jpArr, int i6, long[] jArr, long[] jArr2) {
        this.A00 = i3;
        this.A03 = i4;
        this.A06 = j3;
        this.A05 = j4;
        this.A04 = j5;
        this.A07 = c2208qI;
        this.A02 = i5;
        this.A0A = jpArr;
        this.A01 = i6;
        this.A08 = jArr;
        this.A09 = jArr2;
    }

    public final JP A00(int i3) {
        if (this.A0A == null) {
            return null;
        }
        return this.A0A[i3];
    }
}

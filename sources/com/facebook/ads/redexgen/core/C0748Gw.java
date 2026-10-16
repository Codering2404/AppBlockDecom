package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0748Gw {
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public final long A05;
    public final long A06;
    public final long A07;

    public C0748Gw(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.A06 = j3;
        this.A07 = j4;
        this.A03 = j5;
        this.A01 = j6;
        this.A02 = j7;
        this.A00 = j8;
        this.A05 = j9;
        this.A04 = A05(j4, j5, j6, j7, j8, j9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A00() {
        return this.A00;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A01() {
        return this.A02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A02() {
        return this.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03() {
        return this.A06;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A04() {
        return this.A07;
    }

    public static long A05(long j3, long j4, long j5, long bytesToSkip, long confidenceInterval, long j6) {
        if (bytesToSkip + 1 >= confidenceInterval || j4 + 1 >= j5) {
            return bytesToSkip;
        }
        long j7 = (long) ((j3 - j4) * ((confidenceInterval - bytesToSkip) / (j5 - j4)));
        return C5C.A0T(((bytesToSkip + j7) - j6) - (j7 / 20), bytesToSkip, confidenceInterval - 1);
    }

    private void A0B() {
        this.A04 = A05(this.A07, this.A03, this.A01, this.A02, this.A00, this.A05);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(long j3, long j4) {
        this.A01 = j3;
        this.A00 = j4;
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(long j3, long j4) {
        this.A03 = j3;
        this.A02 = j4;
        A0B();
    }
}

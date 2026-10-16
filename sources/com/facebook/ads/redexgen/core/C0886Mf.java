package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0886Mf {
    public final long A00;
    public final long A01;

    public C0886Mf(long j3, long j4) {
        this.A01 = j3;
        this.A00 = j4;
    }

    public final boolean A00(long j3, long j4) {
        return this.A00 == -1 ? j3 >= this.A01 : j4 != -1 && this.A01 <= j3 && j3 + j4 <= this.A01 + this.A00;
    }

    public final boolean A01(long j3, long j4) {
        return this.A01 <= j3 ? this.A00 == -1 || this.A01 + this.A00 > j3 : j4 == -1 || j3 + j4 > this.A01;
    }
}

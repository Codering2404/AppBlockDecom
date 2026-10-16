package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0751Gz {
    public static final C0751Gz A03 = new C0751Gz(-3, -9223372036854775807L, -1);
    public final int A00;
    public final long A01;
    public final long A02;

    public C0751Gz(int i3, long j3, long j4) {
        this.A00 = i3;
        this.A02 = j3;
        this.A01 = j4;
    }

    public static C0751Gz A03(long j3) {
        return new C0751Gz(0, -9223372036854775807L, j3);
    }

    public static C0751Gz A04(long j3, long j4) {
        return new C0751Gz(-1, j3, j4);
    }

    public static C0751Gz A05(long j3, long j4) {
        return new C0751Gz(-2, j3, j4);
    }
}

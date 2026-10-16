package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1907lC extends H2 {
    public C1907lC(AnonymousClass53 anonymousClass53, long j3, long j4) {
        super(new C2005mz(), new C1908lD(anonymousClass53), j3, 0L, j3 + 1, 0L, j4, 188L, 1000);
    }

    public static int A00(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8) | (bArr[i3 + 3] & 255);
    }
}

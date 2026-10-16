package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0929Nx implements XN {
    public static byte[] A01;
    public final /* synthetic */ NO A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{69, 81, 80, 75, 71, 72, 77, 71, 79};
    }

    public C0929Nx(NO no) {
        this.A00 = no;
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void ADS() {
        if (!this.A00.A0H && !this.A00.A0G) {
            this.A00.A0W(false, A00(0, 9, 80));
        }
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void AFV(float f3) {
    }
}

package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0959Pb implements InterfaceC1290au {
    public static byte[] A01;
    public final /* synthetic */ PZ A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-17, -19, -33, -20, -39, -36, -17, -32, -32, -33, -20, -33, -34, -39, -35, -26, -29, -35, -27, -39, -29, -37, -36, -39, -33, -14, -18, -33, -20, -24, -37, -26, -39, -24, -37, -16, -29, -31, -37, -18, -29, -23, -24};
    }

    public C0959Pb(PZ pz) {
        this.A00 = pz;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1290au
    public final void ADO() {
        this.A00.A0H();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1290au
    public final void AF0() {
        this.A00.A0I(A00(0, 43, 56));
    }
}

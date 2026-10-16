package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class JC extends AbstractRunnableC1135Wc {
    public static byte[] A01;
    public final /* synthetic */ C1424d4 A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-87, -68, -73, -72, -62, 115, -63, -72, -55, -72, -59, 115, -58, -57, -76, -59, -57, -72, -73, 115, -61, -65, -76, -52, -68, -63, -70};
    }

    public JC(C1424d4 c1424d4) {
        this.A00 = c1424d4;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        if (this.A00.A04) {
            return;
        }
        this.A00.A0I(A00(0, 27, 64));
    }
}

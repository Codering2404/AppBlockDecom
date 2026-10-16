package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.et, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1535et {
    A03,
    A04,
    A02;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-75, -55, -56, -61, -45, -57, -56, -75, -58, -56, -71, -72, -27, -26, -21, -10, -22, -21, -40, -23, -21, -36, -37, -61, -63, -77, -64, -51, -63, -62, -81, -64, -62, -77, -78};
    }

    static {
        A01();
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum V0 {
    A03,
    A02;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{104, 121, 109, 107, 125, 124, 110, 114, Ascii.DEL, 103, 119, 112, 121};
    }

    static {
        A01();
    }
}

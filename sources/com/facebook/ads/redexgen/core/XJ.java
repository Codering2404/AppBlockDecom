package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum XJ {
    A04,
    A03,
    A02;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{99, 100, 99, 126, 99, 107, 102, 99, 112, 111, 110, Ascii.DC2, Ascii.NAK, Ascii.DC2, Ascii.SI, Ascii.DC2, Ascii.SUB, Ascii.ETB, Ascii.DC2, 1, Ascii.DC2, Ascii.NAK, Ascii.FS, Ascii.CAN, Ascii.EM, 2, 9, Ascii.US, Ascii.CAN, Ascii.US, 2, Ascii.US, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.FF, 19, Ascii.DC2};
    }

    static {
        A01();
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum OD {
    A02,
    A06,
    A05,
    A07,
    A08,
    A03,
    A04;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{5, Ascii.DC4, 3, 7, Ascii.DC2, 3, 2, Ascii.CAN, Ascii.EM, Ascii.SI, 8, Ascii.SO, 19, 5, Ascii.EM, Ascii.CAN, 10, Ascii.GS, Ascii.GS, 0, Ascii.GS, 101, 102, 104, 109, 108, 109, 53, 54, 56, 61, 48, 55, 62, 46, 53, Framer.STDERR_FRAME_PREFIX, 42, 52, 51, 58, Ascii.FS, 7, 0, Ascii.CAN, 1};
    }

    static {
        A01();
    }
}

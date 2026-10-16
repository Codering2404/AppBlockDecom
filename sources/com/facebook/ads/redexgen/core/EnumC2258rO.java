package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.rO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC2258rO {
    A02,
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
        A00 = new byte[]{79, 68, 87, 68, 83, 94, 83, 68, 70, 72, 82, 85, 68, 83, 68, 69, 115, 100, 102, 104, 114, 117, 100, 115, 100, 101, Ascii.SO, Ascii.NAK, 9, Ascii.RS, Ascii.FS, Ascii.DC2, 8, Ascii.SI, Ascii.RS, 9, Ascii.RS, Ascii.US};
    }

    static {
        A01();
    }
}

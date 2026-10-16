package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1590fm {
    A04,
    A08,
    A07,
    A0A,
    A05,
    A02,
    A06,
    A03,
    A09;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-11, 8, -7, -7, -8, 5, -4, 1, -6, -27, -14, -14, -17, -14, -8, -13, -5, -12, -21, -36, -16, -18, -32, -33, Ascii.FF, 8, -3, Ascii.NAK, -2, -3, -1, 7, Ascii.ESC, -1, Ascii.VT, 9, Ascii.FF, 8, 1, Ascii.DLE, 1, 0, -23, -21, -34, -23, -38, -21, -34, -35, 47, Framer.STDOUT_FRAME_PREFIX, 36, 47, 32, Framer.STDOUT_FRAME_PREFIX, 40, Framer.STDIN_FRAME_PREFIX, 38, 19, Ascii.VT, 9, Ascii.DLE, Ascii.DLE, 5, 4, -14, -13, -32, -15, -13, -28, -29};
    }

    static {
        A01();
    }
}

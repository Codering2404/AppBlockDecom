package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1256aM {
    A03,
    A02,
    A07,
    A06,
    A04,
    A05;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{35, 40, 34, 57, 37, 39, 52, 34, 2, Ascii.CR, Ascii.SYN, Ascii.ETB, Ascii.DLE, Ascii.ESC, 7, 5, Ascii.SYN, 0, 37, Framer.STDIN_FRAME_PREFIX, 44, Framer.ENTER_FRAME_PREFIX, 61, 37, 55, 58, Framer.STDIN_FRAME_PREFIX, 43, 60, 41, 38, 47, 36, Framer.STDIN_FRAME_PREFIX, 78, 65, 84, 73, 86, 69, Framer.ENTER_FRAME_PREFIX, 35, 52, 46, 35, 52, 38, 48, 35, 53, 46, 34, Framer.STDERR_FRAME_PREFIX, 35, 52, 52, 63, 87, 64, 82, 68, 87, 65, 90, 86, 80, 70, 70, 64, 86, 86, 90, 86, 70, 87, 64, 64, 75};
    }

    static {
        A01();
    }
}

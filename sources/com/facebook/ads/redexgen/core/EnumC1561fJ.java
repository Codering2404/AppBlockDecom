package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1561fJ {
    A03,
    A02,
    A05,
    A04;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.FS, 19, Ascii.DC4, Ascii.DLE, Ascii.FS, 9, Ascii.CAN, Ascii.EM, 107, 100, 99, 103, 107, 126, 99, 100, 109, 107, 124, 111, 124, 107, 106, 124, 102, Framer.EXIT_FRAME_PREFIX, 119, 112, 116, Framer.EXIT_FRAME_PREFIX, 109, 124, 125, 91, 76, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 91, 90, 76, 86, 72, 71, 64, 68, 72, 93, 64, 71, 78};
    }

    static {
        A01();
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1259aP {
    A03,
    A02,
    A04;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{75, 78, 85, 73, 66, 69, 67, 73, 79, Framer.STDOUT_FRAME_PREFIX, 32, 55, 54, 59, 38, Framer.STDIN_FRAME_PREFIX, 62, 59, 60, 55, Framer.STDIN_FRAME_PREFIX, 36, 67, 107, 122, 109, 108, 97, 124, 119, 100, 97, 102, 109, 119, 126, Ascii.SUB, 119, 105, 102, 97, 101, 105, 124, 97, 103, 102};
    }

    static {
        A01();
    }
}

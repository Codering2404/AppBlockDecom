package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1941lk {
    A05,
    A04,
    A02,
    A03;

    public static byte[] A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{48, 59, 58, Framer.STDOUT_FRAME_PREFIX, 41, 46, 38, 35, 42, 43, 55, 54, Framer.STDIN_FRAME_PREFIX, 38, 43, 60, 56, 61, 32, 101, 114, 118, 115, 110};
    }

    static {
        A01();
    }
}

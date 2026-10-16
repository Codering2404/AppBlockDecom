package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum NF {
    A03(A00(37, 9, 98)),
    A05(A00(65, 9, 87)),
    A04(A00(46, 19, 70));

    public static byte[] A01;
    public final String A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{66, 85, 66, 74, 79, 66, 65, 79, 70, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, 78, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 69, 88, 71, 84, 78, 80, 85, 78, 93, 80, 72, 94, 68, 69, 8, 19, 19, 3, Ascii.SI, 17, Ascii.GS, Ascii.DLE, Ascii.DLE, 65, 86, 65, 73, 76, 65, 66, 76, 69, 106, 107, 91, 106, 101, 112, 109, 114, 97, 91, 101, 96, 91, 104, 101, 125, 107, 113, 112, 97, 122, 122, 74, 102, Framer.EXIT_FRAME_PREFIX, 116, 121, 121};
    }

    static {
        A01();
    }

    NF(String str) {
        this.A00 = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.A00;
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum XT {
    A04(0),
    A05(1),
    A03(2);

    public static byte[] A01;
    public final int A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{37, 56, 56, 35, Framer.STDERR_FRAME_PREFIX, 51, 101, 126, 123, 126, Ascii.DEL, 103, 126, 86, 77, 81, 76, 76, 87, 70, 71};
    }

    static {
        A01();
    }

    XT(int i3) {
        this.A00 = i3;
    }
}

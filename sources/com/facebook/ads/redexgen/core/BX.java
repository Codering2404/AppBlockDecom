package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class BX extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{52, 19, Ascii.ESC, Ascii.RS, Ascii.ETB, Ascii.SYN, 82, 6, Ascii.GS, 82, 3, 7, Ascii.ETB, 0, Ascii.VT, 82, 7, Ascii.FS, Ascii.SYN, Ascii.ETB, 0, Ascii.RS, Ascii.VT, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, Ascii.US, Ascii.ETB, Ascii.SYN, Ascii.ESC, 19, 82, 17, Ascii.GS, Ascii.SYN, Ascii.ETB, 17, 1};
    }

    public BX(Throwable th) {
        super(A00(0, 39, 35), th);
    }
}

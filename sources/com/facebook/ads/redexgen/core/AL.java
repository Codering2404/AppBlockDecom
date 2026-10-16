package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AL extends C2134p5 {
    public static byte[] A01;
    public final String A00;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-11, Ascii.SUB, 34, Ascii.CR, Ascii.CAN, Ascii.NAK, Ascii.DLE, -52, Ascii.SI, Ascii.ESC, Ascii.SUB, 32, 17, Ascii.SUB, 32, -52, 32, 37, Ascii.FS, 17, -26, -52};
    }

    public AL(String str, C04685i c04685i) {
        super(A01(0, 22, 85) + str, c04685i, AdError.INTERNAL_ERROR_2003, 1);
        this.A00 = str;
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class XL {
    public static byte[] A00;
    public static String[] A01 = {"qSiXKiq1IG9lqM50Z2Mb9O8Z2LWgBu", "r2U8xUOmaYVPqVNF7ipuwqUkClKOL9fI", "t2SmaoScOMFcI6wk6u94gycUTd7TrCEv", "g958mvzQCDN4laMR6tofpj9QKe8MWy18", "srt0ITOyv23HblPPEDvfXyJdFCTOXScH", "yBqqog3SgBsnKDzcKk1fPvagOkeR5j", "3gR", "V2iGxa"};

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.DLE, Ascii.ETB, Ascii.ESC, Ascii.CAN, Ascii.SO, 5, Ascii.SO, Ascii.ESC, Ascii.NAK, Ascii.SUB, 35, 32, 43, 44};
    }

    static {
        A02();
    }

    public static String A00(float f3) {
        if (A03(f3)) {
            return A01(10, 4, 69);
        }
        if (A05(f3)) {
            return A01(0, 4, 126);
        }
        if (A04(f3)) {
            return A01(4, 3, 96);
        }
        String strA01 = A01(7, 3, 112);
        String[] strArr = A01;
        if (strArr[0].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A01[4] = "joCrsBqpJwLPerzsPAAgEpnRec6YcWpS";
        return strA01;
    }

    public static boolean A03(float f3) {
        return f3 <= 0.7f;
    }

    public static boolean A04(float f3) {
        return f3 == 1.0f;
    }

    public static boolean A05(float f3) {
        return f3 >= 1.2f;
    }
}

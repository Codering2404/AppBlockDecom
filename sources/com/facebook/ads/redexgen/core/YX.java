package com.facebook.ads.redexgen.core;

import android.app.Activity;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class YX {
    public static byte[] A00;
    public static String[] A01 = {"fNLd7n7EkFNgLvt4vtbAtkfYXAQTEPRW", "T28d5tP6PdXMoXHWEuFSx", "qUncBokoif621v1GQ7gcKknRgizXPQsv", "IkdBxGtQCWxg3d0UA", "tTLCQWoYBdse5ixamGS9HTw2k7WXO8kY", "MyXxcbJBNTQUhn8S7mcX9rM3djOk", "ymwmgwOSW636xClV84tW2WEHiZAMdx7v", "xCAHRx5Y4"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = bArrCopyOfRange[i6];
            String[] strArr = A01;
            if (strArr[7].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A01[0] = "dZQs1GEaNPWr5rijC2ubsciPbAft3PPF";
            bArrCopyOfRange[i6] = (byte) ((b3 - i5) - 117);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.SI, Ascii.CR, Ascii.SYN, Ascii.CR, Ascii.SUB, 17, Ascii.VT};
    }

    static {
        A01();
    }

    public static void A02(Activity activity, int i3, C1648gi c1648gi) {
        try {
            activity.setRequestedOrientation(i3);
        } catch (IllegalStateException e3) {
            c1648gi.A08().ABz(A00(0, 7, 51), AbstractC1060Td.A0H, new C1061Te(e3));
        }
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1501eK {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-102, -110, -106, -107, -110, -108, -45, -30, -30, -47, -32, -45, -33, -41, -10, -9, 8, -5, -11, -9, -15, -1, 1, -10, -9, -2, -39, -36, -48, -50, -39, -46, -65, -61, 38, 42, Ascii.SYN, Framer.STDIN_FRAME_PREFIX, Ascii.FS, 41, -10, -25, -8, -6, -12, -21, -8, -27, -21, -12, -22, -10, -11, -17, -12, -6, -31, -35, -46, -22, -46, -45, -35, -42, -48, -33, -46, -34, -42, -56, -72, -57, -70, -70, -61, -76, -67, -70, -66, -68, -67, -55, Ascii.SYN, 6, Ascii.NAK, 8, 8, 17, 2, Ascii.SUB, Ascii.FF, 7, Ascii.ETB, Ascii.VT, -19, -34, -27, -39, -16, -33, -20, -19, -29, -23, -24, -1, -15, -1, -1, -11, -5, -6, -21, -11, -16};
    }

    public static Map<String, String> A01(T8 t8, String str, String str2) {
        HashMap map = new HashMap();
        C1071To c1071To = new C1071To(t8);
        int i3 = t8.getResources().getDisplayMetrics().widthPixels;
        int i4 = t8.getResources().getDisplayMetrics().heightPixels;
        map.put(A00(105, 10, 69), t8.A09().A02());
        map.put(A00(56, 13, 42), str2);
        map.put(A00(40, 16, 63), str);
        map.put(A00(14, 12, 75), String.valueOf(c1071To.A09()));
        map.put(A00(82, 12, 92), String.valueOf((int) (i3 / XX.A02)));
        map.put(A00(69, 13, 14), String.valueOf((int) (i4 / XX.A02)));
        map.put(A00(32, 2, 9), t8.A05().A9S());
        map.put(A00(34, 6, 112), C1071To.A04);
        map.put(A00(26, 6, 38), Locale.getDefault().toString());
        map.put(A00(94, 11, 51), A00(0, 6, 29));
        map.put(A00(6, 8, 43), c1071To.A05());
        return map;
    }
}

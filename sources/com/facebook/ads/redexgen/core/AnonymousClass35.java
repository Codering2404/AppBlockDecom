package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.35, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass35 {
    public static boolean A00;
    public static String A01;
    public static byte[] A02;
    public static String[] A03 = {"xIpC", "lOutcBeb", "y6lcWPY0M5vgnnr832pPoLFOGrBEwJN", "eNaaWw40USiw6vcri4oIxijcBQWus6T9", "W", "oHSXRLDm", "pbRsDBVUOoB3mv", "LvjaTOAqlauNDNt2xP6XrUFLIm1SBtnY"};
    public static final HashSet<String> A04;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        if (A03[0].length() == 28) {
            throw new RuntimeException();
        }
        A03[6] = "8";
        A02 = new byte[]{-61, -73, Framer.STDOUT_FRAME_PREFIX, 57, 57, Framer.STDOUT_FRAME_PREFIX, -8, 47, 66, 57, -8, Framer.STDIN_FRAME_PREFIX, 57, 60, 47};
    }

    static {
        A02();
        A00 = true;
        A04 = new HashSet<>();
        A01 = A01(2, 13, 107);
    }

    public static synchronized String A00() {
        return A01;
    }

    public static synchronized void A03(String str) {
        if (A04.add(str)) {
            A01 += A01(0, 2, 56) + str;
        }
    }
}

package com.facebook.ads.redexgen.core;

import android.os.PowerManager;
import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YV {
    public static byte[] A00;
    public static String[] A01 = {"CRKlMdJj7sWkVQXvhxP2gtYMKrwrdBdz", "MDVslC7yGiRJk7iB8DE8e8h4fEVrC5ER", "lH08WA", "RxIchMFZh", "vNyd6Jid8bvsA1cw15Ve5Ic9LBA7HcUI", "txgfdNfKSs8Co5f2ObGoVq", "d8ndlqqx7tIKNJdyWXTDq8r8sQB5dgXc", "5RbatCjsfF363SonahZsted9lIdQCMHb"};
    public static final String A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = bArrCopyOfRange[i6] - i5;
            String[] strArr = A01;
            if (strArr[4].charAt(3) != strArr[6].charAt(3)) {
                throw new RuntimeException();
            }
            A01[2] = "R3kMyn";
            bArrCopyOfRange[i6] = (byte) (i7 - 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{109, -96, -117, -115, -104, -100, -111, -105, -106, 72, -111, -106, 72, -101, -117, -102, -115, -115, -106, 72, -111, -106, -100, -115, -102, -119, -117, -100, -111, -98, -115, 72, -117, -112, -115, -117, -109, 84, 72, -119, -101, -101, -99, -107, -111, -106, -113, 72, -111, -106, -100, -115, -102, -119, -117, -100, -111, -98, -115, 86, -33, -34, -26, -44, -31, -69, -78, -68, -76, -62};
    }

    static {
        A01();
        A02 = YV.class.getSimpleName();
    }

    public static boolean A02(C1648gi c1648gi) {
        return A03(c1648gi) && YW.A03(c1648gi);
    }

    public static boolean A03(C1648gi c1648gi) {
        if (c1648gi == null) {
            return true;
        }
        try {
            return ((PowerManager) c1648gi.getSystemService(A00(60, 5, 91))).isInteractive();
        } catch (Exception e3) {
            Log.e(A02, A00(0, 60, 20), e3);
            c1648gi.A08().ABC(A00(65, 5, 53), AbstractC1060Td.A2S, new C1061Te(e3));
            return true;
        }
    }
}

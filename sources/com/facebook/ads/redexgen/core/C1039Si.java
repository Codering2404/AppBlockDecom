package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Si, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1039Si {
    public static InterfaceC1040Sj A00;
    public static boolean A01;
    public static byte[] A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-91, -88, -79, -90, -85, -80, -92, -75, -82};
    }

    static {
        A02();
        A01 = false;
        A00 = null;
    }

    public static void A01() {
        synchronized (C1039Si.class) {
            if (A00 == null) {
                return;
            }
            C1061Te c1061Te = new C1061Te(A00.AIb());
            c1061Te.A05(1);
            C1644ge c1644geA00 = T7.A00();
            if (c1644geA00 != null) {
                c1644geA00.A08().ABC(A00(0, 9, 49), 3401, c1061Te);
            }
            A00.reset();
        }
    }

    public static void A03(long j3) {
        if (j3 > 0) {
            A00 = new C1657gr();
            new C1041Sk(j3);
        }
    }
}

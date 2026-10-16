package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class IL extends AbstractRunnableC1135Wc {
    public static byte[] A01;
    public static String[] A02 = {"mPUp", "QaVG6HdjpkfaxAZj0g", "f", "awRGdU6dgRZhiPVlhe", "rFOzx0t9VnUrXKVKNhKeQ4JnbF82l9OW", "Jupus4hVDLzI", "SNB8L6kKTybUpjfk2kEtWCUyw", "zmy1APRNrfa5"};
    public final /* synthetic */ C5S A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-23, -4, -9, -8, 2, -77, 10, -12, 6, -77, 1, -8, 9, -8, 5, -77, 3, 5, -8, 3, -12, 5, -8, -9};
    }

    static {
        A01();
    }

    public IL(C5S c5s) {
        this.A00 = c5s;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        if (!this.A00.A0C) {
            C5S c5s = this.A00;
            String[] strArr = A02;
            if (strArr[2].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A02[3] = "r7zn";
            c5s.A0S(A00(0, 24, 121));
        }
    }
}

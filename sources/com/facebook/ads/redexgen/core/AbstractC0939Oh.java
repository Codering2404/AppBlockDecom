package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0939Oh {
    public static C0938Og A00;
    public static byte[] A01;
    public static String[] A02 = {"g", "j", "XC0Rp", "xmnbF", "ZVN1dtOIFAKzm8JTATZerxuQP9zv55g", "kSPLn3WG70", "", ""};

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = bArrCopyOfRange[i6] ^ i5;
            String[] strArr = A02;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "w";
            strArr2[0] = "P";
            bArrCopyOfRange[i6] = (byte) (i7 ^ 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{86, 90, 88, Ascii.ESC, 83, 84, 86, 80, 87, 90, 90, 94, Ascii.ESC, 84, 81, 70, Ascii.ESC, 116, 113, 106, 103, 112, 101, 122, 103, 97, 124, 123, 114, 106, 118, 122, 123, 115, 124, 114};
    }

    static {
        A02();
    }

    public static C0938Og A00(C1644ge c1644ge) {
        if (A00 == null) {
            synchronized (C0938Og.class) {
                if (A00 == null) {
                    A00 = new C0938Og(new C1736iB(c1644ge.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(0, 36, 105), c1644ge), 0)));
                }
            }
        }
        return A00;
    }
}

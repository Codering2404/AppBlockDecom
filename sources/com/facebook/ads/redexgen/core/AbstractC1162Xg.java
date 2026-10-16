package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1162Xg {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-16, -7, -3, Framer.STDOUT_FRAME_PREFIX, -85, -83, -83, 1, -2, -9};
    }

    public static String A01(long j3) {
        String string;
        String strA00 = A00(0, 0, 78);
        if (j3 < 1000) {
            string = j3 + strA00;
        } else {
            String strA002 = A00(0, 4, 79);
            if (j3 < 1000000) {
                StringBuilder sb = new StringBuilder();
                String formattedNumber = String.format(Locale.US, strA002, Double.valueOf(j3 / 1000.0d));
                StringBuilder sbAppend = sb.append(formattedNumber);
                String formattedNumber2 = A00(8, 1, 55);
                string = sbAppend.append(formattedNumber2).toString();
            } else if (j3 < 1000000000) {
                StringBuilder sb2 = new StringBuilder();
                String formattedNumber3 = String.format(Locale.US, strA002, Double.valueOf(j3 / 1000000.0d));
                StringBuilder sbAppend2 = sb2.append(formattedNumber3);
                String formattedNumber4 = A00(9, 1, 46);
                string = sbAppend2.append(formattedNumber4).toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                String formattedNumber5 = String.format(Locale.US, strA002, Double.valueOf(j3 / 1.0E9d));
                StringBuilder sbAppend3 = sb3.append(formattedNumber5);
                String formattedNumber6 = A00(7, 1, 67);
                string = sbAppend3.append(formattedNumber6).toString();
            }
        }
        String strA003 = A00(4, 3, 1);
        if (string.contains(strA003)) {
            return string.replace(strA003, strA00);
        }
        return string;
    }
}

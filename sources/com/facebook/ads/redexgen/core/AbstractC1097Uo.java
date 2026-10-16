package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1097Uo {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{62, 59, Framer.STDOUT_FRAME_PREFIX, 40, 0, 60, 48, Framer.STDOUT_FRAME_PREFIX, 57, 54, 56, 0, 44, 58, Framer.STDOUT_FRAME_PREFIX, 59, 0, 57, 61, 51, 48, 56, 54, Framer.STDOUT_FRAME_PREFIX, 0, 62, 44, 54, 59, Ascii.DEL, 122, 112, 105, 65, 119, 122, Framer.EXIT_FRAME_PREFIX, Ascii.DEL, 65, 108, 123, Framer.EXIT_FRAME_PREFIX, 108, 123, 109, 118, 65, 106, 119, 115, 123, 65, 115, 109, 94, 91, 81, 72, 96, 76, 87, 80, 74, 83, 91, 96, 76, 90, 81, 91, 96, 94, 79, 79, 96, 86, 81, 89, 80, 96, 86, 81, 96, 74, 76, 90, 77, 96, 94, 88, 90, 81, 75, 1, 4, Ascii.SO, Ascii.ETB, 63, Ascii.NAK, 19, 5, 63, 6, 2, 84, 1, 63, 9, 4, 122, Ascii.DEL, 117, 108, 68, 110, 104, 126, 68, 125, 121, 47, 122, 68, 114, Ascii.DEL, 68, 125, 114, 105, 104, 111, 64, 69, 79, 86, 126, 84, 82, 68, 83, 126, 64, 70, 68, 79, 85, 126, 83, 68, 71, 83, 68, 82, 73, 126, 85, 72, 76, 68, 126, 76, 82};
    }

    public static long A00(Context context) {
        return C1098Up.A0V(context).A33(A02(29, 25, 32), -1L);
    }

    public static long A01(Context context) {
        return C1098Up.A0V(context).A33(A02(131, 31, 31), -1L);
    }

    public static boolean A04(Context context) {
        return C1098Up.A0V(context).A38(A02(54, 39, 1), true);
    }

    public static boolean A05(Context context) {
        return C1098Up.A0V(context).A38(A02(0, 29, 97), false);
    }

    public static boolean A06(Context context) {
        return C1098Up.A0V(context).A38(A02(93, 16, 94), false);
    }

    public static boolean A07(Context context) {
        return C1098Up.A0V(context).A38(A02(109, 22, 37), false);
    }
}

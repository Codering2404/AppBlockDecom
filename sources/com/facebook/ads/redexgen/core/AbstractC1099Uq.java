package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1099Uq {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 34);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{58, 63, 53, 44, 4, 58, 53, 63, 41, 52, Framer.STDERR_FRAME_PREFIX, 63, 4, 58, 55, 55, 52, 44, 4, Framer.STDERR_FRAME_PREFIX, 58, 57, 4, 56, 52, 53, 47, 62, 35, 47, 4, 44, 41, 58, 43, 43, 62, 41, 4, 56, 41, 62, 58, 47, Framer.STDERR_FRAME_PREFIX, 52, 53, 32, 37, 47, 54, Ascii.RS, 32, 47, 37, 51, 46, 40, 37, Ascii.RS, 36, 47, 32, 35, Framer.STDIN_FRAME_PREFIX, 36, Ascii.RS, 40, 47, Ascii.RS, 32, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, Ascii.RS, 35, 51, 46, 54, Framer.STDERR_FRAME_PREFIX, 36, 51, Ascii.RS, 39, 40, Framer.STDIN_FRAME_PREFIX, 36, Ascii.RS, 34, 41, 46, 46, Framer.STDERR_FRAME_PREFIX, 36, 51, Ascii.VT, Ascii.SO, 4, Ascii.GS, 53, Ascii.VT, 4, Ascii.SO, Ascii.CAN, 5, 3, Ascii.SO, 53, Ascii.SI, 4, Ascii.VT, 8, 6, Ascii.SI, 53, 3, 4, 53, Ascii.VT, Ascii.SUB, Ascii.SUB, 53, 8, Ascii.CAN, 5, Ascii.GS, Ascii.EM, Ascii.SI, Ascii.CAN, 53, 4, Ascii.VT, Ascii.FS, 3, Ascii.CR, Ascii.VT, Ascii.RS, 3, 5, 4, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 98, 106, 105, 84, 98, 102, 123, 121, 100, 125, 110, 84, 105, 121, 100, 124, Framer.EXIT_FRAME_PREFIX, 98, 101, 108, 84, 104, 106, 123, 106, 105, 98, 103, 98, Ascii.DEL, 98, 110, Framer.EXIT_FRAME_PREFIX, 93, 88, 82, 75, 99, 89, 82, 93, 94, 80, 89, 99, 85, 93, 94};
    }

    public static boolean A02(Context context) {
        return C1098Up.A0V(context).A38(A00(0, 47, 121), true);
    }

    public static boolean A03(Context context) {
        return C1098Up.A0V(context).A38(A00(47, 47, 99), false);
    }

    public static boolean A04(Context context) {
        return C1098Up.A0V(context).A38(A00(139, 46, 41), false);
    }

    public static boolean A05(Context context) {
        return C1098Up.A0V(context).A38(A00(185, 15, 30), false);
    }

    public static boolean A06(Context context) {
        return C1098Up.A0V(context).A38(A00(94, 45, 72), false);
    }
}

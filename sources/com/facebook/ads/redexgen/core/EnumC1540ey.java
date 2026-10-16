package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ey, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1540ey {
    A04(A00(147, 33, 22)),
    A05(A00(SensibleDefaults.X_OFFSET, 36, 110)),
    A06(A00(216, 29, 107)),
    A03(A00(78, 32, 92)),
    A07(A00(110, 37, 90));

    public static byte[] A01;
    public String A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.DC4, 7, Ascii.SUB, Ascii.SI, Ascii.FS, Ascii.VT, 37, 7, 10, 37, 9, Ascii.DC2, Ascii.SI, 9, 17, -63, -76, -57, -68, -55, -72, -46, -74, -62, -64, -61, -65, -72, -57, -72, -35, -48, -29, -40, -27, -44, -18, -44, -35, -45, -18, -48, -46, -29, -40, -27, -40, -29, -24, -35, -48, -29, -40, -27, -44, -18, -44, -31, -31, -34, -31, -39, -52, -33, -44, -31, -48, -22, -44, -40, -37, -35, -48, -34, -34, -44, -38, -39, 41, 53, 51, -12, 44, 39, 41, 43, 40, 53, 53, Framer.STDOUT_FRAME_PREFIX, -12, 39, 42, 57, -12, 52, 39, 58, 47, 60, 43, -12, 39, 42, 37, 41, Framer.STDERR_FRAME_PREFIX, 47, 41, Framer.STDOUT_FRAME_PREFIX, 39, 51, Framer.STDOUT_FRAME_PREFIX, -14, 42, 37, 39, 41, 38, 51, 51, 47, -14, 37, 40, 55, -14, Framer.STDERR_FRAME_PREFIX, 37, 56, Framer.STDIN_FRAME_PREFIX, 58, 41, -14, 37, 40, 35, Framer.STDIN_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 52, 54, 41, 55, 55, Framer.STDIN_FRAME_PREFIX, 51, Framer.STDERR_FRAME_PREFIX, -29, -17, -19, -82, -26, -31, -29, -27, -30, -17, -17, -21, -82, -31, -28, -13, -82, -18, -31, -12, -23, -10, -27, -82, -29, -17, -19, -16, -20, -27, -12, -27, -28, 59, 71, 69, 6, 62, 57, 59, 61, 58, 71, 71, 67, 6, 57, 60, 75, 6, 70, 57, 76, 65, 78, 61, 6, 61, 70, 60, 55, 57, 59, 76, 65, 78, 65, 76, 81, 56, 68, 66, 3, 59, 54, 56, 58, 55, 68, 68, 64, 3, 54, 57, 72, 3, 67, 54, 73, 62, 75, 58, 3, 58, 71, 71, 68, 71};
    }

    static {
        A01();
    }

    EnumC1540ey(String str) {
        this.A00 = str;
    }

    public final String A03() {
        return this.A00;
    }
}

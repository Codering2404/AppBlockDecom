package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.el, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1527el {
    A06(101),
    A09(102),
    A0A(103),
    A07(104),
    A08(105),
    A05(106),
    A04(107),
    A03(108);

    public static byte[] A01;
    public final int A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-67, -52, -59, -40, -63, -46, -69, -53, -62, -67, -40, -56, -57, -40, -67, -66, -52, -51, -53, -56, -46, -20, -5, -12, 7, -16, 1, -22, -6, -15, -20, 7, -5, -13, -15, -8, -66, -51, -60, -60, -53, -69, -54, -67, -67, -58, -41, -50, -63, -68, -67, -57, -41, -50, -63, -67, -49, -41, -57, -58, -41, -68, -67, -53, -52, -54, -57, -47, 2, 7, Ascii.CR, -2, Ascii.VT, Ascii.FF, Ascii.CR, 2, Ascii.CR, 2, -6, 5, Ascii.CAN, Ascii.SI, 2, -3, -2, 8, Ascii.CAN, Ascii.SI, 2, -2, Ascii.DLE, Ascii.CAN, -3, -2, Ascii.FF, Ascii.CR, Ascii.VT, 8, Ascii.DC2, Ascii.DLE, 7, Ascii.EM, Framer.ENTER_FRAME_PREFIX, Ascii.CAN, Ascii.VT, 6, 7, 17, Framer.ENTER_FRAME_PREFIX, Ascii.VT, Ascii.DLE, Ascii.SYN, 7, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.VT, Ascii.SYN, Ascii.VT, 3, Ascii.SO, Framer.ENTER_FRAME_PREFIX, Ascii.DLE, 9, Ascii.SYN, Framer.ENTER_FRAME_PREFIX, 4, Ascii.ETB, Ascii.SYN, Ascii.SYN, 17, Ascii.DLE, 7, -2, Ascii.DLE, Ascii.CAN, Ascii.SI, 2, -3, -2, 8, Ascii.CAN, 2, 7, Ascii.CR, -2, Ascii.VT, Ascii.FF, Ascii.CR, 2, Ascii.CR, 2, -6, 5, Ascii.CAN, Ascii.CR, 8, 8, 5, -5, -6, Ascii.VT, Ascii.CAN, -4, 5, 8, Ascii.FF, -2, Ascii.CAN, -4, 5, 2, -4, 4, -2, -3, -35, -48, -30, -52, -35, -49, -48, -49, -22, -31, -44, -49, -48, -38, -22, -33, -38, -38, -41, -51, -52, -35, -22, -50, -41, -38, -34, -48, -22, -50, -41, -44, -50, -42, -48, -49, -39, -47, -49, -42, -27, -42, -46, -37, -51, -49, -44};
    }

    static {
        A01();
    }

    EnumC1527el(int i3) {
        this.A00 = i3;
    }

    public final int A03() {
        return this.A00;
    }
}

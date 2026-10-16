package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05588y extends Exception {
    public static byte[] A03;
    public final int A00;
    public final C2208qI A01;
    public final boolean A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-26, Ascii.SUB, 9, Ascii.SO, Ascii.DC4, -7, Ascii.ETB, 6, 8, Ascii.DLE, -59, Ascii.FS, Ascii.ETB, Ascii.SO, Ascii.EM, 10, -59, Ascii.VT, 6, Ascii.SO, 17, 10, 9, -33, -59};
    }

    public C05588y(int i3, C2208qI c2208qI, boolean z2) {
        super(A00(0, 25, 91) + i3);
        this.A02 = z2;
        this.A00 = i3;
        this.A01 = c2208qI;
    }
}

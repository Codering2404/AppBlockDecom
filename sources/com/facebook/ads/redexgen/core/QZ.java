package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QZ {
    public static byte[] A06;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public RK A04;
    public RK A05;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{118, 122, 60, 40, 53, 55, 2, 103, Ascii.SO, 2, 68, 80, 77, 79, 123, Ascii.US, 76, 64, Ascii.SO, 5, Ascii.ETB, 40, Ascii.SI, Ascii.FF, 4, 5, Ascii.DC2, 93, 86, 90, Ascii.SO, Ascii.NAK, 34, 71, 71, 75, Ascii.US, 4, Framer.STDERR_FRAME_PREFIX, 86, 109, 70, 79, 64, 73, 75, 103, 64, 72, 65, 85, 65, 66, 74, 102, 65, 66, 74, 75, 92, 19};
    }

    public QZ(RK rk, RK rk2) {
        this.A05 = rk;
        this.A04 = rk2;
    }

    public QZ(RK rk, RK rk2, int i3, int i4, int i5, int i6) {
        this(rk, rk2);
        this.A00 = i3;
        this.A01 = i4;
        this.A02 = i5;
        this.A03 = i6;
    }

    public final String toString() {
        return A00(40, 21, 109) + this.A05 + A00(16, 12, 35) + this.A04 + A00(0, 8, 25) + this.A00 + A00(8, 8, 97) + this.A01 + A00(28, 6, 57) + this.A02 + A00(34, 6, 40) + this.A03 + '}';
    }
}

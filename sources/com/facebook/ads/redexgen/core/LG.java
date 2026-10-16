package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class LG {
    public static byte[] A05;
    public int A00;
    public String A01;
    public final int A02;
    public final int A03;
    public final String A04;

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-81, 126, 124, -123, 124, -119, Framer.EXIT_FRAME_PREFIX, -117, 124, 101, 124, -114, 96, 123, 63, 64, 55, -124, -116, -118, -117, 55, 121, 124, 55, 122, Framer.EXIT_FRAME_PREFIX, -125, -125, 124, 123, 55, 121, 124, 125, -122, -119, 124, 55, -119, 124, -117, -119, -128, 124, -115, -128, -123, 126, 55, -128, 123, -118, 69};
    }

    public LG(int i3, int i4) {
        this(Integer.MIN_VALUE, i3, i4);
    }

    public LG(int i3, int i4, int i5) {
        String strA00 = A00(0, 0, 0);
        this.A04 = i3 != Integer.MIN_VALUE ? i3 + A00(0, 1, 112) : strA00;
        this.A02 = i4;
        this.A03 = i5;
        this.A00 = Integer.MIN_VALUE;
        this.A01 = strA00;
    }

    private void A01() {
        if (this.A00 != Integer.MIN_VALUE) {
        } else {
            throw new IllegalStateException(A00(1, 53, 7));
        }
    }

    public final int A03() {
        A01();
        return this.A00;
    }

    public final String A04() {
        A01();
        return this.A01;
    }

    public final void A05() {
        this.A00 = this.A00 == Integer.MIN_VALUE ? this.A02 : this.A00 + this.A03;
        this.A01 = this.A04 + this.A00;
    }
}

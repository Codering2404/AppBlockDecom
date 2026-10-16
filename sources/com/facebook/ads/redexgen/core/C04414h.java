package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04414h {
    public static byte[] A02;
    public int A00;
    public long[] A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-125, 119, -54, -64, -47, -68, 119, -64, -54, 119, -97, -60, -52, -73, -62, -65, -70, 118, -65, -60, -70, -69, -50, 118};
    }

    public C04414h() {
        this(32);
    }

    public C04414h(int i3) {
        this.A01 = new long[i3];
    }

    public final int A02() {
        return this.A00;
    }

    public final long A03(int i3) {
        if (i3 >= 0 && i3 < this.A00) {
            return this.A01[i3];
        }
        throw new IndexOutOfBoundsException(A00(10, 14, 43) + i3 + A00(0, 10, 44) + this.A00);
    }

    public final void A04(long j3) {
        if (this.A00 == this.A01.length) {
            this.A01 = Arrays.copyOf(this.A01, this.A00 * 2);
        }
        long[] jArr = this.A01;
        int i3 = this.A00;
        this.A00 = i3 + 1;
        jArr[i3] = j3;
    }

    public final long[] A05() {
        return Arrays.copyOf(this.A01, this.A00);
    }
}

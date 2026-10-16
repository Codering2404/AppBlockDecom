package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class UU {
    public static byte[] A02;
    public final int A00;
    public final int A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 34);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-85, -48, -40, -61, -50, -53, -58, -126, -53, -48, -58, -57, -38, -90, -57, -50, -42, -61, -126, -118, -121, -58, -114, -126, -53, -48, -58, -57, -38, -126, -97, -126, -121, -58, -117, -56, -53, -50, -57, -126, -118, -121, -58, -117, -126, -98, -126, -113, -109, -12, -9, -6, -13, -82, -53, -82, -77, -14, -82, -76, -76, -82, -9, -4, -14, -13, 6, -82, -53, -82, -77, -14, -47, -44, -41, -48, -117, -88, -88, -117, -104, -100, -117, -111, -111, -117, -44, -39, -49, -48, -29, -117, -88, -117, -112, -49};
    }

    public UU() {
        this(-1, -1);
    }

    public UU(int i3, int i4) {
        if (i3 < -1) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(35, 14, 64), Integer.valueOf(i3)));
        }
        if (i3 >= 0 && i4 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(49, 23, 108), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        if (i3 == -1 && i4 != -1) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(72, 24, 73), Integer.valueOf(i4)));
        }
        this.A00 = i3;
        this.A01 = i4;
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03() {
        return this.A01;
    }

    public final int A04(UU uu) {
        if (this.A00 != uu.A00) {
            return this.A00 - uu.A00;
        }
        return this.A01 - uu.A01;
    }

    public final UU A05(int i3) {
        if (this.A01 + i3 >= 0) {
            return new UU(this.A00, this.A01 + i3);
        }
        throw new IllegalArgumentException(String.format(Locale.US, A00(0, 35, 64), Integer.valueOf(i3), Integer.valueOf(this.A01)));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UU)) {
            return false;
        }
        UU uu = (UU) obj;
        return uu.A00 == this.A00 && uu.A01 == this.A01;
    }

    public final int hashCode() {
        return (this.A00 * 2) + (this.A01 * 3);
    }
}

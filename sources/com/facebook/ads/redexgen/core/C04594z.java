package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04594z {
    public static byte[] A02;
    public static final C04594z A03;
    public static final C04594z A04;
    public final int A00;
    public final int A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-28};
    }

    static {
        A01();
        A03 = new C04594z(-1, -1);
        A04 = new C04594z(0, 0);
    }

    public C04594z(int i3, int i4) {
        AbstractC04323y.A07((i3 == -1 || i3 >= 0) && (i4 == -1 || i4 >= 0));
        this.A01 = i3;
        this.A00 = i4;
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03() {
        return this.A01;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C04594z)) {
            return false;
        }
        C04594z c04594z = (C04594z) obj;
        return this.A01 == c04594z.A01 && this.A00 == c04594z.A00;
    }

    public final int hashCode() {
        return this.A00 ^ ((this.A01 << 16) | (this.A01 >>> 16));
    }

    public final String toString() {
        return this.A01 + A00(0, 1, 44) + this.A00;
    }
}

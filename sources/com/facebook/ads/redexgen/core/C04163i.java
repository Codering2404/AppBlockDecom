package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04163i {
    public static byte[] A04;
    public static final C04163i A05;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-23, -35, 32, 37, Ascii.RS, 43, 43, 34, 41, 0, 44, Framer.STDERR_FRAME_PREFIX, 43, Framer.STDOUT_FRAME_PREFIX, -6, Ascii.SO, 2, 71, 80, 69, 81, 70, 75, 80, 73, Ascii.US, -33, 19, 2, 7, Ascii.CR, -28, Ascii.CR, Ascii.DLE, Ascii.VT, -1, Ascii.DC2, -7, 17, -1, Ascii.VT, Ascii.SO, 10, 3, -16, -1, Ascii.DC2, 3, -37};
    }

    static {
        A01();
        A05 = new C04163i(-1, -1, -1);
    }

    public C04163i(int i3, int i4, int i5) {
        int iA06;
        this.A03 = i3;
        this.A01 = i4;
        this.A02 = i5;
        if (C5C.A15(i5)) {
            iA06 = C5C.A06(i5, i4);
        } else {
            iA06 = -1;
        }
        this.A00 = iA06;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C04163i)) {
            return false;
        }
        C04163i c04163i = (C04163i) obj;
        return this.A03 == c04163i.A03 && this.A01 == c04163i.A01 && this.A02 == c04163i.A02;
    }

    public final int hashCode() {
        return CB.A00(Integer.valueOf(this.A03), Integer.valueOf(this.A01), Integer.valueOf(this.A02));
    }

    public final String toString() {
        return A00(26, 23, 59) + this.A03 + A00(0, 15, 90) + this.A01 + A00(15, 11, 127) + this.A02 + ']';
    }
}

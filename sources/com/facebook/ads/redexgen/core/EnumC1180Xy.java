package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1180Xy {
    A08(0),
    A07(0),
    A06(1),
    A03(2),
    A04(3),
    A05(4);

    public static byte[] A01;
    public final int A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-63, -61, -74, -67, -64, -71, -45, -90, -69, -47, -45, -58, -51, -48, -55, -29, -73, -53, -97, -95, -108, -101, -98, -105, -79, -122, -103, -74, -72, -85, -78, -75, -82, -56, -78, -73, -67, -82, -69, -73, -82, -67, Ascii.DEL, -128, Ascii.DEL, 118, -67, -74, -77, -74, -73, -65, -74};
    }

    static {
        A01();
    }

    EnumC1180Xy(int i3) {
        this.A00 = i3;
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ve, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1113Ve {
    A06(-1, 100, 1, 0),
    A07(-1, 120, 2, 1),
    A08(-1, 300, 3, 2),
    A09(-1, RCHTTPStatusCodes.BAD_REQUEST, 4, 3),
    A0A(-1, 50, 5, 4),
    A0B(-1, -1, 6, 5);

    public static byte[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{Ascii.DLE, Ascii.GS, 17, Ascii.US, Ascii.DLE, Ascii.FF, 7, 105, 104, 104, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 94, 80, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 72, 38, 37, 39, 91, 86, 90, 84, 91, 71, 76, 32, 35, 35, 115, 126, 114, 124, 115, 111, 100, Ascii.SI, Ascii.VT, Ascii.VT, 91, 86, 90, 84, 91, 71, 76, 38, 35, 82, 69, 67, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 89, 78, 65, 77, 73, 67};
    }

    static {
        A02();
    }

    EnumC1113Ve(int i3, int i4, int i5, int i6) {
        this.A03 = i3;
        this.A01 = i4;
        this.A02 = i5;
        this.A00 = i6;
    }

    @Nullable
    public static EnumC1113Ve A00(int i3) {
        for (EnumC1113Ve enumC1113Ve : values()) {
            if (enumC1113Ve.A00 == i3) {
                return enumC1113Ve;
            }
        }
        return null;
    }

    public final int A04() {
        return this.A01;
    }

    public final int A05() {
        return this.A02;
    }

    public final int A06() {
        return this.A03;
    }
}

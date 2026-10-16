package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1634gU {
    A03(A01(37, 3, 126)),
    A04(A01(40, 7, 55));

    public static byte[] A01;
    public String A00;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 117);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{48, Framer.STDERR_FRAME_PREFIX, 58, 108, 75, 83, 68, 73, 76, 65, 5, 86, 64, 87, 83, 64, 87, 5, 87, 64, 86, 85, 74, 75, 86, 64, Ascii.US, 5, 0, 86, 51, 40, Framer.STDIN_FRAME_PREFIX, 40, 41, Framer.STDOUT_FRAME_PREFIX, 40, 106, 104, 96, 55, 44, 41, 44, Framer.STDIN_FRAME_PREFIX, 53, 44};
    }

    static {
        A02();
    }

    EnumC1634gU(String str) {
        this.A00 = str;
    }

    public static EnumC1634gU A00(String str) {
        for (EnumC1634gU enumC1634gU : values()) {
            if (enumC1634gU.A00.equals(str)) {
                return enumC1634gU;
            }
        }
        throw new IllegalArgumentException(String.format(Locale.US, A01(3, 27, 80), str));
    }
}

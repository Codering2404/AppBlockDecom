package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2220qW {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Framer.STDOUT_FRAME_PREFIX, 53, 46, 54, 51, 52, 116, 48, 44, 55, 116, 60, 47, 52, 57, 46, 51, 53, 52, 41, 116};
    }

    public final String A02(AY ay) {
        String string = ay.getClass().getGenericInterfaces()[0].toString();
        String strA00 = A00(0, 21, 12);
        return string.startsWith(strA00) ? string.substring(strA00.length()) : string;
    }

    public final String A03(AbstractC03741o abstractC03741o) {
        return A02(abstractC03741o);
    }
}

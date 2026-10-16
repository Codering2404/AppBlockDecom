package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class TR {
    public static byte[] A03;
    public final String A00;
    public final String A01;
    public final Map<String, String> A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{8, 101, 2, 0, Ascii.DC4, 6, 9, Ascii.NAK, 62, 4, Ascii.EM, 2, 4, 17, Ascii.NAK, 8, Ascii.SO, Ascii.SI, Ascii.GS, Ascii.SUB, Ascii.SI, Ascii.CR, 5, Ascii.SUB, Ascii.FS, Ascii.SI, Ascii.CR, Ascii.VT};
    }

    public TR(String str, Map<String, String> mStaticEnvironmentData) {
        this(str, mStaticEnvironmentData, false);
    }

    public TR(String str, Map<String, String> map, boolean z2) {
        this.A01 = str;
        this.A02 = map;
        this.A00 = z2 ? A00(1, 1, 37) : A00(0, 1, 73);
    }

    public final Map<String, String> A02() {
        HashMap map = new HashMap();
        map.put(A00(18, 10, 31), this.A01);
        map.put(A00(2, 16, 16), this.A00);
        Map<String, String> data = this.A02;
        map.putAll(data);
        return map;
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1486e5 {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final NR A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{89, 91, 72, 94, 89, 84, 78, 7, 5, Ascii.SYN, 0, Ascii.CR, 10, 0};
    }

    public C1486e5(int i3, int i4, NR nr) {
        this.A01 = i3;
        this.A00 = i4;
        this.A02 = nr;
    }

    public final int A02() {
        return this.A01;
    }

    public final NR A03() {
        return this.A02;
    }

    public final Map<String, String> A04() {
        HashMap map = new HashMap();
        StringBuilder sbAppend = new StringBuilder().append(this.A01);
        String strA00 = A00(0, 0, 41);
        map.put(A00(7, 7, 20), sbAppend.append(strA00).toString());
        map.put(A00(0, 7, 74), this.A00 + strA00);
        return map;
    }
}

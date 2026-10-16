package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1482e1 implements InterfaceC1597ft {
    public static byte[] A01;
    public final C1644ge A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{82, 39, 76, 72, 39, 90, 101, 101, 102, 39, 88, 101, Ascii.DEL, 126, 99, 100, 109, 39, 94, 101, 97, 111, 100, Ascii.FF, 10, Ascii.FS, Ascii.VT, 84, Ascii.CAN, Ascii.RS, Ascii.FS, Ascii.ETB, Ascii.CR};
    }

    public C1482e1(C1644ge c1644ge) {
        this.A00 = c1644ge;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1597ft
    public final Map<String, String> A6g(boolean z2) {
        HashMap map = new HashMap();
        if (!SZ.A00().A04()) {
            map.put(A00(0, 23, 64), UG.A00().A01(this.A00, true).A04());
        }
        map.put(A00(23, 10, 51), UJ.A06(new C1071To(this.A00), this.A00, z2));
        return map;
    }
}

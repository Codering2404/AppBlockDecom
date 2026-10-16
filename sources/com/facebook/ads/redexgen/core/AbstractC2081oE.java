package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2081oE implements InterfaceC04815v {
    public static byte[] A00;
    public static final boolean A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{32, 39, 53, 35, 35, 36, 54, 47, 58, Ascii.SYN, Ascii.SUB, 1, Ascii.DC4, Ascii.NAK};
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    static {
        /*
            A01()
            java.lang.String r3 = com.facebook.ads.redexgen.core.C5C.A05
            r2 = 8
            r1 = 6
            r0 = 91
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L38
            java.lang.String r3 = com.facebook.ads.redexgen.core.C5C.A06
            r2 = 4
            r1 = 4
            r0 = 66
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L34
            java.lang.String r3 = com.facebook.ads.redexgen.core.C5C.A06
            r2 = 0
            r1 = 4
            r0 = 65
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L38
        L34:
            r0 = 1
        L35:
            com.facebook.ads.redexgen.core.AbstractC2081oE.A01 = r0
            return
        L38:
            r0 = 0
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2081oE.<clinit>():void");
    }
}

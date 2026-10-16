package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class O6 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 76, 80, 73, 72, 121, 126, 100, 117, 98, 99, 100, 121, 100, 121, 113, 124, 101, 114, 96, 118, 101, 115, 114, 115, 72, 97, 126, 115, 114, Framer.EXIT_FRAME_PREFIX};
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x00da */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A02(com.facebook.ads.redexgen.core.C1648gi r11, com.facebook.ads.redexgen.core.C1054Sx r12, com.facebook.ads.redexgen.core.C05237l r13) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.O6.A02(com.facebook.ads.redexgen.X.gi, com.facebook.ads.redexgen.X.Sx, com.facebook.ads.redexgen.X.7l):void");
    }

    public static void A03(C1648gi c1648gi, C1054Sx c1054Sx, C05237l c05237l) {
        int i3 = 0;
        for (NR nr : c05237l.A2G()) {
            C1052Sv c1052Sv = new C1052Sv(nr.A0H().A08(), O1.A00(nr.A0H()), O1.A01(nr.A0H()), c05237l.A1D(), A00(5, 12, 118));
            if (i3 == 0) {
                c1054Sx.A0c(c1052Sv);
            } else {
                c1054Sx.A0d(c1052Sv);
            }
            O0.A00(c05237l, c1054Sx, A00(17, 14, 113));
            Iterator<String> it = nr.A0K().A02().iterator();
            while (it.hasNext()) {
                c1054Sx.A0d(new C1052Sv(it.next(), -1, -1, c05237l.A1D(), A00(5, 12, 118)));
            }
            if (!TextUtils.isEmpty(nr.A0H().A09())) {
                new C1050St(nr.A0H().A09(), c05237l.A1D(), A00(5, 12, 118), nr.A0H().A06()).A04 = false;
            }
            i3++;
        }
    }
}

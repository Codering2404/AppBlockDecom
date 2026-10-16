package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class O5 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.VT, 77, 81, 72, 73, 93, 90, 64, 81, 70, 71, 64, 93, 64, 93, 85, 88};
    }

    public static void A02(C1648gi c1648gi, AbstractC1813jd abstractC1813jd, boolean z2, O3 o3) {
        if (!C1098Up.A2E(c1648gi)) {
            C1054Sx c1054Sx = new C1054Sx(c1648gi);
            C0920No c0920NoA07 = abstractC1813jd.A29().A0H().A07();
            c1054Sx.A0e(new VI(abstractC1813jd.A2E(), c1648gi.A0A()));
            if (c0920NoA07 == null) {
                o3.AFF(AdError.CACHE_ERROR);
                return;
            }
            if (c0920NoA07.A0Y()) {
                o3.AFG();
                return;
            }
            C1050St c1050St = new C1050St(c0920NoA07.A0L(), abstractC1813jd.A1D(), abstractC1813jd.A10());
            c1050St.A04 = true;
            c1050St.A03 = A00(0, 5, 86);
            switch (O2.A00[c0920NoA07.A0G().ordinal()]) {
                case 1:
                case 2:
                    c1054Sx.A0Y(c1050St);
                    break;
            }
            c1054Sx.A0c(new C1052Sv(abstractC1813jd.A2C().A01(), -1, -1, abstractC1813jd.A1D(), abstractC1813jd.A10()));
            c1054Sx.A0c(new C1052Sv(c0920NoA07.A0K(), -1, -1, abstractC1813jd.A1D(), abstractC1813jd.A10()));
            O0.A00(abstractC1813jd, c1054Sx, A00(5, 12, 71));
            c1054Sx.A0X(new C1791jA(c1648gi, o3, c1054Sx, c0920NoA07, z2), new C1047Sq(abstractC1813jd.A1D(), abstractC1813jd.A10()));
            return;
        }
        o3.AFG();
    }
}

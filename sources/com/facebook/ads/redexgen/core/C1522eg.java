package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1522eg {
    public static byte[] A09;
    public final C0685Ek A02;
    public final C1752iS A05;
    public final String A06;
    public final Map<String, String> A07;
    public final boolean A08;
    public final E7 A04 = new E7() { // from class: com.facebook.ads.redexgen.X.4R
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4F c4f) {
            C1753iT c1753iT = new C1753iT(this.A00.A06, c4f.A03(), c4f.A01(), c4f.A02());
            if (c4f.A00() >= 0.05d) {
                c1753iT.A06(c4f.A01());
            }
            C1522eg.A00(this.A00);
            this.A00.A05.A04(c1753iT);
        }
    };
    public final EA A03 = new EA() { // from class: com.facebook.ads.redexgen.X.4Q
        public static String[] A01 = {"6BCUDqBTxMKsyDySTDfAgToNrOyTrTD7", "Djf66yrzqq1vnadUmdmWvJcbyzxtAl6k", "tEWjotQxZjNCyKq2vbPJS9KAzb4A3hxJ", "kfWCXMrmmpdmvn7", "tPgONuxPqcgn4e0Z", "11TiM4f61A8Ladhbi7mmvNycAncH9GAZ", "vRuUugy6JKGdIehMZ73GXeup75bhp5n7", "ksJD2q6S6mSNkSfcUAtwhZVbKKRTJPP1"};

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(C4K c4k) {
            if (this.A00.A08) {
                C1522eg c1522eg = this.A00;
                String[] strArr = A01;
                if (strArr[0].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A01[3] = "Cld5vqCsdzETAPzY9HB959";
                c1522eg.A07();
            }
        }
    };
    public int A01 = 0;
    public int A00 = 0;

    static {
        A04();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-116, -99, -116, -107, -101, -122, -112, -107, -117, -116, -97, 3, Ascii.SI, -2, 10, 2, -4, 0, Ascii.FF, Ascii.DC2, Ascii.VT, 17, -90, -78, -95, -83, -91, -77};
    }

    public C1522eg(C0685Ek c0685Ek, String str, boolean z2, Map<String, String> map) {
        this.A06 = str;
        this.A02 = c0685Ek;
        this.A07 = map;
        this.A08 = z2;
        this.A05 = new C1752iS(this.A06);
        this.A02.getEventBus().A03(this.A04, this.A03);
    }

    public static /* synthetic */ int A00(C1522eg c1522eg) {
        int i3 = c1522eg.A01;
        c1522eg.A01 = i3 + 1;
        return i3;
    }

    public final Map<String, String> A06() {
        String strA01 = C1752iS.A01(this.A05.A03());
        HashMap map = new HashMap();
        if (this.A07 != null) {
            map.putAll(this.A07);
        }
        if (strA01 == null) {
            strA01 = A02(0, 0, 25);
        }
        map.put(A02(22, 6, 33), strA01);
        map.put(A02(11, 11, 126), String.valueOf(this.A01));
        int i3 = this.A00 + 1;
        this.A00 = i3;
        map.put(A02(0, 11, 8), String.valueOf(i3));
        return map;
    }

    public final void A07() {
        this.A02.getEventBus().A04(this.A04, this.A03);
    }
}

package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05187g extends AbstractC1783j0 {
    public static byte[] A00;
    public static String[] A01 = {"5V5lzA70kRKZvNcqBnXwT00Z041t6ONl", "kRuh8LYE7MIIox", "vbi5lrus1TtIcXopJBSqGum5Kl452Sg0", "JcNQ6WafPgnmx1aBDePIhrwzaceROyrU", "60x4BO5hhvvMWgz", "65jgyaanPJJ2TdYJaJc79ygQBnrUrWFq", "zOX7nuTxFizV3LeqTcyyEc2wd", "PvIxiwPRiyIOar7lINjn4bFuW"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{42, 47, 107, 34, 56, 107, 37, 36, 63, 107, 57, 46, 42, 47, Framer.STDERR_FRAME_PREFIX, 107, 36, 57, 107, 42, 39, 57, 46, 42, 47, Framer.STDERR_FRAME_PREFIX, 107, 47, 34, 56, 59, 39, 42, Framer.STDERR_FRAME_PREFIX, 46, 47, Ascii.DC4, Ascii.NAK, Ascii.FS, 17, 9};
    }

    static {
        A03();
    }

    public C05187g(C1648gi c1648gi, O7 o7) {
        super(c1648gi, o7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01(long j3) {
        HashMap map = new HashMap();
        map.put(A00(36, 5, 12), String.valueOf(System.currentTimeMillis() - j3));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(List<String> trackingUrls, Map<String, String> extraData) {
        if (trackingUrls != null) {
            boolean zIsEmpty = trackingUrls.isEmpty();
            if (A01[3].charAt(25) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "86KHDrV9NKgfIZAVdUdv4tP2w";
            strArr[7] = "hnWt117Y9rLxZfnYOmFuZ36IL";
            if (zIsEmpty) {
                return;
            }
            Iterator<String> it = trackingUrls.iterator();
            while (it.hasNext()) {
                new AsyncTaskC1619gF(this.A0B, extraData).execute(it.next());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0P() {
        C1830ju c1830ju = (C1830ju) this.A01;
        if (c1830ju.A0R()) {
            N2 n22 = this.A07;
            if (A01[3].charAt(25) != 'c') {
                throw new RuntimeException();
            }
            A01[4] = "SmlVqZ";
            if (n22 != null) {
                this.A07.A0B(c1830ju);
                return;
            }
            return;
        }
        throw new IllegalStateException(A00(0, 36, 55));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0R(N1 n12, C1079Tw c1079Tw, C1077Tu c1077Tu, O8 o8) {
        C1830ju c1830ju = (C1830ju) n12;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1780ix c1780ix = new C1780ix(this, o8, c1830ju, jCurrentTimeMillis, c1077Tu);
        A0H().postDelayed(c1780ix, c1079Tw.A05().A05());
        c1830ju.A0L(this.A0B, new C1779iw(this, c1780ix, jCurrentTimeMillis, c1077Tu), this.A09, o8, UK.A0K());
    }
}

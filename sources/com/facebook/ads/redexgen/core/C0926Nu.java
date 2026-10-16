package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0926Nu {
    public static byte[] A05;
    public static String[] A06 = {"SwW", "nKJOmWTx3LjNZvOp7YbBROgXIyGkfXUh", "cNvS8LZQYgXEdOP85dYAvAy4C3J", "ICxq6EmLG0dgZi7UJ5PBV2wBsvrmCfpb", "tKedy3gZYTLe", "bmz0vq", "hvIAQTYE0cdtFIL2", "tj9oqRvQS19ndgZTuA"};
    public C1054Sx A00;
    public EnumC1309bD A01 = EnumC1309bD.A05;
    public ArrayList<C1432dC> A02 = new ArrayList<>();
    public final NQ A03;
    public final InterfaceC0925Nt A04;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-35, Ascii.ETB, 35, Ascii.FS, Ascii.ESC, -66, -29, -23, -38, -25, -29, -42, -31, -107, -70, -25, -25, -28, -25, -107, -89, -91, -91, -85, -107, -20, -34, -23, -35, -28, -22, -23, -107, -42, -107, -21, -42, -31, -34, -39, -107, -74, -39, -66, -29, -37, -28, -93, Ascii.NAK, Ascii.CAN, 19, Ascii.CAN, Ascii.NAK, 40, Ascii.NAK, 19, Ascii.SYN, 41, 34, Ascii.CAN, 32, Ascii.EM, -29, -14, -21, -36, -31, -38, -30, -25, -40, -23, -38, -21, -38, -26, -20, Ascii.DC2, Ascii.ETB, Ascii.DLE, Ascii.CAN, Ascii.GS, Ascii.DC4, 19, -16, 19, -13, Ascii.DLE, 35, Ascii.DLE, -15, 36, Ascii.GS, 19, Ascii.ESC, Ascii.DC4, 63, 68, 74, 59, 72, 73, 74, 63, 74, 63, 55, 66};
    }

    static {
        A06();
    }

    public C0926Nu(C1648gi c1648gi, O8 o8, InterfaceC0925Nt interfaceC0925Nt, String str) {
        JSONObject dataObject = o8.A03();
        this.A03 = A01(c1648gi, o8, str, dataObject);
        this.A04 = interfaceC0925Nt;
    }

    private AdError A00(C1648gi c1648gi, AbstractC1813jd abstractC1813jd) {
        if (abstractC1813jd == null || abstractC1813jd.A2G().isEmpty()) {
            c1648gi.A08().ABC(A04(62, 3, 33), AbstractC1060Td.A0Z, new C1061Te(A04(5, 43, 20)));
            return AdError.internalError(AdError.INTERNAL_ERROR_2006);
        }
        return null;
    }

    public static NQ A01(C1648gi c1648gi, O8 o8, String str, JSONObject jSONObject) {
        NQ nqA00 = null;
        if (jSONObject.has(A04(65, 12, 24))) {
            try {
                nqA00 = C1807jT.A01(jSONObject, c1648gi, true);
                nqA00.A1Q(true);
                nqA00.A1N(A04(96, 12, 117));
            } catch (JSONException unused) {
            }
        }
        if (nqA00 == null) {
            nqA00 = C05257n.A00(jSONObject, c1648gi);
        }
        nqA00.A1M(str);
        C1080Tx c1080TxA01 = o8.A01();
        if (c1080TxA01 != null) {
            nqA00.A1I(c1080TxA01.A06());
        }
        return nqA00;
    }

    private C1054Sx A03(C1648gi c1648gi) {
        return this.A00 != null ? this.A00 : new C1054Sx(c1648gi);
    }

    private void A08(C1648gi c1648gi, C05257n c05257n) {
        C0920No playableData = c05257n.A29().A0H().A07();
        A0B(playableData != null ? playableData.A0H() : EnumC1309bD.A05);
        C1793jC c1793jC = new C1793jC(this);
        C1054Sx c1054Sx = new C1054Sx(c1648gi);
        boolean z2 = C1098Up.A2H(c1648gi) && SN.A0A(c05257n.A1H());
        if (z2) {
            SN unifiedAssetsLoader = new SN(c1054Sx, c05257n.A1H(), c05257n.A10(), c05257n.A1D(), z2, new C1792jB(this));
            c1054Sx.A0e(new VI(c05257n.A2E(), c1648gi.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        O5.A02(c1648gi, c05257n, true, c1793jC);
    }

    private void A09(C1648gi c1648gi, EnumSet<CacheFlag> enumSet, AbstractC1813jd abstractC1813jd, int i3, InterfaceC0925Nt interfaceC0925Nt) {
        boolean isDSL = abstractC1813jd.A1g();
        C1054Sx c1054SxA03 = A03(c1648gi);
        c1054SxA03.A0e(new VI(abstractC1813jd.A2E(), c1648gi.A0A()));
        boolean z2 = C1098Up.A2H(c1648gi) && SN.A0A(abstractC1813jd.A1H());
        if (z2) {
            new SN(c1054SxA03, abstractC1813jd.A1H(), abstractC1813jd.A10(), abstractC1813jd.A1D(), z2, new C1796jF(this, c1648gi, isDSL, abstractC1813jd, interfaceC0925Nt)).A0B();
            return;
        }
        String strA04 = A04(96, 12, 117);
        if (isDSL) {
            C1050St c1050St = new C1050St(abstractC1813jd.A0x(), abstractC1813jd.A1D(), strA04);
            c1050St.A04 = true;
            c1050St.A03 = A04(0, 5, 78);
            c1054SxA03.A0Y(c1050St);
        }
        c1054SxA03.A0d(new C1052Sv(abstractC1813jd.A2C().A01(), C1485e4.A04, C1485e4.A04, abstractC1813jd.A1D(), A04(96, 12, 117)));
        boolean isUnifiedAssetsLoaderEnabled = enumSet.contains(CacheFlag.VIDEO);
        int i4 = 0;
        boolean zA30 = C1098Up.A30(c1648gi, C1575fX.A03());
        for (NR nr : abstractC1813jd.A2G()) {
            C1052Sv c1052Sv = new C1052Sv(nr.A0H().A08(), O1.A00(nr.A0H()), O1.A01(nr.A0H()), abstractC1813jd.A1D(), A04(96, 12, 117));
            if (i4 == 0) {
                c1054SxA03.A0c(c1052Sv);
            } else {
                c1054SxA03.A0d(c1052Sv);
            }
            Iterator<String> it = nr.A0K().A02().iterator();
            while (it.hasNext()) {
                c1054SxA03.A0d(new C1052Sv(it.next(), -1, -1, abstractC1813jd.A1D(), A04(96, 12, 117)));
            }
            if (isUnifiedAssetsLoaderEnabled && !TextUtils.isEmpty(nr.A0H().A09())) {
                C1050St c1050St2 = new C1050St(nr.A0H().A09(), abstractC1813jd.A1D(), A04(96, 12, 117), nr.A0H().A06());
                c1050St2.A04 = false;
                if (i4 == 0) {
                    if (isDSL && !zA30) {
                        c1054SxA03.A0Y(c1050St2);
                    } else {
                        c1054SxA03.A0b(c1050St2);
                    }
                } else if (isDSL && !zA30) {
                    c1054SxA03.A0Z(c1050St2);
                } else {
                    c1054SxA03.A0a(c1050St2);
                }
            }
            i4++;
        }
        if (abstractC1813jd.A1W() && !TextUtils.isEmpty(abstractC1813jd.A11())) {
            c1054SxA03.A0d(new C1052Sv(abstractC1813jd.A11(), C0962Pe.A0A, C0962Pe.A0A, abstractC1813jd.A1D(), A04(96, 12, 117)));
        }
        O0.A00(abstractC1813jd, c1054SxA03, strA04);
        c1054SxA03.A0X(new C1794jD(this, c1648gi, isDSL, abstractC1813jd, interfaceC0925Nt), new C1047Sq(abstractC1813jd.A1D(), strA04, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C1648gi c1648gi, EnumSet<CacheFlag> enumSet, C1807jT c1807jT, AbstractC1813jd abstractC1813jd, int i3, InterfaceC0925Nt interfaceC0925Nt) {
        A09(c1648gi, enumSet, abstractC1813jd, i3, new C1798jH(this, c1648gi, abstractC1813jd, c1807jT, i3, interfaceC0925Nt, enumSet));
    }

    private void A0B(EnumC1309bD enumC1309bD) {
        this.A01 = enumC1309bD;
    }

    private boolean A0C(C1648gi c1648gi, AbstractC1813jd abstractC1813jd) {
        AdError adErrorA00 = A00(c1648gi, abstractC1813jd);
        if (adErrorA00 != null) {
            this.A04.ACo(adErrorA00);
            return true;
        }
        return false;
    }

    public final NQ A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        return com.facebook.ads.redexgen.core.WK.A0C;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.WK A0E() {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.NQ r0 = r5.A03
            boolean r0 = r0.A1b()
            if (r0 == 0) goto Lb
            com.facebook.ads.redexgen.X.WK r0 = com.facebook.ads.redexgen.core.WK.A04
            return r0
        Lb:
            com.facebook.ads.redexgen.X.NQ r4 = r5.A03
            com.facebook.ads.redexgen.X.jd r4 = (com.facebook.ads.redexgen.core.AbstractC1813jd) r4
            boolean r0 = r4.A1g()
            if (r0 == 0) goto L18
            com.facebook.ads.redexgen.X.WK r0 = com.facebook.ads.redexgen.core.WK.A06
            return r0
        L18:
            java.util.List r0 = r4.A2G()
            int r1 = r0.size()
            r0 = 1
            if (r1 <= r0) goto L26
            com.facebook.ads.redexgen.X.WK r0 = com.facebook.ads.redexgen.core.WK.A0A
            return r0
        L26:
            com.facebook.ads.redexgen.X.NR r0 = r4.A29()
            com.facebook.ads.redexgen.X.NU r0 = r0.A0H()
            com.facebook.ads.redexgen.X.No r3 = r0.A07()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C0926Nu.A06
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 14
            if (r1 == r0) goto L9f
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C0926Nu.A06
            java.lang.String r1 = "HO5lN2vl3hawZ3xdOTbB4PXxItmZOFKM"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "QabHGQsenJFHZf5mHftqzVXi6FXcwsQx"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L7a
            boolean r0 = r4.A1n()
            if (r0 != 0) goto L71
            boolean r3 = r4.A1u()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C0926Nu.A06
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto L74
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C0926Nu.A06
            java.lang.String r1 = "iV2CDA2M2IfUZLXvhnmiNr1pV0Sur2CQ"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "GDT4frbvCKvkZrCQcOaJTMqN9T6RIdn0"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L77
        L71:
            com.facebook.ads.redexgen.X.WK r0 = com.facebook.ads.redexgen.core.WK.A0E
            return r0
        L74:
            if (r3 == 0) goto L77
            goto L71
        L77:
            com.facebook.ads.redexgen.X.WK r0 = com.facebook.ads.redexgen.core.WK.A0C
            return r0
        L7a:
            boolean r3 = r5.A0L(r4)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C0926Nu.A06
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto L99
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C0926Nu.A06
            java.lang.String r1 = "iDu"
            r0 = 0
            r2[r0] = r1
            if (r3 == 0) goto L96
            com.facebook.ads.redexgen.X.WK r0 = com.facebook.ads.redexgen.core.WK.A0D
            return r0
        L96:
            com.facebook.ads.redexgen.X.WK r0 = com.facebook.ads.redexgen.core.WK.A0B
            return r0
        L99:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L9f:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0926Nu.A0E():com.facebook.ads.redexgen.X.WK");
    }

    public final EnumC1309bD A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A1b()) {
            return ((C1807jT) this.A03).A2A();
        }
        return ((AbstractC1813jd) this.A03).A2E();
    }

    public final void A0H() {
        this.A04.AKX();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A1K(rewardData);
        this.A03.A1O(str);
        if (A0D().A1b()) {
            intent.putExtra(A04(77, 19, 78), this.A03);
        }
        intent.putExtra(A04(48, 14, 83), this.A03);
    }

    public final void A0J(C1648gi c1648gi, EnumSet<CacheFlag> enumSet) {
        if (A0E() == WK.A04) {
            C1807jT c1807jT = (C1807jT) this.A03;
            AbstractC1813jd abstractC1813jdA26 = c1807jT.A26();
            if (A0C(c1648gi, abstractC1813jdA26) || abstractC1813jdA26 == null) {
                return;
            }
            this.A04.AHY();
            A0A(c1648gi, enumSet, c1807jT, abstractC1813jdA26, 0, this.A04);
            return;
        }
        AbstractC1813jd abstractC1813jd = (AbstractC1813jd) this.A03;
        if (A06[5].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "h3j4XQE4N9RDZ4AU6tvjsFYKX3e30HKG";
        strArr[3] = "lDhcJ7lgFtqhZjTb781X3zaoWDc2BWUc";
        if (A0C(c1648gi, abstractC1813jd)) {
            return;
        }
        this.A04.AHY();
        if (A0E() == WK.A0C) {
            C05257n c05257n = (C05257n) this.A03;
            String[] strArr2 = A06;
            if (strArr2[2].length() != strArr2[6].length()) {
                A06[7] = "0uVLF1bkkTEn2WeYm46QMmOd1A6";
                A08(c1648gi, c05257n);
                return;
            } else {
                A08(c1648gi, c05257n);
                return;
            }
        }
        A09(c1648gi, enumSet, (C05257n) this.A03, -1, this.A04);
    }

    public final boolean A0K() {
        return this.A03.A1U();
    }

    public final boolean A0L(AbstractC1813jd abstractC1813jd) {
        return !TextUtils.isEmpty(abstractC1813jd.A29().A0H().A09());
    }
}

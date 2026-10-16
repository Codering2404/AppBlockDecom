package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Log;
import android.widget.LinearLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.81, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass81<NativeViewabilityLogger> implements InterfaceC1844k8 {
    public static byte[] A0J;
    public static String[] A0K = {"NhwOmA8H17maQr2Thm3XPPVG1xwEsLhZ", "rranxCubAcBFDRhPr2LDrxoK3htxcyeL", "LmhV8", "ZLGOK7uKxyyp5W3sNEqoBEODv8zXcPE1", "dNK0bBZMrDk2YJmjrhSzlk1RMTFmUAsD", "q33l17MPfjO0fzYSahPh7EE95Ux5x03H", "4VfBn9Mh4W5rafl7A4va0uDeREUgOp63", "NLrbv196ww605txiYhOndsfSQjY"};
    public static final String A0L;
    public N9 A00;
    public NA A01;
    public C1821jl A02;
    public C05267o A03;
    public AnonymousClass76 A04;
    public VA A05;
    public EnumC1122Vp A06;
    public InterfaceC1297b1 A07;
    public LV A08;
    public AnonymousClass62 A09;
    public AbstractC1592fo A0A;
    public C1593fp A0B;
    public String A0D;
    public final String A0I = UUID.randomUUID().toString();
    public boolean A0E = false;
    public boolean A0F = false;
    public boolean A0G = false;
    public final Y2 A0H = new Y2();
    public Boolean A0C = false;

    public static String A08(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A0J = new byte[]{Ascii.FS, 40, 38, -25, Ascii.US, Ascii.SUB, Ascii.FS, Ascii.RS, Ascii.ESC, 40, 40, 36, -25, Ascii.SUB, Ascii.GS, 44, -25, Ascii.ESC, Ascii.SUB, 39, 39, Ascii.RS, 43, -25, Ascii.FS, 37, 34, Ascii.FS, 36, Ascii.RS, Ascii.GS, -15, -30, -11, -15, -84, -27, -15, -22, -23, -21, -22, -36, -93, -82};
    }

    static {
        A0B();
        A0L = AnonymousClass81.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A0A() {
        if (this.A00 != null && this.A09 != null && this.A03 != null && this.A03.A1g()) {
            this.A00.ADD(this, this.A09);
        }
        if (this.A00 != null) {
            boolean z2 = this.A0E;
            if (A0K[1].charAt(21) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[6] = "pcQhCrMOoUvf1wSUiS8eXhj7G6bioSrh";
            strArr[4] = "JWZBC7ZhFf7k7YrTz5pa22tV9NT1Mc4w";
            if (z2 && (this.A0F || !this.A0G)) {
                N9 n9 = this.A00;
                if (A0K[3].charAt(25) != 'G') {
                    A0K[3] = "irPj8aYnTZH6GsdLYSbTyVfXBLXHQnPh";
                    n9.ADD(this, this.A08);
                } else {
                    A0K[3] = "5PA9hoTjlgD01Tr6eTkR8jxCvDfXc2RO";
                    n9.ADD(this, this.A08);
                }
            }
        }
        this.A04.A0F().A4O(this.A00 != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A0C(int i3, C1080Tx c1080Tx) {
        C1838k2 c1838k2 = new C1838k2(this);
        this.A09 = new AnonymousClass62(this.A04, this.A05, c1838k2, this.A03, A08(0, 31, 79), 2, this.A0H);
        this.A0A = new C1837k1(this);
        this.A0B = new C1593fp(this.A09, c1080Tx.A04(), c1080Tx.A09(), true, new WeakReference(this.A0A), this.A04);
        this.A0B.A0W(this.A03.A0m());
        this.A0B.A0X(this.A03.A0n());
        this.A09.setVisibility(0);
        this.A04.getResources();
        this.A09.setLayoutParams(new LinearLayout.LayoutParams(-1, i3));
        this.A09.AKD();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    private void A0F(C1080Tx c1080Tx, JSONObject jSONObject, EnumC1122Vp enumC1122Vp) {
        this.A0F = false;
        final C1823jn c1823jnA00 = C1823jn.A00(this.A04, jSONObject);
        this.A0D = c1823jnA00.A7O();
        if (AbstractC0904Mx.A06(this.A04, c1823jnA00, this.A05)) {
            this.A04.A0F().A52();
            this.A00.AEN(this, C1120Vm.A00(AdErrorType.NO_FILL));
            return;
        }
        this.A07 = new AbstractC0870Lp() { // from class: com.facebook.ads.redexgen.X.82
            public static byte[] A02;
            public static String[] A03 = {"dvnbyrX9L5Wlup6c2JnWkpTYBAz3QIun", "ITj", "KqeTcLSx6Zay5vtxcnHqZ", "bGeXa7nDz1byFpBCq22utpLnb", "UYph9iPsD3jee8BOLuPQ6r57rjKJpmVb", "DfaYbRSw6X21pxGApii0qweOJ64z1eNB", "52vckdype7aS5lLwU46sLHF0XTMQAze7", "uuBWL9In1wjj"};

            public static String A00(int i3, int i4, int i5) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
                for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                    bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 105);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A02 = new byte[]{67, 116, 116, 105, 116, 38, 99, 126, 99, 101, 115, 114, 111, 104, 97, 38, 103, 101, 114, 111, 105, 104, 119, 117, Framer.EXIT_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 113, 102, 64, 109, 100, 113, 116, 112, 115, 118, 81, 74, 77, 85, 81, 65, 109, 64};
            }

            static {
                A01();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void ACz() {
                this.A00.A0F = true;
                if (this.A00.A0G) {
                    this.A00.A0A();
                }
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC0870Lp, com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void ADN(String str, Map<String, String> map) {
                C0912Ng c0912NgA2A;
                this.A00.A04.A0F().A4P();
                Uri uriA00 = XB.A00(str);
                map.put(A00(22, 10, 125), AdPlacementType.BANNER.name());
                map.put(A00(36, 8, 77), this.A00.A0I);
                AnonymousClass76 anonymousClass76 = this.A00.A04;
                VA va = this.A00.A05;
                String strA7O = c1823jnA00.A7O();
                if (this.A00.A03 == null) {
                    c0912NgA2A = null;
                } else {
                    AnonymousClass81 anonymousClass81 = this.A00;
                    if (A03[7].length() == 4) {
                        throw new RuntimeException();
                    }
                    A03[2] = "7FoTEC4l3Pv3ceMVIqf";
                    c0912NgA2A = anonymousClass81.A03.A2A();
                }
                AbstractC0900Mt adAction = C0901Mu.A00(anonymousClass76, va, strA7O, uriA00, map, c0912NgA2A);
                EnumC0897Mq enumC0897MqA0G = EnumC0897Mq.A09;
                if (adAction != null) {
                    try {
                        this.A00.A04.A0F().A4M();
                        enumC0897MqA0G = adAction.A0G(null);
                    } catch (Exception e3) {
                        Log.e(AnonymousClass81.A0L, A00(0, 22, 111), e3);
                    }
                }
                if (A00(32, 4, 123).equals(uriA00.getScheme()) && C0901Mu.A04(uriA00.getAuthority()) && this.A00.A00 != null && enumC0897MqA0G != EnumC0897Mq.A06) {
                    this.A00.A00.ADC(this.A00);
                }
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void AEA() {
                this.A00.A04.A0F().A4Q(this.A00.A02 != null);
                if (this.A00.A02 != null) {
                    this.A00.A02.A03();
                }
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void AF8() {
                this.A00.A04.A0F().A4S();
                this.A00.A02.A09();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1297b1
            public final void AGg() {
            }
        };
        this.A08 = new LV(this.A04, (WeakReference<InterfaceC1297b1>) new WeakReference(this.A07), c1080Tx.A04(), A7O());
        this.A08.A0L(c1080Tx.A07(), c1080Tx.A08());
        N4 impressionHelper = new C1836k0(this);
        this.A02 = new C1821jl(this.A04, this.A05, this.A08, this.A08.getViewabilityChecker(), impressionHelper, enumC1122Vp);
        this.A02.A0A(c1823jnA00);
        this.A08.loadDataWithBaseURL(AbstractC1300b4.A01(AdInternalSettings.getUrlPrefix()), c1823jnA00.A04(), A08(31, 9, 19), A08(40, 5, 12), null);
        this.A0E = true;
        A0A();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053 A[PHI: r1
      0x0053: PHI (r1v13 int) = (r1v10 int), (r1v17 int) binds: [B:20:0x0079, B:12:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c A[PHI: r1
      0x007c: PHI (r1v11 int) = (r1v10 int), (r1v13 int), (r1v17 int) binds: [B:20:0x0079, B:14:0x005d, B:12:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0G(com.facebook.ads.redexgen.core.EnumC1122Vp r11, com.facebook.ads.redexgen.core.C1080Tx r12) {
        /*
            r10 = this;
            com.facebook.ads.redexgen.X.7o r0 = r10.A03
            if (r0 == 0) goto L23
            com.facebook.ads.redexgen.X.VA r3 = r10.A05
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AnonymousClass81.A0K
            r0 = 1
            r1 = r1[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            r0 = 73
            if (r1 == r0) goto La7
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AnonymousClass81.A0K
            java.lang.String r1 = "0asQ5nS3mEJJFXqECkaJp8czAINd5ojj"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "wkfCN0fAVUFan65EWCqz3ffd3K2ZXjjS"
            r0 = 4
            r2[r0] = r1
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r11.A03()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AnonymousClass81.A0K
            r0 = 3
            r1 = r1[r0]
            r0 = 25
            char r1 = r1.charAt(r0)
            r0 = 71
            if (r1 == r0) goto L66
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AnonymousClass81.A0K
            java.lang.String r1 = "7AAzPingpmVfFCqSXKHauNoNKo9Xv93Z"
            r0 = 5
            r2[r0] = r1
            float r1 = (float) r3
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r1 = r1 * r0
            int r1 = (int) r1
            com.facebook.ads.redexgen.X.76 r0 = r10.A04
            boolean r0 = com.facebook.ads.redexgen.core.C1098Up.A2H(r0)
            if (r0 == 0) goto L7c
        L53:
            com.facebook.ads.redexgen.X.7o r0 = r10.A03
            org.json.JSONObject r0 = r0.A1H()
            boolean r0 = com.facebook.ads.redexgen.core.SN.A0A(r0)
            if (r0 == 0) goto L7c
            r0 = 1
        L60:
            if (r0 != 0) goto L7e
            r10.A0C(r1, r12)
            return
        L66:
            float r1 = (float) r3
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r1 = r1 * r0
            int r1 = (int) r1
            com.facebook.ads.redexgen.X.76 r0 = r10.A04
            boolean r0 = com.facebook.ads.redexgen.core.C1098Up.A2H(r0)
            if (r0 == 0) goto L7c
            goto L53
        L7c:
            r0 = 0
            goto L60
        L7e:
            com.facebook.ads.redexgen.X.76 r0 = r10.A04
            com.facebook.ads.redexgen.X.Sx r4 = new com.facebook.ads.redexgen.X.Sx
            r4.<init>(r0)
            r2 = r10
            com.facebook.ads.redexgen.X.SN r3 = new com.facebook.ads.redexgen.X.SN
            com.facebook.ads.redexgen.X.7o r0 = r10.A03
            org.json.JSONObject r5 = r0.A1H()
            com.facebook.ads.redexgen.X.7o r0 = r10.A03
            java.lang.String r6 = r0.A10()
            com.facebook.ads.redexgen.X.7o r0 = r10.A03
            java.lang.String r7 = r0.A1D()
            com.facebook.ads.redexgen.X.k4 r9 = new com.facebook.ads.redexgen.X.k4
            r9.<init>(r10, r1, r12, r2)
            r8 = 1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3.A0B()
            return
        La7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass81.A0G(com.facebook.ads.redexgen.X.Vp, com.facebook.ads.redexgen.X.Tx):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.N1
    public final String A7O() {
        return this.A0D;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.N1
    public final AdPlacementType A8k() {
        if (C1098Up.A1A(this.A04)) {
            EnumC1122Vp enumC1122Vp = this.A06;
            String[] strArr = A0K;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A0K[0] = "gRyzGCsQg6apk2eHBZ3N290V4KDgGwY2";
            if (enumC1122Vp != null && this.A06 == EnumC1122Vp.A09) {
                return AdPlacementType.MEDIUM_RECTANGLE;
            }
        }
        return AdPlacementType.BANNER;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1844k8
    public final void AAt(AnonymousClass76 anonymousClass76, VA va, EnumC1122Vp enumC1122Vp, N9 n9, JSONObject jSONObject, C1080Tx c1080Tx) {
        anonymousClass76.A0F().A4N();
        this.A04 = anonymousClass76;
        this.A05 = va;
        this.A00 = n9;
        this.A06 = enumC1122Vp;
        this.A0G = C1098Up.A1o(this.A04.getApplicationContext());
        this.A03 = C05267o.A00(jSONObject, this.A04);
        if (this.A03.A1g()) {
            A0G(enumC1122Vp, c1080Tx);
        } else {
            A0F(c1080Tx, jSONObject, enumC1122Vp);
        }
        this.A01 = new NA(this.A04, this.A0I, this, n9);
        this.A01.A02();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.N1
    public final boolean AKL() {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.N1
    public final void onDestroy() {
        this.A04.A0F().A4L(this.A08 != null);
        if (this.A08 != null) {
            this.A08.destroy();
            this.A08 = null;
            this.A07 = null;
        }
        if (this.A01 != null) {
            this.A01.A03();
        }
    }
}

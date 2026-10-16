package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.adapters.datamodels.AdInfo;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C4T extends PJ {
    public static byte[] A0D;
    public static String[] A0E = {"tW3Su6P8GZp1yTngpwFy2DF2GhDzXnf2", "3HQabaXZCQWVf5CedpF1izNpaoU6B", "XHPkWVuaRS230ZzCiYR7qtQACoZnYKM5", "gQNAwnCobdMDtnebLpL2jf4350QwOymE", "dRJ3n5TbirTJDeON6upQokchUTJmTtSu", "43KhzPf8qbqk0SZtfSmXLCVXJtKHuuuO", "kYCENHGiqRDWZvuV9M2TmYzxFqbu31T5", "7NDfQDtGKt0HcNI2moZZTs031QkqKmSX"};
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public int A00;
    public int A01;
    public LinearLayout A02;
    public AbstractC1813jd A03;
    public C1054Sx A04;
    public C1J A05;
    public C1341bj A06;
    public C0724Fy A07;
    public AbstractC1592fo A08;
    public C1593fp A09;
    public String A0A;
    public List<C1486e5> A0B;
    public final Y2 A0C;

    public static String A0E(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0G() {
        A0D = new byte[]{66, 71, 124, 71, 66, 87, 66, 124, 65, 86, 77, 71, 79, 70, Ascii.DC2, 5, Ascii.ETB, 1, Ascii.DC2, 4, 5, 4, 54, 9, 4, 5, Ascii.SI, Framer.ENTER_FRAME_PREFIX, 4, 36, 1, Ascii.DC4, 1, 34, Ascii.NAK, Ascii.SO, 4, Ascii.FF, 5, 118, 110, 108, 117};
    }

    static {
        A0G();
        A0G = (int) (XX.A02 * 48.0f);
        A0H = XV.A0v;
        A0I = (int) (XX.A02 * 8.0f);
        A0K = (int) (XX.A02 * 56.0f);
        A0F = (int) (XX.A02 * 48.0f);
        A0J = (int) (XX.A02 * 12.0f);
    }

    public C4T(C1648gi c1648gi, VA va, C1054Sx c1054Sx, InterfaceC1189Yh interfaceC1189Yh, AbstractC1813jd abstractC1813jd) {
        super(c1648gi, va, interfaceC1189Yh, abstractC1813jd);
        this.A0C = new Y2();
        if (abstractC1813jd instanceof C05237l) {
            super.A09 = true;
            super.A08 = new C1516ea(c1648gi, new MG(), this.A0D.A1G(), interfaceC1189Yh);
        }
        this.A04 = c1054Sx;
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    private int A00() {
        return A0K + A0G + (A0H * 4) + (this.A0D.A2Q() ? A0F : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.ads.redexgen.core.EnumC0897Mq A02(java.lang.String r7) {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.Mq r5 = com.facebook.ads.redexgen.core.EnumC0897Mq.A09
            com.facebook.ads.redexgen.X.1J r0 = r6.A05
            if (r0 != 0) goto L7
            return r5
        L7:
            com.facebook.ads.redexgen.X.1J r4 = r6.A05
            com.facebook.ads.redexgen.X.1J r0 = r6.A05
            com.facebook.ads.redexgen.X.hr r3 = r0.getLayoutManager()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            r0 = 5
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 30
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L91
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            java.lang.String r1 = "E32f1TaBN4dkj3FL0vDfikWnsbqL7SKY"
            r0 = 2
            r2[r0] = r1
            int r0 = r3.A25()
            com.facebook.ads.redexgen.X.RK r3 = r4.A1G(r0)
            com.facebook.ads.redexgen.X.FY r3 = (com.facebook.ads.redexgen.core.FY) r3
            if (r3 == 0) goto L7d
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            if (r0 == 0) goto L7d
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            com.facebook.ads.redexgen.X.Mq r5 = r0.A0E(r7)
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            com.facebook.ads.redexgen.X.bV r4 = r0.getCtaActionHelper()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C4T.A0E
            r0 = 2
            r1 = r1[r0]
            r0 = 16
            char r1 = r1.charAt(r0)
            r0 = 49
            if (r1 == r0) goto L7e
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            java.lang.String r1 = "i7TFLIHedh0buU6tWLTqbZ60SXZT8zmg"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "DCWE7AKb21kTTjPuFVubbU6pDlTglIBY"
            r0 = 6
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Mr r0 = r4.A06()
            if (r0 != 0) goto L7d
        L6d:
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            com.facebook.ads.redexgen.X.bV r1 = r0.getCtaActionHelper()
            com.facebook.ads.redexgen.X.Ff r0 = new com.facebook.ads.redexgen.X.Ff
            r0.<init>(r6)
            r1.A07(r0)
        L7d:
            return r5
        L7e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            java.lang.String r1 = "dI26cUvsILIVYWhCptAOIe9hx0G02LwU"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "KP2PoUq36ksxZ0HlOf60WIRRhVJwRZXP"
            r0 = 0
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Mr r0 = r4.A06()
            if (r0 != 0) goto L7d
            goto L6d
        L91:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C4T.A02(java.lang.String):com.facebook.ads.redexgen.X.Mq");
    }

    private AbstractC1813jd A03(Intent intent) {
        if (super.A09) {
            return (AbstractC1813jd) intent.getSerializableExtra(A0E(14, 25, 103));
        }
        return (AbstractC1813jd) intent.getSerializableExtra(A0E(0, 14, 36));
    }

    private final void A0H() {
        if (this.A02 != null) {
            this.A02.removeAllViews();
            if (A0E[3].charAt(5) != 'n') {
                throw new RuntimeException();
            }
            A0E[4] = "3JPxSaqJUpKyt95G35P4gQJAerHutmpA";
            this.A02 = null;
        }
        if (this.A05 != null) {
            this.A05.removeAllViews();
            this.A05.A1S();
            this.A05 = null;
        }
        if (this.A06 != null) {
            this.A06.removeAllViews();
            this.A06 = null;
        }
    }

    private final void A0I(int i3, Bundle bundle) {
        int extraSpacing;
        int i4;
        int height;
        this.A02 = new LinearLayout(getContext());
        if (i3 == 1) {
            this.A02.setGravity(17);
        } else {
            this.A02.setGravity(48);
        }
        this.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A02.setOrientation(1);
        int i5 = XX.A04.widthPixels;
        int i6 = XX.A04.heightPixels;
        if (i3 == 1) {
            extraSpacing = Math.min(i5 - (A0H * 4), i6 / 2);
            i4 = (i5 - extraSpacing) / 8;
            height = i4 * 4;
        } else {
            extraSpacing = i6 - A00();
            i4 = A0H;
            height = i4 * 2;
        }
        this.A08 = new C0707Fg(this);
        this.A09 = new C1593fp(this, 1, new WeakReference(this.A08), this.A0E);
        this.A09.A0W(this.A00);
        this.A09.A0X(this.A01);
        this.A05 = new C1J(this.A0E);
        this.A05.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.A07 = new C0724Fy(this.A05, i3, this.A0B, this.A09, bundle);
        int extraSpacing2 = i4;
        int childSpacing = extraSpacing;
        this.A05.setAdapter(new C0715Fp(this.A0E, this.A0B, this.A03, this.A0F, this.A04, this.A09, this.A0C, getAudienceNetworkListener(), this.A0A, childSpacing, extraSpacing2, height, i3, this.A07, this.A0H));
        this.A05.A1h(this.A05.getOnScrollListener());
        if (i3 == 1) {
            A0K(this.A07);
        }
        this.A02.addView(this.A05);
        if (this.A06 != null) {
            this.A02.addView(this.A06);
        }
        if (C1098Up.A1z(this.A0E)) {
            this.A0E.A0B().AKn(this.A05, this.A0D.A2E(), false);
        }
        A0f(this.A02, false, i3);
    }

    private void A0J(AbstractC1813jd abstractC1813jd) {
        this.A03 = abstractC1813jd;
        this.A0A = this.A03.A2E();
        this.A00 = this.A03.A0m();
        this.A01 = this.A03.A0n();
        List<NR> listA2G = this.A03.A2G();
        List<AdInfo> adInfoList = new ArrayList<>(listA2G.size());
        this.A0B = adInfoList;
        for (int i3 = 0; i3 < listA2G.size(); i3++) {
            NR nr = listA2G.get(i3);
            List<C1486e5> list = this.A0B;
            int i4 = listA2G.size();
            list.add(new C1486e5(i3, i4, nr));
        }
    }

    private void A0K(C0724Fy c0724Fy) {
        new C7N().A0G(this.A05);
        c0724Fy.A0Y(new C0705Fe(this));
        this.A06 = new C1341bj(this.A0E, super.A07.A01(), this.A0B.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0I);
        layoutParams.setMargins(0, A0J, 0, 0);
        this.A06.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public final AbstractC1183Yb A0b() {
        return new FullScreenAdToolbar(this.A0E, getAudienceNetworkListener(), this.A0G, 0, this.A0D.A22(), false);
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public final void A0d() {
        EnumC0897Mq enumC0897MqA02 = A02(A0E(39, 4, 2));
        if (this.A0D.A2N()) {
            return;
        }
        EnumC0897Mq actionOutcome = EnumC0897Mq.A09;
        if (enumC0897MqA02 != actionOutcome) {
            EnumC0897Mq actionOutcome2 = EnumC0897Mq.A06;
            if (enumC0897MqA02 != actionOutcome2) {
                A0m();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public final boolean A0l() {
        return false;
    }

    public final void A0m() {
        if (this.A0H.getToolbarActionMode() == 8) {
            this.A0H.setToolbarActionMode(2);
        }
        this.A0D.A2K(false);
        this.A0D.A29().A0M(-1);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AAu(Intent intent, Bundle bundle, C1010Re c1010Re) {
        AbstractC1813jd dataBundle = A03(intent);
        A0g(c1010Re);
        A0J(dataBundle);
        A0I(c1010Re.A05().getResources().getConfiguration().orientation, bundle);
        c1010Re.A0A(new C0704Fd(this, c1010Re));
        AbstractC1813jd dataBundle2 = this.A0D;
        int unskippableSec = dataBundle2.A29().A0H().A04();
        if (super.A09) {
            AbstractC1813jd dataBundle3 = this.A0D;
            unskippableSec = dataBundle3.A29().A0H().A03();
        }
        if (unskippableSec > 0) {
            A0e(unskippableSec);
        }
        AbstractC1813jd dataBundle4 = this.A0D;
        if (dataBundle4.A29().A0H().A02() >= 0) {
            this.A0H.setToolbarActionMode(8);
        }
        AbstractC1813jd dataBundle5 = this.A0D;
        if (dataBundle5.A2T()) {
            this.A0H.setOnClickListener(new ViewOnClickListenerC1490e9(this));
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ, com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFA(boolean z2) {
        super.AFA(z2);
        if (this.A07 != null) {
            this.A07.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ, com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFi(boolean z2) {
        super.AFi(z2);
        this.A07.A0R();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AIv(Bundle bundle) {
        if (this.A07 != null) {
            this.A07.A0W(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public int getCloseButtonStyle() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        AIv(bundle);
        A0H();
        A0I(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ, com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void onDestroy() {
        super.onDestroy();
        if (C1098Up.A1z(this.A0E)) {
            this.A0E.A0B().AKU(this.A05);
        }
        if (!TextUtils.isEmpty(this.A0A)) {
            this.A0F.AB7(this.A0A, new C1305b9().A03(this.A09).A02(this.A0C).A05());
        }
        A0H();
        this.A09.A0V();
        this.A09 = null;
        this.A08 = null;
        this.A0B = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0C.A06(this.A0E, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}

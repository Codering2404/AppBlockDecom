package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MW extends RelativeLayout implements InterfaceC1190Yi {
    public static byte[] A0V;
    public static String[] A0W = {"K2KQx5j", "I1DdEcIQOKACt5VfynDO8RkkSmVrIdSu", "CrPvtz5bwgp8q96Y41ywgNmdDqzXYyT", "BcZqlHBP86U0O", "mAAXLn1achaKS", "KDsASou", "qHjTnlroNJSmFEFt4pVmvH8neAK9EJVy", "ok9QX18270ZP2OGfEK6N7HjWUQBUEH7u"};
    public static final int A0X;
    public int A00;
    public C1010Re A01;
    public XO A02;
    public C1238a4 A03;
    public C1253aJ A04;
    public C1257aN A05;
    public C1323bR A06;
    public ViewOnClickListenerC0846Kr A07;
    public C1503eM A08;
    public C1509eS A09;
    public C1516ea A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public final Handler A0F;
    public final AbstractC1813jd A0G;
    public final C0920No A0H;
    public final InterfaceC1016Rk A0I;
    public final C1648gi A0J;
    public final VA A0K;
    public final VI A0L;
    public final XO A0M;
    public final ViewOnSystemUiVisibilityChangeListenerC1179Xx A0N;
    public final InterfaceC1189Yh A0O;
    public final ZU A0P;
    public final C1499eI A0Q;
    public final AtomicBoolean A0R;
    public final AtomicBoolean A0S;
    public final boolean A0T;
    public final AbstractC1183Yb A0U;

    public static String A09(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0V, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A0V = new byte[]{-81, -72, -75, -81, -73, -85, -69, -66, -75, -77, -75, -70, -99, -90, -93, -99, -91, -103, -83, -87, -81, -84, -99, -97, -7, -20, -1, -12, 1, -16, -22, -18, -9, -12, -18, -10, Ascii.CAN, Ascii.DC4, 9, Ascii.VT, Ascii.CR, Ascii.NAK, Ascii.CR, Ascii.SYN, Ascii.FS, -18, -26, -28, -21, 3, -15, -18, 2, -11, -15, 3, -21, -17, -8, -11, -17, -9};
    }

    static {
        A0P();
        A0X = XV.A03;
    }

    public MW(C1648gi c1648gi, VA va, InterfaceC1189Yh interfaceC1189Yh, AbstractC1813jd abstractC1813jd, C0920No c0920No, String str, ZU zu) {
        super(c1648gi);
        this.A0C = false;
        this.A0B = false;
        this.A0F = new Handler(Looper.getMainLooper());
        this.A0R = new AtomicBoolean(false);
        this.A0D = false;
        this.A0S = new AtomicBoolean(false);
        this.A0I = new C0893Mm(this);
        this.A0J = c1648gi;
        this.A0K = va;
        this.A0O = interfaceC1189Yh;
        this.A0G = abstractC1813jd;
        this.A0H = c0920No;
        this.A0P = zu;
        this.A0L = new VI(this.A0G.A2E(), this.A0K);
        this.A0A = new C1516ea(c1648gi, this.A0P, str, this.A0O);
        C0893Mm c0893Mm = null;
        this.A0M = new XO(this.A0H.A0C(), new C0882Mb(this, c0893Mm));
        this.A0T = this.A0G.A1v();
        setBackgroundColor(-16777216);
        this.A00 = getResources().getConfiguration().orientation;
        this.A0N = new ViewOnSystemUiVisibilityChangeListenerC1179Xx(this);
        this.A0N.A05(EnumC1178Xw.A03);
        C0881Ma c0881Ma = new C0881Ma(this, c0893Mm);
        HashMap map = new HashMap();
        map.put(A09(36, 9, 124), this.A0P.A8l());
        this.A0Q = new C1499eI(this.A0J, this.A0G, this.A0H, this.A0K, c0881Ma, map);
        this.A0U = A04();
        this.A07 = A06();
        this.A0O.A45(this, new RelativeLayout.LayoutParams(-1, -1));
        A0M();
        if (!this.A0H.A0b()) {
            A0b();
        }
    }

    private PU A04() {
        PU pu = new PU(this.A0J, this.A0G, 4);
        pu.setToolbarListener(new InterfaceC1182Ya() { // from class: com.facebook.ads.redexgen.X.NB
            @Override // com.facebook.ads.redexgen.core.InterfaceC1182Ya
            public final void ACl(AbstractC1183Yb abstractC1183Yb) {
                this.A00.A0d(abstractC1183Yb);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(XV.A00, XV.A0N, XV.A00, XV.A00);
        pu.setLayoutParams(layoutParams);
        return pu;
    }

    private ViewOnClickListenerC0846Kr A06() {
        if (this.A0Q != null) {
            C1499eI c1499eI = this.A0Q;
            if (A0W[1].charAt(5) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[5] = "DwrRGPH";
            strArr[0] = "aRDWSvq";
            if (c1499eI.getViewabilityChecker() != null && this.A0Q.getTouchDataRecorder() != null) {
                ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr = new ViewOnClickListenerC0846Kr(this.A0J, this.A0P.A7M(), this.A0G.A28().A01(), this.A0K, this.A0O, this.A0Q.getViewabilityChecker(), this.A0Q.getTouchDataRecorder(), this.A0G.A2A());
                viewOnClickListenerC0846Kr.setCta(this.A0G.A29().A0J(), this.A0G.A2E(), new HashMap(), null);
                viewOnClickListenerC0846Kr.setText(this.A0H.A0M());
                viewOnClickListenerC0846Kr.A0D();
                viewOnClickListenerC0846Kr.setTextSize(13.0f);
                viewOnClickListenerC0846Kr.setPadding(XV.A0D, XV.A00, XV.A0D, XV.A00);
                YB.A0P(viewOnClickListenerC0846Kr, -15902766, A0X);
                viewOnClickListenerC0846Kr.setElevation(0.0f);
                viewOnClickListenerC0846Kr.setStateListAnimator(null);
                viewOnClickListenerC0846Kr.setOutlineProvider(null);
                viewOnClickListenerC0846Kr.setOnClickListener(new ZA(this));
                return viewOnClickListenerC0846Kr;
            }
        }
        return null;
    }

    private void A0C() {
        this.A0U.setToolbarActionMode(2);
        this.A0D = true;
        this.A0L.A04(VH.A0Y, null);
        this.A0J.A0F().AFE();
        if (C1098Up.A1H(this.A0J)) {
            boolean z2 = this.A0T;
            if (A0W[2].length() == 32) {
                throw new RuntimeException();
            }
            A0W[6] = "k4geMuTXC1h9ucfhhM9HvzcpXwlG9hvy";
            if (z2) {
                A0N();
                if (this.A0G.A29().A0S()) {
                    this.A0A.A06();
                    this.A0O.A4k(this.A0P.A6l(), new C4K(0, 0));
                }
            }
        }
        A0V(false, A09(45, 4, 79));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A0E = true;
        if (this.A0G.A29().A0S()) {
            this.A0A.A06();
            this.A0O.A4k(this.A0P.A6l(), new C4K(0, 0));
        }
    }

    private void A0E() {
        if (this.A03 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        layoutParams.setMargins(XV.A00, XV.A00, XV.A0F, XV.A00);
        this.A03.setLayoutParams(layoutParams);
    }

    private void A0F() {
        if (this.A04 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        layoutParams.setMargins(XV.A00, XV.A00, XV.A09, XV.A09);
        this.A04.setLayoutParams(layoutParams);
    }

    private void A0G() {
        if (this.A05 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(20);
            layoutParams.addRule(12);
            layoutParams.setMargins(XV.A09, XV.A00, XV.A00, XV.A09);
            this.A05.setLayoutParams(layoutParams);
        }
    }

    private void A0H() {
        this.A03 = new C1238a4(this.A0J, this.A0G, null, this.A0O);
        A0E();
        addView(this.A03);
    }

    private void A0I() {
        if (this.A0G.A2W()) {
            A0L();
        }
        if (this.A0G.A2M()) {
            A0K();
        } else {
            A0H();
        }
    }

    private void A0J() {
        if (this.A07 == null) {
            return;
        }
        setClipChildren(false);
        this.A06 = new C1323bR(this.A0J, this.A0G, this.A07, this.A0H.A0B(), this.A0H.A0Z());
        A0Q(this.A00);
        addView(this.A06);
    }

    private void A0K() {
        this.A04 = AbstractC1258aO.A01(this.A0J, false, this.A0G, this.A0L, this.A0O, EnumC1256aM.A03, AbstractC1255aL.A00(this.A0G));
        A0F();
        addView(this.A04);
    }

    private void A0L() {
        this.A05 = AbstractC1258aO.A02(this.A0J, EnumC1256aM.A03, this.A0G);
        this.A05.setBackgroundColor(-2145637581);
        A0G();
        addView(this.A05);
    }

    private void A0M() {
        this.A0U.setVisibility(4);
        YB.A0K(this.A0U);
        this.A0Q.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        A0R(this.A00);
        addView(this.A0Q);
        addView(this.A0U);
        if (this.A0H.A0a()) {
            A0J();
        }
        A0I();
        if (!this.A0H.A0Y()) {
            boolean zA0b = this.A0H.A0b();
            if (A0W[1].charAt(5) != 'c') {
                throw new RuntimeException();
            }
            A0W[7] = "XlBnGmRHSm8FPKQHD6bIB4zK3mUoDq5y";
            if (!zA0b) {
                this.A0Q.setVisibility(4);
                return;
            }
        }
        setVisibility(4);
        this.A0Q.A0C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N() {
        if (this.A0G.A2M() && this.A04 != null) {
            this.A04.A0P();
            if (this.A0G.A2U()) {
                AbstractC1255aL.A04(this.A0J, EnumC1256aM.A02);
            } else {
                AbstractC1255aL.A05(this.A0J, EnumC1256aM.A02);
            }
        }
        if (this.A0G.A2W() && this.A05 != null) {
            AbstractC1255aL.A06(this.A0J, EnumC1256aM.A02);
        }
        this.A0L.A04(VH.A0z, null);
        if (this.A07 != null) {
            this.A07.setText(this.A0G.A29().A0J().A04());
        }
        if (!this.A0G.A29().A0K().A02().isEmpty()) {
            this.A09 = new C1509eS(this.A0J, this.A0G, this.A0O, this.A07, this.A0F, this.A0L);
            addView(this.A09.A0W(), new RelativeLayout.LayoutParams(-1, -1));
            YB.A0d(this.A0U);
        } else {
            this.A08 = new C1503eM(this.A0J, this.A0K, this.A0G);
            Pair<EnumC1502eL, View> pairA03 = this.A08.A03(this.A07);
            AbstractC1349br.A00(this.A0J, this, this.A0G.A29().A0H().A08());
            addView((View) pairA03.second, new RelativeLayout.LayoutParams(-1, -1));
            long jA00 = this.A0G.A29().A0K().A00();
            if (jA00 > 0) {
                this.A0F.postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.Z9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.A00.A0c();
                    }
                }, jA00);
            } else {
                AbstractC1183Yb abstractC1183Yb = this.A0U;
                String[] strArr = A0W;
                if (strArr[5].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                A0W[3] = "dsmu";
                abstractC1183Yb.setToolbarActionMode(0);
            }
        }
        YB.A0d(this.A0Q);
        this.A0R.set(true);
    }

    private void A0O() {
        final C1477dw c1477dw = new C1477dw(this.A0J, this.A0G);
        addView(c1477dw, new RelativeLayout.LayoutParams(-1, -1));
        this.A0F.postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.Z8
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0e(c1477dw);
            }
        }, this.A0H.A0D());
    }

    private void A0Q(int i3) {
        if (this.A06 == null) {
            return;
        }
        this.A06.A0I(i3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i3 == 2) {
            int i4 = XV.A00;
            if (A0W[4].length() == 25) {
                throw new RuntimeException();
            }
            A0W[2] = "3KWOojhtbTrcKNejqW7";
            layoutParams.setMargins(i4, XV.A00, XV.A00, XV.A05);
        } else {
            layoutParams.setMargins(XV.A00, XV.A00, XV.A00, XV.A0N);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.A06.setLayoutParams(layoutParams);
    }

    private void A0R(int i3) {
        if (i3 == 2) {
            this.A0Q.setPadding(XV.A01, XV.A01, XV.A01, XV.A01);
            return;
        }
        C1499eI c1499eI = this.A0Q;
        int i4 = XV.A00;
        if (A0W[7].charAt(28) == 'Z') {
            throw new RuntimeException();
        }
        A0W[3] = "dtYS90IKRfB1L";
        c1499eI.setPadding(i4, XV.A00, XV.A00, XV.A00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0V(boolean z2, String str) {
        this.A0C = true;
        HashMap map = new HashMap();
        map.put(A09(0, 12, 32), z2 ? A09(49, 13, 96) : A09(24, 12, 95));
        map.put(A09(12, 12, 14), str);
        new C1327bV(this.A0J, this.A0P.A7M(), this.A0Q.getViewabilityChecker(), this.A0Q.getTouchDataRecorder(), this.A0K, this.A0G.A2A(), this.A0O).A05(this.A0G.A2E(), this.A0G.A29().A0J().A05(), map);
    }

    public final void A0b() {
        if (this.A0H.A0Y() || this.A0H.A0b()) {
            setVisibility(0);
            this.A0Q.A0E(0);
            AFi(false);
            if (this.A0S.get()) {
                A0N();
            }
        } else {
            this.A0Q.A0C();
            this.A0Q.setVisibility(0);
            this.A0M.A07();
        }
        if (this.A0H.A0W()) {
            A0O();
        }
        if (this.A06 != null) {
            this.A06.A0E();
        }
        this.A0U.setVisibility(0);
        if (this.A07 != null && this.A0G.A25() > 0 && this.A02 == null) {
            this.A02 = new XO(this.A0G.A25(), new C0883Mc(this));
            this.A02.A07();
        }
    }

    public final /* synthetic */ void A0c() {
        this.A0U.setToolbarActionMode(0);
    }

    public final /* synthetic */ void A0d(AbstractC1183Yb abstractC1183Yb) {
        if (this.A0H.A0A() > 0 && abstractC1183Yb.getToolbarActionMode() == 8) {
            A0C();
            return;
        }
        if (abstractC1183Yb.getToolbarActionMode() != 0 && this.A0H.A0V() && !this.A0R.get()) {
            abstractC1183Yb.setToolbarActionMode(2);
            A0N();
        } else {
            this.A0L.A04(VH.A07, null);
            this.A0J.A0F().AB0();
            this.A0O.A4j(this.A0P.A7w());
        }
    }

    public final /* synthetic */ void A0e(C1477dw c1477dw) {
        removeView(c1477dw);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AAu(Intent intent, Bundle bundle, C1010Re c1010Re) {
        this.A01 = c1010Re;
        c1010Re.A0A(this.A0I);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFA(boolean z2) {
        this.A0M.A06();
        this.A0B = true;
        if (this.A06 != null) {
            this.A06.A0G();
        }
        if (this.A04 != null) {
            this.A04.A0P();
        } else {
            if (this.A03 == null) {
                return;
            }
            this.A03.A05();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFi(boolean z2) {
        this.A0M.A07();
        if (this.A06 != null) {
            this.A06.A0H();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AIv(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public String getCurrentClientToken() {
        return A09(0, 0, 117);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final boolean onActivityResult(int i3, int i4, Intent intent) {
        if (i3 == 945321098 && this.A0D && !this.A0R.get()) {
            this.A0L.A04(VH.A07, null);
            this.A0O.A4j(this.A0P.A7w());
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A0R(configuration.orientation);
        A0Q(configuration.orientation);
        if (this.A09 != null) {
            this.A09.A0a(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void onDestroy() {
        this.A0N.A03();
        if (this.A01 != null) {
            this.A01.A0B(this.A0I);
        }
        if (this.A06 != null) {
            this.A06.A0F();
        }
        if (this.A0Q != null) {
            if (!TextUtils.isEmpty(this.A0G.A2E())) {
                this.A0K.AB7(this.A0G.A2E(), new C1305b9().A03(this.A0Q.getViewabilityChecker()).A02(this.A0Q.getTouchDataRecorder()).A05());
            }
            this.A0Q.A0D();
        }
        if (this.A04 != null) {
            this.A04.A0O();
        } else if (this.A03 != null) {
            this.A03.A04();
        }
        this.A0M.A06();
        AbstractC1183Yb abstractC1183Yb = this.A0U;
        if (A0W[1].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A0W;
        strArr[5] = "SgQ0Vce";
        strArr[0] = "JIQdJaY";
        abstractC1183Yb.setToolbarListener(null);
        this.A0F.removeCallbacksAndMessages(null);
    }

    public void setListener(InterfaceC1189Yh interfaceC1189Yh) {
    }
}

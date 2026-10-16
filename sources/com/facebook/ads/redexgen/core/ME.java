package com.facebook.ads.redexgen.core;

import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ME extends AbstractC1211Zd {
    public static String[] A03 = {"ps9u6Kn8p", "fRCCllxRFm9XYnsS5Nz0CDYYbd8rz98F", "veZY5LUK4HkumILqtvhVtf9OT9QK1Jmh", "8c6Edyt19YE2bwpDp37rWBgdyfN4I4si", "Dgwj6SSLqT", "biYcUlACC5CMDg3zbjwwDR7mq5XP76DA", "rp5V5gFYHfFnaijOqqdMDMWavMrEx7HP", "ycj43TNZcka4uMSCxDz6fuqQ2r9gi3g6"};
    public static final int A04 = (int) (XX.A02 * 8.0f);
    public final RelativeLayout A00;
    public final C0938Og A01;
    public final C1648gi A02;

    public ME(C1648gi c1648gi, VA va, String str, C0918Nm c0918Nm, InterfaceC1190Yi interfaceC1190Yi, InterfaceC1189Yh interfaceC1189Yh) {
        super(c1648gi, va, str, c0918Nm, interfaceC1190Yi, interfaceC1189Yh);
        this.A02 = c1648gi;
        this.A01 = AbstractC0939Oh.A00(c1648gi.A02());
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        YB.A0N(this.A00, -1728053248);
        if (C1098Up.A2b(c1648gi)) {
            this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Zi
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A0T(view);
                }
            });
        }
    }

    public static RelativeLayout.LayoutParams A00(boolean z2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z2 ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A01() {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0O() {
        C0942Ok c0942OkA0A = this.A01.A0A();
        C1226Zs c1226Zs = new C1226Zs(this.A02);
        c1226Zs.setInfo(YM.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        c1226Zs.setOnClickListener(new ViewOnClickListenerC1217Zj(this));
        C0942Ok c0942OkA0B = this.A01.A0B();
        C1226Zs c1226Zs2 = new C1226Zs(this.A02);
        c1226Zs2.setInfo(YM.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        c1226Zs2.setOnClickListener(new ViewOnClickListenerC1218Zk(this));
        C1226Zs c1226Zs3 = new C1226Zs(this.A02);
        c1226Zs3.setInfo(YM.AD_CHOICES_ICON, this.A01.A0M(), "");
        c1226Zs3.setOnClickListener(new ViewOnClickListenerC1219Zl(this));
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04 * 2, A04, A04 * 2, A04);
        YB.A0N(linearLayout, -1);
        if (!c0942OkA0A.A05().isEmpty()) {
            linearLayout.addView(c1226Zs, itemParams);
        }
        if (!c0942OkA0B.A05().isEmpty()) {
            linearLayout.addView(c1226Zs2, itemParams);
        }
        linearLayout.addView(c1226Zs3, itemParams);
        A01();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0P() {
        this.A00.removeAllViews();
        YB.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0Q(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi) {
        String strA0E;
        int i3;
        String strA01;
        if (enumC0940Oi == EnumC0940Oi.A05) {
            return;
        }
        boolean z2 = enumC0940Oi == EnumC0940Oi.A06;
        C1208Za c1208Za = new C1208Za(this.A02, this.A0D);
        if (z2) {
            C0938Og c0938Og = this.A01;
            if (A03[4].length() != 10) {
                throw new RuntimeException();
            }
            A03[6] = "KfE81dulHFmzGO7NxqDM7oaE1pV2dKkX";
            strA0E = c0938Og.A0F();
        } else {
            strA0E = this.A01.A0E();
        }
        C1208Za c1208ZaA0D = c1208Za.A0H(strA0E).A0G(this.A01.A0D()).A0E(c0942Ok.A04()).A0D(z2 ? YM.REPORT_AD : YM.HIDE_AD);
        if (z2) {
            i3 = -552389;
        } else {
            i3 = -13272859;
        }
        C1208Za c1208ZaA0C = c1208ZaA0D.A0C(i3);
        if (this.A0C != null) {
            C0918Nm c0918Nm = this.A0C;
            if (A03[1].charAt(11) != 'X') {
                strA01 = c0918Nm.A01();
            } else {
                A03[0] = "vLdx3pZGf";
                strA01 = c0918Nm.A01();
            }
        } else {
            strA01 = "";
        }
        C1209Zb adHiddenView = c1208ZaA0C.A0F(strA01).A0L();
        YB.A0N(adHiddenView, -1);
        YB.A0W(this);
        this.A00.removeAllViews();
        this.A00.addView(adHiddenView, A00(true));
        super.A0Q(c0942Ok, enumC0940Oi);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0R(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi) {
        String strA0H;
        boolean z2 = enumC0940Oi == EnumC0940Oi.A06;
        C1648gi c1648gi = this.A02;
        InterfaceC1213Zf interfaceC1213Zf = this.A0D;
        if (z2) {
            strA0H = this.A01.A0L();
        } else {
            strA0H = this.A01.A0H();
        }
        C1229Zv c1229Zv = new C1229Zv(c1648gi, c0942Ok, interfaceC1213Zf, strA0H, z2 ? YM.REPORT_AD : YM.HIDE_AD);
        c1229Zv.setClickable(true);
        YB.A0N(c1229Zv, -1);
        c1229Zv.setPadding(A04 * 2, A04, A04 * 2, A04);
        A01();
        this.A00.removeAllViews();
        RelativeLayout relativeLayout = this.A00;
        String[] strArr = A03;
        if (strArr[3].charAt(9) == strArr[5].charAt(9)) {
            throw new RuntimeException();
        }
        A03[1] = "OoQvJ70CiRWXlhIiWSDPNsGTFrOY4nX1";
        relativeLayout.addView(c1229Zv, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final boolean A0S() {
        return false;
    }

    public final /* synthetic */ void A0T(View view) {
        this.A0D.A54();
    }
}

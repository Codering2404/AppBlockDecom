package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1503eM {
    public ViewOnClickListenerC0846Kr A00;
    public final NN A01;
    public final NY A02;
    public final C0909Nd A03;
    public final C0918Nm A04;
    public final C1648gi A05;
    public final VI A06;
    public static final int A09 = (int) (XX.A02 * 4.0f);
    public static final int A07 = (int) (XX.A02 * 72.0f);
    public static final int A08 = (int) (XX.A02 * 8.0f);

    public C1503eM(C1648gi c1648gi, VA va, AbstractC1813jd abstractC1813jd) {
        this.A05 = c1648gi;
        this.A06 = new VI(abstractC1813jd.A2E(), va);
        this.A01 = abstractC1813jd.A28();
        this.A02 = abstractC1813jd.A29().A0I();
        this.A04 = abstractC1813jd.A2C();
        this.A03 = abstractC1813jd.A29().A0K();
    }

    private View A00(ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr) {
        C1348bq c1348bq = new C1348bq(this.A05, this.A01.A01(), true, false, false);
        c1348bq.A04(this.A02.A0G(), this.A02.A04(), null, false, true);
        c1348bq.setAlignment(17);
        C1342bk c1342bk = new C1342bk(this.A05);
        YB.A0N(c1342bk, 0);
        c1342bk.setRadius(50);
        new LM(c1342bk, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c1342bk, new LinearLayout.LayoutParams(A07, A07));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A08, 0, A08);
        linearLayout.addView(c1348bq, layoutParams);
        if (viewOnClickListenerC0846Kr != null) {
            YB.A0J(viewOnClickListenerC0846Kr);
            linearLayout.addView(viewOnClickListenerC0846Kr, layoutParams);
            viewOnClickListenerC0846Kr.setPadding(XV.A0Z, 0, XV.A0Z, 0);
            if (TextUtils.isEmpty(viewOnClickListenerC0846Kr.getText())) {
                YB.A0H(viewOnClickListenerC0846Kr);
            }
        }
        return linearLayout;
    }

    private C7M A01() {
        C7M c7m = new C7M(this.A05);
        c7m.setLayoutManager(new C1718hr(this.A05, 0, false));
        c7m.setAdapter(new FH(this.A05, this.A03.A02(), A09, this.A00));
        return c7m;
    }

    private final EnumC1502eL A02() {
        if (!this.A03.A02().isEmpty()) {
            return EnumC1502eL.A03;
        }
        return EnumC1502eL.A02;
    }

    public final Pair<EnumC1502eL, View> A03(ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr) {
        View viewA01;
        this.A00 = viewOnClickListenerC0846Kr;
        EnumC1502eL enumC1502eLA02 = A02();
        switch (enumC1502eLA02) {
            case A03:
                viewA01 = A01();
                break;
            default:
                viewA01 = A00(this.A00);
                break;
        }
        VK.A04(viewA01, this.A06, VH.A0S);
        return new Pair<>(enumC1502eLA02, viewA01);
    }
}

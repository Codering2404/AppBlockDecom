package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1361c3 extends RelativeLayout {
    public static final int A08 = XV.A0b;
    public static final int A09 = (int) (XX.A02 * 28.0f);
    public static final int A0A = (int) (XX.A02 * 32.0f);
    public C0906Na A00;
    public boolean A01;
    public C1253aJ A02;
    public final C1648gi A03;
    public final VA A04;
    public final ViewOnClickListenerC0846Kr A05;
    public final C1348bq A06;
    public final C1365c7 A07;

    public abstract boolean A1O();

    public AbstractC1361c3(C1365c7 c1365c7, boolean z2) {
        C0906Na c0906NaA00;
        super(c1365c7.A06());
        this.A07 = c1365c7;
        this.A03 = c1365c7.A06();
        this.A04 = c1365c7.A07();
        if (c1365c7.A00() == 1) {
            c0906NaA00 = c1365c7.A05().A28().A01();
        } else {
            c0906NaA00 = c1365c7.A05().A28().A00();
        }
        this.A00 = c0906NaA00;
        this.A01 = z2;
        this.A05 = new ViewOnClickListenerC0846Kr(c1365c7.A06(), c1365c7.A05(), this.A00, c1365c7.A07(), c1365c7.A0C(), c1365c7.A0F(), c1365c7.A0A(), c1365c7.A09());
        this.A05.setRoundedCornersEnabled(A02());
        this.A05.setViewShowsOverMedia(A0A());
        this.A05.setV2Design(A04());
        YB.A0G(AdError.NO_FILL_ERROR_CODE, this.A05);
        this.A06 = new C1348bq(this.A03, this.A00, this.A01, A03(), A0B());
        YB.A0K(this.A06);
    }

    public final C1253aJ A00(C1648gi c1648gi, AbstractC1813jd abstractC1813jd, VI vi, EnumC1256aM enumC1256aM, InterfaceC1189Yh interfaceC1189Yh) {
        this.A02 = AbstractC1258aO.A01(c1648gi, true, abstractC1813jd, vi, interfaceC1189Yh, enumC1256aM, AbstractC1255aL.A00(abstractC1813jd));
        YB.A0K(this.A02);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (abstractC1813jd.A2U()) {
            layoutParams.setMargins(XV.A0b, XV.A0r, 0, 0);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else {
            layoutParams.setMargins(XV.A0b, 0, 0, XV.A0b);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
        this.A02.setLayoutParams(layoutParams);
        return this.A02;
    }

    public final C1257aN A01(C1648gi c1648gi, EnumC1256aM enumC1256aM) {
        C1257aN c1257aNA02 = AbstractC1258aO.A02(c1648gi, enumC1256aM, this.A07.A05());
        YB.A0K(c1257aNA02);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(XV.A0b, 0, 0, XV.A0b);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        c1257aNA02.setLayoutParams(layoutParams);
        return c1257aNA02;
    }

    public boolean A02() {
        return true;
    }

    public boolean A03() {
        return true;
    }

    public final boolean A04() {
        if (this.A07.A05().A29().A0H().A07() == null) {
            return this.A07.A05().A1w() || this.A07.A05().A1y();
        }
        return this.A07.A05().A1n();
    }

    public boolean A0A() {
        return true;
    }

    public boolean A0B() {
        return true;
    }

    public EnumC0897Mq A1B(String str) {
        return getCtaButton().A0E(str);
    }

    public void A1C() {
        if (this.A02 != null) {
            this.A02.A0O();
        }
    }

    public void A1D() {
    }

    public void A1E() {
    }

    public void A1F() {
    }

    public void A1G() {
    }

    public void A1H(NR nr, String str, double d3, Bundle bundle) {
        this.A06.A04(nr.A0I().A0F(), nr.A0I().A04(), null, false, !A1O() && d3 > 0.0d && d3 < 1.0d);
        this.A05.setCta(nr.A0J(), str, new HashMap());
    }

    public void A1I(C4K c4k) {
    }

    public void A1J(E1 e12) {
    }

    public void A1K(C4A c4a, int i3) {
    }

    public void A1L(boolean z2) {
        if (!z2 && this.A02 != null) {
            this.A02.A0P();
        }
    }

    public boolean A1M() {
        return false;
    }

    public boolean A1N() {
        return true;
    }

    public boolean A1P(boolean z2) {
        return false;
    }

    public C1648gi getAdContextWrapper() {
        return this.A03;
    }

    public VA getAdEventManager() {
        return this.A04;
    }

    public int getCloseButtonStyle() {
        return 0;
    }

    public C0906Na getColors() {
        return this.A00;
    }

    public ViewOnClickListenerC0846Kr getCtaButton() {
        return this.A05;
    }

    public C1348bq getTitleDescContainer() {
        return this.A06;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C0906Na c0906NaA00;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            c0906NaA00 = this.A07.A05().A28().A01();
        } else {
            c0906NaA00 = this.A07.A05().A28().A00();
        }
        this.A00 = c0906NaA00;
        this.A05.setViewShowsOverMedia(A0A());
        this.A05.setUpButtonColors(this.A00);
        this.A06.A03(this.A00, this.A01);
    }

    public void setAccidentalClickCappingListener(InterfaceC0898Mr interfaceC0898Mr) {
        getCtaButton().getCtaActionHelper().A07(interfaceC0898Mr);
    }

    public void setChainedWatchAndBrowseSkippableStatus(boolean z2) {
    }
}

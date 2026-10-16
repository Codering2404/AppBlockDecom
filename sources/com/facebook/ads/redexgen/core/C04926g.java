package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04926g extends AbstractC0948Oq {
    public static String[] A0E = {"vPMRmT88mgqFEke8ATcV4DjUXhfKSOnR", "vcxzG3inNeckkmEQerBRT2lbis8VS7m7", "eUyvpit7R4E8S", "81xoNnBskiL3NHuExK0jouL0xNUbAz24", "9rRUUXnOqMhF40SMgnak6Kzhg0roR6HI", "NGPySEd1uSK0pWi3", "38FqFi34P3eGFZ4PzNWUjtJ56H9UGtdy", "zzAANKTeXLAH5LLCmw3IQOJWh4jGOg5d"};
    public C4L A00;
    public boolean A01;
    public boolean A02;
    public final ViewGroup A03;
    public final C1054Sx A04;
    public final VA A05;
    public final C0685Ek A06;
    public final EA A07;
    public final E8 A08;
    public final C0658Dj A09;
    public final ViewOnClickListenerC0655Dg A0A;
    public final C0654Df A0B;
    public final AbstractC1592fo A0C;
    public final C1593fp A0D;

    public C04926g(C1648gi c1648gi, VA va, C1054Sx c1054Sx, VI vi, View.OnClickListener onClickListener, AbstractC1813jd abstractC1813jd) {
        super(c1648gi, onClickListener, vi, abstractC1813jd);
        this.A02 = false;
        this.A01 = false;
        this.A07 = new EA() { // from class: com.facebook.ads.redexgen.X.6p
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4K c4k) {
                if (C1098Up.A1T(((AbstractC0948Oq) this.A00).A08)) {
                    this.A00.A06.A0e(EnumC1535et.A02, 30);
                }
            }
        };
        this.A08 = new C05006o(this);
        this.A05 = va;
        this.A04 = c1054Sx;
        this.A0C = A00();
        this.A0D = A07();
        this.A03 = new FrameLayout(c1648gi);
        addView(this.A03, new RelativeLayout.LayoutParams(-1, -1));
        this.A06 = A01(vi);
        this.A0A = A04();
        this.A09 = A03();
        this.A0B = A06(vi);
        YB.A0K(this.A0B);
        A0F();
    }

    private C0947Op A00() {
        return new C0947Op(this);
    }

    private C0685Ek A01(VI vi) {
        C0685Ek c0685Ek = new C0685Ek(super.A08);
        YB.A0K(c0685Ek);
        c0685Ek.setFunnelLoggingHandler(vi);
        c0685Ek.getEventBus().A03(this.A07, this.A08);
        if (C1098Up.A1V(super.A08)) {
            c0685Ek.setVolume(0.0f);
        }
        if (!C1098Up.A1Q(super.A08)) {
            c0685Ek.setOnClickListener(new ViewOnClickListenerC1206Yy(this));
        }
        RelativeLayout.LayoutParams videoLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        videoLayoutParams.addRule(13);
        addView(c0685Ek, videoLayoutParams);
        return c0685Ek;
    }

    private C0658Dj A03() {
        C0658Dj c0658Dj = new C0658Dj(super.A08);
        c0658Dj.setTextColor(-1);
        YB.A0a(c0658Dj, false, 12);
        c0658Dj.setGravity(17);
        this.A06.A0f(c0658Dj);
        return c0658Dj;
    }

    private ViewOnClickListenerC0655Dg A04() {
        ViewOnClickListenerC0655Dg viewOnClickListenerC0655Dg = new ViewOnClickListenerC0655Dg(super.A08);
        this.A06.A0f(viewOnClickListenerC0655Dg);
        return viewOnClickListenerC0655Dg;
    }

    private C0654Df A06(VI vi) {
        C0654Df c0654Df = new C0654Df(super.A08, vi, true);
        c0654Df.setBackgroundPaintColor(855638016);
        this.A06.A0f(c0654Df);
        return c0654Df;
    }

    private C1593fp A07() {
        return new C1593fp(this, 50, true, new WeakReference(this.A0C), super.A08);
    }

    private void A08() {
        if (getVisibility() == 0 && this.A01 && hasWindowFocus()) {
            this.A0D.A0U();
            return;
        }
        if (super.A05 != null) {
            super.A05.A0P();
        }
        this.A0D.A0V();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0948Oq
    public final void A0D() {
        this.A0D.A0V();
        this.A06.getEventBus().A04(this.A07, this.A08);
        this.A06.A0W();
        if (super.A05 != null) {
            super.A05.A0O();
        }
        YB.A0J(this.A06);
        if (this.A00 != null) {
            C4L c4l = this.A00;
            if (A0E[1].charAt(6) != 'i') {
                throw new RuntimeException();
            }
            A0E[6] = "QSSPJpdXUUt8XbGqouva3DO5ILergMU2";
            c4l.A0p();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0948Oq
    public final void A0E() {
        super.A0E();
        this.A0B.A09();
        this.A02 = true;
        this.A0D.A0U();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0948Oq
    public final void A0F() {
        super.A0F();
        if (C1098Up.A1W(super.A08)) {
            YB.A0J(this.A0A);
            this.A0A.setLayoutParams(A0C(true, false));
            addView(this.A0A);
        }
        if (C1098Up.A1S(super.A08)) {
            YB.A0J(this.A09);
            this.A09.setLayoutParams(A0C(true, true));
            addView(this.A09);
        }
        if (C1098Up.A1U(super.A08)) {
            YB.A0J(this.A0B);
            this.A0B.setLayoutParams(A0C(false, false));
            addView(this.A0B);
        }
        C1239a5 c1239a5 = super.A04;
        if (A0E[6].charAt(23) != '5') {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[5] = "QWCSfSUWuFerXIpv";
        strArr[2] = "7tLHnRgEmKXMN";
        if (c1239a5 != null) {
            YB.A0J(super.A04);
            if (C1098Up.A1U(super.A08)) {
                super.A04.setLayoutParams(AbstractC0948Oq.A0A(this.A0B));
            } else {
                super.A04.setLayoutParams(AbstractC0948Oq.A0A(null));
            }
            addView(super.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0948Oq
    public final boolean A0G() {
        return this.A06.A0l();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0948Oq
    public final boolean A0H() {
        if (getMeasuredWidth() <= 0 || this.A06.getMeasuredWidth() <= 0) {
            return true;
        }
        int measuredWidth = (int) (((double) (getMeasuredWidth() - this.A06.getMeasuredWidth())) / 2.0d);
        int i3 = AbstractC0948Oq.A0D;
        int widthGap = AbstractC0948Oq.A0C;
        return measuredWidth > i3 + (widthGap * 2);
    }

    public final C04926g A0I(String str, String str2, String str3, String str4, String str5) {
        this.A06.setVideoURI(this.A04.A0T(str2));
        this.A00 = new C4L(super.A08, this.A05, this.A06, str);
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            new LM(this.A03, super.A08).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C0946Oo(this)).A07(str3);
        }
        if (str5 != null) {
            this.A0A.setPlayAccessibilityLabel(str4);
        }
        if (str5 != null) {
            this.A0A.setPauseAccessibilityLabel(str5);
        }
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0948Oq
    public int getMediaViewId() {
        return this.A06.getId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A01 = true;
        A08();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A01 = false;
        A08();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        A08();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        A08();
    }
}

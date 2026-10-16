package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1397cd extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final ViewOnClickListenerC0846Kr A02;
    public static final int A05 = (int) (XX.A02 * 36.0f);
    public static final int A06 = (int) (XX.A02 * 36.0f);
    public static final int A03 = (int) (XX.A02 * 23.0f);
    public static final int A04 = (int) (XX.A02 * 3.0f);
    public static final int A07 = (int) (XX.A02 * 4.0f);

    public C1397cd(C1648gi c1648gi, ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr, AbstractC1813jd abstractC1813jd, VA va, InterfaceC1189Yh interfaceC1189Yh, C1593fp c1593fp, Y2 y2, C0906Na c0906Na, InterfaceC1326bU interfaceC1326bU) {
        super(c1648gi);
        this.A00 = c0906Na.A09(true);
        this.A01 = new RelativeLayout(c1648gi);
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(c1648gi, abstractC1813jd.A29().A0J().A04());
        if (viewOnClickListenerC0846Kr == null) {
            this.A02 = new ViewOnClickListenerC0846Kr(c1648gi, abstractC1813jd.A0w(), (C0906Na) null, va, interfaceC1189Yh, c1593fp, y2, abstractC1813jd.A2A());
        } else {
            this.A02 = viewOnClickListenerC0846Kr;
        }
        A03();
        this.A02.setCta(abstractC1813jd.A29().A0J(), abstractC1813jd.A2E(), new HashMap(), interfaceC1326bU);
        this.A02.setIsInAppBrowser(true);
        FrameLayout.LayoutParams ctaButtonParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.A02, ctaButtonParams);
    }

    private void A00(C1648gi c1648gi, View view) {
        ImageView imageView = new ImageView(c1648gi);
        imageView.setImageBitmap(YN.A01(YM.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A03, A03);
        imageView.setPadding(A04, A04, A04, A04);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C1648gi c1648gi, String str) {
        Button button = new Button(c1648gi);
        YB.A0K(button);
        button.setPadding(A06, 0, A06, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        YB.A0Q(button, this.A00, A07);
        button.setTextColor(-16777216);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c1648gi, button);
    }

    public final EnumC0897Mq A02(String str) {
        return this.A02.A0E(str);
    }

    public final void A03() {
        this.A02.setBackgroundColor(0);
        this.A02.setTextColor(0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC1813jd abstractC1813jd, AbstractC1183Yb abstractC1183Yb) {
        this.A02.A0F(abstractC1813jd, abstractC1183Yb);
    }

    public void setCta(C0908Nc c0908Nc, String str, HashMap<String, String> extras, InterfaceC1326bU interfaceC1326bU) {
        this.A02.setCta(c0908Nc, str, extras, interfaceC1326bU);
    }
}

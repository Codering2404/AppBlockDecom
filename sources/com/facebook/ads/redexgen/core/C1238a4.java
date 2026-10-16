package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1238a4 extends LinearLayout {
    public final Handler A00;
    public final ImageView A01;
    public final ImageView A02;
    public final C0918Nm A03;
    public final C0938Og A04;
    public final C1648gi A05;
    public final VI A06;
    public final InterfaceC1189Yh A07;
    public final Runnable A08;
    public final String A09;

    public C1238a4(C1648gi c1648gi, AbstractC1813jd abstractC1813jd, VI vi, InterfaceC1189Yh interfaceC1189Yh) {
        super(c1648gi);
        this.A00 = new Handler(Looper.getMainLooper());
        this.A08 = new RunnableC1236a2(this);
        this.A05 = c1648gi;
        this.A09 = abstractC1813jd.A2E();
        this.A03 = abstractC1813jd.A2C();
        this.A07 = interfaceC1189Yh;
        this.A06 = vi;
        this.A04 = AbstractC0939Oh.A00(c1648gi.A02());
        this.A01 = A01(YM.AD_CHOICE_V2_COLLAPSE, 1104);
        addView(this.A01);
        this.A02 = A01(YM.AD_CHOICE_V2_EXPAND, 1105);
        addView(this.A02);
        A07(8);
        setOnClickListener(new ViewOnClickListenerC1237a3(this));
    }

    private final ImageView A01(YM ym, int i3) {
        ImageView imageView = new ImageView(this.A05);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setImageBitmap(YN.A01(ym));
        YB.A0G(i3, imageView);
        return imageView;
    }

    public final void A04() {
        this.A00.removeCallbacksAndMessages(null);
    }

    public final void A05() {
        this.A00.removeCallbacks(this.A08);
        A07(8);
    }

    public final void A06() {
        if (this.A06 != null) {
            this.A06.A04(VH.A0A, null);
        }
        if (this.A04.A0O(this.A05.A02(), true)) {
            this.A07.AAo(this.A09, this.A03);
        } else {
            if (TextUtils.isEmpty(this.A03.A00())) {
                return;
            }
            X6.A0O(new X6(), this.A05, XB.A00(this.A03.A00()), this.A09);
        }
    }

    public final void A07(int i3) {
        if (i3 == 0) {
            this.A02.setVisibility(0);
            this.A01.setVisibility(8);
        } else {
            this.A02.setVisibility(8);
            this.A01.setVisibility(0);
        }
    }
}

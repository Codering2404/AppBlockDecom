package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MC extends AbstractC1211Zd {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final C0938Og A03;
    public final C1648gi A04;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 24);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-52, -21, -19, -11, Framer.EXIT_FRAME_PREFIX, -95, -92, -88, -102, 85, 118, -103, 85, -121, -102, -91, -92, -89, -87, -98, -93, -100};
    }

    static {
        A01();
        A08 = (int) (XX.A02 * 8.0f);
        A07 = (int) (XX.A02 * 10.0f);
        A06 = (int) (XX.A02 * 44.0f);
    }

    public MC(C1648gi c1648gi, VA va, String str) {
        super(c1648gi, va, str);
        this.A04 = c1648gi;
        this.A03 = AbstractC0939Oh.A00(this.A04.A02());
        this.A00 = new ImageView(getContext());
        this.A00.setPadding(A07, A07, A07, A07);
        this.A00.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A06, A06);
        layoutParams.gravity = 3;
        this.A00.setLayoutParams(layoutParams);
        this.A02 = new ScrollView(getContext());
        this.A02.setFillViewport(true);
        YB.A0N(this.A02, -218103809);
        this.A01 = new LinearLayout(getContext());
        this.A01.setOrientation(1);
        this.A01.setPadding(A08, A08, A08, A08);
        this.A02.addView(this.A01, new FrameLayout.LayoutParams(-1, -2));
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0O() {
        this.A00.setImageBitmap(YN.A01(YM.CROSS));
        this.A00.setOnClickListener(new ViewOnClickListenerC1230Zw(this));
        this.A00.setContentDescription(A00(4, 18, 29));
        C1215Zh c1215Zh = new C1215Zh(this.A04);
        c1215Zh.setData(this.A03.A0H(), YM.HIDE_AD);
        c1215Zh.setOnClickListener(new ViewOnClickListenerC1231Zx(this, c1215Zh));
        C1215Zh c1215Zh2 = new C1215Zh(this.A04);
        c1215Zh2.setData(this.A03.A0L(), YM.REPORT_AD);
        c1215Zh2.setOnClickListener(new ViewOnClickListenerC1232Zy(this, c1215Zh2));
        C1215Zh c1215Zh3 = new C1215Zh(this.A04);
        c1215Zh3.setData(this.A03.A0M(), YM.AD_CHOICES_ICON);
        c1215Zh3.setOnClickListener(new ViewOnClickListenerC1233Zz(this, c1215Zh3));
        LinearLayout.LayoutParams menuParams = new LinearLayout.LayoutParams(-2, -2);
        menuParams.setMargins(A08, A08, A08, A08);
        menuParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        YB.A0W(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(linearLayout, layoutParams);
        linearLayout.addView(c1215Zh, menuParams);
        linearLayout.addView(c1215Zh2, menuParams);
        linearLayout.addView(c1215Zh3, menuParams);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0P() {
        YB.A0I(this);
        YB.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0Q(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi) {
        String strA0H;
        YM ym;
        int i3;
        this.A00.setOnClickListener(null);
        if (enumC0940Oi == EnumC0940Oi.A06) {
            strA0H = this.A03.A0F();
            ym = YM.REPORT_AD;
            i3 = -552389;
        } else {
            strA0H = this.A03.A0H();
            ym = YM.HIDE_AD;
            i3 = -13272859;
        }
        C1208Za c1208ZaA0H = new C1208Za(this.A04, this.A0D).A0H(strA0H);
        String title = this.A03.A0D();
        C1208Za c1208ZaA0G = c1208ZaA0H.A0G(title);
        String title2 = c0942Ok.A04();
        C1209Zb adHiddenView = c1208ZaA0G.A0E(title2).A0J(false).A0D(ym).A0C(i3).A0K(false).A0I(false).A0L();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        YB.A0W(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(adHiddenView, layoutParams);
        super.A0Q(c0942Ok, enumC0940Oi);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0R(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi) {
        boolean isReportFlow = enumC0940Oi == EnumC0940Oi.A06;
        C1229Zv c1229Zv = new C1229Zv(this.A04, c0942Ok, this.A0D, isReportFlow ? YM.REPORT_AD : YM.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(YN.A01(YM.BACK_ARROW));
        this.A00.setOnClickListener(new ViewOnClickListenerC1234a0(this));
        this.A00.setContentDescription(A00(0, 4, 114));
        YB.A0W(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(c1229Zv, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final boolean A0S() {
        return true;
    }
}

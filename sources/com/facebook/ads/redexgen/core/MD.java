package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MD extends AbstractC1211Zd {
    public static byte[] A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public final HorizontalScrollView A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final LinearLayout A03;
    public final C0938Og A04;
    public final C1648gi A05;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{3, 32, 34, 42, 3, 44, 47, 51, 37, 96, 1, 36, 96, Ascii.DC2, 37, 48, 47, Framer.STDERR_FRAME_PREFIX, 52, 41, 46, 39};
    }

    static {
        A01();
        A09 = (int) (XX.A02 * 4.0f);
        A08 = (int) (XX.A02 * 10.0f);
        A07 = (int) (XX.A02 * 44.0f);
    }

    public MD(C1648gi c1648gi, VA va, String str) {
        super(c1648gi, va, str);
        this.A05 = c1648gi;
        this.A04 = AbstractC0939Oh.A00(c1648gi.A02());
        this.A01 = new ImageView(getContext());
        this.A01.setPadding(A08, A08, A08, A08);
        this.A01.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A01.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A07, A07);
        layoutParams.gravity = 16;
        this.A02 = new LinearLayout(getContext());
        this.A02.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        this.A00 = new HorizontalScrollView(getContext());
        this.A00.setHorizontalScrollBarEnabled(false);
        this.A00.setLayoutParams(layoutParams2);
        this.A00.addView(this.A02, layoutParams2);
        this.A03 = new LinearLayout(getContext());
        this.A03.setOrientation(0);
        YB.A0N(this.A03, -218103809);
        this.A03.setMotionEventSplittingEnabled(false);
        this.A03.addView(this.A01, layoutParams);
        this.A03.addView(this.A00, layoutParams2);
        addView(this.A03, new FrameLayout.LayoutParams(-1, -1));
        this.A03.setClickable(true);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0O() {
        this.A01.setImageBitmap(YN.A01(YM.CROSS));
        this.A01.setOnClickListener(new ViewOnClickListenerC1220Zm(this));
        this.A01.setContentDescription(A00(4, 18, 84));
        C1215Zh c1215Zh = new C1215Zh(this.A05);
        c1215Zh.setData(this.A04.A0H(), YM.HIDE_AD);
        c1215Zh.setOnClickListener(new ViewOnClickListenerC1221Zn(this, c1215Zh));
        C1215Zh c1215Zh2 = new C1215Zh(this.A05);
        c1215Zh2.setData(this.A04.A0L(), YM.REPORT_AD);
        c1215Zh2.setOnClickListener(new ViewOnClickListenerC1222Zo(this, c1215Zh2));
        C1215Zh c1215Zh3 = new C1215Zh(this.A05);
        c1215Zh3.setData(this.A04.A0M(), YM.AD_CHOICES_ICON);
        c1215Zh3.setOnClickListener(new ViewOnClickListenerC1223Zp(this, c1215Zh3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A09, A09, A09);
        YB.A0W(this.A03);
        this.A02.removeAllViews();
        this.A02.addView(c1215Zh, layoutParams);
        this.A02.addView(c1215Zh2, layoutParams);
        this.A02.addView(c1215Zh3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0P() {
        YB.A0I(this);
        YB.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0Q(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi) {
        this.A01.setOnClickListener(null);
        TextView textView = new TextView(getContext());
        YB.A0a(textView, true, 14);
        textView.setText(this.A04.A0D());
        textView.setGravity(17);
        YB.A0W(this.A03);
        this.A03.removeAllViews();
        this.A03.addView(textView, new LinearLayout.LayoutParams(-1, -1));
        super.A0Q(c0942Ok, enumC0940Oi);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final void A0R(C0942Ok c0942Ok, EnumC0940Oi enumC0940Oi) {
        YB.A0W(this.A03);
        this.A01.setImageBitmap(YN.A01(YM.BACK_ARROW));
        this.A01.setOnClickListener(new ViewOnClickListenerC1224Zq(this));
        this.A01.setContentDescription(A00(0, 4, 85));
        this.A02.removeAllViews();
        this.A00.fullScroll(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A09, A09, A09);
        for (C0942Ok c0942Ok2 : c0942Ok.A05()) {
            C1215Zh c1215Zh = new C1215Zh(this.A05);
            c1215Zh.setData(c0942Ok2.A04(), null);
            c1215Zh.setOnClickListener(new ViewOnClickListenerC1225Zr(this, c1215Zh, c0942Ok2));
            this.A02.addView(c1215Zh, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1211Zd
    public final boolean A0S() {
        return true;
    }
}

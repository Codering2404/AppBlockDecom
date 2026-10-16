package com.facebook.ads.redexgen.core;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1532eq extends RelativeLayout {
    public static String[] A04 = {"Ym3c0mHmt8I3OfABPCOx9UJ2Q16UuduY", "K4DkQJV", "KARr27mhou56jkSxhuic5Eo8", "doL6IsbVcBXoE3lEPdAb4lspmNlkYQBg", "ZiamaIcezCYLNnFM0CzM2w39hefukKsr", "QAAEQWAERntefxGdirzkY0W9ygCVb18Z", "ecvamyNjiJSZyZ2FY2suHBqgS12IICXX", "BDk4Rb0w5P1ojifCZQT7pVNvZTakDsaU"};
    public static final int A05 = (int) (XX.A02 * 4.0f);
    public int A00;
    public C3S A01;
    public WeakReference<InterfaceC1531ep> A02;
    public final InterfaceC1588fk A03;

    public C1532eq(C1648gi c1648gi, InterfaceC1588fk interfaceC1588fk) {
        super(c1648gi);
        this.A00 = 0;
        this.A03 = interfaceC1588fk;
        YB.A0J((View) this.A03);
        addView(this.A03.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    private void A00(AnimatorSet animatorSet, final int i3, final boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.ads.redexgen.X.em
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.A01.A04(z2, i3, valueAnimator);
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat);
    }

    public final void A01(AnimatorSet animatorSet, boolean z2) {
        if (z2) {
            this.A03.getView().setClipToOutline(true);
            C1529en c1529en = new C1529en(this);
            this.A03.getView().setOutlineProvider(c1529en);
            if (this.A01 != null) {
                this.A01.setClipToOutline(true);
                this.A01.setOutlineProvider(c1529en);
            }
            A00(animatorSet, A05, true);
            return;
        }
        this.A03.getView().setClipToOutline(false);
        this.A03.getView().setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        if (this.A01 != null) {
            this.A01.setClipToOutline(false);
            this.A01.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        A00(animatorSet, this.A00, false);
    }

    public final void A02(ED ed) {
        addView(ed, new RelativeLayout.LayoutParams(-1, -1));
        this.A01 = (C3S) ed;
    }

    public final void A03(ED ed) {
        YB.A0J(ed);
        this.A01 = null;
    }

    public final /* synthetic */ void A04(boolean z2, int i3, ValueAnimator valueAnimator) {
        float curInterpolatedTime = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (!z2) {
            curInterpolatedTime = 1.0f - curInterpolatedTime;
        }
        float interpolatedTime = i3;
        this.A00 = (int) (interpolatedTime * curInterpolatedTime);
        requestLayout();
    }

    public final boolean A05() {
        return this.A03.A9r();
    }

    public int getCurrentPosition() {
        return this.A03.getCurrentPosition();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        ((View) this.A03).layout(this.A00, this.A00, getWidth() - this.A00, getHeight() - this.A00);
        if (this.A01 != null) {
            this.A01.layout(this.A00, this.A00, getWidth() - this.A00, getHeight() - this.A00);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        boolean z2 = false;
        int heightSpecSize = this.A03.getVideoWidth() + (this.A00 * 2);
        int widthSpecMode = this.A03.getVideoHeight() + (this.A00 * 2);
        int width = getDefaultSize(heightSpecSize, i3);
        int height = getDefaultSize(widthSpecMode, i4);
        if (heightSpecSize > 0 && widthSpecMode > 0) {
            z2 = true;
            int mode = View.MeasureSpec.getMode(i3);
            int heightSpecMode = View.MeasureSpec.getSize(i3);
            int widthSpecSize = View.MeasureSpec.getMode(i4);
            int mVideoHeight = View.MeasureSpec.getSize(i4);
            if (mode != 1073741824 || widthSpecSize != 1073741824) {
                if (mode == 1073741824) {
                    width = heightSpecMode;
                    height = (width * widthSpecMode) / heightSpecSize;
                    if (widthSpecSize == Integer.MIN_VALUE && height > mVideoHeight) {
                        height = mVideoHeight;
                    }
                } else if (widthSpecSize == 1073741824) {
                    height = mVideoHeight;
                    width = (height * heightSpecSize) / widthSpecMode;
                    if (mode == Integer.MIN_VALUE && width > heightSpecMode) {
                        width = heightSpecMode;
                    }
                } else {
                    width = heightSpecSize;
                    height = widthSpecMode;
                    if (widthSpecSize == Integer.MIN_VALUE && height > mVideoHeight) {
                        height = mVideoHeight;
                        width = (height * heightSpecSize) / widthSpecMode;
                    }
                    if (mode == Integer.MIN_VALUE && width > heightSpecMode) {
                        width = heightSpecMode;
                        height = (width * widthSpecMode) / heightSpecSize;
                    }
                }
            } else {
                width = heightSpecMode;
                height = mVideoHeight;
                int mVideoWidth = heightSpecSize * height;
                if (mVideoWidth < width * widthSpecMode) {
                    int width2 = height * heightSpecSize;
                    String[] strArr = A04;
                    String str = strArr[2];
                    String str2 = strArr[1];
                    int mVideoWidth2 = str.length();
                    if (mVideoWidth2 == str2.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[5] = "U4zbj2Wm0uAraatZAyMG0dkAaN2sbGyV";
                    strArr2[7] = "NaQeXa1xIolrwrGsNa3PifVvRhjqFXGF";
                    width = width2 / widthSpecMode;
                } else {
                    int mVideoWidth3 = heightSpecSize * height;
                    if (mVideoWidth3 > width * widthSpecMode) {
                        height = (width * widthSpecMode) / heightSpecSize;
                    }
                }
            }
        }
        setMeasuredDimension(width, height);
        if (!z2 || this.A02 == null) {
            return;
        }
        WeakReference<InterfaceC1531ep> weakReference = this.A02;
        int mVideoWidth4 = A04[6].charAt(8);
        if (mVideoWidth4 != 105) {
            throw new RuntimeException();
        }
        A04[3] = "u6I59svdNPk3v5MrivI4HijRJO25VXOb";
        if (weakReference.get() != null) {
            this.A02.get().AGT();
        }
    }

    public void setRoundedCornersVideoStyle(float f3) {
        this.A03.getView().setClipToOutline(true);
        this.A03.getView().setOutlineProvider(new C1530eo(this, f3));
    }

    public void setViewImplInflationListener(InterfaceC1531ep interfaceC1531ep) {
        this.A02 = new WeakReference<>(interfaceC1531ep);
    }
}

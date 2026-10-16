package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1301b5 extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public C1301b5(C1648gi c1648gi) {
        super(c1648gi);
        this.A03 = new ImageView(c1648gi);
        this.A02 = new ImageView(c1648gi);
        A00();
    }

    public C1301b5(C1648gi c1648gi, AttributeSet attributeSet) {
        super(c1648gi, attributeSet);
        this.A03 = new ImageView(c1648gi, attributeSet);
        this.A02 = new ImageView(c1648gi, attributeSet);
        A00();
    }

    public C1301b5(C1648gi c1648gi, AttributeSet attributeSet, int i3) {
        super(c1648gi, attributeSet, i3);
        this.A03 = new ImageView(c1648gi, attributeSet, i3);
        this.A02 = new ImageView(c1648gi, attributeSet, i3);
        A00();
    }

    public C1301b5(C1648gi c1648gi, AttributeSet attributeSet, int i3, int i4) {
        super(c1648gi, attributeSet, i3, i4);
        this.A03 = new ImageView(c1648gi, attributeSet, i3, i4);
        this.A02 = new ImageView(c1648gi, attributeSet, i3, i4);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        EnumC1158Xc.A04(this.A03, EnumC1158Xc.A0B);
        setId(YB.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        if (this.A01 <= 0 || this.A00 <= 0) {
            super.onLayout(z2, i3, i4, i5, i6);
            return;
        }
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        float fMin = Math.min(i7 / this.A01, i8 / this.A00);
        int i9 = (int) (this.A01 * fMin);
        int i10 = (int) (this.A00 * fMin);
        this.A02.layout(i3, i4, i5, i6);
        int blurBorderViewHeight = (i7 / 2) + i3;
        int blurBorderViewWidth = (i8 / 2) + i4;
        this.A03.layout(blurBorderViewHeight - (i9 / 2), blurBorderViewWidth - (i10 / 2), (i9 / 2) + blurBorderViewHeight, blurBorderViewWidth + (i10 / 2));
        this.A02.setVisibility(0);
    }

    public void setImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            YB.A0V(this.A02, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            YB.A0N(this.A02, 0);
        }
        if (bitmap != null) {
            this.A01 = bitmap.getWidth();
            this.A00 = bitmap.getHeight();
            this.A03.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.A03.setImageDrawable(null);
    }
}

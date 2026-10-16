package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FadeThroughDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f81191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f81192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f81193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f81194d;

    public FadeThroughDrawable(Drawable drawable, Drawable drawable2) {
        this.f81191a = drawable.getConstantState().newDrawable().mutate();
        Drawable drawableMutate = drawable2.getConstantState().newDrawable().mutate();
        this.f81192b = drawableMutate;
        drawableMutate.setAlpha(0);
        this.f81193c = new float[2];
    }

    public void a(float f3) {
        if (this.f81194d != f3) {
            this.f81194d = f3;
            FadeThroughUtils.a(f3, this.f81193c);
            this.f81191a.setAlpha((int) (this.f81193c[0] * 255.0f));
            this.f81192b.setAlpha((int) (this.f81193c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f81191a.draw(canvas);
        this.f81192b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f81191a.getIntrinsicHeight(), this.f81192b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f81191a.getIntrinsicWidth(), this.f81192b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f81191a.getMinimumHeight(), this.f81192b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f81191a.getMinimumWidth(), this.f81192b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f81191a.isStateful() || this.f81192b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f81194d <= 0.5f) {
            this.f81191a.setAlpha(i3);
            this.f81192b.setAlpha(0);
        } else {
            this.f81191a.setAlpha(0);
            this.f81192b.setAlpha(i3);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i4, int i5, int i6) {
        super.setBounds(i3, i4, i5, i6);
        this.f81191a.setBounds(i3, i4, i5, i6);
        this.f81192b.setBounds(i3, i4, i5, i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f81191a.setColorFilter(colorFilter);
        this.f81192b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f81191a.setState(iArr) || this.f81192b.setState(iArr);
    }
}

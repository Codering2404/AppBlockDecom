package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f81202q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f81203r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f81204s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f81205t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f81206u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f81207v;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f81203r = new Rect();
        this.f81204s = new Rect();
        this.f81205t = 119;
        this.f81206u = true;
        this.f81207v = false;
        TypedArray typedArrayI = ThemeEnforcement.i(context, attributeSet, R.styleable.l3, i3, 0, new int[0]);
        this.f81205t = typedArrayI.getInt(R.styleable.n3, this.f81205t);
        Drawable drawable = typedArrayI.getDrawable(R.styleable.m3);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f81206u = typedArrayI.getBoolean(R.styleable.o3, true);
        typedArrayI.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f81202q;
        if (drawable != null) {
            if (this.f81207v) {
                this.f81207v = false;
                Rect rect = this.f81203r;
                Rect rect2 = this.f81204s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f81206u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f81205t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f3, float f4) {
        super.drawableHotspotChanged(f3, f4);
        Drawable drawable = this.f81202q;
        if (drawable != null) {
            drawable.setHotspot(f3, f4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f81202q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f81202q.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f81202q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f81205t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f81202q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        this.f81207v = z2 | this.f81207v;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f81207v = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f81202q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f81202q);
            }
            this.f81202q = drawable;
            this.f81207v = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f81205t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i3) {
        if (this.f81205t != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f81205t = i3;
            if (i3 == 119 && this.f81202q != null) {
                this.f81202q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f81202q;
    }
}

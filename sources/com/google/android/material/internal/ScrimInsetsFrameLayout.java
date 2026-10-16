package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Drawable f81255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Rect f81256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f81257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f81258d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f81259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f81260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f81261h;

    /* JADX INFO: renamed from: com.google.android.material.internal.ScrimInsetsFrameLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScrimInsetsFrameLayout f81262a;

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.f81262a;
            if (scrimInsetsFrameLayout.f81256b == null) {
                scrimInsetsFrameLayout.f81256b = new Rect();
            }
            this.f81262a.f81256b.set(windowInsetsCompat.k(), windowInsetsCompat.m(), windowInsetsCompat.l(), windowInsetsCompat.j());
            this.f81262a.g(windowInsetsCompat);
            this.f81262a.setWillNotDraw(!windowInsetsCompat.o() || this.f81262a.f81255a == null);
            ViewCompat.d0(this.f81262a);
            return windowInsetsCompat.c();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f81256b == null || this.f81255a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f81258d) {
            this.f81257c.set(0, 0, width, this.f81256b.top);
            this.f81255a.setBounds(this.f81257c);
            this.f81255a.draw(canvas);
        }
        if (this.f81259f) {
            this.f81257c.set(0, height - this.f81256b.bottom, width, height);
            this.f81255a.setBounds(this.f81257c);
            this.f81255a.draw(canvas);
        }
        if (this.f81260g) {
            Rect rect = this.f81257c;
            Rect rect2 = this.f81256b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f81255a.setBounds(this.f81257c);
            this.f81255a.draw(canvas);
        }
        if (this.f81261h) {
            Rect rect3 = this.f81257c;
            Rect rect4 = this.f81256b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f81255a.setBounds(this.f81257c);
            this.f81255a.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f81255a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f81255a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z2) {
        this.f81259f = z2;
    }

    public void setDrawLeftInsetForeground(boolean z2) {
        this.f81260g = z2;
    }

    public void setDrawRightInsetForeground(boolean z2) {
        this.f81261h = z2;
    }

    public void setDrawTopInsetForeground(boolean z2) {
        this.f81258d = z2;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f81255a = drawable;
    }

    protected void g(WindowInsetsCompat windowInsetsCompat) {
    }
}

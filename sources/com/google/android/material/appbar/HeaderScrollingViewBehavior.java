package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f79960d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Rect f79961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f79962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f79963h;

    public HeaderScrollingViewBehavior() {
        this.f79960d = new Rect();
        this.f79961f = new Rect();
        this.f79962g = 0;
    }

    private static int T(int i3) {
        if (i3 == 0) {
            return 8388659;
        }
        return i3;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void L(CoordinatorLayout coordinatorLayout, View view, int i3) {
        View viewN = N(coordinatorLayout.v(view));
        if (viewN == null) {
            super.L(coordinatorLayout, view, i3);
            this.f79962g = 0;
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        Rect rect = this.f79960d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, viewN.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + viewN.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.v(coordinatorLayout) && !ViewCompat.v(view)) {
            rect.left += lastWindowInsets.k();
            rect.right -= lastWindowInsets.l();
        }
        Rect rect2 = this.f79961f;
        GravityCompat.a(T(layoutParams.f33465c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i3);
        int iO = O(viewN);
        view.layout(rect2.left, rect2.top - iO, rect2.right, rect2.bottom - iO);
        this.f79962g = rect2.top - viewN.getBottom();
    }

    abstract View N(List list);

    final int O(View view) {
        if (this.f79963h == 0) {
            return 0;
        }
        float fP = P(view);
        int i3 = this.f79963h;
        return MathUtils.b((int) (fP * i3), 0, i3);
    }

    float P(View view) {
        return 1.0f;
    }

    public final int Q() {
        return this.f79963h;
    }

    int R(View view) {
        return view.getMeasuredHeight();
    }

    final int S() {
        return this.f79962g;
    }

    public final void U(int i3) {
        this.f79963h = i3;
    }

    protected boolean V() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
        View viewN;
        WindowInsetsCompat lastWindowInsets;
        int i7 = view.getLayoutParams().height;
        if ((i7 != -1 && i7 != -2) || (viewN = N(coordinatorLayout.v(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.v(viewN) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.m() + lastWindowInsets.j();
        }
        int iR = size + R(viewN);
        int measuredHeight = viewN.getMeasuredHeight();
        if (V()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iR -= measuredHeight;
        }
        coordinatorLayout.N(view, i3, i4, View.MeasureSpec.makeMeasureSpec(iR, i7 == -1 ? 1073741824 : Integer.MIN_VALUE), i6);
        return true;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79960d = new Rect();
        this.f79961f = new Rect();
        this.f79962g = 0;
    }
}

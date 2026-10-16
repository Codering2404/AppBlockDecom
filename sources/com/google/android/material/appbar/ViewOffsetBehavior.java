package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewOffsetHelper f79969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f79970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f79971c;

    public ViewOffsetBehavior() {
        this.f79970b = 0;
        this.f79971c = 0;
    }

    public int K() {
        ViewOffsetHelper viewOffsetHelper = this.f79969a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.c();
        }
        return 0;
    }

    protected void L(CoordinatorLayout coordinatorLayout, View view, int i3) {
        coordinatorLayout.M(view, i3);
    }

    public boolean M(int i3) {
        ViewOffsetHelper viewOffsetHelper = this.f79969a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.f(i3);
        }
        this.f79970b = i3;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i3) {
        L(coordinatorLayout, view, i3);
        if (this.f79969a == null) {
            this.f79969a = new ViewOffsetHelper(view);
        }
        this.f79969a.d();
        this.f79969a.a();
        int i4 = this.f79970b;
        if (i4 != 0) {
            this.f79969a.f(i4);
            this.f79970b = 0;
        }
        int i5 = this.f79971c;
        if (i5 == 0) {
            return true;
        }
        this.f79969a.e(i5);
        this.f79971c = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79970b = 0;
        this.f79971c = 0;
    }
}

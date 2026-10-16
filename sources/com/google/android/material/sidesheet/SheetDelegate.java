package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class SheetDelegate {
    SheetDelegate() {
    }

    abstract int a(ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract float b(int i3);

    abstract int c(ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract int d();

    abstract int e();

    abstract int f();

    abstract int g();

    abstract int h(View view);

    abstract int i(CoordinatorLayout coordinatorLayout);

    abstract int j();

    abstract boolean k(float f3);

    abstract boolean l(View view);

    abstract boolean m(float f3, float f4);

    abstract boolean n(View view, float f3);

    abstract void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i3);

    abstract void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i3, int i4);
}

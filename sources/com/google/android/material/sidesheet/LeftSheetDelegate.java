package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class LeftSheetDelegate extends SheetDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f81917a;

    LeftSheetDelegate(SideSheetBehavior sideSheetBehavior) {
        this.f81917a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    float b(int i3) {
        float fE = e();
        return (i3 - fE) / (d() - fE);
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int d() {
        return Math.max(0, this.f81917a.q0() + this.f81917a.o0());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int e() {
        return (-this.f81917a.h0()) - this.f81917a.o0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int f() {
        return this.f81917a.o0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int g() {
        return -this.f81917a.h0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int h(View view) {
        return view.getRight() + this.f81917a.o0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int j() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean k(float f3) {
        return f3 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean l(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean m(float f3, float f4) {
        return SheetUtils.a(f3, f4) && Math.abs(f3) > ((float) this.f81917a.s0());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean n(View view, float f3) {
        return Math.abs(((float) view.getLeft()) + (f3 * this.f81917a.m0())) > this.f81917a.n0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.leftMargin = i3;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i3, int i4) {
        if (i3 <= this.f81917a.r0()) {
            marginLayoutParams.leftMargin = i4;
        }
    }
}

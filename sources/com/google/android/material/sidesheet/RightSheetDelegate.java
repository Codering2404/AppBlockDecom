package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class RightSheetDelegate extends SheetDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f81918a;

    RightSheetDelegate(SideSheetBehavior sideSheetBehavior) {
        this.f81918a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    float b(int i3) {
        float fE = e();
        return (fE - i3) / (fE - d());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int d() {
        return Math.max(0, (e() - this.f81918a.h0()) - this.f81918a.o0());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int e() {
        return this.f81918a.r0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int f() {
        return this.f81918a.r0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int g() {
        return d();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int h(View view) {
        return view.getLeft() - this.f81918a.o0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int j() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean k(float f3) {
        return f3 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean l(View view) {
        return view.getLeft() > (e() + d()) / 2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean m(float f3, float f4) {
        return SheetUtils.a(f3, f4) && Math.abs(f3) > ((float) this.f81918a.s0());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean n(View view, float f3) {
        return Math.abs(((float) view.getRight()) + (f3 * this.f81918a.m0())) > this.f81918a.n0();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.rightMargin = i3;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i3, int i4) {
        int iR0 = this.f81918a.r0();
        if (i3 <= iR0) {
            marginLayoutParams.rightMargin = iR0 - i3;
        }
    }
}

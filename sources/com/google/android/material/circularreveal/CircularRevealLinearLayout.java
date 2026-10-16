package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CircularRevealLinearLayout extends LinearLayout implements CircularRevealWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CircularRevealHelper f80507a;

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void a() {
        this.f80507a.a();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void b() {
        this.f80507a.b();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.Delegate
    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.Delegate
    public boolean d() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f80507a;
        if (circularRevealHelper != null) {
            circularRevealHelper.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f80507a.e();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        return this.f80507a.f();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        return this.f80507a.h();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f80507a;
        return circularRevealHelper != null ? circularRevealHelper.j() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f80507a.k(drawable);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealScrimColor(int i3) {
        this.f80507a.l(i3);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setRevealInfo(CircularRevealWidget.RevealInfo revealInfo) {
        this.f80507a.m(revealInfo);
    }
}

package com.google.android.material.circularreveal.cardview;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CircularRevealCardView extends MaterialCardView implements CircularRevealWidget {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final CircularRevealHelper f80516t;

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void a() {
        this.f80516t.a();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void b() {
        this.f80516t.b();
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
        CircularRevealHelper circularRevealHelper = this.f80516t;
        if (circularRevealHelper != null) {
            circularRevealHelper.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f80516t.e();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        return this.f80516t.f();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        return this.f80516t.h();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f80516t;
        return circularRevealHelper != null ? circularRevealHelper.j() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f80516t.k(drawable);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealScrimColor(int i3) {
        this.f80516t.l(i3);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setRevealInfo(CircularRevealWidget.RevealInfo revealInfo) {
        this.f80516t.m(revealInfo);
    }
}

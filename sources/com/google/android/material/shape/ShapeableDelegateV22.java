package com.google.android.material.shape;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ShapeableDelegateV22 extends ShapeableDelegate {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f81911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f81912g;

    private float l() {
        RectF rectF;
        ShapeAppearanceModel shapeAppearanceModel = this.f81908c;
        if (shapeAppearanceModel == null || (rectF = this.f81909d) == null) {
            return 0.0f;
        }
        return shapeAppearanceModel.f81827f.a(rectF);
    }

    private void m(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.shape.ShapeableDelegateV22.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                ShapeableDelegateV22 shapeableDelegateV22 = ShapeableDelegateV22.this;
                if (shapeableDelegateV22.f81908c == null || shapeableDelegateV22.f81909d.isEmpty()) {
                    return;
                }
                ShapeableDelegateV22 shapeableDelegateV222 = ShapeableDelegateV22.this;
                RectF rectF = shapeableDelegateV222.f81909d;
                outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, shapeableDelegateV222.f81912g);
            }
        });
    }

    private boolean n() {
        ShapeAppearanceModel shapeAppearanceModel;
        if (this.f81909d.isEmpty() || (shapeAppearanceModel = this.f81908c) == null) {
            return false;
        }
        return shapeAppearanceModel.u(this.f81909d);
    }

    private boolean o() {
        ShapeAppearanceModel shapeAppearanceModel;
        if (!this.f81909d.isEmpty() && (shapeAppearanceModel = this.f81908c) != null && this.f81907b && !shapeAppearanceModel.u(this.f81909d) && p(this.f81908c)) {
            float fA = this.f81908c.r().a(this.f81909d);
            float fA2 = this.f81908c.t().a(this.f81909d);
            float fA3 = this.f81908c.j().a(this.f81909d);
            float fA4 = this.f81908c.l().a(this.f81909d);
            if (fA == 0.0f && fA3 == 0.0f && fA2 == fA4) {
                RectF rectF = this.f81909d;
                rectF.set(rectF.left - fA2, rectF.top, rectF.right, rectF.bottom);
                this.f81912g = fA2;
                return true;
            }
            if (fA == 0.0f && fA2 == 0.0f && fA3 == fA4) {
                RectF rectF2 = this.f81909d;
                rectF2.set(rectF2.left, rectF2.top - fA3, rectF2.right, rectF2.bottom);
                this.f81912g = fA3;
                return true;
            }
            if (fA2 == 0.0f && fA4 == 0.0f && fA == fA3) {
                RectF rectF3 = this.f81909d;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + fA, rectF3.bottom);
                this.f81912g = fA;
                return true;
            }
            if (fA3 == 0.0f && fA4 == 0.0f && fA == fA2) {
                RectF rectF4 = this.f81909d;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + fA);
                this.f81912g = fA;
                return true;
            }
        }
        return false;
    }

    private static boolean p(ShapeAppearanceModel shapeAppearanceModel) {
        return (shapeAppearanceModel.q() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.s() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.i() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.k() instanceof RoundedCornerTreatment);
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    void a(View view) {
        this.f81912g = l();
        this.f81911f = n() || o();
        view.setClipToOutline(!i());
        if (i()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    boolean i() {
        return !this.f81911f || this.f81906a;
    }
}

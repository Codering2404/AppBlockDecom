package com.google.android.material.transition.platform;

import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class FitModeEvaluators {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final FitModeEvaluator f82713a = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult a(float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            float fN = TransitionUtils.n(f6, f8, f4, f5, f3, true);
            float f10 = fN / f6;
            float f11 = fN / f8;
            return new FitModeResult(f10, f11, fN, f7 * f10, fN, f9 * f11);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            return fitModeResult.f82718d > fitModeResult.f82720f;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void c(RectF rectF, float f3, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.f82720f - fitModeResult.f82718d) * f3;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final FitModeEvaluator f82714b = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult a(float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            float fN = TransitionUtils.n(f7, f9, f4, f5, f3, true);
            float f10 = fN / f7;
            float f11 = fN / f9;
            return new FitModeResult(f10, f11, f6 * f10, fN, f8 * f11, fN);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            return fitModeResult.f82717c > fitModeResult.f82719e;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void c(RectF rectF, float f3, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.f82719e - fitModeResult.f82717c) / 2.0f) * f3;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    };

    static FitModeEvaluator a(int i3, boolean z2, RectF rectF, RectF rectF2) {
        if (i3 == 0) {
            return b(z2, rectF, rectF2) ? f82713a : f82714b;
        }
        if (i3 == 1) {
            return f82713a;
        }
        if (i3 == 2) {
            return f82714b;
        }
        throw new IllegalArgumentException("Invalid fit mode: " + i3);
    }

    private static boolean b(boolean z2, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        return z2 ? (fHeight2 * fWidth) / fWidth2 >= fHeight : (fWidth2 * fHeight) / fWidth >= fHeight2;
    }
}

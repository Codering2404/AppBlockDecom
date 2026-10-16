package com.google.android.material.transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class FadeModeEvaluators {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final FadeModeEvaluator f82569a = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f3, float f4, float f5, float f6) {
            return FadeModeResult.a(255, TransitionUtils.n(0, 255, f4, f5, f3));
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final FadeModeEvaluator f82570b = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f3, float f4, float f5, float f6) {
            return FadeModeResult.b(TransitionUtils.n(255, 0, f4, f5, f3), 255);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final FadeModeEvaluator f82571c = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f3, float f4, float f5, float f6) {
            return FadeModeResult.b(TransitionUtils.n(255, 0, f4, f5, f3), TransitionUtils.n(0, 255, f4, f5, f3));
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FadeModeEvaluator f82572d = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f3, float f4, float f5, float f6) {
            float f7 = ((f5 - f4) * f6) + f4;
            return FadeModeResult.b(TransitionUtils.n(255, 0, f4, f7, f3), TransitionUtils.n(0, 255, f7, f5, f3));
        }
    };

    static FadeModeEvaluator a(int i3, boolean z2) {
        if (i3 == 0) {
            return z2 ? f82569a : f82570b;
        }
        if (i3 == 1) {
            return z2 ? f82570b : f82569a;
        }
        if (i3 == 2) {
            return f82571c;
        }
        if (i3 == 3) {
            return f82572d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i3);
    }
}

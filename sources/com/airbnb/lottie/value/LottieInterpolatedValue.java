package com.airbnb.lottie.value;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f57134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f57135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interpolator f57136f;

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Object a(LottieFrameInfo lottieFrameInfo) {
        return e(this.f57134d, this.f57135e, this.f57136f.getInterpolation(lottieFrameInfo.e()));
    }

    abstract Object e(Object obj, Object obj2, float f3);
}

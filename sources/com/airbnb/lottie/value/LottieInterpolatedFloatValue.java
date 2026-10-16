package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object a(LottieFrameInfo lottieFrameInfo) {
        return super.a(lottieFrameInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float e(Float f3, Float f4, float f5) {
        return Float.valueOf(MiscUtils.i(f3.floatValue(), f4.floatValue(), f5));
    }
}

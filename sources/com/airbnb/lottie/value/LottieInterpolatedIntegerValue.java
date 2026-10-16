package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object a(LottieFrameInfo lottieFrameInfo) {
        return super.a(lottieFrameInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Integer e(Integer num, Integer num2, float f3) {
        return Integer.valueOf(MiscUtils.j(num.intValue(), num2.intValue(), f3));
    }
}

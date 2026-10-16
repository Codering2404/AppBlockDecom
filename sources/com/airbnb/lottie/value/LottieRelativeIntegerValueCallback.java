package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    public Integer e(LottieFrameInfo lottieFrameInfo) {
        Object obj = this.f57140c;
        if (obj != null) {
            return (Integer) obj;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // com.airbnb.lottie.value.LottieValueCallback
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Integer a(LottieFrameInfo lottieFrameInfo) {
        return Integer.valueOf(MiscUtils.j(((Integer) lottieFrameInfo.g()).intValue(), ((Integer) lottieFrameInfo.b()).intValue(), lottieFrameInfo.c()) + e(lottieFrameInfo).intValue());
    }
}

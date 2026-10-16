package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PointF f57133g;

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object a(LottieFrameInfo lottieFrameInfo) {
        return super.a(lottieFrameInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public PointF e(PointF pointF, PointF pointF2, float f3) {
        this.f57133g.set(MiscUtils.i(pointF.x, pointF2.x, f3), MiscUtils.i(pointF.y, pointF2.y, f3));
        return this.f57133g;
    }
}

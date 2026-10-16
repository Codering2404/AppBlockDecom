package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f57137d;

    public PointF e(LottieFrameInfo lottieFrameInfo) {
        Object obj = this.f57140c;
        if (obj != null) {
            return (PointF) obj;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // com.airbnb.lottie.value.LottieValueCallback
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final PointF a(LottieFrameInfo lottieFrameInfo) {
        this.f57137d.set(MiscUtils.i(((PointF) lottieFrameInfo.g()).x, ((PointF) lottieFrameInfo.b()).x, lottieFrameInfo.c()), MiscUtils.i(((PointF) lottieFrameInfo.g()).y, ((PointF) lottieFrameInfo.b()).y, lottieFrameInfo.c()));
        PointF pointFE = e(lottieFrameInfo);
        this.f57137d.offset(pointFE.x, pointFE.y);
        return this.f57137d;
    }
}

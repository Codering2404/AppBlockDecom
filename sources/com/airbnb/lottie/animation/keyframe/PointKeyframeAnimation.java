package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f56613i;

    public PointKeyframeAnimation(List list) {
        super(list);
        this.f56613i = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(Keyframe keyframe, float f3) {
        return j(keyframe, f3, f3, f3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF j(Keyframe keyframe, float f3, float f4, float f5) {
        Object obj;
        PointF pointF;
        Object obj2 = keyframe.f57111b;
        if (obj2 == null || (obj = keyframe.f57112c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) obj2;
        PointF pointF3 = (PointF) obj;
        LottieValueCallback lottieValueCallback = this.f56584e;
        if (lottieValueCallback != null && (pointF = (PointF) lottieValueCallback.b(keyframe.f57116g, keyframe.f57117h.floatValue(), pointF2, pointF3, f3, e(), f())) != null) {
            return pointF;
        }
        PointF pointF4 = this.f56613i;
        float f6 = pointF2.x;
        float f7 = f6 + (f4 * (pointF3.x - f6));
        float f8 = pointF2.y;
        pointF4.set(f7, f8 + (f5 * (pointF3.y - f8)));
        return this.f56613i;
    }
}

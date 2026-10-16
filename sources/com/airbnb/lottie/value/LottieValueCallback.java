package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieValueCallback<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseKeyframeAnimation f57139b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LottieFrameInfo f57138a = new LottieFrameInfo();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Object f57140c = null;

    public Object a(LottieFrameInfo lottieFrameInfo) {
        return this.f57140c;
    }

    public final Object b(float f3, float f4, Object obj, Object obj2, float f5, float f6, float f7) {
        return a(this.f57138a.h(f3, f4, obj, obj2, f5, f6, f7));
    }

    public final void c(BaseKeyframeAnimation baseKeyframeAnimation) {
        this.f57139b = baseKeyframeAnimation;
    }

    public final void d(Object obj) {
        this.f57140c = obj;
        BaseKeyframeAnimation baseKeyframeAnimation = this.f57139b;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.k();
        }
    }
}

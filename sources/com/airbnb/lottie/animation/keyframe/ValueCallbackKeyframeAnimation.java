package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f56642i;

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object h() {
        LottieValueCallback lottieValueCallback = this.f56584e;
        Object obj = this.f56642i;
        return lottieValueCallback.b(0.0f, 0.0f, obj, obj, f(), f(), f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    Object i(Keyframe keyframe, float f3) {
        return h();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void k() {
        if (this.f56584e != null) {
            super.k();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f3) {
        this.f56583d = f3;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback, Object obj) {
        super(Collections.EMPTY_LIST);
        n(lottieValueCallback);
        this.f56642i = obj;
    }
}

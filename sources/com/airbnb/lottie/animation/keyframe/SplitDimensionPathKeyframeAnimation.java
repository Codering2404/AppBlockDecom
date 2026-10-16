package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f56618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PointF f56619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BaseKeyframeAnimation f56620k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final BaseKeyframeAnimation f56621l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected LottieValueCallback f56622m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected LottieValueCallback f56623n;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        super(Collections.EMPTY_LIST);
        this.f56618i = new PointF();
        this.f56619j = new PointF();
        this.f56620k = baseKeyframeAnimation;
        this.f56621l = baseKeyframeAnimation2;
        m(f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f3) {
        this.f56620k.m(f3);
        this.f56621l.m(f3);
        this.f56618i.set(((Float) this.f56620k.h()).floatValue(), ((Float) this.f56621l.h()).floatValue());
        for (int i3 = 0; i3 < this.f56580a.size(); i3++) {
            ((BaseKeyframeAnimation.AnimationListener) this.f56580a.get(i3)).a();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(Keyframe keyframe, float f3) {
        float f4;
        Float f5;
        Keyframe keyframeB;
        Keyframe keyframeB2;
        Float f6 = null;
        if (this.f56622m == null || (keyframeB2 = this.f56620k.b()) == null) {
            f4 = f3;
            f5 = null;
        } else {
            float fD = this.f56620k.d();
            Float f7 = keyframeB2.f57117h;
            LottieValueCallback lottieValueCallback = this.f56622m;
            float f8 = keyframeB2.f57116g;
            f4 = f3;
            f5 = (Float) lottieValueCallback.b(f8, f7 == null ? f8 : f7.floatValue(), (Float) keyframeB2.f57111b, (Float) keyframeB2.f57112c, f3, f3, fD);
        }
        if (this.f56623n != null && (keyframeB = this.f56621l.b()) != null) {
            float fD2 = this.f56621l.d();
            Float f9 = keyframeB.f57117h;
            LottieValueCallback lottieValueCallback2 = this.f56623n;
            float f10 = keyframeB.f57116g;
            f6 = (Float) lottieValueCallback2.b(f10, f9 == null ? f10 : f9.floatValue(), (Float) keyframeB.f57111b, (Float) keyframeB.f57112c, f4, f4, fD2);
        }
        if (f5 == null) {
            this.f56619j.set(this.f56618i.x, 0.0f);
        } else {
            this.f56619j.set(f5.floatValue(), 0.0f);
        }
        if (f6 == null) {
            PointF pointF = this.f56619j;
            pointF.set(pointF.x, this.f56618i.y);
        } else {
            PointF pointF2 = this.f56619j;
            pointF2.set(pointF2.x, f6.floatValue());
        }
        return this.f56619j;
    }

    public void r(LottieValueCallback lottieValueCallback) {
        LottieValueCallback lottieValueCallback2 = this.f56622m;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.c(null);
        }
        this.f56622m = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.c(this);
        }
    }

    public void s(LottieValueCallback lottieValueCallback) {
        LottieValueCallback lottieValueCallback2 = this.f56623n;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.c(null);
        }
        this.f56623n = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.c(this);
        }
    }
}

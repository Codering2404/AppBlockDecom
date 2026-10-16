package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimatableFloatValue f56719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableFloatValue f56720b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.f56719a = animatableFloatValue;
        this.f56720b = animatableFloatValue2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation a() {
        return new SplitDimensionPathKeyframeAnimation(this.f56719a.a(), this.f56720b.a());
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean c() {
        return this.f56719a.c() && this.f56720b.c();
    }
}

package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f56718a;

    public AnimatablePathValue(List list) {
        this.f56718a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation a() {
        return ((Keyframe) this.f56718a.get(0)).i() ? new PointKeyframeAnimation(this.f56718a) : new PathKeyframeAnimation(this.f56718a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List b() {
        return this.f56718a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean c() {
        return this.f56718a.size() == 1 && ((Keyframe) this.f56718a.get(0)).i();
    }
}

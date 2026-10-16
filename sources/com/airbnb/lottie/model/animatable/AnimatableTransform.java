package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatableTransform implements ModifierContent, ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimatablePathValue f56725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableValue f56726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableScaleValue f56727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableFloatValue f56728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatableIntegerValue f56729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AnimatableFloatValue f56730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AnimatableFloatValue f56731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AnimatableFloatValue f56732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AnimatableFloatValue f56733i;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return null;
    }

    public TransformKeyframeAnimation b() {
        return new TransformKeyframeAnimation(this);
    }

    public AnimatablePathValue c() {
        return this.f56725a;
    }

    public AnimatableFloatValue d() {
        return this.f56733i;
    }

    public AnimatableIntegerValue e() {
        return this.f56729e;
    }

    public AnimatableValue f() {
        return this.f56726b;
    }

    public AnimatableFloatValue g() {
        return this.f56728d;
    }

    public AnimatableScaleValue h() {
        return this.f56727c;
    }

    public AnimatableFloatValue i() {
        return this.f56730f;
    }

    public AnimatableFloatValue j() {
        return this.f56731g;
    }

    public AnimatableFloatValue k() {
        return this.f56732h;
    }

    public AnimatableTransform(AnimatablePathValue animatablePathValue, AnimatableValue animatableValue, AnimatableScaleValue animatableScaleValue, AnimatableFloatValue animatableFloatValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5) {
        this.f56725a = animatablePathValue;
        this.f56726b = animatableValue;
        this.f56727c = animatableScaleValue;
        this.f56728d = animatableFloatValue;
        this.f56729e = animatableIntegerValue;
        this.f56732h = animatableFloatValue2;
        this.f56733i = animatableFloatValue3;
        this.f56730f = animatableFloatValue4;
        this.f56731g = animatableFloatValue5;
    }
}

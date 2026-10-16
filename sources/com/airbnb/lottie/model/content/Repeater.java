package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Repeater implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableFloatValue f56808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableFloatValue f56809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableTransform f56810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f56811e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z2) {
        this.f56807a = str;
        this.f56808b = animatableFloatValue;
        this.f56809c = animatableFloatValue2;
        this.f56810d = animatableTransform;
        this.f56811e = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f56808b;
    }

    public String c() {
        return this.f56807a;
    }

    public AnimatableFloatValue d() {
        return this.f56809c;
    }

    public AnimatableTransform e() {
        return this.f56810d;
    }

    public boolean f() {
        return this.f56811e;
    }
}

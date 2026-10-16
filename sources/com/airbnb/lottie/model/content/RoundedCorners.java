package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RoundedCornersContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RoundedCorners implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableValue f56813b;

    public RoundedCorners(String str, AnimatableValue animatableValue) {
        this.f56812a = str;
        this.f56813b = animatableValue;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new RoundedCornersContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableValue b() {
        return this.f56813b;
    }

    public String c() {
        return this.f56812a;
    }
}

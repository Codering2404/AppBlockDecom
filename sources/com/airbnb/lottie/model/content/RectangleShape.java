package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RectangleShape implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableValue f56803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableValue f56804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableFloatValue f56805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f56806e;

    public RectangleShape(String str, AnimatableValue animatableValue, AnimatableValue animatableValue2, AnimatableFloatValue animatableFloatValue, boolean z2) {
        this.f56802a = str;
        this.f56803b = animatableValue;
        this.f56804c = animatableValue2;
        this.f56805d = animatableFloatValue;
        this.f56806e = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f56805d;
    }

    public String c() {
        return this.f56802a;
    }

    public AnimatableValue d() {
        return this.f56803b;
    }

    public AnimatableValue e() {
        return this.f56804c;
    }

    public boolean f() {
        return this.f56806e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f56803b + ", size=" + this.f56804c + '}';
    }
}

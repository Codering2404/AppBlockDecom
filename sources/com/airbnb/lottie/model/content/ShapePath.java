package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapePath implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f56827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableShapeValue f56828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f56829d;

    public ShapePath(String str, int i3, AnimatableShapeValue animatableShapeValue, boolean z2) {
        this.f56826a = str;
        this.f56827b = i3;
        this.f56828c = animatableShapeValue;
        this.f56829d = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f56826a;
    }

    public AnimatableShapeValue c() {
        return this.f56828c;
    }

    public boolean d() {
        return this.f56829d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f56826a + ", index=" + this.f56827b + '}';
    }
}

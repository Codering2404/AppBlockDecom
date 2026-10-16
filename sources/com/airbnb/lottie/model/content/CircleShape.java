package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CircleShape implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableValue f56737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatablePointValue f56738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f56739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f56740e;

    public CircleShape(String str, AnimatableValue animatableValue, AnimatablePointValue animatablePointValue, boolean z2, boolean z3) {
        this.f56736a = str;
        this.f56737b = animatableValue;
        this.f56738c = animatablePointValue;
        this.f56739d = z2;
        this.f56740e = z3;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f56736a;
    }

    public AnimatableValue c() {
        return this.f56737b;
    }

    public AnimatablePointValue d() {
        return this.f56738c;
    }

    public boolean e() {
        return this.f56740e;
    }

    public boolean f() {
        return this.f56739d;
    }
}

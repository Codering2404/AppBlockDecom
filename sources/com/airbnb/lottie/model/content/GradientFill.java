package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GradientFill implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GradientType f56743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path.FillType f56744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableGradientColorValue f56745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableIntegerValue f56746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatablePointValue f56747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AnimatablePointValue f56748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f56749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AnimatableFloatValue f56750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AnimatableFloatValue f56751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f56752j;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z2) {
        this.f56743a = gradientType;
        this.f56744b = fillType;
        this.f56745c = animatableGradientColorValue;
        this.f56746d = animatableIntegerValue;
        this.f56747e = animatablePointValue;
        this.f56748f = animatablePointValue2;
        this.f56749g = str;
        this.f56750h = animatableFloatValue;
        this.f56751i = animatableFloatValue2;
        this.f56752j = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, lottieComposition, baseLayer, this);
    }

    public AnimatablePointValue b() {
        return this.f56748f;
    }

    public Path.FillType c() {
        return this.f56744b;
    }

    public AnimatableGradientColorValue d() {
        return this.f56745c;
    }

    public GradientType e() {
        return this.f56743a;
    }

    public String f() {
        return this.f56749g;
    }

    public AnimatableIntegerValue g() {
        return this.f56746d;
    }

    public AnimatablePointValue h() {
        return this.f56747e;
    }

    public boolean i() {
        return this.f56752j;
    }
}

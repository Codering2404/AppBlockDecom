package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeFill implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f56817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path.FillType f56818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f56819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableColorValue f56820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatableIntegerValue f56821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f56822f;

    public ShapeFill(String str, boolean z2, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z3) {
        this.f56819c = str;
        this.f56817a = z2;
        this.f56818b = fillType;
        this.f56820d = animatableColorValue;
        this.f56821e = animatableIntegerValue;
        this.f56822f = z3;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableColorValue b() {
        return this.f56820d;
    }

    public Path.FillType c() {
        return this.f56818b;
    }

    public String d() {
        return this.f56819c;
    }

    public AnimatableIntegerValue e() {
        return this.f56821e;
    }

    public boolean f() {
        return this.f56822f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f56817a + '}';
    }
}

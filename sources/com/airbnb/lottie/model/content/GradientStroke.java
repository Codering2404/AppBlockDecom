package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GradientStroke implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GradientType f56754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableGradientColorValue f56755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableIntegerValue f56756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatablePointValue f56757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AnimatablePointValue f56758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AnimatableFloatValue f56759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ShapeStroke.LineCapType f56760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ShapeStroke.LineJoinType f56761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f56762j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f56763k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AnimatableFloatValue f56764l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f56765m;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f3, List list, AnimatableFloatValue animatableFloatValue2, boolean z2) {
        this.f56753a = str;
        this.f56754b = gradientType;
        this.f56755c = animatableGradientColorValue;
        this.f56756d = animatableIntegerValue;
        this.f56757e = animatablePointValue;
        this.f56758f = animatablePointValue2;
        this.f56759g = animatableFloatValue;
        this.f56760h = lineCapType;
        this.f56761i = lineJoinType;
        this.f56762j = f3;
        this.f56763k = list;
        this.f56764l = animatableFloatValue2;
        this.f56765m = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f56760h;
    }

    public AnimatableFloatValue c() {
        return this.f56764l;
    }

    public AnimatablePointValue d() {
        return this.f56758f;
    }

    public AnimatableGradientColorValue e() {
        return this.f56755c;
    }

    public GradientType f() {
        return this.f56754b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f56761i;
    }

    public List h() {
        return this.f56763k;
    }

    public float i() {
        return this.f56762j;
    }

    public String j() {
        return this.f56753a;
    }

    public AnimatableIntegerValue k() {
        return this.f56756d;
    }

    public AnimatablePointValue l() {
        return this.f56757e;
    }

    public AnimatableFloatValue m() {
        return this.f56759g;
    }

    public boolean n() {
        return this.f56765m;
    }
}

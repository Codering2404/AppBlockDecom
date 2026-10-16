package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PolystarShape implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f56788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableFloatValue f56789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableValue f56790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatableFloatValue f56791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AnimatableFloatValue f56792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AnimatableFloatValue f56793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AnimatableFloatValue f56794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AnimatableFloatValue f56795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f56796j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f56797k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        STAR(1),
        POLYGON(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f56801a;

        Type(int i3) {
            this.f56801a = i3;
        }

        public static Type b(int i3) {
            for (Type type : values()) {
                if (type.f56801a == i3) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z2, boolean z3) {
        this.f56787a = str;
        this.f56788b = type;
        this.f56789c = animatableFloatValue;
        this.f56790d = animatableValue;
        this.f56791e = animatableFloatValue2;
        this.f56792f = animatableFloatValue3;
        this.f56793g = animatableFloatValue4;
        this.f56794h = animatableFloatValue5;
        this.f56795i = animatableFloatValue6;
        this.f56796j = z2;
        this.f56797k = z3;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f56792f;
    }

    public AnimatableFloatValue c() {
        return this.f56794h;
    }

    public String d() {
        return this.f56787a;
    }

    public AnimatableFloatValue e() {
        return this.f56793g;
    }

    public AnimatableFloatValue f() {
        return this.f56795i;
    }

    public AnimatableFloatValue g() {
        return this.f56789c;
    }

    public AnimatableValue h() {
        return this.f56790d;
    }

    public AnimatableFloatValue i() {
        return this.f56791e;
    }

    public Type j() {
        return this.f56788b;
    }

    public boolean k() {
        return this.f56796j;
    }

    public boolean l() {
        return this.f56797k;
    }
}

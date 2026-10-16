package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeTrimPath implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f56851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableFloatValue f56852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableFloatValue f56853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatableFloatValue f56854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f56855f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type b(int i3) {
            if (i3 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i3 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException(MrGIhy.AApxeSXPHwcRer + i3);
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z2) {
        this.f56850a = str;
        this.f56851b = type;
        this.f56852c = animatableFloatValue;
        this.f56853d = animatableFloatValue2;
        this.f56854e = animatableFloatValue3;
        this.f56855f = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f56853d;
    }

    public String c() {
        return this.f56850a;
    }

    public AnimatableFloatValue d() {
        return this.f56854e;
    }

    public AnimatableFloatValue e() {
        return this.f56852c;
    }

    public Type f() {
        return this.f56851b;
    }

    public boolean g() {
        return this.f56855f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f56852c + ", end: " + this.f56853d + ", offset: " + this.f56854e + "}";
    }
}

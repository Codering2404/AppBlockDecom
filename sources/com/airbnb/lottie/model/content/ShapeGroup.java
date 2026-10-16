package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeGroup implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f56824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f56825c;

    public ShapeGroup(String str, List list, boolean z2) {
        this.f56823a = str;
        this.f56824b = list;
        this.f56825c = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this, lottieComposition);
    }

    public List b() {
        return this.f56824b;
    }

    public String c() {
        return this.f56823a;
    }

    public boolean d() {
        return this.f56825c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f56823a + "' Shapes: " + Arrays.toString(this.f56824b.toArray()) + '}';
    }
}

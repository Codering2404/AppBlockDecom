package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Mask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaskMode f56769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableShapeValue f56770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimatableIntegerValue f56771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f56772d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.f56769a = maskMode;
        this.f56770b = animatableShapeValue;
        this.f56771c = animatableIntegerValue;
        this.f56772d = z2;
    }

    public MaskMode a() {
        return this.f56769a;
    }

    public AnimatableShapeValue b() {
        return this.f56770b;
    }

    public AnimatableIntegerValue c() {
        return this.f56771c;
    }

    public boolean d() {
        return this.f56772d;
    }
}

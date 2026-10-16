package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CarouselStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f80363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f80364b;

    static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr2[i3] = iArr[i3] * 2;
        }
        return iArr2;
    }

    static float b(float f3, float f4, float f5) {
        return 1.0f - ((f3 - f5) / (f4 - f5));
    }

    public float c() {
        return this.f80364b;
    }

    public float d() {
        return this.f80363a;
    }

    void e(Context context) {
        float fH = this.f80363a;
        if (fH <= 0.0f) {
            fH = CarouselStrategyHelper.h(context);
        }
        this.f80363a = fH;
        float fG = this.f80364b;
        if (fG <= 0.0f) {
            fG = CarouselStrategyHelper.g(context);
        }
        this.f80364b = fG;
    }

    boolean f() {
        return true;
    }

    abstract KeylineState g(Carousel carousel, View view);

    boolean h(Carousel carousel, int i3) {
        return false;
    }
}

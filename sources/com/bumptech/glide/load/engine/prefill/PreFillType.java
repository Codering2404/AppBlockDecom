package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PreFillType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Bitmap.Config f66664e = Bitmap.Config.RGB_565;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f66665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f66666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bitmap.Config f66667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f66668d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    Bitmap.Config a() {
        return this.f66667c;
    }

    int b() {
        return this.f66666b;
    }

    int c() {
        return this.f66665a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            if (this.f66666b == preFillType.f66666b && this.f66665a == preFillType.f66665a && this.f66668d == preFillType.f66668d && this.f66667c == preFillType.f66667c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f66665a * 31) + this.f66666b) * 31) + this.f66667c.hashCode()) * 31) + this.f66668d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f66665a + ", height=" + this.f66666b + ", config=" + this.f66667c + ", weight=" + this.f66668d + '}';
    }
}

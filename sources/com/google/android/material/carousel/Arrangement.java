package com.google.android.material.carousel;

import androidx.core.math.MathUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Arrangement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f80331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f80332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f80333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f80334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f80335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f80336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f80337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final float f80338h;

    Arrangement(int i3, float f3, float f4, float f5, int i4, float f6, int i5, float f7, int i6, float f8) {
        this.f80331a = i3;
        this.f80332b = MathUtils.a(f3, f4, f5);
        this.f80333c = i4;
        this.f80335e = f6;
        this.f80334d = i5;
        this.f80336f = f7;
        this.f80337g = i6;
        d(f8, f4, f5, f7);
        this.f80338h = b(f7);
    }

    private float a(float f3, int i3, float f4, int i4, int i5) {
        if (i3 <= 0) {
            f4 = 0.0f;
        }
        float f5 = i4 / 2.0f;
        return (f3 - ((i3 + f5) * f4)) / (i5 + f5);
    }

    private float b(float f3) {
        if (g()) {
            return Math.abs(f3 - this.f80336f) * this.f80331a;
        }
        return Float.MAX_VALUE;
    }

    static Arrangement c(float f3, float f4, float f5, float f6, int[] iArr, float f7, int[] iArr2, float f8, int[] iArr3) {
        Arrangement arrangement = null;
        int i3 = 1;
        for (int i4 : iArr3) {
            int length = iArr2.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = iArr2[i5];
                int length2 = iArr.length;
                int i7 = 0;
                while (i7 < length2) {
                    int i8 = length;
                    int i9 = i5;
                    int i10 = i3;
                    int i11 = length2;
                    int i12 = i7;
                    Arrangement arrangement2 = new Arrangement(i10, f4, f5, f6, iArr[i7], f7, i6, f8, i4, f3);
                    if (arrangement == null || arrangement2.f80338h < arrangement.f80338h) {
                        if (arrangement2.f80338h == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i13 = i10 + 1;
                    i7 = i12 + 1;
                    i5 = i9;
                    i3 = i13;
                    length = i8;
                    length2 = i11;
                }
                i5++;
                i3 = i3;
                length = length;
            }
        }
        return arrangement;
    }

    private void d(float f3, float f4, float f5, float f6) {
        float f7 = f3 - f();
        int i3 = this.f80333c;
        if (i3 > 0 && f7 > 0.0f) {
            float f8 = this.f80332b;
            this.f80332b = f8 + Math.min(f7 / i3, f5 - f8);
        } else if (i3 > 0 && f7 < 0.0f) {
            float f9 = this.f80332b;
            this.f80332b = f9 + Math.max(f7 / i3, f4 - f9);
        }
        int i4 = this.f80333c;
        float f10 = i4 > 0 ? this.f80332b : 0.0f;
        this.f80332b = f10;
        float fA = a(f3, i4, f10, this.f80334d, this.f80337g);
        this.f80336f = fA;
        float f11 = (this.f80332b + fA) / 2.0f;
        this.f80335e = f11;
        int i5 = this.f80334d;
        if (i5 <= 0 || fA == f6) {
            return;
        }
        float f12 = (f6 - fA) * this.f80337g;
        float fMin = Math.min(Math.abs(f12), f11 * 0.1f * i5);
        if (f12 > 0.0f) {
            this.f80335e -= fMin / this.f80334d;
            this.f80336f += fMin / this.f80337g;
        } else {
            this.f80335e += fMin / this.f80334d;
            this.f80336f -= fMin / this.f80337g;
        }
    }

    private float f() {
        return (this.f80336f * this.f80337g) + (this.f80335e * this.f80334d) + (this.f80332b * this.f80333c);
    }

    private boolean g() {
        int i3 = this.f80337g;
        if (i3 <= 0 || this.f80333c <= 0 || this.f80334d <= 0) {
            return i3 <= 0 || this.f80333c <= 0 || this.f80336f > this.f80332b;
        }
        float f3 = this.f80336f;
        float f4 = this.f80335e;
        return f3 > f4 && f4 > this.f80332b;
    }

    int e() {
        return this.f80333c + this.f80334d + this.f80337g;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f80331a + ", smallCount=" + this.f80333c + ", smallSize=" + this.f80332b + ", mediumCount=" + this.f80334d + ", mediumSize=" + this.f80335e + ", largeCount=" + this.f80337g + ", largeSize=" + this.f80336f + ", cost=" + this.f80338h + "]";
    }
}

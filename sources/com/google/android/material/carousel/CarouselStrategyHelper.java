package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class CarouselStrategyHelper {
    static float a(float f3, float f4, int i3) {
        return f3 + (Math.max(0, i3 - 1) * f4);
    }

    static float b(float f3, float f4, int i3) {
        return i3 > 0 ? f3 + (f4 / 2.0f) : f3;
    }

    static KeylineState c(Context context, float f3, float f4, Arrangement arrangement) {
        float f5;
        float f6;
        float fMin = Math.min(f(context) + f3, arrangement.f80336f);
        float f7 = fMin / 2.0f;
        float f8 = 0.0f - f7;
        float fB = b(0.0f, arrangement.f80332b, arrangement.f80333c);
        float fJ = j(0.0f, a(fB, arrangement.f80332b, (int) Math.floor(arrangement.f80333c / 2.0f)), arrangement.f80332b, arrangement.f80333c);
        float fB2 = b(fJ, arrangement.f80335e, arrangement.f80334d);
        float fJ2 = j(fJ, a(fB2, arrangement.f80335e, (int) Math.floor(arrangement.f80334d / 2.0f)), arrangement.f80335e, arrangement.f80334d);
        float fB3 = b(fJ2, arrangement.f80336f, arrangement.f80337g);
        float fJ3 = j(fJ2, a(fB3, arrangement.f80336f, arrangement.f80337g), arrangement.f80336f, arrangement.f80337g);
        float fB4 = b(fJ3, arrangement.f80335e, arrangement.f80334d);
        float fB5 = b(j(fJ3, a(fB4, arrangement.f80335e, (int) Math.ceil(arrangement.f80334d / 2.0f)), arrangement.f80335e, arrangement.f80334d), arrangement.f80332b, arrangement.f80333c);
        float f9 = f7 + f4;
        float fB6 = CarouselStrategy.b(fMin, arrangement.f80336f, f3);
        float fB7 = CarouselStrategy.b(arrangement.f80332b, arrangement.f80336f, f3);
        float fB8 = CarouselStrategy.b(arrangement.f80335e, arrangement.f80336f, f3);
        KeylineState.Builder builderA = new KeylineState.Builder(arrangement.f80336f, f4).a(f8, fB6, fMin);
        if (arrangement.f80333c > 0) {
            f5 = 2.0f;
            f6 = f9;
            builderA.g(fB, fB7, arrangement.f80332b, (int) Math.floor(r7 / 2.0f));
        } else {
            f5 = 2.0f;
            f6 = f9;
        }
        if (arrangement.f80334d > 0) {
            builderA.g(fB2, fB8, arrangement.f80335e, (int) Math.floor(r4 / f5));
        }
        builderA.h(fB3, 0.0f, arrangement.f80336f, arrangement.f80337g, true);
        if (arrangement.f80334d > 0) {
            builderA.g(fB4, fB8, arrangement.f80335e, (int) Math.ceil(r4 / f5));
        }
        if (arrangement.f80333c > 0) {
            builderA.g(fB5, fB7, arrangement.f80332b, (int) Math.ceil(r0 / f5));
        }
        builderA.a(f6, fB6, fMin);
        return builderA.i();
    }

    static KeylineState d(Context context, float f3, float f4, Arrangement arrangement, int i3) {
        return i3 == 1 ? c(context, f3, f4, arrangement) : e(context, f3, f4, arrangement);
    }

    static KeylineState e(Context context, float f3, float f4, Arrangement arrangement) {
        float fMin = Math.min(f(context) + f3, arrangement.f80336f);
        float f5 = fMin / 2.0f;
        float f6 = 0.0f - f5;
        float fB = b(0.0f, arrangement.f80336f, arrangement.f80337g);
        float fJ = j(0.0f, a(fB, arrangement.f80336f, arrangement.f80337g), arrangement.f80336f, arrangement.f80337g);
        float fB2 = b(fJ, arrangement.f80335e, arrangement.f80334d);
        float fB3 = b(j(fJ, fB2, arrangement.f80335e, arrangement.f80334d), arrangement.f80332b, arrangement.f80333c);
        float f7 = f5 + f4;
        float fB4 = CarouselStrategy.b(fMin, arrangement.f80336f, f3);
        float fB5 = CarouselStrategy.b(arrangement.f80332b, arrangement.f80336f, f3);
        float fB6 = CarouselStrategy.b(arrangement.f80335e, arrangement.f80336f, f3);
        KeylineState.Builder builderH = new KeylineState.Builder(arrangement.f80336f, f4).a(f6, fB4, fMin).h(fB, 0.0f, arrangement.f80336f, arrangement.f80337g, true);
        if (arrangement.f80334d > 0) {
            builderH.b(fB2, fB6, arrangement.f80335e);
        }
        int i3 = arrangement.f80333c;
        if (i3 > 0) {
            builderH.g(fB3, fB5, arrangement.f80332b, i3);
        }
        builderH.a(f7, fB4, fMin);
        return builderH.i();
    }

    static float f(Context context) {
        return context.getResources().getDimension(R.dimen.f79600x);
    }

    static float g(Context context) {
        return context.getResources().getDimension(R.dimen.f79602y);
    }

    static float h(Context context) {
        return context.getResources().getDimension(R.dimen.f79604z);
    }

    static int i(int[] iArr) {
        int i3 = Integer.MIN_VALUE;
        for (int i4 : iArr) {
            if (i4 > i3) {
                i3 = i4;
            }
        }
        return i3;
    }

    static float j(float f3, float f4, float f5, int i3) {
        return i3 > 0 ? f4 + (f5 / 2.0f) : f3;
    }
}

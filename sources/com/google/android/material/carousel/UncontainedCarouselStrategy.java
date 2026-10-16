package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.KeylineState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private float i(float f3, float f4, float f5) {
        float fMax = Math.max(1.5f * f5, f3);
        float f6 = 0.85f * f4;
        if (fMax > f6) {
            fMax = Math.max(f6, f5 * 1.2f);
        }
        return Math.min(f4, fMax);
    }

    private KeylineState j(float f3, float f4, float f5, int i3, float f6, float f7, float f8) {
        float fMin = Math.min(f7, f5);
        float fB = CarouselStrategy.b(fMin, f5, f4);
        float fB2 = CarouselStrategy.b(f6, f5, f4);
        float f9 = f6 / 2.0f;
        float f10 = (f8 + 0.0f) - f9;
        float f11 = f10 + f9;
        float f12 = fMin / 2.0f;
        float f13 = (i3 * f5) + f11;
        KeylineState.Builder builderH = new KeylineState.Builder(f5, f3).a((f10 - f9) - f12, fB, fMin).c(f10, fB2, f6, false).h((f5 / 2.0f) + f11, 0.0f, f5, i3, true);
        builderH.c(f9 + f13, fB2, f6, false);
        builderH.a(f13 + f6 + f12, fB, fMin);
        return builderH.i();
    }

    private KeylineState k(Context context, float f3, float f4, float f5, int i3, float f6, int i4, float f7) {
        float fMin = Math.min(f7, f5);
        float fMax = Math.max(fMin, 0.5f * f6);
        float fB = CarouselStrategy.b(fMax, f5, f3);
        float fB2 = CarouselStrategy.b(fMin, f5, f3);
        float fB3 = CarouselStrategy.b(f6, f5, f3);
        float f8 = (i3 * f5) + 0.0f;
        KeylineState.Builder builderH = new KeylineState.Builder(f5, f4).a(0.0f - (fMax / 2.0f), fB, fMax).h(f5 / 2.0f, 0.0f, f5, i3, true);
        if (i4 > 0) {
            float f9 = (f6 / 2.0f) + f8;
            f8 += f6;
            builderH.c(f9, fB3, f6, false);
        }
        builderH.a(f8 + (CarouselStrategyHelper.f(context) / 2.0f), fB2, fMin);
        return builderH.i();
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    boolean f() {
        return false;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState g(Carousel carousel, View view) {
        float fC = carousel.b() ? carousel.c() : carousel.d();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.b()) {
            f3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f4 = measuredHeight;
        float f5 = f3;
        float f6 = f4 + f5;
        float f7 = CarouselStrategyHelper.f(view.getContext()) + f5;
        float f8 = CarouselStrategyHelper.f(view.getContext()) + f5;
        int iMax = Math.max(1, (int) Math.floor(fC / f6));
        float f9 = fC - (iMax * f6);
        if (carousel.g() == 1) {
            float f10 = f9 / 2.0f;
            return j(fC, f5, f6, iMax, Math.max(Math.min(3.0f * f10, f6), d() + f5), f8, f10);
        }
        int i3 = 1;
        if (f9 <= 0.0f) {
            i3 = 0;
        }
        return k(view.getContext(), f5, fC, f6, iMax, i(f7, f6, f9), i3, f8);
    }
}

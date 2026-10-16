package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f80402d = {1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f80403e = {1, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f80404c = 0;

    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState g(Carousel carousel, View view) {
        float fD = carousel.d();
        if (carousel.b()) {
            fD = carousel.c();
        }
        float f3 = fD;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.b()) {
            f4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f5 = f4;
        float fD2 = d() + f5;
        float fMax = Math.max(c() + f5, fD2);
        float fMin = Math.min(measuredHeight + f5, f3);
        float fA = MathUtils.a((measuredHeight / 3.0f) + f5, fD2 + f5, fMax + f5);
        float f6 = (fMin + fA) / 2.0f;
        int[] iArrA = f80402d;
        if (f3 < 2.0f * fD2) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = f80403e;
        if (carousel.g() == 1) {
            iArrA = CarouselStrategy.a(iArrA);
            iArrA2 = CarouselStrategy.a(iArrA2);
        }
        int[] iArr = iArrA2;
        int[] iArr2 = iArrA;
        int iMax = (int) Math.max(1.0d, Math.floor(((f3 - (CarouselStrategyHelper.i(iArr) * f6)) - (CarouselStrategyHelper.i(iArr2) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(f3 / fMin);
        int i3 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr3[i4] = iCeil - i4;
        }
        Arrangement arrangementC = Arrangement.c(f3, fA, fD2, fMax, iArr2, f6, iArr, fMin, iArr3);
        this.f80404c = arrangementC.e();
        if (i(arrangementC, carousel.a())) {
            arrangementC = Arrangement.c(f3, fA, fD2, fMax, new int[]{arrangementC.f80333c}, f6, new int[]{arrangementC.f80334d}, fMin, new int[]{arrangementC.f80337g});
        }
        return CarouselStrategyHelper.d(view.getContext(), f5, f3, arrangementC, carousel.g());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    boolean h(Carousel carousel, int i3) {
        if (i3 >= this.f80404c || carousel.a() < this.f80404c) {
            return i3 >= this.f80404c && carousel.a() < this.f80404c;
        }
        return true;
    }

    boolean i(Arrangement arrangement, int i3) {
        int iE = arrangement.e() - i3;
        boolean z2 = iE > 0 && (arrangement.f80333c > 0 || arrangement.f80334d > 1);
        while (iE > 0) {
            int i4 = arrangement.f80333c;
            if (i4 > 0) {
                arrangement.f80333c = i4 - 1;
            } else {
                int i5 = arrangement.f80334d;
                if (i5 > 1) {
                    arrangement.f80334d = i5 - 1;
                }
            }
            iE--;
        }
        return z2;
    }
}

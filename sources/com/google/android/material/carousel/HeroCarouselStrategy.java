package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class HeroCarouselStrategy extends CarouselStrategy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f80365d = {1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f80366e = {0, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f80367c;

    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState g(Carousel carousel, View view) {
        int iD = carousel.d();
        if (carousel.b()) {
            iD = carousel.c();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.b()) {
            f3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float fD = d() + f3;
        float fMax = Math.max(c() + f3, fD);
        float f4 = iD;
        float fMin = Math.min(measuredWidth + f3, f4);
        float fA = MathUtils.a((measuredWidth / 3.0f) + f3, fD + f3, fMax + f3);
        float f5 = (fMin + fA) / 2.0f;
        int i3 = 0;
        int[] iArr = f4 < 2.0f * fD ? new int[]{0} : f80365d;
        int iMax = (int) Math.max(1.0d, Math.floor((f4 - (CarouselStrategyHelper.i(r0) * fMax)) / fMin));
        int iCeil = (((int) Math.ceil(f4 / fMin)) - iMax) + 1;
        int[] iArr2 = new int[iCeil];
        for (int i4 = 0; i4 < iCeil; i4++) {
            iArr2[i4] = iMax + i4;
        }
        int i5 = carousel.g() == 1 ? 1 : 0;
        Arrangement arrangementC = Arrangement.c(f4, fA, fD, fMax, i5 != 0 ? CarouselStrategy.a(iArr) : iArr, f5, i5 != 0 ? CarouselStrategy.a(f80366e) : f80366e, fMin, iArr2);
        this.f80367c = arrangementC.e();
        if (arrangementC.e() > carousel.a()) {
            arrangementC = Arrangement.c(f4, fA, fD, fMax, iArr, f5, f80366e, fMin, iArr2);
        } else {
            i3 = i5;
        }
        return CarouselStrategyHelper.d(view.getContext(), f3, f4, arrangementC, i3);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    boolean h(Carousel carousel, int i3) {
        if (carousel.g() == 1) {
            return (i3 < this.f80367c && carousel.a() >= this.f80367c) || (i3 >= this.f80367c && carousel.a() < this.f80367c);
        }
        return false;
    }
}

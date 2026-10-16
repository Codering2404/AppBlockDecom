package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FullScreenCarouselStrategy extends CarouselStrategy {
    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState g(Carousel carousel, View view) {
        float fD;
        int i3;
        int i4;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (carousel.b()) {
            fD = carousel.c();
            i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            fD = carousel.d();
            i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        float f3 = i3 + i4;
        float f4 = fD;
        return CarouselStrategyHelper.e(view.getContext(), f3, f4, new Arrangement(0, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, Math.min(f4 + f3, f4), 1, f4));
    }
}

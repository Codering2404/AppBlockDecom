package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class CarouselOrientationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f80356a;

    private static CarouselOrientationHelper b(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(0) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.2
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void a(RectF rectF, RectF rectF2, RectF rectF3) {
                float f3 = rectF2.left;
                float f4 = rectF3.left;
                if (f3 < f4 && rectF2.right > f4) {
                    float f5 = f4 - f3;
                    rectF.left += f5;
                    rectF2.left += f5;
                }
                float f6 = rectF2.right;
                float f7 = rectF3.right;
                if (f6 <= f7 || rectF2.left >= f7) {
                    return;
                }
                float f8 = f6 - f7;
                rectF.right = Math.max(rectF.right - f8, rectF.left);
                rectF2.right = Math.max(rectF2.right - f8, rectF2.left);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float e(RecyclerView.LayoutParams layoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF f(float f3, float f4, float f5, float f6) {
                return new RectF(f6, 0.0f, f4 - f6, f3);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int g() {
                return carouselLayoutManager.c0() - carouselLayoutManager.i0();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int h() {
                return carouselLayoutManager.H2() ? i() : j();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int i() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int j() {
                return carouselLayoutManager.t0();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int k() {
                return carouselLayoutManager.H2() ? j() : i();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int l() {
                return carouselLayoutManager.l0();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void m(View view, int i3, int i4) {
                int iL = l();
                carouselLayoutManager.E0(view, i3, iL, i4, iL + p(view));
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void n(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.right <= rectF3.left) {
                    float fFloor = ((float) Math.floor(rectF.right)) - 1.0f;
                    rectF.right = fFloor;
                    rectF.left = Math.min(rectF.left, fFloor);
                }
                if (rectF2.left >= rectF3.right) {
                    float fCeil = ((float) Math.ceil(rectF.left)) + 1.0f;
                    rectF.left = fCeil;
                    rectF.right = Math.max(fCeil, rectF.right);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void o(View view, Rect rect, float f3, float f4) {
                view.offsetLeftAndRight((int) (f4 - (rect.left + f3)));
            }

            int p(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.X(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        };
    }

    static CarouselOrientationHelper c(CarouselLayoutManager carouselLayoutManager, int i3) {
        if (i3 == 0) {
            return b(carouselLayoutManager);
        }
        if (i3 == 1) {
            return d(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static CarouselOrientationHelper d(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(1) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.1
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void a(RectF rectF, RectF rectF2, RectF rectF3) {
                float f3 = rectF2.top;
                float f4 = rectF3.top;
                if (f3 < f4 && rectF2.bottom > f4) {
                    float f5 = f4 - f3;
                    rectF.top += f5;
                    rectF3.top += f5;
                }
                float f6 = rectF2.bottom;
                float f7 = rectF3.bottom;
                if (f6 <= f7 || rectF2.top >= f7) {
                    return;
                }
                float f8 = f6 - f7;
                rectF.bottom = Math.max(rectF.bottom - f8, rectF.top);
                rectF2.bottom = Math.max(rectF2.bottom - f8, rectF2.top);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float e(RecyclerView.LayoutParams layoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF f(float f3, float f4, float f5, float f6) {
                return new RectF(0.0f, f5, f4, f3 - f5);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int g() {
                return carouselLayoutManager.c0();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int h() {
                return g();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int i() {
                return carouselLayoutManager.j0();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int j() {
                return carouselLayoutManager.t0() - carouselLayoutManager.k0();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int k() {
                return l();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int l() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void m(View view, int i3, int i4) {
                int i5 = i();
                carouselLayoutManager.E0(view, i5, i3, i5 + p(view), i4);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void n(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.bottom <= rectF3.top) {
                    float fFloor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                    rectF.bottom = fFloor;
                    rectF.top = Math.min(rectF.top, fFloor);
                }
                if (rectF2.top >= rectF3.bottom) {
                    float fCeil = ((float) Math.ceil(rectF.top)) + 1.0f;
                    rectF.top = fCeil;
                    rectF.bottom = Math.max(fCeil, rectF.bottom);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void o(View view, Rect rect, float f3, float f4) {
                view.offsetTopAndBottom((int) (f4 - (rect.top + f3)));
            }

            int p(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.Y(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }
        };
    }

    abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    abstract float e(RecyclerView.LayoutParams layoutParams);

    abstract RectF f(float f3, float f4, float f5, float f6);

    abstract int g();

    abstract int h();

    abstract int i();

    abstract int j();

    abstract int k();

    abstract int l();

    abstract void m(View view, int i3, int i4);

    abstract void n(RectF rectF, RectF rectF2, RectF rectF3);

    abstract void o(View view, Rect rect, float f3, float f4);

    private CarouselOrientationHelper(int i3) {
        this.f80356a = i3;
    }
}

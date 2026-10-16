package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f53832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPager2.PageTransformer f53833b;

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f53832a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void b(int i3, float f3, int i4) {
        if (this.f53833b == null) {
            return;
        }
        float f4 = -f3;
        for (int i5 = 0; i5 < this.f53832a.P(); i5++) {
            View viewO = this.f53832a.O(i5);
            if (viewO == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i5), Integer.valueOf(this.f53832a.P())));
            }
            this.f53833b.transformPage(viewO, (this.f53832a.m0(viewO) - i3) + f4);
        }
    }

    ViewPager2.PageTransformer d() {
        return this.f53833b;
    }

    void e(ViewPager2.PageTransformer pageTransformer) {
        this.f53833b = pageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void a(int i3) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void c(int i3) {
    }
}

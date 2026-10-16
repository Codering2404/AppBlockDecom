package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f53831a;

    private ViewPager2 a(View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f3) {
        ViewPager2 viewPager2A = a(view);
        float f4 = this.f53831a * f3;
        if (viewPager2A.getOrientation() != 0) {
            view.setTranslationY(f4);
            return;
        }
        if (viewPager2A.d()) {
            f4 = -f4;
        }
        view.setTranslationX(f4);
    }
}

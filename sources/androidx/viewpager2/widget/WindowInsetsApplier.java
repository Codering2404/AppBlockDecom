package androidx.viewpager2.widget;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WindowInsetsApplier implements OnApplyWindowInsetsListener {
    private WindowInsetsCompat b(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.f34517b;
        return windowInsetsCompat2.y() != null ? windowInsetsCompat2 : windowInsetsCompat.c().b();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        WindowInsetsCompat windowInsetsCompatY = ViewCompat.Y(viewPager2, windowInsetsCompat);
        if (windowInsetsCompatY.r()) {
            return windowInsetsCompatY;
        }
        RecyclerView recyclerView = viewPager2.f53860k;
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewCompat.g(recyclerView.getChildAt(i3), new WindowInsetsCompat(windowInsetsCompatY));
        }
        return b(windowInsetsCompatY);
    }
}

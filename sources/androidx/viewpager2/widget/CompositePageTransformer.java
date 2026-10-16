package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f53827a;

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f3) {
        Iterator it = this.f53827a.iterator();
        while (it.hasNext()) {
            ((ViewPager2.PageTransformer) it.next()).transformPage(view, f3);
        }
    }
}

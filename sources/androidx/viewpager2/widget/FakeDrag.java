package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FakeDrag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewPager2 f53828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScrollEventAdapter f53829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f53830c;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f53828a = viewPager2;
        this.f53829b = scrollEventAdapter;
        this.f53830c = recyclerView;
    }

    boolean a() {
        return this.f53829b.i();
    }
}

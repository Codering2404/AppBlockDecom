package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class TabLayoutMediator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TabLayout f82193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewPager2 f82194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f82195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f82196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TabConfigurationStrategy f82197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RecyclerView.Adapter f82198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f82199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TabLayoutOnPageChangeCallback f82200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TabLayout.OnTabSelectedListener f82201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f82202j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i4) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i4, int i5) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i4) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4, Object obj) {
            TabLayoutMediator.this.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TabConfigurationStrategy {
        void a(TabLayout.Tab tab, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f82204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f82205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f82206c;

        TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            this.f82204a = new WeakReference(tabLayout);
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void a(int i3) {
            this.f82205b = this.f82206c;
            this.f82206c = i3;
            TabLayout tabLayout = (TabLayout) this.f82204a.get();
            if (tabLayout != null) {
                tabLayout.V(this.f82206c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void b(int i3, float f3, int i4) {
            boolean z2;
            TabLayout tabLayout = (TabLayout) this.f82204a.get();
            if (tabLayout != null) {
                int i5 = this.f82206c;
                boolean z3 = true;
                if (i5 != 2 || this.f82205b == 1) {
                    z2 = true;
                } else {
                    z2 = true;
                    z3 = false;
                }
                if (i5 == 2 && this.f82205b == 0) {
                    z2 = false;
                }
                tabLayout.P(i3, f3, z3, z2, false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void c(int i3) {
            TabLayout tabLayout = (TabLayout) this.f82204a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i3 || i3 >= tabLayout.getTabCount()) {
                return;
            }
            int i4 = this.f82206c;
            tabLayout.L(tabLayout.B(i3), i4 == 0 || (i4 == 2 && this.f82205b == 0));
        }

        void d() {
            this.f82206c = 0;
            this.f82205b = 0;
        }
    }

    public TabLayoutMediator(TabLayout tabLayout, ViewPager2 viewPager2, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
    }

    public void a() {
        if (this.f82199g) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.Adapter adapter = this.f82194b.getAdapter();
        this.f82198f = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.f82199g = true;
        TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.f82193a);
        this.f82200h = tabLayoutOnPageChangeCallback;
        this.f82194b.g(tabLayoutOnPageChangeCallback);
        ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.f82194b, this.f82196d);
        this.f82201i = viewPagerOnTabSelectedListener;
        this.f82193a.h(viewPagerOnTabSelectedListener);
        if (this.f82195c) {
            PagerAdapterObserver pagerAdapterObserver = new PagerAdapterObserver();
            this.f82202j = pagerAdapterObserver;
            this.f82198f.registerAdapterDataObserver(pagerAdapterObserver);
        }
        b();
        this.f82193a.N(this.f82194b.getCurrentItem(), 0.0f, true);
    }

    void b() {
        this.f82193a.H();
        RecyclerView.Adapter adapter = this.f82198f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i3 = 0; i3 < itemCount; i3++) {
                TabLayout.Tab tabE = this.f82193a.E();
                this.f82197e.a(tabE, i3);
                this.f82193a.k(tabE, false);
            }
            if (itemCount > 0) {
                int iMin = Math.min(this.f82194b.getCurrentItem(), this.f82193a.getTabCount() - 1);
                if (iMin != this.f82193a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f82193a;
                    tabLayout.K(tabLayout.B(iMin));
                }
            }
        }
    }

    public TabLayoutMediator(TabLayout tabLayout, ViewPager2 viewPager2, boolean z2, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z2, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(TabLayout tabLayout, ViewPager2 viewPager2, boolean z2, boolean z3, TabConfigurationStrategy tabConfigurationStrategy) {
        this.f82193a = tabLayout;
        this.f82194b = viewPager2;
        this.f82195c = z2;
        this.f82196d = z3;
        this.f82197e = tabConfigurationStrategy;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager2 f82207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f82208b;

        ViewPagerOnTabSelectedListener(ViewPager2 viewPager2, boolean z2) {
            this.f82207a = viewPager2;
            this.f82208b = z2;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void a(TabLayout.Tab tab) {
            this.f82207a.j(tab.g(), this.f82208b);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void b(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void c(TabLayout.Tab tab) {
        }
    }
}

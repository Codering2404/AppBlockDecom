package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class NestedAdapterWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewTypeStorage.ViewTypeLookup f51820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StableIdStorage.StableIdLookup f51821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.Adapter f51822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callback f51823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f51824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f51825f = new RecyclerView.AdapterDataObserver() { // from class: androidx.recyclerview.widget.NestedAdapterWrapper.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f51824e = nestedAdapterWrapper.f51822c.getItemCount();
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            nestedAdapterWrapper2.f51823d.e(nestedAdapterWrapper2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f51823d.a(nestedAdapterWrapper, i3, i4, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i4) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f51824e += i4;
            nestedAdapterWrapper.f51823d.b(nestedAdapterWrapper, i3, i4);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.f51824e <= 0 || nestedAdapterWrapper2.f51822c.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
            nestedAdapterWrapper3.f51823d.d(nestedAdapterWrapper3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i4, int i5) {
            Preconditions.b(i5 == 1, "moving more than 1 item is not supported in RecyclerView");
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f51823d.c(nestedAdapterWrapper, i3, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i4) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f51824e -= i4;
            nestedAdapterWrapper.f51823d.f(nestedAdapterWrapper, i3, i4);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.f51824e >= 1 || nestedAdapterWrapper2.f51822c.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
            nestedAdapterWrapper3.f51823d.d(nestedAdapterWrapper3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f51823d.d(nestedAdapterWrapper);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4, Object obj) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f51823d.a(nestedAdapterWrapper, i3, i4, obj);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        void a(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4, Object obj);

        void b(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4);

        void c(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4);

        void d(NestedAdapterWrapper nestedAdapterWrapper);

        void e(NestedAdapterWrapper nestedAdapterWrapper);

        void f(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4);
    }

    NestedAdapterWrapper(RecyclerView.Adapter adapter, Callback callback, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        this.f51822c = adapter;
        this.f51823d = callback;
        this.f51820a = viewTypeStorage.b(this);
        this.f51821b = stableIdLookup;
        this.f51824e = adapter.getItemCount();
        adapter.registerAdapterDataObserver(this.f51825f);
    }

    void a() {
        this.f51822c.unregisterAdapterDataObserver(this.f51825f);
        this.f51820a.dispose();
    }

    int b() {
        return this.f51824e;
    }

    public long c(int i3) {
        return this.f51821b.a(this.f51822c.getItemId(i3));
    }

    int d(int i3) {
        return this.f51820a.b(this.f51822c.getItemViewType(i3));
    }

    void e(RecyclerView.ViewHolder viewHolder, int i3) {
        this.f51822c.bindViewHolder(viewHolder, i3);
    }

    RecyclerView.ViewHolder f(ViewGroup viewGroup, int i3) {
        return this.f51822c.onCreateViewHolder(viewGroup, this.f51820a.a(i3));
    }
}

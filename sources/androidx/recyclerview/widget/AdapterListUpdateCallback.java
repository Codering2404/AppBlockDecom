package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView.Adapter f51471a;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.f51471a = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void a(int i3, int i4) {
        this.f51471a.notifyItemRangeInserted(i3, i4);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void b(int i3, int i4) {
        this.f51471a.notifyItemRangeRemoved(i3, i4);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void c(int i3, int i4, Object obj) {
        this.f51471a.notifyItemRangeChanged(i3, i4, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void d(int i3, int i4) {
        this.f51471a.notifyItemMoved(i3, i4);
    }
}

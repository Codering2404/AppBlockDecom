package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RecyclerView.Adapter f52009a;

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void a(int i3, int i4) {
        this.f52009a.notifyItemRangeInserted(i3, i4);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void b(int i3, int i4) {
        this.f52009a.notifyItemRangeRemoved(i3, i4);
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
    public void c(int i3, int i4, Object obj) {
        this.f52009a.notifyItemRangeChanged(i3, i4, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void d(int i3, int i4) {
        this.f52009a.notifyItemMoved(i3, i4);
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback
    public void e(int i3, int i4) {
        this.f52009a.notifyItemRangeChanged(i3, i4);
    }
}

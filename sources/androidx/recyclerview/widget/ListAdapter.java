package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AsyncListDiffer f51794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AsyncListDiffer.ListListener f51795j;

    protected ListAdapter(DiffUtil.ItemCallback itemCallback) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void a(List list, List list2) {
                ListAdapter.this.h(list, list2);
            }
        };
        this.f51795j = listListener;
        AsyncListDiffer asyncListDiffer = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).a());
        this.f51794i = asyncListDiffer;
        asyncListDiffer.a(listListener);
    }

    protected Object g(int i3) {
        return this.f51794i.b().get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f51794i.b().size();
    }

    public void i(List list) {
        this.f51794i.e(list);
    }

    public void h(List list, List list2) {
    }
}

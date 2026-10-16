package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ConcatAdapterController f51533i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Config {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Config f51534c = new Config(true, StableIdMode.NO_STABLE_IDS);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f51535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StableIdMode f51536b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum StableIdMode {
            NO_STABLE_IDS,
            ISOLATED_STABLE_IDS,
            SHARED_STABLE_IDS
        }

        Config(boolean z2, StableIdMode stableIdMode) {
            this.f51535a = z2;
            this.f51536b = stableIdMode;
        }
    }

    public ConcatAdapter(RecyclerView.Adapter... adapterArr) {
        this(Config.f51534c, adapterArr);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int findRelativeAdapterPositionIn(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i3) {
        return this.f51533i.q(adapter, viewHolder, i3);
    }

    public boolean g(int i3, RecyclerView.Adapter adapter) {
        return this.f51533i.g(i3, adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f51533i.r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return this.f51533i.o(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f51533i.p(i3);
    }

    public boolean h(RecyclerView.Adapter adapter) {
        return this.f51533i.h(adapter);
    }

    public List i() {
        return Collections.unmodifiableList(this.f51533i.n());
    }

    void j(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    public boolean k(RecyclerView.Adapter adapter) {
        return this.f51533i.F(adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f51533i.w(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        this.f51533i.x(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return this.f51533i.y(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f51533i.z(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.f51533i.A(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.f51533i.B(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.f51533i.C(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.f51533i.D(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z2) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    public ConcatAdapter(Config config, RecyclerView.Adapter... adapterArr) {
        this(config, Arrays.asList(adapterArr));
    }

    public ConcatAdapter(Config config, List list) {
        this.f51533i = new ConcatAdapterController(this, config);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h((RecyclerView.Adapter) it.next());
        }
        super.setHasStableIds(this.f51533i.t());
    }
}

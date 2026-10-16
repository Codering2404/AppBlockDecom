package com.applovin.mediation.nativeAds.adPlacer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.applovin.impl.hl;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MaxAdPlacer.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxAdPlacer f65580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RecyclerView.Adapter f65581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f65582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RecyclerView f65583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private hl f65584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxAdPlacer.Listener f65585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f65586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AdPositionBehavior f65587h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AdPositionBehavior {
        DYNAMIC_EXCEPT_ON_APPEND,
        DYNAMIC,
        FIXED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MaxAdRecyclerViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f65589a;

        public MaxAdRecyclerViewHolder(View view) {
            super(view);
            this.f65589a = (ViewGroup) view.findViewById(R.id.applovin_native_ad_view_container);
        }

        public ViewGroup getContainerView() {
            return this.f65589a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements hl.a {
        a() {
        }

        @Override // com.applovin.impl.hl.a
        public void a(int i3, int i4) {
            MaxRecyclerAdapter.this.f65580a.updateFillablePositions(i3, Math.min(i4 + MaxRecyclerAdapter.this.f65586g, MaxRecyclerAdapter.this.getItemCount() - 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b extends RecyclerView.AdapterDataObserver {
        private b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4) {
            int adjustedPosition = MaxRecyclerAdapter.this.f65580a.getAdjustedPosition(i3);
            MaxRecyclerAdapter.this.notifyItemRangeChanged(adjustedPosition, (MaxRecyclerAdapter.this.f65580a.getAdjustedPosition((i3 + i4) - 1) - adjustedPosition) + 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i4) {
            boolean z2 = i3 + i4 >= MaxRecyclerAdapter.this.f65581b.getItemCount();
            if (MaxRecyclerAdapter.this.f65587h == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.f65587h == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z2)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.f65580a.getAdjustedPosition(i3);
            for (int i5 = 0; i5 < i4; i5++) {
                MaxRecyclerAdapter.this.f65580a.insertItem(adjustedPosition);
            }
            MaxRecyclerAdapter.this.notifyItemRangeInserted(adjustedPosition, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i4, int i5) {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i4) {
            int itemCount = MaxRecyclerAdapter.this.f65581b.getItemCount();
            boolean z2 = i3 + i4 >= itemCount;
            if (MaxRecyclerAdapter.this.f65587h == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.f65587h == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z2)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.f65580a.getAdjustedPosition(i3);
            int adjustedCount = MaxRecyclerAdapter.this.f65580a.getAdjustedCount(itemCount + i4);
            for (int i5 = 0; i5 < i4; i5++) {
                MaxRecyclerAdapter.this.f65580a.removeItem(adjustedPosition);
            }
            int adjustedCount2 = MaxRecyclerAdapter.this.f65580a.getAdjustedCount(itemCount);
            int size = adjustedCount - adjustedCount2;
            Collection<Integer> collectionClearTrailingAds = MaxRecyclerAdapter.this.f65580a.clearTrailingAds(adjustedCount2 - 1);
            if (!collectionClearTrailingAds.isEmpty()) {
                size += collectionClearTrailingAds.size();
            }
            MaxRecyclerAdapter.this.notifyItemRangeRemoved(adjustedPosition - (size - i4), size);
        }

        /* synthetic */ b(MaxRecyclerAdapter maxRecyclerAdapter, a aVar) {
            this();
        }
    }

    public MaxRecyclerAdapter(MaxAdPlacerSettings maxAdPlacerSettings, RecyclerView.Adapter adapter, Activity activity) {
        b bVar = new b(this, null);
        this.f65582c = bVar;
        this.f65586g = 8;
        this.f65587h = AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND;
        MaxAdPlacer maxAdPlacer = new MaxAdPlacer(maxAdPlacerSettings, activity);
        this.f65580a = maxAdPlacer;
        maxAdPlacer.setListener(this);
        super.setHasStableIds(adapter.hasStableIds());
        this.f65581b = adapter;
        adapter.registerAdapterDataObserver(bVar);
    }

    public void destroy() {
        try {
            this.f65581b.unregisterAdapterDataObserver(this.f65582c);
        } catch (Exception unused) {
        }
        this.f65580a.destroy();
        hl hlVar = this.f65584e;
        if (hlVar != null) {
            hlVar.a();
        }
    }

    public MaxAdPlacer getAdPlacer() {
        return this.f65580a;
    }

    public int getAdjustedPosition(int i3) {
        return this.f65580a.getAdjustedPosition(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f65580a.getAdjustedCount(this.f65581b.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (this.f65581b.hasStableIds()) {
            return this.f65580a.isFilledPosition(i3) ? this.f65580a.getAdItemId(i3) : this.f65581b.getItemId(this.f65580a.getOriginalPosition(i3));
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.f65580a.isAdPosition(i3)) {
            return -42;
        }
        return this.f65581b.getItemViewType(this.f65580a.getOriginalPosition(i3));
    }

    public int getOriginalPosition(int i3) {
        return this.f65580a.getOriginalPosition(i3);
    }

    public void loadAds() {
        this.f65580a.loadAds();
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdClicked(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f65585f;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdLoaded(int i3) {
        notifyItemChanged(i3);
        MaxAdPlacer.Listener listener = this.f65585f;
        if (listener != null) {
            listener.onAdLoaded(i3);
        }
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdRemoved(int i3) {
        MaxAdPlacer.Listener listener = this.f65585f;
        if (listener != null) {
            listener.onAdRemoved(i3);
        }
    }

    @Override // com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer.Listener
    public void onAdRevenuePaid(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f65585f;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f65583d = recyclerView;
        hl hlVar = new hl(recyclerView);
        this.f65584e = hlVar;
        hlVar.a(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        this.f65584e.a(viewHolder.itemView, i3);
        if (!this.f65580a.isAdPosition(i3)) {
            this.f65581b.onBindViewHolder(viewHolder, this.f65580a.getOriginalPosition(i3));
            return;
        }
        AppLovinSdkUtils.Size adSize = this.f65580a.getAdSize(i3, a(i3));
        ViewGroup containerView = ((MaxAdRecyclerViewHolder) viewHolder).getContainerView();
        ViewGroup.LayoutParams layoutParams = containerView.getLayoutParams();
        if (adSize == AppLovinSdkUtils.Size.ZERO) {
            layoutParams.width = -2;
            layoutParams.height = -2;
            containerView.setLayoutParams(layoutParams);
        } else {
            layoutParams.width = adSize.getWidth() < 0 ? adSize.getWidth() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getWidth());
            layoutParams.height = adSize.getHeight() < 0 ? adSize.getHeight() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getHeight());
            containerView.setLayoutParams(layoutParams);
            this.f65580a.renderAd(i3, containerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 != -42) {
            return this.f65581b.onCreateViewHolder(viewGroup, i3);
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.max_native_ad_recycler_view_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
        RecyclerView.LayoutManager layoutManager = this.f65583d.getLayoutManager();
        if (layoutManager == null || !layoutManager.q()) {
            layoutParams.width = -1;
            layoutParams.height = -2;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        viewInflate.setLayoutParams(layoutParams);
        return new MaxAdRecyclerViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f65583d = null;
        hl hlVar = this.f65584e;
        if (hlVar != null) {
            hlVar.a();
            this.f65584e = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return viewHolder instanceof MaxAdRecyclerViewHolder ? super.onFailedToRecycleView(viewHolder) : this.f65581b.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            super.onViewAttachedToWindow(viewHolder);
        } else {
            this.f65581b.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
        } else {
            this.f65581b.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        hl hlVar = this.f65584e;
        if (hlVar != null) {
            hlVar.b(viewHolder.itemView);
        }
        if (!(viewHolder instanceof MaxAdRecyclerViewHolder)) {
            this.f65581b.onViewRecycled(viewHolder);
            return;
        }
        if (this.f65580a.isFilledPosition(viewHolder.getBindingAdapterPosition())) {
            ((MaxAdRecyclerViewHolder) viewHolder).getContainerView().removeAllViews();
        }
        super.onViewRecycled(viewHolder);
    }

    public void setAdPositionBehavior(AdPositionBehavior adPositionBehavior) {
        this.f65587h = adPositionBehavior;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z2) {
        super.setHasStableIds(z2);
        this.f65581b.unregisterAdapterDataObserver(this.f65582c);
        this.f65581b.setHasStableIds(z2);
        this.f65581b.registerAdapterDataObserver(this.f65582c);
    }

    public void setListener(MaxAdPlacer.Listener listener) {
        this.f65585f = listener;
    }

    public void setLookAhead(int i3) {
        this.f65586g = i3;
    }

    private int a(int i3) {
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f65583d.getContext(), this.f65583d.getWidth());
        RecyclerView.LayoutManager layoutManager = this.f65583d.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            return layoutManager instanceof StaggeredGridLayoutManager ? iPxToDp / ((StaggeredGridLayoutManager) layoutManager).v2() : iPxToDp;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        return (iPxToDp / gridLayoutManager.Z2()) * gridLayoutManager.d3().f(i3);
    }
}

package com.google.android.libraries.places.internal;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.model.Orientation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzqd extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CoroutineScope f78449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Orientation f78450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f78451k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f78452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f78453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f78454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f78455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final zzpt f78456p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List f78457q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Function1 f78458r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List f78459s;

    public zzqd(CoroutineScope lifecycleScope, Orientation placeDetailsFragmentOrientation, int i3, int i4, boolean z2, boolean z3, List places, zzpt zzptVar, List requestedContent, Function1 onItemClick) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(placeDetailsFragmentOrientation, "placeDetailsFragmentOrientation");
        Intrinsics.checkNotNullParameter(places, "places");
        Intrinsics.checkNotNullParameter(requestedContent, "requestedContent");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.f78449i = lifecycleScope;
        this.f78450j = placeDetailsFragmentOrientation;
        this.f78451k = i3;
        this.f78452l = i4;
        this.f78453m = z2;
        this.f78454n = z3;
        this.f78455o = places;
        this.f78456p = zzptVar;
        this.f78457q = requestedContent;
        this.f78458r = onItemClick;
        this.f78459s = CollectionsKt.emptyList();
    }

    static /* synthetic */ void n(zzqd zzqdVar, zzqc zzqcVar, String str, int i3, com.google.android.libraries.places.widget.internal.placedetails.zzas zzasVar) {
        boolean z2 = zzqdVar.f78450j == Orientation.f79404b || ((int) (((float) zzqcVar.itemView.getWidth()) / zzqcVar.itemView.getContext().getResources().getDisplayMetrics().density)) > 350;
        if (str != null) {
            if (Intrinsics.areEqual(str, "place-image")) {
                zzasVar.c((com.google.android.libraries.places.widget.internal.placedetails.zzbq) zzqdVar.f78459s.get(i3), z2, zzqdVar.f78459s.size() > 0, false, 0);
            }
        } else if (zzqdVar.f78459s.size() > i3) {
            zzasVar.c((com.google.android.libraries.places.widget.internal.placedetails.zzbq) zzqdVar.f78459s.get(i3), z2, zzqdVar.f78459s.size() > 0 && zzqdVar.f78457q.contains(zzpx.f78430a), false, 0);
        } else if (z2 && zzqdVar.f78457q.contains(zzpx.f78430a)) {
            ((ImageView) zzqcVar.itemView.findViewById(R.id.E0)).setVisibility(0);
            zzqcVar.itemView.findViewById(R.id.L0).setVisibility(0);
            zzasVar.c(com.google.android.libraries.places.widget.internal.placedetails.zzbn.f79275a, true, true, false, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(zzqc holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        onBindViewHolder(holder, i3, CollectionsKt.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f78455o.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(final zzqc holder, final int i3, List payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        zzpt zzptVar = this.f78456p;
        CoroutineScope coroutineScope = this.f78449i;
        int i4 = this.f78451k;
        Orientation orientation = this.f78450j;
        final com.google.android.libraries.places.widget.internal.placedetails.zzas zzasVar = new com.google.android.libraries.places.widget.internal.placedetails.zzas(itemView, zzptVar, coroutineScope, i4, orientation);
        View itemView2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        Context context = holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar = new com.google.android.libraries.places.widget.internal.placedetails.zzad(itemView2, context, i4, zzptVar != null ? zzptVar.zzb() : null, com.google.android.libraries.places.widget.internal.placedetails.zzab.f79144c);
        Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        final String str = objFirstOrNull instanceof String ? (String) objFirstOrNull : null;
        if (str == null) {
            if (orientation == Orientation.f79403a) {
                holder.b();
            } else {
                holder.c();
            }
            holder.itemView.findViewById(R.id.f74720g0).setVisibility(8);
            holder.itemView.findViewById(R.id.f74712e0).setVisibility(8);
            zzasVar.a();
            TypedValue typedValue = new TypedValue();
            if (holder.itemView.getContext().getTheme().resolveAttribute(R.attr.P, typedValue, true)) {
                TextViewCompat.o((TextView) holder.itemView.findViewById(R.id.M0), typedValue.resourceId);
            }
            List list = this.f78455o;
            Place place = (Place) list.get(i3);
            boolean z2 = this.f78454n;
            List list2 = this.f78457q;
            zzasVar.b(place, z2, list2.contains(zzpx.f78431b));
            zzadVar.a((Place) list.get(i3), list2.contains(zzpx.f78432c), list2.contains(zzpx.f78434f), list2.contains(zzpx.f78433d), list2.contains(zzpx.f78435g), list2.contains(zzpx.f78436h), null);
            zzadVar.b((Place) list.get(i3), null);
        }
        holder.itemView.post(new Runnable() { // from class: com.google.android.libraries.places.internal.zzpy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzqd.n(this.f78438a, holder, str, i3, zzasVar);
            }
        });
    }

    public final void i(List placeImages) {
        Intrinsics.checkNotNullParameter(placeImages, "placeImages");
        this.f78459s = placeImages;
        int itemCount = getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            notifyItemChanged(i3, "place-image");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = this.f78450j == Orientation.f79403a ? LayoutInflater.from(parent.getContext()).inflate(R.layout.f74804o, parent, false) : LayoutInflater.from(parent.getContext()).inflate(R.layout.f74805p, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new zzqc(this, viewInflate);
    }
}

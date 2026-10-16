package com.google.android.libraries.places.widget.internal.placedetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzw extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f79366i;

    public zzw(List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f79366i = items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79366i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        zzv viewHolder2 = (zzv) viewHolder;
        Intrinsics.checkNotNullParameter(viewHolder2, "viewHolder");
        viewHolder2.b().setText((CharSequence) this.f79366i.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f74797h, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new zzv(viewInflate);
    }
}

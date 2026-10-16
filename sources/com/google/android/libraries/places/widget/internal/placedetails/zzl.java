package com.google.android.libraries.places.widget.internal.placedetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzl extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f79345i;

    public zzl(List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f79345i = items;
    }

    public final boolean g(int i3) {
        if (i3 < 0) {
            return false;
        }
        List list = this.f79345i;
        if (i3 >= list.size() - 1) {
            return false;
        }
        return list.get(i3 + 1) instanceof zzh;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79345i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        zzi zziVar = (zzi) this.f79345i.get(i3);
        if (zziVar instanceof zzh) {
            return 0;
        }
        if (zziVar instanceof zzg) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 0) {
            TextView textViewB = ((zzk) viewHolder).b();
            Object obj = this.f79345i.get(i3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.google.android.libraries.places.widget.internal.placedetails.AboutTabItem.SectionTitle");
            textViewB.setText(((zzh) obj).a());
            return;
        }
        if (itemViewType != 1) {
            return;
        }
        TextView textViewB2 = ((zzj) viewHolder).b();
        Object obj2 = this.f79345i.get(i3);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.google.android.libraries.places.widget.internal.placedetails.AboutTabItem.Feature");
        textViewB2.setText(((zzg) obj2).a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        if (i3 == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.f74791b, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new zzk(viewInflate);
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.f74790a, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new zzj(viewInflate2);
    }
}

package com.google.android.libraries.places.widget.internal.photoviewer;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzm extends FragmentStateAdapter {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List f79120r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.f79120r = CollectionsKt.emptyList();
    }

    public final void A(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f79120r = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79120r.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment i(int i3) {
        int i4 = zzl.f79111j;
        zzd photoPageData = (zzd) this.f79120r.get(i3);
        int size = this.f79120r.size() - 1;
        Intrinsics.checkNotNullParameter(photoPageData, "photoPageData");
        zzl zzlVar = new zzl();
        Bundle bundle = new Bundle();
        bundle.putParcelable("page_data", photoPageData);
        bundle.putBoolean("has_previous", i3 > 0);
        bundle.putBoolean("has_next", i3 < size);
        zzlVar.setArguments(bundle);
        return zzlVar;
    }
}

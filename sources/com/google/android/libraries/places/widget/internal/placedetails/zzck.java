package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzck extends FragmentStateAdapter {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f79331r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Place f79332s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f79333t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final List f79334u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzck(FragmentManager fragmentManager, Lifecycle lifecycle, Context context, boolean z2, boolean z3, Place place, int i3) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(place, "place");
        this.f79331r = z3;
        this.f79332s = place;
        this.f79333t = i3;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (zzcj.k(place, context, z3)) {
            listCreateListBuilder.add(1);
        }
        Intrinsics.checkNotNullParameter(place, "<this>");
        List listF0 = place.f0();
        if (listF0 != null && !listF0.isEmpty()) {
            listCreateListBuilder.add(2);
        }
        Intrinsics.checkNotNullParameter(place, "<this>");
        if (z2 && (zzcj.a(place) || zzcj.b(place) || zzcj.c(place) || zzcj.d(place) || zzcj.e(place) || zzcj.f(place) || zzcj.g(place) || zzcj.h(place) || zzcj.i(place) || zzcj.j(place))) {
            listCreateListBuilder.add(3);
        }
        this.f79334u = CollectionsKt.build(listCreateListBuilder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79334u.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        return ((Number) this.f79334u.get(i3)).intValue();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment i(int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 1) {
            int i4 = this.f79333t;
            boolean z2 = this.f79331r;
            zzao zzaoVar = new zzao();
            Bundle bundle = new Bundle();
            bundle.putInt("arg-theme-res-id", i4);
            bundle.putBoolean("arg-opening-hours-requested", z2);
            zzaoVar.setArguments(bundle);
            return zzaoVar;
        }
        if (itemViewType == 2) {
            int i5 = this.f79333t;
            zzby zzbyVar = new zzby();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("arg-theme-res-id", i5);
            zzbyVar.setArguments(bundle2);
            return zzbyVar;
        }
        if (itemViewType != 3) {
            throw new IllegalStateException("Invalid tab type.");
        }
        int i6 = this.f79333t;
        zzf zzfVar = new zzf();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("arg-theme-res-id", i6);
        zzfVar.setArguments(bundle3);
        return zzfVar;
    }
}

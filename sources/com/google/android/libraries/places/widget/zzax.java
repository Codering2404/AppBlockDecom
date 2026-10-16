package com.google.android.libraries.places.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.widget.model.AttributionPosition;
import com.google.android.libraries.places.widget.model.Orientation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzax extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PlaceSearchFragment f79435a;

    zzax(PlaceSearchFragment placeSearchFragment) {
        this.f79435a = placeSearchFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void b(RecyclerView recyclerView, int i3, int i4) {
        View viewFindViewById;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.b(recyclerView, i3, i4);
        if (!recyclerView.canScrollVertically(1)) {
            View viewFindViewById2 = this.f79435a.requireView().findViewById(R.id.X0);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
                return;
            }
            return;
        }
        PlaceSearchFragment placeSearchFragment = this.f79435a;
        Orientation orientation = placeSearchFragment.f78959k;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        }
        if (orientation == Orientation.f79404b && placeSearchFragment.w() == AttributionPosition.f79379b && (viewFindViewById = placeSearchFragment.requireView().findViewById(R.id.X0)) != null) {
            viewFindViewById.setVisibility(0);
        }
    }
}

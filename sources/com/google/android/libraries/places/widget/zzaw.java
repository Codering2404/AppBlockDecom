package com.google.android.libraries.places.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaw extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PlaceSearchFragment f79434a;

    zzaw(PlaceSearchFragment placeSearchFragment) {
        this.f79434a = placeSearchFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void g(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int layoutDirection = parent.getLayoutDirection();
        int iK0 = parent.k0(view);
        int iB = state.b() - 1;
        boolean z2 = true;
        boolean z3 = layoutDirection == 1;
        if (iK0 == iB) {
            if (z3) {
            }
            outRect.set(0, 0, 0, 0);
        }
        z2 = z3;
        if (iK0 != 0 || !z2) {
            PlaceSearchFragment placeSearchFragment = this.f79434a;
            Context contextRequireContext = placeSearchFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            int iH = placeSearchFragment.H();
            int[] PlacesMaterialThemeAttrs = R.styleable.f74889a;
            Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
            TypedArray typedArrayObtainStyledAttributes = contextRequireContext.obtainStyledAttributes(iH, PlacesMaterialThemeAttrs);
            outRect.set(0, 0, (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.f74901m, placeSearchFragment.requireContext().getResources().getDimensionPixelSize(R.dimen.f74677c)), 0);
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        outRect.set(0, 0, 0, 0);
    }
}

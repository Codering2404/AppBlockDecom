package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzb extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f79241a;

    public zzb(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getResources().getDrawable(R.drawable.f74685a, new ContextThemeWrapper(context, i3).getTheme());
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        this.f79241a = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void g(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int iK0 = parent.k0(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        zzl zzlVar = adapter instanceof zzl ? (zzl) adapter : null;
        if (zzlVar == null || !zzlVar.g(iK0)) {
            return;
        }
        outRect.bottom = this.f79241a.getIntrinsicHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void i(Canvas c3, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c3, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (parent.getAdapter() == null) {
            return;
        }
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = parent.getChildAt(i3);
            int iK0 = parent.k0(childAt);
            if (iK0 != -1) {
                RecyclerView.Adapter adapter = parent.getAdapter();
                zzl zzlVar = adapter instanceof zzl ? (zzl) adapter : null;
                if (zzlVar != null && zzlVar.g(iK0)) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                    int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
                    Drawable drawable = this.f79241a;
                    drawable.setBounds(paddingLeft, bottom, width, drawable.getIntrinsicHeight() + bottom);
                    drawable.draw(c3);
                }
            }
        }
    }
}

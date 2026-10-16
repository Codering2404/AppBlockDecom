package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private int I;
    private final FrameLayout.LayoutParams J;

    private int n(int i3, int i4, int i5) {
        int iMax = i4 / Math.max(1, i5);
        int size = this.I;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i3);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    private int o(View view, int i3, int i4) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i3, i4);
        return view.getMeasuredHeight();
    }

    private int p(int i3, int i4, int i5, View view) {
        int iN = view == null ? n(i3, i4, i5) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int iO = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != view) {
                iO += o(childAt, i3, iN);
            }
        }
        return iO;
    }

    private int q(int i3, int i4, int i5) {
        int iO;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iO = o(childAt, i3, n(i3, i4, i5));
            i4 -= iO;
            i5--;
        } else {
            iO = 0;
        }
        return iO + p(i3, i4, i5, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView f(Context context) {
        return new NavigationRailItemView(context);
    }

    public int getItemMinimumHeight() {
        return this.I;
    }

    int getMenuGravity() {
        return this.J.gravity;
    }

    boolean m() {
        return (this.J.gravity & 112) == 48;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                childAt.layout(0, i8, i7, measuredHeight);
                i8 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int size = View.MeasureSpec.getSize(i4);
        int size2 = getMenu().G().size();
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.resolveSizeAndState((size2 <= 1 || !g(getLabelVisibilityMode(), size2)) ? p(i3, size, size2, null) : q(i3, size, size2), i4, 0));
    }

    public void setItemMinimumHeight(int i3) {
        if (this.I != i3) {
            this.I = i3;
            requestLayout();
        }
    }

    void setMenuGravity(int i3) {
        FrameLayout.LayoutParams layoutParams = this.J;
        if (layoutParams.gravity != i3) {
            layoutParams.gravity = i3;
            setLayoutParams(layoutParams);
        }
    }
}

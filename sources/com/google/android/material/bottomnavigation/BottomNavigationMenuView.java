package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private boolean M;
    private final List N;

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView f(Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean m() {
        return this.M;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        int measuredWidth = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.y(this) == 1) {
                    int i10 = i7 - measuredWidth;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i8);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i8);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i3);
        int size2 = menu.G().size();
        int childCount = getChildCount();
        this.N.clear();
        int size3 = View.MeasureSpec.getSize(i4);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        if (g(getLabelVisibilityMode(), size2) && m()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int iMax = this.L;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.K, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.J * i7), Math.min(iMax, this.K));
            int i8 = size - iMin;
            int iMin2 = Math.min(i8 / (i7 != 0 ? i7 : 1), this.I);
            int i9 = i8 - (i7 * iMin2);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    i6 = i10 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i9 > 0) {
                        i6++;
                        i9--;
                    }
                } else {
                    i6 = 0;
                }
                this.N.add(Integer.valueOf(i6));
                i10++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), this.K);
            int i11 = size - (size2 * iMin3);
            for (int i12 = 0; i12 < childCount; i12++) {
                if (getChildAt(i12).getVisibility() == 8) {
                    i5 = 0;
                } else if (i11 > 0) {
                    i5 = iMin3 + 1;
                    i11--;
                } else {
                    i5 = iMin3;
                }
                this.N.add(Integer.valueOf(i5));
            }
        }
        int measuredWidth = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) this.N.get(i13)).intValue(), 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(measuredWidth, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.M = z2;
    }
}

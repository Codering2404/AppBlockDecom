package com.google.android.material.bottomnavigation;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomNavigationView extends NavigationBarView {

    /* JADX INFO: renamed from: com.google.android.material.bottomnavigation.BottomNavigationView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ViewUtils.OnApplyWindowInsetsListener {
        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            relativePadding.f81316d += windowInsetsCompat.j();
            boolean z2 = ViewCompat.y(view) == 1;
            int iK = windowInsetsCompat.k();
            int iL = windowInsetsCompat.l();
            relativePadding.f81313a += z2 ? iL : iK;
            int i3 = relativePadding.f81315c;
            if (!z2) {
                iK = iL;
            }
            relativePadding.f81315c = i3 + iK;
            relativePadding.a(view);
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    private int c(int i3) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i3) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i3;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, c(i4));
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.m() != z2) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z2);
            getPresenter().h(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        setOnItemReselectedListener(onNavigationItemReselectedListener);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        setOnItemSelectedListener(onNavigationItemSelectedListener);
    }
}

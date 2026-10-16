package com.google.android.material.navigationrail;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class NavigationRailView extends NavigationBarView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f81462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f81463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Boolean f81464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f81465k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Boolean f81466l;

    /* JADX INFO: renamed from: com.google.android.material.navigationrail.NavigationRailView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ViewUtils.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationRailView f81467a;

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            Insets insetsF = windowInsetsCompat.f(WindowInsetsCompat.Type.i());
            NavigationRailView navigationRailView = this.f81467a;
            if (navigationRailView.i(navigationRailView.f81464j)) {
                relativePadding.f81314b += insetsF.f33965b;
            }
            NavigationRailView navigationRailView2 = this.f81467a;
            if (navigationRailView2.i(navigationRailView2.f81465k)) {
                relativePadding.f81316d += insetsF.f33967d;
            }
            NavigationRailView navigationRailView3 = this.f81467a;
            if (navigationRailView3.i(navigationRailView3.f81466l)) {
                relativePadding.f81313a += ViewUtils.o(view) ? insetsF.f33966c : insetsF.f33964a;
            }
            relativePadding.a(view);
            return windowInsetsCompat;
        }
    }

    private boolean g() {
        View view = this.f81463i;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private int h(int i3) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i3) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i3;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(Boolean bool) {
        return bool != null ? bool.booleanValue() : ViewCompat.v(this);
    }

    public View getHeaderView() {
        return this.f81463i;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i7 = 0;
        if (g()) {
            int bottom = this.f81463i.getBottom() + this.f81462h;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i7 = bottom - top;
            }
        } else if (navigationRailMenuView.m()) {
            i7 = this.f81462h;
        }
        if (i7 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i7, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i7);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int iH = h(i3);
        super.onMeasure(iH, i4);
        if (g()) {
            measureChild(getNavigationRailMenuView(), iH, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f81463i.getMeasuredHeight()) - this.f81462h, Integer.MIN_VALUE));
        }
    }

    public void setItemMinimumHeight(int i3) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i3);
    }

    public void setMenuGravity(int i3) {
        getNavigationRailMenuView().setMenuGravity(i3);
    }
}

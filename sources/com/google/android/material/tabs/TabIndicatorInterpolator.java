package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TabIndicatorInterpolator {
    TabIndicatorInterpolator() {
    }

    static RectF a(TabLayout tabLayout, View view) {
        return view == null ? new RectF() : (tabLayout.D() || !(view instanceof TabLayout.TabView)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : b((TabLayout.TabView) view, 24);
    }

    static RectF b(TabLayout.TabView tabView, int i3) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int iG = (int) ViewUtils.g(tabView.getContext(), i3);
        if (contentWidth < iG) {
            contentWidth = iG;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i4 = contentWidth / 2;
        return new RectF(left - i4, top - (contentHeight / 2), i4 + left, top + (left / 2));
    }

    void c(TabLayout tabLayout, View view, Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
    }

    void d(TabLayout tabLayout, View view, View view2, float f3, Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(AnimationUtils.c((int) rectFA.left, (int) rectFA2.left, f3), drawable.getBounds().top, AnimationUtils.c((int) rectFA.right, (int) rectFA2.right, f3), drawable.getBounds().bottom);
    }
}

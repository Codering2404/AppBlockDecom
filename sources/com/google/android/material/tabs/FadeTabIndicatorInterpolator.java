package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    FadeTabIndicatorInterpolator() {
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    void d(TabLayout tabLayout, View view, View view2, float f3, Drawable drawable) {
        if (f3 >= 0.5f) {
            view = view2;
        }
        RectF rectFA = TabIndicatorInterpolator.a(tabLayout, view);
        float fB = f3 < 0.5f ? AnimationUtils.b(1.0f, 0.0f, 0.0f, 0.5f, f3) : AnimationUtils.b(0.0f, 1.0f, 0.5f, 1.0f, f3);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (fB * 255.0f));
    }
}

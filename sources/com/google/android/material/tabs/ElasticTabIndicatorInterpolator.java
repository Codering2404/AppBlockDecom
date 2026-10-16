package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    ElasticTabIndicatorInterpolator() {
    }

    private static float e(float f3) {
        return (float) (1.0d - Math.cos((((double) f3) * 3.141592653589793d) / 2.0d));
    }

    private static float f(float f3) {
        return (float) Math.sin((((double) f3) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.TabIndicatorInterpolator
    void d(TabLayout tabLayout, View view, View view2, float f3, Drawable drawable) {
        float f4;
        float fE;
        RectF rectFA = TabIndicatorInterpolator.a(tabLayout, view);
        RectF rectFA2 = TabIndicatorInterpolator.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            f4 = e(f3);
            fE = f(f3);
        } else {
            f4 = f(f3);
            fE = e(f3);
        }
        drawable.setBounds(AnimationUtils.c((int) rectFA.left, (int) rectFA2.left, f4), drawable.getBounds().top, AnimationUtils.c((int) rectFA.right, (int) rectFA2.right, fE), drawable.getBounds().bottom);
    }
}

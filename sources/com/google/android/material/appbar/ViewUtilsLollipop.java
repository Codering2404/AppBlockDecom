package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ViewUtilsLollipop {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f79979a = {R.attr.stateListAnimator};

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(View view, float f3) {
        int integer = view.getResources().getInteger(com.google.android.material.R.integer.f79667a);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j3 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, com.google.android.material.R.attr.f79519v0, -com.google.android.material.R.attr.f79521w0}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j3));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f3).setDuration(j3));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(View view, AttributeSet attributeSet, int i3, int i4) {
        Context context = view.getContext();
        TypedArray typedArrayI = ThemeEnforcement.i(context, attributeSet, f79979a, i3, i4, new int[0]);
        try {
            if (typedArrayI.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayI.getResourceId(0, 0)));
            }
            typedArrayI.recycle();
        } catch (Throwable th) {
            typedArrayI.recycle();
            throw th;
        }
    }
}

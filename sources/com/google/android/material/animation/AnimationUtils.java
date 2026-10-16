package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AnimationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f79849a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f79850b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f79851c = new FastOutLinearInInterpolator();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f79852d = new LinearOutSlowInInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f79853e = new DecelerateInterpolator();

    public static float a(float f3, float f4, float f5) {
        return f3 + (f5 * (f4 - f3));
    }

    public static float b(float f3, float f4, float f5, float f6, float f7) {
        return f7 <= f5 ? f3 : f7 >= f6 ? f4 : a(f3, f4, (f7 - f5) / (f6 - f5));
    }

    public static int c(int i3, int i4, float f3) {
        return i3 + Math.round(f3 * (i4 - i3));
    }
}

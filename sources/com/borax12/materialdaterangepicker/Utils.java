package com.borax12.materialdaterangepicker;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Utils {
    public static int a(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        fArr[2] = fArr[2] * 0.8f;
        return Color.HSVToColor(fArr);
    }

    public static int b(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorAccent, typedValue, true);
        return typedValue.data;
    }

    public static ObjectAnimator c(View view, float f3, float f4) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.275f, f3);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.69f, f4);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4));
        objectAnimatorOfPropertyValuesHolder.setDuration(544L);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static boolean d() {
        return true;
    }

    public static void e(View view, CharSequence charSequence) {
        if (!d() || view == null || charSequence == null) {
            return;
        }
        view.announceForAccessibility(charSequence);
    }
}

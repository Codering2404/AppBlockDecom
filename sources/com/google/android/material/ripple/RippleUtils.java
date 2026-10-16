package com.google.android.material.ripple;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RippleUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f81616a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f81617b = {R.attr.state_pressed};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f81618c = {R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f81619d = {R.attr.state_focused};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f81620e = {R.attr.state_hovered};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f81621f = {R.attr.state_selected, R.attr.state_pressed};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f81622g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f81623h = {R.attr.state_selected, R.attr.state_focused};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f81624i = {R.attr.state_selected, R.attr.state_hovered};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f81625j = {R.attr.state_selected};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f81626k = {R.attr.state_enabled, R.attr.state_pressed};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f81627l = RippleUtils.class.getSimpleName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RippleUtilsLollipop {
        private static Drawable a(Context context, int i3) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(MaterialColors.g(context, com.google.android.material.R.attr.f79498l, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i3, i3, i3, i3));
        }
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f81616a) {
            int[] iArr = f81619d;
            return new ColorStateList(new int[][]{f81625j, iArr, StateSet.NOTHING}, new int[]{c(colorStateList, f81621f), c(colorStateList, iArr), c(colorStateList, f81617b)});
        }
        int[] iArr2 = f81621f;
        int[] iArr3 = f81622g;
        int[] iArr4 = f81623h;
        int[] iArr5 = f81624i;
        int[] iArr6 = f81617b;
        int[] iArr7 = f81618c;
        int[] iArr8 = f81619d;
        int[] iArr9 = f81620e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f81625j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), c(colorStateList, iArr5), 0, c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), c(colorStateList, iArr9), 0});
    }

    private static int b(int i3) {
        return ColorUtils.k(i3, Math.min(Color.alpha(i3) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f81616a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        return colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
    }

    public static boolean e(int[] iArr) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 : iArr) {
            if (i3 == 16842910) {
                z2 = true;
            } else if (i3 == 16842908 || i3 == 16842919 || i3 == 16843623) {
                z3 = true;
            }
        }
        return z2 && z3;
    }
}

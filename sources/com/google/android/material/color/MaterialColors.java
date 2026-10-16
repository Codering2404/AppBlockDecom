package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialColors {
    public static int a(int i3, int i4) {
        return ColorUtils.k(i3, (Color.alpha(i3) * i4) / 255);
    }

    public static int b(Context context, int i3, int i4) {
        Integer numF = f(context, i3);
        return numF != null ? numF.intValue() : i4;
    }

    public static int c(Context context, int i3, String str) {
        return n(context, MaterialAttributes.e(context, i3, str));
    }

    public static int d(View view, int i3) {
        return n(view.getContext(), MaterialAttributes.f(view, i3));
    }

    public static int e(View view, int i3, int i4) {
        return b(view.getContext(), i3, i4);
    }

    public static Integer f(Context context, int i3) {
        TypedValue typedValueA = MaterialAttributes.a(context, i3);
        if (typedValueA != null) {
            return Integer.valueOf(n(context, typedValueA));
        }
        return null;
    }

    public static ColorStateList g(Context context, int i3, ColorStateList colorStateList) {
        TypedValue typedValueA = MaterialAttributes.a(context, i3);
        ColorStateList colorStateListO = typedValueA != null ? o(context, typedValueA) : null;
        return colorStateListO == null ? colorStateList : colorStateListO;
    }

    public static ColorStateList h(Context context, int i3) {
        TypedValue typedValueA = MaterialAttributes.a(context, i3);
        if (typedValueA == null) {
            return null;
        }
        int i4 = typedValueA.resourceId;
        if (i4 != 0) {
            return ContextCompat.getColorStateList(context, i4);
        }
        int i5 = typedValueA.data;
        if (i5 != 0) {
            return ColorStateList.valueOf(i5);
        }
        return null;
    }

    public static boolean i(int i3) {
        return i3 != 0 && ColorUtils.d(i3) > 0.5d;
    }

    static boolean j(Context context) {
        return MaterialAttributes.b(context, R.attr.F, true);
    }

    public static int k(int i3, int i4) {
        return ColorUtils.g(i4, i3);
    }

    public static int l(int i3, int i4, float f3) {
        return k(i3, ColorUtils.k(i4, Math.round(Color.alpha(i4) * f3)));
    }

    public static int m(View view, int i3, int i4, float f3) {
        return l(d(view, i3), d(view, i4), f3);
    }

    private static int n(Context context, TypedValue typedValue) {
        int i3 = typedValue.resourceId;
        return i3 != 0 ? ContextCompat.getColor(context, i3) : typedValue.data;
    }

    private static ColorStateList o(Context context, TypedValue typedValue) {
        int i3 = typedValue.resourceId;
        return i3 != 0 ? ContextCompat.getColorStateList(context, i3) : ColorStateList.valueOf(typedValue.data);
    }
}

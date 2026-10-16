package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialResources {
    public static ColorStateList a(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (colorStateListA = AppCompatResources.a(context, resourceId)) == null) ? typedArray.getColorStateList(i3) : colorStateListA;
    }

    public static ColorStateList b(Context context, TintTypedArray tintTypedArray, int i3) {
        int iN;
        ColorStateList colorStateListA;
        return (!tintTypedArray.s(i3) || (iN = tintTypedArray.n(i3, 0)) == 0 || (colorStateListA = AppCompatResources.a(context, iN)) == null) ? tintTypedArray.c(i3) : colorStateListA;
    }

    private static int c(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    public static int d(Context context, TypedArray typedArray, int i3, int i4) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i3, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i3, i4);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i4);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable e(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (drawableB = AppCompatResources.b(context, resourceId)) == null) ? typedArray.getDrawable(i3) : drawableB;
    }

    public static float f(Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    static int g(TypedArray typedArray, int i3, int i4) {
        return typedArray.hasValue(i3) ? i3 : i4;
    }

    public static TextAppearance h(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static int i(Context context, int i3, int i4) {
        if (i3 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, R.styleable.R7);
            TypedValue typedValue = new TypedValue();
            boolean value = typedArrayObtainStyledAttributes.getValue(R.styleable.S7, typedValue);
            typedArrayObtainStyledAttributes.recycle();
            if (value) {
                return c(typedValue) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            }
        }
        return i4;
    }

    public static boolean j(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean k(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}

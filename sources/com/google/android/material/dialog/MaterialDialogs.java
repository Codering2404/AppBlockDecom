package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialDialogs {
    public static Rect a(Context context, int i3, int i4) {
        TypedArray typedArrayI = ThemeEnforcement.i(context, null, R.styleable.I3, i3, i4, new int[0]);
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R.styleable.L3, context.getResources().getDimensionPixelSize(R.dimen.f79561d0));
        int dimensionPixelSize2 = typedArrayI.getDimensionPixelSize(R.styleable.M3, context.getResources().getDimensionPixelSize(R.dimen.f79563e0));
        int dimensionPixelSize3 = typedArrayI.getDimensionPixelSize(R.styleable.K3, context.getResources().getDimensionPixelSize(R.dimen.f79559c0));
        int dimensionPixelSize4 = typedArrayI.getDimensionPixelSize(R.styleable.J3, context.getResources().getDimensionPixelSize(R.dimen.f79557b0));
        typedArrayI.recycle();
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    public static InsetDrawable b(Drawable drawable, Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}

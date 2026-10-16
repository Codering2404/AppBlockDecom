package com.google.android.material.theme.overlay;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialThemeOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f82403a = {R.attr.theme, com.google.android.material.R.attr.E0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f82404b = {com.google.android.material.R.attr.R};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f82403a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f82404b, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i3, int i4) {
        int iB = b(context, attributeSet, i3, i4);
        boolean z2 = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).c() == iB;
        if (iB == 0 || z2) {
            return context;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            contextThemeWrapper.getTheme().applyStyle(iA, true);
        }
        return contextThemeWrapper;
    }
}

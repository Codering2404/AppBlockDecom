package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ThemeEnforcement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f81295a = {R.attr.f79514t};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f81296b = {R.attr.f79516u};

    public static void a(Context context) {
        e(context, f81295a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.C9, i3, i4);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.E9, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z2) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.H, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f81296b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.C9, i3, i4);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.F9, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(R.styleable.D9, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i3, i4, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (h(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
        for (int i5 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i5, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static boolean g(Context context) {
        return MaterialAttributes.b(context, R.attr.G, false);
    }

    private static boolean h(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i3)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray i(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        b(context, attributeSet, i3, i4);
        d(context, attributeSet, iArr, i3, i4, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
    }

    public static TintTypedArray j(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        b(context, attributeSet, i3, i4);
        d(context, attributeSet, iArr, i3, i4, iArr2);
        return TintTypedArray.v(context, attributeSet, iArr, i3, i4);
    }
}

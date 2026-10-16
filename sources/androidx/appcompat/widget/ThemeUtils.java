package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ThemeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f2227a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f2228b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f2229c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f2230d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f2231e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f2232f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f2233g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f2234h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[] f2235i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f2236j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.A0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.F0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i3) {
        ColorStateList colorStateListE = e(context, i3);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f2228b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i3, typedValueF.getFloat());
    }

    public static int c(Context context, int i3) {
        int[] iArr = f2236j;
        iArr[0] = i3;
        TintTypedArray tintTypedArrayU = TintTypedArray.u(context, null, iArr);
        try {
            return tintTypedArrayU.b(0, 0);
        } finally {
            tintTypedArrayU.x();
        }
    }

    static int d(Context context, int i3, float f3) {
        return ColorUtils.k(c(context, i3), Math.round(Color.alpha(r0) * f3));
    }

    public static ColorStateList e(Context context, int i3) {
        int[] iArr = f2236j;
        iArr[0] = i3;
        TintTypedArray tintTypedArrayU = TintTypedArray.u(context, null, iArr);
        try {
            return tintTypedArrayU.c(0);
        } finally {
            tintTypedArrayU.x();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f2227a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}

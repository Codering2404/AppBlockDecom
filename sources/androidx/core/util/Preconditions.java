package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    public static void a(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static float c(float f3, String str) {
        if (Float.isNaN(f3)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (!Float.isInfinite(f3)) {
            return f3;
        }
        throw new IllegalArgumentException(str + " must not be infinite");
    }

    public static int d(int i3, int i4, int i5, String str) {
        if (i3 < i4) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i4), Integer.valueOf(i5)));
        }
        if (i3 <= i5) {
            return i3;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    public static int e(int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    public static int f(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str);
    }

    public static int g(int i3, int i4) {
        if ((i3 & i4) == i3) {
            return i3;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i3) + ", but only 0x" + Integer.toHexString(i4) + " are allowed");
    }

    public static Object h(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object i(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static void j(boolean z2, String str) {
        if (!z2) {
            throw new IllegalStateException(str);
        }
    }

    public static CharSequence k(CharSequence charSequence, Object obj) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return charSequence;
    }
}

package androidx.biometric;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class DeviceUtils {
    private static boolean a(Context context, String str, int i3) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i3)) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(Context context, String str, int i3) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i3)) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(Context context, String str, int i3) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i3)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    static boolean d(Context context, String str) {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return a(context, str, R.array.f2494c);
    }

    static boolean e(Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return b(context, str, R.array.f2495d);
    }

    static boolean f(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return c(context, str, R.array.f2493b) || b(context, str2, R.array.f2492a);
    }
}

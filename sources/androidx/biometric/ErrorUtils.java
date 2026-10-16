package androidx.biometric;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class ErrorUtils {
    static String a(Context context, int i3) {
        if (context == null) {
            return "";
        }
        if (i3 == 1) {
            return context.getString(R.string.f2507d);
        }
        if (i3 != 7) {
            switch (i3) {
                case 9:
                    break;
                case 10:
                    return context.getString(R.string.f2511h);
                case 11:
                    return context.getString(R.string.f2510g);
                case 12:
                    return context.getString(R.string.f2508e);
                default:
                    Log.e("BiometricUtils", "Unknown error code: " + i3);
                    return context.getString(R.string.f2505b);
            }
        }
        return context.getString(R.string.f2509f);
    }

    static boolean b(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 6:
            default:
                return false;
        }
    }

    static boolean c(int i3) {
        return i3 == 7 || i3 == 9;
    }
}

package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppOpsManagerCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static Object a(Context context, Class cls) {
            return context.getSystemService(cls);
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        static String c(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static int a(AppOpsManager appOpsManager, String str, int i3, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i3, str2);
        }

        static String b(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager c(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(Context context, int i3, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return b(context, str, str2);
        }
        AppOpsManager appOpsManagerC = Api29Impl.c(context);
        int iA = Api29Impl.a(appOpsManagerC, str, Binder.getCallingUid(), str2);
        return iA != 0 ? iA : Api29Impl.a(appOpsManagerC, str, i3, Api29Impl.b(context));
    }

    public static int b(Context context, String str, String str2) {
        return Api23Impl.b((AppOpsManager) Api23Impl.a(context, AppOpsManager.class), str, str2);
    }

    public static String c(String str) {
        return Api23Impl.c(str);
    }
}

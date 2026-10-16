package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LocaleManagerCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }
    }

    public static LocaleListCompat a(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return LocaleListCompat.c(AppLocalesStorageHelper.b(context));
        }
        Object objB = b(context);
        return objB != null ? LocaleListCompat.k(Api33Impl.a(objB)) : LocaleListCompat.f();
    }

    private static Object b(Context context) {
        return context.getSystemService("locale");
    }
}

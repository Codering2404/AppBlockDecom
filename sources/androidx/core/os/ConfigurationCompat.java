package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ConfigurationCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        static void b(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales((LocaleList) localeListCompat.j());
        }
    }

    public static LocaleListCompat a(Configuration configuration) {
        return LocaleListCompat.k(Api24Impl.a(configuration));
    }

    public static void b(Configuration configuration, LocaleListCompat localeListCompat) {
        Api24Impl.b(configuration, localeListCompat);
    }
}

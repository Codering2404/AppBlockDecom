package androidx.appcompat.app;

import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
final class LocaleOverlayHelper {
    private static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i3 = 0;
        while (i3 < localeListCompat.h() + localeListCompat2.h()) {
            Locale localeD = i3 < localeListCompat.h() ? localeListCompat.d(i3) : localeListCompat2.d(i3 - localeListCompat.h());
            if (localeD != null) {
                linkedHashSet.add(localeD);
            }
            i3++;
        }
        return LocaleListCompat.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static LocaleListCompat b(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        return (localeListCompat == null || localeListCompat.g()) ? LocaleListCompat.f() : a(localeListCompat, localeListCompat2);
    }
}

package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LocaleListCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LocaleListCompat f34154b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocaleListInterface f34155a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Locale[] f34156a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getDefault();
        }
    }

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.f34155a = localeListInterface;
    }

    public static LocaleListCompat a(Locale... localeArr) {
        return k(Api24Impl.a(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static LocaleListCompat c(String str) {
        if (str == null || str.isEmpty()) {
            return f();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i3 = 0; i3 < length; i3++) {
            localeArr[i3] = Api21Impl.a(strArrSplit[i3]);
        }
        return a(localeArr);
    }

    public static LocaleListCompat e() {
        return k(Api24Impl.b());
    }

    public static LocaleListCompat f() {
        return f34154b;
    }

    public static LocaleListCompat k(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    public Locale d(int i3) {
        return this.f34155a.get(i3);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.f34155a.equals(((LocaleListCompat) obj).f34155a);
    }

    public boolean g() {
        return this.f34155a.isEmpty();
    }

    public int h() {
        return this.f34155a.size();
    }

    public int hashCode() {
        return this.f34155a.hashCode();
    }

    public String i() {
        return this.f34155a.a();
    }

    public Object j() {
        return this.f34155a.b();
    }

    public String toString() {
        return this.f34155a.toString();
    }
}

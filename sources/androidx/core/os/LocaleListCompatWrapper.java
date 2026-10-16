package androidx.core.os;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class LocaleListCompatWrapper implements LocaleListInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Locale[] f34157c = new Locale[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Locale f34158d = new Locale("en", "XA");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Locale f34159e = new Locale("ar", "XB");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Locale f34160f = LocaleListCompat.b("en-Latn");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale[] f34161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f34162b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
    }

    @Override // androidx.core.os.LocaleListInterface
    public String a() {
        return this.f34162b;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).f34161a;
        if (this.f34161a.length != localeArr.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            Locale[] localeArr2 = this.f34161a;
            if (i3 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i3].equals(localeArr[i3])) {
                return false;
            }
            i3++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i3) {
        if (i3 < 0) {
            return null;
        }
        Locale[] localeArr = this.f34161a;
        if (i3 < localeArr.length) {
            return localeArr[i3];
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f34161a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.f34161a.length == 0;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f34161a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.f34161a;
            if (i3 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i3]);
            if (i3 < this.f34161a.length - 1) {
                sb.append(',');
            }
            i3++;
        }
    }
}

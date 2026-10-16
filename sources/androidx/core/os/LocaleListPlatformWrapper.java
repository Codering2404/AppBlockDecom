package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocaleList f34163a;

    LocaleListPlatformWrapper(Object obj) {
        this.f34163a = (LocaleList) obj;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String a() {
        return this.f34163a.toLanguageTags();
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object b() {
        return this.f34163a;
    }

    public boolean equals(Object obj) {
        return this.f34163a.equals(((LocaleListInterface) obj).b());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i3) {
        return this.f34163a.get(i3);
    }

    public int hashCode() {
        return this.f34163a.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.f34163a.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f34163a.size();
    }

    public String toString() {
        return this.f34163a.toString();
    }
}

package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LocusIdCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocusId f33834b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api29Impl {
        static LocusId a(String str) {
            return new LocusId(str);
        }

        static String b(LocusId locusId) {
            return locusId.getId();
        }
    }

    public LocusIdCompat(String str) {
        this.f33833a = (String) Preconditions.k(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f33834b = Api29Impl.a(str);
        } else {
            this.f33834b = null;
        }
    }

    private String b() {
        return this.f33833a.length() + "_chars";
    }

    public static LocusIdCompat d(LocusId locusId) {
        Preconditions.i(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.k(Api29Impl.b(locusId), "id cannot be empty"));
    }

    public String a() {
        return this.f33833a;
    }

    public LocusId c() {
        return this.f33834b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.f33833a;
        return str == null ? locusIdCompat.f33833a == null : str.equals(locusIdCompat.f33833a);
    }

    public int hashCode() {
        String str = this.f33833a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}

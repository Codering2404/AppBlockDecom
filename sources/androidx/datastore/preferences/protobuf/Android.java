package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Android {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f35967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f35968b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f35969c;

    static {
        f35969c = (f35967a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class b() {
        return f35968b;
    }

    static boolean c() {
        if (f35967a) {
            return true;
        }
        return (f35968b == null || f35969c) ? false : true;
    }
}

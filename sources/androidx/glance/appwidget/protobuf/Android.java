package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Android {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f38779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f38780b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f38781c;

    static {
        f38781c = (f38779a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class b() {
        return f38780b;
    }

    static boolean c() {
        if (f38779a) {
            return true;
        }
        return (f38780b == null || f38781c) ? false : true;
    }
}

package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ExtensionRegistryFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Class f38940a = c();

    public static ExtensionRegistryLite a() {
        ExtensionRegistryLite extensionRegistryLiteB = b("getEmptyRegistry");
        return extensionRegistryLiteB != null ? extensionRegistryLiteB : ExtensionRegistryLite.f38943d;
    }

    private static final ExtensionRegistryLite b(String str) {
        Class cls = f38940a;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class c() {
        try {
            return Class.forName("androidx.glance.appwidget.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}

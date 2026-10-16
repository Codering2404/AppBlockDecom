package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ExtensionSchemas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExtensionSchema f38949a = new ExtensionSchemaLite();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExtensionSchema f38950b = c();

    static ExtensionSchema a() {
        ExtensionSchema extensionSchema = f38950b;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static ExtensionSchema b() {
        return f38949a;
    }

    private static ExtensionSchema c() {
        try {
            return (ExtensionSchema) Class.forName("androidx.glance.appwidget.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

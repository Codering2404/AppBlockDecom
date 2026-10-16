package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ExtensionSchemas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExtensionSchema f36291a = new ExtensionSchemaLite();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExtensionSchema f36292b = c();

    static ExtensionSchema a() {
        ExtensionSchema extensionSchema = f36292b;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static ExtensionSchema b() {
        return f36291a;
    }

    private static ExtensionSchema c() {
        if (Protobuf.f36554d) {
            return null;
        }
        try {
            return (ExtensionSchema) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

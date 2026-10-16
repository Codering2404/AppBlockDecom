package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MapFieldSchemas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MapFieldSchema f36509a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MapFieldSchema f36510b = new MapFieldSchemaLite();

    static MapFieldSchema a() {
        return f36509a;
    }

    static MapFieldSchema b() {
        return f36510b;
    }

    private static MapFieldSchema c() {
        if (Protobuf.f36554d) {
            return null;
        }
        try {
            return (MapFieldSchema) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

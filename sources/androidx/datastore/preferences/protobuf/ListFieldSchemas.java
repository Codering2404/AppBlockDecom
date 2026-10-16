package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ListFieldSchemas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ListFieldSchema f36489a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ListFieldSchema f36490b = new ListFieldSchemaLite();

    static ListFieldSchema a() {
        return f36489a;
    }

    static ListFieldSchema b() {
        return f36490b;
    }

    private static ListFieldSchema c() {
        if (Protobuf.f36554d) {
            return null;
        }
        try {
            return (ListFieldSchema) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

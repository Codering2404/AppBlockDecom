package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class Protobuf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Protobuf f36553c = new Protobuf();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f36554d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f36556b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SchemaFactory f36555a = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf a() {
        return f36553c;
    }

    public Schema b(Class cls, Schema schema) {
        Internal.b(cls, "messageType");
        Internal.b(schema, "schema");
        return (Schema) this.f36556b.putIfAbsent(cls, schema);
    }

    public Schema c(Class cls) {
        Schema schemaB;
        Internal.b(cls, "messageType");
        Schema schemaA = (Schema) this.f36556b.get(cls);
        return (schemaA != null || (schemaB = b(cls, (schemaA = this.f36555a.a(cls)))) == null) ? schemaA : schemaB;
    }

    public Schema d(Object obj) {
        return c(obj.getClass());
    }

    public void e(Object obj, Writer writer) {
        d(obj).h(obj, writer);
    }
}

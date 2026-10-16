package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
final class Protobuf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Protobuf f87061c = new Protobuf();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f87063b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SchemaFactory f87062a = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf a() {
        return f87061c;
    }

    public Schema b(Class cls, Schema schema) {
        Internal.b(cls, "messageType");
        Internal.b(schema, "schema");
        return (Schema) this.f87063b.putIfAbsent(cls, schema);
    }

    public Schema c(Class cls) {
        Schema schemaB;
        Internal.b(cls, "messageType");
        Schema schemaA = (Schema) this.f87063b.get(cls);
        return (schemaA != null || (schemaB = b(cls, (schemaA = this.f87062a.a(cls)))) == null) ? schemaA : schemaB;
    }

    public Schema d(Object obj) {
        return c(obj.getClass());
    }

    public void e(Object obj, Writer writer) {
        d(obj).i(obj, writer);
    }
}

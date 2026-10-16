package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
final class ExtensionSchemas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExtensionSchema f86810a = new ExtensionSchemaLite();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExtensionSchema f86811b = c();

    static ExtensionSchema a() {
        ExtensionSchema extensionSchema = f86811b;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static ExtensionSchema b() {
        return f86810a;
    }

    private static ExtensionSchema c() {
        try {
            return (ExtensionSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

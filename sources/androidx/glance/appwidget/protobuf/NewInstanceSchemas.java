package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class NewInstanceSchemas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final NewInstanceSchema f39184a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final NewInstanceSchema f39185b = new NewInstanceSchemaLite();

    static NewInstanceSchema a() {
        return f39184a;
    }

    static NewInstanceSchema b() {
        return f39185b;
    }

    private static NewInstanceSchema c() {
        try {
            return (NewInstanceSchema) Class.forName("androidx.glance.appwidget.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}

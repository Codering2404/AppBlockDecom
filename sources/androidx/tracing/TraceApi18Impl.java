package androidx.tracing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TraceApi18Impl {
    public static void a(String str) {
        android.os.Trace.beginSection(str);
    }

    public static void b() {
        android.os.Trace.endSection();
    }
}

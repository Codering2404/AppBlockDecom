package androidx.datastore.preferences.protobuf;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeVersion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RuntimeDomain f36583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RuntimeDomain f36584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f36585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f36586d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ProtobufRuntimeVersionException extends RuntimeException {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        f36583a = runtimeDomain;
        f36584b = runtimeDomain;
        f36585c = a(4, 28, 2, "");
        f36586d = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private static String a(int i3, int i4, int i5, String str) {
        return String.format("%d.%d.%d%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str);
    }
}

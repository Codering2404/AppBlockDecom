package androidx.glance.appwidget.protobuf;

import com.appsflyer.AppsFlyerProperties;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ByteBufferWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f38827a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f38828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f38829c;

    static {
        Class clsB = b("java.io.FileOutputStream");
        f38828b = clsB;
        f38829c = a(clsB);
    }

    private static long a(Class cls) {
        if (cls == null) {
            return -1L;
        }
        try {
            if (UnsafeUtil.J()) {
                return UnsafeUtil.M(cls.getDeclaredField(AppsFlyerProperties.CHANNEL));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}

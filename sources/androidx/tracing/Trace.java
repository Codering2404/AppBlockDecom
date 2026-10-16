package androidx.tracing;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Trace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f53342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f53343b;

    public static void a(String str) {
        TraceApi18Impl.a(f(str));
    }

    public static void b() {
        TraceApi18Impl.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 29 ? TraceApi29Impl.a() : e();
    }

    private static boolean e() {
        try {
            if (f53343b == null) {
                f53342a = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f53343b = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f53343b.invoke(null, Long.valueOf(f53342a))).booleanValue();
        } catch (Exception e3) {
            c("isTagEnabled", e3);
            return false;
        }
    }

    private static String f(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}

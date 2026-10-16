package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class TraceCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f34173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f34174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f34175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f34176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f34177e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f34173a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f34174b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f34175c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f34176d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f34177e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e3) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e3);
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}

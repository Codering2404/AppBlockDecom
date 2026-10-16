package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class VolleyLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f57724a = "Volley";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f57725b = Log.isLoggable("Volley", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f57726c = VolleyLog.class.getName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MarkerLog {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final boolean f57727c = VolleyLog.f57725b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f57728a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f57729b = false;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Marker {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f57730a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f57731b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f57732c;

            public Marker(String str, long j3, long j4) {
                this.f57730a = str;
                this.f57731b = j3;
                this.f57732c = j4;
            }
        }

        MarkerLog() {
        }

        private long c() {
            if (this.f57728a.size() == 0) {
                return 0L;
            }
            return ((Marker) this.f57728a.get(r2.size() - 1)).f57732c - ((Marker) this.f57728a.get(0)).f57732c;
        }

        public synchronized void a(String str, long j3) {
            if (this.f57729b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f57728a.add(new Marker(str, j3, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.f57729b = true;
            long jC = c();
            if (jC <= 0) {
                return;
            }
            long j3 = ((Marker) this.f57728a.get(0)).f57732c;
            VolleyLog.b("(%-4d ms) %s", Long.valueOf(jC), str);
            for (Marker marker : this.f57728a) {
                long j4 = marker.f57732c;
                VolleyLog.b("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(marker.f57731b), marker.f57730a);
                j3 = j4;
            }
        }

        protected void finalize() {
            if (this.f57729b) {
                return;
            }
            b("Request on the loose");
            VolleyLog.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i3 = 2;
        while (true) {
            if (i3 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i3].getClassName().equals(f57726c)) {
                String className = stackTrace[i3].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i3].getMethodName();
                break;
            }
            i3++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f57724a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f57724a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(f57724a, a(str, objArr), th);
    }

    public static void e(String str, Object... objArr) {
        if (f57725b) {
            Log.v(f57724a, a(str, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        Log.wtf(f57724a, a(str, objArr));
    }
}

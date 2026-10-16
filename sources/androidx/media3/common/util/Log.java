package androidx.media3.common.util;

import android.text.TextUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Log {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f41554b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f41555c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f41553a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Logger f41556d = Logger.f41557a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Logger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Logger f41557a = new Logger() { // from class: androidx.media3.common.util.Log.Logger.1
            @Override // androidx.media3.common.util.Log.Logger
            public void a(String str, String str2, Throwable th) {
                android.util.Log.d(str, Log.a(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            public void b(String str, String str2, Throwable th) {
                android.util.Log.w(str, Log.a(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            public void c(String str, String str2, Throwable th) {
                android.util.Log.i(str, Log.a(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            public void e(String str, String str2, Throwable th) {
                android.util.Log.e(str, Log.a(str2, th));
            }
        };

        void a(String str, String str2, Throwable th);

        void b(String str, String str2, Throwable th);

        void c(String str, String str2, Throwable th);

        void e(String str, String str2, Throwable th);
    }

    public static String a(String str, Throwable th) {
        String strF = f(th);
        if (TextUtils.isEmpty(strF)) {
            return str;
        }
        return str + "\n  " + strF.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (f41553a) {
            try {
                if (f41554b == 0) {
                    f41556d.a(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        synchronized (f41553a) {
            try {
                if (f41554b == 0) {
                    f41556d.a(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void d(String str, String str2) {
        synchronized (f41553a) {
            try {
                if (f41554b <= 3) {
                    f41556d.e(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        synchronized (f41553a) {
            try {
                if (f41554b <= 3) {
                    f41556d.e(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String f(Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (f41553a) {
            try {
                if (h(th)) {
                    return "UnknownHostException (no network)";
                }
                if (f41555c) {
                    return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
                }
                return th.getMessage();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void g(String str, String str2) {
        synchronized (f41553a) {
            try {
                if (f41554b <= 1) {
                    f41556d.c(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean h(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void i(String str, String str2) {
        synchronized (f41553a) {
            try {
                if (f41554b <= 2) {
                    f41556d.b(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void j(String str, String str2, Throwable th) {
        synchronized (f41553a) {
            try {
                if (f41554b <= 2) {
                    f41556d.b(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

package androidx.work;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f54538a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Logger f54539b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f54540c = 20;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LogcatLogger extends Logger {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f54541d;

        public LogcatLogger(int i3) {
            super(i3);
            this.f54541d = i3;
        }

        @Override // androidx.work.Logger
        public void a(String str, String str2) {
            if (this.f54541d <= 3) {
                Log.d(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void b(String str, String str2, Throwable th) {
            if (this.f54541d <= 3) {
                Log.d(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public void c(String str, String str2) {
            if (this.f54541d <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void d(String str, String str2, Throwable th) {
            if (this.f54541d <= 6) {
                Log.e(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public void f(String str, String str2) {
            if (this.f54541d <= 4) {
                Log.i(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void g(String str, String str2, Throwable th) {
            if (this.f54541d <= 4) {
                Log.i(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public void j(String str, String str2) {
            if (this.f54541d <= 2) {
                Log.v(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void k(String str, String str2) {
            if (this.f54541d <= 5) {
                Log.w(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public void l(String str, String str2, Throwable th) {
            if (this.f54541d <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public Logger(int i3) {
    }

    public static Logger e() {
        Logger logger;
        synchronized (f54538a) {
            try {
                if (f54539b == null) {
                    f54539b = new LogcatLogger(3);
                }
                logger = f54539b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logger;
    }

    public static void h(Logger logger) {
        synchronized (f54538a) {
            f54539b = logger;
        }
    }

    public static String i(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i3 = f54540c;
        if (length >= i3) {
            sb.append(str.substring(0, i3));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2);

    public abstract void b(String str, String str2, Throwable th);

    public abstract void c(String str, String str2);

    public abstract void d(String str, String str2, Throwable th);

    public abstract void f(String str, String str2);

    public abstract void g(String str, String str2, Throwable th);

    public abstract void j(String str, String str2);

    public abstract void k(String str, String str2);

    public abstract void l(String str, String str2, Throwable th);
}

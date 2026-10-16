package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Logger {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Logger f88280c = new Logger("FirebaseCrashlytics");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f88282b = 4;

    public Logger(String str) {
        this.f88281a = str;
    }

    private boolean a(int i3) {
        return this.f88282b <= i3 || Log.isLoggable(this.f88281a, i3);
    }

    public static Logger f() {
        return f88280c;
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f88281a, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f88281a, str, th);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f88281a, str, th);
        }
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f88281a, str, th);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f88281a, str, th);
        }
    }
}

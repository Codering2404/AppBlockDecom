package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GmsLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71997b;

    public GmsLogger(String str) {
        this(str, null);
    }

    private final String f(String str) {
        String str2 = this.f71997b;
        return str2 == null ? str : str2.concat(str);
    }

    public boolean a(int i3) {
        return Log.isLoggable(this.f71996a, i3);
    }

    public void b(String str, String str2) {
        if (a(3)) {
            Log.d(str, f(str2));
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, f(str2), th);
        }
    }

    public void d(String str, String str2) {
        if (a(2)) {
            Log.v(str, f(str2));
        }
    }

    public void e(String str, String str2) {
        if (a(5)) {
            Log.w(str, f(str2));
        }
    }

    public GmsLogger(String str, String str2) {
        Preconditions.n(str, "log tag cannot be null");
        Preconditions.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f71996a = str;
        this.f71997b = (str2 == null || str2.length() <= 0) ? null : str2;
    }
}

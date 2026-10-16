package com.singular.sdk.internal;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularLog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f92732c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f92733d = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f92734a = "Singular";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f92735b;

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularLog$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends SingularLog {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f92736e;

        @Override // com.singular.sdk.internal.SingularLog
        protected boolean j(int i3) {
            return super.j(i3) && this.f92736e;
        }
    }

    private SingularLog(String str) {
        this.f92735b = str;
    }

    public static SingularLog f(String str) {
        return new SingularLog(str);
    }

    public static String g() {
        return String.format("%s", Thread.currentThread().getName());
    }

    public int a(String str) {
        if (j(3)) {
            return Log.d("Singular", k(str));
        }
        return 0;
    }

    public int b(String str, Object... objArr) {
        if (j(3)) {
            return Log.d("Singular", k(String.format(str, objArr)));
        }
        return 0;
    }

    public int c(String str) {
        if (j(6)) {
            return Log.e("Singular", k(str));
        }
        return 0;
    }

    public int d(String str, Throwable th) {
        if (j(6)) {
            return Log.e("Singular", k(str), th);
        }
        return 0;
    }

    public int e(String str, Object... objArr) {
        if (j(6)) {
            return Log.e("Singular", k(String.format(str, objArr)));
        }
        return 0;
    }

    public int h(String str) {
        if (j(4)) {
            return Log.i("Singular", k(str));
        }
        return 0;
    }

    public boolean i() {
        return j(3);
    }

    protected boolean j(int i3) {
        return f92732c && f92733d <= i3;
    }

    String k(String str) {
        return String.format("%s [%s] - %s", this.f92735b, g(), str);
    }
}

package com.applovin.impl.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.pc;
import com.applovin.impl.sj;
import com.applovin.impl.z3;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f63429b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63430a;

    n(j jVar) {
        this.f63430a = jVar;
        a("SDK Session Begin");
    }

    public static void a(boolean z2) {
        f63429b = z2;
    }

    public static void c(String str, String str2, Throwable th) {
        if (!f63429b || a()) {
            Log.e("AppLovinSdk", "[" + str + "] " + str2, th);
        }
    }

    public static void e(String str, String str2) {
        g(str, str2);
    }

    public static void g(String str, String str2) {
        if (!f63429b || a()) {
            Log.d("AppLovinSdk", "[" + str + "] " + str2);
        }
    }

    public static void h(String str, String str2) {
        c(str, str2, null);
    }

    public static void i(String str, String str2) {
        if (!f63429b || a()) {
            Log.i("AppLovinSdk", "[" + str + "] " + str2);
        }
    }

    public static void j(String str, String str2) {
        if (!f63429b || a()) {
            Log.w("AppLovinSdk", "[" + str + "] " + str2);
        }
    }

    public static void l(String str, String str2) {
        j jVar = j.f63329u0;
        if (jVar == null) {
            return;
        }
        jVar.I();
        if (a()) {
            j.f63329u0.I().k(str, str2);
        }
    }

    public void b(String str, String str2) {
        a(str, str2, null);
    }

    public void d(String str, String str2) {
        Log.i("AppLovinSdk", "[" + str + "] " + str2);
    }

    public void f(String str, String str2) {
        int iIntValue;
        if (a(this.f63430a) && !TextUtils.isEmpty(str2) && (iIntValue = ((Integer) this.f63430a.a(sj.f63791t)).intValue()) > 0) {
            int length = str2.length();
            int i3 = ((length + iIntValue) - 1) / iIntValue;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 * iIntValue;
                a(str, str2.substring(i5, Math.min(length, i5 + iIntValue)));
            }
        }
    }

    public void k(String str, String str2) {
        d(str, str2, null);
    }

    private void a(String str) {
        pc pcVar = new pc();
        pcVar.a().a(str).a();
        g("AppLovinSdk", pcVar.toString());
    }

    public static void b(String str, String str2, Throwable th) {
        j jVar = j.f63329u0;
        if (jVar == null) {
            return;
        }
        jVar.I();
        if (a()) {
            j.f63329u0.I().a(str, str2, th);
        }
    }

    public void d(String str, String str2, Throwable th) {
        Log.w("AppLovinSdk", "[" + str + "] " + str2, th);
    }

    public static void c(String str, String str2) {
        b(str, str2, null);
    }

    public void a(String str, Throwable th) {
        if (z3.e()) {
            for (Throwable th2 : th.getSuppressed()) {
                b(str, th2.toString());
            }
        }
    }

    public void a(String str, String str2) {
        Log.d("AppLovinSdk", "[" + str + "] " + str2);
    }

    public void a(String str, String str2, Throwable th) {
        Log.e("AppLovinSdk", "[" + str + "] " + str2, th);
    }

    public static boolean a() {
        return a(j.f63329u0);
    }

    public static boolean a(j jVar) {
        return jVar != null && jVar.g0().c();
    }
}

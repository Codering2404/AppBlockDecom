package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WebView f63821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f63822b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f63825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f63826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f63827g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f63823c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f63824d = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicBoolean f63828h = new AtomicBoolean();

    static {
        if (e()) {
            f63822b = (String) vj.a(uj.K, "", com.applovin.impl.sdk.j.m());
            return;
        }
        f63822b = "";
        vj.b(uj.K, (Object) null, com.applovin.impl.sdk.j.m());
        vj.b(uj.L, (Object) null, com.applovin.impl.sdk.j.m());
    }

    public static void a(final com.applovin.impl.sdk.j jVar) {
        if (f63824d.getAndSet(true)) {
            return;
        }
        if (((Boolean) jVar.a(sj.c4)).booleanValue() && e()) {
            return;
        }
        if (z3.d()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.e50
                @Override // java.lang.Runnable
                public final void run() {
                    sr.d(jVar);
                }
            });
        } else {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.f50
                @Override // java.lang.Runnable
                public final void run() {
                    sr.e(jVar);
                }
            });
        }
    }

    public static String b() {
        return f63827g;
    }

    public static String c() {
        return f63826f;
    }

    public static int d() {
        return f63825e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(com.applovin.impl.sdk.j jVar) {
        try {
            f(jVar);
            synchronized (f63823c) {
                f63822b = f63821a.getSettings().getUserAgentString();
                vj.b(uj.K, f63822b, com.applovin.impl.sdk.j.m());
                vj.b(uj.L, Build.VERSION.RELEASE, com.applovin.impl.sdk.j.m());
            }
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("WebViewDataCollector", "Failed to collect user agent", th);
            }
            jVar.D().a("WebViewDataCollector", "collectUserAgent", th);
        }
    }

    public static void b(com.applovin.impl.sdk.j jVar) {
        if (f63828h.getAndSet(true)) {
            return;
        }
        PackageInfo packageInfoC = c(jVar);
        if (packageInfoC != null) {
            f63825e = packageInfoC.versionCode;
            f63826f = packageInfoC.versionName;
            f63827g = packageInfoC.packageName;
        } else {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("WebViewDataCollector", "Failed to get WebView package info");
            }
        }
    }

    private static PackageInfo c(com.applovin.impl.sdk.j jVar) {
        PackageManager packageManager = com.applovin.impl.sdk.j.m().getPackageManager();
        if (z3.i()) {
            return WebView.getCurrentWebViewPackage();
        }
        Iterator it = jVar.c(sj.q4).iterator();
        while (it.hasNext()) {
            try {
                return packageManager.getPackageInfo((String) it.next(), 0);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(com.applovin.impl.sdk.j jVar) {
        try {
            synchronized (f63823c) {
                f63822b = WebSettings.getDefaultUserAgent(com.applovin.impl.sdk.j.m());
                vj.b(uj.K, f63822b, com.applovin.impl.sdk.j.m());
                vj.b(uj.L, Build.VERSION.RELEASE, com.applovin.impl.sdk.j.m());
            }
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("WebViewDataCollector", "Failed to collect user agent", th);
            }
            jVar.D().a("WebViewDataCollector", "collectUserAgent", th);
        }
    }

    public static String a() {
        String str;
        synchronized (f63823c) {
            str = f63822b;
        }
        return str;
    }

    public static boolean e() {
        boolean zEquals;
        synchronized (f63823c) {
            zEquals = Build.VERSION.RELEASE.equals((String) vj.a(uj.L, "", com.applovin.impl.sdk.j.m()));
        }
        return zEquals;
    }

    public static void f(com.applovin.impl.sdk.j jVar) {
    }
}

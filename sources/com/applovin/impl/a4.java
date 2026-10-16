package com.applovin.impl;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f58165a = new a("Age Restricted User", uj.f64237m);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f58166b = new a("Has User Consent", uj.f64236l);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f58167c = new a("\"Do Not Sell\"", uj.f64238n);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f58168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final uj f58169b;

        a(String str, uj ujVar) {
            this.f58168a = str;
            this.f58169b = ujVar;
        }

        public Boolean b(Context context) {
            if (context != null) {
                return (Boolean) vj.a(this.f58169b, (Object) null, context);
            }
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to get value for key: " + this.f58169b);
            return null;
        }

        public String a() {
            return this.f58168a;
        }

        public String a(Context context) {
            Boolean boolB = b(context);
            return boolB != null ? boolB.toString() : "No value set";
        }
    }

    private static boolean a(uj ujVar, Boolean bool, Context context) {
        if (context != null) {
            Boolean bool2 = (Boolean) vj.a(ujVar, (Object) null, context);
            vj.b(ujVar, bool, context);
            return bool2 == null || bool2 != bool;
        }
        com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to update compliance value for key: " + ujVar);
        return false;
    }

    public static a b() {
        return f58166b;
    }

    public static a c() {
        return f58165a;
    }

    public static boolean b(boolean z2, Context context) {
        return a(uj.f64236l, Boolean.valueOf(z2), context);
    }

    public static a a() {
        return f58167c;
    }

    public static boolean a(boolean z2, Context context) {
        return a(uj.f64238n, Boolean.valueOf(z2), context);
    }

    public static String a(Context context) {
        return a(f58166b, context) + a(f58167c, context);
    }

    private static String a(a aVar, Context context) {
        return "\n" + aVar.f58168a + " - " + aVar.a(context);
    }
}

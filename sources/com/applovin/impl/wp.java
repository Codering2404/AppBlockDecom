package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f64727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f64728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f64729c = a(uj.f64233i, (String) vj.a(uj.f64232h, (Object) null, com.applovin.impl.sdk.j.m()));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f64730d;

    public wp(com.applovin.impl.sdk.j jVar) {
        this.f64727a = jVar;
        this.f64730d = a(uj.f64234j, (String) jVar.a(sj.f63741g));
        a(d());
    }

    private String d() {
        if (!((Boolean) this.f64727a.a(sj.J3)).booleanValue()) {
            this.f64727a.c(uj.f64231g);
        }
        String str = (String) this.f64727a.a(uj.f64231g);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        this.f64727a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64727a.I().a("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    public String a() {
        return this.f64730d;
    }

    public String b() {
        return this.f64729c;
    }

    public String c() {
        return this.f64728b;
    }

    public static String a(com.applovin.impl.sdk.j jVar) {
        uj ujVar = uj.f64235k;
        String str = (String) jVar.a(ujVar);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        jVar.b(ujVar, strValueOf);
        return strValueOf;
    }

    private String a(uj ujVar, String str) {
        String str2 = (String) vj.a(ujVar, (Object) null, com.applovin.impl.sdk.j.m());
        if (StringUtils.isValidString(str2)) {
            return str2;
        }
        if (!StringUtils.isValidString(str)) {
            str = UUID.randomUUID().toString().toLowerCase(Locale.US);
        }
        vj.b(ujVar, str, com.applovin.impl.sdk.j.m());
        return str;
    }

    public void a(String str) {
        if (((Boolean) this.f64727a.a(sj.J3)).booleanValue()) {
            this.f64727a.b(uj.f64231g, str);
        }
        this.f64728b = str;
        this.f64727a.q().b(str, a());
    }
}

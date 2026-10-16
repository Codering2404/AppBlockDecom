package com.applovin.impl;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f62933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f62934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f62935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f62936d;

    public s(String str, String str2) {
        this(str, str2, null, false);
    }

    public String a() {
        return this.f62934b;
    }

    public Map b() {
        return this.f62935c;
    }

    public String c() {
        return this.f62933a;
    }

    public boolean d() {
        return this.f62936d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f62933a + "', backupUrl='" + this.f62934b + "', headers='" + this.f62935c + "', shouldFireInWebView='" + this.f62936d + "'}";
    }

    public s(String str, String str2, Map map, boolean z2) {
        this.f62933a = str;
        this.f62934b = str2;
        this.f62935c = map;
        this.f62936d = z2;
    }
}

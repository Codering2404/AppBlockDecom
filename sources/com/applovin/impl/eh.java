package com.applovin.impl;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f59494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f59495b;

    private eh(String str, Map map) {
        this.f59494a = str;
        this.f59495b = map;
    }

    public static eh a(String str) {
        return a(str, null);
    }

    public String b() {
        return this.f59494a;
    }

    public String toString() {
        return "PendingReward{result='" + this.f59494a + "'params='" + this.f59495b + "'}";
    }

    public Map a() {
        return this.f59495b;
    }

    public static eh a(String str, Map map) {
        return new eh(str, map);
    }
}

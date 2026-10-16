package com.applovin.impl;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f64522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f64523b;

    public w0(Map map, List list) {
        this.f64522a = map;
        this.f64523b = list;
    }

    protected boolean a(Object obj) {
        return obj instanceof w0;
    }

    public List b() {
        return this.f64523b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        if (!w0Var.a(this)) {
            return false;
        }
        Map mapA = a();
        Map mapA2 = w0Var.a();
        if (mapA != null ? !mapA.equals(mapA2) : mapA2 != null) {
            return false;
        }
        List listB = b();
        List listB2 = w0Var.b();
        return listB != null ? listB.equals(listB2) : listB2 == null;
    }

    public int hashCode() {
        Map mapA = a();
        int iHashCode = mapA == null ? 43 : mapA.hashCode();
        List listB = b();
        return ((iHashCode + 59) * 59) + (listB != null ? listB.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxt(domainEntries=" + a() + ", invalidEntries=" + b() + ")";
    }

    public Map a() {
        return this.f64522a;
    }
}

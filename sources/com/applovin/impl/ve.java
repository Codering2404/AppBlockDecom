package com.applovin.impl;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ve {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f64420b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ve f64421c = a("ar");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ve f64422d = a("ttdasi_ms");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f64423a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        Object a(Object obj);
    }

    private ve(String str) {
        this.f64423a = str;
    }

    protected boolean a(Object obj) {
        return obj instanceof ve;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ve)) {
            return false;
        }
        ve veVar = (ve) obj;
        if (!veVar.a(this)) {
            return false;
        }
        String strA = a();
        String strA2 = veVar.a();
        return strA != null ? strA.equals(strA2) : strA2 == null;
    }

    public int hashCode() {
        String strA = a();
        return (strA == null ? 43 : strA.hashCode()) + 59;
    }

    public String toString() {
        return this.f64423a;
    }

    public String a() {
        return this.f64423a;
    }

    private static ve a(String str) {
        Set set = f64420b;
        if (!set.contains(str)) {
            set.add(str);
            return new ve(str);
        }
        throw new IllegalArgumentException("Key has already been used: " + str);
    }
}

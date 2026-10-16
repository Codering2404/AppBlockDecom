package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ProductAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f70885a = new HashMap();

    public ProductAction(String str) {
        k("&pa", str);
    }

    public ProductAction a(String str) {
        k("&col", str);
        return this;
    }

    public ProductAction b(int i3) {
        k("&cos", Integer.toString(i3));
        return this;
    }

    public ProductAction c(String str) {
        k("&pal", str);
        return this;
    }

    public ProductAction d(String str) {
        k("&ta", str);
        return this;
    }

    public ProductAction e(String str) {
        k("&tcc", str);
        return this;
    }

    public ProductAction f(String str) {
        k("&ti", str);
        return this;
    }

    public ProductAction g(double d3) {
        k("&tr", Double.toString(d3));
        return this;
    }

    public ProductAction h(double d3) {
        k("&ts", Double.toString(d3));
        return this;
    }

    public ProductAction i(double d3) {
        k("&tt", Double.toString(d3));
        return this;
    }

    public final Map j() {
        return new HashMap(this.f70885a);
    }

    final void k(String str, String str2) {
        Preconditions.n(str, "Name should be non-null");
        this.f70885a.put(str, str2);
    }

    public String toString() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f70885a.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                map.put(((String) entry.getKey()).substring(1), (String) entry.getValue());
            } else {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return zzj.zzb(map);
    }
}

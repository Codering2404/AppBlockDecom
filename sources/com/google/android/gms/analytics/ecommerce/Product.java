package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzd;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Product {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f70884a = new HashMap();

    public Product a(String str) {
        m("br", str);
        return this;
    }

    public Product b(String str) {
        m("ca", str);
        return this;
    }

    public Product c(String str) {
        m("cc", str);
        return this;
    }

    public Product d(int i3, String str) {
        m(zzd.b(i3), str);
        return this;
    }

    public Product e(int i3, int i4) {
        m(zzd.d(i3), Integer.toString(i4));
        return this;
    }

    public Product f(String str) {
        m("id", str);
        return this;
    }

    public Product g(String str) {
        m("nm", str);
        return this;
    }

    public Product h(int i3) {
        m("ps", Integer.toString(i3));
        return this;
    }

    public Product i(double d3) {
        m("pr", Double.toString(d3));
        return this;
    }

    public Product j(int i3) {
        m("qt", Integer.toString(i3));
        return this;
    }

    public Product k(String str) {
        m("va", str);
        return this;
    }

    public final Map l(String str) {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f70884a.entrySet()) {
            String strValueOf = String.valueOf((String) entry.getKey());
            map.put(str.concat(strValueOf), (String) entry.getValue());
        }
        return map;
    }

    final void m(String str, String str2) {
        Preconditions.n(str, "Name should be non-null");
        this.f70884a.put(str, str2);
    }

    public String toString() {
        return zzj.zzb(this.f70884a);
    }
}

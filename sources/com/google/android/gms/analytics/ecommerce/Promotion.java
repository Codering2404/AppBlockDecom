package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Promotion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f70886a = new HashMap();

    public Promotion a(String str) {
        f("cr", str);
        return this;
    }

    public Promotion b(String str) {
        f("id", str);
        return this;
    }

    public Promotion c(String str) {
        f("nm", str);
        return this;
    }

    public Promotion d(String str) {
        f("ps", str);
        return this;
    }

    public final Map e(String str) {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f70886a.entrySet()) {
            String strValueOf = String.valueOf((String) entry.getKey());
            map.put(str.concat(strValueOf), (String) entry.getValue());
        }
        return map;
    }

    final void f(String str, String str2) {
        Preconditions.n(str, "Name should be non-null");
        this.f70886a.put(str, str2);
    }

    public String toString() {
        return zzj.zzb(this.f70886a);
    }
}

package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbvz f77058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f77059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f77060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbze f77061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f77062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f77063f;

    zzbwb(zzbvz zzbvzVar, Map map, Map map2, zzbze zzbzeVar, Object obj, Map map3) {
        this.f77058a = zzbvzVar;
        this.f77059b = Collections.unmodifiableMap(new HashMap(map));
        this.f77060c = Collections.unmodifiableMap(new HashMap(map2));
        this.f77061d = zzbzeVar;
        this.f77062e = obj;
        this.f77063f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    final Map a() {
        return this.f77063f;
    }

    final zzbkq b() {
        if (this.f77060c.isEmpty() && this.f77059b.isEmpty() && this.f77058a == null) {
            return null;
        }
        return new zzbwa(this, null);
    }

    final Object c() {
        return this.f77062e;
    }

    final zzbze d() {
        return this.f77061d;
    }

    final zzbvz e(zzbml zzbmlVar) {
        zzbvz zzbvzVar = (zzbvz) this.f77059b.get(zzbmlVar.b());
        if (zzbvzVar == null) {
            zzbvzVar = (zzbvz) this.f77060c.get(zzbmlVar.c());
        }
        return zzbvzVar == null ? this.f77058a : zzbvzVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbwb.class == obj.getClass()) {
            zzbwb zzbwbVar = (zzbwb) obj;
            if (Objects.a(this.f77058a, zzbwbVar.f77058a) && Objects.a(this.f77059b, zzbwbVar.f77059b) && Objects.a(this.f77060c, zzbwbVar.f77060c) && Objects.a(this.f77061d, zzbwbVar.f77061d) && Objects.a(this.f77062e, zzbwbVar.f77062e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f77058a, this.f77059b, this.f77060c, this.f77061d, this.f77062e);
    }

    public final String toString() {
        return MoreObjects.c(this).d("defaultMethodConfig", this.f77058a).d("serviceMethodMap", this.f77059b).d("serviceMap", this.f77060c).d("retryThrottling", this.f77061d).d("loadBalancingConfig", this.f77062e).toString();
    }
}

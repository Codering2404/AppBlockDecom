package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbmw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnr f76448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbio f76449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbms f76450c;

    zzbmw(zzbnr zzbnrVar, zzbio zzbioVar, zzbms zzbmsVar) {
        this.f76448a = zzbnrVar;
        this.f76449b = (zzbio) Preconditions.u(zzbioVar, "attributes");
        this.f76450c = zzbmsVar;
    }

    public static zzbmv a() {
        return new zzbmv();
    }

    public final zzbnr b() {
        return this.f76448a;
    }

    public final zzbio c() {
        return this.f76449b;
    }

    public final zzbms d() {
        return this.f76450c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbmw)) {
            return false;
        }
        zzbmw zzbmwVar = (zzbmw) obj;
        return Objects.a(this.f76448a, zzbmwVar.f76448a) && Objects.a(this.f76449b, zzbmwVar.f76449b) && Objects.a(this.f76450c, zzbmwVar.f76450c);
    }

    public final int hashCode() {
        return Objects.b(this.f76448a, this.f76449b, this.f76450c);
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperC = MoreObjects.c(this);
        toStringHelperC.d("addressesOrError", this.f76448a.toString());
        toStringHelperC.d("attributes", this.f76449b);
        toStringHelperC.d("serviceConfigOrError", this.f76450c);
        return toStringHelperC.toString();
    }
}

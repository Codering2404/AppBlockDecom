package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzblr f77301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f77302b;

    public zzbzs(zzblr zzblrVar, Object obj) {
        this.f77301a = (zzblr) Preconditions.u(zzblrVar, "provider");
        this.f77302b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbzs.class == obj.getClass()) {
            zzbzs zzbzsVar = (zzbzs) obj;
            if (Objects.a(this.f77301a, zzbzsVar.f77301a) && Objects.a(this.f77302b, zzbzsVar.f77302b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f77301a, this.f77302b);
    }

    public final String toString() {
        return MoreObjects.c(this).d("provider", this.f77301a).d("config", this.f77302b).toString();
    }
}

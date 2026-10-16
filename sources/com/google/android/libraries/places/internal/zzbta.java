package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f76838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f76839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Set f76840c;

    zzbta(int i3, long j3, Set set) {
        this.f76838a = i3;
        this.f76839b = j3;
        this.f76840c = ImmutableSet.u(set);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbta.class == obj.getClass()) {
            zzbta zzbtaVar = (zzbta) obj;
            if (this.f76838a == zzbtaVar.f76838a && this.f76839b == zzbtaVar.f76839b && Objects.a(this.f76840c, zzbtaVar.f76840c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(Integer.valueOf(this.f76838a), Long.valueOf(this.f76839b), this.f76840c);
    }

    public final String toString() {
        return MoreObjects.c(this).b("maxAttempts", this.f76838a).c("hedgingDelayNanos", this.f76839b).d("nonFatalStatusCodes", this.f76840c).toString();
    }
}

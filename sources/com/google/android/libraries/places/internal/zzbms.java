package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbms {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnp f76443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f76444b;

    private zzbms(zzbnp zzbnpVar) {
        this.f76444b = null;
        this.f76443a = (zzbnp) Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        Preconditions.m(!zzbnpVar.j(), "cannot use OK status: %s", zzbnpVar);
    }

    public static zzbms a(Object obj) {
        return new zzbms(obj);
    }

    public static zzbms b(zzbnp zzbnpVar) {
        return new zzbms(zzbnpVar);
    }

    public final Object c() {
        return this.f76444b;
    }

    public final zzbnp d() {
        return this.f76443a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbms.class == obj.getClass()) {
            zzbms zzbmsVar = (zzbms) obj;
            if (Objects.a(this.f76443a, zzbmsVar.f76443a) && Objects.a(this.f76444b, zzbmsVar.f76444b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f76443a, this.f76444b);
    }

    public final String toString() {
        Object obj = this.f76444b;
        return obj != null ? MoreObjects.c(this).d("config", obj).toString() : MoreObjects.c(this).d("error", this.f76443a).toString();
    }

    private zzbms(Object obj) {
        this.f76444b = Preconditions.u(obj, "config");
        this.f76443a = null;
    }
}

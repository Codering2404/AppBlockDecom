package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbnr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnp f76504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f76505b;

    private zzbnr(zzbnp zzbnpVar, Object obj) {
        this.f76504a = zzbnpVar;
        this.f76505b = obj;
    }

    public static zzbnr a(Object obj) {
        return new zzbnr(null, obj);
    }

    public static zzbnr b(zzbnp zzbnpVar) {
        zzbnr zzbnrVar = new zzbnr((zzbnp) Preconditions.u(zzbnpVar, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS), null);
        Preconditions.m(!zzbnpVar.j(), "cannot use OK status: %s", zzbnpVar);
        return zzbnrVar;
    }

    public final boolean c() {
        return this.f76504a == null;
    }

    public final Object d() {
        if (this.f76504a == null) {
            return this.f76505b;
        }
        throw new IllegalStateException("No value present.");
    }

    public final zzbnp e() {
        zzbnp zzbnpVar = this.f76504a;
        return zzbnpVar == null ? zzbnp.f76488e : zzbnpVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbnr)) {
            return false;
        }
        zzbnr zzbnrVar = (zzbnr) obj;
        if (c() == zzbnrVar.c()) {
            return c() ? Objects.a(this.f76505b, zzbnrVar.f76505b) : Objects.a(this.f76504a, zzbnrVar.f76504a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f76504a, this.f76505b);
    }

    public final String toString() {
        zzbnp zzbnpVar = this.f76504a;
        MoreObjects.ToStringHelper toStringHelperC = MoreObjects.c(this);
        if (zzbnpVar == null) {
            toStringHelperC.d("value", this.f76505b);
        } else {
            toStringHelperC.d("error", zzbnpVar);
        }
        return toStringHelperC.toString();
    }
}

package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbjn f76291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbnp f76292b;

    private zzbjo(zzbjn zzbjnVar, zzbnp zzbnpVar) {
        this.f76291a = (zzbjn) Preconditions.u(zzbjnVar, "state is null");
        this.f76292b = (zzbnp) Preconditions.u(zzbnpVar, "status is null");
    }

    public static zzbjo a(zzbjn zzbjnVar) {
        Preconditions.e(zzbjnVar != zzbjn.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new zzbjo(zzbjnVar, zzbnp.f76488e);
    }

    public static zzbjo b(zzbnp zzbnpVar) {
        Preconditions.e(!zzbnpVar.j(), "The error status must not be OK");
        return new zzbjo(zzbjn.TRANSIENT_FAILURE, zzbnpVar);
    }

    public final zzbjn c() {
        return this.f76291a;
    }

    public final zzbnp d() {
        return this.f76292b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbjo)) {
            return false;
        }
        zzbjo zzbjoVar = (zzbjo) obj;
        return this.f76291a.equals(zzbjoVar.f76291a) && this.f76292b.equals(zzbjoVar.f76292b);
    }

    public final int hashCode() {
        zzbnp zzbnpVar = this.f76292b;
        return zzbnpVar.hashCode() ^ this.f76291a.hashCode();
    }

    public final String toString() {
        zzbnp zzbnpVar = this.f76292b;
        if (zzbnpVar.j()) {
            return this.f76291a.toString();
        }
        String strValueOf = String.valueOf(this.f76291a);
        String strValueOf2 = String.valueOf(zzbnpVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length() + 1);
        sb.append(strValueOf);
        sb.append("(");
        sb.append(strValueOf2);
        sb.append(")");
        return sb.toString();
    }
}

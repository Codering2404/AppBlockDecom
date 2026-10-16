package com.google.android.libraries.places.internal;

import com.facebook.GraphRequest;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbxk extends zzblj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbis f77154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbmg f77155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbml f77156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzblh f77157d;

    public zzbxk(zzbml zzbmlVar, zzbmg zzbmgVar, zzbis zzbisVar, zzblh zzblhVar) {
        this.f77156c = (zzbml) Preconditions.u(zzbmlVar, GraphRequest.BATCH_METHOD_PARAM);
        this.f77155b = (zzbmg) Preconditions.u(zzbmgVar, "headers");
        this.f77154a = (zzbis) Preconditions.u(zzbisVar, "callOptions");
        this.f77157d = (zzblh) Preconditions.u(zzblhVar, "pickDetailsConsumer");
    }

    @Override // com.google.android.libraries.places.internal.zzblj
    public final zzbis a() {
        return this.f77154a;
    }

    @Override // com.google.android.libraries.places.internal.zzblj
    public final zzbmg b() {
        return this.f77155b;
    }

    @Override // com.google.android.libraries.places.internal.zzblj
    public final zzbml c() {
        return this.f77156c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbxk.class == obj.getClass()) {
            zzbxk zzbxkVar = (zzbxk) obj;
            if (Objects.a(this.f77154a, zzbxkVar.f77154a) && Objects.a(this.f77155b, zzbxkVar.f77155b) && Objects.a(this.f77156c, zzbxkVar.f77156c) && Objects.a(this.f77157d, zzbxkVar.f77157d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f77154a, this.f77155b, this.f77156c, this.f77157d);
    }

    public final String toString() {
        zzbis zzbisVar = this.f77154a;
        zzbmg zzbmgVar = this.f77155b;
        String strValueOf = String.valueOf(this.f77156c);
        String strValueOf2 = String.valueOf(zzbmgVar);
        String strValueOf3 = String.valueOf(zzbisVar);
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 17 + strValueOf2.length() + 13 + strValueOf3.length() + 1);
        sb.append("[method=");
        sb.append(strValueOf);
        sb.append(" headers=");
        sb.append(strValueOf2);
        sb.append(" callOptions=");
        sb.append(strValueOf3);
        sb.append("]");
        return sb.toString();
    }
}

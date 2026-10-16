package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcep extends zzcel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzceq f77725b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcep(zzceq zzceqVar) {
        super(zzceqVar);
        Objects.requireNonNull(zzceqVar);
        this.f77725b = zzceqVar;
    }

    @Override // com.google.android.libraries.places.internal.zzcel, com.google.android.libraries.places.internal.zzcek, com.google.android.libraries.places.internal.zzblg
    public final void b(zzbjn zzbjnVar, zzbln zzblnVar) {
        super.b(zzbjnVar, zzblnVar);
        zzceq zzceqVar = this.f77725b;
        if (zzceqVar.f77726f.f77722h || zzbjnVar != zzbjn.IDLE) {
            return;
        }
        zzceqVar.d().d();
    }
}

package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzcel extends zzcek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcem f77710a;

    protected zzcel(zzcem zzcemVar) {
        Objects.requireNonNull(zzcemVar);
        this.f77710a = zzcemVar;
    }

    @Override // com.google.android.libraries.places.internal.zzcek, com.google.android.libraries.places.internal.zzblg
    public void b(zzbjn zzbjnVar, zzbln zzblnVar) {
        zzcem zzcemVar = this.f77710a;
        if (zzcemVar.h() == zzbjn.SHUTDOWN) {
            return;
        }
        zzcemVar.i(zzbjnVar);
        zzcemVar.j(zzblnVar);
        zzceo zzceoVar = zzcemVar.f77715e;
        if (zzceoVar.f77722h) {
            return;
        }
        zzceoVar.e();
    }

    @Override // com.google.android.libraries.places.internal.zzcek
    protected final zzblg f() {
        return this.f77710a.f77715e.k();
    }
}

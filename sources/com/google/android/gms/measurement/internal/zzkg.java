package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkg extends zzay {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzlj f74072e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkg(zzlj zzljVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzljVar);
        this.f74072e = zzljVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zzlj zzljVar = this.f74072e;
        if (zzljVar.f73997a.n()) {
            zzljVar.c0().b(2000L);
        }
    }
}

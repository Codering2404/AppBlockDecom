package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgdq implements zzind {
    final /* synthetic */ zzgdr zza;

    zzgdq(zzgdr zzgdrVar) {
        Objects.requireNonNull(zzgdrVar);
        this.zza = zzgdrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgdr zzgdrVar = this.zza;
        return new zzgdu(zzgdrVar.zzb(), zzgdrVar.zzc(), null);
    }
}

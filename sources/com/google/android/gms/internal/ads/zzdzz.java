package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdzz implements zzimu {
    private final zzind zza;

    private zzdzz(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdzz zza(zzind zzindVar) {
        return new zzdzz(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdzy((Clock) this.zza.zzb());
    }
}

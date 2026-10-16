package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcdq {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    zzcdq(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcdz zzcdzVar) {
        this.zza = zzgVar;
    }

    public final void zza(int i3, long j3) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbe)).booleanValue()) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zza;
        if (j3 - zzgVar.zzF() < 0) {
            com.google.android.gms.ads.internal.util.zze.k("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbf)).booleanValue()) {
            zzgVar.h(i3);
            zzgVar.f(j3);
        } else {
            zzgVar.h(-1);
            zzgVar.f(j3);
        }
    }
}

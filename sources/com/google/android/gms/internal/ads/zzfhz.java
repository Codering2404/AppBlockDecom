package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfhz implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzfhz(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzfhz zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfhz(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfhw zzb() {
        Context context = (Context) this.zza.zzb();
        zzfmj zzfmjVar = (zzfmj) this.zzb.zzb();
        zzfnb zzfnbVar = (zzfnb) this.zzc.zzb();
        zzcey zzceyVarZzi = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhm)).booleanValue() ? com.google.android.gms.ads.internal.zzt.l().zzo().zzi() : com.google.android.gms.ads.internal.zzt.l().zzo().zzj();
        boolean z2 = false;
        if (zzceyVarZzi != null && zzceyVarZzi.zzi()) {
            z2 = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzho)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhl)).booleanValue() || z2) {
                zzfna zzfnaVarZza = zzfnbVar.zza(zzfmr.Rewarded, context, zzfmjVar, new zzfgz(new zzfgy()));
                zzfhn zzfhnVar = new zzfhn(new zzfhm());
                zzfmn zzfmnVar = zzfnaVarZza.zza;
                zzhcg zzhcgVar = zzcfr.zza;
                return new zzfhd(zzfhnVar, new zzfhj(zzfmnVar, zzhcgVar), zzfnaVarZza.zzb, zzfmnVar.zze().zzf, zzhcgVar);
            }
        }
        return new zzfhm();
    }
}

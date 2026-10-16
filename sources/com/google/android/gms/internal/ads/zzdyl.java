package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbhv;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdyl implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzdyl(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar4;
    }

    public static zzdyl zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzdyl(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton;
        final String strZza = ((zzfeu) this.zza).zza();
        Context contextZza = ((zzcns) this.zzb).zza();
        zzhcg zzhcgVarZzc = zzfoa.zzc();
        Map mapZzb = ((zzimy) this.zzc).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzge)).booleanValue()) {
            zzbhp zzbhpVar = new zzbhp(new zzbhu(contextZza));
            zzbhpVar.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzdym
                @Override // com.google.android.gms.internal.ads.zzbho
                public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar) {
                    zzaVar.zzh(strZza);
                }
            });
            setSingleton = Collections.singleton(new zzdkq(new zzdyo(zzbhpVar, mapZzb), zzhcgVarZzc));
        } else {
            setSingleton = Collections.EMPTY_SET;
        }
        zzinc.zzb(setSingleton);
        return setSingleton;
    }
}

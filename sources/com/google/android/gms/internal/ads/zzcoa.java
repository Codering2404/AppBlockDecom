package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcoa implements zzimu {
    private final zzind zza;

    private zzcoa(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzcoa zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcoa(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzco)).booleanValue() ? Collections.singleton(new zzdkq((zzeby) this.zza.zzb(), zzfoa.zzc())) : Collections.EMPTY_SET;
        zzinc.zzb(setSingleton);
        return setSingleton;
    }
}

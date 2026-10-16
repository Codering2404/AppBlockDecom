package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzctn implements zzdcu {
    private final zzfki zza;
    private final zzfkq zzb;
    private final zzfry zzc;
    private final zzfsc zzd;

    public zzctn(zzfkq zzfkqVar, zzfsc zzfscVar, zzfry zzfryVar) {
        this.zzb = zzfkqVar;
        this.zzd = zzfscVar;
        this.zzc = zzfryVar;
        this.zza = zzfkqVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        List list = this.zza.zza;
        this.zzd.zza(this.zzc.zza(this.zzb, null, list), null);
    }
}

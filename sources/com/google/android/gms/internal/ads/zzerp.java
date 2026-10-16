package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzerp {
    private final zzdng zza;

    public zzerp(zzdng zzdngVar) {
        this.zza = zzdngVar;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfkq zzfkqVar, zzfkf zzfkfVar, View view, zzerl zzerlVar) {
        zzern zzernVar = new zzern(this, new zzerm(this, zzfkfVar));
        zzdma zzdmaVarZzd = this.zza.zzd(new zzcyj(zzfkqVar, zzfkfVar, null), zzernVar);
        zzerlVar.zzd(new zzero(this, zzdmaVarZzd));
        return zzdmaVarZzd.zzh();
    }
}

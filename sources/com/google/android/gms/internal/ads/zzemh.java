package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzemh implements zzely {
    private final Context zza;
    private final zzcuz zzb;
    private final Executor zzc;

    zzemh(Context context, zzcuz zzcuzVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcuzVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        zzflw zzflwVar = (zzflw) zzelvVar.zzb;
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        String string = zzfkfVar.zzv.toString();
        zzflwVar.zzy(this.zza, zzfkyVar.zzd, string, (zzbvi) zzelvVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf, zzeph {
        zzcuw zzcuwVarZzf = this.zzb.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdmd(new zzemg(this, zzelvVar, zzfkfVar), null), new zzcux(zzfkfVar.zzaa));
        zzcuwVarZzf.zza().zzq(new zzcsz((zzflw) zzelvVar.zzb), this.zzc);
        ((zzenh) zzelvVar.zzc).zzc(zzcuwVarZzf.zzf());
        return zzcuwVarZzf.zzh();
    }
}

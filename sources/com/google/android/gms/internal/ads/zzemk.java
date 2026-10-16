package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzemk implements zzely {
    private final Context zza;
    private final zzcuz zzb;

    zzemk(Context context, zzcuz zzcuzVar) {
        this.zza = context;
        this.zzb = zzcuzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        try {
            zzbxb zzbxbVar = (zzbxb) zzelvVar.zzb;
            zzbxbVar.zzo(zzfkfVar.zzZ);
            zzbxbVar.zzs(zzfkfVar.zzU, zzfkfVar.zzv.toString(), zzfkqVar.zza.zza.zzd, ObjectWrapper.i5(this.zza), new zzemj(zzelvVar, null), (zzbvi) zzelvVar.zzc);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Remote exception loading an app open RTB ad", e3);
            throw new zzflf(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf, zzeph {
        zzenq zzenqVar = new zzenq(zzfkfVar, (zzbxb) zzelvVar.zzb, AdFormat.APP_OPEN_AD);
        zzcuw zzcuwVarZzf = this.zzb.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdmd(zzenqVar, null), new zzcux(zzfkfVar.zzaa));
        zzenqVar.zzc(zzcuwVarZzf.zzd());
        ((zzenh) zzelvVar.zzc).zzc(zzcuwVarZzf.zzg());
        return zzcuwVarZzf.zzh();
    }
}

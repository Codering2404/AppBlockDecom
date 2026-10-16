package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzept implements zzely {
    private final Context zza;
    private final zzdvr zzb;

    public zzept(Context context, zzdvr zzdvrVar) {
        this.zza = context;
        this.zzb = zzdvrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        try {
            zzbxb zzbxbVar = (zzbxb) zzelvVar.zzb;
            zzbxbVar.zzo(zzfkfVar.zzZ);
            zzfky zzfkyVar = zzfkqVar.zza.zza;
            if (zzfkyVar.zzp.zza == 3) {
                zzbxbVar.zzp(zzfkfVar.zzU, zzfkfVar.zzv.toString(), zzfkyVar.zzd, ObjectWrapper.i5(this.zza), new zzeps(this, zzelvVar, null), (zzbvi) zzelvVar.zzc);
            } else {
                zzbxbVar.zzl(zzfkfVar.zzU, zzfkfVar.zzv.toString(), zzfkyVar.zzd, ObjectWrapper.i5(this.zza), new zzeps(this, zzelvVar, null), (zzbvi) zzelvVar.zzc);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Remote exception loading a rewarded RTB ad", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf, zzeph {
        zzenq zzenqVar = new zzenq(zzfkfVar, (zzbxb) zzelvVar.zzb, AdFormat.REWARDED);
        zzdvn zzdvnVarZzf = this.zzb.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdvo(zzenqVar));
        zzenqVar.zzc(zzdvnVarZzf.zzd());
        ((zzenh) zzelvVar.zzc).zzc(zzdvnVarZzf.zzn());
        return zzdvnVarZzf.zzh();
    }
}

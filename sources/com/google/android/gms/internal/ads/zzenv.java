package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzenv implements zzely {
    private final Context zza;
    private final zzdng zzb;

    public zzenv(Context context, zzdng zzdngVar) {
        this.zza = context;
        this.zzb = zzdngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        try {
            zzbxb zzbxbVar = (zzbxb) zzelvVar.zzb;
            zzbxbVar.zzo(zzfkfVar.zzZ);
            zzbxbVar.zzj(zzfkfVar.zzU, zzfkfVar.zzv.toString(), zzfkqVar.zza.zza.zzd, ObjectWrapper.i5(this.zza), new zzenu(this, zzelvVar, null), (zzbvi) zzelvVar.zzc);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Remote exception loading a interstitial RTB ad", e3);
            throw new zzflf(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf, zzeph {
        zzenq zzenqVar = new zzenq(zzfkfVar, (zzbxb) zzelvVar.zzb, AdFormat.INTERSTITIAL);
        zzdma zzdmaVarZzd = this.zzb.zzd(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdmd(zzenqVar, null));
        zzenqVar.zzc(zzdmaVarZzd.zzd());
        ((zzenh) zzelvVar.zzc).zzc(zzdmaVarZzd.zzg());
        return zzdmaVarZzd.zzh();
    }
}

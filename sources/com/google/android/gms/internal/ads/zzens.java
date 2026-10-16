package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzens implements zzely {
    private final Context zza;
    private final zzdng zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzens(Context context, VersionInfoParcel versionInfoParcel, zzdng zzdngVar, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdngVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        zzflw zzflwVar = (zzflw) zzelvVar.zzb;
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        String string = zzfkfVar.zzv.toString();
        String strM = com.google.android.gms.ads.internal.util.zzbp.m(zzfkfVar.zzs);
        zzflwVar.zzh(this.zza, zzfkyVar.zzd, string, strM, (zzbvi) zzelvVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf, zzeph {
        zzdma zzdmaVarZzd = this.zzb.zzd(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdmd(new zzenr(this, zzelvVar, zzfkfVar), null));
        zzdmaVarZzd.zza().zzq(new zzcsz((zzflw) zzelvVar.zzb), this.zzd);
        ((zzenh) zzelvVar.zzc).zzc(zzdmaVarZzd.zzf());
        return zzdmaVarZzd.zzh();
    }

    final /* synthetic */ VersionInfoParcel zzc() {
        return this.zzc;
    }
}

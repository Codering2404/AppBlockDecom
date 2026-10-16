package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeog implements zzely {
    private final Context zza;
    private final zzdoc zzb;
    private final Executor zzc;

    public zzeog(Context context, zzdoc zzdocVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdocVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfkq zzfkqVar, int i3) {
        return zzfkqVar.zza.zza.zzh.contains(Integer.toString(i3));
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        zzflw zzflwVar = (zzflw) zzelvVar.zzb;
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        String string = zzfkfVar.zzv.toString();
        String strM = com.google.android.gms.ads.internal.util.zzbp.m(zzfkfVar.zzs);
        zzflwVar.zzo(this.zza, zzfkyVar.zzd, string, strM, (zzbvi) zzelvVar.zzc, zzfkyVar.zzj, zzfkyVar.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf, zzeph {
        zzdpt zzdptVarZzag;
        zzflw zzflwVar = (zzflw) zzelvVar.zzb;
        zzbvn zzbvnVarZzD = zzflwVar.zzD();
        zzbvo zzbvoVarZzE = zzflwVar.zzE();
        zzbvr zzbvrVarZzu = zzflwVar.zzu();
        if (zzbvrVarZzu != null && zzc(zzfkqVar, 6)) {
            zzdptVarZzag = zzdpt.zzaf(zzbvrVarZzu);
        } else if (zzbvnVarZzD != null && zzc(zzfkqVar, 6)) {
            zzdptVarZzag = zzdpt.zzai(zzbvnVarZzD);
        } else if (zzbvnVarZzD != null && zzc(zzfkqVar, 2)) {
            zzdptVarZzag = zzdpt.zzah(zzbvnVarZzD);
        } else if (zzbvoVarZzE != null && zzc(zzfkqVar, 6)) {
            zzdptVarZzag = zzdpt.zzaj(zzbvoVarZzE);
        } else {
            if (zzbvoVarZzE == null || !zzc(zzfkqVar, 1)) {
                throw new zzeph(1, "No native ad mappers");
            }
            zzdptVarZzag = zzdpt.zzag(zzbvoVarZzE);
        }
        if (zzdptVarZzag != null) {
            zzfky zzfkyVar = zzfkqVar.zza.zza;
            if (zzfkyVar.zzh.contains(Integer.toString(zzdptVarZzag.zzx()))) {
                zzdpv zzdpvVarZze = this.zzb.zze(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdqe(zzdptVarZzag), new zzdrx(zzbvoVarZzE, zzbvnVarZzD, zzbvrVarZzu));
                ((zzenh) zzelvVar.zzc).zzc(zzdpvVarZze.zzf());
                zzdpvVarZze.zza().zzq(new zzcsz(zzflwVar), this.zzc);
                return zzdpvVarZze.zzh();
            }
        }
        throw new zzeph(1, "No corresponding native ad listener");
    }
}

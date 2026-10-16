package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxt extends zzxd {
    final zzzg zza;
    final Object zzb;
    final zzzg zzc;
    final zzxs zzd;

    zzxt(zzzg zzzgVar, Object obj, zzzg zzzgVar2, zzxs zzxsVar, Class cls) {
        if (zzzgVar == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (zzxsVar.zzc == zzaba.zzk && zzzgVar2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.zza = zzzgVar;
        this.zzb = obj;
        this.zzc = zzzgVar2;
        this.zzd = zzxsVar;
    }

    final Object zza(Object obj) {
        if (this.zzd.zzc.zza() != zzabb.ENUM) {
            return obj;
        }
        zzxs zzxsVar = this.zzd;
        return zzxsVar.zza.zza(((Integer) obj).intValue());
    }
}

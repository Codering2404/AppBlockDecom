package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpt implements zzps {
    public static final zzkm zza;
    public static final zzkm zzb;

    static {
        zzkg zzkgVarZzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkgVarZzb.zzd("measurement.collection.event_safelist", true);
        zza = zzkgVarZzb.zzd("measurement.service.store_null_safelist", true);
        zzb = zzkgVarZzb.zzd("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zzc() {
        return ((Boolean) zzb.zzd()).booleanValue();
    }
}

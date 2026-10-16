package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqu implements zzqt {
    public static final zzkm zza;

    static {
        zzkg zzkgVarZzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzkgVarZzb.zzd("measurement.add_first_launch_logging_timestamp.service", false);
        zzkgVarZzb.zzc("measurement.id.add_first_launch_logging_timestamp.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzqt
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}

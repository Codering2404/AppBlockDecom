package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpk implements zzpj {
    public static final zzkm zza;
    public static final zzkm zzb;

    static {
        zzkg zzkgVarZzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkgVarZzb.zzd("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        zzkgVarZzb.zzd("measurement.set_default_event_parameters_with_backfill.service", true);
        zzkgVarZzb.zzc("measurement.id.set_default_event_parameters.fix_service_request_ordering", 0L);
        zza = zzkgVarZzb.zzd("measurement.set_default_event_parameters.fix_app_update_logging", true);
        zzb = zzkgVarZzb.zzd("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        zzkgVarZzb.zzd("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpj
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpj
    public final boolean zzb() {
        return ((Boolean) zzb.zzd()).booleanValue();
    }
}

package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhv implements zzhu {
    public static final zzdc zza;
    public static final zzdc zzb;
    public static final zzdc zzc;
    public static final zzdc zzd;
    public static final zzdc zze;

    static {
        zzcz zzczVarZza = new zzcz(zzcr.zza("com.google.android.gms.auth_account")).zzb().zza();
        zza = zzczVarZza.zze("Aang__create_auth_exception_with_pending_intent", false);
        zzb = zzczVarZza.zze("Aang__enable_add_account_restrictions", false);
        zzc = zzczVarZza.zze("Aang__log_missing_gaia_id_event", true);
        zzd = zzczVarZza.zze("Aang__log_obfuscated_gaiaid_status", true);
        zze = zzczVarZza.zze("Aang__switch_clear_token_to_aang", false);
    }

    @Override // com.google.android.gms.internal.auth.zzhu
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}

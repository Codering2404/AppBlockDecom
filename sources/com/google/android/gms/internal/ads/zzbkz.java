package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbkz {
    public static final zzbka zza = zzbka.zzb("gads:dynamite_load:fail:sample_rate", 10000);
    public static final zzbka zzb = zzbka.zza("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbka zzc = new zzbka("gads:public_beta:traffic_multiplier", "1.0", 4);
    public static final zzbka zzd = new zzbka("gads:sdk_crash_report_class_prefix", "com.google.", 4);
    public static final zzbka zze;
    public static final zzbka zzf;

    static {
        zzbka.zza("gads:sdk_crash_report_enabled", false);
        zze = zzbka.zza("gads:sdk_crash_report_full_stacktrace", false);
        zzf = zzbka.zzc("gads:trapped_exception_sample_rate", 0.01d);
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzblf {
    public static final zzbka zza = zzbka.zza("gads:trustless_token_for_decagon:enabled", true);
    public static final zzbka zzb;

    static {
        zzbka.zza("gads:invalidate_token_at_refresh_start", true);
        zzbka.zza("gms:expose_token_for_gma:enabled", true);
        zzbka.zza("gads:referesh_rate_limit", false);
        zzb = zzbka.zzb("gads:timeout_for_trustless_token:millis", 2000L);
        zzbka.zza("gads:token_anonymization:enabled", true);
        zzbka.zzb("gads:cached_token:ttl_millis", 10800000L);
    }
}

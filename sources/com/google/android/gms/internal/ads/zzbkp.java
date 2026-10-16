package com.google.android.gms.internal.ads;

import coil.target.Yb.oUcQRqOVfOC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbkp {
    public static final zzbka zza = new zzbka("gads:gma_attestation:click:macro_string", "@click_attok@", 4);
    public static final zzbka zzb = new zzbka(oUcQRqOVfOC.RnvEfekSXAWS, "attok", 4);
    public static final zzbka zzc = zzbka.zzb("gads:gma_attestation:click:timeout", 2000);
    public static final zzbka zzd = zzbka.zza("gads:gma_attestation:click:enable", false);
    public static final zzbka zze = zzbka.zzb("gads:gma_attestation:click:enable_dynamite_version", Long.MAX_VALUE);
    public static final zzbka zzf = zzbka.zza("gads:gma_attestation:click:qualification:enable", true);
    public static final zzbka zzg = zzbka.zza("gads:gma_attestation:image_hash", false);
    public static final zzbka zzh = zzbka.zza("gads:gma_attestation:impression:enable", false);
    public static final zzbka zzi;

    static {
        zzbka.zza("gads:gma_attestation:request:enable_javascript", false);
        zzbka.zza("gads:gma_attestation:request:enable", true);
        zzi = zzbka.zza("gads:gma_attestation:click:report_error", true);
    }
}

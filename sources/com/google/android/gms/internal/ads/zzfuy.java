package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfuy {
    private final String zza;
    private final String zzb;

    private zzfuy(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfuy zza(String str, String str2) {
        zzfwi.zzc(str, "Name is null or empty");
        zzfwi.zzc(str2, "Version is null or empty");
        return new zzfuy(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}

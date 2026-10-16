package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhur {
    public static final zzhur zza = new zzhur("SHA256");
    public static final zzhur zzb = new zzhur("SHA384");
    public static final zzhur zzc = new zzhur("SHA512");
    private final String zzd;

    private zzhur(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}

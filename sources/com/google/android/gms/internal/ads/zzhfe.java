package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfe {
    public static final zzhfe zza = new zzhfe("SHA1");
    public static final zzhfe zzb = new zzhfe("SHA224");
    public static final zzhfe zzc = new zzhfe("SHA256");
    public static final zzhfe zzd = new zzhfe("SHA384");
    public static final zzhfe zze = new zzhfe("SHA512");
    private final String zzf;

    private zzhfe(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}

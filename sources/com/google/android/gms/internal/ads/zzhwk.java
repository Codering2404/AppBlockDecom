package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhwk {
    public static final zzhwk zza = new zzhwk("SHA256");
    public static final zzhwk zzb = new zzhwk("SHA384");
    public static final zzhwk zzc = new zzhwk("SHA512");
    private final String zzd;

    private zzhwk(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}

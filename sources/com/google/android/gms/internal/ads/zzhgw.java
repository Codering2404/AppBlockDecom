package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhgw extends zzheu {
    private final String zza;
    private final zzhgv zzb;

    private zzhgw(String str, zzhgv zzhgvVar) {
        this.zza = str;
        this.zzb = zzhgvVar;
    }

    public static zzhgw zzb(String str, zzhgv zzhgvVar) {
        return new zzhgw(str, zzhgvVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhgw)) {
            return false;
        }
        zzhgw zzhgwVar = (zzhgw) obj;
        return zzhgwVar.zza.equals(this.zza) && zzhgwVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(zzhgw.class, this.zza, this.zzb);
    }

    public final String toString() {
        String string = this.zzb.toString();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + string.length() + 1);
        sb.append("LegacyKmsAead Parameters (keyUri: ");
        sb.append(str);
        sb.append(", variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzb != zzhgv.zzb;
    }

    public final String zzc() {
        return this.zza;
    }

    public final zzhgv zzd() {
        return this.zzb;
    }
}

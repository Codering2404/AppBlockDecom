package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfo extends zzheu {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzhfn zzd;

    /* synthetic */ zzhfo(int i3, int i4, int i5, zzhfn zzhfnVar, byte[] bArr) {
        this.zza = i3;
        this.zzb = i4;
        this.zzd = zzhfnVar;
    }

    public static zzhfm zzb() {
        return new zzhfm(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhfo)) {
            return false;
        }
        zzhfo zzhfoVar = (zzhfo) obj;
        return zzhfoVar.zza == this.zza && zzhfoVar.zzb == this.zzb && zzhfoVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhfo.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = strValueOf.length();
        int i3 = this.zzb;
        int length2 = String.valueOf(i3).length();
        int length3 = String.valueOf(16).length();
        int i4 = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 10 + length3 + 15 + String.valueOf(i4).length() + 10);
        sb.append("AesEax Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i3);
        sb.append("-byte IV, ");
        sb.append(16);
        sb.append("-byte tag, and ");
        sb.append(i4);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhfn.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final zzhfn zze() {
        return this.zzd;
    }
}

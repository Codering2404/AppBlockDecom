package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfg extends zzheu {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzhff zze;
    private final zzhfe zzf;

    /* synthetic */ zzhfg(int i3, int i4, int i5, int i6, zzhff zzhffVar, zzhfe zzhfeVar, byte[] bArr) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = zzhffVar;
        this.zzf = zzhfeVar;
    }

    public static zzhfd zzb() {
        return new zzhfd(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhfg)) {
            return false;
        }
        zzhfg zzhfgVar = (zzhfg) obj;
        return zzhfgVar.zza == this.zza && zzhfgVar.zzb == this.zzb && zzhfgVar.zzc == this.zzc && zzhfgVar.zzd == this.zzd && zzhfgVar.zze == this.zze && zzhfgVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzhfg.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        zzhfe zzhfeVar = this.zzf;
        String strValueOf = String.valueOf(this.zze);
        String strValueOf2 = String.valueOf(zzhfeVar);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int i3 = this.zzc;
        int length3 = String.valueOf(i3).length();
        int i4 = this.zzd;
        int length4 = String.valueOf(i4).length();
        int i5 = this.zza;
        int length5 = String.valueOf(i5).length();
        int i6 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 2 + length3 + 14 + length4 + 16 + length5 + 19 + String.valueOf(i6).length() + 15);
        sb.append("AesCtrHmacAead Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(i3);
        sb.append("-byte IV, and ");
        sb.append(i4);
        sb.append("-byte tags, and ");
        sb.append(i5);
        sb.append("-byte AES key, and ");
        sb.append(i6);
        sb.append("-byte HMAC key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zze != zzhff.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzc;
    }

    public final zzhff zzg() {
        return this.zze;
    }

    public final zzhfe zzh() {
        return this.zzf;
    }
}

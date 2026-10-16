package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhoi extends zzhoy {
    private final int zza;
    private final int zzb;
    private final zzhoh zzc;

    /* synthetic */ zzhoi(int i3, int i4, zzhoh zzhohVar, byte[] bArr) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = zzhohVar;
    }

    public static zzhog zzb() {
        return new zzhog(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhoi)) {
            return false;
        }
        zzhoi zzhoiVar = (zzhoi) obj;
        return zzhoiVar.zza == this.zza && zzhoiVar.zze() == zze() && zzhoiVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzhoi.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        int length = strValueOf.length();
        int i3 = this.zzb;
        int length2 = String.valueOf(i3).length();
        int i4 = this.zza;
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 16 + String.valueOf(i4).length() + 10);
        sb.append("AES-CMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i3);
        sb.append("-byte tags, and ");
        sb.append(i4);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzc != zzhoh.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzhoh zzhohVar = this.zzc;
        if (zzhohVar == zzhoh.zzd) {
            return this.zzb;
        }
        if (zzhohVar == zzhoh.zza || zzhohVar == zzhoh.zzb || zzhohVar == zzhoh.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzhoh zzf() {
        return this.zzc;
    }
}

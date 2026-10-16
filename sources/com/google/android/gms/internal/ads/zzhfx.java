package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfx extends zzheu {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzhfw zzd;

    /* synthetic */ zzhfx(int i3, int i4, int i5, zzhfw zzhfwVar, byte[] bArr) {
        this.zza = i3;
        this.zzd = zzhfwVar;
    }

    public static zzhfv zzb() {
        return new zzhfv(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhfx)) {
            return false;
        }
        zzhfx zzhfxVar = (zzhfx) obj;
        return zzhfxVar.zza == this.zza && zzhfxVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhfx.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = strValueOf.length();
        int length2 = String.valueOf(12).length();
        int length3 = String.valueOf(16).length();
        int i3 = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 10 + length3 + 15 + String.valueOf(i3).length() + 10);
        sb.append("AesGcm Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(12);
        sb.append("-byte IV, ");
        sb.append(16);
        sb.append("-byte tag, and ");
        sb.append(i3);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhfw.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzhfw zzd() {
        return this.zzd;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhgg extends zzheu {
    private final int zza;
    private final zzhgf zzb;

    /* synthetic */ zzhgg(int i3, zzhgf zzhgfVar, byte[] bArr) {
        this.zza = i3;
        this.zzb = zzhgfVar;
    }

    public static zzhge zzb() {
        return new zzhge(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhgg)) {
            return false;
        }
        zzhgg zzhggVar = (zzhgg) obj;
        return zzhggVar.zza == this.zza && zzhggVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzhgg.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        int length = strValueOf.length();
        int i3 = this.zza;
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(i3).length() + 10);
        sb.append("AesGcmSiv Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i3);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzb != zzhgf.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzhgf zzd() {
        return this.zzb;
    }
}

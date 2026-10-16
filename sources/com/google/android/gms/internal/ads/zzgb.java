package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgb implements zzao {
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzgb(long j3, long j4, long j5) {
        this.zza = j3;
        this.zzb = j4;
        this.zzc = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgb)) {
            return false;
        }
        zzgb zzgbVar = (zzgb) obj;
        return this.zza == zzgbVar.zza && this.zzb == zzgbVar.zzb && this.zzc == zzgbVar.zzc;
    }

    public final int hashCode() {
        return ((((Long.hashCode(this.zza) + 527) * 31) + Long.hashCode(this.zzb)) * 31) + Long.hashCode(this.zzc);
    }

    public final String toString() {
        long j3 = this.zza;
        int length = String.valueOf(j3).length();
        long j4 = this.zzb;
        int length2 = String.valueOf(j4).length();
        long j5 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 12 + String.valueOf(j5).length());
        sb.append("Mp4Timestamp: creation time=");
        sb.append(j3);
        sb.append(", modification time=");
        sb.append(j4);
        sb.append(", timescale=");
        sb.append(j5);
        return sb.toString();
    }
}

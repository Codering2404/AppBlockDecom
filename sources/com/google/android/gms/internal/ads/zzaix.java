package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaix implements zzao {
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzaix(long j3, long j4, long j5, long j6, long j7) {
        this.zza = j3;
        this.zzb = j4;
        this.zzc = j5;
        this.zzd = j6;
        this.zze = j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaix.class == obj.getClass()) {
            zzaix zzaixVar = (zzaix) obj;
            if (this.zza == zzaixVar.zza && this.zzb == zzaixVar.zzb && this.zzc == zzaixVar.zzc && this.zzd == zzaixVar.zzd && this.zze == zzaixVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((Long.hashCode(this.zza) + 527) * 31) + Long.hashCode(this.zzb)) * 31) + Long.hashCode(this.zzc)) * 31) + Long.hashCode(this.zzd)) * 31) + Long.hashCode(this.zze);
    }

    public final String toString() {
        long j3 = this.zza;
        int length = String.valueOf(j3).length();
        long j4 = this.zzb;
        int length2 = String.valueOf(j4).length();
        long j5 = this.zzc;
        int length3 = String.valueOf(j5).length();
        long j6 = this.zzd;
        int length4 = String.valueOf(j6).length();
        long j7 = this.zze;
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 31 + length3 + 21 + length4 + 12 + String.valueOf(j7).length());
        sb.append("Motion photo metadata: photoStartPosition=");
        sb.append(j3);
        sb.append(", photoSize=");
        sb.append(j4);
        sb.append(", photoPresentationTimestampUs=");
        sb.append(j5);
        sb.append(", videoStartPosition=");
        sb.append(j6);
        sb.append(", videoSize=");
        sb.append(j7);
        return sb.toString();
    }
}

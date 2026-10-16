package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaiz implements zzao {
    public final long zza;

    public zzaiz(long j3) {
        this.zza = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzaiz.class == obj.getClass() && this.zza == ((zzaiz) obj).zza;
    }

    public final int hashCode() {
        return Long.hashCode(this.zza) + 527;
    }

    public final String toString() {
        long j3 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 38);
        sb.append("ThumbnailMetadata: presentationTimeUs=");
        sb.append(j3);
        return sb.toString();
    }
}

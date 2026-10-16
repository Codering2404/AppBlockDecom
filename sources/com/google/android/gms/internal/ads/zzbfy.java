package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbfy {
    final long zza;
    final String zzb;
    final int zzc;

    zzbfy(long j3, String str, int i3) {
        this.zza = j3;
        this.zzb = str;
        this.zzc = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbfy)) {
            return false;
        }
        zzbfy zzbfyVar = (zzbfy) obj;
        return zzbfyVar.zza == this.zza && zzbfyVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}

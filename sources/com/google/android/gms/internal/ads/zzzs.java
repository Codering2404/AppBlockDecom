package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzs {
    public final long zza;
    public final long zzb;

    public zzzs(long j3, long j4) {
        this.zza = j3;
        this.zzb = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzs)) {
            return false;
        }
        zzzs zzzsVar = (zzzs) obj;
        return this.zza == zzzsVar.zza && this.zzb == zzzsVar.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}

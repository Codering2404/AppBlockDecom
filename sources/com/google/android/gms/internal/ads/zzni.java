package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzni {
    public static final zzni zza;
    public static final zzni zzb;
    public static final zzni zzc;
    public final long zzd;
    public final long zze;

    static {
        zzni zzniVar = new zzni(0L, 0L);
        zza = zzniVar;
        new zzni(Long.MAX_VALUE, Long.MAX_VALUE);
        zzb = new zzni(Long.MAX_VALUE, 0L);
        new zzni(0L, Long.MAX_VALUE);
        zzc = zzniVar;
    }

    public zzni(long j3, long j4) {
        zzgtj.zza(j3 >= 0);
        zzgtj.zza(j4 >= 0);
        this.zzd = j3;
        this.zze = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzni.class == obj.getClass()) {
            zzni zzniVar = (zzni) obj;
            if (this.zzd == zzniVar.zzd && this.zze == zzniVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzd) * 31) + ((int) this.zze);
    }
}

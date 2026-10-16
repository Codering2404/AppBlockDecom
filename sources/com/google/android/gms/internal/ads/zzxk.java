package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxk {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    private zzxk(Object obj, int i3, int i4, long j3, int i5) {
        this.zza = obj;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = j3;
        this.zze = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxk)) {
            return false;
        }
        zzxk zzxkVar = (zzxk) obj;
        return this.zza.equals(zzxkVar.zza) && this.zzb == zzxkVar.zzb && this.zzc == zzxkVar.zzc && this.zzd == zzxkVar.zzd && this.zze == zzxkVar.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzxk zza(Object obj) {
        return this.zza.equals(obj) ? this : new zzxk(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzxk(Object obj, int i3, int i4, long j3) {
        this(obj, i3, i4, j3, -1);
    }

    public zzxk(Object obj, long j3) {
        this(obj, -1, -1, j3, -1);
    }

    public zzxk(Object obj, long j3, int i3) {
        this(obj, -1, -1, j3, i3);
    }
}

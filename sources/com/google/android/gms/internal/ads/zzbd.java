package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbd {
    public Object zza;
    public Object zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public boolean zzf;
    public zzc zzg = zzc.zza;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbd.class.equals(obj.getClass())) {
            zzbd zzbdVar = (zzbd) obj;
            if (Objects.equals(this.zza, zzbdVar.zza) && Objects.equals(this.zzb, zzbdVar.zzb) && this.zzc == zzbdVar.zzc && this.zzd == zzbdVar.zzd && this.zzf == zzbdVar.zzf && Objects.equals(this.zzg, zzbdVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.zza;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzb;
        int iHashCode2 = ((((iHashCode + 217) * 31) + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.zzc;
        long j3 = this.zzd;
        return (((((iHashCode2 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 961) + (this.zzf ? 1 : 0)) * 31) + this.zzg.hashCode();
    }

    public final zzbd zza(Object obj, Object obj2, int i3, long j3, long j4, zzc zzcVar, boolean z2) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = i3;
        this.zzd = j3;
        this.zze = 0L;
        this.zzg = zzcVar;
        this.zzf = z2;
        return this;
    }

    public final int zzb() {
        int i3 = this.zzg.zzb;
        return 0;
    }

    public final long zzc(int i3) {
        long j3 = this.zzg.zza(i3).zza;
        return 0L;
    }

    public final int zzd(int i3) {
        return this.zzg.zza(i3).zza(-1);
    }

    public final int zze(long j3) {
        this.zzg.zzb(-1);
        return -1;
    }

    public final int zzf(long j3) {
        return -1;
    }

    public final int zzg(int i3) {
        return this.zzg.zza(i3).zzb;
    }

    public final long zzh(int i3, int i4) {
        zza zzaVarZza = this.zzg.zza(i3);
        if (zzaVarZza.zzb != -1) {
            return zzaVarZza.zzf[i4];
        }
        return -9223372036854775807L;
    }

    public final boolean zzi(int i3) {
        zzb();
        if (i3 != -1) {
            return false;
        }
        this.zzg.zzb(-1);
        return false;
    }

    public final long zzj() {
        long j3 = this.zzg.zzc;
        return 0L;
    }

    public final boolean zzk(int i3) {
        boolean z2 = this.zzg.zza(i3).zzj;
        return false;
    }
}

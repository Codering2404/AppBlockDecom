package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmd {
    public final zzxk zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final boolean zzk;

    zzmd(zzxk zzxkVar, long j3, long j4, long j5, long j6, long j7, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7 = true;
        zzgtj.zza(!z6 || z4);
        if (z5 && !z4) {
            z7 = false;
        }
        zzgtj.zza(z7);
        this.zza = zzxkVar;
        this.zzb = j3;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = j6;
        this.zzf = j7;
        this.zzg = false;
        this.zzh = false;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = z6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmd.class == obj.getClass()) {
            zzmd zzmdVar = (zzmd) obj;
            if (this.zzb == zzmdVar.zzb && this.zzd == zzmdVar.zzd && this.zze == zzmdVar.zze && this.zzf == zzmdVar.zzf && this.zzi == zzmdVar.zzi && this.zzj == zzmdVar.zzj && this.zzk == zzmdVar.zzk && Objects.equals(this.zza, zzmdVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        long j3 = this.zzf;
        long j4 = this.zze;
        return (((((((((((((iHashCode * 31) + ((int) this.zzb)) * 31) + ((int) this.zzd)) * 31) + ((int) j4)) * 31) + ((int) j3)) * 29791) + (this.zzi ? 1 : 0)) * 31) + (this.zzj ? 1 : 0)) * 31) + (this.zzk ? 1 : 0);
    }

    public final zzmd zza(long j3, long j4) {
        return (j3 == this.zzb && j4 == this.zzc) ? this : new zzmd(this.zza, j3, j4, this.zzd, this.zze, this.zzf, false, false, this.zzi, this.zzj, this.zzk);
    }

    public final zzmd zzb(long j3) {
        return j3 == this.zzd ? this : new zzmd(this.zza, this.zzb, this.zzc, j3, this.zze, this.zzf, false, false, this.zzi, this.zzj, this.zzk);
    }
}

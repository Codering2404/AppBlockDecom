package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzafk {
    protected final zzafe zza;
    protected final zzafj zzb;
    protected zzafg zzc;
    private final int zzd;

    protected zzafk(zzafh zzafhVar, zzafj zzafjVar, long j3, long j4, long j5, long j6, long j7, long j8, int i3) {
        this.zzb = zzafjVar;
        this.zzd = i3;
        this.zza = new zzafe(zzafhVar, j3, 0L, j5, j6, j7, j8);
    }

    protected static final int zzf(zzafz zzafzVar, long j3, zzagy zzagyVar) {
        if (j3 == zzafzVar.zzn()) {
            return 0;
        }
        zzagyVar.zza = j3;
        return 1;
    }

    protected static final boolean zzg(zzafz zzafzVar, long j3) throws IOException {
        long jZzn = j3 - zzafzVar.zzn();
        if (jZzn < 0 || jZzn > 262144) {
            return false;
        }
        zzafzVar.zzf((int) jZzn);
        return true;
    }

    public final zzahb zza() {
        return this.zza;
    }

    public final void zzb(long j3) {
        zzafg zzafgVar = this.zzc;
        if (zzafgVar == null || zzafgVar.zze() != j3) {
            zzafe zzafeVar = this.zza;
            this.zzc = new zzafg(j3, zzafeVar.zzd(j3), 0L, zzafeVar.zze(), zzafeVar.zzf(), zzafeVar.zzg(), zzafeVar.zzh());
        }
    }

    public final boolean zzc() {
        return this.zzc != null;
    }

    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        while (true) {
            zzafg zzafgVar = this.zzc;
            zzafgVar.getClass();
            long jZzb = zzafgVar.zzb();
            long jZzc = zzafgVar.zzc();
            long jZzh = zzafgVar.zzh();
            if (jZzc - jZzb <= this.zzd) {
                zze(false, jZzb);
                return zzf(zzafzVar, jZzb, zzagyVar);
            }
            if (!zzg(zzafzVar, jZzh)) {
                return zzf(zzafzVar, jZzh, zzagyVar);
            }
            zzafzVar.zzl();
            zzafi zzafiVarZza = this.zzb.zza(zzafzVar, zzafgVar.zzd());
            int iZzd = zzafiVarZza.zzd();
            if (iZzd == -3) {
                zze(false, jZzh);
                return zzf(zzafzVar, jZzh, zzagyVar);
            }
            if (iZzd == -2) {
                zzafgVar.zzf(zzafiVarZza.zze(), zzafiVarZza.zzf());
            } else {
                if (iZzd != -1) {
                    zzg(zzafzVar, zzafiVarZza.zzf());
                    zze(true, zzafiVarZza.zzf());
                    return zzf(zzafzVar, zzafiVarZza.zzf(), zzagyVar);
                }
                zzafgVar.zzg(zzafiVarZza.zze(), zzafiVarZza.zzf());
            }
        }
    }

    protected final void zze(boolean z2, long j3) {
        this.zzc = null;
        this.zzb.zzb();
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzamz {
    private zzahk zzb;
    private zzagb zzc;
    private zzamv zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzamt zza = new zzamt();
    private zzamx zzj = new zzamx();

    protected void zza(boolean z2) {
        int i3;
        if (z2) {
            this.zzj = new zzamx();
            this.zzf = 0L;
            i3 = 0;
        } else {
            i3 = 1;
        }
        this.zzh = i3;
        this.zze = -1L;
        this.zzg = 0L;
    }

    protected abstract long zzb(zzet zzetVar);

    @EnsuresNonNullIf
    protected abstract boolean zzc(zzet zzetVar, long j3, zzamx zzamxVar) throws IOException;

    final void zze(zzagb zzagbVar, zzahk zzahkVar) {
        this.zzc = zzagbVar;
        this.zzb = zzahkVar;
        zza(true);
    }

    final void zzf(long j3, long j4) {
        this.zza.zza();
        if (j3 == 0) {
            zza(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            long jZzi = zzi(j4);
            this.zze = jZzi;
            zzamv zzamvVar = this.zzd;
            String str = zzfl.zza;
            zzamvVar.zzb(jZzi);
            this.zzh = 2;
        }
    }

    final int zzg(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        this.zzb.getClass();
        String str = zzfl.zza;
        int i3 = this.zzh;
        if (i3 != 0) {
            if (i3 == 1) {
                zzafzVar.zzf((int) this.zzf);
                this.zzh = 2;
                return 0;
            }
            if (i3 != 2) {
                return -1;
            }
            long jZza = this.zzd.zza(zzafzVar);
            if (jZza >= 0) {
                zzagyVar.zza = jZza;
                return 1;
            }
            if (jZza < -1) {
                zzj(-(jZza + 2));
            }
            if (!this.zzl) {
                zzahb zzahbVarZzc = this.zzd.zzc();
                zzahbVarZzc.getClass();
                this.zzc.zzw(zzahbVarZzc);
                this.zzb.zzO(zzahbVarZzc.zza());
                this.zzl = true;
            }
            if (this.zzk <= 0 && !this.zza.zzb(zzafzVar)) {
                this.zzh = 3;
                return -1;
            }
            this.zzk = 0L;
            zzet zzetVarZzd = this.zza.zzd();
            long jZzb = zzb(zzetVarZzd);
            if (jZzb >= 0) {
                long j3 = this.zzg;
                if (j3 + jZzb >= this.zze) {
                    long jZzh = zzh(j3);
                    this.zzb.zzc(zzetVarZzd, zzetVarZzd.zze());
                    this.zzb.zze(jZzh, 1, zzetVarZzd.zze(), 0, null);
                    this.zze = -1L;
                }
            }
            this.zzg += jZzb;
            return 0;
        }
        while (true) {
            zzamt zzamtVar = this.zza;
            if (!zzamtVar.zzb(zzafzVar)) {
                this.zzh = 3;
                return -1;
            }
            long jZzn = zzafzVar.zzn();
            long j4 = this.zzf;
            this.zzk = jZzn - j4;
            if (!zzc(zzamtVar.zzd(), j4, this.zzj)) {
                zzv zzvVar = this.zzj.zza;
                this.zzi = zzvVar.zzI;
                if (!this.zzm) {
                    this.zzb.zzA(zzvVar);
                    this.zzm = true;
                }
                zzamv zzamvVar = this.zzj.zzb;
                if (zzamvVar != null) {
                    this.zzd = zzamvVar;
                } else if (zzafzVar.zzo() == -1) {
                    this.zzd = new zzamy(null);
                } else {
                    zzamu zzamuVarZzc = zzamtVar.zzc();
                    this.zzd = new zzamo(this, this.zzf, zzafzVar.zzo(), zzamuVarZzc.zzd + zzamuVarZzc.zze, zzamuVarZzc.zzb, (zzamuVarZzc.zza & 4) != 0);
                }
                this.zzh = 2;
                zzamtVar.zze();
                return 0;
            }
            this.zzf = zzafzVar.zzn();
        }
    }

    protected final long zzh(long j3) {
        return (j3 * 1000000) / ((long) this.zzi);
    }

    protected final long zzi(long j3) {
        return (((long) this.zzi) * j3) / 1000000;
    }

    protected void zzj(long j3) {
        this.zzg = j3;
    }
}

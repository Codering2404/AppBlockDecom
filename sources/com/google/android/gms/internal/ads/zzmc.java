package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmc {
    public final zzxi zza;
    public final Object zzb;
    public final zzzc[] zzc;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public zzmd zzg;
    public boolean zzh;
    private final boolean[] zzi;
    private final zznc[] zzj;
    private final zzabh zzk;
    private final zzmr zzl;
    private zzmc zzm;
    private zzzn zzn;
    private zzabi zzo;
    private long zzp;

    public zzmc(zznc[] zzncVarArr, long j3, zzabh zzabhVar, zzabl zzablVar, zzmr zzmrVar, zzmd zzmdVar, zzabi zzabiVar, long j4) {
        this.zzj = zzncVarArr;
        this.zzp = j3;
        this.zzk = zzabhVar;
        this.zzl = zzmrVar;
        zzxk zzxkVar = zzmdVar.zza;
        this.zzb = zzxkVar.zza;
        this.zzg = zzmdVar;
        this.zzn = zzzn.zza;
        this.zzo = zzabiVar;
        this.zzc = new zzzc[2];
        this.zzi = new boolean[2];
        long j5 = zzmdVar.zzb;
        long j6 = zzmdVar.zze;
        zzxi zzxiVarZze = zzmrVar.zze(zzxkVar, zzablVar, j5);
        this.zza = j6 != -9223372036854775807L ? new zzwo(zzxiVarZze, true, 0L, j6) : zzxiVarZze;
    }

    private final void zzu() {
        if (!zzw()) {
            return;
        }
        int i3 = 0;
        while (true) {
            zzabi zzabiVar = this.zzo;
            if (i3 >= zzabiVar.zza) {
                return;
            }
            zzabiVar.zza(i3);
            zzaba zzabaVar = this.zzo.zzc[i3];
            i3++;
        }
    }

    private final void zzv() {
        if (!zzw()) {
            return;
        }
        int i3 = 0;
        while (true) {
            zzabi zzabiVar = this.zzo;
            if (i3 >= zzabiVar.zza) {
                return;
            }
            zzabiVar.zza(i3);
            zzaba zzabaVar = this.zzo.zzc[i3];
            i3++;
        }
    }

    private final boolean zzw() {
        return this.zzm == null;
    }

    public final long zza() {
        return this.zzp;
    }

    public final void zzb(long j3) {
        this.zzp = j3;
    }

    public final long zzc() {
        return this.zzg.zzb + this.zzp;
    }

    public final boolean zzd() {
        if (this.zze) {
            return !this.zzf || this.zza.zzi() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zze() {
        if (this.zze) {
            return zzd() || zzf() - this.zzg.zzb >= -9223372036854775807L;
        }
        return false;
    }

    public final long zzf() {
        if (!this.zze) {
            return this.zzg.zzb;
        }
        long jZzi = this.zzf ? this.zza.zzi() : Long.MIN_VALUE;
        return jZzi == Long.MIN_VALUE ? this.zzg.zzf : jZzi;
    }

    public final long zzg() {
        if (this.zze) {
            return this.zza.zzl();
        }
        return 0L;
    }

    public final void zzh(float f3, zzbf zzbfVar, boolean z2) throws zzjk {
        this.zze = true;
        this.zzn = this.zza.zzd();
        zzabi zzabiVarZzk = zzk(f3, zzbfVar, z2);
        zzmd zzmdVar = this.zzg;
        long jMax = zzmdVar.zzb;
        long j3 = zzmdVar.zzf;
        if (j3 != -9223372036854775807L && jMax >= j3) {
            jMax = Math.max(0L, j3 - 1);
        }
        long jZzl = zzl(zzabiVarZzk, jMax, false);
        long j4 = this.zzp;
        zzmd zzmdVar2 = this.zzg;
        this.zzp = j4 + (zzmdVar2.zzb - jZzl);
        this.zzg = zzmdVar2.zza(jZzl, zzmdVar2.zzc);
    }

    public final void zzi(long j3) {
        zzgtj.zzi(zzw());
        if (this.zze) {
            this.zza.zzg(j3 - this.zzp);
        }
    }

    public final void zzj(zzma zzmaVar) {
        zzgtj.zzi(zzw());
        this.zza.zzm(zzmaVar);
    }

    public final zzabi zzk(float f3, zzbf zzbfVar, boolean z2) throws zzjk {
        zzzn zzznVar = this.zzn;
        zzxk zzxkVar = this.zzg.zza;
        zzabh zzabhVar = this.zzk;
        zznc[] zzncVarArr = this.zzj;
        zzabi zzabiVarZzr = zzabhVar.zzr(zzncVarArr, zzznVar, zzxkVar, zzbfVar);
        for (int i3 = 0; i3 < zzabiVarZzr.zza; i3++) {
            if (zzabiVarZzr.zza(i3)) {
                if (zzabiVarZzr.zzc[i3] == null) {
                    zzncVarArr[i3].zza();
                    z = false;
                }
                zzgtj.zzi(z);
            } else {
                zzgtj.zzi(zzabiVarZzr.zzc[i3] == null);
            }
        }
        for (zzaba zzabaVar : zzabiVarZzr.zzc) {
        }
        return zzabiVarZzr;
    }

    public final long zzl(zzabi zzabiVar, long j3, boolean z2) {
        return zzm(zzabiVar, j3, false, new boolean[2]);
    }

    public final long zzm(zzabi zzabiVar, long j3, boolean z2, boolean[] zArr) {
        zznc[] zzncVarArr;
        int i3 = 0;
        while (true) {
            boolean z3 = true;
            if (i3 >= zzabiVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzi;
            if (z2 || !zzabiVar.zzb(this.zzo, i3)) {
                z3 = false;
            }
            zArr2[i3] = z3;
            i3++;
        }
        int i4 = 0;
        while (true) {
            zzncVarArr = this.zzj;
            if (i4 >= 2) {
                break;
            }
            zzncVarArr[i4].zza();
            i4++;
        }
        zzv();
        this.zzo = zzabiVar;
        zzu();
        zzxi zzxiVar = this.zza;
        zzaba[] zzabaVarArr = zzabiVar.zzc;
        boolean[] zArr3 = this.zzi;
        zzzc[] zzzcVarArr = this.zzc;
        long jZze = zzxiVar.zze(zzabaVarArr, zArr3, zzzcVarArr, zArr, j3);
        for (int i5 = 0; i5 < 2; i5++) {
            zzncVarArr[i5].zza();
        }
        this.zzf = false;
        for (int i6 = 0; i6 < 2; i6++) {
            if (zzzcVarArr[i6] != null) {
                zzgtj.zzi(zzabiVar.zza(i6));
                zzncVarArr[i6].zza();
                this.zzf = true;
            } else {
                zzgtj.zzi(zzabaVarArr[i6] == null);
            }
        }
        return jZze;
    }

    public final void zzn() {
        zzv();
        zzxi zzxiVar = this.zza;
        try {
            boolean z2 = zzxiVar instanceof zzwo;
            zzmr zzmrVar = this.zzl;
            if (z2) {
                zzmrVar.zzf(((zzwo) zzxiVar).zza);
            } else {
                zzmrVar.zzf(zzxiVar);
            }
        } catch (RuntimeException e3) {
            zzeg.zzf("MediaPeriodHolder", "Period release failed.", e3);
        }
    }

    public final void zzo(zzmc zzmcVar) {
        if (zzmcVar == this.zzm) {
            return;
        }
        zzv();
        this.zzm = zzmcVar;
        zzu();
    }

    public final zzmc zzp() {
        return this.zzm;
    }

    public final zzzn zzq() {
        return this.zzn;
    }

    public final zzabi zzr() {
        return this.zzo;
    }

    public final void zzs() {
        zzxi zzxiVar = this.zza;
        if (zzxiVar instanceof zzwo) {
            long j3 = this.zzg.zze;
            if (j3 == -9223372036854775807L) {
                j3 = Long.MIN_VALUE;
            }
            ((zzwo) zzxiVar).zza(0L, j3);
        }
    }

    public final void zzt(zzxh zzxhVar, long j3) {
        this.zzd = true;
        this.zza.zzb(zzxhVar, j3);
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwo implements zzxi, zzxh {
    public final zzxi zza;
    long zzb;
    private zzxh zzc;
    private zzwn[] zzd = new zzwn[0];
    private long zze = 0;
    private long zzf = -9223372036854775807L;

    public zzwo(zzxi zzxiVar, boolean z2, long j3, long j4) {
        this.zza = zzxiVar;
        this.zzb = j4;
    }

    private static long zzt(long j3, long j4, long j5) {
        long jMax = Math.max(j3, j4);
        return j5 != Long.MIN_VALUE ? Math.min(jMax, j5) : jMax;
    }

    public final void zza(long j3, long j4) {
        this.zzb = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j3) {
        this.zzc = zzxhVar;
        this.zza.zzb(this, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final zzzn zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zze(zzaba[] zzabaVarArr, boolean[] zArr, zzzc[] zzzcVarArr, boolean[] zArr2, long j3) {
        int length = zzzcVarArr.length;
        this.zzd = new zzwn[length];
        zzzc[] zzzcVarArr2 = new zzzc[length];
        int i3 = 0;
        while (true) {
            zzzc zzzcVar = null;
            if (i3 >= zzzcVarArr.length) {
                break;
            }
            zzwn[] zzwnVarArr = this.zzd;
            zzwn zzwnVar = (zzwn) zzzcVarArr[i3];
            zzwnVarArr[i3] = zzwnVar;
            if (zzwnVar != null) {
                zzzcVar = zzwnVar.zza;
            }
            zzzcVarArr2[i3] = zzzcVar;
            i3++;
        }
        long jZze = this.zza.zze(zzabaVarArr, zArr, zzzcVarArr2, zArr2, j3);
        long jZzt = zzt(jZze, j3, this.zzb);
        long j4 = -9223372036854775807L;
        if (zzo()) {
            if (jZze < j3) {
                j4 = jZzt;
                break;
            }
            if (jZze != 0) {
                for (zzaba zzabaVar : zzabaVarArr) {
                    if (zzabaVar != null) {
                        zzv zzvVarZzc = zzabaVar.zzc();
                        if (!zzas.zzd(zzvVarZzc.zzp, zzvVarZzc.zzk)) {
                            j4 = jZzt;
                            break;
                        }
                    }
                }
            }
        }
        this.zze = j4;
        for (int i4 = 0; i4 < zzzcVarArr.length; i4++) {
            zzzc zzzcVar2 = zzzcVarArr2[i4];
            if (zzzcVar2 == null) {
                this.zzd[i4] = null;
            } else {
                zzwn[] zzwnVarArr2 = this.zzd;
                zzwn zzwnVar2 = zzwnVarArr2[i4];
                if (zzwnVar2 == null || zzwnVar2.zza != zzzcVar2) {
                    zzwnVarArr2[i4] = new zzwn(this, zzzcVar2);
                }
            }
            zzzcVarArr[i4] = this.zzd[i4];
        }
        return jZzt;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j3, boolean z2) {
        this.zza.zzf(j3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j3) {
        this.zza.zzg(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        if (zzo()) {
            long j3 = this.zze;
            this.zze = -9223372036854775807L;
            this.zzf = j3;
            long jZzh = zzh();
            return jZzh != -9223372036854775807L ? jZzh : j3;
        }
        long jZzh2 = this.zza.zzh();
        if (jZzh2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jZzt = zzt(jZzh2, 0L, this.zzb);
        if (jZzt == this.zzf) {
            return -9223372036854775807L;
        }
        this.zzf = jZzt;
        return jZzt;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        long jZzi = this.zza.zzi();
        if (jZzi != Long.MIN_VALUE) {
            long j3 = this.zzb;
            if (j3 == Long.MIN_VALUE || jZzi < j3) {
                return jZzi;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzj(long j3) {
        this.zze = -9223372036854775807L;
        for (zzwn zzwnVar : this.zzd) {
            if (zzwnVar != null) {
                zzwnVar.zza();
            }
        }
        return zzt(this.zza.zzj(j3), 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzk(long j3, zzni zzniVar) {
        if (j3 == 0) {
            return 0L;
        }
        long j4 = zzniVar.zzd;
        String str = zzfl.zza;
        long jMax = Math.max(0L, Math.min(j4, j3));
        long j5 = zzniVar.zze;
        long j6 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j5, j6 == Long.MIN_VALUE ? Long.MAX_VALUE : j6 - j3));
        if (jMax != j4 || jMax2 != j5) {
            zzniVar = new zzni(jMax, jMax2);
        }
        return this.zza.zzk(j3, zzniVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        long jZzl = this.zza.zzl();
        if (jZzl != Long.MIN_VALUE) {
            long j3 = this.zzb;
            if (j3 == Long.MIN_VALUE || jZzl < j3) {
                return jZzl;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        return this.zza.zzm(zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zza.zzn();
    }

    final boolean zzo() {
        return this.zze != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzp(this);
    }

    final /* synthetic */ long zzq() {
        return this.zzf;
    }

    final /* synthetic */ void zzr(long j3) {
        this.zzf = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }
}

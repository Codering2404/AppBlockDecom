package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzk implements zzxi, zzxh {
    private final zzxi zza;
    private final long zzb;
    private zzxh zzc;

    public zzzk(zzxi zzxiVar, long j3) {
        this.zza = zzxiVar;
        this.zzb = j3;
    }

    public final zzxi zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j3) {
        this.zzc = zzxhVar;
        this.zza.zzb(this, j3 - this.zzb);
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
        zzzc[] zzzcVarArr2 = new zzzc[zzzcVarArr.length];
        int i3 = 0;
        while (true) {
            zzzc zzzcVarZza = null;
            if (i3 >= zzzcVarArr.length) {
                break;
            }
            zzzj zzzjVar = (zzzj) zzzcVarArr[i3];
            if (zzzjVar != null) {
                zzzcVarZza = zzzjVar.zza();
            }
            zzzcVarArr2[i3] = zzzcVarZza;
            i3++;
        }
        zzxi zzxiVar = this.zza;
        long j4 = this.zzb;
        long jZze = zzxiVar.zze(zzabaVarArr, zArr, zzzcVarArr2, zArr2, j3 - j4);
        for (int i4 = 0; i4 < zzzcVarArr.length; i4++) {
            zzzc zzzcVar = zzzcVarArr2[i4];
            if (zzzcVar == null) {
                zzzcVarArr[i4] = null;
            } else {
                zzzc zzzcVar2 = zzzcVarArr[i4];
                if (zzzcVar2 == null || ((zzzj) zzzcVar2).zza() != zzzcVar) {
                    zzzcVarArr[i4] = new zzzj(zzzcVar, j4);
                }
            }
        }
        return jZze + j4;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j3, boolean z2) {
        this.zza.zzf(j3 - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j3) {
        this.zza.zzg(j3 - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        long jZzh = this.zza.zzh();
        if (jZzh == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzh + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        long jZzi = this.zza.zzi();
        if (jZzi == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzi + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzj(long j3) {
        long j4 = this.zzb;
        return this.zza.zzj(j3 - j4) + j4;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzk(long j3, zzni zzniVar) {
        long j4 = this.zzb;
        return this.zza.zzk(j3 - j4, zzniVar) + j4;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        long jZzl = this.zza.zzl();
        if (jZzl == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzl + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        long j3 = zzmaVar.zza;
        long j4 = this.zzb;
        zzlz zzlzVarZza = zzmaVar.zza();
        zzlzVarZza.zza(j3 - j4);
        return this.zza.zzm(zzlzVarZza.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzp(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        zzxh zzxhVar = this.zzc;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }
}

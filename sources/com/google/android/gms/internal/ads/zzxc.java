package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxc implements zzxi, zzxh {
    public final zzxk zza;
    private final long zzb;
    private final zzabl zzc;
    private zzxm zzd;
    private zzxi zze;
    private zzxh zzf;
    private long zzg = -9223372036854775807L;

    public zzxc(zzxk zzxkVar, zzabl zzablVar, long j3) {
        this.zza = zzxkVar;
        this.zzc = zzablVar;
        this.zzb = j3;
    }

    private final long zzv(long j3) {
        long j4 = this.zzg;
        return j4 != -9223372036854775807L ? j4 : j3;
    }

    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j3) {
        this.zzf = zzxhVar;
        zzxi zzxiVar = this.zze;
        if (zzxiVar != null) {
            zzxiVar.zzb(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzc() throws IOException {
        zzxi zzxiVar = this.zze;
        if (zzxiVar != null) {
            zzxiVar.zzc();
            return;
        }
        zzxm zzxmVar = this.zzd;
        if (zzxmVar != null) {
            zzxmVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final zzzn zzd() {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        return zzxiVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zze(zzaba[] zzabaVarArr, boolean[] zArr, zzzc[] zzzcVarArr, boolean[] zArr2, long j3) {
        long j4 = this.zzg;
        long j5 = (j4 == -9223372036854775807L || j3 != this.zzb) ? j3 : j4;
        this.zzg = -9223372036854775807L;
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        return zzxiVar.zze(zzabaVarArr, zArr, zzzcVarArr, zArr2, j5);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j3, boolean z2) {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        zzxiVar.zzf(j3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j3) {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        zzxiVar.zzg(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        return zzxiVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        return zzxiVar.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzj(long j3) {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        return zzxiVar.zzj(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzk(long j3, zzni zzniVar) {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        return zzxiVar.zzk(j3, zzniVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        zzxi zzxiVar = this.zze;
        String str = zzfl.zza;
        return zzxiVar.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        zzxi zzxiVar = this.zze;
        return zzxiVar != null && zzxiVar.zzm(zzmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        zzxi zzxiVar = this.zze;
        return zzxiVar != null && zzxiVar.zzn();
    }

    public final void zzo(long j3) {
        this.zzg = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        zzxh zzxhVar = this.zzf;
        String str = zzfl.zza;
        zzxhVar.zzp(this);
    }

    public final long zzq() {
        return this.zzg;
    }

    public final void zzr(zzxm zzxmVar) {
        zzgtj.zzi(this.zzd == null);
        this.zzd = zzxmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        zzxh zzxhVar = this.zzf;
        String str = zzfl.zza;
        zzxhVar.zzs(this);
    }

    public final void zzt(zzxk zzxkVar) {
        long jZzv = zzv(this.zzb);
        zzxm zzxmVar = this.zzd;
        zzxmVar.getClass();
        zzxi zzxiVarZzG = zzxmVar.zzG(zzxkVar, this.zzc, jZzv);
        this.zze = zzxiVarZzG;
        if (this.zzf != null) {
            zzxiVarZzG.zzb(this, jZzv);
        }
    }

    public final void zzu() {
        zzxi zzxiVar = this.zze;
        if (zzxiVar != null) {
            zzxm zzxmVar = this.zzd;
            zzxmVar.getClass();
            zzxmVar.zzD(zzxiVar);
        }
    }
}

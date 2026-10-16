package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzami {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final zzv zzg;
    public final int zzh;
    public final long[] zzi;
    public final long[] zzj;
    public final int zzk;
    private final zzamj[] zzl;

    public zzami(int i3, int i4, long j3, long j4, long j5, long j6, zzv zzvVar, int i5, zzamj[] zzamjVarArr, int i6, long[] jArr, long[] jArr2) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
        this.zzf = j6;
        this.zzg = zzvVar;
        this.zzh = i5;
        this.zzl = zzamjVarArr;
        this.zzk = i6;
        this.zzi = jArr;
        this.zzj = jArr2;
    }

    public final zzamj zza(int i3) {
        return this.zzl[i3];
    }

    public final zzami zzb(zzv zzvVar) {
        return new zzami(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, zzvVar, this.zzh, this.zzl, this.zzk, this.zzi, this.zzj);
    }
}

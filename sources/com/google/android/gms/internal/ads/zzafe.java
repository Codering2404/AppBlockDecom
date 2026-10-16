package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafe implements zzahb {
    private final zzafh zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zzafe(zzafh zzafhVar, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.zza = zzafhVar;
        this.zzb = j3;
        this.zzc = j5;
        this.zzd = j6;
        this.zze = j7;
        this.zzf = j8;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        zzahc zzahcVar = new zzahc(j3, zzafg.zza(this.zza.zza(j3), 0L, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzagz(zzahcVar, zzahcVar);
    }

    public final long zzd(long j3) {
        return this.zza.zza(j3);
    }

    final /* synthetic */ long zze() {
        return this.zzc;
    }

    final /* synthetic */ long zzf() {
        return this.zzd;
    }

    final /* synthetic */ long zzg() {
        return this.zze;
    }

    final /* synthetic */ long zzh() {
        return this.zzf;
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzamp implements zzamv {
    private final zzagl zza;
    private final zzagk zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzamp(zzagl zzaglVar, zzagk zzagkVar) {
        this.zza = zzaglVar;
        this.zzb = zzagkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final long zza(zzafz zzafzVar) {
        long j3 = this.zzd;
        if (j3 < 0) {
            return -1L;
        }
        this.zzd = -1L;
        return -(j3 + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(long j3) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfl.zzo(jArr, j3, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzahb zzc() {
        zzgtj.zzi(this.zzc != -1);
        return new zzagj(this.zza, this.zzc);
    }

    public final void zzd(long j3) {
        this.zzc = j3;
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzamo implements zzamv {
    private final zzamu zza;
    private final long zzb;
    private final long zzc;
    private final zzamz zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzamo(zzamz zzamzVar, long j3, long j4, long j5, long j6, boolean z2) {
        zzgtj.zza(j3 >= 0 && j4 > j3);
        this.zzd = zzamzVar;
        this.zzb = j3;
        this.zzc = j4;
        if (j5 == j4 - j3 || z2) {
            this.zzf = j6;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzamu();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    @Override // com.google.android.gms.internal.ads.zzamv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zza(com.google.android.gms.internal.ads.zzafz r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamo.zza(com.google.android.gms.internal.ads.zzafz):long");
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(long j3) {
        long j4 = this.zzf - 1;
        String str = zzfl.zza;
        this.zzh = Math.max(0L, Math.min(j3, j4));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final /* bridge */ /* synthetic */ zzahb zzc() {
        byte[] bArr = null;
        if (this.zzf != 0) {
            return new zzamn(this, bArr);
        }
        return null;
    }

    final /* synthetic */ long zzd() {
        return this.zzb;
    }

    final /* synthetic */ long zze() {
        return this.zzc;
    }

    final /* synthetic */ zzamz zzf() {
        return this.zzd;
    }

    final /* synthetic */ long zzg() {
        return this.zzf;
    }
}

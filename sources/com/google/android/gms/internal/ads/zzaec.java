package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaec {
    private final zzadu zza;
    private final zzadv zzf;
    private long zzk;
    private final zzacu zzl;
    private final zzads zzb = new zzads();
    private final zzfh zzc = new zzfh(10);
    private final zzfh zzd = new zzfh(10);
    private final zzei zze = new zzei(16);
    private long zzg = -9223372036854775807L;
    private zzbv zzj = zzbv.zza;
    private long zzh = -9223372036854775807L;
    private long zzi = -9223372036854775807L;

    public zzaec(zzacu zzacuVar, zzadu zzaduVar, zzadv zzadvVar) {
        this.zzl = zzacuVar;
        this.zza = zzaduVar;
        this.zzf = zzadvVar;
    }

    private static Object zzh(zzfh zzfhVar) {
        zzgtj.zza(zzfhVar.zzc() > 0);
        while (zzfhVar.zzc() > 1) {
            zzfhVar.zzd();
        }
        Object objZzd = zzfhVar.zzd();
        objZzd.getClass();
        return objZzd;
    }

    public final void zza() {
        this.zze.zze();
        this.zzg = -9223372036854775807L;
        this.zzh = -9223372036854775807L;
        this.zzi = -9223372036854775807L;
        zzfh zzfhVar = this.zzd;
        if (zzfhVar.zzc() > 0) {
            this.zzk = ((Long) zzh(zzfhVar)).longValue();
        }
        zzfh zzfhVar2 = this.zzc;
        if (zzfhVar2.zzc() > 0) {
            zzfhVar2.zza(0L, (zzbv) zzh(zzfhVar2));
        }
    }

    public final void zzb(long j3, long j4) throws zzjk {
        while (true) {
            zzei zzeiVar = this.zze;
            if (zzeiVar.zzd()) {
                return;
            }
            zzfh zzfhVar = this.zzd;
            long jZzc = zzeiVar.zzc();
            Long l3 = (Long) zzfhVar.zze(jZzc);
            if (l3 != null && l3.longValue() != this.zzk) {
                this.zzk = l3.longValue();
                this.zza.zza(2);
            }
            zzadu zzaduVar = this.zza;
            long j5 = this.zzk;
            zzads zzadsVar = this.zzb;
            int iZzk = zzaduVar.zzk(jZzc, j3, j4, j5, false, false, zzadsVar);
            if (iZzk != 5 && iZzk != 4) {
                this.zzf.zza(jZzc, zzadsVar.zza());
            }
            if (iZzk == 0 || iZzk == 1) {
                this.zzh = jZzc;
                long jZzb = zzeiVar.zzb();
                zzbv zzbvVar = (zzbv) this.zzc.zze(jZzb);
                if (zzbvVar != null && !zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzj)) {
                    this.zzj = zzbvVar;
                    this.zzl.zza(zzbvVar);
                }
                this.zzl.zzb(iZzk == 0 ? System.nanoTime() : zzadsVar.zzb(), jZzb, zzaduVar.zzf());
            } else if (iZzk == 2 || iZzk == 3) {
                this.zzh = jZzc;
                zzeiVar.zzb();
                final zzacu zzacuVar = this.zzl;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzacs
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzacuVar.zza.zzB().zzc();
                    }
                };
                zzacv zzacvVar = zzacuVar.zza;
                zzacvVar.zzC().execute(runnable);
                ((zzaes) zzacvVar.zzz().remove()).zzb();
            } else if (iZzk != 4) {
                return;
            } else {
                this.zzh = jZzc;
            }
        }
    }

    public final void zzc(int i3, int i4) {
        long j3 = this.zzg;
        this.zzc.zza(j3 == -9223372036854775807L ? 0L : j3 + 1, new zzbv(i3, i4, 1.0f));
    }

    public final void zzd(int i3, long j3) {
        if (this.zze.zzd()) {
            this.zza.zza(i3);
            this.zzk = j3;
        } else {
            zzfh zzfhVar = this.zzd;
            long j4 = this.zzg;
            zzfhVar.zza(j4 == -9223372036854775807L ? -4611686018427387904L : j4 + 1, Long.valueOf(j3));
        }
    }

    public final void zze(long j3) {
        this.zze.zza(j3);
        this.zzg = j3;
        this.zzi = -9223372036854775807L;
    }

    public final void zzf() {
        long j3 = this.zzg;
        if (j3 == -9223372036854775807L) {
            j3 = Long.MIN_VALUE;
            this.zzg = Long.MIN_VALUE;
            this.zzh = Long.MIN_VALUE;
        }
        this.zzi = j3;
    }

    public final boolean zzg() {
        long j3 = this.zzi;
        return j3 != -9223372036854775807L && this.zzh == j3;
    }
}

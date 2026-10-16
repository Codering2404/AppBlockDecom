package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakk extends zzafo implements zzakt {
    private final long zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;

    public zzakk(long j3, long j4, int i3, int i4, boolean z2) {
        this(j3, j4, i3, i4, false, true);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j3) {
        return zze(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return this.zzb;
    }

    public final zzakk zzi(long j3) {
        return new zzakk(j3, this.zza, this.zzb, this.zzc, false, false);
    }

    private zzakk(long j3, long j4, int i3, int i4, boolean z2, boolean z3) {
        super(j3, j4, i3, i4, false, z3);
        this.zza = j4;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = j3 == -1 ? -1L : j3;
    }

    public zzakk(long j3, long j4, zzagv zzagvVar, boolean z2) {
        this(j3, j4, zzagvVar.zzf, zzagvVar.zzc, false, true);
    }
}

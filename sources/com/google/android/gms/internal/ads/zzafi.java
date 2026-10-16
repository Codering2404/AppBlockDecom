package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafi {
    public static final zzafi zza = new zzafi(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzafi(int i3, long j3, long j4) {
        this.zzb = i3;
        this.zzc = j3;
        this.zzd = j4;
    }

    public static zzafi zza(long j3, long j4) {
        return new zzafi(-1, j3, j4);
    }

    public static zzafi zzb(long j3, long j4) {
        return new zzafi(-2, j3, j4);
    }

    public static zzafi zzc(long j3) {
        return new zzafi(0, -9223372036854775807L, j3);
    }

    final /* synthetic */ int zzd() {
        return this.zzb;
    }

    final /* synthetic */ long zze() {
        return this.zzc;
    }

    final /* synthetic */ long zzf() {
        return this.zzd;
    }
}

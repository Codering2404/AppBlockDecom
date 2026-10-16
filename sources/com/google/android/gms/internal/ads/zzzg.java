package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzg extends zzbf {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;
    private final boolean zze;
    private final zzak zzf;
    private final zzaf zzg;

    static {
        zzz zzzVar = new zzz();
        zzzVar.zza("SinglePeriodTimeline");
        zzzVar.zzb(Uri.EMPTY);
        zzzVar.zzc();
    }

    public zzzg(long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z2, boolean z3, boolean z4, Object obj, zzak zzakVar, zzaf zzafVar) {
        this.zzc = j6;
        this.zzd = j7;
        this.zze = z2;
        zzakVar.getClass();
        this.zzf = zzakVar;
        this.zzg = zzafVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i3, zzbe zzbeVar, long j3) {
        zzgtj.zzm(i3, 1, "index");
        boolean z2 = this.zze;
        zzbeVar.zza(zzbe.zza, this.zzf, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, z2, false, this.zzg, 0L, this.zzd, 0, 0, 0L);
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i3, zzbd zzbdVar, boolean z2) {
        zzgtj.zzm(i3, 1, "index");
        zzbdVar.zza(null, z2 ? zzb : null, 0, this.zzc, 0L, zzc.zza, false);
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zze(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final Object zzf(int i3) {
        zzgtj.zzm(i3, 1, "index");
        return zzb;
    }
}

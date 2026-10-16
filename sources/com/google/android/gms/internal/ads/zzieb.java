package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzieb implements zzids {
    final int zza;
    final zzihg zzb;
    final boolean zzc;
    final boolean zzd;

    zzieb(zziej zziejVar, int i3, zzihg zzihgVar, boolean z2, boolean z3) {
        this.zza = i3;
        this.zzb = zzihgVar;
        this.zzc = z2;
        this.zzd = z3;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzieb) obj).zza;
    }

    @Override // com.google.android.gms.internal.ads.zzids
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzids
    public final zzihg zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzids
    public final zzihh zzc() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzids
    public final boolean zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzids
    public final boolean zze() {
        return this.zzd;
    }
}

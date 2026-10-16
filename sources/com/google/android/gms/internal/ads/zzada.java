package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzada implements zzaes {
    final /* synthetic */ zzvj zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzade zzd;

    zzada(zzade zzadeVar, zzvj zzvjVar, int i3, long j3) {
        this.zza = zzvjVar;
        this.zzb = i3;
        this.zzc = j3;
        Objects.requireNonNull(zzadeVar);
        this.zzd = zzadeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void zza(long j3) {
        this.zzd.zzaB(this.zza, this.zzb, this.zzc, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void zzb() {
        this.zzd.zzay(this.zza, this.zzb, this.zzc);
    }
}

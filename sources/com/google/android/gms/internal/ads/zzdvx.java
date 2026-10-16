package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdvx implements com.google.android.gms.ads.internal.zzn {
    final /* synthetic */ zzdwi zza;

    zzdvx(zzdwi zzdwiVar) {
        Objects.requireNonNull(zzdwiVar);
        this.zza = zzdwiVar;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdk() {
        this.zza.zzb().zza();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdl() {
        this.zza.zzb().zzb();
    }
}

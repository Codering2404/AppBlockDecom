package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbsq implements zzbpq {
    final /* synthetic */ zzbsx zza;
    private final zzbpq zzb;

    public zzbsq(zzbsx zzbsxVar, zzbpq zzbpqVar) {
        Objects.requireNonNull(zzbsxVar);
        this.zza = zzbsxVar;
        this.zzb = zzbpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        this.zzb.zza(this.zza, map);
    }

    final /* synthetic */ zzbpq zzb() {
        return this.zzb;
    }
}

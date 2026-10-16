package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaop implements zzang {
    private final zzaoi zza;
    private final long[] zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;

    public zzaop(zzaoi zzaoiVar, Map map, Map map2, Map map3) {
        this.zza = zzaoiVar;
        this.zzd = map2;
        this.zze = map3;
        this.zzc = Collections.unmodifiableMap(map);
        this.zzb = zzaoiVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final long zzb(int i3) {
        return this.zzb[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final List zzc(long j3) {
        return this.zza.zzh(j3, this.zzc, this.zzd, this.zze);
    }
}

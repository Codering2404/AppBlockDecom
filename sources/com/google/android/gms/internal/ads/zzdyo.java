package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdyo implements zzfpl {
    private final Map zza;
    private final zzbhp zzb;

    zzdyo(zzbhp zzbhpVar, Map map) {
        this.zza = map;
        this.zzb = zzbhpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdM(zzfpe zzfpeVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            this.zzb.zzc(((zzdyn) map.get(zzfpeVar)).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdN(zzfpe zzfpeVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            this.zzb.zzc(((zzdyn) map.get(zzfpeVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdO(zzfpe zzfpeVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfpeVar)) {
            this.zzb.zzc(((zzdyn) map.get(zzfpeVar)).zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdL(zzfpe zzfpeVar, String str) {
    }
}

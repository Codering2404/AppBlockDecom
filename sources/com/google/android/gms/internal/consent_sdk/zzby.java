package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzby implements zzth {
    private final zztk zza;
    private final zztk zzb;

    private zzby(zztk zztkVar, zztk zztkVar2, zztk zztkVar3) {
        this.zza = zztkVar;
        this.zzb = zztkVar3;
    }

    public static zzby zzc(zztk zztkVar, zztk zztkVar2, zztk zztkVar3) {
        return new zzby(zztkVar, zztkVar2, zztkVar3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm, com.google.android.gms.internal.consent_sdk.zztl
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbx zzb() {
        return new zzbx((zzbz) this.zza.zzb(), zzav.zza(), ((zzce) this.zzb).zzb());
    }
}

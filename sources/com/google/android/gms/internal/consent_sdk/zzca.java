package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzca implements zzth {
    private final zztk zza;

    private zzca(zztk zztkVar) {
        this.zza = zztkVar;
    }

    public static zzca zza(zztk zztkVar) {
        return new zzca(zztkVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm, com.google.android.gms.internal.consent_sdk.zztl
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbz((Application) this.zza.zzb());
    }
}

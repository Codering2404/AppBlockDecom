package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzar implements zzth {
    private final zztk zza;

    private zzar(zztk zztkVar) {
        this.zza = zztkVar;
    }

    public static zzar zza(zztk zztkVar) {
        return new zzar(zztkVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm, com.google.android.gms.internal.consent_sdk.zztl
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzaq((Application) this.zza.zzb());
    }
}

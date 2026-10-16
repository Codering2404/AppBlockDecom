package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzca extends zzcy {
    final /* synthetic */ zzce zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzca(zzce zzceVar, zzbx zzbxVar) {
        super(zzbxVar);
        this.zza = zzceVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzcy
    public final void zza() {
        com.google.android.gms.analytics.zzr.h();
        zzce zzceVar = this.zza;
        if (zzceVar.zzg()) {
            zzceVar.zzN("Inactivity, disconnecting from device AnalyticsService");
            zzceVar.zzc();
        }
    }
}

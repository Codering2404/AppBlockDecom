package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzq implements zzjq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzda f74498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f74499b;

    zzq(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzda zzdaVar) {
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f74499b = appMeasurementDynamiteService;
        this.f74498a = zzdaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjq
    public final void a(String str, String str2, Bundle bundle, long j3) {
        try {
            this.f74498a.zze(str, str2, bundle, j3);
        } catch (RemoteException e3) {
            zzic zzicVar = this.f74499b.f73363a;
            if (zzicVar != null) {
                zzicVar.a().r().b("Event listener threw exception", e3);
            }
        }
    }
}

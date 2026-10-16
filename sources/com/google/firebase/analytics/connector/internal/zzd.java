package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjm;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzd implements AppMeasurementSdk.OnEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zze f87685a;

    public zzd(zze zzeVar) {
        Objects.requireNonNull(zzeVar);
        this.f87685a = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjq
    public final void a(String str, String str2, Bundle bundle, long j3) {
        zze zzeVar = this.f87685a;
        if (zzeVar.f87686a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            int i3 = zzc.f87684g;
            String strA = zzjm.a(str2);
            if (strA != null) {
                str2 = strA;
            }
            bundle2.putString("events", str2);
            zzeVar.a().a(2, bundle2);
        }
    }
}

package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzf implements AppMeasurementSdk.OnEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzg f87690a;

    public zzf(zzg zzgVar) {
        Objects.requireNonNull(zzgVar);
        this.f87690a = zzgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjq
    public final void a(String str, String str2, Bundle bundle, long j3) {
        if (str == null || !zzc.c(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j3);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        this.f87690a.a().a(3, bundle2);
    }
}

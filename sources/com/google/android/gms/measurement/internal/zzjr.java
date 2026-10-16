package com.google.android.gms.measurement.internal;

import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzjr implements zzgm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzic f74028a;

    zzjr(zzjs zzjsVar, zzic zzicVar) {
        this.f74028a = zzicVar;
        Objects.requireNonNull(zzjsVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final boolean zza() {
        return Log.isLoggable(this.f74028a.a().z(), 3);
    }
}

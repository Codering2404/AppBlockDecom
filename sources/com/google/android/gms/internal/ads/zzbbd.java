package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbbd implements zzbbg {
    final /* synthetic */ Activity zza;

    zzbbd(zzbbh zzbbhVar, Activity activity) {
        this.zza = activity;
        Objects.requireNonNull(zzbbhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbbg
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.zza);
    }
}

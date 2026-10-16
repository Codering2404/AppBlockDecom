package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzack implements Spatializer$OnSpatializerStateChangedListener {
    final /* synthetic */ Runnable zza;

    zzack(zzacm zzacmVar, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzacmVar);
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z2) {
        this.zza.run();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z2) {
        this.zza.run();
    }
}

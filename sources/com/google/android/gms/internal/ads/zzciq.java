package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzciq implements Runnable {
    final /* synthetic */ zzcis zza;

    zzciq(zzcis zzcisVar) {
        Objects.requireNonNull(zzcisVar);
        this.zza = zzcisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.b().zzd(this.zza);
    }
}

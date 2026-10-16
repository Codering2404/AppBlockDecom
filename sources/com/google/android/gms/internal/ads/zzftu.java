package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzftu implements Runnable {
    final /* synthetic */ zzfub zza;

    zzftu(zzfub zzfubVar) {
        Objects.requireNonNull(zzfubVar);
        this.zza = zzfubVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfub zzfubVar = this.zza;
        if (zzfubVar.zzN() != null) {
            long jCurrentTimeMillis = zzfubVar.zzO().currentTimeMillis();
            int iZzs = zzfubVar.zzs();
            String strZzM = zzfubVar.zzM();
            zzfubVar.zzN().zzj(jCurrentTimeMillis, zzfubVar.zzP(), iZzs, strZzM);
        }
    }
}

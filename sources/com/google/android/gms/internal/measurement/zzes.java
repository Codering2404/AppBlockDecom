package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzes extends zzcz {
    private final com.google.android.gms.measurement.internal.zzjq zza;

    zzes(com.google.android.gms.measurement.internal.zzjq zzjqVar) {
        this.zza = zzjqVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j3) {
        this.zza.a(str, str2, bundle, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}

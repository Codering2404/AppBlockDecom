package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdwq implements zzddm {
    private final zzcku zza;

    zzdwq(zzcku zzckuVar) {
        this.zza = zzckuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zza(Context context) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzb(Context context) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzc(Context context) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.destroy();
        }
    }
}

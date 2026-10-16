package com.google.android.gms.tagmanager;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaa implements zzx {
    final /* synthetic */ zzak zza;

    @Override // com.google.android.gms.tagmanager.zzx
    public final String zza() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.tagmanager.zzx
    public final void zzb() {
        Log.w("GoogleTagManager", "Refresh ignored: container loaded as default only.");
    }

    @Override // com.google.android.gms.tagmanager.zzx
    public final void zzc(String str) {
        this.zza.zzo(str);
    }
}

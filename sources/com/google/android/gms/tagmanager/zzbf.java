package com.google.android.gms.tagmanager;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbf {
    private int zza = 5;

    public final void zza(String str) {
        if (this.zza <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public final void zzb(String str) {
        if (this.zza <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public final void zzd(String str) {
        if (this.zza <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }
}

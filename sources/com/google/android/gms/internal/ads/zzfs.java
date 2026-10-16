package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfs {
    private boolean zza;

    public zzfs(Context context, Looper looper, zzdo zzdoVar) {
        context.getApplicationContext();
        zzdoVar.zzd(looper, null);
        zzdoVar.zzd(Looper.getMainLooper(), null);
    }

    public final void zza(boolean z2) {
        if (this.zza == z2) {
            return;
        }
        this.zza = z2;
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcev {
    public final ListenableFuture zza(Context context, int i3) {
        zzcfw zzcfwVar = new zzcfw();
        com.google.android.gms.ads.internal.client.zzay.a();
        if (com.google.android.gms.ads.internal.util.client.zzf.a(context)) {
            zzcfr.zza.execute(new zzceu(this, context, zzcfwVar));
        }
        return zzcfwVar;
    }
}

package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbfm implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbfq zzb;

    zzbfm(zzbfq zzbfqVar, View view) {
        this.zza = view;
        Objects.requireNonNull(zzbfqVar);
        this.zzb = zzbfqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}

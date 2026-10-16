package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfwb implements Runnable {
    final /* synthetic */ zzfwc zza;
    private final WebView zzb;

    zzfwb(zzfwc zzfwcVar) {
        Objects.requireNonNull(zzfwcVar);
        this.zza = zzfwcVar;
        this.zzb = zzfwcVar.zzq();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}

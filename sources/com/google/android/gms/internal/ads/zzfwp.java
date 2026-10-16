package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfwp implements Runnable {
    zzfwp() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzfws.zzc != null) {
            zzfws.zzc.post(zzfws.zzk);
            zzfws.zzc.postDelayed(zzfws.zzl, 200L);
        }
    }
}

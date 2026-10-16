package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbfi implements Runnable {
    final /* synthetic */ zzbfj zza;

    zzbfi(zzbfj zzbfjVar) {
        Objects.requireNonNull(zzbfjVar);
        this.zza = zzbfjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfj zzbfjVar = this.zza;
        synchronized (zzbfjVar.zzf()) {
            if (zzbfjVar.zzg().get() && zzbfjVar.zzh()) {
                zzbfjVar.zzg().set(false);
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("App went background");
                Iterator it = zzbfjVar.zzi().iterator();
                while (it.hasNext()) {
                    try {
                        ((zzbfk) it.next()).zza(false);
                    } catch (Exception e3) {
                        com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
                    }
                }
            } else {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("App is still foreground");
            }
        }
    }
}

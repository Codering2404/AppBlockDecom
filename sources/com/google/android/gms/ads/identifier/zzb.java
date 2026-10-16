package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzb extends Thread {
    final CountDownLatch zza;
    private final WeakReference zzb;
    private final long zzc;

    public zzb(AdvertisingIdClient advertisingIdClient, long j3) {
        super("AdIdClientAutoDisconnectThread");
        this.zzb = new WeakReference(advertisingIdClient);
        this.zzc = j3;
        this.zza = new CountDownLatch(1);
        start();
    }

    private final void zza() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzb.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.zza();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.zza.await(this.zzc, TimeUnit.MILLISECONDS)) {
                return;
            }
            zza();
        } catch (InterruptedException unused) {
            zza();
        }
    }
}

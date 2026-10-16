package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzew implements zzeb {
    private long zzb;
    private final Object zzc = new Object();
    private double zza = 60.0d;
    private final Clock zzd = DefaultClock.c();

    @Override // com.google.android.gms.tagmanager.zzeb
    public final boolean zza() {
        synchronized (this.zzc) {
            try {
                long jCurrentTimeMillis = this.zzd.currentTimeMillis();
                double dMin = this.zza;
                if (dMin < 60.0d) {
                    double d3 = (jCurrentTimeMillis - this.zzb) / 2000.0d;
                    if (d3 > 0.0d) {
                        dMin = Math.min(60.0d, dMin + d3);
                        this.zza = dMin;
                    }
                }
                this.zzb = jCurrentTimeMillis;
                if (dMin >= 1.0d) {
                    this.zza = dMin - 1.0d;
                    return true;
                }
                Log.w("GoogleTagManager", "No more tokens available.");
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

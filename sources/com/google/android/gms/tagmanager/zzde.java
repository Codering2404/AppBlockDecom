package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzde implements zzeb {
    private double zza;
    private long zzb;
    private final Object zzc;
    private final String zzd;
    private final Clock zze;

    @Override // com.google.android.gms.tagmanager.zzeb
    public final boolean zza() {
        synchronized (this.zzc) {
            try {
                long jCurrentTimeMillis = this.zze.currentTimeMillis();
                long j3 = jCurrentTimeMillis - this.zzb;
                if (j3 < 5000) {
                    Log.w("GoogleTagManager", "Excessive " + this.zzd + " detected; call ignored.");
                    return false;
                }
                double dMin = this.zza;
                if (dMin < 5.0d) {
                    double d3 = j3 / 900000.0d;
                    if (d3 > 0.0d) {
                        dMin = Math.min(5.0d, dMin + d3);
                        this.zza = dMin;
                    }
                }
                this.zzb = jCurrentTimeMillis;
                if (dMin >= 1.0d) {
                    this.zza = dMin - 1.0d;
                    return true;
                }
                Log.w("GoogleTagManager", "Excessive " + this.zzd + " detected; call ignored.");
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

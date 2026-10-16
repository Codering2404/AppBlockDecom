package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfke {
    private final Clock zza;
    private final zzdzl zzb;
    private final Object zzc = new Object();
    private volatile int zze = 1;
    private volatile long zzd = 0;

    public zzfke(Clock clock, zzdzl zzdzlVar) {
        this.zza = clock;
        this.zzb = zzdzlVar;
    }

    private final void zze() {
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzc) {
            try {
                if (this.zze == 3) {
                    if (this.zzd + ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgU)).longValue() <= jCurrentTimeMillis) {
                        this.zze = 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzf(int i3, int i4) {
        zze();
        Object obj = this.zzc;
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (obj) {
            try {
                if (this.zze != i3) {
                    return;
                }
                this.zze = i4;
                if (this.zze == 3) {
                    this.zzd = jCurrentTimeMillis;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza(boolean z2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoB)).booleanValue()) {
            zzdzk zzdzkVarZza = this.zzb.zza();
            zzdzkVarZza.zzc("action", "mbs_state");
            zzdzkVarZza.zzc("mbs_state", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            zzdzkVarZza.zzd();
        }
        if (z2) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzb() {
        boolean z2;
        synchronized (this.zzc) {
            zze();
            z2 = this.zze == 2;
        }
        return z2;
    }

    public final boolean zzc() {
        boolean z2;
        synchronized (this.zzc) {
            zze();
            z2 = this.zze == 3;
        }
        return z2;
    }

    public final void zzd() {
        zzf(2, 3);
    }
}

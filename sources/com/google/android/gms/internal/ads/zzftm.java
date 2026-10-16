package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzftm {
    private final Object zza;
    private final long zzb;
    private final Clock zzc;
    private final long zzd;
    private final double zze;
    private final int zzf;

    public zzftm(Object obj, Clock clock, double d3, int i3) {
        if (clock == null) {
            throw new IllegalArgumentException("Clock cannot be null.");
        }
        this.zza = obj;
        this.zzc = clock;
        this.zzb = clock.currentTimeMillis();
        this.zzd = Math.min(Math.max(((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaa)).longValue() * 1000, 10000L), 21600000L);
        this.zze = d3;
        this.zzf = i3;
    }

    public final Object zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzc.currentTimeMillis() >= this.zzb + this.zzd;
    }

    public final long zzc() {
        return this.zzd - (this.zzc.currentTimeMillis() - this.zzb);
    }

    public final long zzd() {
        return this.zzb;
    }

    public final double zze() {
        return this.zze;
    }

    public final int zzf() {
        return this.zzf;
    }
}

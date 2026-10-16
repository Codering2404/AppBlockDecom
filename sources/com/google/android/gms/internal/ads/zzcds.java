package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcds {
    private final Clock zza;
    private final zzcdq zzb;

    zzcds(Clock clock, zzcdq zzcdqVar) {
        this.zza = clock;
        this.zzb = zzcdqVar;
    }

    public static zzcds zza(Context context) {
        return zzcea.zzb(context).zza();
    }

    public final void zzb() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzfr zzfrVar) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd(int i3, long j3) {
        this.zzb.zza(i3, j3);
    }
}

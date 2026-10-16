package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcdu {
    private Context zza;
    private Clock zzb;
    private com.google.android.gms.ads.internal.util.zzg zzc;
    private zzcdz zzd;

    private zzcdu() {
        throw null;
    }

    public final zzcdu zza(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzcdu zzb(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzcdu zzc(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzc = zzgVar;
        return this;
    }

    public final zzcdu zzd(zzcdz zzcdzVar) {
        this.zzd = zzcdzVar;
        return this;
    }

    public final zzcea zze() {
        zzinc.zzc(this.zza, Context.class);
        zzinc.zzc(this.zzb, Clock.class);
        zzinc.zzc(this.zzc, com.google.android.gms.ads.internal.util.zzg.class);
        zzinc.zzc(this.zzd, zzcdz.class);
        return new zzcdv(this.zza, this.zzb, this.zzc, this.zzd);
    }

    /* synthetic */ zzcdu(byte[] bArr) {
    }
}

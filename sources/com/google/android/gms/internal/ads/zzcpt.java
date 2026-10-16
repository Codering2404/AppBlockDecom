package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcpt implements zzehi {
    private final zzcox zza;
    private Context zzb;

    /* synthetic */ zzcpt(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final zzehj zza() {
        zzinc.zzc(this.zzb, Context.class);
        return new zzcpu(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final /* bridge */ /* synthetic */ zzehi zzb(Context context) {
        this.zzb = context;
        return this;
    }
}

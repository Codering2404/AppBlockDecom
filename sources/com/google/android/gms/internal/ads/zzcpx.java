package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcpx implements zzfjy {
    private final zzcox zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcpx(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfjy
    public final zzfjz zza() {
        zzinc.zzc(this.zzb, Context.class);
        return new zzcpy(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzfjy
    public final /* synthetic */ zzfjy zzb(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfjy
    public final /* bridge */ /* synthetic */ zzfjy zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}

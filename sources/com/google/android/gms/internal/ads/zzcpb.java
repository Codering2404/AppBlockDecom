package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcpb implements zzffg {
    private final zzcox zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcpb(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffg
    public final zzffh zza() {
        zzinc.zzc(this.zzb, Context.class);
        zzinc.zzc(this.zzc, String.class);
        return new zzcpc(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzffg
    public final /* bridge */ /* synthetic */ zzffg zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzffg
    public final /* bridge */ /* synthetic */ zzffg zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}

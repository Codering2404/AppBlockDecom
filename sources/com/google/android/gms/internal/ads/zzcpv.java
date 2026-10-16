package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcpv implements zzehp {
    private final zzcox zza;
    private final zzcpu zzb;
    private zzefw zzc;

    /* synthetic */ zzcpv(zzcox zzcoxVar, zzcpu zzcpuVar, byte[] bArr) {
        this.zza = zzcoxVar;
        this.zzb = zzcpuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehp
    public final zzehq zza() {
        zzinc.zzc(this.zzc, zzefw.class);
        return new zzcpw(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzehp
    public final /* bridge */ /* synthetic */ zzehp zzb(zzefw zzefwVar) {
        this.zzc = zzefwVar;
        return this;
    }
}

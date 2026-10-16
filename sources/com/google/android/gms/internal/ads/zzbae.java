package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbae implements zzfye {
    final /* synthetic */ zzfxg zza;

    zzbae(zzfxg zzfxgVar) {
        this.zza = zzfxgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfye
    public final void zza(int i3, long j3) {
        this.zza.zzb(i3, System.currentTimeMillis() - j3);
    }

    @Override // com.google.android.gms.internal.ads.zzfye
    public final void zzb(int i3, long j3, String str) {
        this.zza.zzf(i3, System.currentTimeMillis() - j3, str);
    }
}

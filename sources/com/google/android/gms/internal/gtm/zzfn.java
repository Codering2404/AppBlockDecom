package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfn implements zzdb {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzfp zzb;

    zzfn(zzfp zzfpVar, Runnable runnable) {
        this.zzb = zzfpVar;
        this.zza = runnable;
    }

    @Override // com.google.android.gms.internal.gtm.zzdb
    public final void zza(Throwable th) {
        this.zzb.zzb.post(this.zza);
    }
}

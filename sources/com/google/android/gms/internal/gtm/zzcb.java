package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcb implements Runnable {
    final /* synthetic */ zzcd zza;
    final /* synthetic */ zzfa zzb;

    zzcb(zzcd zzcdVar, zzfa zzfaVar) {
        this.zza = zzcdVar;
        this.zzb = zzfaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.zza.zzg()) {
            return;
        }
        this.zza.zza.zzE("Connected to service after a timeout");
        zzcd zzcdVar = this.zza;
        zzce.zzi(zzcdVar.zza, this.zzb);
    }
}

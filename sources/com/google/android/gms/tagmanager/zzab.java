package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzab {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzak zzb;
    private Long zzc;

    public final boolean zza(Container container) {
        if (!this.zza) {
            return !container.isDefault();
        }
        long lastRefreshTime = container.getLastRefreshTime();
        if (this.zzc == null) {
            this.zzc = Long.valueOf(this.zzb.zzi.zza());
        }
        return lastRefreshTime + this.zzc.longValue() >= this.zzb.zza.currentTimeMillis();
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbto extends zzcgd {
    private final Object zza = new Object();
    private final zzbtt zzb;
    private boolean zzc;

    public zzbto(zzbtt zzbttVar) {
        this.zzb = zzbttVar;
    }

    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.k("release: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("release: Lock acquired");
                if (this.zzc) {
                    com.google.android.gms.ads.internal.util.zze.k("release: Lock already released");
                    return;
                }
                this.zzc = true;
                zze(new zzbtl(this), new zzcfz());
                zze(new zzbtm(this), new zzbtn(this));
                com.google.android.gms.ads.internal.util.zze.k("release: Lock released");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ zzbtt zzb() {
        return this.zzb;
    }
}

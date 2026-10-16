package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzasu implements Runnable {
    private final zzate zza;
    private final zzatk zzb;
    private final Runnable zzc;

    public zzasu(zzate zzateVar, zzatk zzatkVar, Runnable runnable) {
        this.zza = zzateVar;
        this.zzb = zzatkVar;
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzate zzateVar = this.zza;
        zzateVar.zzl();
        zzatk zzatkVar = this.zzb;
        if (zzatkVar.zzc()) {
            zzateVar.zzs(zzatkVar.zza);
        } else {
            zzateVar.zzt(zzatkVar.zzc);
        }
        if (zzatkVar.zzd) {
            zzateVar.zzc("intermediate-response");
        } else {
            zzateVar.zzd("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}

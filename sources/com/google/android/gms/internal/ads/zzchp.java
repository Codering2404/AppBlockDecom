package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzchp implements Runnable {
    private final zzchb zza;
    private boolean zzb = false;

    zzchp(zzchb zzchbVar) {
        this.zza = zzchbVar;
    }

    private final void zzc() {
        zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.f70374l;
        zzgamVar.removeCallbacks(this);
        zzgamVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzF();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzF();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlr {
    public zzms zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    private boolean zze;

    public zzlr(zzms zzmsVar) {
        this.zza = zzmsVar;
    }

    public final void zza(int i3) {
        this.zze = 1 == ((this.zze ? 1 : 0) | i3);
        this.zzb += i3;
    }

    public final void zzb(zzms zzmsVar) {
        this.zze |= this.zza != zzmsVar;
        this.zza = zzmsVar;
    }

    public final void zzc(int i3) {
        if (this.zzc && this.zzd != 5) {
            zzgtj.zza(i3 == 5);
            return;
        }
        this.zze = true;
        this.zzc = true;
        this.zzd = i3;
    }

    final /* synthetic */ boolean zzd() {
        return this.zze;
    }
}

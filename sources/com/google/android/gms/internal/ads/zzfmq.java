package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfmq {
    private final zzfmp zza = new zzfmp();
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    zzfmq() {
    }

    public final void zza() {
        this.zzd++;
    }

    public final void zzb() {
        this.zze++;
    }

    public final void zzc() {
        this.zzb++;
        this.zza.zza = true;
    }

    public final void zzd() {
        this.zzc++;
        this.zza.zzb = true;
    }

    public final void zze() {
        this.zzf++;
    }

    public final zzfmp zzf() {
        zzfmp zzfmpVar = this.zza;
        zzfmp zzfmpVarClone = zzfmpVar.clone();
        zzfmpVar.zza = false;
        zzfmpVar.zzb = false;
        return zzfmpVarClone;
    }

    public final String zzg() {
        return "\n\tPool does not exist: " + this.zzd + "\n\tNew pools created: " + this.zzb + "\n\tPools removed: " + this.zzc + "\n\tEntries added: " + this.zzf + "\n\tNo entries retrieved: " + this.zze + "\n";
    }
}

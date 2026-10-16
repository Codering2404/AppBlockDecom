package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzca implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcb zzc;
    final /* synthetic */ zzcb zzd;

    zzca(zzcb zzcbVar, zzcb zzcbVar2, long j3, String str) {
        this.zzc = zzcbVar;
        this.zzd = zzcbVar2;
        this.zza = j3;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzc.zze == null) {
            zzcb zzcbVar = this.zzc;
            zzcb zzcbVar2 = this.zzd;
            zzfe zzfeVarZzg = zzfe.zzg();
            zzfeVarZzg.zzl(zzcbVar.zzf, zzcbVar2);
            this.zzc.zze = zzfeVarZzg.zzf();
        }
        zzcb zzcbVar3 = this.zzc;
        zzcbVar3.zze.zzb(this.zza, this.zzb);
    }
}

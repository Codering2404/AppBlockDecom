package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfqc implements zzhbt {
    final /* synthetic */ zzfqg zza;
    final /* synthetic */ zzfpw zzb;
    final /* synthetic */ boolean zzc;

    zzfqc(zzfqg zzfqgVar, zzfpw zzfpwVar, boolean z2) {
        this.zza = zzfqgVar;
        this.zzb = zzfpwVar;
        this.zzc = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfpw zzfpwVar = this.zzb;
        if (zzfpwVar.zzb()) {
            zzfqg zzfqgVar = this.zza;
            zzfpwVar.zzj(th);
            zzfpwVar.zzd(false);
            zzfqgVar.zza(zzfpwVar);
            if (this.zzc) {
                zzfqgVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        zzfpw zzfpwVar = this.zzb;
        zzfpwVar.zzd(true);
        zzfqg zzfqgVar = this.zza;
        zzfqgVar.zza(zzfpwVar);
        if (this.zzc) {
            zzfqgVar.zzh();
        }
    }
}

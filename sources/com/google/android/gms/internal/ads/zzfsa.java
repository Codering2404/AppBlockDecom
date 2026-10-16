package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfsa implements zzhbt {
    final /* synthetic */ zzfpw zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzdfg zzc;
    final /* synthetic */ zzfsc zzd;

    zzfsa(zzfsc zzfscVar, zzfpw zzfpwVar, zzfqg zzfqgVar, zzdfg zzdfgVar) {
        this.zza = zzfpwVar;
        this.zzb = zzfqgVar;
        this.zzc = zzdfgVar;
        Objects.requireNonNull(zzfscVar);
        this.zzd = zzfscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfpw zzfpwVar = this.zza;
        if (zzfpwVar == null) {
            return;
        }
        zzfpwVar.zzd(false);
        zzfqg zzfqgVar = this.zzb;
        if (zzfqgVar != null) {
            zzfqgVar.zza(zzfpwVar);
            zzfqgVar.zzh();
        } else {
            zzfsc zzfscVar = this.zzd;
            zzfscVar.zze().zzb(zzfpwVar.zzm());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    @Override // com.google.android.gms.internal.ads.zzhbt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfsa.zzb(java.lang.Object):void");
    }
}

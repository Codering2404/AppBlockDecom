package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbk extends zzhay {
    private zzhbj zza;

    zzhbk(zzgwi zzgwiVar, boolean z2, Executor executor, Callable callable) {
        super(zzgwiVar, z2, false);
        this.zza = new zzhbi(this, callable, executor);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzA(int i3) {
        super.zzA(i3);
        if (i3 == 1) {
            this.zza = null;
        }
    }

    final /* synthetic */ void zzD(zzhbj zzhbjVar) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    protected final void zzi() {
        zzhbj zzhbjVar = this.zza;
        if (zzhbjVar != null) {
            zzhbjVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzx() {
        zzhbj zzhbjVar = this.zza;
        if (zzhbjVar != null) {
            zzhbjVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzw(int i3, Object obj) {
    }
}

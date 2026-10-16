package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzacz implements zzaer {
    final /* synthetic */ zzade zza;

    zzacz(zzade zzadeVar) {
        Objects.requireNonNull(zzadeVar);
        this.zza = zzadeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zza() {
        zzmz zzmzVarZzbc = this.zza.zzbc();
        if (zzmzVarZzbc != null) {
            zzmzVarZzbc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzb() {
        zzade zzadeVar = this.zza;
        if (zzadeVar.zzbp() != null) {
            zzadeVar.zzbo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzc() {
        zzade zzadeVar = this.zza;
        if (zzadeVar.zzbp() != null) {
            zzadeVar.zzaz(0, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzd(zzbv zzbvVar) {
    }
}

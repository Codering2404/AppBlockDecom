package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfne implements zzhbt {
    final /* synthetic */ zzfnh zza;
    final /* synthetic */ zzfnj zzb;

    zzfne(zzfnj zzfnjVar, zzfnh zzfnhVar) {
        this.zza = zzfnhVar;
        Objects.requireNonNull(zzfnjVar);
        this.zzb = zzfnjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfnj zzfnjVar = this.zzb;
        synchronized (zzfnjVar) {
            zzfnjVar.zzf(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfnj zzfnjVar = this.zzb;
        synchronized (zzfnjVar) {
            try {
                zzfnjVar.zzf(null);
                zzfnjVar.zze().addFirst(this.zza);
                if (zzfnjVar.zzg() == 1) {
                    zzfnjVar.zzd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

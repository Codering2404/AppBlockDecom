package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbnz extends zzbne {
    final /* synthetic */ zzbob zza;

    /* synthetic */ zzbnz(zzbob zzbobVar, byte[] bArr) {
        Objects.requireNonNull(zzbobVar);
        this.zza = zzbobVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void zze(zzbmv zzbmvVar, String str) {
        zzbob zzbobVar = this.zza;
        if (zzbobVar.zzd() == null) {
            return;
        }
        zzbobVar.zzd().b(zzbobVar.zze(zzbmvVar), str);
    }
}

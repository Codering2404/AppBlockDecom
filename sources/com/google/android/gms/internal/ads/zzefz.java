package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzefz implements zzhbt {
    final /* synthetic */ Context zza;

    zzefz(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        if (((Boolean) zzbki.zzh.zze()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzaz)) {
            zzbib.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbki.zzj.zze()).booleanValue()) {
            zzbib.zze(this.zza);
        }
    }
}

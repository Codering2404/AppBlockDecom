package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Strings;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewt implements zzfck {
    private final zzfhe zza;

    zzewt(zzfhe zzfheVar) {
        this.zza = zzfheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        zzfhe zzfheVar = this.zza;
        if (zzfheVar == null) {
            return zzhbw.zza(new zzews(null));
        }
        String strZza = zzfheVar.zza();
        return Strings.b(strZza) ? zzhbw.zza(new zzews(null)) : zzhbw.zza(new zzews(strZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 15;
    }
}

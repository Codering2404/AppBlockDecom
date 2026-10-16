package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfef implements zzfck {
    public zzfef(zzces zzcesVar, zzhcg zzhcgVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        final ListenableFuture listenableFutureZza = zzhbw.zza(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgO)).booleanValue()) {
            listenableFutureZza = zzhbw.zza(null);
        }
        final ListenableFuture listenableFutureZza2 = zzhbw.zza(null);
        return zzhbw.zzo(listenableFutureZza, listenableFutureZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfee
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzfeg((String) listenableFutureZza.get(), (String) listenableFutureZza2.get());
            }
        }, zzcfr.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 47;
    }
}

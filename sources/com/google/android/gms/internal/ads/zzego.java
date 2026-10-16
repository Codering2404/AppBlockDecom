package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzego implements zzegq {
    private final Map zza;
    private final zzhcg zzb;
    private final zzdfv zzc;

    public zzego(Map map, zzhcg zzhcgVar, zzdfv zzdfvVar) {
        this.zza = map;
        this.zzb = zzhcgVar;
        this.zzc = zzdfvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zza(final zzcbd zzcbdVar) {
        this.zzc.zzdP(zzcbdVar);
        ListenableFuture listenableFutureZzc = zzhbw.zzc(new zzeed(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjx)).split(",")) {
            final zzinj zzinjVar = (zzinj) this.zza.get(str.trim());
            if (zzinjVar != null) {
                listenableFutureZzc = zzhbw.zzh(listenableFutureZzc, zzeed.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzegn
                    @Override // com.google.android.gms.internal.ads.zzhbe
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return ((zzegq) zzinjVar.zzb()).zza(zzcbdVar);
                    }
                }, this.zzb);
            }
        }
        zzhbw.zzr(listenableFutureZzc, new zzegm(this), zzcfr.zzh);
        return listenableFutureZzc;
    }

    final /* synthetic */ zzdfv zzb() {
        return this.zzc;
    }
}

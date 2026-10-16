package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeul implements zzfck {
    private final zzhcg zza;
    private final zzfky zzb;

    zzeul(zzhcg zzhcgVar, zzfky zzfkyVar, zzflo zzfloVar) {
        this.zza = zzhcgVar;
        this.zzb = zzfkyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuk
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 5;
    }

    final /* synthetic */ zzeum zzc() {
        List listAsList;
        String strZza = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhY)).booleanValue()) {
            String strC = com.google.android.gms.ads.nonagon.signalgeneration.zzv.c(this.zzb.zzd);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzia)).booleanValue()) {
                listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzib)).split(","));
            } else {
                listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhZ)).split(","));
            }
            if (listAsList.contains(com.google.android.gms.ads.nonagon.signalgeneration.zzv.b(strC))) {
                strZza = zzflo.zza();
            }
        }
        return new zzeum(strZza);
    }
}

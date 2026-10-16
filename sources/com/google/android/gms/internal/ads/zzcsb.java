package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzcsb implements zzhbe {
    static final /* synthetic */ zzcsb zza = new zzcsb();

    private /* synthetic */ zzcsb() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        Throwable th = (Throwable) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlQ)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.l().zzi(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
        } else {
            com.google.android.gms.ads.internal.zzt.l().zzh(th, "GetTopicsApiWithRecordObservationActionHandler");
        }
        return zzhbw.zza(new GetTopicsResponse(zzgwm.zzi()));
    }
}

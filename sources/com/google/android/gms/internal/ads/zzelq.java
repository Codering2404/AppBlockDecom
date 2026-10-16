package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzelq {
    private final Context zza;

    zzelq(Context context) {
        this.zza = context;
    }

    public final ListenableFuture zza(boolean z2) {
        try {
            GetTopicsRequest getTopicsRequestA = new GetTopicsRequest.Builder().b("com.google.android.gms.ads").c(z2).a();
            TopicsManagerFutures topicsManagerFuturesA = TopicsManagerFutures.a(this.zza);
            return topicsManagerFuturesA != null ? topicsManagerFuturesA.b(getTopicsRequestA) : zzhbw.zzc(new IllegalStateException());
        } catch (Exception e3) {
            return zzhbw.zzc(e3);
        }
    }
}

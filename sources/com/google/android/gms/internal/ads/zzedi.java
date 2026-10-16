package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzedi extends AdListener {
    final /* synthetic */ zzedo zza;

    zzedi(zzedo zzedoVar) {
        Objects.requireNonNull(zzedoVar);
        this.zza = zzedoVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zza.zzg(zzedo.zzm(loadAdError));
    }
}

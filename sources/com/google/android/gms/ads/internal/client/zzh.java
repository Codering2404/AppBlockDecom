package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzh extends zzbj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdLoadCallback f69960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f69961b;

    public zzh(AdLoadCallback adLoadCallback, Object obj) {
        this.f69960a = adLoadCallback;
        this.f69961b = obj;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb() {
        Object obj;
        AdLoadCallback adLoadCallback = this.f69960a;
        if (adLoadCallback == null || (obj = this.f69961b) == null) {
            return;
        }
        adLoadCallback.onAdLoaded(obj);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc(zze zzeVar) {
        AdLoadCallback adLoadCallback = this.f69960a;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzeVar.N());
        }
    }
}

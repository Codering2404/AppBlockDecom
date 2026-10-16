package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfn extends zzdm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnAdMetadataChangedListener f69945a;

    public zzfn(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f69945a = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final void zze() {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.f69945a;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}

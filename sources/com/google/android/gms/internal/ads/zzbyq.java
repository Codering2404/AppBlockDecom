package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyq extends zzbno {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbyq(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbnp
    public final void zze(zzbnv zzbnvVar) {
        this.zza.onNativeAdLoaded(new zzbyl(zzbnvVar));
    }
}

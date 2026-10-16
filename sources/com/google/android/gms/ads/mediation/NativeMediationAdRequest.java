package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface NativeMediationAdRequest extends MediationAdRequest {
    NativeAdOptions getNativeAdOptions();

    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isUnifiedNativeAdRequested();

    boolean zza();

    Map zzb();
}

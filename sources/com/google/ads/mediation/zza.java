package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zzh;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zza extends UnifiedNativeAdMapper {
    public zza(UnifiedNativeAd unifiedNativeAd) {
        x(unifiedNativeAd.zza());
        z(unifiedNativeAd.zzb());
        v(unifiedNativeAd.zzc());
        y(unifiedNativeAd.zzd());
        w(unifiedNativeAd.zze());
        u(unifiedNativeAd.zzf());
        D(unifiedNativeAd.zzg());
        E(unifiedNativeAd.zzh());
        C(unifiedNativeAd.zzi());
        I(unifiedNativeAd.zzk());
        B(true);
        A(true);
        H(unifiedNativeAd.zzj());
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public final void F(View view, Map map, Map map2) {
        if ((view instanceof zzh) || ((com.google.android.gms.ads.formats.zzc) com.google.android.gms.ads.formats.zzc.f69737a.get(view)) != null) {
            throw null;
        }
    }
}

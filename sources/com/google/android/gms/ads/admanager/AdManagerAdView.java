package com.google.android.gms.ads.admanager;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbzy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdManagerAdView extends BaseAdView {
    public AdManagerAdView(Context context) {
        super(context, 0);
        Preconditions.n(context, "Context cannot be null");
    }

    public final boolean e(zzbu zzbuVar) {
        return this.f69669a.c(zzbuVar);
    }

    final /* synthetic */ void f(AdManagerAdRequest adManagerAdRequest) {
        try {
            this.f69669a.n(adManagerAdRequest.a());
        } catch (IllegalStateException e3) {
            zzbzy.zza(getContext()).zzh(e3, "AdManagerAdView.loadAd");
        }
    }

    public AdSize[] getAdSizes() {
        return this.f69669a.k();
    }

    public AppEventListener getAppEventListener() {
        return this.f69669a.m();
    }

    public VideoController getVideoController() {
        return this.f69669a.C();
    }

    public VideoOptions getVideoOptions() {
        return this.f69669a.b();
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f69669a.t(adSizeArr);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f69669a.v(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z2) {
        this.f69669a.w(z2);
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.f69669a.a(videoOptions);
    }
}

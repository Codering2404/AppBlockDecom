package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.d;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class dd extends MaxNativeAdListener implements MaxAdRevenueListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f59204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxNativeAdLoader f59205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f59206c = new LinkedList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f59207d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f59208f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f59209g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void onAdRevenuePaid(MaxAd maxAd);

        void onNativeAdClicked(MaxAd maxAd);

        void onNativeAdLoadFailed(String str, MaxError maxError);

        void onNativeAdLoaded();
    }

    public dd(MaxAdPlacerSettings maxAdPlacerSettings, Context context, a aVar) {
        this.f59204a = maxAdPlacerSettings.getMaxPreloadedAdCount();
        this.f59209g = aVar;
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(maxAdPlacerSettings.getAdUnitId(), context);
        this.f59205b = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this);
        maxNativeAdLoader.setRevenueListener(this);
        maxNativeAdLoader.setPlacement(maxAdPlacerSettings.getPlacement());
        maxNativeAdLoader.setLocalExtraParameter(MaxNativeAdLoaderImpl.KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE, d.b.NATIVE_AD_PLACER);
    }

    public void a() {
        synchronized (this.f59208f) {
            try {
                Iterator it = this.f59206c.iterator();
                while (it.hasNext()) {
                    a((MaxAd) it.next());
                }
                this.f59206c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public MaxAd b() {
        MaxAd maxAd;
        synchronized (this.f59208f) {
            maxAd = null;
            while (!this.f59206c.isEmpty() && (maxAd == null || maxAd.getNativeAd().isExpired())) {
                try {
                    maxAd = (MaxAd) this.f59206c.remove();
                } catch (Throwable th) {
                    throw th;
                }
            }
            e();
        }
        return maxAd;
    }

    public void c() {
        this.f59209g = null;
        a();
        this.f59205b.destroy();
    }

    public boolean d() {
        boolean z2;
        synchronized (this.f59208f) {
            z2 = !this.f59206c.isEmpty();
        }
        return z2;
    }

    public void e() {
        synchronized (this.f59208f) {
            try {
                if (!this.f59207d && this.f59206c.size() < this.f59204a) {
                    this.f59207d = true;
                    this.f59205b.loadAd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        a aVar = this.f59209g;
        if (aVar != null) {
            aVar.onAdRevenuePaid(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdClicked(MaxAd maxAd) {
        a aVar = this.f59209g;
        if (aVar != null) {
            aVar.onNativeAdClicked(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        a aVar = this.f59209g;
        if (aVar != null) {
            aVar.onNativeAdLoadFailed(str, maxError);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        synchronized (this.f59208f) {
            this.f59206c.add(maxAd);
            this.f59207d = false;
            e();
        }
        a aVar = this.f59209g;
        if (aVar != null) {
            aVar.onNativeAdLoaded();
        }
    }

    public void a(MaxAd maxAd) {
        this.f59205b.destroy(maxAd);
    }

    public boolean a(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        return this.f59205b.render(maxNativeAdView, maxAd);
    }
}

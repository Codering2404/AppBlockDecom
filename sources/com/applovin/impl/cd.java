package com.applovin.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.hybridAds.MaxHybridMRecAdActivity;
import com.applovin.mediation.hybridAds.MaxHybridNativeAdActivity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f58896a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final he f58897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f58898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MaxAdapterListener f58899c;

        public a(he heVar, com.applovin.impl.sdk.j jVar, MaxAdapterListener maxAdapterListener) {
            this.f58897a = heVar;
            this.f58898b = jVar;
            this.f58899c = maxAdapterListener;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridMRecAdActivity) {
                ((MaxHybridMRecAdActivity) activity).a(this.f58897a.H(), this.f58897a.y(), this.f58898b, this.f58899c);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridMRecAdActivity) && !activity.isChangingConfigurations() && this.f58897a.w().get()) {
                this.f58898b.e().b(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final he f58900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f58901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MaxAdapterListener f58902c;

        public b(he heVar, com.applovin.impl.sdk.j jVar, MaxAdapterListener maxAdapterListener) {
            this.f58900a = heVar;
            this.f58901b = jVar;
            this.f58902c = maxAdapterListener;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxHybridNativeAdActivity) {
                ((MaxHybridNativeAdActivity) activity).a(this.f58900a.H(), this.f58900a.getNativeAd(), this.f58901b, this.f58902c);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if ((activity instanceof MaxHybridNativeAdActivity) && !activity.isChangingConfigurations() && this.f58900a.w().get()) {
                this.f58901b.e().b(this);
            }
        }
    }

    public cd(com.applovin.impl.sdk.j jVar) {
        this.f58896a = jVar;
    }

    public void a(he heVar, Activity activity, MaxAdapterListener maxAdapterListener) {
        yp.b();
        if (activity == null) {
            activity = this.f58896a.e().b();
        }
        if (heVar.getNativeAd() != null) {
            this.f58896a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58896a.I().a("MaxHybridAdService", "Showing fullscreen native ad...");
            }
            this.f58896a.e().a(new b(heVar, this.f58896a, maxAdapterListener));
            activity.startActivity(new Intent(activity, (Class<?>) MaxHybridNativeAdActivity.class));
            return;
        }
        if (heVar.y() != null) {
            this.f58896a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58896a.I().a("MaxHybridAdService", "Showing fullscreen MREC ad...");
            }
            this.f58896a.e().a(new a(heVar, this.f58896a, maxAdapterListener));
            activity.startActivity(new Intent(activity, (Class<?>) MaxHybridMRecAdActivity.class));
            return;
        }
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
        } else {
            if (!(maxAdapterListener instanceof MaxAppOpenAdapterListener)) {
                throw new IllegalStateException("Failed to display hybrid ad: neither native nor adview ad");
            }
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
        }
    }
}

package com.applovin.impl;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.common.cache.LSNn.vfptEEmYY;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f59678a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f59679b = true;

    public static void a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdClickListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.dw
            @Override // java.lang.Runnable
            public final void run() {
                fc.b(appLovinAdClickListener, appLovinAd);
            }
        });
    }

    public static void e(MaxAdListener maxAdListener, MaxAd maxAd) {
        e(maxAdListener, maxAd, false);
    }

    public static void f(MaxAdListener maxAdListener, MaxAd maxAd) {
        f(maxAdListener, maxAd, false);
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.hw
            @Override // java.lang.Runnable
            public final void run() {
                fc.c(appLovinAdDisplayListener, appLovinAd);
            }
        });
    }

    public static void b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.fw
            @Override // java.lang.Runnable
            public final void run() {
                fc.d(appLovinAdDisplayListener, appLovinAd);
            }
        });
    }

    public static void c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.wv
            @Override // java.lang.Runnable
            public final void run() {
                fc.f(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    public static void d(MaxAdListener maxAdListener, MaxAd maxAd) {
        d(maxAdListener, maxAd, false);
    }

    public static void e(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.kv
            @Override // java.lang.Runnable
            public final void run() {
                fc.e(z2, maxAdListener, maxAd);
            }
        });
    }

    public static void f(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.qv
            @Override // java.lang.Runnable
            public final void run() {
                fc.f(z2, maxAdListener, maxAd);
            }
        });
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.bw
            @Override // java.lang.Runnable
            public final void run() {
                fc.d(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    public static void b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ov
            @Override // java.lang.Runnable
            public final void run() {
                fc.e(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    public static void c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.jw
            @Override // java.lang.Runnable
            public final void run() {
                fc.f(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    public static void d(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.pv
            @Override // java.lang.Runnable
            public final void run() {
                fc.d(z2, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userOverQuota(a(appLovinAd), map);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardVerified(a(appLovinAd), map);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
        }
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i3) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.aw
            @Override // java.lang.Runnable
            public final void run() {
                fc.b(appLovinAdRewardListener, appLovinAd, i3);
            }
        });
    }

    public static void b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.lw
            @Override // java.lang.Runnable
            public final void run() {
                fc.e(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    public static void c(MaxAdListener maxAdListener, MaxAd maxAd) {
        c(maxAdListener, maxAd, false);
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mw
            @Override // java.lang.Runnable
            public final void run() {
                fc.b(appLovinAdVideoPlaybackListener, appLovinAd);
            }
        });
    }

    public static void b(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, final String str) {
        if (appLovinBidTokenCollectionListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.vv
                @Override // java.lang.Runnable
                public final void run() {
                    fc.d(appLovinBidTokenCollectionListener, str);
                }
            });
        }
    }

    public static void c(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.xv
            @Override // java.lang.Runnable
            public final void run() {
                fc.c(z2, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adHidden(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
            c("adHidden", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adLeftApplication(a(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adOpenedFullscreen(a(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
        }
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd, final double d3, final boolean z2) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.rv
            @Override // java.lang.Runnable
            public final void run() {
                fc.b(appLovinAdVideoPlaybackListener, appLovinAd, d3, z2);
            }
        });
    }

    public static void b(MaxAdListener maxAdListener, MaxAd maxAd) {
        b(maxAdListener, maxAd, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adDisplayed(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
            c("adDisplayed", th);
        }
    }

    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.lv
            @Override // java.lang.Runnable
            public final void run() {
                fc.d(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    public static void b(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.jv
            @Override // java.lang.Runnable
            public final void run() {
                fc.b(z2, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxAdListener.onAdHidden(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdHidden", th, z2);
                c("maxAdHidden", th);
                return;
            }
        }
        maxAdListener.onAdHidden(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxAdListener.onAdLoaded(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdLoaded", th, z2);
                c("maxAdLoaded", th);
                return;
            }
        }
        maxAdListener.onAdLoaded(maxAd);
    }

    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.iv
            @Override // java.lang.Runnable
            public final void run() {
                fc.b(appLovinAdViewEventListener, appLovinAd, appLovinAdView, appLovinAdViewDisplayErrorCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardRejected(a(appLovinAd), map);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
        }
    }

    public static void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, final String str) {
        if (appLovinBidTokenCollectionListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ew
                @Override // java.lang.Runnable
                public final void run() {
                    fc.c(appLovinBidTokenCollectionListener, str);
                }
            });
        }
    }

    public static void b(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.mv
            @Override // java.lang.Runnable
            public final void run() {
                fc.b(z2, maxNativeAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, String str) {
        try {
            appLovinBidTokenCollectionListener.onBidTokenCollected(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify bid token listener about successful bid token collection", th);
            c("onBidTokenCollected", th);
        }
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof pb) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.hv
                @Override // java.lang.Runnable
                public final void run() {
                    fc.b(appLovinAdDisplayListener, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdClickListener.adClicked(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
            c("adClicked", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adClosedFullscreen(a(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
        }
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd) {
        a(maxAdListener, maxAd, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxAdListener.onAdDisplayed(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdDisplayed", th, z2);
                c("maxAdDisplayed", th);
                return;
            }
        }
        maxAdListener.onAdDisplayed(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, String str) {
        try {
            appLovinBidTokenCollectionListener.onBidTokenCollectionFailed(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify bid token listener about bid token collection failure", th);
            c("onBidTokenCollectionFailed", th);
        }
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.uv
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i3) {
        try {
            appLovinAdRewardListener.validationRequestFailed(a(appLovinAd), i3);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
        }
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        a(maxAdListener, maxAd, maxError, false);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxError maxError, final boolean z2) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.tv
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxAdListener, maxAd, maxError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackBegan(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdExpanded", th, z2);
                return;
            }
        }
        ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
    }

    public static void a(MaxAdListener maxAdListener, String str, MaxError maxError) {
        a(maxAdListener, str, maxError, false);
    }

    public static void a(final MaxAdListener maxAdListener, final String str, final MaxError maxError, final boolean z2) {
        if (str == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.gw
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxAdListener, str, maxError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d3, boolean z2) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackEnded(a(appLovinAd), d3, z2);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
        }
    }

    private static boolean c(boolean z2) {
        return z2 ? f59678a : f59679b;
    }

    public static void a(MaxAdRequestListener maxAdRequestListener, String str) {
        a(maxAdRequestListener, str, false);
    }

    private static void c(String str, Throwable th) {
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f63329u0;
        if (jVar != null) {
            jVar.D().a("ListenerCallbackInvoker", str, th);
        }
    }

    public static void a(final MaxAdRequestListener maxAdRequestListener, final String str, final boolean z2) {
        if (str == null || maxAdRequestListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.fv
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxAdRequestListener, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        try {
            appLovinAdViewEventListener.adFailedToDisplay(a(appLovinAd), appLovinAdView, appLovinAdViewDisplayErrorCode);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about display failed event", th);
        }
    }

    public static void a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        a(maxAdRevenueListener, maxAd, false);
    }

    public static void a(final MaxAdRevenueListener maxAdRevenueListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxAdRevenueListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.cv
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxAdRevenueListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdDisplayListener appLovinAdDisplayListener, String str) {
        ((pb) appLovinAdDisplayListener).onAdDisplayFailed(str);
    }

    public static void a(final MaxAdExpirationListener maxAdExpirationListener, final MaxAd maxAd, final MaxAd maxAd2, final boolean z2) {
        if (maxAd == null || maxAd2 == null || maxAdExpirationListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.yv
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxAdExpirationListener, maxAd, maxAd2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdCollapsed", th, z2);
                return;
            }
        }
        ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.kw
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxNativeAdListener, maxAd);
            }
        });
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final String str, final MaxError maxError, final boolean z2) {
        if (str == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.gv
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxNativeAdListener, str, maxError);
            }
        });
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxNativeAdView maxNativeAdView, final MaxAd maxAd, final boolean z2) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.ev
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxNativeAdListener, maxNativeAdView, maxAd);
            }
        });
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        a(maxAdListener, maxAd, maxReward, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z2, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxNativeAdListener.onNativeAdExpired(maxAd);
                return;
            } catch (Throwable th) {
                a("onNativeAdExpired", th, z2);
                c("maxNativeAdExpired", th);
                return;
            }
        }
        maxNativeAdListener.onNativeAdExpired(maxAd);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward, final boolean z2) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.dv
            @Override // java.lang.Runnable
            public final void run() {
                fc.a(z2, maxAdListener, maxAd, maxReward);
            }
        });
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i3) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.zv
                @Override // java.lang.Runnable
                public final void run() {
                    fc.b(appLovinPostbackListener, str, i3);
                }
            });
        }
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sv
                @Override // java.lang.Runnable
                public final void run() {
                    fc.b(appLovinPostbackListener, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxAdListener.onAdClicked(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdClicked", th, z2);
                c("maxAdClicked", th);
                return;
            }
        }
        maxAdListener.onAdClicked(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str, int i3) {
        try {
            appLovinPostbackListener.onPostbackFailure(str, i3);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c(vfptEEmYY.RcJumKSFXZjOgG, "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") failing to execute with error code (" + i3 + "):", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str) {
        try {
            appLovinPostbackListener.onPostbackSuccess(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") executed", th);
        }
    }

    public static void b(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        a(maxAdReviewListener, str, maxAd, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        if (c(z2)) {
            try {
                maxAdListener.onAdDisplayFailed(maxAd, maxError);
                return;
            } catch (Throwable th) {
                a("onAdDisplayFailed", th, z2);
                c("maxAdDisplayFailed", th);
                return;
            }
        }
        maxAdListener.onAdDisplayFailed(maxAd, maxError);
    }

    public static void b(final AppLovinNativeAdEventListener appLovinNativeAdEventListener, final AppLovinNativeAd appLovinNativeAd) {
        if (appLovinNativeAdEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.cw
                @Override // java.lang.Runnable
                public final void run() {
                    fc.a(appLovinNativeAdEventListener, appLovinNativeAd);
                }
            });
        }
    }

    public static void b(final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, final AppLovinError appLovinError) {
        if (appLovinNativeAdLoadListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.nv
                @Override // java.lang.Runnable
                public final void run() {
                    fc.a(appLovinNativeAdLoadListener, appLovinError);
                }
            });
        }
    }

    public static void b(boolean z2) {
        f59678a = z2;
    }

    private static void b(String str, Throwable th) {
        com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Error in publisher callback '" + str + "'", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxAdListener maxAdListener, String str, MaxError maxError) {
        if (c(z2)) {
            try {
                maxAdListener.onAdLoadFailed(str, maxError);
                return;
            } catch (Throwable th) {
                a("onAdLoadFailed", th, z2);
                c("maxAdLoadFailed", th);
                return;
            }
        }
        maxAdListener.onAdLoadFailed(str, maxError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxAdRequestListener maxAdRequestListener, String str) {
        if (c(z2)) {
            try {
                maxAdRequestListener.onAdRequestStarted(str);
                return;
            } catch (Throwable th) {
                a("onAdRequestStarted", th, z2);
                c("maxAdRequestStarted", th);
                return;
            }
        }
        maxAdRequestListener.onAdRequestStarted(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxAdRevenueListener.onAdRevenuePaid(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdRevenuePaid", th, z2);
                c("maxAdPaidRevenue", th);
                return;
            }
        }
        maxAdRevenueListener.onAdRevenuePaid(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxAdExpirationListener maxAdExpirationListener, MaxAd maxAd, MaxAd maxAd2) {
        if (c(z2)) {
            try {
                maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
                return;
            } catch (Throwable th) {
                a("onExpiredAdReloaded", th, z2);
                c("maxExpiredAdReloaded", th);
                return;
            }
        }
        maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxNativeAdListener.onNativeAdClicked(maxAd);
                return;
            } catch (Throwable th) {
                a("onNativeAdClicked", th, z2);
                c("maxNativeAdClicked", th);
                return;
            }
        }
        maxNativeAdListener.onNativeAdClicked(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxNativeAdListener maxNativeAdListener, String str, MaxError maxError) {
        if (c(z2)) {
            try {
                maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
                return;
            } catch (Throwable th) {
                a("onNativeAdLoadFailed", th, z2);
                c("maxNativeAdLoadFailed", th);
                return;
            }
        }
        maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxNativeAdListener maxNativeAdListener, MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (c(z2)) {
            try {
                maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
                return;
            } catch (Throwable th) {
                a("onNativeAdLoaded", th, z2);
                c("maxNativeAdLoaded", th);
                return;
            }
        }
        maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        if (c(z2)) {
            try {
                ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
                return;
            } catch (Throwable th) {
                a("onUserRewarded", th, z2);
                c("maxRewardedUser", th);
                return;
            }
        }
        ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        try {
            maxAdReviewListener.onCreativeIdGenerated(str, maxAd);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify Ad Review creative id generated", th);
            c("adReviewCreativeIdGenerated", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppLovinNativeAdEventListener appLovinNativeAdEventListener, AppLovinNativeAd appLovinNativeAd) {
        try {
            appLovinNativeAdEventListener.onNativeAdClicked(appLovinNativeAd);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad click", th);
            c("nativeAdClicked", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, AppLovinError appLovinError) {
        try {
            appLovinNativeAdLoadListener.onNativeAdLoadFailed(appLovinError);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad failing to load", th);
            c("nativeAdLoadFailed", th);
        }
    }

    private static void a(String str, Throwable th, boolean z2) {
        if (z2) {
            b(str, th);
        } else {
            a(str, th);
        }
    }

    public static void a(final MaxAdReviewListener maxAdReviewListener, final String str, final MaxAd maxAd, boolean z2) {
        if (maxAdReviewListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new Runnable() { // from class: com.applovin.impl.iw
                @Override // java.lang.Runnable
                public final void run() {
                    fc.a(maxAdReviewListener, str, maxAd);
                }
            });
        }
    }

    private static AppLovinAd a(AppLovinAd appLovinAd) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        return appLovinAdImpl.getDummyAd() != null ? appLovinAdImpl.getDummyAd() : appLovinAd;
    }

    public static void a(boolean z2) {
        f59679b = z2;
    }

    private static void a(String str, Throwable th) {
        com.applovin.impl.sdk.n.b("ListenerCallbackInvoker", "Error in internal callback '" + str + "'", th);
    }
}

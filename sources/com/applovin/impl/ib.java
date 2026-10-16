package com.applovin.impl;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ib {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f60416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AppLovinAdServiceImpl f60417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAd f60418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f60419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SoftReference f60420f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f60422h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f60415a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f60421g = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f60423i = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements AppLovinAdRewardListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            ib.this.f60416b.I();
            if (com.applovin.impl.sdk.n.a()) {
                ib.this.f60416b.I().b("IncentivizedAdController", "User over quota: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            ib.this.f60416b.I();
            if (com.applovin.impl.sdk.n.a()) {
                ib.this.f60416b.I().b("IncentivizedAdController", "Reward rejected: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i3) {
            ib.this.f60416b.I();
            if (com.applovin.impl.sdk.n.a()) {
                ib.this.f60416b.I().b("IncentivizedAdController", "Reward validation failed: " + i3);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            ib.this.f60416b.I();
            if (com.applovin.impl.sdk.n.a()) {
                ib.this.f60416b.I().a(vgWWUoTKYyuC.JyxczsSEJEKcHkv, "Reward validated: " + map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements AppLovinAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinAdLoadListener f60425a;

        b(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f60425a = appLovinAdLoadListener;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(final AppLovinAd appLovinAd) {
            ib.this.f60418d = appLovinAd;
            if (this.f60425a != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.zx
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65495a.a(appLovinAd);
                    }
                });
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(final int i3) {
            if (this.f60425a != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ay
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58522a.a(i3);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(AppLovinAd appLovinAd) {
            try {
                this.f60425a.adReceived(appLovinAd);
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                ib.this.f60416b.D().a("IncentivizedAdController", "adLoaded", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i3) {
            try {
                this.f60425a.failedToReceiveAd(i3);
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                ib.this.f60416b.D().a("IncentivizedAdController", "adLoadFailed", th);
            }
        }
    }

    public ib(String str, AppLovinSdk appLovinSdk) {
        this.f60416b = appLovinSdk.a();
        this.f60417c = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f60419e = str;
    }

    private void e() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference softReference = this.f60420f;
        if (softReference == null || (appLovinAdLoadListener = (AppLovinAdLoadListener) softReference.get()) == null) {
            return;
        }
        appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
    }

    public String c() {
        return this.f60419e;
    }

    public boolean d() {
        return this.f60418d != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        String str;
        synchronized (this.f60421g) {
            str = this.f60422h;
        }
        return str;
    }

    private void a(AppLovinAd appLovinAd, String str, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, pb pbVar) {
        this.f60416b.C().c(ba.f58617o);
        fc.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        fc.a(pbVar, str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c implements pb, AppLovinAdVideoPlaybackListener, AppLovinAdRewardListener, AppLovinAdClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinAd f60427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppLovinAdDisplayListener f60428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AppLovinAdClickListener f60429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AppLovinAdVideoPlaybackListener f60430d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AppLovinAdRewardListener f60431f;

        private c(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f60427a = appLovinAd;
            this.f60428b = appLovinAdDisplayListener;
            this.f60429c = appLovinAdClickListener;
            this.f60430d = appLovinAdVideoPlaybackListener;
            this.f60431f = appLovinAdRewardListener;
        }

        private void a(com.applovin.impl.sdk.ad.b bVar) {
            String str;
            int i3;
            ib.this.f60416b.I();
            if (com.applovin.impl.sdk.n.a()) {
                ib.this.f60416b.I().a("IncentivizedAdController", "Finishing direct ad...");
            }
            String strB = ib.this.b();
            if (!StringUtils.isValidString(strB) || !ib.this.f60423i) {
                ib.this.f60416b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    ib.this.f60416b.I().b("IncentivizedAdController", "Invalid reward state - result: " + strB + " and wasFullyEngaged: " + ib.this.f60423i);
                }
                ib.this.f60416b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    ib.this.f60416b.I().a("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                }
                bVar.c();
                if (ib.this.f60423i) {
                    ib.this.f60416b.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        ib.this.f60416b.I().b("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    }
                    str = "network_timeout";
                    i3 = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                } else {
                    ib.this.f60416b.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        ib.this.f60416b.I().b("IncentivizedAdController", "User close the ad prematurely");
                    }
                    str = "user_closed_video";
                    i3 = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                }
                bVar.a(eh.a(str));
                ib.this.f60416b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    ib.this.f60416b.I().a("IncentivizedAdController", "Notifying listener of reward validation failure");
                }
                fc.a(this.f60431f, bVar, i3);
            }
            if (bVar.H0().getAndSet(true)) {
                return;
            }
            ib.this.f60416b.I();
            if (com.applovin.impl.sdk.n.a()) {
                ib.this.f60416b.I().a("IncentivizedAdController", "Scheduling report rewarded ad...");
            }
            ib.this.f60416b.i0().a((yl) new en(bVar, ib.this.f60416b), tm.b.OTHER);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            fc.a(this.f60429c, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            fc.a(this.f60428b, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            String str;
            AppLovinAd appLovinAdF = appLovinAd instanceof com.applovin.impl.sdk.ad.c ? ((com.applovin.impl.sdk.ad.c) appLovinAd).f() : appLovinAd;
            if (appLovinAdF instanceof com.applovin.impl.sdk.ad.b) {
                a((com.applovin.impl.sdk.ad.b) appLovinAdF);
            } else {
                if (appLovinAdF == null) {
                    str = "null/expired ad";
                } else {
                    str = "invalid ad of type: " + appLovinAdF;
                }
                ib.this.f60416b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    ib.this.f60416b.I().b("IncentivizedAdController", "Received `adHidden` callback for " + str);
                }
            }
            ib.this.a(appLovinAdF);
            ib.this.f60416b.I();
            if (com.applovin.impl.sdk.n.a()) {
                ib.this.f60416b.I().a("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            }
            fc.b(this.f60428b, appLovinAd);
        }

        @Override // com.applovin.impl.pb
        public void onAdDisplayFailed(String str) {
            String str2;
            AppLovinAd appLovinAdF = this.f60427a;
            if (appLovinAdF instanceof com.applovin.impl.sdk.ad.c) {
                appLovinAdF = ((com.applovin.impl.sdk.ad.c) appLovinAdF).f();
            }
            boolean z2 = this.f60428b instanceof pb;
            if (appLovinAdF instanceof com.applovin.impl.sdk.ad.b) {
                a((com.applovin.impl.sdk.ad.b) appLovinAdF);
            } else {
                if (appLovinAdF == null) {
                    str2 = "null/expired ad";
                } else {
                    str2 = "invalid ad of type: " + appLovinAdF;
                }
                ib.this.f60416b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    com.applovin.impl.sdk.n nVarI = ib.this.f60416b.I();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Received `");
                    sb.append(z2 ? "adDisplayFailed" : "adHidden");
                    sb.append("` callback for ");
                    sb.append(str2);
                    nVarI.b("IncentivizedAdController", sb.toString());
                }
            }
            ib.this.a(appLovinAdF);
            if (z2) {
                fc.a(this.f60428b, str);
            } else {
                fc.b(this.f60428b, this.f60427a);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            ib.this.a("quota_exceeded");
            fc.b(this.f60431f, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            ib.this.a("rejected");
            fc.a(this.f60431f, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            ib.this.a("accepted");
            fc.c(this.f60431f, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i3) {
            ib.this.a("network_timeout");
            fc.a(this.f60431f, appLovinAd, i3);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            fc.a(this.f60430d, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d3, boolean z2) {
            fc.a(this.f60430d, appLovinAd, d3, z2);
            ib.this.f60423i = z2;
        }

        /* synthetic */ c(ib ibVar, AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener, a aVar) {
            this(appLovinAd, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        }
    }

    public void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f60416b.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f60416b.I().a("IncentivizedAdController", "User requested preload of incentivized ad...");
        }
        this.f60420f = new SoftReference(appLovinAdLoadListener);
        if (d()) {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f60418d);
                return;
            }
            return;
        }
        a(new b(appLovinAdLoadListener));
    }

    private void a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.f60418d;
        }
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        if (appLovinAdImpl2 != null) {
            a(appLovinAdImpl2, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
        }
    }

    public void b(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = a();
        }
        a(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    private void a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.f60418d;
        }
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        if (appLovinAdImpl2 != null) {
            a(appLovinAdImpl2, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
        }
    }

    private void a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        c cVar = new c(this, appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
        AppLovinAd appLovinAdA = yp.a(appLovinAdImpl, this.f60416b);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, cVar, cVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.f60416b.q0(), context);
        for (String str : this.f60415a.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.f60415a.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(cVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA);
        a((com.applovin.impl.sdk.ad.b) appLovinAdA, cVar);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        c cVar = new c(this, appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
        AppLovinAd appLovinAdA = yp.a(appLovinAdImpl, this.f60416b);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, cVar, cVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.f60416b.q0(), context);
        for (String str : this.f60415a.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.f60415a.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(cVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA, viewGroup, lifecycle);
        a((com.applovin.impl.sdk.ad.b) appLovinAdA, cVar);
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f60416b.i0().a((yl) new kn(bVar, appLovinAdRewardListener, this.f60416b), tm.b.OTHER);
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f60417c.loadNextIncentivizedAd(this.f60419e, appLovinAdLoadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f60418d;
        if (appLovinAd2 == null) {
            return;
        }
        if (!(appLovinAd2 instanceof com.applovin.impl.sdk.ad.c)) {
            if (appLovinAd == appLovinAd2) {
                this.f60418d = null;
            }
        } else {
            com.applovin.impl.sdk.ad.c cVar = (com.applovin.impl.sdk.ad.c) appLovinAd2;
            if (cVar.f() == null || appLovinAd == cVar.f()) {
                this.f60418d = null;
            }
        }
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2) {
        if (appLovinAd == null) {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.: " + appLovinAd2);
            return "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.";
        }
        if (appLovinAd2.getType() == AppLovinAdType.INCENTIVIZED || appLovinAd2.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            return null;
        }
        com.applovin.impl.sdk.n.h("IncentivizedAdController", "Attempting to display ad with invalid ad type: " + appLovinAd2.getType());
        return "Attempting to display ad with invalid ad type";
    }

    public void a(String str, Object obj) {
        this.f60415a.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f60421g) {
            this.f60422h = str;
        }
    }

    public void a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = a();
        }
        a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    private AppLovinAdRewardListener a() {
        return new a();
    }
}

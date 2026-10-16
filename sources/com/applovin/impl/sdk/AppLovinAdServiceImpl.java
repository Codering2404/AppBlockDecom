package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.e4;
import com.applovin.impl.fc;
import com.applovin.impl.i8;
import com.applovin.impl.ka;
import com.applovin.impl.o9;
import com.applovin.impl.om;
import com.applovin.impl.qb;
import com.applovin.impl.qm;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.tp;
import com.applovin.impl.uj;
import com.applovin.impl.um;
import com.applovin.impl.w;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.zq;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinAdServiceImpl implements AppLovinAdService, a.InterfaceC0121a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f63097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f63098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f63099d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f63100e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference f63101f = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements ArrayService.DirectDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.ad.b f63102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f63103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o9 f63104c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f63105d;

        a(com.applovin.impl.sdk.ad.b bVar, Uri uri, o9 o9Var, Context context) {
            this.f63102a = bVar;
            this.f63103b = uri;
            this.f63104c = o9Var;
            this.f63105d = context;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDismissed() {
            AppLovinAdServiceImpl.this.f63096a.e0().resumeForClick();
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDisplayed() {
            AppLovinAdServiceImpl.this.f63096a.e0().pauseForClick();
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            n unused = AppLovinAdServiceImpl.this.f63097b;
            if (n.a()) {
                AppLovinAdServiceImpl.this.f63097b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.f63102a, this.f63103b, this.f63104c, this.f63105d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements ArrayService.DirectDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.adview.a f63107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.ad.b f63108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppLovinAdView f63109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f63110d;

        b(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri) {
            this.f63107a = aVar;
            this.f63108b = bVar;
            this.f63109c = appLovinAdView;
            this.f63110d = uri;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDismissed() {
            if (this.f63107a != null) {
                AppLovinAdServiceImpl.this.f63096a.e0().resumeForClick();
                fc.a(this.f63107a.e(), this.f63108b, this.f63109c);
            }
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDisplayed() {
            AppLovinAdServiceImpl.this.f63096a.e0().pauseForClick();
            com.applovin.impl.adview.a aVar = this.f63107a;
            if (aVar != null) {
                aVar.x();
                fc.c(this.f63107a.e(), this.f63108b, this.f63109c);
            }
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            n unused = AppLovinAdServiceImpl.this.f63097b;
            if (n.a()) {
                AppLovinAdServiceImpl.this.f63097b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.f63108b, this.f63109c, this.f63107a, this.f63110d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements qb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f63112a;

        /* synthetic */ c(AppLovinAdServiceImpl appLovinAdServiceImpl, d dVar, a aVar) {
            this(dVar);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.f63096a.h().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.f63096a.f().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new com.applovin.impl.sdk.ad.c(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.f63096a);
            }
            Collection hashSet = Collections.EMPTY_SET;
            synchronized (this.f63112a.f63114a) {
                try {
                    if (!this.f63112a.f63116c) {
                        hashSet = new HashSet(this.f63112a.f63117d);
                        this.f63112a.f63117d.clear();
                    }
                    d dVar = this.f63112a;
                    dVar.f63115b = false;
                    dVar.f63116c = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.a(appLovinAd, (AppLovinAdLoadListener) it.next());
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i3) {
            failedToReceiveAdV2(new AppLovinError(i3, ""));
        }

        @Override // com.applovin.impl.qb
        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            Collection hashSet = Collections.EMPTY_SET;
            synchronized (this.f63112a.f63114a) {
                try {
                    if (!this.f63112a.f63116c) {
                        hashSet = new HashSet(this.f63112a.f63117d);
                        this.f63112a.f63117d.clear();
                    }
                    d dVar = this.f63112a;
                    dVar.f63115b = false;
                    dVar.f63116c = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.b(appLovinError, (AppLovinAdLoadListener) it.next());
            }
        }

        private c(d dVar) {
            this.f63112a = dVar;
        }
    }

    AppLovinAdServiceImpl(j jVar) {
        this.f63096a = jVar;
        this.f63097b = jVar.I();
        HashMap map = new HashMap(6);
        this.f63098c = map;
        a aVar = null;
        map.put(com.applovin.impl.h0.c(), new d(aVar));
        map.put(com.applovin.impl.h0.k(), new d(aVar));
        map.put(com.applovin.impl.h0.j(), new d(aVar));
        map.put(com.applovin.impl.h0.m(), new d(aVar));
        map.put(com.applovin.impl.h0.b(), new d(aVar));
        map.put(com.applovin.impl.h0.h(), new d(aVar));
    }

    public void addCustomQueryParams(Map<String, String> map) {
        this.f63100e.putAll(map);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void collectBidToken(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "collectBidToken(listener=" + appLovinBidTokenCollectionListener + ")");
        }
        this.f63096a.x().a(appLovinBidTokenCollectionListener);
    }

    public AppLovinAd dequeueAd(com.applovin.impl.h0 h0Var) {
        AppLovinAdImpl appLovinAdImplA = this.f63096a.h().a(h0Var);
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Dequeued ad: " + appLovinAdImplA + " for zone: " + h0Var + "...");
        }
        return appLovinAdImplA;
    }

    public JSONObject getAndResetCustomPostBody() {
        return (JSONObject) this.f63101f.getAndSet(null);
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        Map<String, String> map;
        synchronized (this.f63100e) {
            map = CollectionUtils.map(this.f63100e);
            this.f63100e.clear();
        }
        return map;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public String getBidToken() {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "getBidToken()");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String strD = this.f63096a.x().D();
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        if (StringUtils.isValidString(strD) && n.a()) {
            this.f63097b.a("AppLovinAdService", "Successfully retrieved bid token");
        }
        return strD;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(com.applovin.impl.h0.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForAdToken(String str, final AppLovinAdLoadListener appLovinAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            n.h("AppLovinAdService", "Empty ad token");
            c(new AppLovinError(-8, "Empty ad token"), appLovinAdLoadListener);
            return;
        }
        com.applovin.impl.w wVar = new com.applovin.impl.w(strTrim, this.f63096a);
        if (wVar.c() == w.a.REGULAR) {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Loading next ad for token: " + wVar);
            }
            a(new qm(wVar, appLovinAdLoadListener, this.f63096a));
            return;
        }
        if (wVar.c() != w.a.AD_RESPONSE_JSON) {
            AppLovinError appLovinError = new AppLovinError(-8, "Invalid token type");
            n.h("AppLovinAdService", "Invalid token type");
            c(appLovinError, appLovinAdLoadListener);
            return;
        }
        final JSONObject jSONObjectA = wVar.a();
        if (jSONObjectA == null) {
            String str2 = "Unable to retrieve ad response JSON from token: " + wVar.b();
            AppLovinError appLovinError2 = new AppLovinError(-8, str2);
            n.h("AppLovinAdService", str2);
            c(appLovinError2, appLovinAdLoadListener);
            return;
        }
        e4.c(jSONObjectA, this.f63096a);
        e4.b(jSONObjectA, this.f63096a);
        e4.a(jSONObjectA, this.f63096a);
        com.applovin.impl.u0.b(this.f63096a);
        if (JsonUtils.getJSONArray(jSONObjectA, "ads", new JSONArray()).length() <= 0) {
            if (n.a()) {
                this.f63097b.b("AppLovinAdService", "No ad returned from the server for token: " + wVar);
            }
            c(AppLovinError.NO_FILL, appLovinAdLoadListener);
            return;
        }
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Rendering ad for token: " + wVar);
        }
        final com.applovin.impl.h0 h0VarA = yp.a(jSONObjectA, this.f63096a);
        MaxAdFormat maxAdFormatD = h0VarA.d();
        if (((Boolean) this.f63096a.a(sj.Y0)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f63096a.g().a(h0VarA, new d.a() { // from class: com.applovin.impl.sdk.t
                @Override // com.applovin.impl.sdk.d.a
                public final void a(com.applovin.impl.sdk.ad.b bVar) {
                    this.f63599a.a(appLovinAdLoadListener, jSONObjectA, h0VarA, bVar);
                }
            });
        } else {
            a(new um(jSONObjectA, h0VarA, appLovinAdLoadListener, this.f63096a));
        }
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No zone id specified");
        }
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Loading next ad of zone {" + str + "}");
        }
        a(com.applovin.impl.h0.a(str), appLovinAdLoadListener);
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(com.applovin.impl.h0.b(str), appLovinAdLoadListener);
    }

    public void maybeFireAppKilledWhilePlayingAdPostback() {
        Long l3;
        if (((Boolean) this.f63096a.a(sj.f63744g2)).booleanValue() && (l3 = (Long) this.f63096a.b(uj.M)) != null && System.currentTimeMillis() - l3.longValue() <= ((Long) this.f63096a.a(sj.f63760k2)).longValue()) {
            if (((Boolean) this.f63096a.a(sj.f63756j2)).booleanValue() || b()) {
                a();
            }
        }
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.s> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.applovin.impl.s> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0121a
    public void onAdExpired(i8 i8Var) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) i8Var;
        com.applovin.impl.h0 adZone = appLovinAdImpl.getAdZone();
        if (n.a()) {
            this.f63097b.k("AppLovinAdService", "Ad expired for zone: " + adZone);
        }
        this.f63096a.h().b(appLovinAdImpl);
        if (this.f63096a.y0() || !((Boolean) this.f63096a.a(sj.f63735e1)).booleanValue()) {
            return;
        }
        d dVarA = a(adZone);
        synchronized (dVarA.f63114a) {
            try {
                if (!dVarA.f63115b) {
                    this.f63096a.I();
                    if (n.a()) {
                        this.f63096a.I().a("AppLovinAdService", "Reloading ad after expiration for zone {" + adZone + "}...");
                    }
                    dVarA.f63115b = true;
                    dVarA.f63116c = true;
                    a(adZone, new c(this, dVarA, null));
                } else if (n.a()) {
                    this.f63097b.a("AppLovinAdService", "Cancelled expired ad reload. Already waiting on an ad load...");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.f63101f.set(jSONObject);
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.f63098c + '}';
    }

    public void trackAndLaunchClick(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri, MotionEvent motionEvent, boolean z2, Bundle bundle) {
        if (bVar == null) {
            if (n.a()) {
                this.f63097b.b("AppLovinAdService", "Unable to track ad view click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Tracking click on an ad...");
            }
            boolean z3 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.b(motionEvent, z2, z3));
            if (this.f63096a.Y() != null) {
                this.f63096a.Y().b(bVar.d(motionEvent, false, z3), motionEvent);
            }
        } else if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Skipping tracking for click on an ad...");
        }
        if (appLovinAdView == null || uri == null) {
            if (n.a()) {
                this.f63097b.b("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
            }
        } else if (bVar.isDirectDownloadEnabled()) {
            this.f63096a.n().startDirectInstallOrDownloadProcess(bVar, bundle, new b(aVar, bVar, appLovinAdView, uri));
        } else {
            a(bVar, appLovinAdView, aVar, uri);
        }
    }

    public void trackAndLaunchVideoClick(com.applovin.impl.sdk.ad.b bVar, Uri uri, MotionEvent motionEvent, Bundle bundle, o9 o9Var, Context context) {
        if (bVar == null) {
            if (n.a()) {
                this.f63097b.b("AppLovinAdService", "Unable to track video click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Tracking VIDEO click on an ad...");
            }
            boolean z2 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.a(motionEvent, z2));
            if (this.f63096a.Y() != null) {
                this.f63096a.Y().b(bVar.d(motionEvent, true, z2), motionEvent);
            }
        } else if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Skipping tracking for VIDEO click on an ad...");
        }
        if (bVar.isDirectDownloadEnabled()) {
            this.f63096a.n().startDirectInstallOrDownloadProcess(bVar, bundle, new a(bVar, uri, o9Var, context));
        } else {
            a(bVar, uri, o9Var, context);
        }
    }

    public void trackCustomTabsNavigationAborted(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking Custom Tabs navigation aborted on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.t());
    }

    public void trackCustomTabsNavigationFailed(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking Custom Tabs navigation failed on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.u());
    }

    public void trackCustomTabsNavigationFinished(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking Custom Tabs navigation finished on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.v());
    }

    public void trackCustomTabsNavigationStarted(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking Custom Tabs navigation started on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.w());
    }

    public void trackCustomTabsTabHidden(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking Custom Tabs tab hidden on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.y());
    }

    public void trackCustomTabsTabShown(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking Custom Tabs tab shown on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.z());
    }

    public void trackFullScreenAdClosed(com.applovin.impl.sdk.ad.b bVar, long j3, List<Long> list, long j4, boolean z2, int i3) {
        if (bVar == null) {
            if (n.a()) {
                this.f63097b.b("AppLovinAdService", "Unable to track ad closed. No ad specified.");
                return;
            }
            return;
        }
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking ad closed...");
        }
        List<com.applovin.impl.s> listD = bVar.d();
        if (listD == null || listD.isEmpty()) {
            if (n.a()) {
                this.f63097b.k("AppLovinAdService", "Unable to track ad closed for AD #" + bVar.getAdIdNumber() + ". Missing ad close tracking URL." + bVar.getAdIdNumber());
                return;
            }
            return;
        }
        for (com.applovin.impl.s sVar : listD) {
            String strA = a(sVar.c(), j3, j4, list, z2, i3);
            String strA2 = a(sVar.a(), j3, j4, list, z2, i3);
            if (StringUtils.isValidString(strA)) {
                a(new com.applovin.impl.s(strA, strA2));
            } else if (n.a()) {
                this.f63097b.b("AppLovinAdService", "Failed to parse url: " + sVar.c());
            }
        }
    }

    public void trackImpression(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            if (n.a()) {
                this.f63097b.b("AppLovinAdService", "Unable to track impression click. No ad specified");
            }
        } else {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(bVar.F());
            if (this.f63096a.Y() != null) {
                this.f63096a.Y().b(bVar.getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    public void trackVideoEnd(com.applovin.impl.sdk.ad.b bVar, long j3, int i3, boolean z2) {
        if (bVar == null) {
            if (n.a()) {
                this.f63097b.b("AppLovinAdService", "Unable to track video end. No ad specified");
                return;
            }
            return;
        }
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking video end on ad...");
        }
        List<com.applovin.impl.s> listP0 = bVar.p0();
        if (listP0 == null || listP0.isEmpty()) {
            if (n.a()) {
                this.f63097b.k("AppLovinAdService", "Unable to submit persistent postback for AD #" + bVar.getAdIdNumber() + ". Missing video end tracking URL.");
                return;
            }
            return;
        }
        String string = Long.toString(System.currentTimeMillis());
        for (com.applovin.impl.s sVar : listP0) {
            if (StringUtils.isValidString(sVar.c())) {
                String strA = a(sVar.c(), j3, i3, string, z2);
                String strA2 = a(sVar.a(), j3, i3, string, z2);
                if (strA != null) {
                    a(new com.applovin.impl.s(strA, strA2));
                } else if (n.a()) {
                    this.f63097b.b("AppLovinAdService", "Failed to parse url: " + sVar.c());
                }
            } else if (n.a()) {
                this.f63097b.k("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }

    private void c(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener instanceof qb) {
            ((qb) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(com.applovin.impl.h0.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f63114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f63115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f63116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection f63117d;

        private d() {
            this.f63114a = new Object();
            this.f63117d = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.f63115b + ", isReloadingExpiredAd=" + this.f63116c + ", pendingAdListeners=" + this.f63117d + '}';
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    private void a(final com.applovin.impl.h0 h0Var, final c cVar) {
        AppLovinAdImpl appLovinAdImplE = this.f63096a.h().e(h0Var);
        if (appLovinAdImplE != null && !appLovinAdImplE.isExpired()) {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Using pre-loaded ad: " + appLovinAdImplE + " for " + h0Var);
            }
            cVar.adReceived(appLovinAdImplE);
            return;
        }
        MaxAdFormat maxAdFormatD = h0Var.d();
        if (((Boolean) this.f63096a.a(sj.Y0)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f63096a.g().a(h0Var, new d.a() { // from class: com.applovin.impl.sdk.r
                @Override // com.applovin.impl.sdk.d.a
                public final void a(com.applovin.impl.sdk.ad.b bVar) {
                    this.f63590a.a(cVar, h0Var, bVar);
                }
            });
        } else {
            a(new om(h0Var, cVar, this.f63096a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinError appLovinError, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f63605a.a(appLovinError, appLovinAdLoadListener);
            }
        });
    }

    private Uri b(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable th) {
            this.f63096a.I();
            if (n.a()) {
                this.f63096a.I().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            }
            this.f63096a.D().a("AppLovinAdService", "buildDeepLinkPlusUrl", th);
            return null;
        }
    }

    private boolean b() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        Context contextM = j.m();
        ApplicationExitInfo applicationExitInfoA = androidx.work.impl.utils.b.a(((ActivityManager) contextM.getSystemService("activity")).getHistoricalProcessExitReasons(contextM.getPackageName(), 0, 1).get(0));
        return applicationExitInfoA.getReason() == 10 || applicationExitInfoA.getReason() == 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final c cVar, com.applovin.impl.h0 h0Var, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.w
                @Override // java.lang.Runnable
                public final void run() {
                    cVar.adReceived(bVar);
                }
            });
        } else {
            a(new om(h0Var, cVar, this.f63096a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(o9 o9Var) {
        if (o9Var != null) {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Dismissing ad after forwarding click");
            }
            o9Var.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final AppLovinAdLoadListener appLovinAdLoadListener, JSONObject jSONObject, com.applovin.impl.h0 h0Var, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.x
                @Override // java.lang.Runnable
                public final void run() {
                    appLovinAdLoadListener.adReceived(bVar);
                }
            });
        } else {
            a(new um(jSONObject, h0Var, appLovinAdLoadListener, this.f63096a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, Uri uri, o9 o9Var, Context context) {
        if (a(uri.getScheme())) {
            a(uri, bVar, (com.applovin.impl.adview.a) null, o9Var);
        } else if (tp.b(uri)) {
            a(uri, bVar, (AppLovinAdView) null, (com.applovin.impl.adview.a) null, context, this.f63096a);
        } else {
            tp.a(uri, context, this.f63096a);
        }
    }

    private void a(com.applovin.impl.h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (h0Var == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        if (appLovinAdLoadListener != null) {
            this.f63096a.I();
            if (n.a()) {
                this.f63096a.I().a("AppLovinAdService", "Loading next ad of zone {" + h0Var + "}...");
            }
            d dVarA = a(h0Var);
            synchronized (dVarA.f63114a) {
                try {
                    dVarA.f63117d.add(appLovinAdLoadListener);
                    if (!dVarA.f63115b) {
                        dVarA.f63115b = true;
                        a(h0Var, new c(this, dVarA, null));
                    } else if (n.a()) {
                        this.f63097b.a("AppLovinAdService", "Already waiting on an ad load...");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new IllegalArgumentException("No callback specified");
    }

    private void a(yl ylVar) {
        if (!this.f63096a.s0()) {
            n.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f63096a.c();
        this.f63096a.i0().a(ylVar, tm.b.CORE);
    }

    private void a(com.applovin.impl.s sVar) {
        if (StringUtils.isValidString(sVar.c())) {
            this.f63096a.W().e(com.applovin.impl.sdk.network.d.b().d(sVar.c()).a(StringUtils.isValidString(sVar.a()) ? sVar.a() : null).a(sVar.b()).a(false).b(sVar.d()).a());
        } else if (n.a()) {
            this.f63097b.k("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    private d a(com.applovin.impl.h0 h0Var) {
        d dVar;
        synchronized (this.f63099d) {
            try {
                dVar = (d) this.f63098c.get(h0Var);
                if (dVar == null) {
                    dVar = new d(null);
                    this.f63098c.put(h0Var, dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f63595a.a(appLovinAdLoadListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAdLoadListener appLovinAdLoadListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdLoadListener.adReceived(appLovinAd);
        } catch (Throwable th) {
            n.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            this.f63096a.D().a("AppLovinAdService", "notifyAdLoadedCallback", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        try {
            c(appLovinError, appLovinAdLoadListener);
        } catch (Throwable th) {
            n.c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            StringBuilder sb = new StringBuilder();
            sb.append("notifyAdLoadFailedCallback");
            sb.append(appLovinAdLoadListener instanceof qb ? "V2" : "");
            this.f63096a.D().a("AppLovinAdService", sb.toString(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri) {
        Context context;
        if (!((Boolean) this.f63096a.a(sj.B)).booleanValue() || (context = zq.a(appLovinAdView, this.f63096a)) == null) {
            context = appLovinAdView.getContext();
        }
        Context context2 = context;
        if (a(uri.getScheme())) {
            a(uri, bVar, aVar, (o9) null);
        } else if (tp.b(uri)) {
            a(uri, bVar, appLovinAdView, aVar, context2, this.f63096a);
        } else {
            a(uri, bVar, appLovinAdView, aVar, context2);
        }
    }

    private String a(String str, long j3, int i3, String str2, boolean z2) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i3 < 0 || i3 > 100) {
                i3 = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j3)).appendQueryParameter("pv", Integer.toString(i3)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z2)).build().toString();
        } catch (Throwable th) {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            }
            this.f63096a.D().a("AppLovinAdService", "buildVideoEndUrl", th);
            return null;
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context) {
        if (tp.a(uri, context, this.f63096a)) {
            fc.b(aVar.e(), bVar, appLovinAdView);
        }
        aVar.x();
    }

    private boolean a(String str) {
        String str2 = this.f63096a.f0().getExtraParameters().get("forwarding_click_scheme");
        return StringUtils.isValidString(str2) && StringUtils.isValidString(str) && str.equalsIgnoreCase(str2);
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.adview.a aVar, final o9 o9Var) {
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Forwarding click " + uri);
        }
        bVar.setMaxAdValue("forwarding_clicked_url", uri.toString());
        String str = this.f63096a.f0().getExtraParameters().get("close_ad_on_forwarding_click_scheme");
        if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
            if (o9Var != null) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63628a.a(o9Var);
                    }
                });
            } else {
                if (aVar == null || yp.a(bVar.getSize())) {
                    return;
                }
                if (n.a()) {
                    this.f63097b.a("AppLovinAdService", "Closing ad after forwarding click");
                }
                aVar.z();
            }
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, j jVar) {
        if (uri != null && StringUtils.isValidString(uri.getQuery())) {
            Uri uriB = b(uri, "primaryUrl");
            List listA = a(uri, "primaryTrackingUrl");
            Uri uriB2 = b(uri, "fallbackUrl");
            List listA2 = a(uri, "fallbackTrackingUrl");
            if (uriB == null && uriB2 == null) {
                jVar.I();
                if (n.a()) {
                    jVar.I().b("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
                    return;
                }
                return;
            }
            if (!a(uriB, "primary", listA, bVar, appLovinAdView, aVar, context, jVar)) {
                a(uriB2, "backup", listA2, bVar, appLovinAdView, aVar, context, jVar);
            }
            if (aVar != null) {
                aVar.x();
                return;
            }
            return;
        }
        jVar.I();
        if (n.a()) {
            jVar.I().b("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
        }
    }

    private boolean a(Uri uri, String str, List list, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, j jVar) {
        jVar.I();
        if (n.a()) {
            jVar.I().a("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean zA = tp.a(uri, context, jVar);
        if (zA) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jVar.X().dispatchPostbackAsync(((Uri) it.next()).toString(), null);
            }
            if (aVar != null) {
                fc.b(aVar.e(), bVar, appLovinAdView);
                return zA;
            }
        } else {
            jVar.I();
            if (n.a()) {
                jVar.I().b("AppLovinAdService", "URL failed to open");
            }
        }
        return zA;
    }

    private List a(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        Iterator<String> it = queryParameters.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Uri.parse(it.next()));
            } catch (Throwable th) {
                this.f63096a.I();
                if (n.a()) {
                    this.f63096a.I().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
                this.f63096a.D().a("AppLovinAdService", "buildDeepLinkPlusUrlList", th);
            }
        }
        return arrayList;
    }

    private String a(String str, long j3, long j4, List list, boolean z2, int i3) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j3)).appendQueryParameter("vs_ms", Long.toString(j4));
        if (list != null && list.size() > 0) {
            builderAppendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i3 != h.f63311i) {
            builderAppendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z2));
            builderAppendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(h.a(i3)));
        }
        return builderAppendQueryParameter.build().toString();
    }

    private void a() {
        Map<String, String> mapTryToStringMap;
        if (n.a()) {
            this.f63097b.a("AppLovinAdService", "Tracking app killed during ad from previous run.");
        }
        String str = (String) this.f63096a.b(uj.P);
        if (TextUtils.isEmpty(str)) {
            if (n.a()) {
                this.f63097b.a("AppLovinAdService", "Couldn't get last ad data. Tracking event with empty data.");
            }
            mapTryToStringMap = null;
        } else {
            mapTryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(str, new JSONObject()));
        }
        this.f63096a.D().a(ka.N, (Map) mapTryToStringMap);
        String str2 = (String) this.f63096a.b(uj.O);
        if (str2 != null) {
            JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(str2, null);
            String string = JsonUtils.getString(jSONObjectJsonObjectFromJsonString, "app_killed_postback_url", null);
            String string2 = JsonUtils.getString(jSONObjectJsonObjectFromJsonString, "app_killed_postback_backup_url", null);
            Long l3 = (Long) this.f63096a.b(uj.N);
            if (l3 != null) {
                string = StringUtils.appendQueryParameter(string, "imp_duration_ms", String.valueOf(l3));
                string2 = StringUtils.appendQueryParameter(string2, "imp_duration_ms", String.valueOf(l3));
            }
            a(new com.applovin.impl.s(string, string2));
            return;
        }
        if (n.a()) {
            this.f63097b.k("AppLovinAdService", "Unable to track app killed during ad from previous run. Missing app killed tracking URLs.");
        }
    }
}

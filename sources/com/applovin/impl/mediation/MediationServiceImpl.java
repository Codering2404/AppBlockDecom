package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.an;
import com.applovin.impl.ba;
import com.applovin.impl.fc;
import com.applovin.impl.fe;
import com.applovin.impl.fi;
import com.applovin.impl.fn;
import com.applovin.impl.he;
import com.applovin.impl.ka;
import com.applovin.impl.la;
import com.applovin.impl.ln;
import com.applovin.impl.me;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.mediation.g;
import com.applovin.impl.oe;
import com.applovin.impl.rm;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.ve;
import com.applovin.impl.we;
import com.applovin.impl.xj;
import com.applovin.impl.yj;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.zj;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f61449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final xj f61450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f61451d = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f61452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f61453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f61454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ zj f61455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ MaxAdFormat f61456e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ yj.a f61457f;

        a(g gVar, String str, long j3, zj zjVar, MaxAdFormat maxAdFormat, yj.a aVar) {
            this.f61452a = gVar;
            this.f61453b = str;
            this.f61454c = j3;
            this.f61455d = zjVar;
            this.f61456e = maxAdFormat;
            this.f61457f = aVar;
        }

        @Override // com.applovin.impl.mediation.g.c
        public void a(MaxError maxError) {
            com.applovin.impl.sdk.n unused = MediationServiceImpl.this.f61449b;
            if (com.applovin.impl.sdk.n.a()) {
                MediationServiceImpl.this.f61449b.b("MediationService", "Signal collection failed from: " + this.f61452a.g() + " for Ad Unit ID: " + this.f61453b + " with error message: \"" + maxError.getMessage() + "\"");
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.f61454c;
            yj yjVarA = yj.a(this.f61455d, this.f61452a, maxError, j3, jElapsedRealtime - j3);
            MediationServiceImpl.this.a(yjVarA, this.f61455d, this.f61452a);
            this.f61457f.a(yjVarA);
            this.f61452a.a();
        }

        @Override // com.applovin.impl.mediation.g.c
        public void onSignalCollected(String str) {
            com.applovin.impl.sdk.n unused = MediationServiceImpl.this.f61449b;
            if (com.applovin.impl.sdk.n.a()) {
                MediationServiceImpl.this.f61449b.a("MediationService", "Signal collection successful from: " + this.f61452a.g() + " for Ad Unit ID: " + this.f61453b + " with signal: \"" + str + "\"");
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.f61454c;
            long j4 = jElapsedRealtime - j3;
            yj yjVarA = yj.a(this.f61455d, this.f61452a, str, j3, j4);
            MediationServiceImpl.this.f61450c.a(yjVarA, this.f61455d, this.f61453b, this.f61456e);
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("network_name", this.f61455d.c(), map);
            CollectionUtils.putStringIfValid("adapter_class", this.f61455d.b(), map);
            CollectionUtils.putStringIfValid("adapter_version", this.f61452a.b(), map);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j4), map);
            CollectionUtils.putStringIfValid("ad_format", String.valueOf(this.f61456e.getLabel()), map);
            CollectionUtils.putStringIfValid("ad_unit_id", this.f61453b, map);
            MediationServiceImpl.this.f61448a.D().a(ka.f60973z, (Map) map);
            this.f61457f.a(yjVarA);
            this.f61452a.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ fi f61459a;

        b(fi fiVar) {
            this.f61459a = fiVar;
        }

        @Override // com.applovin.impl.mediation.g.c
        public void a(MaxError maxError) {
            this.f61459a.a(maxError);
        }

        @Override // com.applovin.impl.mediation.g.c
        public void onSignalCollected(String str) {
            this.f61459a.b(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f61461a;

        static {
            int[] iArr = new int[MaxAdapter.InitializationStatus.values().length];
            f61461a = iArr;
            try {
                iArr[MaxAdapter.InitializationStatus.DOES_NOT_APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61461a[MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61461a[MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61461a[MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f61461a[MaxAdapter.InitializationStatus.NOT_INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f61461a[MaxAdapter.InitializationStatus.INITIALIZING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class d implements MaxAdListener, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, a.InterfaceC0110a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fe f61462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a.InterfaceC0110a f61463b;

        public d(fe feVar, a.InterfaceC0110a interfaceC0110a) {
            this.f61462a = feVar;
            this.f61463b = interfaceC0110a;
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.f61462a.a(bundle);
            fc.b(this.f61463b, maxAd);
        }

        public void c(MaxAd maxAd, Bundle bundle) {
            this.f61462a.a(bundle);
            com.applovin.impl.sdk.n unused = MediationServiceImpl.this.f61449b;
            if (com.applovin.impl.sdk.n.a()) {
                MediationServiceImpl.this.f61449b.a("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f61462a, this.f61463b);
            if (!((Boolean) MediationServiceImpl.this.f61448a.a(ue.K7)).booleanValue() || this.f61462a.u().compareAndSet(false, true)) {
                MediationServiceImpl.this.f61448a.k().a(this.f61462a, g.c.SHOW);
                MediationServiceImpl.this.f61448a.C().c(ba.f58608f);
                MediationServiceImpl.this.f61448a.C().c(ba.f58611i);
                if (!maxAd.getFormat().isFullscreenAd()) {
                    MediationServiceImpl.this.f61448a.q().b(this.f61462a, "DID_DISPLAY");
                    fc.c(this.f61463b, maxAd);
                    return;
                }
                he heVar = (he) maxAd;
                if (heVar.q0()) {
                    MediationServiceImpl.this.f61448a.q().b(this.f61462a, "DID_DISPLAY");
                    MediationServiceImpl.this.f61448a.B().a(this.f61462a);
                    fc.c(this.f61463b, maxAd);
                    return;
                }
                com.applovin.impl.sdk.n unused2 = MediationServiceImpl.this.f61449b;
                if (com.applovin.impl.sdk.n.a()) {
                    com.applovin.impl.sdk.n nVar = MediationServiceImpl.this.f61449b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Received ad display callback before attempting show");
                    sb.append(heVar.Y() ? " for hybrid ad" : "");
                    nVar.k("MediationService", sb.toString());
                }
            }
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.f61462a.a(bundle);
            fc.d(this.f61463b, maxAd);
        }

        public void e(final MaxAd maxAd, Bundle bundle) {
            this.f61462a.a(bundle);
            MediationServiceImpl.this.f61448a.D().a(ka.K, this.f61462a);
            MediationServiceImpl.this.f61448a.k().a(this.f61462a, g.c.HIDE);
            MediationServiceImpl.this.f61448a.q().b((fe) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61838a.a(maxAd);
                }
            }, maxAd instanceof he ? ((he) maxAd).h0() : 0L);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.f61462a.a(bundle);
            this.f61462a.d0();
            MediationServiceImpl.this.f61448a.k().a(this.f61462a, g.c.LOAD);
            MediationServiceImpl.this.a(this.f61462a);
            fc.f(this.f61463b, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            a(maxAd, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            b(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            c(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            d(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            e(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f61462a.d0();
            MediationServiceImpl.this.b(this.f61462a, maxError, this.f61463b);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            f(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }

        public void a(a.InterfaceC0110a interfaceC0110a) {
            this.f61463b = interfaceC0110a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f61448a.B().b(maxAd);
            }
            fc.e(this.f61463b, maxAd);
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.f61462a.a(bundle);
            MediationServiceImpl.this.f61448a.k().a(this.f61462a, g.c.CLICK);
            MediationServiceImpl.this.a(this.f61462a, this.f61463b);
            fc.a((MaxAdListener) this.f61463b, maxAd);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.f61462a.a(bundle);
            MediationServiceImpl.this.a(this.f61462a, maxError, this.f61463b);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof he)) {
                ((he) maxAd).f0();
            }
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.f61462a.a(bundle);
            fc.a(this.f61463b, maxAd, maxReward);
            MediationServiceImpl.this.f61448a.i0().a((yl) new fn((he) maxAd, MediationServiceImpl.this.f61448a), tm.b.OTHER);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }
    }

    public MediationServiceImpl(com.applovin.impl.sdk.j jVar) {
        this.f61448a = jVar;
        this.f61449b = jVar.I();
        this.f61450c = new xj(jVar);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    public void collectSignal(String str, MaxAdFormat maxAdFormat, zj zjVar, Context context, yj.a aVar) {
        if (zjVar == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        yj yjVarB = this.f61450c.b(zjVar, str, maxAdFormat);
        if (yjVarB != null) {
            aVar.a(yj.a(yjVarB));
            return;
        }
        g gVarA = this.f61448a.L().a(zjVar, zjVar.A());
        if (gVarA == null) {
            aVar.a(yj.a(zjVar, new MaxErrorImpl("Could not load adapter")));
            return;
        }
        if (((Boolean) this.f61448a.a(ue.J7)).booleanValue()) {
            a(str, maxAdFormat, zjVar, context, aVar, gVarA);
            return;
        }
        Activity activityM0 = context instanceof Activity ? (Activity) context : this.f61448a.m0();
        MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(zjVar, str, maxAdFormat);
        if (zjVar.z()) {
            this.f61448a.K().b(zjVar, activityM0);
        }
        a aVar2 = new a(gVarA, str, SystemClock.elapsedRealtime(), zjVar, maxAdFormat, aVar);
        if (!zjVar.v()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61449b.a("MediationService", "Collecting signal for adapter: " + gVarA.g());
            }
            gVarA.a(maxAdapterParametersImplA, zjVar, activityM0, aVar2);
            return;
        }
        if (this.f61448a.K().b(zjVar)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61449b.a("MediationService", "Collecting signal for now-initialized adapter: " + gVarA.g());
            }
            gVarA.a(maxAdapterParametersImplA, zjVar, activityM0, aVar2);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.b("MediationService", "Skip collecting signal for not-initialized adapter: " + gVarA.g());
        }
        aVar.a(yj.a(zjVar, new MaxErrorImpl("Adapter not initialized yet")));
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof fe) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61449b.d("MediationService", "Destroying " + maxAd);
            }
            fe feVar = (fe) maxAd;
            g gVarA = feVar.A();
            if (gVarA != null) {
                gVarA.a();
                feVar.t();
            }
            this.f61448a.i().c(feVar.R());
            this.f61448a.k().a(feVar, g.c.DESTROY);
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return (JSONObject) this.f61451d.getAndSet(null);
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, d.b bVar, Map<String, Object> map, Map<String, Object> map2, Context context, a.InterfaceC0110a interfaceC0110a) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (interfaceC0110a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.f61448a.N())) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
        }
        if (!this.f61448a.s0()) {
            com.applovin.impl.sdk.n.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        List<String> initializationAdUnitIds = this.f61448a.x0().get() ? this.f61448a.f0().getInitializationAdUnitIds() : this.f61448a.G() != null ? this.f61448a.G().getAdUnitIds() : null;
        boolean zStartsWith = str.startsWith("test_mode");
        if (initializationAdUnitIds != null && initializationAdUnitIds.size() > 0 && !initializationAdUnitIds.contains(str) && !zStartsWith) {
            if (yp.c(this.f61448a)) {
                String str3 = "Ad Unit ID " + str + " has not been initialized. When you use selective init, any ad units that you do not explicitly specify are excluded from serving ads for the current session. For more information visit our docs: https://developers.applovin.com/en/max/android/overview/advanced-settings#selective-init";
                if (((Boolean) this.f61448a.a(sj.h6)).booleanValue()) {
                    throw new RuntimeException(str3);
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61449b.b("MediationService", str3);
                }
            }
            this.f61448a.D().a(ka.V, "uninitialized_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "uninitialized_ad_unit_id" + str);
        }
        this.f61448a.c();
        if (str.length() != 16 && !zStartsWith && !this.f61448a.a0().startsWith("05TMD")) {
            com.applovin.impl.sdk.n.h("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
        }
        if (!this.f61448a.a(maxAdFormat)) {
            this.f61448a.R0();
            fc.a((MaxAdRequestListener) interfaceC0110a, str, true);
            this.f61448a.J().a(str, str2, maxAdFormat, bVar, map, map2, context, interfaceC0110a);
            return;
        }
        com.applovin.impl.sdk.n.h("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
        fc.a(interfaceC0110a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
    }

    public void loadThirdPartyMediatedAd(final String str, final fe feVar, final Activity activity, final a.InterfaceC0110a interfaceC0110a) {
        fi fiVarA;
        if (feVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.a("MediationService", "Loading " + feVar + "...");
        }
        this.f61448a.D().a(ka.E, feVar);
        this.f61448a.q().b(feVar, "WILL_LOAD");
        final g gVarA = this.f61448a.L().a(feVar);
        if (gVarA == null) {
            String str2 = "Failed to load " + feVar + ": adapter not loaded";
            com.applovin.impl.sdk.n.h("MediationService", str2);
            b(feVar, new MaxErrorImpl(-5001, str2), interfaceC0110a);
            return;
        }
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(feVar);
        if (feVar.b0()) {
            fiVarA = this.f61448a.K().a(feVar, activity);
        } else {
            if (feVar.c0()) {
                this.f61448a.K().b(feVar, activity);
            }
            fiVarA = null;
        }
        final fe feVarA = feVar.a(gVarA);
        gVarA.a(str, feVarA);
        feVarA.e0();
        if (fiVarA == null) {
            gVarA.a(str, maxAdapterParametersImplA, feVarA, activity, new d(feVarA, interfaceC0110a));
            return;
        }
        Executor executor = fi.f59703i;
        fiVarA.a(executor, new fi.a() { // from class: com.applovin.impl.mediation.n
            @Override // com.applovin.impl.fi.a
            public final void a(Object obj) {
                this.f61824a.a(feVar, interfaceC0110a, (String) obj);
            }
        });
        fiVarA.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f61829a.a(gVarA, str, maxAdapterParametersImplA, feVarA, activity, interfaceC0110a);
            }
        });
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object objA = this.f61448a.B().a();
            if (objA instanceof fe) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (fe) objA, true);
            }
        }
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, fe feVar) {
        a(maxError, feVar, false);
    }

    public void processAdapterInitializationPostback(oe oeVar, long j3, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap map = new HashMap(2);
        map.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        map.put("{INIT_TIME_MS}", String.valueOf(j3));
        a("minit", map, new MaxErrorImpl(str), oeVar);
        Map mapA = la.a(oeVar);
        CollectionUtils.putStringIfValid("adapter_init_status", String.valueOf(initializationStatus.getCode()), mapA);
        CollectionUtils.putStringIfValid("error_message", str, mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j3), mapA);
        switch (c.f61461a[initializationStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f61448a.D().a(ka.f60971x, mapA);
                break;
            case 4:
                this.f61448a.D().a(ka.f60972y, mapA);
                break;
            case 5:
            case 6:
                this.f61448a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61448a.I().k("MediationService", "Adapter init postback called while the adapter is not fully initialized.");
                }
                this.f61448a.D().a(ka.f60950d, "adapterNotInitializedForPostback", mapA);
                break;
        }
    }

    public void processCallbackAdImpressionPostback(fe feVar, a.InterfaceC0110a interfaceC0110a) {
        if (feVar.P().endsWith("cimp")) {
            this.f61448a.q().b(feVar);
            fc.a((MaxAdRevenueListener) interfaceC0110a, (MaxAd) feVar);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f61448a.o0().c());
        if (!((Boolean) this.f61448a.a(sj.I3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mcimp", map, feVar);
        this.f61448a.D().a(ka.I, feVar);
    }

    public void processRawAdImpression(fe feVar, a.InterfaceC0110a interfaceC0110a) {
        this.f61448a.q().b(feVar, "WILL_DISPLAY");
        if (feVar.P().endsWith("mimp")) {
            this.f61448a.q().b(feVar);
            fc.a((MaxAdRevenueListener) interfaceC0110a, (MaxAd) feVar);
        }
        if (((Boolean) this.f61448a.a(sj.C4)).booleanValue()) {
            this.f61448a.Q().a(ve.f64422d, we.a(feVar), Long.valueOf(System.currentTimeMillis() - this.f61448a.H()));
        }
        HashMap map = new HashMap(2);
        if (feVar instanceof he) {
            map.put("{TIME_TO_SHOW_MS}", String.valueOf(((he) feVar).l0()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f61448a.o0().c());
        if (!((Boolean) this.f61448a.a(sj.I3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mimp", map, feVar);
    }

    public void processViewabilityAdImpressionPostback(me meVar, long j3, a.InterfaceC0110a interfaceC0110a) {
        if (meVar.P().endsWith("vimp")) {
            this.f61448a.q().b(meVar);
            fc.a((MaxAdRevenueListener) interfaceC0110a, (MaxAd) meVar);
        }
        HashMap map = new HashMap(3);
        map.put("{VIEWABILITY_FLAGS}", String.valueOf(j3));
        map.put("{USED_VIEWABILITY_TIMER}", String.valueOf(meVar.m0()));
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f61448a.o0().c());
        if (!((Boolean) this.f61448a.a(sj.I3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mvimp", map, meVar);
    }

    public void processWaterfallInfoPostback(String str, MaxAdFormat maxAdFormat, MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl, MaxError maxError, long j3, long j4) {
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map);
        CollectionUtils.putStringIfValid("ad_unit_id", str, map);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j4), map);
        if (maxError != null) {
            map.putAll(la.a(maxError));
        }
        this.f61448a.D().a(ka.H, (Map) map);
        if (CollectionUtils.isEmpty(maxAdWaterfallInfoImpl.getPostbackUrls())) {
            return;
        }
        HashMap map2 = new HashMap(8);
        CollectionUtils.putStringIfValid("mcode", maxAdWaterfallInfoImpl.getMCode(), map2);
        CollectionUtils.putStringIfValid("ad_unit_id", str, map2);
        CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map2);
        CollectionUtils.putStringIfValid("name", maxAdWaterfallInfoImpl.getName(), map2);
        CollectionUtils.putLongIfValid("request_latency_ms", Long.valueOf(j4), map2);
        CollectionUtils.putLongIfValid("request_start_timestamp_ms", Long.valueOf(j3), map2);
        CollectionUtils.putLongIfValid("wf_latency_ms", Long.valueOf(maxAdWaterfallInfoImpl.getLatencyMillis()), map2);
        List<MaxNetworkResponseInfo> networkResponses = maxAdWaterfallInfoImpl.getNetworkResponses();
        ArrayList arrayList = new ArrayList(networkResponses.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : networkResponses) {
            MaxMediatedNetworkInfo mediatedNetwork = maxNetworkResponseInfo.getMediatedNetwork();
            HashMap map3 = new HashMap(5);
            CollectionUtils.putStringIfValid("bcode", ((MaxNetworkResponseInfoImpl) maxNetworkResponseInfo).getBCode(), map3);
            map3.put("name", mediatedNetwork.getName());
            CollectionUtils.putLongIfValid("latency_ms", Long.valueOf(maxNetworkResponseInfo.getLatencyMillis()), map3);
            map3.put("load_state", Integer.valueOf(maxNetworkResponseInfo.getAdLoadState().ordinal()));
            MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxNetworkResponseInfo.getError();
            if (maxErrorImpl != null) {
                HashMap map4 = new HashMap(4);
                map4.put("error_code", Integer.valueOf(maxErrorImpl.getCode()));
                map4.put("error_message", maxErrorImpl.getMessage());
                map4.put("third_party_sdk_error_code", Integer.valueOf(maxErrorImpl.getMediatedNetworkErrorCode()));
                map4.put("third_party_sdk_error_message", maxErrorImpl.getMediatedNetworkErrorMessage());
                map3.put("error_info", map4);
            }
            arrayList.add(map3);
        }
        map2.put("ads_info", arrayList);
        a("mwf_info", maxAdWaterfallInfoImpl.getPostbackUrls(), Collections.EMPTY_MAP, (Map) map2, (MaxError) null, (oe) null, false);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.f61451d.set(jSONObject);
    }

    public void showFullscreenAd(final he heVar, final Activity activity, final a.InterfaceC0110a interfaceC0110a) {
        if (heVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != heVar.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f61448a.B().a(true);
        final g gVarB = b(heVar);
        long jN0 = heVar.n0();
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.d("MediationService", "Showing ad " + heVar.getAdUnitId() + " with delay of " + jN0 + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f61771a.a(heVar, gVarB, activity, interfaceC0110a);
            }
        }, jN0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(fe feVar, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, feVar);
        destroyAd(feVar);
        fc.a(maxAdListener, feVar.getAdUnitId(), maxError);
    }

    private void a(final String str, final MaxAdFormat maxAdFormat, final zj zjVar, Context context, final yj.a aVar, final g gVar) {
        final fi fiVar = new fi("SignalCollection:" + zjVar.c());
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Executor executor = fi.f59703i;
        fiVar.a(executor, new fi.b() { // from class: com.applovin.impl.mediation.j
            @Override // com.applovin.impl.fi.b
            public final void a(boolean z2, Object obj, Object obj2) {
                this.f61791a.a(jElapsedRealtime, gVar, str, zjVar, maxAdFormat, aVar, z2, (String) obj, (MaxError) obj2);
            }
        });
        an.a(zjVar.m(), fiVar, new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + zjVar.c() + ") timed out collecting signal"), "MediationService", this.f61448a);
        final g.c bVar = new b(fiVar);
        Activity activityM0 = context instanceof Activity ? (Activity) context : this.f61448a.m0();
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(zjVar, str, maxAdFormat);
        if (zjVar.v()) {
            fi fiVarA = this.f61448a.K().a(zjVar, activityM0);
            final Activity activity = activityM0;
            fiVarA.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61801a.a(fiVar, gVar, maxAdapterParametersImplA, zjVar, activity, bVar);
                }
            });
            fiVarA.a(executor, new fi.a() { // from class: com.applovin.impl.mediation.l
                @Override // com.applovin.impl.fi.a
                public final void a(Object obj) {
                    this.f61812a.a(gVar, fiVar, (String) obj);
                }
            });
            return;
        }
        Activity activity2 = activityM0;
        if (zjVar.w()) {
            fi fiVarA2 = this.f61448a.K().a(zjVar, activity2);
            if (fiVarA2.d() && !zjVar.y()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61449b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + gVar.g());
                }
                fiVar.a(new MaxErrorImpl("Could not initialize adapter: " + ((String) fiVarA2.a())));
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.a("MediationService", "Collecting signal for adapter: " + gVar.g());
        }
        gVar.a(maxAdapterParametersImplA, zjVar, activity2, bVar);
    }

    private g b(he heVar) {
        g gVarA = heVar.A();
        if (gVarA != null) {
            return gVarA;
        }
        this.f61448a.B().a(false);
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.k("MediationService", "Failed to show " + heVar + ": adapter not found");
        }
        com.applovin.impl.sdk.n.h("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + heVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    public void showFullscreenAd(final he heVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity, final a.InterfaceC0110a interfaceC0110a) {
        if (heVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity != null) {
            this.f61448a.B().a(true);
            final g gVarB = b(heVar);
            long jN0 = heVar.n0();
            if (com.applovin.impl.sdk.n.a()) {
                this.f61449b.d("MediationService", "Showing ad " + heVar.getAdUnitId() + " with delay of " + jN0 + "ms...");
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61778a.a(heVar, gVarB, viewGroup, lifecycle, activity, interfaceC0110a);
                }
            }, jN0);
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    private void a(he heVar, a.InterfaceC0110a interfaceC0110a) {
        this.f61448a.B().a(false);
        a(heVar, (MaxAdListener) interfaceC0110a);
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.a("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpression(heVar, interfaceC0110a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j3, g gVar, String str, zj zjVar, MaxAdFormat maxAdFormat, yj.a aVar, boolean z2, String str2, MaxError maxError) {
        yj yjVarA;
        String str3;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j3;
        if (z2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61449b.a("MediationService", "Signal collection successful from: " + gVar.g() + " for Ad Unit ID: " + str + " with signal: \"" + str2 + "\"");
                str3 = str2;
            } else {
                str3 = str2;
            }
            yjVarA = yj.a(zjVar, gVar, str3, j3, jElapsedRealtime);
            this.f61450c.a(yjVarA, zjVar, str, maxAdFormat);
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("network_name", zjVar.c(), map);
            CollectionUtils.putStringIfValid("adapter_class", zjVar.b(), map);
            CollectionUtils.putStringIfValid("adapter_version", gVar.b(), map);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jElapsedRealtime), map);
            CollectionUtils.putStringIfValid("ad_format", String.valueOf(maxAdFormat.getLabel()), map);
            CollectionUtils.putStringIfValid("ad_unit_id", str, map);
            this.f61448a.D().a(ka.f60973z, (Map) map);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61449b.b("MediationService", "Signal collection failed from: " + gVar.g() + " for Ad Unit ID: " + str + " with error message: \"" + maxError.getMessage() + "\"");
            }
            yjVarA = yj.a(zjVar, gVar, maxError, j3, jElapsedRealtime);
            a(yjVarA, zjVar, gVar);
        }
        aVar.a(yjVarA);
        gVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(fi fiVar, g gVar, MaxAdapterParametersImpl maxAdapterParametersImpl, zj zjVar, Activity activity, g.c cVar) {
        if (fiVar.c()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.a("MediationService", "Collecting signal for now-initialized adapter: " + gVar.g());
        }
        gVar.a(maxAdapterParametersImpl, zjVar, activity, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, String str, MaxAdapterParametersImpl maxAdapterParametersImpl, fe feVar, Activity activity, a.InterfaceC0110a interfaceC0110a) {
        gVar.a(str, maxAdapterParametersImpl, feVar, activity, new d(feVar, interfaceC0110a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(he heVar, Long l3, MaxAdListener maxAdListener) {
        if (heVar.u().get()) {
            return;
        }
        String str = pMpIcGE.RECP + heVar.k() + ") has not been displayed after " + l3 + "ms. Failing ad display...";
        com.applovin.impl.sdk.n.h("MediationService", str);
        a(heVar, new MaxErrorImpl(-1, str), maxAdListener);
        this.f61448a.B().b(heVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(he heVar, g gVar, Activity activity, a.InterfaceC0110a interfaceC0110a) {
        heVar.a(true);
        a(heVar);
        gVar.c(heVar, activity);
        a(heVar, interfaceC0110a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(he heVar, g gVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.InterfaceC0110a interfaceC0110a) {
        heVar.a(true);
        a(heVar);
        gVar.a(heVar, viewGroup, lifecycle, activity);
        a(heVar, interfaceC0110a);
    }

    private void a(final he heVar, final MaxAdListener maxAdListener) {
        final Long l3 = (Long) this.f61448a.a(ue.j7);
        if (l3.longValue() <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f61819a.a(heVar, l3, maxAdListener);
            }
        }, l3.longValue());
    }

    private void a(he heVar) {
        if (heVar.getFormat() == MaxAdFormat.REWARDED || heVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            this.f61448a.i0().a((yl) new ln(heVar, this.f61448a), tm.b.OTHER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(fe feVar, MaxError maxError, MaxAdListener maxAdListener) {
        this.f61448a.k().a(feVar, g.c.SHOW_ERROR);
        this.f61448a.q().b(feVar, "DID_FAIL_DISPLAY");
        a(maxError, feVar, true);
        if (feVar.u().compareAndSet(false, true)) {
            fc.a(maxAdListener, feVar, maxError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(fe feVar, a.InterfaceC0110a interfaceC0110a) {
        this.f61448a.q().b(feVar, "DID_CLICKED");
        this.f61448a.q().b(feVar, "DID_CLICK");
        if (feVar.P().endsWith("click")) {
            this.f61448a.q().b(feVar);
            fc.a((MaxAdRevenueListener) interfaceC0110a, (MaxAd) feVar);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f61448a.o0().c());
        if (!((Boolean) this.f61448a.a(sj.I3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclick", map, feVar);
    }

    private void a(MaxError maxError, fe feVar, boolean z2) {
        a("mierr", Collections.EMPTY_MAP, maxError, feVar, z2);
        if (!z2 || feVar == null) {
            return;
        }
        this.f61448a.D().a(ka.J, feVar, maxError);
    }

    private void a(MaxError maxError, fe feVar) {
        HashMap map = new HashMap(3);
        long jG = feVar.G();
        map.put("{LOAD_TIME_MS}", String.valueOf(jG));
        if (feVar.getFormat().isFullscreenAd()) {
            m.a aVarB = this.f61448a.B().b(feVar.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("mlerr", map, maxError, feVar);
        Map mapA = la.a(feVar);
        mapA.putAll(la.a(maxError));
        mapA.put("duration_ms", String.valueOf(jG));
        this.f61448a.D().a(ka.G, mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(fe feVar) {
        this.f61448a.q().b(feVar, "DID_LOAD");
        if (feVar.P().endsWith("load")) {
            this.f61448a.q().b(feVar);
        }
        HashMap map = new HashMap(3);
        long jG = feVar.G();
        map.put("{LOAD_TIME_MS}", String.valueOf(jG));
        if (feVar.getFormat().isFullscreenAd()) {
            m.a aVarB = this.f61448a.B().b(feVar.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("load", map, feVar);
        Map mapA = la.a(feVar);
        mapA.put("duration_ms", String.valueOf(jG));
        this.f61448a.D().a(ka.F, mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(yj yjVar, zj zjVar, g gVar) {
        long jB = yjVar.b();
        HashMap map = new HashMap(3);
        map.put("{LOAD_TIME_MS}", String.valueOf(jB));
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", gVar.b(), map);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", gVar.i(), map);
        a("serr", map, yjVar.c(), zjVar);
        HashMap map2 = new HashMap();
        CollectionUtils.putStringIfValid("network_name", zjVar.c(), map2);
        CollectionUtils.putStringIfValid("adapter_class", zjVar.b(), map2);
        CollectionUtils.putStringIfValid("adapter_version", gVar.b(), map2);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jB), map2);
        this.f61448a.D().a(ka.A, (Map) map2);
    }

    private void a(String str, List list, Map map, Map map2, MaxError maxError, oe oeVar, boolean z2) {
        this.f61448a.i0().a((yl) new rm(str, list, map, map2, maxError, oeVar, this.f61448a, z2), tm.b.OTHER);
    }

    private void a(String str, Map map, oe oeVar) {
        a(str, map, (MaxError) null, oeVar);
    }

    private void a(String str, Map map, MaxError maxError, oe oeVar) {
        a(str, map, maxError, oeVar, true);
    }

    private void a(String str, Map map, MaxError maxError, oe oeVar, boolean z2) {
        String strEmptyIfNull;
        Map map2 = CollectionUtils.map(map);
        String strEmptyIfNull2 = "";
        map2.put("{PLACEMENT}", z2 ? StringUtils.emptyIfNull(oeVar.getPlacement()) : "");
        if (!z2) {
            strEmptyIfNull = "";
        } else {
            strEmptyIfNull = StringUtils.emptyIfNull(oeVar.e());
        }
        map2.put("{CUSTOM_DATA}", strEmptyIfNull);
        if (oeVar instanceof fe) {
            fe feVar = (fe) oeVar;
            if (z2) {
                strEmptyIfNull2 = StringUtils.emptyIfNull(feVar.getCreativeId());
            }
            map2.put("{CREATIVE_ID}", strEmptyIfNull2);
        }
        a(str, (List) null, map2, (Map) null, maxError, oeVar, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(fe feVar, a.InterfaceC0110a interfaceC0110a, String str) {
        String str2 = "Failed to load " + feVar + ": adapter init failed with error: " + str;
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.k("MediationService", str2);
        }
        b(feVar, new MaxErrorImpl(MaxAdapterError.NOT_INITIALIZED.getErrorCode(), "Adapter initialization failed"), interfaceC0110a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, fi fiVar, String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f61449b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + gVar.g());
        }
        fiVar.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_NOT_INITIALIZED, "Could not initialize adapter: " + str));
    }
}

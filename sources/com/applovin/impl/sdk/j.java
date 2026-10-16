package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.ag;
import com.applovin.impl.ba;
import com.applovin.impl.c5;
import com.applovin.impl.ca;
import com.applovin.impl.cd;
import com.applovin.impl.d4;
import com.applovin.impl.e4;
import com.applovin.impl.fc;
import com.applovin.impl.h4;
import com.applovin.impl.hr;
import com.applovin.impl.jm;
import com.applovin.impl.jn;
import com.applovin.impl.ka;
import com.applovin.impl.la;
import com.applovin.impl.mediation.MaxSegmentCollectionImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.ob;
import com.applovin.impl.oe;
import com.applovin.impl.oj;
import com.applovin.impl.pe;
import com.applovin.impl.pg;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.qn;
import com.applovin.impl.qr;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.sm;
import com.applovin.impl.te;
import com.applovin.impl.tj;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.uj;
import com.applovin.impl.vj;
import com.applovin.impl.wh;
import com.applovin.impl.wn;
import com.applovin.impl.wp;
import com.applovin.impl.x4;
import com.applovin.impl.xe;
import com.applovin.impl.ye;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.ze;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.LegacyTokenHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class j {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static j f63329u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected static Context f63330v0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final boolean f63332x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static volatile com.applovin.impl.q f63333y0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f63335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f63337b;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private List f63340c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f63341d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AppLovinSdkSettings f63345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxSegmentCollection f63347g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private boolean f63348g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f63349h;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private String f63358l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile AppLovinSdk f63359m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private AppLovinSdkInitializationConfiguration f63360m0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private AppLovinSdk.SdkInitializationListener f63366p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private AppLovinSdk.SdkInitializationListener f63368q0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final Object f63334z0 = new Object();

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private static final long f63331w0 = System.currentTimeMillis();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f63343e = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f63351i = new AtomicReference();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicReference f63353j = new AtomicReference();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicReference f63355k = new AtomicReference();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicReference f63357l = new AtomicReference();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n f63361n = new n(this);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final la f63363o = new la(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicReference f63365p = new AtomicReference();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicReference f63367q = new AtomicReference();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicReference f63369r = new AtomicReference();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AtomicReference f63371s = new AtomicReference();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicReference f63373t = new AtomicReference();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicReference f63375u = new AtomicReference();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicReference f63376v = new AtomicReference();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicReference f63377w = new AtomicReference();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicReference f63378x = new AtomicReference();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicReference f63379y = new AtomicReference();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AtomicReference f63380z = new AtomicReference();
    private final AtomicReference A = new AtomicReference();
    private final AtomicReference B = new AtomicReference();
    private final AtomicReference C = new AtomicReference();
    private final AtomicReference D = new AtomicReference();
    private final AtomicReference E = new AtomicReference();
    private final AtomicReference F = new AtomicReference();
    private final AtomicReference G = new AtomicReference();
    private final AtomicReference H = new AtomicReference();
    private final AtomicReference I = new AtomicReference();
    private final AtomicReference J = new AtomicReference();
    private final AtomicReference K = new AtomicReference();
    private final AtomicReference L = new AtomicReference();
    private final AtomicReference M = new AtomicReference();
    private final AtomicReference N = new AtomicReference();
    private final AtomicReference O = new AtomicReference();
    private final AtomicReference P = new AtomicReference();
    private final AtomicReference Q = new AtomicReference();
    private final AtomicReference R = new AtomicReference();
    private final AtomicReference S = new AtomicReference();
    private final AtomicReference T = new AtomicReference();
    private final AtomicReference U = new AtomicReference();
    private final AtomicReference V = new AtomicReference();
    private final AtomicReference W = new AtomicReference();
    private final AtomicReference X = new AtomicReference();
    private final AtomicReference Y = new AtomicReference();
    private final AtomicReference Z = new AtomicReference();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final AtomicReference f63336a0 = new AtomicReference();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final AtomicReference f63338b0 = new AtomicReference();

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final Object f63342d0 = new Object();

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final AtomicBoolean f63344e0 = new AtomicBoolean(true);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final AtomicBoolean f63346f0 = new AtomicBoolean();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f63350h0 = false;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f63352i0 = false;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f63354j0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private int f63356k0 = 0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Object f63362n0 = new Object();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private AppLovinSdkConfiguration f63364o0 = new SdkConfigurationImpl(null, this);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final AtomicBoolean f63370r0 = new AtomicBoolean(false);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private final yl f63372s0 = new jn(this, true, "scheduleAdLoadIntegrationError", new Runnable() { // from class: com.applovin.impl.sdk.v0
        @Override // java.lang.Runnable
        public final void run() {
            this.f63630a.C0();
        }
    });

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final yl f63374t0 = new jn(this, true, "sdkInit", new Runnable() { // from class: com.applovin.impl.sdk.w0
        @Override // java.lang.Runnable
        public final void run() {
            this.f63633a.D0();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f63339c = System.currentTimeMillis();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements jm.b {
        a() {
        }

        @Override // com.applovin.impl.jm.b
        public void a(JSONObject jSONObject) {
            boolean z2 = jSONObject != null && jSONObject.length() > 0;
            j.this.c(jSONObject);
            com.applovin.impl.u0.b(j.this);
            e4.a(jSONObject, z2, j.this);
            j.this.M().a(JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE).booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
            j.this.D().a();
            j jVar = j.this;
            jVar.f63340c0 = jVar.a(jSONObject);
            if (z2) {
                List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", ""));
                j jVar2 = j.this;
                jVar2.f63364o0 = new SdkConfigurationImpl(listExplode, jVar2);
            }
            j.this.k0().a(jSONObject);
            j.this.b(jSONObject);
            fc.b(((Boolean) j.this.a(sj.c6)).booleanValue());
            fc.a(((Boolean) j.this.a(sj.d6)).booleanValue());
            j.this.K0();
            if (!((Boolean) j.this.a(sj.f3)).booleanValue() || z2 || !e4.a(j.m())) {
                j.this.J0();
                return;
            }
            j.this.I();
            if (n.a()) {
                j.this.I().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            j.this.P0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements h4.b {
        b() {
        }

        @Override // com.applovin.impl.h4.b
        public void a(h4.a aVar) {
            j.this.I();
            if (n.a()) {
                j.this.I().a("AppLovinSdk", "Terms and Privacy Policy flow completed with status: " + aVar);
            }
            if (!aVar.b()) {
                j.this.e("Initializing SDK in MAX environment...");
                return;
            }
            j.this.I();
            if (n.a()) {
                j.this.I().a("AppLovinSdk", "Re-initializing SDK with the updated privacy settings...");
            }
            j.this.O0();
            j.this.L0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements jm.b {
        c() {
        }

        @Override // com.applovin.impl.jm.b
        public void a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() > 0) {
                j.this.c(jSONObject);
            }
            j.this.f63343e.set(false);
            j.this.J0();
        }
    }

    static {
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.m0
                @Override // java.lang.Runnable
                public final void run() {
                    yp.c();
                }
            });
            f63332x0 = true;
        } catch (Throwable unused) {
            f63332x0 = false;
        }
    }

    public j(Context context) {
        this.f63348g0 = false;
        this.f63345f = new AppLovinSdkSettings(context);
        this.f63348g0 = true;
        if (!w0()) {
            throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://developers.applovin.com/en/android/overview/integration");
        }
        f63330v0 = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f63337b = new WeakReference((Activity) context);
        }
        if (f63329u0 == null) {
            f63329u0 = this;
        } else {
            n.h("AppLovinSdk", "Multiple SDK instances detected");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0() {
        if (i0().d()) {
            return;
        }
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "Timing out adapters init...");
        }
        i0().e();
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0() {
        tm tmVarI0 = i0();
        int i3 = this.f63356k0 + 1;
        this.f63356k0 = i3;
        tmVarI0.a((yl) new jm(i3, this, new c()), tm.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0() {
        if (y0()) {
            ob.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0() {
        synchronized (this.f63342d0) {
            try {
                boolean zA = e4.a(m());
                if (!y0()) {
                    I();
                    if (n.a()) {
                        I().a("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + N());
                    }
                }
                if (!((Boolean) a(sj.g3)).booleanValue() || zA) {
                    O0();
                }
                if (((Boolean) a(sj.f3)).booleanValue() && !zA) {
                    I();
                    if (n.a()) {
                        I().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                    }
                    P0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        if (u0()) {
            return;
        }
        this.f63372s0.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0() {
        if (u0()) {
            return;
        }
        this.f63370r0.set(true);
        this.f63374t0.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0() {
        c(uj.I);
    }

    private q I0() {
        if (!wh.f(f63330v0)) {
            return null;
        }
        try {
            return new q(this);
        } catch (Throwable th) {
            n.b("AppLovinSdk", "Failed to initialize Privacy Sandbox Service", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        Long l3 = (Long) a(sj.o3);
        if (l3.longValue() >= 0 && this.f63343e.compareAndSet(false, true)) {
            hr.a(l3.longValue(), false, this, new Runnable() { // from class: com.applovin.impl.sdk.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63598a.B0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        if (!y0()) {
            e("Initializing SDK in non-MAX environment...");
            return;
        }
        if (!this.f63346f0.compareAndSet(false, true)) {
            e("Consent flow is already shown. Initializing SDK in MAX environment...");
        } else {
            if (!u().j()) {
                e("Consent flow is not enabled. Initializing SDK in MAX environment...");
                return;
            }
            u().a();
            u().b(m0(), new b());
        }
    }

    private void M0() {
        Context context = f63330v0;
        n nVarI = I();
        vj vjVarH0 = h0();
        h4 h4VarU = u();
        a(context);
        e0();
        i();
        n();
        U();
        K().a(MaxAdapter.InitializationStatus.INITIALIZING);
        NativeCrashReporter.a(this);
        String str = this.f63335a;
        if (str == null || str.length() != 86) {
            n.h("AppLovinSdk", "Please double-check that you entered your SDK key correctly (" + this.f63335a + ") : " + Log.getStackTraceString(new Throwable("")));
        }
        if ("HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(this.f63335a)) {
            n.h("AppLovinSdk", "Cross Promo SDK has been deprecated and is no longer supported");
            if (yp.c(this)) {
                throw new RuntimeException("Cross Promo SDK has been deprecated and is no longer supported");
            }
            return;
        }
        if (f0().getExtraParameters().containsKey("terms_flow_settings")) {
            String str2 = "Terms flow has been removed. Please migrate to our Terms and Privacy Policy flow. For more information visit our docs: " + u().b();
            if (yp.c(this)) {
                throw new IllegalStateException(str2);
            }
            n.h("AppLovinSdk", str2);
        }
        if (yp.i()) {
            n.h("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!yp.b(this)) {
            n.h("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (yp.k(context)) {
            this.f63345f.setVerboseLogging(true);
        }
        g0().a(sj.f63761l, Boolean.valueOf(this.f63345f.isVerboseLoggingEnabled()));
        if (yp.c(this)) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayA = ze.a(this);
            for (int i3 = 0; i3 < jSONArrayA.length(); i3++) {
                JSONObject jSONObject = JsonUtils.getJSONObject(jSONArrayA, i3, (JSONObject) null);
                if (!JsonUtils.getBoolean(jSONObject, "is_supported", Boolean.TRUE).booleanValue()) {
                    arrayList.add(JsonUtils.getString(jSONObject, "name", "unknown"));
                }
            }
            if (!arrayList.isEmpty()) {
                throw new IllegalArgumentException("Please update to the latest adapter versions. Incompatible adapter(s) found: " + arrayList);
            }
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        uj ujVar = uj.f64227c;
        if (TextUtils.isEmpty((String) vjVarH0.a(ujVar, (Object) null, defaultSharedPreferences))) {
            this.f63352i0 = true;
            vjVarH0.b(ujVar, Boolean.toString(true), defaultSharedPreferences);
        } else {
            vjVarH0.b(ujVar, Boolean.toString(false), defaultSharedPreferences);
        }
        uj ujVar2 = uj.f64228d;
        if (((Boolean) vjVarH0.a(ujVar2, Boolean.FALSE)).booleanValue()) {
            if (n.a()) {
                nVarI.a("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.f63354j0 = true;
        } else {
            if (n.a()) {
                nVarI.a("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            vjVarH0.b(ujVar2, Boolean.TRUE);
            vjVarH0.b(uj.f64239o, Boolean.valueOf(h4VarU.j()));
        }
        uj ujVar3 = uj.f64229e;
        String str3 = (String) vjVarH0.a(ujVar3, null);
        if (StringUtils.isValidString(str3)) {
            if (AppLovinSdk.VERSION_CODE > yp.f(str3)) {
                vjVarH0.b(ujVar3, AppLovinSdk.VERSION);
            }
        } else {
            vjVarH0.b(ujVar3, AppLovinSdk.VERSION);
        }
        D().a(ka.f60952e, (Object) null, (Map) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        M0();
        if (this.f63345f.isExceptionHandlerEnabled() && ((Boolean) a(sj.f63794u)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        int i3 = StringUtils.parseInt(this.f63345f.getExtraParameters().get("initialization_delay_ms"), ((Integer) a(sj.j4)).intValue());
        tm tmVarI0 = i0();
        jn jnVar = new jn(this, true, "scheduleAdLoadIntegrationErrorAuto", new Runnable() { // from class: com.applovin.impl.sdk.o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63572a.E0();
            }
        });
        tm.b bVar = tm.b.CORE;
        long j3 = i3;
        tmVarI0.a(jnVar, bVar, j3);
        i0().a(new jn(this, true, "scheduleSdkInit", new Runnable() { // from class: com.applovin.impl.sdk.p0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63575a.F0();
            }
        }), bVar, j3);
    }

    private Map O() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(sj.k4)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        ag agVarU = U();
        agVarU.a(new d(agVarU));
    }

    public static boolean w0() {
        return f63332x0;
    }

    public l A() {
        Object lVar = this.A.get();
        if (lVar == null) {
            synchronized (this.A) {
                try {
                    lVar = this.A.get();
                    if (lVar == null) {
                        lVar = new l(this);
                        this.A.set(lVar);
                    }
                } finally {
                }
            }
        }
        if (lVar == this.A) {
            lVar = null;
        }
        return (l) lVar;
    }

    public m B() {
        Object mVar = this.C.get();
        if (mVar == null) {
            synchronized (this.C) {
                try {
                    mVar = this.C.get();
                    if (mVar == null) {
                        mVar = new m(this);
                        this.C.set(mVar);
                    }
                } finally {
                }
            }
        }
        if (mVar == this.C) {
            mVar = null;
        }
        return (m) mVar;
    }

    public ca C() {
        Object caVar = this.f63371s.get();
        if (caVar == null) {
            synchronized (this.f63371s) {
                try {
                    caVar = this.f63371s.get();
                    if (caVar == null) {
                        caVar = new ca(this);
                        this.f63371s.set(caVar);
                    }
                } finally {
                }
            }
        }
        if (caVar == this.f63371s) {
            caVar = null;
        }
        return (ca) caVar;
    }

    public la D() {
        return this.f63363o;
    }

    public cd E() {
        Object cdVar = this.W.get();
        if (cdVar == null) {
            synchronized (this.W) {
                try {
                    cdVar = this.W.get();
                    if (cdVar == null) {
                        cdVar = new cd(this);
                        this.W.set(cdVar);
                    }
                } finally {
                }
            }
        }
        if (cdVar == this.W) {
            cdVar = null;
        }
        return (cd) cdVar;
    }

    public Activity F() {
        WeakReference weakReference = this.f63337b;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public AppLovinSdkInitializationConfiguration G() {
        return this.f63360m0;
    }

    public long H() {
        return this.f63339c;
    }

    public void H0() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if (u().i() || (sdkInitializationListener = this.f63366p0) == null) {
            return;
        }
        if (s0()) {
            this.f63366p0 = null;
            this.f63368q0 = null;
            K().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
        } else {
            if (this.f63368q0 == sdkInitializationListener) {
                return;
            }
            K().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
            if (((Boolean) a(sj.f63785r)).booleanValue()) {
                this.f63366p0 = null;
            } else {
                this.f63368q0 = sdkInitializationListener;
            }
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.t0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63603a.d(sdkInitializationListener);
            }
        }, Math.max(0L, ((Long) a(sj.f63788s)).longValue()));
    }

    public n I() {
        return this.f63361n;
    }

    public com.applovin.impl.mediation.d J() {
        Object dVar = this.f63336a0.get();
        if (dVar == null) {
            synchronized (this.f63336a0) {
                try {
                    dVar = this.f63336a0.get();
                    if (dVar == null) {
                        dVar = new com.applovin.impl.mediation.d(this);
                        this.f63336a0.set(dVar);
                    }
                } finally {
                }
            }
        }
        if (dVar == this.f63336a0) {
            dVar = null;
        }
        return (com.applovin.impl.mediation.d) dVar;
    }

    public com.applovin.impl.mediation.e K() {
        Object eVar = this.U.get();
        if (eVar == null) {
            synchronized (this.U) {
                try {
                    eVar = this.U.get();
                    if (eVar == null) {
                        eVar = new com.applovin.impl.mediation.e(this);
                        this.U.set(eVar);
                    }
                } finally {
                }
            }
        }
        if (eVar == this.U) {
            eVar = null;
        }
        return (com.applovin.impl.mediation.e) eVar;
    }

    public com.applovin.impl.mediation.f L() {
        Object fVar = this.T.get();
        if (fVar == null) {
            synchronized (this.T) {
                try {
                    fVar = this.T.get();
                    if (fVar == null) {
                        fVar = new com.applovin.impl.mediation.f(this);
                        this.T.set(fVar);
                    }
                } finally {
                }
            }
        }
        if (fVar == this.T) {
            fVar = null;
        }
        return (com.applovin.impl.mediation.f) fVar;
    }

    public void L0() {
        q().a();
    }

    public te M() {
        Object teVar = this.Y.get();
        if (teVar == null) {
            synchronized (this.Y) {
                try {
                    teVar = this.Y.get();
                    if (teVar == null) {
                        teVar = new te(this);
                        this.Y.set(teVar);
                    }
                } finally {
                }
            }
        }
        if (teVar == this.Y) {
            teVar = null;
        }
        return (te) teVar;
    }

    public String N() {
        String str = (String) a(uj.I);
        return StringUtils.isValidString(str) ? str : this.f63349h;
    }

    public void O0() {
        synchronized (this.f63342d0) {
            this.f63348g0 = true;
            i0().f();
            d();
        }
    }

    public MediationServiceImpl P() {
        Object mediationServiceImpl = this.V.get();
        if (mediationServiceImpl == null) {
            synchronized (this.V) {
                try {
                    mediationServiceImpl = this.V.get();
                    if (mediationServiceImpl == null) {
                        mediationServiceImpl = new MediationServiceImpl(this);
                        this.V.set(mediationServiceImpl);
                    }
                } finally {
                }
            }
        }
        if (mediationServiceImpl == this.V) {
            mediationServiceImpl = null;
        }
        return (MediationServiceImpl) mediationServiceImpl;
    }

    public xe Q() {
        Object xeVar = this.f63373t.get();
        if (xeVar == null) {
            synchronized (this.f63373t) {
                try {
                    xeVar = this.f63373t.get();
                    if (xeVar == null) {
                        xeVar = new xe(this);
                        this.f63373t.set(xeVar);
                    }
                } finally {
                }
            }
        }
        if (xeVar == this.f63373t) {
            xeVar = null;
        }
        return (xe) xeVar;
    }

    public void Q0() {
        n.h("AppLovinSdk", "Resetting SDK state...");
        ca caVarC = C();
        ba baVar = ba.f58614l;
        long jB = caVarC.b(baVar);
        g0().a();
        g0().e();
        C().a();
        C().b(baVar, jB + 1);
        if (this.f63344e0.compareAndSet(true, false)) {
            O0();
        } else {
            this.f63344e0.set(true);
        }
    }

    public ye R() {
        Object yeVar = this.X.get();
        if (yeVar == null) {
            synchronized (this.X) {
                try {
                    yeVar = this.X.get();
                    if (yeVar == null) {
                        yeVar = new ye();
                        this.X.set(yeVar);
                    }
                } finally {
                }
            }
        }
        if (yeVar == this.X) {
            yeVar = null;
        }
        return (ye) yeVar;
    }

    public void R0() {
        if (StringUtils.isValidString(this.f63358l0)) {
            return;
        }
        this.f63358l0 = AppLovinMediationProvider.MAX;
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "Detected mediation provider: MAX");
        }
    }

    public o S() {
        Object oVar = this.Z.get();
        if (oVar == null) {
            synchronized (this.Z) {
                try {
                    oVar = this.Z.get();
                    if (oVar == null) {
                        oVar = new o(this);
                        this.Z.set(oVar);
                    }
                } finally {
                }
            }
        }
        if (oVar == this.Z) {
            oVar = null;
        }
        return (o) oVar;
    }

    public void S0() {
        v().n();
    }

    public AppLovinNativeAdService T() {
        Object appLovinNativeAdService = this.f63353j.get();
        if (appLovinNativeAdService == null) {
            synchronized (this.f63353j) {
                try {
                    appLovinNativeAdService = this.f63353j.get();
                    if (appLovinNativeAdService == null) {
                        appLovinNativeAdService = new AppLovinNativeAdService(this);
                        this.f63353j.set(appLovinNativeAdService);
                    }
                } finally {
                }
            }
        }
        if (appLovinNativeAdService == this.f63353j) {
            appLovinNativeAdService = null;
        }
        return (AppLovinNativeAdService) appLovinNativeAdService;
    }

    public void T0() {
        a((Map) null);
    }

    public ag U() {
        Object agVar = this.F.get();
        if (agVar == null) {
            synchronized (this.F) {
                try {
                    agVar = this.F.get();
                    if (agVar == null) {
                        agVar = new ag(m());
                        this.F.set(agVar);
                    }
                } finally {
                }
            }
        }
        if (agVar == this.F) {
            agVar = null;
        }
        return (ag) agVar;
    }

    public void U0() {
        if (AppLovinMediationProvider.ADMOB.equalsIgnoreCase(this.f63349h) && ((Boolean) a(sj.L3)).booleanValue()) {
            String str = (String) a(sj.K3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str2 = AppLovinSdk.VERSION;
            sb.append(str2);
            sb.append(".");
            if (str.startsWith(sb.toString())) {
                return;
            }
            final String str3 = "Mismatched AdMob adapter (" + str + ") and AppLovin SDK (" + str2 + ") versions detected, which may cause compatibility issues.";
            n.h("AppLovinSdk", str3);
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63386a.d(str3);
                }
            });
        }
    }

    public pg V() {
        Object pgVar = this.M.get();
        if (pgVar == null) {
            synchronized (this.M) {
                try {
                    pgVar = this.M.get();
                    if (pgVar == null) {
                        pgVar = new pg(this);
                        this.M.set(pgVar);
                    }
                } finally {
                }
            }
        }
        if (pgVar == this.M) {
            pgVar = null;
        }
        return (pg) pgVar;
    }

    public com.applovin.impl.sdk.network.b W() {
        Object bVar = this.R.get();
        if (bVar == null) {
            synchronized (this.R) {
                try {
                    bVar = this.R.get();
                    if (bVar == null) {
                        bVar = new com.applovin.impl.sdk.network.b(this);
                        this.R.set(bVar);
                    }
                } finally {
                }
            }
        }
        if (bVar == this.R) {
            bVar = null;
        }
        return (com.applovin.impl.sdk.network.b) bVar;
    }

    public PostbackServiceImpl X() {
        Object postbackServiceImpl = this.Q.get();
        if (postbackServiceImpl == null) {
            synchronized (this.Q) {
                try {
                    postbackServiceImpl = this.Q.get();
                    if (postbackServiceImpl == null) {
                        postbackServiceImpl = new PostbackServiceImpl(this);
                        this.Q.set(postbackServiceImpl);
                    }
                } finally {
                }
            }
        }
        if (postbackServiceImpl == this.Q) {
            postbackServiceImpl = null;
        }
        return (PostbackServiceImpl) postbackServiceImpl;
    }

    public q Y() {
        Object objI0 = this.f63376v.get();
        if (objI0 == null) {
            synchronized (this.f63376v) {
                try {
                    objI0 = this.f63376v.get();
                    if (objI0 == null) {
                        objI0 = I0();
                        if (objI0 == null) {
                            objI0 = this.f63376v;
                        }
                        this.f63376v.set(objI0);
                    }
                } finally {
                }
            }
        }
        if (objI0 == this.f63376v) {
            objI0 = null;
        }
        return (q) objI0;
    }

    public String Z() {
        return o0().a();
    }

    public Object a(sj sjVar) {
        return g0().a(sjVar);
    }

    public String a0() {
        return this.f63335a;
    }

    public MaxSegmentCollectionImpl b0() {
        return (MaxSegmentCollectionImpl) this.f63347g;
    }

    public List c(sj sjVar) {
        return g0().c(sjVar);
    }

    public Map c0() {
        MaxSegmentCollectionImpl maxSegmentCollectionImplB0 = b0();
        if (maxSegmentCollectionImplB0 == null) {
            return null;
        }
        return maxSegmentCollectionImplB0.getJsonData();
    }

    public oj d0() {
        Object ojVar = this.H.get();
        if (ojVar == null) {
            synchronized (this.H) {
                try {
                    ojVar = this.H.get();
                    if (ojVar == null) {
                        ojVar = new oj(this);
                        this.H.set(ojVar);
                    }
                } finally {
                }
            }
        }
        if (ojVar == this.H) {
            ojVar = null;
        }
        return (oj) ojVar;
    }

    public SessionTracker e0() {
        Object sessionTracker = this.B.get();
        if (sessionTracker == null) {
            synchronized (this.B) {
                try {
                    sessionTracker = this.B.get();
                    if (sessionTracker == null) {
                        sessionTracker = new SessionTracker(this);
                        this.B.set(sessionTracker);
                    }
                } finally {
                }
            }
        }
        if (sessionTracker == this.B) {
            sessionTracker = null;
        }
        return (SessionTracker) sessionTracker;
    }

    public AppLovinSdkSettings f0() {
        return this.f63345f;
    }

    public tj g0() {
        Object tjVar = this.f63367q.get();
        if (tjVar == null) {
            synchronized (this.f63367q) {
                try {
                    tjVar = this.f63367q.get();
                    if (tjVar == null) {
                        tjVar = new tj(this);
                        this.f63367q.set(tjVar);
                    }
                } finally {
                }
            }
        }
        if (tjVar == this.f63367q) {
            tjVar = null;
        }
        return (tj) tjVar;
    }

    public vj h0() {
        Object vjVar = this.f63377w.get();
        if (vjVar == null) {
            synchronized (this.f63377w) {
                try {
                    vjVar = this.f63377w.get();
                    if (vjVar == null) {
                        vjVar = new vj(this);
                        this.f63377w.set(vjVar);
                    }
                } finally {
                }
            }
        }
        if (vjVar == this.f63377w) {
            vjVar = null;
        }
        return (vj) vjVar;
    }

    public tm i0() {
        Object tmVar = this.f63365p.get();
        if (tmVar == null) {
            synchronized (this.f63365p) {
                try {
                    tmVar = this.f63365p.get();
                    if (tmVar == null) {
                        tmVar = new tm(this);
                        this.f63365p.set(tmVar);
                    }
                } finally {
                }
            }
        }
        if (tmVar == this.f63365p) {
            tmVar = null;
        }
        return (tm) tmVar;
    }

    public qn j0() {
        Object qnVar = this.K.get();
        if (qnVar == null) {
            synchronized (this.K) {
                try {
                    qnVar = this.K.get();
                    if (qnVar == null) {
                        qnVar = new qn(this);
                        this.K.set(qnVar);
                    }
                } finally {
                }
            }
        }
        if (qnVar == this.K) {
            qnVar = null;
        }
        return (qn) qnVar;
    }

    public wn k0() {
        Object wnVar = this.f63338b0.get();
        if (wnVar == null) {
            synchronized (this.f63338b0) {
                try {
                    wnVar = this.f63338b0.get();
                    if (wnVar == null) {
                        wnVar = new wn(this);
                        this.f63338b0.set(wnVar);
                    }
                } finally {
                }
            }
        }
        if (wnVar == this.f63338b0) {
            wnVar = null;
        }
        return (wn) wnVar;
    }

    public long l0() {
        if (this.f63341d == 0) {
            return -1L;
        }
        return System.currentTimeMillis() - this.f63341d;
    }

    public Activity m0() {
        Activity activityB = a(m()).b();
        return activityB != null ? activityB : F();
    }

    public String n0() {
        return o0().c();
    }

    public wp o0() {
        Object wpVar = this.f63378x.get();
        if (wpVar == null) {
            synchronized (this.f63378x) {
                try {
                    wpVar = this.f63378x.get();
                    if (wpVar == null) {
                        wpVar = new wp(this);
                        this.f63378x.set(wpVar);
                    }
                } finally {
                }
            }
        }
        if (wpVar == this.f63378x) {
            wpVar = null;
        }
        return (wp) wpVar;
    }

    public qr p0() {
        Object qrVar = this.E.get();
        if (qrVar == null) {
            synchronized (this.E) {
                try {
                    qrVar = this.E.get();
                    if (qrVar == null) {
                        qrVar = new qr(this);
                        this.E.set(qrVar);
                    }
                } finally {
                }
            }
        }
        if (qrVar == this.E) {
            qrVar = null;
        }
        return (qr) qrVar;
    }

    public AppLovinSdk q0() {
        return this.f63359m;
    }

    public boolean r0() {
        return this.f63354j0;
    }

    public boolean s0() {
        boolean z2;
        synchronized (this.f63342d0) {
            z2 = this.f63350h0;
        }
        return z2;
    }

    public boolean t0() {
        return this.f63352i0;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f63335a + "', enabled=" + this.f63350h0 + ", isFirstSession=" + this.f63352i0 + '}';
    }

    public h4 u() {
        Object h4Var = this.J.get();
        if (h4Var == null) {
            synchronized (this.J) {
                try {
                    h4Var = this.J.get();
                    if (h4Var == null) {
                        h4Var = new h4(this);
                        this.J.set(h4Var);
                    }
                } finally {
                }
            }
        }
        if (h4Var == this.J) {
            h4Var = null;
        }
        return (h4) h4Var;
    }

    public boolean u0() {
        boolean z2;
        synchronized (this.f63362n0) {
            z2 = this.f63360m0 != null;
        }
        return z2;
    }

    public x4 v() {
        Object x4Var = this.L.get();
        if (x4Var == null) {
            synchronized (this.L) {
                try {
                    x4Var = this.L.get();
                    if (x4Var == null) {
                        x4Var = new x4(this);
                        this.L.set(x4Var);
                    }
                } finally {
                }
            }
        }
        if (x4Var == this.L) {
            x4Var = null;
        }
        return (x4) x4Var;
    }

    public boolean v0() {
        boolean z2;
        synchronized (this.f63342d0) {
            z2 = this.f63348g0;
        }
        return z2;
    }

    public c5 w() {
        Object c5Var = this.O.get();
        if (c5Var == null) {
            synchronized (this.O) {
                try {
                    c5Var = this.O.get();
                    if (c5Var == null) {
                        c5Var = new c5(this);
                        this.O.set(c5Var);
                    }
                } finally {
                }
            }
        }
        if (c5Var == this.O) {
            c5Var = null;
        }
        return (c5) c5Var;
    }

    public k x() {
        Object kVar = this.f63375u.get();
        if (kVar == null) {
            synchronized (this.f63375u) {
                try {
                    kVar = this.f63375u.get();
                    if (kVar == null) {
                        kVar = new k(this);
                        this.f63375u.set(kVar);
                    }
                } finally {
                }
            }
        }
        if (kVar == this.f63375u) {
            kVar = null;
        }
        return (k) kVar;
    }

    public AtomicBoolean x0() {
        return this.f63370r0;
    }

    public String y() {
        return this.f63358l0;
    }

    public boolean y0() {
        return StringUtils.containsIgnoreCase(N(), AppLovinMediationProvider.MAX);
    }

    public EventServiceImpl z() {
        Object eventServiceImpl = this.f63355k.get();
        if (eventServiceImpl == null) {
            synchronized (this.f63355k) {
                try {
                    eventServiceImpl = this.f63355k.get();
                    if (eventServiceImpl == null) {
                        eventServiceImpl = new EventServiceImpl(this);
                        this.f63355k.set(eventServiceImpl);
                    }
                } finally {
                }
            }
        }
        if (eventServiceImpl == this.f63355k) {
            eventServiceImpl = null;
        }
        return (EventServiceImpl) eventServiceImpl;
    }

    public boolean z0() {
        return yp.a("com.unity3d.player.UnityPlayerActivity");
    }

    private void d() {
        tm tmVarI0 = i0();
        int i3 = this.f63356k0 + 1;
        this.f63356k0 = i3;
        tmVarI0.a((yl) new jm(i3, this, new a()), tm.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        I();
        if (n.a()) {
            I().a("AppLovinSdk", str);
        }
        i0().a(new sm(this));
    }

    public static long l() {
        return f63331w0;
    }

    public static Context m() {
        return f63330v0;
    }

    public Object a(uj ujVar) {
        return a(ujVar, (Object) null);
    }

    public List b(sj sjVar) {
        return g0().b(sjVar);
    }

    public void c(uj ujVar) {
        h0().b(ujVar);
    }

    public com.applovin.impl.sdk.a f() {
        Object aVar = this.f63380z.get();
        if (aVar == null) {
            synchronized (this.f63380z) {
                try {
                    aVar = this.f63380z.get();
                    if (aVar == null) {
                        aVar = new com.applovin.impl.sdk.a(this);
                        this.f63380z.set(aVar);
                    }
                } finally {
                }
            }
        }
        if (aVar == this.f63380z) {
            aVar = null;
        }
        return (com.applovin.impl.sdk.a) aVar;
    }

    public com.applovin.impl.sdk.d g() {
        Object dVar = this.P.get();
        if (dVar == null) {
            synchronized (this.P) {
                try {
                    dVar = this.P.get();
                    if (dVar == null) {
                        dVar = new com.applovin.impl.sdk.d(this);
                        this.P.set(dVar);
                    }
                } finally {
                }
            }
        }
        if (dVar == this.P) {
            dVar = null;
        }
        return (com.applovin.impl.sdk.d) dVar;
    }

    public e h() {
        Object eVar = this.f63379y.get();
        if (eVar == null) {
            synchronized (this.f63379y) {
                try {
                    eVar = this.f63379y.get();
                    if (eVar == null) {
                        eVar = new e(this);
                        this.f63379y.set(eVar);
                    }
                } finally {
                }
            }
        }
        if (eVar == this.f63379y) {
            eVar = null;
        }
        return (e) eVar;
    }

    public com.applovin.impl.v i() {
        Object vVar = this.S.get();
        if (vVar == null) {
            synchronized (this.S) {
                try {
                    vVar = this.S.get();
                    if (vVar == null) {
                        vVar = new com.applovin.impl.v(this);
                        this.S.set(vVar);
                    }
                } finally {
                }
            }
        }
        if (vVar == this.S) {
            vVar = null;
        }
        return (com.applovin.impl.v) vVar;
    }

    public AppLovinAdServiceImpl j() {
        Object appLovinAdServiceImpl = this.f63351i.get();
        if (appLovinAdServiceImpl == null) {
            synchronized (this.f63351i) {
                try {
                    appLovinAdServiceImpl = this.f63351i.get();
                    if (appLovinAdServiceImpl == null) {
                        appLovinAdServiceImpl = new AppLovinAdServiceImpl(this);
                        this.f63351i.set(appLovinAdServiceImpl);
                    }
                } finally {
                }
            }
        }
        if (appLovinAdServiceImpl == this.f63351i) {
            appLovinAdServiceImpl = null;
        }
        return (AppLovinAdServiceImpl) appLovinAdServiceImpl;
    }

    public g k() {
        Object gVar = this.D.get();
        if (gVar == null) {
            synchronized (this.D) {
                try {
                    gVar = this.D.get();
                    if (gVar == null) {
                        gVar = new g(this);
                        this.D.set(gVar);
                    }
                } finally {
                }
            }
        }
        if (gVar == this.D) {
            gVar = null;
        }
        return (g) gVar;
    }

    public ArrayService n() {
        Object arrayService = this.N.get();
        if (arrayService == null) {
            synchronized (this.N) {
                try {
                    arrayService = this.N.get();
                    if (arrayService == null) {
                        arrayService = new ArrayService(this);
                        this.N.set(arrayService);
                    }
                } finally {
                }
            }
        }
        if (arrayService == this.N) {
            arrayService = null;
        }
        return (ArrayService) arrayService;
    }

    public h o() {
        Object hVar = this.I.get();
        if (hVar == null) {
            synchronized (this.I) {
                try {
                    hVar = this.I.get();
                    if (hVar == null) {
                        hVar = new h(this);
                        this.I.set(hVar);
                    }
                } finally {
                }
            }
        }
        if (hVar == this.I) {
            hVar = null;
        }
        return (h) hVar;
    }

    public CmpServiceImpl p() {
        Object cmpServiceImpl = this.f63357l.get();
        if (cmpServiceImpl == null) {
            synchronized (this.f63357l) {
                try {
                    cmpServiceImpl = this.f63357l.get();
                    if (cmpServiceImpl == null) {
                        cmpServiceImpl = new CmpServiceImpl(this);
                        this.f63357l.set(cmpServiceImpl);
                    }
                } finally {
                }
            }
        }
        if (cmpServiceImpl == this.f63357l) {
            cmpServiceImpl = null;
        }
        return (CmpServiceImpl) cmpServiceImpl;
    }

    public i q() {
        Object iVar = this.G.get();
        if (iVar == null) {
            synchronized (this.G) {
                try {
                    iVar = this.G.get();
                    if (iVar == null) {
                        iVar = new i(this);
                        this.G.set(iVar);
                    }
                } finally {
                }
            }
        }
        if (iVar == this.G) {
            iVar = null;
        }
        return (i) iVar;
    }

    public String r() {
        return o0().b();
    }

    public AppLovinSdkConfiguration s() {
        return this.f63364o0;
    }

    public d4 t() {
        Object d4Var = this.f63369r.get();
        if (d4Var == null) {
            synchronized (this.f63369r) {
                try {
                    d4Var = this.f63369r.get();
                    if (d4Var == null) {
                        d4Var = new d4(this);
                        this.f63369r.set(d4Var);
                    }
                } finally {
                }
            }
        }
        if (d4Var == this.f63369r) {
            d4Var = null;
        }
        return (d4) d4Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str) {
        if (!yp.c(this)) {
            HashMap map = new HashMap();
            map.put("details", AppLovinMediationProvider.ADMOB);
            map.put("error_message", str);
            D().a(ka.V, "adapterVersionMismatch", (Map) map);
            return;
        }
        throw new IllegalStateException(str);
    }

    public Object a(uj ujVar, Object obj) {
        return h0().a(ujVar, obj);
    }

    public Object b(uj ujVar) {
        return h0().a(ujVar);
    }

    public void f(String str) {
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "setMediationProvider(mediationProvider=" + str + ")");
        }
        if (str != null && (str.isEmpty() || str.length() > 64 || !StringUtils.isAlphaNumeric(str))) {
            n.h("AppLovinSdk", "Mediation provider set to invalid value: " + str + ". Please use a valid mediation provider (e.g., AppLovinMediationProvider.MAX)");
            return;
        }
        this.f63349h = str;
        if (yp.h()) {
            yp.a(new Runnable() { // from class: com.applovin.impl.sdk.n0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63431a.G0();
                }
            });
        } else {
            c(uj.I);
        }
    }

    public void g(final String str) {
        n.g("AppLovinSdk", "Setting plugin version: " + str);
        if (yp.h()) {
            yp.a(new Runnable() { // from class: com.applovin.impl.sdk.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63593a.b(str);
                }
            });
        } else {
            g0().a(sj.K3, str);
        }
    }

    public void h(final String str) {
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "Setting user id: " + str);
        }
        if (StringUtils.isValidString(str) && str.length() > yp.b(8)) {
            n.h("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + yp.b(8) + " maximum)");
        }
        if (yp.h()) {
            yp.a(new Runnable() { // from class: com.applovin.impl.sdk.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63636a.c(str);
                }
            });
        } else {
            o0().a(str);
        }
    }

    public boolean a(sj sjVar, MaxAdFormat maxAdFormat) {
        return b(sjVar).contains(maxAdFormat);
    }

    public void b(uj ujVar, Object obj) {
        h0().b(ujVar, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        this.f63341d = System.currentTimeMillis();
        e4.c(jSONObject, this);
        e4.b(jSONObject, this);
        e4.a(jSONObject, this);
        pe.f(jSONObject, this);
        pe.d(jSONObject, this);
        pe.e(jSONObject, this);
        pe.g(jSONObject, this);
    }

    public void a(oe oeVar) {
        if (i0().d()) {
            return;
        }
        List listC = c(ue.D6);
        if (listC.size() <= 0 || !K().a().containsAll(listC)) {
            return;
        }
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "All required adapters initialized");
        }
        i0().e();
        H0();
    }

    public com.applovin.impl.q e() {
        return a(f63330v0);
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        f63330v0 = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.f63364o0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration) {
        M0();
        this.f63345f.attachAppLovinSdk(this);
        String pluginVersion = appLovinSdkInitializationConfiguration.getPluginVersion();
        if (pluginVersion != null) {
            n.g("AppLovinSdk", "Setting plugin version: " + pluginVersion);
            g0().a(sj.K3, pluginVersion);
        }
        if (appLovinSdkInitializationConfiguration.isExceptionHandlerEnabled() && ((Boolean) a(sj.f63794u)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        tm tmVarI0 = i0();
        yl ylVar = this.f63372s0;
        tm.b bVar = tm.b.CORE;
        tmVarI0.a(ylVar, bVar);
        i0().a(this.f63374t0, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.f63364o0);
    }

    public void c() {
        synchronized (this.f63342d0) {
            try {
                if (!this.f63348g0 && !this.f63350h0) {
                    O0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class d implements ag.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ag f63384a;

        d(ag agVar) {
            this.f63384a = agVar;
        }

        @Override // com.applovin.impl.ag.a
        public void a() {
            j.this.I();
            if (n.a()) {
                j.this.I().d("AppLovinSdk", "Connected to internet - re-initializing SDK");
            }
            synchronized (j.this.f63342d0) {
                try {
                    if (!j.this.f63348g0) {
                        j.this.O0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f63384a.b(this);
        }

        @Override // com.applovin.impl.ag.a
        public void b() {
        }
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.f63359m = appLovinSdk;
    }

    public static String a(String str) {
        return a(str, (List) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.f63364o0);
    }

    public static String a(int i3) {
        return a(i3, (List) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        Iterator it = JsonUtils.getList(jSONObject, "error_messages", Collections.EMPTY_LIST).iterator();
        while (it.hasNext()) {
            n.h("AppLovinSdk", (String) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        o0().a(str);
    }

    public static String a(String str, List list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context contextM = m();
        return a(contextM.getResources().getIdentifier(str, LegacyTokenHelper.TYPE_STRING, contextM.getPackageName()), list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        r12 = r4.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r12.hasNext() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        r13 = (java.util.Map.Entry) r12.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:
    
        if (r11.startsWith((java.lang.String) r13.getKey()) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
    
        r15.f63358l0 = (java.lang.String) r13.getValue();
        I();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
    
        if (com.applovin.impl.sdk.n.a() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009e, code lost:
    
        I().a("AppLovinSdk", "Detected mediation provider: " + r15.f63358l0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b8, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        if (r6.booleanValue() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bf, code lost:
    
        r2.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
    
        r8 = java.lang.Integer.valueOf(r8.intValue() - 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b() {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.j.b():java.lang.String");
    }

    public static String a(int i3, List list) {
        String string = m().getResources().getString(i3);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    public static com.applovin.impl.q a(Context context) {
        if (f63333y0 == null) {
            synchronized (f63334z0) {
                try {
                    if (f63333y0 == null) {
                        f63333y0 = new com.applovin.impl.q(context);
                    }
                } finally {
                }
            }
        }
        return f63333y0;
    }

    public void a(final AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (this.f63370r0.get()) {
            n.h("AppLovinSdk", "Invalid initialization process: please remove the applovin.sdk.key entry from your AndroidManifest.xml and set your SDK key with the AppLovinSdkInitializationConfiguration object. Then initialize the SDK as soon as possible with \"AppLovinSdk#initialize(AppLovinSdkInitializationConfiguration, AppLovinSdk.SdkInitializationListener)\" before accessing any SDK fields or APIs.");
            D().a(ka.V, "legacy_init_already");
            if (yp.c(this)) {
                throw new IllegalStateException("Invalid initialization process: please remove the applovin.sdk.key entry from your AndroidManifest.xml and set your SDK key with the AppLovinSdkInitializationConfiguration object. Then initialize the SDK as soon as possible with \"AppLovinSdk#initialize(AppLovinSdkInitializationConfiguration, AppLovinSdk.SdkInitializationListener)\" before accessing any SDK fields or APIs.");
            }
            return;
        }
        synchronized (this.f63362n0) {
            try {
                if (this.f63360m0 != null) {
                    n.h("AppLovinSdk", "AppLovin SDK already initialized with configuration: " + this.f63360m0 + ". Ignoring the provided initialization configuration.");
                    if (!s0() || sdkInitializationListener == null) {
                        return;
                    }
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.y0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f63642a.b(sdkInitializationListener);
                        }
                    });
                    return;
                }
                this.f63360m0 = appLovinSdkInitializationConfiguration;
                this.f63366p0 = sdkInitializationListener;
                this.f63335a = appLovinSdkInitializationConfiguration.getSdkKey();
                this.f63349h = appLovinSdkInitializationConfiguration.getMediationProvider();
                this.f63347g = appLovinSdkInitializationConfiguration.getSegmentCollection();
                yp.a(new Runnable() { // from class: com.applovin.impl.sdk.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63408a.a(appLovinSdkInitializationConfiguration);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        g0().a(sj.K3, str);
    }

    public void a(String str, AppLovinSdkSettings appLovinSdkSettings) {
        x0().set(true);
        this.f63335a = str;
        this.f63345f = appLovinSdkSettings;
        if (TextUtils.isEmpty(str)) {
            n.h("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            n.h("AppLovinSdk", "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        yp.a(new Runnable() { // from class: com.applovin.impl.sdk.u0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63608a.N0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(JSONObject jSONObject) {
        List listAsList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            MaxAdFormat fromString = MaxAdFormat.formatFromString((String) it.next());
            if (fromString != null) {
                arrayList.add(fromString);
            }
        }
        return arrayList;
    }

    public void a(boolean z2) {
        synchronized (this.f63342d0) {
            this.f63348g0 = false;
            this.f63350h0 = z2;
        }
        if (z2) {
            List listC = c(ue.D6);
            if (listC.isEmpty()) {
                i0().e();
                H0();
                return;
            }
            Long l3 = (Long) a(ue.E6);
            jn jnVar = new jn(this, true, "timeoutInitAdapters", new Runnable() { // from class: com.applovin.impl.sdk.l0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63416a.A0();
                }
            });
            I();
            if (n.a()) {
                I().a("AppLovinSdk", "Waiting for required adapters to init: " + listC + " - timing out in " + l3 + "ms...");
            }
            i0().a(jnVar, tm.b.TIMEOUT, l3.longValue(), true);
        }
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List list = this.f63340c0;
        return (list == null || list.size() <= 0 || this.f63340c0.contains(maxAdFormat)) ? false : true;
    }

    public void a() {
        String str = (String) h0().a(uj.f64229e, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE < yp.f(str)) {
                n.h("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
            }
        }
    }

    public void a(Map map) {
        M().a(map);
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        h0().a(str, obj, editor);
    }

    public Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return vj.a(str, obj, cls, sharedPreferences);
    }

    public void a(SharedPreferences sharedPreferences) {
        h0().a(sharedPreferences);
    }

    public void a(final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!s0()) {
            this.f63366p0 = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63588a.c(sdkInitializationListener);
                }
            });
        }
    }
}

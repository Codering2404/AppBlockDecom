package com.singular.sdk.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularDeviceAttributionHandler;
import com.singular.sdk.internal.ApiCustomUserId;
import com.singular.sdk.internal.ApiGDPRConsent;
import com.singular.sdk.internal.ApiGDPRUnder13;
import com.singular.sdk.internal.ApiStartSession;
import com.singular.sdk.internal.ApiSubmitEvent;
import com.singular.sdk.internal.InstallReferrer.SLDigitalTurbineReferrer;
import com.singular.sdk.internal.InstallReferrer.SLGoogleReferrer;
import com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler;
import com.singular.sdk.internal.InstallReferrer.SLSamsungReferrer;
import com.singular.sdk.internal.utils.SLJsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularInstance {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final SingularLog f92682o = SingularLog.f("Instance");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f92683p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static SingularInstance f92684q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f92685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ApiManager f92686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SingularWorkerThread f92687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SingularConfig f92688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SessionManager f92689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DeviceInfo f92690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap f92691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Map f92692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Map f92693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Map f92694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f92695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f92696l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f92697m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private double f92698n;

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularInstance$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass11 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ApiCustomUserId apiCustomUserId = new ApiCustomUserId(Utils.y());
            apiCustomUserId.e(ApiCustomUserId.Params.m(SingularInstance.f92684q));
            SingularInstance.f92684q.f92686b.c(apiCustomUserId);
        }
    }

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularInstance$14, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass14 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SingularInstance f92705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SingularInstance f92706b;

        @Override // java.lang.Runnable
        public void run() {
            ApiGDPRConsent apiGDPRConsent = new ApiGDPRConsent(Utils.y());
            apiGDPRConsent.e(ApiGDPRConsent.Params.m(this.f92705a));
            this.f92706b.M(apiGDPRConsent);
        }
    }

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularInstance$15, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass15 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SingularInstance f92707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SingularInstance f92708b;

        @Override // java.lang.Runnable
        public void run() {
            ApiGDPRUnder13 apiGDPRUnder13 = new ApiGDPRUnder13(Utils.y());
            apiGDPRUnder13.e(ApiGDPRUnder13.Params.m(this.f92707a));
            this.f92708b.M(apiGDPRUnder13);
        }
    }

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularInstance$16, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass16 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            SingularInstance.f92684q.f92690f.a(SingularInstance.f92684q.f92685a);
        }
    }

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularInstance$17, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass17 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f92709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f92710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SingularInstance f92711c;

        @Override // java.lang.Runnable
        public void run() {
            this.f92711c.V(this.f92709a, this.f92710b);
        }
    }

    private SingularInstance(Context context, SingularConfig singularConfig) {
        SingularLog singularLog = f92682o;
        singularLog.b("SDK version: %s", Constants.f92523b);
        singularLog.b("SDK build info: %s", Constants.f92522a);
        singularLog.b("new SingularInstance() with config: %s", singularConfig);
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            throw new IllegalStateException("Context failed to cast to ApplicationContext");
        }
        this.f92685a = applicationContext;
        this.f92688d = singularConfig;
        SingularWorkerThread singularWorkerThread = new SingularWorkerThread("worker");
        this.f92687c = singularWorkerThread;
        this.f92686b = new ApiManager(new SingularWorkerThread("api"), context, new SQLitePersistentQueue(context));
        singularWorkerThread.start();
        F();
        S(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.1
            @Override // java.lang.Runnable
            public void run() {
                SingularInstance.this.E(this);
            }
        });
    }

    private SharedPreferences B() {
        return this.f92685a.getSharedPreferences("singular-pref-session", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(SingularInstance singularInstance) {
        if (H()) {
            f92682o.c("Singular is already initialized, please don't call init() again.");
            return;
        }
        try {
            singularInstance.f92697m = Utils.t(o());
            if (!Utils.U(this.f92688d.f92436u)) {
                X("fcm_device_token_key", this.f92688d.f92436u);
            }
            String str = this.f92688d.f92421f;
            if (str != null) {
                W(str);
            }
            Boolean bool = this.f92688d.f92437v;
            if (bool != null) {
                K(bool.booleanValue());
            }
            String str2 = this.f92688d.f92422g;
            if (str2 != null) {
                Z(str2);
            }
            singularInstance.f92690f = new DeviceInfo(singularInstance.f92685a, this.f92688d.f92423h, Boolean.valueOf(I()), singularInstance.f92697m);
            ConfigManager.c().o();
            DeviceIDManager.c().i(singularInstance);
            BatchManager.r().x(this.f92685a);
            BatchManager.r().w();
            singularInstance.f92689e = new SessionManager(singularInstance);
            this.f92696l = true;
            f92682o.h("Singular is initialized now.");
        } catch (Throwable th) {
            f92682o.d("error in init()", th);
        }
    }

    private void F() {
        this.f92691g = L();
        if (this.f92688d.f92424i.size() == 0) {
            return;
        }
        HashMap map = (HashMap) this.f92691g.clone();
        for (SingularGlobalProperty singularGlobalProperty : this.f92688d.f92424i.values()) {
            if (singularGlobalProperty.c() || !map.containsKey(singularGlobalProperty.a())) {
                map.put(singularGlobalProperty.a(), singularGlobalProperty.b());
            }
        }
        if (map.size() > 5) {
            return;
        }
        this.f92691g = map;
        Y();
        if (this.f92691g == null) {
            j();
        }
    }

    private boolean J() {
        return (!H() || u() == null || A() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str, boolean z2) {
        SharedPreferences.Editor editorEdit = B().edit();
        editorEdit.putBoolean(str, z2);
        editorEdit.commit();
    }

    private void X(String str, String str2) {
        SharedPreferences.Editor editorEdit = B().edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    private void Y() {
        if (this.f92691g == null) {
            this.f92691g = new HashMap();
        }
        SharedPreferences.Editor editorEdit = B().edit();
        editorEdit.putString("global_properties", r().toString());
        editorEdit.commit();
    }

    public static SingularInstance u() {
        return f92684q;
    }

    public static SingularInstance v(Context context, SingularConfig singularConfig) {
        if (f92684q == null) {
            synchronized (SingularInstance.class) {
                try {
                    if (f92684q == null) {
                        SingularLog.f92732c = singularConfig.f92426k;
                        SingularLog.f92733d = singularConfig.f92427l;
                        f92684q = new SingularInstance(context, singularConfig);
                    }
                } finally {
                }
            }
        }
        SingularInstance singularInstance = f92684q;
        singularInstance.f92688d = singularConfig;
        return singularInstance;
    }

    SessionManager A() {
        return this.f92689e;
    }

    SingularConfig C() {
        return this.f92688d;
    }

    public void D(JSONObject jSONObject) {
        try {
            final Map mapA = SLJsonUtils.a(jSONObject);
            f92682o.a("device attribution json to map: " + mapA);
            final SingularDeviceAttributionHandler singularDeviceAttributionHandler = this.f92688d.f92430o;
            if (mapA == null || singularDeviceAttributionHandler == null) {
                return;
            }
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.18
                @Override // java.lang.Runnable
                public void run() {
                    singularDeviceAttributionHandler.a(mapA);
                }
            });
        } catch (Throwable th) {
            f92682o.a("could not convert device attribution json object to map" + th.getMessage());
        }
    }

    public boolean G() {
        return B().getBoolean("stop_all_tracking", false);
    }

    boolean H() {
        return this.f92696l;
    }

    public boolean I() {
        if (f92684q == null) {
            f92682o.a("isLimitAdvertisingIdentifiers: instance null, returning default false.");
            return false;
        }
        SingularConfig singularConfig = this.f92688d;
        if (singularConfig != null) {
            return singularConfig.f92438w.booleanValue();
        }
        f92682o.a("isLimitAdvertisingIdentifiers: config null, returning default false.");
        return false;
    }

    public void K(boolean z2) {
        V("limit_data_sharing", z2);
    }

    public HashMap L() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(B().getString("global_properties", JsonUtils.EMPTY_JSON));
        } catch (Throwable th) {
            f92682o.c("Failed to parse global properties JSON, using empty object: " + Utils.l(th));
            jSONObject = new JSONObject();
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            } catch (Throwable th2) {
                f92682o.c("Failed to load global property from JSON: " + Utils.l(th2));
            }
        }
        return map;
    }

    void M(final BaseApi baseApi) {
        if (G()) {
            f92682o.a("Tracking was stopped! not logging event!");
        } else if (J()) {
            S(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.5
                @Override // java.lang.Runnable
                public void run() {
                    SingularInstance.f92684q.f92686b.c(baseApi);
                }
            });
        } else {
            R(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.4
                @Override // java.lang.Runnable
                public void run() {
                    SingularInstance.this.M(baseApi);
                }
            });
        }
    }

    void N(final ApiSubmitEvent.RawEvent rawEvent) {
        if (G()) {
            f92682o.a("Tracking was stopped! not logging event!");
        } else if (J()) {
            S(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.3
                @Override // java.lang.Runnable
                public void run() {
                    ApiSubmitEvent apiSubmitEvent = new ApiSubmitEvent(rawEvent.f92487c);
                    apiSubmitEvent.e(ApiSubmitEvent.Params.m(rawEvent, SingularInstance.f92684q));
                    if (!apiSubmitEvent.m() || BatchManager.r() == null) {
                        SingularInstance.f92684q.f92686b.c(apiSubmitEvent);
                    } else {
                        BatchManager.r().n(apiSubmitEvent);
                    }
                }
            });
        } else {
            R(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.2
                @Override // java.lang.Runnable
                public void run() {
                    SingularInstance.this.N(rawEvent);
                }
            });
        }
    }

    public boolean O(String str) {
        return P(str, null);
    }

    public boolean P(String str, String str2) {
        int length = (str != null ? str.length() : 0) + (str2 != null ? str2.length() : 0);
        if (length > 3746) {
            f92682o.b("Event discarded! payload length = %d", Integer.valueOf(length));
            return false;
        }
        N(new ApiSubmitEvent.RawEvent(str, str2));
        return true;
    }

    void Q(final long j3) {
        if (G()) {
            f92682o.a("Tracking was stopped! not logging event!");
        } else {
            T(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.6
                @Override // java.lang.Runnable
                public void run() {
                    if (SingularInstance.f92684q != null) {
                        if (!SingularInstance.this.f92697m) {
                            SingularInstance.this.a0(j3);
                            return;
                        }
                        SingularInstance.this.m();
                        SingularInstance.this.k();
                        SingularInstance.this.l(j3);
                    }
                }
            });
        }
    }

    void R(Runnable runnable) {
        if (f92683p < 10) {
            U(runnable, 200);
            f92683p++;
        }
    }

    void S(Runnable runnable) {
        this.f92687c.c(runnable);
    }

    void T(Runnable runnable) {
        this.f92687c.d(runnable);
    }

    void U(Runnable runnable, int i3) {
        this.f92687c.e(runnable, i3);
    }

    public void W(String str) {
        SharedPreferences.Editor editorEdit = B().edit();
        editorEdit.putString("custom_user_id", str);
        editorEdit.commit();
        DeviceInfo deviceInfo = this.f92690f;
        if (deviceInfo != null) {
            deviceInfo.r(str);
        }
    }

    public void Z(String str) {
        Utils.o0(str);
    }

    void a0(long j3) {
        ApiStartSession apiStartSession = new ApiStartSession(j3);
        apiStartSession.e(ApiStartSession.Params.m(j3, f92684q));
        f92684q.f92686b.c(apiStartSession);
        SingularInstance singularInstance = f92684q;
        singularInstance.f92688d.f92419d = null;
        singularInstance.f92697m = false;
    }

    public void b0() {
        if (this.f92688d.f92428m == null) {
            return;
        }
        S(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.13
            @Override // java.lang.Runnable
            public void run() {
                SingularInstance.this.f92689e.t(Utils.y());
            }
        });
    }

    public void c0() {
        S(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.12
            @Override // java.lang.Runnable
            public void run() {
                SingularInstance.this.f92689e.t(Utils.y());
            }
        });
    }

    public void j() {
        this.f92691g = null;
        Y();
    }

    void k() {
        new SLDigitalTurbineReferrer().c(o(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.8
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void a(Map map) {
                if (map == null || !map.containsKey("dt_referrer")) {
                    return;
                }
                SingularInstance.this.f92695k = map.get("dt_referrer").toString();
            }
        });
    }

    void l(long j3) {
        final long jY = Utils.y();
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new SLGoogleReferrer().d(o(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.9
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void a(Map map) {
                SingularInstance.this.f92692h = map;
                countDownLatch.countDown();
                SingularInstance.this.f92698n = Utils.e0(jY);
            }
        });
        new SLSamsungReferrer().a(o(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.10
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void a(Map map) {
                SingularInstance.this.f92693i = map;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e3) {
            f92682o.a("InterruptedException while waiting for install referrer: " + Utils.l(e3));
        }
        a0(j3);
    }

    void m() {
        new SLMetaReferrer().a(o(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.7
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void a(Map map) {
                SingularInstance.this.f92694j = map;
            }
        });
    }

    ApiManager n() {
        return this.f92686b;
    }

    Context o() {
        return this.f92685a;
    }

    public String p() {
        return this.f92695k;
    }

    DeviceInfo q() {
        return this.f92690f;
    }

    public JSONObject r() {
        return new JSONObject(this.f92691g);
    }

    public Map s() {
        return this.f92692h;
    }

    public double t() {
        return this.f92698n;
    }

    public boolean w() {
        return this.f92697m;
    }

    public Boolean x() {
        SharedPreferences sharedPreferencesB = B();
        if (sharedPreferencesB.contains("limit_data_sharing")) {
            return Boolean.valueOf(sharedPreferencesB.getBoolean("limit_data_sharing", false));
        }
        return null;
    }

    public Map y() {
        return this.f92694j;
    }

    public Map z() {
        return this.f92693i;
    }
}

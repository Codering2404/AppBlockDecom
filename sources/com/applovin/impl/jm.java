package com.applovin.impl;

import android.app.ActivityManager;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.applovin.impl.l0;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.vi;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.GraphRequest;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.security.ProviderInstaller;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.comparisons.xn.YvFRmou;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class jm extends yl {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicBoolean f60777k = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f60778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f60779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f60780j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c extends yl {
        public c(com.applovin.impl.sdk.j jVar) {
            super("TaskTimeoutFetchBasicSettings", jVar, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jm.this.f60780j != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "Timing out fetch basic settings...");
                }
                jm.this.a(new JSONObject());
            }
        }
    }

    public jm(int i3, com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskFetchBasicSettings", jVar, true);
        this.f60779i = new Object();
        this.f60778h = i3;
        this.f60780j = bVar;
    }

    private String f() {
        return e4.a((String) this.f65231a.a(sj.f63782q0), "5.0/i", b());
    }

    private String g() {
        return e4.a((String) this.f65231a.a(sj.f63778p0), "5.0/i", b());
    }

    protected Map h() {
        HashMap map = new HashMap();
        if (!((Boolean) this.f65231a.a(sj.o5)).booleanValue() && !((Boolean) this.f65231a.a(sj.n5)).booleanValue()) {
            map.put("rid", UUID.randomUUID().toString());
        }
        if (!((Boolean) this.f65231a.a(sj.a5)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f65231a.a0());
        }
        Boolean boolB = a4.b().b(a());
        if (boolB != null) {
            map.put("huc", boolB.toString());
        }
        Boolean boolB2 = a4.c().b(a());
        if (boolB2 != null) {
            map.put("aru", boolB2.toString());
        }
        Boolean boolB3 = a4.a().b(a());
        if (boolB3 != null) {
            map.put("dns", boolB3.toString());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!z3.k() && f60777k.compareAndSet(false, true)) {
            try {
                ProviderInstaller.a(com.applovin.impl.sdk.j.m());
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "Cannot update security provider", th);
                }
            }
        }
        Map mapH = h();
        a.C0125a c0125aB = com.applovin.impl.sdk.network.a.a(this.f65231a).b(g()).a(f()).b(mapH).a(e()).b(((Boolean) this.f65231a.a(sj.z5)).booleanValue()).c("POST").a((Object) new JSONObject()).a(((Integer) this.f65231a.a(sj.e3)).intValue()).b(((Integer) this.f65231a.a(sj.h3)).intValue());
        com.applovin.impl.sdk.j jVar = this.f65231a;
        sj sjVar = sj.d3;
        com.applovin.impl.sdk.network.a aVarA = c0125aB.c(((Integer) jVar.a(sjVar)).intValue()).e(((Boolean) this.f65231a.a(sj.q3)).booleanValue()).a(vi.a.a(((Integer) this.f65231a.a(sj.f5)).intValue())).f(true).a();
        this.f65231a.i0().a(new c(this.f65231a), tm.b.TIMEOUT, ((long) ((Integer) this.f65231a.a(sjVar)).intValue()) + 250);
        a aVar = new a(aVarA, this.f65231a, d());
        aVar.c(sj.f63778p0);
        aVar.b(sj.f63782q0);
        this.f65231a.i0().a(aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z2) {
            super(aVar, jVar, z2);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            jm.this.a(jSONObject);
            this.f65231a.D().a("fetchBasicSettings", str, i3);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Unable to fetch basic SDK settings: server returned " + i3);
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jm.this.a(jSONObject);
            this.f65231a.D().a("fetchBasicSettings", str, i3, CollectionUtils.hashMap("error_message", str2));
        }
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.applovin.impl.sdk.j jVar = this.f65231a;
            sj sjVar = sj.n5;
            if (((Boolean) jVar.a(sjVar)).booleanValue() || ((Boolean) this.f65231a.a(sjVar)).booleanValue()) {
                jSONObject.put("rid", UUID.randomUUID().toString());
            }
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            JsonUtils.putStringIfValid(jSONObject, "ad_review_sdk_version", v.b());
            jSONObject.put("init_count", this.f60778h);
            jSONObject.put("server_installed_at", this.f65231a.a(sj.f63777p));
            jSONObject.put("legacy", this.f65231a.x0().get());
            if (this.f65231a.t0()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f65231a.r0()) {
                jSONObject.put("first_install_v2", true);
            }
            JsonUtils.putStringIfValid(jSONObject, "process_name", yp.b(a()));
            JsonUtils.putBooleanIfValid(jSONObject, "is_main_process", yp.g(a()));
            JsonUtils.putStringIfValid(jSONObject, "plugin_version", (String) this.f65231a.a(sj.K3));
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider", this.f65231a.N());
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider_v2", this.f65231a.y());
            jSONObject.put("installed_mediation_adapters", ze.a(this.f65231a));
            Map mapB = this.f65231a.x().B();
            jSONObject.put("package_name", mapB.get("package_name"));
            jSONObject.put("app_version", mapB.get("app_version"));
            jSONObject.put(GraphRequest.DEBUG_PARAM, mapB.get(GraphRequest.DEBUG_PARAM));
            jSONObject.put("tg", mapB.get("tg"));
            jSONObject.put("target_sdk", mapB.get("target_sdk"));
            List<String> initializationAdUnitIds = this.f65231a.x0().get() ? this.f65231a.f0().getInitializationAdUnitIds() : this.f65231a.G() != null ? this.f65231a.G().getAdUnitIds() : null;
            if (initializationAdUnitIds != null && initializationAdUnitIds.size() > 0) {
                List<String> listRemoveTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(initializationAdUnitIds);
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(listRemoveTrimmedEmptyStrings, listRemoveTrimmedEmptyStrings.size()));
            }
            jSONObject.put("IABTCF_TCString", mapB.get("IABTCF_TCString"));
            jSONObject.put("IABTCF_gdprApplies", mapB.get("IABTCF_gdprApplies"));
            Object obj = mapB.get("IABTCF_AddtlConsent");
            if (obj instanceof String) {
                JsonUtils.putStringIfValid(jSONObject, "IABTCF_AddtlConsent", (String) obj);
            }
            jSONObject.put("consent_flow_info", this.f65231a.u().c());
            Map mapH = this.f65231a.x().H();
            jSONObject.put("platform", mapH.get("platform"));
            jSONObject.put("os", mapH.get("os"));
            jSONObject.put("locale", mapH.get("locale"));
            jSONObject.put("brand", mapH.get("brand"));
            jSONObject.put("brand_name", mapH.get("brand_name"));
            jSONObject.put("hardware", mapH.get("hardware"));
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, mapH.get(DeviceRequestsHelper.DEVICE_INFO_MODEL));
            jSONObject.put("revision", mapH.get("revision"));
            jSONObject.put("is_tablet", mapH.get("is_tablet"));
            jSONObject.put("screen_size_in", mapH.get("screen_size_in"));
            jSONObject.put("supported_abis", mapH.get("supported_abis"));
            if (((Boolean) this.f65231a.a(sj.V3)).booleanValue()) {
                jSONObject.put(KqqtdetwHMIO.eKmElF, this.f65231a.e0().getLastTrimMemoryLevel());
            }
            try {
                ActivityManager activityManager = (ActivityManager) com.applovin.impl.sdk.j.m().getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("fm", memoryInfo.availMem);
                    jSONObject.put("tm", memoryInfo.totalMem);
                    jSONObject.put("lmt", memoryInfo.threshold);
                    jSONObject.put("lm", memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            l0.a aVarF = this.f65231a.x().f();
            jSONObject.put("dnt", aVarF.c());
            jSONObject.put("dnt_code", aVarF.b().b());
            Boolean boolB = a4.c().b(a());
            if (((Boolean) this.f65231a.a(sj.H3)).booleanValue() && StringUtils.isValidString(aVarF.a()) && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfa", aVarF.a());
            }
            k.b bVarC = this.f65231a.x().C();
            if (((Boolean) this.f65231a.a(sj.A3)).booleanValue() && bVarC != null && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfv", bVarC.f63403a);
                jSONObject.put("idfv_scope", bVarC.f63404b);
            }
            if (((Boolean) this.f65231a.a(sj.D3)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f65231a.r());
            }
            if (((Boolean) this.f65231a.a(sj.F3)).booleanValue()) {
                jSONObject.put(tDEtWsFLJfe.bRFpCEc, this.f65231a.Z());
            }
            if (this.f65231a.k0().c()) {
                jSONObject.put("test_mode", true);
            }
            List listB = this.f65231a.k0().b();
            if (listB != null && !listB.isEmpty()) {
                jSONObject.put("test_mode_networks", listB);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.f65231a.f0().getExtraParameters()));
            Map mapC0 = this.f65231a.c0();
            if (!CollectionUtils.isEmpty(mapC0)) {
                jSONObject.put("segments", new JSONObject(mapC0));
            }
            if (this.f60778h > 1) {
                ArrayService arrayServiceN = this.f65231a.n();
                if (arrayServiceN.getIsDirectDownloadEnabled() != null) {
                    jSONObject.put("ah_dd_enabled", arrayServiceN.getIsDirectDownloadEnabled());
                }
                jSONObject.put("ah_sdk_version_code", arrayServiceN.getAppHubVersionCode());
                jSONObject.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceN.getRandomUserToken()));
                jSONObject.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceN.getAppHubPackageName()));
            }
        } catch (JSONException e3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, YvFRmou.aSYcSKqQdukjYB, e3);
            }
            this.f65231a.D().a(this.f65232b, "createJSONBody", e3);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        b bVar;
        synchronized (this.f60779i) {
            bVar = this.f60780j;
            this.f60780j = null;
        }
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }
}

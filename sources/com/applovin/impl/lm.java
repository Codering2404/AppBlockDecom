package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.vi;
import com.applovin.impl.we;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.AppEventsConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class lm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f61239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f61240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f61241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f61242k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f61243l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final JSONArray f61244m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Context f61245n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final a.InterfaceC0110a f61246o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, JSONObject jSONObject) {
            lm.this.a(str, i3, str2);
            this.f65231a.D().a("fetchMediatedAd", str, i3, CollectionUtils.hashMap("error_message", str2));
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, JSONObject jSONObject, int i3) {
            if (i3 != 200) {
                lm.this.a(str, i3, (String) null);
                return;
            }
            JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f59273m.a());
            JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f59273m.b());
            HashMap map = new HashMap(6);
            CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
            CollectionUtils.putStringIfValid("code", String.valueOf(i3), map);
            CollectionUtils.putStringIfValid("ad_unit_id", lm.this.f61239h, map);
            CollectionUtils.putStringIfValid("ad_format", lm.this.f61240i.getLabel(), map);
            CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.f59273m.a()), map);
            CollectionUtils.putStringIfValid("response_size", String.valueOf(this.f59273m.b()), map);
            this.f65231a.D().a(ka.C, (Map) map);
            lm.this.b(jSONObject);
        }
    }

    public lm(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, JSONArray jSONArray, Context context, com.applovin.impl.sdk.j jVar, a.InterfaceC0110a interfaceC0110a) {
        super("TaskFetchMediatedAd", jVar, str);
        this.f61239h = str;
        this.f61240i = maxAdFormat;
        this.f61241j = map;
        this.f61242k = map2;
        this.f61243l = map3;
        this.f61244m = jSONArray;
        this.f61245n = context;
        this.f61246o = interfaceC0110a;
    }

    private void c(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f65231a.P().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData == null || !yp.f(com.applovin.impl.sdk.j.m())) {
            return;
        }
        JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
    }

    private void d(JSONObject jSONObject) {
        if (((Boolean) this.f65231a.a(sj.C4)).booleanValue()) {
            xe xeVarQ = this.f65231a.Q();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            ve veVar = ve.f64421c;
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) xeVarQ.a(veVar, we.a.AD_UNIT_ID));
            JsonUtils.putJSONObject(jSONObject2, "arpau", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.putAll(jSONObject4, (Map<String, ?>) xeVarQ.a(veVar, we.a.AD_FORMAT));
            JsonUtils.putJSONObject(jSONObject2, "arpaf", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            JsonUtils.putAll(jSONObject5, (Map<String, ?>) xeVarQ.a(ve.f64422d, we.a.AD));
            JsonUtils.putJSONObject(jSONObject2, "ttdasipa_ms", jSONObject5);
            JsonUtils.putJSONObject(jSONObject, "mediation_stats", jSONObject2);
        }
    }

    private String e() {
        return pe.a(this.f65231a);
    }

    private String f() {
        return pe.b(this.f65231a);
    }

    private JSONObject g() throws JSONException {
        Map mapA = this.f65231a.x().a(null, false, true);
        mapA.putAll(this.f61243l);
        JSONObject jSONObject = new JSONObject(mapA);
        e(jSONObject);
        h(jSONObject);
        f(jSONObject);
        c(jSONObject);
        g(jSONObject);
        d(jSONObject);
        return jSONObject;
    }

    private void h(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f61244m;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Fetching next ad for " + this.f61240i.getLabel() + " ad unit " + this.f61239h);
        }
        ob.a();
        if (((Boolean) this.f65231a.a(sj.S3)).booleanValue() && yp.j() && com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "User is connected to a VPN");
        }
        this.f65231a.D().a(ka.B, this.f61240i, this.f61239h, (MaxError) null);
        if (((Boolean) this.f65231a.a(sj.C4)).booleanValue()) {
            xe xeVarQ = this.f65231a.Q();
            ve veVar = ve.f64421c;
            xeVarQ.a(veVar, we.a(this.f61239h));
            xeVarQ.a(veVar, we.a(this.f61240i));
        }
        yp.a(this.f65231a, this.f65232b);
        ca caVarC = this.f65231a.C();
        caVarC.c(ba.f58621s);
        ba baVar = ba.f58609g;
        if (caVarC.b(baVar) == 0) {
            caVarC.b(baVar, System.currentTimeMillis());
        }
        try {
            JSONObject jSONObjectG = g();
            HashMap map = new HashMap();
            if (!((Boolean) this.f65231a.a(sj.p5)).booleanValue() && !((Boolean) this.f65231a.a(sj.n5)).booleanValue()) {
                map.put("rid", UUID.randomUUID().toString());
            }
            if (!((Boolean) this.f65231a.a(sj.a5)).booleanValue()) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f65231a.a0());
            }
            if (this.f65231a.k0().c()) {
                map.put("test_mode", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            List listB = this.f65231a.k0().b();
            String str = this.f65231a.f0().getExtraParameters().get("fan");
            if (listB != null && !listB.isEmpty()) {
                String strJoin = String.join(",", listB);
                map.put("filter_ad_network", strJoin);
                if (!this.f65231a.k0().c()) {
                    map.put("fhkZsVqYC7", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                if (this.f65231a.k0().d()) {
                    map.put("force_ad_network", strJoin);
                }
            } else if (StringUtils.isValidString(str)) {
                map.put("filter_ad_network", str);
            }
            a(caVarC);
            a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f65231a).c("POST").a(h()).b(f()).a(e()).b(map).a(jSONObjectG).b(((Boolean) this.f65231a.a(ue.N7)).booleanValue()).a((Object) new JSONObject()).c(((Long) this.f65231a.a(ue.I6)).intValue()).a(((Integer) this.f65231a.a(sj.Y2)).intValue()).b(((Long) this.f65231a.a(ue.H6)).intValue()).a(vi.a.a(((Integer) this.f65231a.a(sj.g5)).intValue())).f(true).a(), this.f65231a);
            aVar.c(ue.F6);
            aVar.b(ue.G6);
            this.f65231a.i0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Unable to fetch ad for Ad Unit ID: " + this.f61239h, th);
            }
            a("", 0, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        try {
            e4.c(jSONObject, this.f65231a);
            e4.b(jSONObject, this.f65231a);
            e4.a(jSONObject, this.f65231a);
            pe.f(jSONObject, this.f65231a);
            pe.d(jSONObject, this.f65231a);
            pe.e(jSONObject, this.f65231a);
            pe.g(jSONObject, this.f65231a);
            u0.b(this.f65231a);
            MaxAdFormat fromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "ad_format", null));
            if (this.f61240i == fromString) {
                a(jSONObject);
                return;
            }
            String label = fromString != null ? fromString.getLabel() : "UNKNOWN";
            String str = "Incorrect format (" + label + ") loaded for (" + this.f61240i.getLabel() + ") ad. Please verify if the ad unit ID (" + this.f61239h + ") is assigned to the correct ad format.";
            if (yp.a(this.f61240i, fromString)) {
                com.applovin.impl.sdk.n.j(this.f65232b, str);
                a(jSONObject);
                return;
            }
            p6.a(str, new Object[0]);
            com.applovin.impl.sdk.n.h(this.f65232b, str);
            this.f61246o.onAdLoadFailed(this.f61239h, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str));
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("ad_unit_id", this.f61239h);
            CollectionUtils.putStringIfValid("name", this.f61240i.getLabel(), mapHashMap);
            CollectionUtils.putStringIfValid("details", label, mapHashMap);
            this.f65231a.D().a(ka.V, "incompatible_ad_format", (Map) mapHashMap);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Unable to process mediated ad response for ad unit " + this.f61239h, th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f61239h);
        jSONObject2.put("ad_format", this.f61240i.getLabel());
        Map map = CollectionUtils.map(this.f61242k);
        com.applovin.impl.sdk.o oVarS = this.f65231a.S();
        CollectionUtils.putStringIfValid("previous_request_id", oVarS.b(this.f61239h), map);
        CollectionUtils.putStringIfValid("previous_loaded_request_id", oVarS.a(this.f61239h), map);
        o.a aVarC = oVarS.c(this.f61239h);
        if (aVarC != null) {
            if (Boolean.parseBoolean(this.f65231a.f0().getExtraParameters().get("esc"))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", "AppLovin");
            } else {
                map.put("previous_winning_network", aVarC.a());
                map.put("previous_winning_network_name", aVarC.c());
                CollectionUtils.putStringIfValid("second_previous_winning_network", aVarC.d(), map);
                CollectionUtils.putStringIfValid("second_previous_winning_network_name", aVarC.e(), map);
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void f(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.f65231a.L().a()));
            jSONObject2.put("installed", ze.a(this.f65231a));
            jSONObject2.put("initialized", this.f65231a.K().b());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.f65231a.K().a()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f65231a.L().c()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f65231a.L().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Failed to populate adapter classNames", e3);
            }
            throw new RuntimeException("Failed to populate classNames: " + e3);
        }
    }

    private Map h() {
        HashMap map = new HashMap(2);
        map.put("AppLovin-Ad-Unit-Id", this.f61239h);
        map.put("AppLovin-Ad-Format", this.f61240i.getLabel());
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", this.f61242k.get("retry_attempt"), map);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", this.f61242k.get("retry_delay_sec"), map);
        return map;
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        yl xmVar;
        if (this.f65231a.a(ue.A7, this.f61240i)) {
            jSONObject2 = jSONObject;
            xmVar = new wm(this.f61239h, this.f61240i, this.f61241j, jSONObject2, this.f61245n, this.f65231a, this.f61246o);
        } else {
            jSONObject2 = jSONObject;
            xmVar = new xm(this.f61239h, this.f61240i, this.f61241j, jSONObject, this.f61245n, this.f65231a, this.f61246o);
        }
        long j3 = JsonUtils.getLong(jSONObject2, "process_waterfall_delay_ms", -1L);
        if (j3 > 0) {
            this.f65231a.i0().a(xmVar, tm.b.MEDIATION, j3, true);
        } else {
            this.f65231a.i0().a(xmVar);
        }
    }

    private void a(ca caVar) {
        ba baVar = ba.f58609g;
        long jB = caVar.b(baVar);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jB > TimeUnit.MINUTES.toMillis(((Integer) this.f65231a.a(sj.u3)).intValue())) {
            caVar.b(baVar, jCurrentTimeMillis);
            caVar.a(ba.f58610h);
            caVar.a(ba.f58611i);
        }
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f65231a.f0().getExtraParameters()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i3, String str2) {
        MaxErrorImpl maxErrorImpl;
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Unable to fetch ad for ad unit " + this.f61239h + ": server returned " + i3);
        }
        if (i3 == -800) {
            this.f65231a.C().c(ba.f58622t);
        }
        if (i3 == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str2);
        } else if (i3 == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str2);
        } else if (StringUtils.isValidString(str2)) {
            maxErrorImpl = new MaxErrorImpl(-1000, str2);
        } else {
            maxErrorImpl = new MaxErrorImpl(-1);
        }
        HashMap map = new HashMap(5);
        CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
        CollectionUtils.putStringIfValid("code", String.valueOf(i3), map);
        CollectionUtils.putStringIfValid("error_message", str2, map);
        CollectionUtils.putStringIfValid("ad_unit_id", this.f61239h, map);
        CollectionUtils.putStringIfValid("ad_format", this.f61240i.getLabel(), map);
        this.f65231a.D().a(ka.D, (Map) map);
        fc.a(this.f61246o, this.f61239h, maxErrorImpl);
    }
}

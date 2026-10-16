package com.singular.sdk.internal;

import com.facebook.appevents.AppEventsConstants;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
abstract class BaseApi extends SingularMap implements Api {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SingularLog f92488b = SingularLog.f(BaseApi.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f92489a = false;

    public BaseApi(String str, long j3) {
        put("__TYPE__", str);
        put("__TIMESTAMP__", String.valueOf(j3));
    }

    public static BaseApi h(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("api string cannot be null");
        }
        Map mapI = i(str);
        String str2 = (String) mapI.get("__TYPE__");
        String str3 = (String) mapI.get("__TIMESTAMP__");
        long j3 = !Utils.U(str3) ? Long.parseLong(str3) : -1L;
        int iS = Utils.s(SingularInstance.u().o(), str3);
        if (iS > 0) {
            mapI.put("rc", String.valueOf(iS));
        }
        if ("CONFIG".equalsIgnoreCase(str2)) {
            ApiConfig apiConfig = new ApiConfig(j3);
            apiConfig.e(mapI);
            return apiConfig;
        }
        if ("EVENT".equalsIgnoreCase(str2)) {
            ApiSubmitEvent apiSubmitEvent = new ApiSubmitEvent(j3);
            apiSubmitEvent.e(mapI);
            return apiSubmitEvent;
        }
        if ("SESSION_START".equalsIgnoreCase(str2)) {
            ApiStartSession apiStartSession = new ApiStartSession(j3);
            apiStartSession.e(mapI);
            return apiStartSession;
        }
        if ("GDPR_CONSENT".equalsIgnoreCase(str2)) {
            ApiGDPRConsent apiGDPRConsent = new ApiGDPRConsent(j3);
            apiGDPRConsent.e(mapI);
            return apiGDPRConsent;
        }
        if ("GDPR_UNDER_13".equalsIgnoreCase(str2)) {
            ApiGDPRUnder13 apiGDPRUnder13 = new ApiGDPRUnder13(j3);
            apiGDPRUnder13.e(mapI);
            return apiGDPRUnder13;
        }
        if (!"CUSTOM_USER_ID".equalsIgnoreCase(str2)) {
            throw new InvalidPropertiesFormatException(String.format("Unknown type = %s", str2));
        }
        ApiCustomUserId apiCustomUserId = new ApiCustomUserId(j3);
        apiCustomUserId.e(mapI);
        return apiCustomUserId;
    }

    private static Map i(String str) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, (String) jSONObject.get(next));
            }
            return map;
        } catch (JSONException e3) {
            throw new IOException(e3);
        }
    }

    public boolean b(SingularInstance singularInstance) {
        q(singularInstance);
        r(singularInstance);
        o(singularInstance);
        return SingularRequestHandler.g(singularInstance, k(), j(), getTimestamp(), a());
    }

    void e(Map map) {
        if (map == null) {
            f92488b.a("addParams: params is null, skipping");
        } else {
            putAll(map);
        }
    }

    public long getTimestamp() {
        String str = get("__TIMESTAMP__");
        if (Utils.U(str)) {
            return -1L;
        }
        return Long.parseLong(str);
    }

    Map j() {
        HashMap map = new HashMap(this);
        map.remove("__TYPE__");
        map.remove("__TIMESTAMP__");
        return map;
    }

    public String k() {
        return "https://sdk-api-v1.singular.net/api/v1" + g();
    }

    public boolean m() {
        try {
            String str = get("e");
            if (str != null) {
                return new JSONObject(str).getBoolean("is_admon_revenue");
            }
            return false;
        } catch (Throwable th) {
            f92488b.a("Not an admon event: " + th.getMessage());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    void o(SingularInstance singularInstance) {
        boolean z2;
        SingularConfig singularConfigC = singularInstance.C();
        if (singularConfigC == null) {
            f92488b.a("sanitizeRequestIfNeeded: config null. skipping.");
            return;
        }
        if (!singularConfigC.f92438w.booleanValue()) {
            f92488b.a("sanitizeRequestIfNeeded: not needed. skipping.");
            return;
        }
        if (!containsKey("k")) {
            f92488b.a("sanitizeRequestIfNeeded: no k param in request. skipping.");
            return;
        }
        String str = (String) get("k");
        if (Utils.U(str)) {
            f92488b.a("sanitizeRequestIfNeeded: no &k= value. skipping.");
            return;
        }
        boolean z3 = false;
        if (Constants.LimitedAdvertisingIdentifiers.f92527b.contains(str)) {
            f92488b.a("sanitizeRequestIfNeeded: limited identifier found, removing &k=" + str + " and &u= params.");
            remove("k");
            remove("u");
            z2 = true;
        } else {
            z2 = false;
        }
        for (String str2 : Constants.LimitedAdvertisingIdentifiers.f92526a) {
            if (containsKey(str2)) {
                f92488b.a("sanitizeRequestIfNeeded: limited identifier found, removing param &" + str2);
                remove(str2);
                z3 = true;
            }
        }
        if (z2 || z3) {
            f92488b.a("sanitizeRequestIfNeeded: updating request params from withDeviceInfo according to current state of limitAdvertisingIdentifiers.");
            putAll(new SingularParamsBase().j(singularInstance, this.f92489a));
        }
        ?? BooleanValue = singularConfigC.f92438w.booleanValue();
        int i3 = BooleanValue;
        if (z2) {
            i3 = BooleanValue + 2;
        }
        if (z3) {
            i3 += 4;
        }
        put("lim", String.valueOf(i3));
        f92488b.a("sanitizeRequestIfNeeded: added sanitize result: &lim=" + i3);
    }

    public String p() {
        return new JSONObject(this).toString();
    }

    void q(SingularInstance singularInstance) {
        try {
            if (DeviceIDManager.c().b(ConfigManager.c(), singularInstance.o()) == null) {
                put("mg", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                f92488b.a("BaseApi: no SDID model available in device id manager, skipping migration.");
                return;
            }
            if (((String) j().get("k")).equalsIgnoreCase("sdid")) {
                put("mg", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                f92488b.a("BaseApi: not migrated, this api already has k=SDID, skipping migration.");
            } else if (!this.f92489a && !DeviceIDManager.c().a(singularInstance.o())) {
                put("mg", "3");
                f92488b.a("BaseApi: no session sent with SDID yet, skipping migration.");
            } else {
                putAll(new SingularParamsBase().j(singularInstance, this.f92489a));
                put("mg", "2");
                f92488b.a("BaseApi: migrated api to k=SDID");
            }
        } catch (Throwable unused) {
            put("mg", "5");
            f92488b.c("BaseApi: failed to migrate event to SDID");
        }
    }

    void r(SingularInstance singularInstance) {
        try {
            if (j().containsKey("k")) {
                f92488b.a("BaseApi: this api already has 'k' param, skipping updating k and u");
                return;
            }
            f92488b.a("BaseApi: this api has no 'k' param, try updating the k and u");
            putAll(new SingularParamsBase().j(singularInstance, this.f92489a));
            put("msk", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } catch (Throwable th) {
            f92488b.c("BaseApi: failed to update to valid k and u with exception: " + Utils.l(th));
            put("msk", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }
}

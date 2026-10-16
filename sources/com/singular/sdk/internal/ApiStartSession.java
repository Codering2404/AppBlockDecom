package com.singular.sdk.internal;

import android.net.Uri;
import com.facebook.AuthenticationToken;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularLinkParams;
import com.singular.sdk.internal.Api;
import com.singular.sdk.internal.ApiSubmitEvent;
import com.singular.sdk.internal.LicenseApiHelper;
import com.singular.sdk.internal.utils.UriUtils;
import java.util.HashMap;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ApiStartSession extends BaseApi {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SingularLog f92469d = SingularLog.f(ApiStartSession.class.getSimpleName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f92470c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ApiStartSessionConstants {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class OnSessionStartCallback implements Api.OnApiCallback {

        /* JADX INFO: renamed from: com.singular.sdk.internal.ApiStartSession$OnSessionStartCallback$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SingularInstance f92472a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f92473b;

            AnonymousClass1(SingularInstance singularInstance, String str) {
                this.f92472a = singularInstance;
                this.f92473b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ApiStartSession.u(ApiStartSession.this);
                LicenseApiHelper.a(this.f92472a.o(), new LicenseApiHelper.LicenseResultHandler() { // from class: com.singular.sdk.internal.ApiStartSession.OnSessionStartCallback.1.1
                    @Override // com.singular.sdk.internal.LicenseApiHelper.LicenseResultHandler
                    public void a(final int i3, final String str, final String str2) {
                        new Thread(new Runnable() { // from class: com.singular.sdk.internal.ApiStartSession.OnSessionStartCallback.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (!OnSessionStartCallback.this.d(i3) && ApiStartSession.this.f92470c < 3) {
                                        Thread.sleep(ApiStartSession.this.f92470c * 3000);
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        OnSessionStartCallback.this.e(anonymousClass1.f92472a, anonymousClass1.f92473b);
                                    } else {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("responseCode", String.valueOf(i3));
                                        jSONObject.put("signedData", str);
                                        jSONObject.put(AuthenticationToken.SIGNATURE_KEY, str2);
                                        AnonymousClass1.this.f92472a.N(new ApiSubmitEvent.RawEvent("__LicensingStatus", jSONObject.toString()));
                                    }
                                } catch (Throwable th) {
                                    ApiStartSession.f92469d.d("Error occurred while trying to send licensing status event", th);
                                }
                            }
                        }).start();
                    }
                });
            }
        }

        public OnSessionStartCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d(int i3) {
            return (i3 == -1 || i3 == 257 || i3 == 4) ? false : true;
        }

        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean a(SingularInstance singularInstance, int i3, String str) {
            String str2;
            if (i3 != 200) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "").equalsIgnoreCase("ok")) {
                    return false;
                }
                if (ApiStartSession.this.containsKey("k") && ApiStartSession.this.get("k").equalsIgnoreCase("SDID") && !DeviceIDManager.c().a(singularInstance.o())) {
                    DeviceIDManager.c().h(singularInstance.o());
                }
                String strOptString = jSONObject.optString("ddl", null);
                String strOptString2 = jSONObject.optString("deferred_passthrough", null);
                if (!Utils.a0() && (!Utils.U(strOptString) || !Utils.U(strOptString2))) {
                    c(singularInstance, strOptString, strOptString2);
                }
                String strOptString3 = jSONObject.optString("resolved_singular_link", null);
                if (!Utils.U(strOptString3) && (str2 = ApiStartSession.this.get("singular_link_resolve_required")) != null && Boolean.parseBoolean(str2) && Utils.e0(ApiStartSession.this.getTimestamp()) < SingularInstance.u().C().f92431p) {
                    Utils.N(Uri.parse(strOptString3));
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution_info");
                if (jSONObjectOptJSONObject != null) {
                    singularInstance.D(jSONObjectOptJSONObject);
                }
                String str3 = ApiStartSession.this.get("u");
                if (Utils.U(str3) || Utils.X(singularInstance.o(), str3)) {
                    return true;
                }
                Utils.l0(singularInstance.o(), str3);
                e(singularInstance, str3);
                return true;
            } catch (JSONException e3) {
                ApiStartSession.f92469d.d("error in handle()", e3);
                return false;
            }
        }

        void c(SingularInstance singularInstance, final String str, String str2) {
            final SingularConfig.DDLHandler dDLHandler = singularInstance.C().f92420e;
            if (dDLHandler == null) {
                ApiStartSession.f92469d.e("DDLHandler is not configured, ignoring callback for url = %s", str);
                return;
            }
            if (Utils.e0(ApiStartSession.this.getTimestamp()) > dDLHandler.f92443b) {
                ApiStartSession.f92469d.e("DDLHandler timedout. timeout = %dms", Long.valueOf(dDLHandler.f92443b));
            } else {
                if (Utils.M(new SingularLinkParams(str, str2, true, Uri.parse(str))) || dDLHandler.f92442a == null) {
                    return;
                }
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.ApiStartSession.OnSessionStartCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            dDLHandler.f92442a.a(str);
                        } catch (Throwable th) {
                            ApiStartSession.f92469d.c("DDL handling failed: " + Utils.l(th));
                        }
                    }
                });
            }
        }

        void e(SingularInstance singularInstance, String str) {
            ApiStartSession.f92469d.a("Trying to fetch license key from the Licensing Service");
            new Thread(new AnonymousClass1(singularInstance, str)).start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Params extends SingularParamsBase {
        private Params() {
        }

        static Params m(long j3, SingularInstance singularInstance) {
            return new Params().r(j3).t(singularInstance.C()).q(singularInstance).o(singularInstance).s(singularInstance).p(singularInstance).u();
        }

        private Params o(SingularInstance singularInstance) {
            if (singularInstance.w()) {
                put("is", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                return this;
            }
            put("is", "false");
            return this;
        }

        private Params p(SingularInstance singularInstance) {
            if (singularInstance.w() & (singularInstance.p() != null)) {
                put("dt_referrer", singularInstance.p());
            }
            return this;
        }

        private Params r(long j3) {
            put("s", String.valueOf(j3));
            return this;
        }

        private Params s(SingularInstance singularInstance) {
            if (singularInstance.w()) {
                if (singularInstance.s() != null) {
                    put("install_ref", new JSONObject(singularInstance.s()).toString());
                }
                put("install_ref_timeinterval", String.valueOf(singularInstance.t()));
                HashMap map = new HashMap();
                if (singularInstance.z() != null) {
                    map.putAll(singularInstance.z());
                }
                if (singularInstance.y() != null) {
                    map.putAll(singularInstance.y());
                }
                put("referrer_data", new JSONObject(map).toString());
            }
            return this;
        }

        private Params u() {
            put("asid_timeinterval", String.valueOf(Utils.p()));
            put("asid_scope", String.valueOf(Utils.o()));
            String strZ = Utils.z();
            if (!Utils.U(strZ)) {
                put("ek", strZ);
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0055  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected com.singular.sdk.internal.ApiStartSession.Params q(com.singular.sdk.internal.SingularInstance r4) {
            /*
                Method dump skipped, instruction units count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.ApiStartSession.Params.q(com.singular.sdk.internal.SingularInstance):com.singular.sdk.internal.ApiStartSession$Params");
        }

        protected Params t(SingularConfig singularConfig) {
            super.k(singularConfig);
            Uri uri = singularConfig.f92419d;
            if (UriUtils.a(uri)) {
                put("ref", uri.getQueryParameter("referrer"));
                put("extra", uri.getQuery());
            }
            Uri uriH0 = singularConfig.f92428m;
            if (SLPushNotificationsManager.e().d().booleanValue()) {
                uriH0 = SLPushNotificationsManager.e().f();
                put("pu", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            if (singularConfig.f92420e == null && singularConfig.f92429n == null) {
                put("ddl_enabled", "false");
            } else {
                put("ddl_enabled", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                put("ddl_to", String.valueOf(singularConfig.f92420e.f92443b));
            }
            if (UriUtils.a(uriH0)) {
                String queryParameter = uriH0.getQueryParameter("referrer");
                String query = uriH0.getQuery();
                if (!Utils.U(queryParameter)) {
                    put("ref", queryParameter);
                }
                if (!Utils.U(query)) {
                    put("extra", query);
                }
                if (Utils.T(uriH0)) {
                    put("esp_link", uriH0.toString());
                    uriH0 = Utils.h0(uriH0);
                }
                if (Utils.q0(uriH0)) {
                    boolean zB0 = Utils.b0(uriH0);
                    if (!zB0) {
                        Utils.N(uriH0);
                    }
                    put("singular_link", uriH0.toString());
                    put("singular_link_resolve_timeout", String.valueOf(singularConfig.f92431p));
                    put("singular_link_resolve_required", String.valueOf(zB0));
                }
                singularConfig.f92428m = null;
            }
            return this;
        }
    }

    ApiStartSession(long j3) {
        super("SESSION_START", j3);
        this.f92470c = 0;
        this.f92489a = true;
    }

    static /* synthetic */ int u(ApiStartSession apiStartSession) {
        int i3 = apiStartSession.f92470c;
        apiStartSession.f92470c = i3 + 1;
        return i3;
    }

    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback a() {
        return new OnSessionStartCallback();
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ boolean b(SingularInstance singularInstance) {
        return super.b(singularInstance);
    }

    @Override // com.singular.sdk.internal.Api
    public String g() {
        return "/start";
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ long getTimestamp() {
        return super.getTimestamp();
    }

    @Override // com.singular.sdk.internal.BaseApi
    public /* bridge */ /* synthetic */ String k() {
        return super.k();
    }

    @Override // com.singular.sdk.internal.BaseApi
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // com.singular.sdk.internal.BaseApi
    public /* bridge */ /* synthetic */ String p() {
        return super.p();
    }
}

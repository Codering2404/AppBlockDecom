package com.singular.sdk.internal;

import com.facebook.internal.AnalyticsEvents;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ApiSubmitEvent extends BaseApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SingularLog f92483c = SingularLog.f(ApiSubmitEvent.class.getSimpleName());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class OnEventSubmitCallback implements Api.OnApiCallback {
        public OnEventSubmitCallback() {
        }

        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean a(SingularInstance singularInstance, int i3, String str) {
            if (i3 == 413) {
                return true;
            }
            if (i3 != 200) {
                return false;
            }
            try {
            } catch (JSONException e3) {
                ApiSubmitEvent.f92483c.d("error in handle()", e3);
            }
            return new JSONObject(str).optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "").equalsIgnoreCase("ok");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Params extends SingularParamsBase {
        private Params() {
        }

        static Params m(RawEvent rawEvent, SingularInstance singularInstance) {
            return new Params().q(rawEvent.f92485a).p(rawEvent.f92486b).r((rawEvent.f92487c - r0) * 0.001d).t(singularInstance.A().i()).s(singularInstance.A().h()).u(singularInstance.C()).o(singularInstance);
        }

        private Params p(String str) {
            try {
                if (Utils.U(str)) {
                    str = new JSONObject().put("is_revenue_event", false).toString();
                } else {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.optBoolean("is_revenue_event", false)) {
                        str = jSONObject.put("is_revenue_event", false).toString();
                    }
                }
                put("e", str);
                return this;
            } catch (JSONException e3) {
                ApiSubmitEvent.f92483c.d("Error in JSON serialization", e3);
                return this;
            }
        }

        private Params q(String str) {
            put("n", str);
            return this;
        }

        private Params r(double d3) {
            put("t", String.valueOf(d3));
            return this;
        }

        private Params s(long j3) {
            put("seq", String.valueOf(j3));
            return this;
        }

        private Params t(long j3) {
            put("s", String.valueOf(j3));
            return this;
        }

        protected Params o(SingularInstance singularInstance) {
            super.i(singularInstance);
            put("av", singularInstance.q().f92551m);
            put("sdk", Utils.H(singularInstance));
            put("custom_user_id", singularInstance.q().R);
            return this;
        }

        protected Params u(SingularConfig singularConfig) {
            super.k(singularConfig);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RawEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f92485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f92486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f92487c;

        RawEvent(String str, String str2) {
            this.f92485a = str.replace("\\n", "");
            this.f92486b = !Utils.U(str2) ? str2.replace("\\n", "") : null;
            this.f92487c = Utils.y();
        }

        public String toString() {
            return "RawEvent{name='" + this.f92485a + "', extra='" + this.f92486b + "', timestamp=" + this.f92487c + '}';
        }
    }

    ApiSubmitEvent(long j3) {
        super("EVENT", j3);
    }

    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback a() {
        return new OnEventSubmitCallback();
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ boolean b(SingularInstance singularInstance) {
        return super.b(singularInstance);
    }

    @Override // com.singular.sdk.internal.Api
    public String g() {
        return "/event";
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

package com.singular.sdk.internal;

import com.facebook.internal.AnalyticsEvents;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ApiCustomUserId extends BaseApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SingularLog f92456c = SingularLog.f(ApiCustomUserId.class.getSimpleName());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class OnSetCustomUserIdCallback implements Api.OnApiCallback {
        public OnSetCustomUserIdCallback() {
        }

        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean a(SingularInstance singularInstance, int i3, String str) {
            if (i3 != 200) {
                return false;
            }
            try {
                return new JSONObject(str).optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "").equalsIgnoreCase("ok");
            } catch (JSONException e3) {
                ApiCustomUserId.f92456c.d("error in handle()", e3);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Params extends SingularParamsBase {
        private Params() {
        }

        static Params m(SingularInstance singularInstance) {
            return new Params().p(singularInstance.C()).o(singularInstance);
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected com.singular.sdk.internal.ApiCustomUserId.Params o(com.singular.sdk.internal.SingularInstance r4) {
            /*
                r3 = this;
                super.i(r4)
                com.singular.sdk.internal.DeviceInfo r4 = r4.q()
                java.lang.String r0 = "sdk"
                java.lang.String r1 = r4.f92560v
                r3.put(r0, r1)
                java.lang.String r0 = "av"
                java.lang.String r1 = r4.f92551m
                r3.put(r0, r1)
                java.lang.String r0 = "n"
                java.lang.String r1 = r4.f92557s
                r3.put(r0, r1)
                boolean r0 = r4.f92545g
                java.lang.String r1 = "0"
                java.lang.String r2 = "1"
                if (r0 == 0) goto L2a
                boolean r0 = r4.f92546h
                if (r0 == 0) goto L35
            L28:
                r1 = r2
                goto L35
            L2a:
                boolean r0 = r4.f92548j
                if (r0 == 0) goto L33
                boolean r0 = r4.f92546h
                if (r0 == 0) goto L35
                goto L28
            L33:
                java.lang.String r1 = "-1"
            L35:
                java.lang.String r0 = "dnt"
                r3.put(r0, r1)
                java.lang.String r0 = "custom_user_id"
                java.lang.String r4 = r4.R
                r3.put(r0, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.ApiCustomUserId.Params.o(com.singular.sdk.internal.SingularInstance):com.singular.sdk.internal.ApiCustomUserId$Params");
        }

        protected Params p(SingularConfig singularConfig) {
            super.k(singularConfig);
            return this;
        }
    }

    public ApiCustomUserId(long j3) {
        super("CUSTOM_USER_ID", j3);
    }

    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback a() {
        return new OnSetCustomUserIdCallback();
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ boolean b(SingularInstance singularInstance) {
        return super.b(singularInstance);
    }

    @Override // com.singular.sdk.internal.Api
    public String g() {
        return "/set_device_for_custom_id";
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

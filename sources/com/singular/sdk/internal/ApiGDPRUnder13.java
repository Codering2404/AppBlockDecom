package com.singular.sdk.internal;

import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ApiGDPRUnder13 extends BaseApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SingularLog f92460c = SingularLog.f(ApiGDPRUnder13.class.getSimpleName());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class OnResolveCallback implements Api.OnApiCallback {
        public OnResolveCallback() {
        }

        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean a(SingularInstance singularInstance, int i3, String str) {
            return i3 == 200;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Params extends SingularParamsBase {
        private Params() {
        }

        static Params m(SingularInstance singularInstance) {
            return new Params().o().q(singularInstance.C()).p(singularInstance);
        }

        private Params o() {
            put("op", "under_13");
            return this;
        }

        protected Params p(SingularInstance singularInstance) {
            super.i(singularInstance);
            put("sdk", Utils.H(singularInstance));
            return this;
        }

        protected Params q(SingularConfig singularConfig) {
            super.k(singularConfig);
            return this;
        }
    }

    ApiGDPRUnder13(long j3) {
        super("GDPR_UNDER_13", j3);
    }

    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback a() {
        return new OnResolveCallback();
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ boolean b(SingularInstance singularInstance) {
        return super.b(singularInstance);
    }

    @Override // com.singular.sdk.internal.Api
    public String g() {
        return "/opengdpr";
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

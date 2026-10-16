package com.singular.sdk.internal;

import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import com.singular.sdk.internal.DeviceIDManager;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ApiConfig extends BaseApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SingularLog f92452c = SingularLog.f(ApiConfig.class.getSimpleName());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ApiConfigCompletionHandler {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class OnConfigCallback implements Api.OnApiCallback {
        public OnConfigCallback() {
        }

        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean a(SingularInstance singularInstance, int i3, String str) {
            if (i3 != 200 || Utils.U(str)) {
                ConfigManager.c().j("invalid remote config response");
                return false;
            }
            try {
                ConfigManager.c().k(new SLRemoteConfiguration(new JSONObject(str)), singularInstance);
                ApiConfig.this.u(singularInstance);
                return true;
            } catch (JSONException e3) {
                ApiConfig.f92452c.c(Utils.l(e3));
                ConfigManager.c().j(Utils.l(e3));
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Params extends SingularParamsBase {
        private Params() {
        }

        static Params m(SingularInstance singularInstance) {
            return new Params().q(singularInstance).o(singularInstance).p(singularInstance.C());
        }

        private Params q(SingularInstance singularInstance) {
            put("sdk", Utils.H(singularInstance));
            return this;
        }

        protected Params o(SingularInstance singularInstance) {
            super.i(singularInstance);
            return this;
        }

        protected Params p(SingularConfig singularConfig) {
            super.k(singularConfig);
            return this;
        }
    }

    public ApiConfig(long j3) {
        super("CONFIG", j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final SingularInstance singularInstance) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.ApiConfig.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SingularInstance singularInstance2 = singularInstance;
                    if (singularInstance2 == null) {
                        ApiConfig.f92452c.a("can't invoke sdid handlers - singular instance is null");
                        return;
                    }
                    SingularConfig singularConfigC = singularInstance2.C();
                    if (singularConfigC == null) {
                        ApiConfig.f92452c.a("can't invoke sdid handlers - singular config is null");
                        return;
                    }
                    if (singularConfigC.f92440y == null) {
                        ApiConfig.f92452c.a("can't invoke sdid handlers - SDID accessor handler is null");
                        return;
                    }
                    DeviceIDManager.SdidModel sdidModelB = DeviceIDManager.c().b(ConfigManager.c(), singularInstance.o());
                    if (sdidModelB == null) {
                        ApiConfig.f92452c.a("can't invoke sdid handlers - SDID model is null");
                        return;
                    }
                    if (sdidModelB.a() == DeviceIDManager.SdidModel.SdidSource.custom) {
                        ApiConfig.f92452c.a("invoking did set SDID handler");
                        singularConfigC.f92440y.a(sdidModelB.b());
                    } else if (sdidModelB.a() == DeviceIDManager.SdidModel.SdidSource.resolved) {
                        ApiConfig.f92452c.a("invoking SDID received handler");
                        singularConfigC.f92440y.b(sdidModelB.b());
                    }
                } catch (Throwable th) {
                    ApiConfig.f92452c.a("invoking sdid accessor handlers handlers failed with error: " + Utils.l(th));
                }
            }
        });
    }

    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback a() {
        return new OnConfigCallback();
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ boolean b(SingularInstance singularInstance) {
        return super.b(singularInstance);
    }

    @Override // com.singular.sdk.internal.Api
    public String g() {
        return "/config";
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

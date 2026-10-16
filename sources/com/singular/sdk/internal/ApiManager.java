package com.singular.sdk.internal;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ApiManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SingularLog f92462e = SingularLog.f(ApiManager.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f92463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue f92464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SingularWorkerThread f92465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Runnable f92466d = new Runnable() { // from class: com.singular.sdk.internal.ApiManager.2
        @Override // java.lang.Runnable
        public void run() {
            if (!SingularInstance.u().H()) {
                ApiManager.f92462e.a("Singular is not initialized!");
                return;
            }
            if (!NetworkMonitor.g(ApiManager.this.f92463a)) {
                ApiManager.f92462e.a("Oops, not connected to internet!");
                return;
            }
            try {
                String strPeek = ApiManager.this.f92464b.peek();
                if (strPeek == null) {
                    ApiManager.f92462e.a("Queue is empty");
                    return;
                }
                BaseApi baseApiH = BaseApi.h(strPeek);
                ApiManager.f92462e.b("api = %s", baseApiH.getClass().getName());
                if (baseApiH.b(SingularInstance.u())) {
                    Utils.g0(ApiManager.this.f92463a, Long.toString(baseApiH.getTimestamp()));
                    ApiManager.this.f92464b.remove();
                    ApiManager.this.e();
                }
            } catch (Throwable th) {
                ApiManager.f92462e.e("IOException in processing an event: %s", th.getMessage());
            }
        }
    };

    public ApiManager(SingularWorkerThread singularWorkerThread, Context context, Queue queue) {
        this.f92463a = context;
        this.f92464b = queue;
        if (queue == null) {
            f92462e.c("ApiManager initialization failed - queue == null.");
            return;
        }
        SingularLog singularLog = f92462e;
        singularLog.b("Queue: %s", queue.getClass().getSimpleName());
        if (singularWorkerThread == null) {
            singularLog.c("CRITICAL: ApiManager initialization failed - workerThread is null. ApiManager cannot function.");
        } else {
            this.f92465c = singularWorkerThread;
            singularWorkerThread.start();
        }
    }

    static void d(BaseApi baseApi) {
        try {
            SingularInstance singularInstanceU = SingularInstance.u();
            JSONObject jSONObjectR = singularInstanceU.r();
            if (jSONObjectR.length() != 0) {
                baseApi.put("global_properties", jSONObjectR.toString());
            }
            Boolean boolX = singularInstanceU.x();
            if (boolX != null) {
                baseApi.put("data_sharing_options", new JSONObject(new HashMap(boolX) { // from class: com.singular.sdk.internal.ApiManager.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Boolean f92467a;

                    {
                        this.f92467a = boolX;
                        boolX.booleanValue();
                        put("limit_data_sharing", boolX);
                    }
                }).toString());
            }
        } catch (Throwable th) {
            f92462e.c("caught exception during enriching request with SingularInstance " + Utils.l(th));
        }
    }

    void c(BaseApi baseApi) {
        if (baseApi != null) {
            try {
                if (this.f92464b != null) {
                    if (!(baseApi instanceof ApiGDPRConsent) && !(baseApi instanceof ApiGDPRUnder13)) {
                        baseApi.put("event_index", String.valueOf(Utils.A(this.f92463a)));
                    }
                    baseApi.put("singular_install_id", Utils.I(this.f92463a).toString());
                    d(baseApi);
                    this.f92464b.a(baseApi.p());
                    e();
                    return;
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            } catch (Throwable th) {
                f92462e.d("error in enqueue()", th);
                return;
            }
        }
        SingularLog singularLog = f92462e;
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot enqueue API: ");
        sb.append(baseApi == null ? "api == null " : "");
        sb.append(this.f92464b == null ? "queue == null" : "");
        singularLog.c(sb.toString());
    }

    void e() {
        SingularWorkerThread singularWorkerThread = this.f92465c;
        if (singularWorkerThread == null) {
            f92462e.c("Cannot wake up ApiManager: worker is null");
        } else {
            singularWorkerThread.b().removeCallbacksAndMessages(null);
            this.f92465c.c(this.f92466d);
        }
    }
}

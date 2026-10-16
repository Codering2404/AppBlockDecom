package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ExecutorDelivery implements ResponseDelivery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f57663a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResponseDeliveryRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Request f57666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Response f57667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f57668c;

        public ResponseDeliveryRunnable(Request request, Response response, Runnable runnable) {
            this.f57666a = request;
            this.f57667b = response;
            this.f57668c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f57666a.B()) {
                this.f57666a.i("canceled-at-delivery");
                return;
            }
            if (this.f57667b.b()) {
                this.f57666a.f(this.f57667b.f57718a);
            } else {
                this.f57666a.e(this.f57667b.f57720c);
            }
            if (this.f57667b.f57721d) {
                this.f57666a.b("intermediate-response");
            } else {
                this.f57666a.i("done");
            }
            Runnable runnable = this.f57668c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public ExecutorDelivery(final Handler handler) {
        this.f57663a = new Executor() { // from class: com.android.volley.ExecutorDelivery.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.android.volley.ResponseDelivery
    public void a(Request request, Response response) {
        b(request, response, null);
    }

    @Override // com.android.volley.ResponseDelivery
    public void b(Request request, Response response, Runnable runnable) {
        request.C();
        request.b("post-response");
        this.f57663a.execute(new ResponseDeliveryRunnable(request, response, runnable));
    }

    @Override // com.android.volley.ResponseDelivery
    public void c(Request request, VolleyError volleyError) {
        request.b("post-error");
        this.f57663a.execute(new ResponseDeliveryRunnable(request, Response.a(volleyError), null));
    }
}

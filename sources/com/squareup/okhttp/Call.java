package com.squareup.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f92822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f92823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Request f92824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    HttpEngine f92825d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ApplicationInterceptorChain implements Interceptor.Chain {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f92826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Request f92827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f92828c;

        ApplicationInterceptorChain(int i3, Request request, boolean z2) {
            this.f92826a = i3;
            this.f92827b = request;
            this.f92828c = z2;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response a(Request request) {
            if (this.f92826a >= Call.this.f92822a.y().size()) {
                return Call.this.d(request, this.f92828c);
            }
            ApplicationInterceptorChain applicationInterceptorChain = Call.this.new ApplicationInterceptorChain(this.f92826a + 1, request, this.f92828c);
            Interceptor interceptor = (Interceptor) Call.this.f92822a.y().get(this.f92826a);
            Response responseA = interceptor.a(applicationInterceptorChain);
            if (responseA != null) {
                return responseA;
            }
            throw new NullPointerException("application interceptor " + interceptor + " returned null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AsyncCall extends NamedRunnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Callback f92830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f92831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Call f92832d;

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void a() {
            boolean z2;
            IOException e3;
            Response responseE;
            try {
                try {
                    responseE = this.f92832d.e(this.f92831c);
                    z2 = true;
                } catch (Throwable th) {
                    this.f92832d.f92822a.j().a(this);
                    throw th;
                }
            } catch (IOException e4) {
                z2 = false;
                e3 = e4;
            }
            try {
                if (this.f92832d.f92823b) {
                    this.f92830b.b(this.f92832d.f92824c, new IOException("Canceled"));
                } else {
                    this.f92830b.a(responseE);
                }
            } catch (IOException e5) {
                e3 = e5;
                if (z2) {
                    Internal.f93097a.log(Level.INFO, "Callback failure for " + this.f92832d.f(), (Throwable) e3);
                } else {
                    Call call = this.f92832d;
                    HttpEngine httpEngine = call.f92825d;
                    this.f92830b.b(httpEngine == null ? call.f92824c : httpEngine.k(), e3);
                }
            }
            this.f92832d.f92822a.j().a(this);
        }

        String b() {
            return this.f92832d.f92824c.k().q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response e(boolean z2) {
        return new ApplicationInterceptorChain(0, this.f92824c, z2).a(this.f92824c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        return (this.f92823b ? "canceled call" : "call") + " to " + this.f92824c.k().D("/...");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.squareup.okhttp.Response d(com.squareup.okhttp.Request r21, boolean r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Call.d(com.squareup.okhttp.Request, boolean):com.squareup.okhttp.Response");
    }
}

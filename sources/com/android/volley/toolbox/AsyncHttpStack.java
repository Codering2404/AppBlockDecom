package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncHttpStack extends BaseHttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f57739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f57740b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnRequestComplete {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Response {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        HttpResponse f57744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        IOException f57745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AuthFailureError f57746c;
    }

    @Override // com.android.volley.toolbox.BaseHttpStack
    public final HttpResponse b(Request request, Map map) throws IOException, AuthFailureError {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        c(request, map, new OnRequestComplete() { // from class: com.android.volley.toolbox.AsyncHttpStack.1
        });
        try {
            countDownLatch.await();
            Response response = (Response) atomicReference.get();
            HttpResponse httpResponse = response.f57744a;
            if (httpResponse != null) {
                return httpResponse;
            }
            IOException iOException = response.f57745b;
            if (iOException != null) {
                throw iOException;
            }
            throw response.f57746c;
        } catch (InterruptedException e3) {
            VolleyLog.d(e3, "while waiting for CountDownLatch", new Object[0]);
            Thread.currentThread().interrupt();
            throw new InterruptedIOException(e3.toString());
        }
    }

    public abstract void c(Request request, Map map, OnRequestComplete onRequestComplete);

    public void d(ExecutorService executorService) {
        this.f57739a = executorService;
    }

    public void e(ExecutorService executorService) {
        this.f57740b = executorService;
    }
}

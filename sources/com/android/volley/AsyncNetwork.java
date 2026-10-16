package com.android.volley;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncNetwork implements Network {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f57602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f57603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f57604c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnRequestComplete {
        void a(VolleyError volleyError);

        void b(NetworkResponse networkResponse);
    }

    @Override // com.android.volley.Network
    public NetworkResponse a(Request request) throws VolleyError {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        c(request, new OnRequestComplete() { // from class: com.android.volley.AsyncNetwork.1
            @Override // com.android.volley.AsyncNetwork.OnRequestComplete
            public void a(VolleyError volleyError) {
                atomicReference2.set(volleyError);
                countDownLatch.countDown();
            }

            @Override // com.android.volley.AsyncNetwork.OnRequestComplete
            public void b(NetworkResponse networkResponse) {
                atomicReference.set(networkResponse);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            if (atomicReference.get() != null) {
                return (NetworkResponse) atomicReference.get();
            }
            if (atomicReference2.get() != null) {
                throw ((VolleyError) atomicReference2.get());
            }
            throw new VolleyError("Neither response entry was set");
        } catch (InterruptedException e3) {
            VolleyLog.d(e3, "while waiting for CountDownLatch", new Object[0]);
            Thread.currentThread().interrupt();
            throw new VolleyError(e3);
        }
    }

    protected ExecutorService b() {
        return this.f57602a;
    }

    public abstract void c(Request request, OnRequestComplete onRequestComplete);

    public void d(ExecutorService executorService) {
        this.f57602a = executorService;
    }

    public void e(ExecutorService executorService) {
        this.f57603b = executorService;
    }

    public void f(ScheduledExecutorService scheduledExecutorService) {
        this.f57604c = scheduledExecutorService;
    }
}

package com.android.volley;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkDispatcher extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue f57671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Network f57672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Cache f57673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResponseDelivery f57674d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f57675f = false;

    public NetworkDispatcher(BlockingQueue blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.f57671a = blockingQueue;
        this.f57672b = network;
        this.f57673c = cache;
        this.f57674d = responseDelivery;
    }

    private void a(Request request) {
        TrafficStats.setThreadStatsTag(request.y());
    }

    private void b(Request request, VolleyError volleyError) {
        this.f57674d.c(request, request.F(volleyError));
    }

    private void c() throws InterruptedException {
        d((Request) this.f57671a.take());
    }

    void d(Request request) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        request.H(3);
        try {
            try {
                try {
                    request.b("network-queue-take");
                    if (request.B()) {
                        request.i("network-discard-cancelled");
                        request.D();
                        return;
                    }
                    a(request);
                    NetworkResponse networkResponseA = this.f57672b.a(request);
                    request.b("network-http-complete");
                    if (networkResponseA.f57680e && request.A()) {
                        request.i("not-modified");
                        request.D();
                        return;
                    }
                    Response responseG = request.G(networkResponseA);
                    request.b("network-parse-complete");
                    if (request.S() && responseG.f57719b != null) {
                        this.f57673c.c(request.m(), responseG.f57719b);
                        request.b("network-cache-written");
                    }
                    request.C();
                    this.f57674d.a(request, responseG);
                    request.E(responseG);
                } catch (VolleyError e3) {
                    e3.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    b(request, e3);
                    request.D();
                }
            } catch (Exception e4) {
                VolleyLog.d(e4, "Unhandled exception %s", e4.toString());
                VolleyError volleyError = new VolleyError(e4);
                volleyError.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.f57674d.c(request, volleyError);
                request.D();
            }
        } finally {
            request.H(4);
        }
    }

    public void e() {
        this.f57675f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f57675f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}

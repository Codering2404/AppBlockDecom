package com.android.volley;

import android.os.Process;
import com.android.volley.Cache;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CacheDispatcher extends Thread {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f57650h = VolleyLog.f57725b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue f57651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue f57652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Cache f57653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResponseDelivery f57654d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f57655f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WaitingRequestManager f57656g;

    public CacheDispatcher(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.f57651a = blockingQueue;
        this.f57652b = blockingQueue2;
        this.f57653c = cache;
        this.f57654d = responseDelivery;
        this.f57656g = new WaitingRequestManager(this, blockingQueue2, responseDelivery);
    }

    private void b() throws InterruptedException {
        c((Request) this.f57651a.take());
    }

    void c(final Request request) {
        request.b("cache-queue-take");
        request.H(1);
        try {
            if (request.B()) {
                request.i("cache-discard-canceled");
                return;
            }
            Cache.Entry entryA = this.f57653c.a(request.m());
            if (entryA == null) {
                request.b("cache-miss");
                if (!this.f57656g.c(request)) {
                    this.f57652b.put(request);
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (entryA.b(jCurrentTimeMillis)) {
                request.b("cache-hit-expired");
                request.I(entryA);
                if (!this.f57656g.c(request)) {
                    this.f57652b.put(request);
                }
                return;
            }
            request.b("cache-hit");
            Response responseG = request.G(new NetworkResponse(entryA.f57642a, entryA.f57648g));
            request.b("cache-hit-parsed");
            if (!responseG.b()) {
                request.b("cache-parsing-failed");
                this.f57653c.b(request.m(), true);
                request.I(null);
                if (!this.f57656g.c(request)) {
                    this.f57652b.put(request);
                }
                return;
            }
            if (entryA.c(jCurrentTimeMillis)) {
                request.b("cache-hit-refresh-needed");
                request.I(entryA);
                responseG.f57721d = true;
                if (this.f57656g.c(request)) {
                    this.f57654d.a(request, responseG);
                } else {
                    this.f57654d.b(request, responseG, new Runnable() { // from class: com.android.volley.CacheDispatcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CacheDispatcher.this.f57652b.put(request);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });
                }
            } else {
                this.f57654d.a(request, responseG);
            }
        } finally {
            request.H(2);
        }
    }

    public void d() {
        this.f57655f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f57650h) {
            VolleyLog.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f57653c.initialize();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f57655f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}

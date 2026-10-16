package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f57706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f57707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue f57708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue f57709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Cache f57710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Network f57711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ResponseDelivery f57712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final NetworkDispatcher[] f57713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CacheDispatcher f57714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f57715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f57716k;

    /* JADX INFO: renamed from: com.android.volley.RequestQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements RequestFilter {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestEvent {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestEventListener {
        void a(Request request, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestFilter {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface RequestFinishedListener<T> {
        void a(Request request);
    }

    public RequestQueue(Cache cache, Network network, int i3, ResponseDelivery responseDelivery) {
        this.f57706a = new AtomicInteger();
        this.f57707b = new HashSet();
        this.f57708c = new PriorityBlockingQueue();
        this.f57709d = new PriorityBlockingQueue();
        this.f57715j = new ArrayList();
        this.f57716k = new ArrayList();
        this.f57710e = cache;
        this.f57711f = network;
        this.f57713h = new NetworkDispatcher[i3];
        this.f57712g = responseDelivery;
    }

    public Request a(Request request) {
        request.P(this);
        synchronized (this.f57707b) {
            this.f57707b.add(request);
        }
        request.R(f());
        request.b("add-to-queue");
        g(request, 0);
        b(request);
        return request;
    }

    void b(Request request) {
        if (request.S()) {
            this.f57708c.add(request);
        } else {
            h(request);
        }
    }

    void c(Request request) {
        synchronized (this.f57707b) {
            this.f57707b.remove(request);
        }
        synchronized (this.f57715j) {
            try {
                Iterator it = this.f57715j.iterator();
                while (it.hasNext()) {
                    ((RequestFinishedListener) it.next()).a(request);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g(request, 5);
    }

    public Cache d() {
        return this.f57710e;
    }

    public ResponseDelivery e() {
        return this.f57712g;
    }

    public int f() {
        return this.f57706a.incrementAndGet();
    }

    void g(Request request, int i3) {
        synchronized (this.f57716k) {
            try {
                Iterator it = this.f57716k.iterator();
                while (it.hasNext()) {
                    ((RequestEventListener) it.next()).a(request, i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void h(Request request) {
        this.f57709d.add(request);
    }

    public void i() {
        j();
        CacheDispatcher cacheDispatcher = new CacheDispatcher(this.f57708c, this.f57709d, this.f57710e, this.f57712g);
        this.f57714i = cacheDispatcher;
        cacheDispatcher.start();
        for (int i3 = 0; i3 < this.f57713h.length; i3++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f57709d, this.f57711f, this.f57710e, this.f57712g);
            this.f57713h[i3] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void j() {
        CacheDispatcher cacheDispatcher = this.f57714i;
        if (cacheDispatcher != null) {
            cacheDispatcher.d();
        }
        for (NetworkDispatcher networkDispatcher : this.f57713h) {
            if (networkDispatcher != null) {
                networkDispatcher.e();
            }
        }
    }

    public RequestQueue(Cache cache, Network network, int i3) {
        this(cache, network, i3, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }
}

package com.android.volley;

import android.os.SystemClock;
import com.android.volley.AsyncCache;
import com.android.volley.AsyncNetwork;
import com.android.volley.Cache;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AsyncRequestQueue extends RequestQueue {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AsyncCache f57609l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AsyncNetwork f57610m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ExecutorService f57611n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ScheduledExecutorService f57612o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ExecutorService f57613p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ExecutorFactory f57614q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final WaitingRequestManager f57615r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final List f57616s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile boolean f57617t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Object f57618u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: com.android.volley.AsyncRequestQueue$Builder$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends ExecutorFactory {
            private ThreadPoolExecutor d(int i3, String str, BlockingQueue blockingQueue) {
                return new ThreadPoolExecutor(0, i3, 60L, TimeUnit.SECONDS, (BlockingQueue<Runnable>) blockingQueue, e(str));
            }

            private ThreadFactory e(final String str) {
                return new ThreadFactory() { // from class: com.android.volley.AsyncRequestQueue.Builder.1.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                        threadNewThread.setName("Volley-" + str);
                        return threadNewThread;
                    }
                };
            }

            @Override // com.android.volley.AsyncRequestQueue.ExecutorFactory
            public ExecutorService a(BlockingQueue blockingQueue) {
                return d(4, "BlockingExecutor", blockingQueue);
            }

            @Override // com.android.volley.AsyncRequestQueue.ExecutorFactory
            public ExecutorService b(BlockingQueue blockingQueue) {
                return d(1, "Non-BlockingExecutor", blockingQueue);
            }

            @Override // com.android.volley.AsyncRequestQueue.ExecutorFactory
            public ScheduledExecutorService c() {
                return new ScheduledThreadPoolExecutor(0, e("ScheduledExecutor"));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CacheParseTask<T> extends RequestTask<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Cache.Entry f57625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f57626c;

        CacheParseTask(Request request, Cache.Entry entry, long j3) {
            super(request);
            this.f57625b = entry;
            this.f57626c = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f57717a.b("cache-hit");
            Request request = this.f57717a;
            Cache.Entry entry = this.f57625b;
            Response responseG = request.G(new NetworkResponse(200, entry.f57642a, false, 0L, entry.f57649h));
            this.f57717a.b("cache-hit-parsed");
            if (!this.f57625b.c(this.f57626c)) {
                AsyncRequestQueue.this.e().a(this.f57717a, responseG);
                return;
            }
            this.f57717a.b("cache-hit-refresh-needed");
            this.f57717a.I(this.f57625b);
            responseG.f57721d = true;
            if (AsyncRequestQueue.this.f57615r.c(this.f57717a)) {
                AsyncRequestQueue.this.e().a(this.f57717a, responseG);
            } else {
                AsyncRequestQueue.this.e().b(this.f57717a, responseG, new Runnable() { // from class: com.android.volley.AsyncRequestQueue.CacheParseTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CacheParseTask cacheParseTask = CacheParseTask.this;
                        AsyncRequestQueue.this.h(cacheParseTask.f57717a);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CachePutTask<T> extends RequestTask<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Response f57629b;

        CachePutTask(Request request, Response response) {
            super(request);
            this.f57629b = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AsyncRequestQueue.this.f57609l != null) {
                AsyncRequestQueue.this.f57609l.c(this.f57717a.m(), this.f57629b.f57719b, new AsyncCache.OnWriteCompleteCallback() { // from class: com.android.volley.AsyncRequestQueue.CachePutTask.1
                    @Override // com.android.volley.AsyncCache.OnWriteCompleteCallback
                    public void a() {
                        CachePutTask cachePutTask = CachePutTask.this;
                        AsyncRequestQueue.this.s(cachePutTask.f57717a, cachePutTask.f57629b, true);
                    }
                });
            } else {
                AsyncRequestQueue.this.d().c(this.f57717a.m(), this.f57629b.f57719b);
                AsyncRequestQueue.this.s(this.f57717a, this.f57629b, true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CacheTask<T> extends RequestTask<T> {
        CacheTask(Request request) {
            super(request);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f57717a.B()) {
                this.f57717a.i("cache-discard-canceled");
                return;
            }
            this.f57717a.b("cache-queue-take");
            if (AsyncRequestQueue.this.f57609l != null) {
                AsyncRequestQueue.this.f57609l.a(this.f57717a.m(), new AsyncCache.OnGetCompleteCallback() { // from class: com.android.volley.AsyncRequestQueue.CacheTask.1
                    @Override // com.android.volley.AsyncCache.OnGetCompleteCallback
                    public void a(Cache.Entry entry) {
                        CacheTask cacheTask = CacheTask.this;
                        AsyncRequestQueue.this.u(entry, cacheTask.f57717a);
                    }
                });
            } else {
                AsyncRequestQueue.this.u(AsyncRequestQueue.this.d().a(this.f57717a.m()), this.f57717a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ExecutorFactory {
        public abstract ExecutorService a(BlockingQueue blockingQueue);

        public abstract ExecutorService b(BlockingQueue blockingQueue);

        public abstract ScheduledExecutorService c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class NetworkParseTask<T> extends RequestTask<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        NetworkResponse f57634b;

        NetworkParseTask(Request request, NetworkResponse networkResponse) {
            super(request);
            this.f57634b = networkResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            Response responseG = this.f57717a.G(this.f57634b);
            this.f57717a.b("network-parse-complete");
            if (!this.f57717a.S() || responseG.f57719b == null) {
                AsyncRequestQueue.this.s(this.f57717a, responseG, false);
            } else if (AsyncRequestQueue.this.f57609l != null) {
                AsyncRequestQueue.this.f57611n.execute(AsyncRequestQueue.this.new CachePutTask(this.f57717a, responseG));
            } else {
                AsyncRequestQueue.this.f57613p.execute(AsyncRequestQueue.this.new CachePutTask(this.f57717a, responseG));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class NetworkTask<T> extends RequestTask<T> {
        NetworkTask(Request request) {
            super(request);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f57717a.B()) {
                this.f57717a.i("network-discard-cancelled");
                this.f57717a.D();
            } else {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f57717a.b("network-queue-take");
                AsyncRequestQueue.this.f57610m.c(this.f57717a, new AsyncNetwork.OnRequestComplete() { // from class: com.android.volley.AsyncRequestQueue.NetworkTask.1
                    @Override // com.android.volley.AsyncNetwork.OnRequestComplete
                    public void a(VolleyError volleyError) {
                        volleyError.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                        ExecutorService executorService = AsyncRequestQueue.this.f57613p;
                        NetworkTask networkTask = NetworkTask.this;
                        executorService.execute(AsyncRequestQueue.this.new ParseErrorTask(networkTask.f57717a, volleyError));
                    }

                    @Override // com.android.volley.AsyncNetwork.OnRequestComplete
                    public void b(NetworkResponse networkResponse) {
                        NetworkTask.this.f57717a.b("network-http-complete");
                        if (networkResponse.f57680e && NetworkTask.this.f57717a.A()) {
                            NetworkTask.this.f57717a.i("not-modified");
                            NetworkTask.this.f57717a.D();
                        } else {
                            ExecutorService executorService = AsyncRequestQueue.this.f57613p;
                            NetworkTask networkTask = NetworkTask.this;
                            executorService.execute(AsyncRequestQueue.this.new NetworkParseTask(networkTask.f57717a, networkResponse));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ParseErrorTask<T> extends RequestTask<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        VolleyError f57639b;

        ParseErrorTask(Request request, VolleyError volleyError) {
            super(request);
            this.f57639b = volleyError;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncRequestQueue.this.e().c(this.f57717a, this.f57717a.F(this.f57639b));
            this.f57717a.D();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ThrowingCache implements Cache {
        @Override // com.android.volley.Cache
        public Cache.Entry a(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void b(String str, boolean z2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void c(String str, Cache.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void initialize() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Request request, Response response, boolean z2) {
        if (z2) {
            request.b("network-cache-written");
        }
        request.C();
        e().a(request, response);
        request.E(response);
    }

    private static PriorityBlockingQueue t() {
        return new PriorityBlockingQueue(11, new Comparator<Runnable>() { // from class: com.android.volley.AsyncRequestQueue.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Runnable runnable, Runnable runnable2) {
                if (!(runnable instanceof RequestTask)) {
                    return runnable2 instanceof RequestTask ? -1 : 0;
                }
                if (runnable2 instanceof RequestTask) {
                    return ((RequestTask) runnable).a((RequestTask) runnable2);
                }
                return 1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Cache.Entry entry, Request request) {
        if (entry == null) {
            request.b("cache-miss");
            if (this.f57615r.c(request)) {
                return;
            }
            h(request);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!entry.b(jCurrentTimeMillis)) {
            this.f57613p.execute(new CacheParseTask(request, entry, jCurrentTimeMillis));
            return;
        }
        request.b("cache-hit-expired");
        request.I(entry);
        if (this.f57615r.c(request)) {
            return;
        }
        h(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ArrayList arrayList;
        synchronized (this.f57618u) {
            arrayList = new ArrayList(this.f57616s);
            this.f57616s.clear();
            this.f57617t = true;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            b((Request) obj);
        }
    }

    @Override // com.android.volley.RequestQueue
    void b(Request request) {
        if (!this.f57617t) {
            synchronized (this.f57618u) {
                try {
                    if (!this.f57617t) {
                        this.f57616s.add(request);
                        return;
                    }
                } finally {
                }
            }
        }
        if (!request.S()) {
            h(request);
        } else if (this.f57609l != null) {
            this.f57611n.execute(new CacheTask(request));
        } else {
            this.f57613p.execute(new CacheTask(request));
        }
    }

    @Override // com.android.volley.RequestQueue
    void h(Request request) {
        this.f57611n.execute(new NetworkTask(request));
    }

    @Override // com.android.volley.RequestQueue
    public void i() {
        j();
        this.f57611n = this.f57614q.b(t());
        this.f57613p = this.f57614q.a(t());
        this.f57612o = this.f57614q.c();
        this.f57610m.d(this.f57613p);
        this.f57610m.e(this.f57611n);
        this.f57610m.f(this.f57612o);
        if (this.f57609l != null) {
            this.f57611n.execute(new Runnable() { // from class: com.android.volley.AsyncRequestQueue.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncRequestQueue.this.f57609l.b(new AsyncCache.OnWriteCompleteCallback() { // from class: com.android.volley.AsyncRequestQueue.1.1
                        @Override // com.android.volley.AsyncCache.OnWriteCompleteCallback
                        public void a() {
                            AsyncRequestQueue.this.v();
                        }
                    });
                }
            });
        } else {
            this.f57613p.execute(new Runnable() { // from class: com.android.volley.AsyncRequestQueue.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncRequestQueue.this.d().initialize();
                    AsyncRequestQueue.this.f57611n.execute(new Runnable() { // from class: com.android.volley.AsyncRequestQueue.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AsyncRequestQueue.this.v();
                        }
                    });
                }
            });
        }
    }

    @Override // com.android.volley.RequestQueue
    public void j() {
        ExecutorService executorService = this.f57611n;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f57611n = null;
        }
        ExecutorService executorService2 = this.f57613p;
        if (executorService2 != null) {
            executorService2.shutdownNow();
            this.f57613p = null;
        }
        ScheduledExecutorService scheduledExecutorService = this.f57612o;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f57612o = null;
        }
    }
}

package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory A = new EngineResourceFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ResourceCallbacksAndExecutors f66436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StateVerifier f66437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EngineResource.ResourceListener f66438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool f66439d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EngineResourceFactory f66440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EngineJobListener f66441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlideExecutor f66442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final GlideExecutor f66443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final GlideExecutor f66444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final GlideExecutor f66445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicInteger f66446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Key f66447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f66448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f66449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f66450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f66451q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Resource f66452r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    DataSource f66453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f66454t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    GlideException f66455u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f66456v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    EngineResource f66457w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private DecodeJob f66458x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile boolean f66459y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f66460z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CallLoadFailed implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResourceCallback f66461a;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.f66461a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f66461a.f()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.f66436a.b(this.f66461a)) {
                            EngineJob.this.f(this.f66461a);
                        }
                        EngineJob.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CallResourceReady implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResourceCallback f66463a;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.f66463a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f66463a.f()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.f66436a.b(this.f66463a)) {
                            EngineJob.this.f66457w.c();
                            EngineJob.this.g(this.f66463a);
                            EngineJob.this.r(this.f66463a);
                        }
                        EngineJob.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public EngineResource a(Resource resource, boolean z2, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource(resource, z2, true, key, resourceListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ResourceCallbackAndExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ResourceCallback f66465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f66466b;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f66465a = resourceCallback;
            this.f66466b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f66465a.equals(((ResourceCallbackAndExecutor) obj).f66465a);
            }
            return false;
        }

        public int hashCode() {
            return this.f66465a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f66467a;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        private static ResourceCallbackAndExecutor e(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.a());
        }

        void a(ResourceCallback resourceCallback, Executor executor) {
            this.f66467a.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        boolean b(ResourceCallback resourceCallback) {
            return this.f66467a.contains(e(resourceCallback));
        }

        void clear() {
            this.f66467a.clear();
        }

        ResourceCallbacksAndExecutors d() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.f66467a));
        }

        void f(ResourceCallback resourceCallback) {
            this.f66467a.remove(e(resourceCallback));
        }

        boolean isEmpty() {
            return this.f66467a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.f66467a.iterator();
        }

        int size() {
            return this.f66467a.size();
        }

        ResourceCallbacksAndExecutors(List list) {
            this.f66467a = list;
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, A);
    }

    private GlideExecutor j() {
        return this.f66449o ? this.f66444j : this.f66450p ? this.f66445k : this.f66443i;
    }

    private boolean m() {
        return this.f66456v || this.f66454t || this.f66459y;
    }

    private synchronized void q() {
        if (this.f66447m == null) {
            throw new IllegalArgumentException();
        }
        this.f66436a.clear();
        this.f66447m = null;
        this.f66457w = null;
        this.f66452r = null;
        this.f66456v = false;
        this.f66459y = false;
        this.f66454t = false;
        this.f66460z = false;
        this.f66458x.w(false);
        this.f66458x = null;
        this.f66455u = null;
        this.f66453s = null;
        this.f66439d.b(this);
    }

    synchronized void a(ResourceCallback resourceCallback, Executor executor) {
        try {
            this.f66437b.c();
            this.f66436a.a(resourceCallback, executor);
            if (this.f66454t) {
                k(1);
                executor.execute(new CallResourceReady(resourceCallback));
            } else if (this.f66456v) {
                k(1);
                executor.execute(new CallLoadFailed(resourceCallback));
            } else {
                Preconditions.b(!this.f66459y, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void b(Resource resource, DataSource dataSource, boolean z2) {
        synchronized (this) {
            this.f66452r = resource;
            this.f66453s = dataSource;
            this.f66460z = z2;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void c(GlideException glideException) {
        synchronized (this) {
            this.f66455u = glideException;
        }
        n();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier d() {
        return this.f66437b;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void e(DecodeJob decodeJob) {
        j().execute(decodeJob);
    }

    void f(ResourceCallback resourceCallback) {
        try {
            resourceCallback.c(this.f66455u);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void g(ResourceCallback resourceCallback) {
        try {
            resourceCallback.b(this.f66457w, this.f66453s, this.f66460z);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void h() {
        if (m()) {
            return;
        }
        this.f66459y = true;
        this.f66458x.b();
        this.f66441g.c(this, this.f66447m);
    }

    void i() {
        EngineResource engineResource;
        synchronized (this) {
            try {
                this.f66437b.c();
                Preconditions.b(m(), "Not yet complete!");
                int iDecrementAndGet = this.f66446l.decrementAndGet();
                Preconditions.b(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    engineResource = this.f66457w;
                    q();
                } else {
                    engineResource = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (engineResource != null) {
            engineResource.f();
        }
    }

    synchronized void k(int i3) {
        EngineResource engineResource;
        Preconditions.b(m(), "Not yet complete!");
        if (this.f66446l.getAndAdd(i3) == 0 && (engineResource = this.f66457w) != null) {
            engineResource.c();
        }
    }

    synchronized EngineJob l(Key key, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f66447m = key;
        this.f66448n = z2;
        this.f66449o = z3;
        this.f66450p = z4;
        this.f66451q = z5;
        return this;
    }

    void n() {
        synchronized (this) {
            try {
                this.f66437b.c();
                if (this.f66459y) {
                    q();
                    return;
                }
                if (this.f66436a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f66456v) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f66456v = true;
                Key key = this.f66447m;
                ResourceCallbacksAndExecutors resourceCallbacksAndExecutorsD = this.f66436a.d();
                k(resourceCallbacksAndExecutorsD.size() + 1);
                this.f66441g.b(this, key, null);
                for (ResourceCallbackAndExecutor resourceCallbackAndExecutor : resourceCallbacksAndExecutorsD) {
                    resourceCallbackAndExecutor.f66466b.execute(new CallLoadFailed(resourceCallbackAndExecutor.f66465a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void o() {
        synchronized (this) {
            try {
                this.f66437b.c();
                if (this.f66459y) {
                    this.f66452r.a();
                    q();
                    return;
                }
                if (this.f66436a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f66454t) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f66457w = this.f66440f.a(this.f66452r, this.f66448n, this.f66447m, this.f66438c);
                this.f66454t = true;
                ResourceCallbacksAndExecutors resourceCallbacksAndExecutorsD = this.f66436a.d();
                k(resourceCallbacksAndExecutorsD.size() + 1);
                this.f66441g.b(this, this.f66447m, this.f66457w);
                for (ResourceCallbackAndExecutor resourceCallbackAndExecutor : resourceCallbacksAndExecutorsD) {
                    resourceCallbackAndExecutor.f66466b.execute(new CallResourceReady(resourceCallbackAndExecutor.f66465a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean p() {
        return this.f66451q;
    }

    synchronized void r(ResourceCallback resourceCallback) {
        try {
            this.f66437b.c();
            this.f66436a.f(resourceCallback);
            if (this.f66436a.isEmpty()) {
                h();
                if (this.f66454t || this.f66456v) {
                    if (this.f66446l.get() == 0) {
                        q();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(DecodeJob decodeJob) {
        try {
            this.f66458x = decodeJob;
            (decodeJob.E() ? this.f66442h : j()).execute(decodeJob);
        } catch (Throwable th) {
            throw th;
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool pool, EngineResourceFactory engineResourceFactory) {
        this.f66436a = new ResourceCallbacksAndExecutors();
        this.f66437b = StateVerifier.a();
        this.f66446l = new AtomicInteger();
        this.f66442h = glideExecutor;
        this.f66443i = glideExecutor2;
        this.f66444j = glideExecutor3;
        this.f66445k = glideExecutor4;
        this.f66441g = engineJobListener;
        this.f66438c = resourceListener;
        this.f66439d = pool;
        this.f66440f = engineResourceFactory;
    }
}

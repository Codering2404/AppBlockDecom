package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f66410i = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Jobs f66411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EngineKeyFactory f66412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MemoryCache f66413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EngineJobFactory f66414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ResourceRecycler f66415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LazyDiskCacheProvider f66416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DecodeJobFactory f66417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ActiveResources f66418h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DecodeJobFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DecodeJob.DiskCacheProvider f66419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Pools.Pool f66420b = FactoryPools.d(150, new FactoryPools.Factory<DecodeJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DecodeJob create() {
                DecodeJobFactory decodeJobFactory = DecodeJobFactory.this;
                return new DecodeJob(decodeJobFactory.f66419a, decodeJobFactory.f66420b);
            }
        });

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f66421c;

        DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.f66419a = diskCacheProvider;
        }

        DecodeJob a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i3, int i4, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z2, boolean z3, boolean z4, Options options, DecodeJob.Callback callback) {
            DecodeJob decodeJob = (DecodeJob) Preconditions.e((DecodeJob) this.f66420b.a());
            int i5 = this.f66421c;
            this.f66421c = i5 + 1;
            return decodeJob.n(glideContext, obj, engineKey, key, i3, i4, cls, cls2, priority, diskCacheStrategy, map, z2, z3, z4, options, callback, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class EngineJobFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GlideExecutor f66423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final GlideExecutor f66424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final GlideExecutor f66425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final GlideExecutor f66426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final EngineJobListener f66427e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final EngineResource.ResourceListener f66428f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Pools.Pool f66429g = FactoryPools.d(150, new FactoryPools.Factory<EngineJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public EngineJob create() {
                EngineJobFactory engineJobFactory = EngineJobFactory.this;
                return new EngineJob(engineJobFactory.f66423a, engineJobFactory.f66424b, engineJobFactory.f66425c, engineJobFactory.f66426d, engineJobFactory.f66427e, engineJobFactory.f66428f, engineJobFactory.f66429g);
            }
        });

        EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            this.f66423a = glideExecutor;
            this.f66424b = glideExecutor2;
            this.f66425c = glideExecutor3;
            this.f66426d = glideExecutor4;
            this.f66427e = engineJobListener;
            this.f66428f = resourceListener;
        }

        EngineJob a(Key key, boolean z2, boolean z3, boolean z4, boolean z5) {
            return ((EngineJob) Preconditions.e((EngineJob) this.f66429g.a())).l(key, z2, z3, z4, z5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DiskCache.Factory f66431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile DiskCache f66432b;

        LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.f66431a = factory;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache a() {
            if (this.f66432b == null) {
                synchronized (this) {
                    try {
                        if (this.f66432b == null) {
                            this.f66432b = this.f66431a.build();
                        }
                        if (this.f66432b == null) {
                            this.f66432b = new DiskCacheAdapter();
                        }
                    } finally {
                    }
                }
            }
            return this.f66432b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class LoadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EngineJob f66433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ResourceCallback f66434b;

        LoadStatus(ResourceCallback resourceCallback, EngineJob engineJob) {
            this.f66434b = resourceCallback;
            this.f66433a = engineJob;
        }

        public void a() {
            synchronized (Engine.this) {
                this.f66433a.r(this.f66434b);
            }
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z2) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z2);
    }

    private EngineResource e(Key key) {
        Resource resourceF = this.f66413c.f(key);
        if (resourceF == null) {
            return null;
        }
        return resourceF instanceof EngineResource ? (EngineResource) resourceF : new EngineResource(resourceF, true, true, key, this);
    }

    private EngineResource g(Key key) {
        EngineResource engineResourceE = this.f66418h.e(key);
        if (engineResourceE != null) {
            engineResourceE.c();
        }
        return engineResourceE;
    }

    private EngineResource h(Key key) {
        EngineResource engineResourceE = e(key);
        if (engineResourceE != null) {
            engineResourceE.c();
            this.f66418h.a(key, engineResourceE);
        }
        return engineResourceE;
    }

    private EngineResource i(EngineKey engineKey, boolean z2, long j3) {
        if (!z2) {
            return null;
        }
        EngineResource engineResourceG = g(engineKey);
        if (engineResourceG != null) {
            if (f66410i) {
                j("Loaded resource from active resources", j3, engineKey);
            }
            return engineResourceG;
        }
        EngineResource engineResourceH = h(engineKey);
        if (engineResourceH == null) {
            return null;
        }
        if (f66410i) {
            j("Loaded resource from cache", j3, engineKey);
        }
        return engineResourceH;
    }

    private static void j(String str, long j3, Key key) {
        Log.v("Engine", str + " in " + LogTime.a(j3) + "ms, key: " + key);
    }

    private LoadStatus l(GlideContext glideContext, Object obj, Key key, int i3, int i4, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z2, boolean z3, Options options, boolean z4, boolean z5, boolean z6, boolean z7, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j3) {
        EngineJob engineJobA = this.f66411a.a(engineKey, z7);
        if (engineJobA != null) {
            engineJobA.a(resourceCallback, executor);
            if (f66410i) {
                j("Added to existing load", j3, engineKey);
            }
            return new LoadStatus(resourceCallback, engineJobA);
        }
        EngineJob engineJobA2 = this.f66414d.a(engineKey, z4, z5, z6, z7);
        DecodeJob decodeJobA = this.f66417g.a(glideContext, obj, engineKey, key, i3, i4, cls, cls2, priority, diskCacheStrategy, map, z2, z3, z7, options, engineJobA2);
        this.f66411a.c(engineKey, engineJobA2);
        engineJobA2.a(resourceCallback, executor);
        engineJobA2.s(decodeJobA);
        if (f66410i) {
            j("Started new load", j3, engineKey);
        }
        return new LoadStatus(resourceCallback, engineJobA2);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void a(Resource resource) {
        this.f66415e.a(resource, true);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void b(EngineJob engineJob, Key key, EngineResource engineResource) {
        if (engineResource != null) {
            try {
                if (engineResource.e()) {
                    this.f66418h.a(key, engineResource);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f66411a.d(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void c(EngineJob engineJob, Key key) {
        this.f66411a.d(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public void d(Key key, EngineResource engineResource) {
        this.f66418h.d(key);
        if (engineResource.e()) {
            this.f66413c.e(key, engineResource);
        } else {
            this.f66415e.a(engineResource, false);
        }
    }

    public LoadStatus f(GlideContext glideContext, Object obj, Key key, int i3, int i4, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z2, boolean z3, Options options, boolean z4, boolean z5, boolean z6, boolean z7, ResourceCallback resourceCallback, Executor executor) {
        long jB = f66410i ? LogTime.b() : 0L;
        EngineKey engineKeyA = this.f66412b.a(obj, key, i3, i4, map, cls, cls2, options);
        synchronized (this) {
            try {
                EngineResource engineResourceI = i(engineKeyA, z4, jB);
                if (engineResourceI == null) {
                    return l(glideContext, obj, key, i3, i4, cls, cls2, priority, diskCacheStrategy, map, z2, z3, options, z4, z5, z6, z7, resourceCallback, executor, engineKeyA, jB);
                }
                resourceCallback.b(engineResourceI, DataSource.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(Resource resource) {
        if (!(resource instanceof EngineResource)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((EngineResource) resource).f();
    }

    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z2) {
        this.f66413c = memoryCache;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(factory);
        this.f66416f = lazyDiskCacheProvider;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z2) : activeResources;
        this.f66418h = activeResources2;
        activeResources2.f(this);
        this.f66412b = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.f66411a = jobs == null ? new Jobs() : jobs;
        this.f66414d = engineJobFactory == null ? new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : engineJobFactory;
        this.f66417g = decodeJobFactory == null ? new DecodeJobFactory(lazyDiskCacheProvider) : decodeJobFactory;
        this.f66415e = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.g(this);
    }
}

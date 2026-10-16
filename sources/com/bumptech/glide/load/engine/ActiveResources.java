package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ActiveResources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f66308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f66309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map f66310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue f66311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private EngineResource.ResourceListener f66312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f66313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile DequeuedResourceCallback f66314g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface DequeuedResourceCallback {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Key f66318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f66319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Resource f66320c;

        ResourceWeakReference(Key key, EngineResource engineResource, ReferenceQueue referenceQueue, boolean z2) {
            super(engineResource, referenceQueue);
            this.f66318a = (Key) Preconditions.e(key);
            this.f66320c = (engineResource.e() && z2) ? (Resource) Preconditions.e(engineResource.d()) : null;
            this.f66319b = engineResource.e();
        }

        void a() {
            this.f66320c = null;
            clear();
        }
    }

    ActiveResources(boolean z2) {
        this(z2, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bumptech.glide.load.engine.ActiveResources.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    synchronized void a(Key key, EngineResource engineResource) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.f66310c.put(key, new ResourceWeakReference(key, engineResource, this.f66311d, this.f66308a));
        if (resourceWeakReference != null) {
            resourceWeakReference.a();
        }
    }

    void b() {
        while (!this.f66313f) {
            try {
                c((ResourceWeakReference) this.f66311d.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.f66314g;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(ResourceWeakReference resourceWeakReference) {
        Resource resource;
        synchronized (this) {
            this.f66310c.remove(resourceWeakReference.f66318a);
            if (resourceWeakReference.f66319b && (resource = resourceWeakReference.f66320c) != null) {
                this.f66312e.d(resourceWeakReference.f66318a, new EngineResource(resource, true, false, resourceWeakReference.f66318a, this.f66312e));
            }
        }
    }

    synchronized void d(Key key) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.f66310c.remove(key);
        if (resourceWeakReference != null) {
            resourceWeakReference.a();
        }
    }

    synchronized EngineResource e(Key key) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.f66310c.get(key);
        if (resourceWeakReference == null) {
            return null;
        }
        EngineResource<?> engineResource = resourceWeakReference.get();
        if (engineResource == null) {
            c(resourceWeakReference);
        }
        return engineResource;
    }

    void f(EngineResource.ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.f66312e = resourceListener;
            }
        }
    }

    ActiveResources(boolean z2, Executor executor) {
        this.f66310c = new HashMap();
        this.f66311d = new ReferenceQueue();
        this.f66308a = z2;
        this.f66309b = executor;
        executor.execute(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.2
            @Override // java.lang.Runnable
            public void run() {
                ActiveResources.this.b();
            }
        });
    }
}

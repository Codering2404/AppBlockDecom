package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pools.Pool f66499f = FactoryPools.d(20, new FactoryPools.Factory<LockedResource<?>>() { // from class: com.bumptech.glide.load.engine.LockedResource.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LockedResource create() {
            return new LockedResource();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StateVerifier f66500a = StateVerifier.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resource f66501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f66502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f66503d;

    LockedResource() {
    }

    private void c(Resource resource) {
        this.f66503d = false;
        this.f66502c = true;
        this.f66501b = resource;
    }

    static LockedResource e(Resource resource) {
        LockedResource lockedResource = (LockedResource) Preconditions.e((LockedResource) f66499f.a());
        lockedResource.c(resource);
        return lockedResource;
    }

    private void f() {
        this.f66501b = null;
        f66499f.b(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void a() {
        this.f66500a.c();
        this.f66503d = true;
        if (!this.f66502c) {
            this.f66501b.a();
            f();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return this.f66501b.b();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier d() {
        return this.f66500a;
    }

    synchronized void g() {
        this.f66500a.c();
        if (!this.f66502c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f66502c = false;
        if (this.f66503d) {
            a();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.f66501b.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f66501b.getSize();
    }
}

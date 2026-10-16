package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class EngineResource<Z> implements Resource<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f66477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f66478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resource f66479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResourceListener f66480d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Key f66481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f66482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f66483h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ResourceListener {
        void d(Key key, EngineResource engineResource);
    }

    EngineResource(Resource resource, boolean z2, boolean z3, Key key, ResourceListener resourceListener) {
        this.f66479c = (Resource) Preconditions.e(resource);
        this.f66477a = z2;
        this.f66478b = z3;
        this.f66481f = key;
        this.f66480d = (ResourceListener) Preconditions.e(resourceListener);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void a() {
        if (this.f66482g > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f66483h) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f66483h = true;
        if (this.f66478b) {
            this.f66479c.a();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return this.f66479c.b();
    }

    synchronized void c() {
        if (this.f66483h) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f66482g++;
    }

    Resource d() {
        return this.f66479c;
    }

    boolean e() {
        return this.f66477a;
    }

    void f() {
        boolean z2;
        synchronized (this) {
            int i3 = this.f66482g;
            if (i3 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z2 = true;
            int i4 = i3 - 1;
            this.f66482g = i4;
            if (i4 != 0) {
                z2 = false;
            }
        }
        if (z2) {
            this.f66480d.d(this.f66481f, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.f66479c.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f66479c.getSize();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f66477a + ", listener=" + this.f66480d + ", key=" + this.f66481f + ", acquired=" + this.f66482g + ", isRecycled=" + this.f66483h + ", resource=" + this.f66479c + '}';
    }
}

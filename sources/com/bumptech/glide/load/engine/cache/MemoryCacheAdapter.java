package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MemoryCacheAdapter implements MemoryCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f66607a;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long c() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long d() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource e(Key key, Resource resource) {
        if (resource == null) {
            return null;
        }
        this.f66607a.a(resource);
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource f(Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void g(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f66607a = resourceRemovedListener;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void a(int i3) {
    }
}

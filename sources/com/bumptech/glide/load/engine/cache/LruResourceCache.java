package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f66606e;

    public LruResourceCache(long j3) {
        super(j3);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void a(int i3) {
        if (i3 >= 40) {
            b();
        } else if (i3 >= 20 || i3 == 15) {
            n(c() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource e(Key key, Resource resource) {
        return (Resource) super.l(key, resource);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource f(Key key) {
        return (Resource) super.m(key);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void g(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f66606e = resourceRemovedListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public int j(Resource resource) {
        return resource == null ? super.j(null) : resource.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void k(Key key, Resource resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.f66606e;
        if (resourceRemovedListener == null || resource == null) {
            return;
        }
        resourceRemovedListener.a(resource);
    }
}

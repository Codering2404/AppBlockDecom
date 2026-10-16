package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MemoryCache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ResourceRemovedListener {
        void a(Resource resource);
    }

    void a(int i3);

    void b();

    long c();

    long d();

    Resource e(Key key, Resource resource);

    Resource f(Key key);

    void g(ResourceRemovedListener resourceRemovedListener);
}

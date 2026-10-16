package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DiskCacheAdapter implements DiskCache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DiskCache.Factory {
        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
        public DiskCache build() {
            return new DiskCacheAdapter();
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File b(Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void a(Key key, DiskCache.Writer writer) {
    }
}

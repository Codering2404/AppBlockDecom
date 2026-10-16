package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f66590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CacheDirectoryGetter f66591b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements CacheDirectoryGetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f66592a;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File a() {
            return new File(this.f66592a);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements CacheDirectoryGetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f66593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f66594b;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File a() {
            return new File(this.f66593a, this.f66594b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface CacheDirectoryGetter {
        File a();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j3) {
        this.f66590a = j3;
        this.f66591b = cacheDirectoryGetter;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File fileA = this.f66591b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return DiskLruCacheWrapper.c(fileA, this.f66590a);
        }
        return null;
    }
}

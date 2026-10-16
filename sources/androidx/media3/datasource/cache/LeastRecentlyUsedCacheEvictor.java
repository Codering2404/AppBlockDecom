package androidx.media3.datasource.cache;

import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f42100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TreeSet f42101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f42102c;

    private void f(Cache cache, long j3) {
        while (this.f42102c + j3 > this.f42100a && !this.f42101b.isEmpty()) {
            cache.d((CacheSpan) this.f42101b.first());
        }
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        d(cache, cacheSpan);
        b(cache, cacheSpan2);
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public void b(Cache cache, CacheSpan cacheSpan) {
        this.f42101b.add(cacheSpan);
        this.f42102c += cacheSpan.f42056c;
        f(cache, 0L);
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public void c(Cache cache, String str, long j3, long j4) {
        if (j4 != -1) {
            f(cache, j4);
        }
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public void d(Cache cache, CacheSpan cacheSpan) {
        this.f42101b.remove(cacheSpan);
        this.f42102c -= cacheSpan.f42056c;
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public void e() {
    }
}

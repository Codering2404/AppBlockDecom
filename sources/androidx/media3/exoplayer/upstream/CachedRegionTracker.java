package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheSpan;
import androidx.media3.extractor.ChunkIndex;
import java.util.Arrays;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CachedRegionTracker implements Cache.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ChunkIndex f45486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TreeSet f45487b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Region implements Comparable<Region> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f45488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f45489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f45490c;

        public Region(long j3, long j4) {
            this.f45488a = j3;
            this.f45489b = j4;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Region region) {
            return Util.p(this.f45488a, region.f45488a);
        }
    }

    private void f(CacheSpan cacheSpan) {
        long j3 = cacheSpan.f42055b;
        Region region = new Region(j3, cacheSpan.f42056c + j3);
        Region region2 = (Region) this.f45487b.floor(region);
        Region region3 = (Region) this.f45487b.ceiling(region);
        boolean zG = g(region2, region);
        if (g(region, region3)) {
            if (zG) {
                region2.f45489b = region3.f45489b;
                region2.f45490c = region3.f45490c;
            } else {
                region.f45489b = region3.f45489b;
                region.f45490c = region3.f45490c;
                this.f45487b.add(region);
            }
            this.f45487b.remove(region3);
            return;
        }
        if (!zG) {
            int iBinarySearch = Arrays.binarySearch(this.f45486a.f46089c, region.f45489b);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            region.f45490c = iBinarySearch;
            this.f45487b.add(region);
            return;
        }
        region2.f45489b = region.f45489b;
        int i3 = region2.f45490c;
        while (true) {
            ChunkIndex chunkIndex = this.f45486a;
            if (i3 >= chunkIndex.f46087a - 1) {
                break;
            }
            int i4 = i3 + 1;
            if (chunkIndex.f46089c[i4] > region2.f45489b) {
                break;
            } else {
                i3 = i4;
            }
        }
        region2.f45490c = i3;
    }

    private boolean g(Region region, Region region2) {
        return (region == null || region2 == null || region.f45489b != region2.f45488a) ? false : true;
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public synchronized void b(Cache cache, CacheSpan cacheSpan) {
        f(cacheSpan);
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public synchronized void d(Cache cache, CacheSpan cacheSpan) {
        long j3 = cacheSpan.f42055b;
        Region region = new Region(j3, cacheSpan.f42056c + j3);
        Region region2 = (Region) this.f45487b.floor(region);
        if (region2 == null) {
            Log.d("CachedRegionTracker", "Removed a span we were not aware of");
            return;
        }
        this.f45487b.remove(region2);
        long j4 = region2.f45488a;
        long j5 = region.f45488a;
        if (j4 < j5) {
            Region region3 = new Region(j4, j5);
            int iBinarySearch = Arrays.binarySearch(this.f45486a.f46089c, region3.f45489b);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            region3.f45490c = iBinarySearch;
            this.f45487b.add(region3);
        }
        long j6 = region2.f45489b;
        long j7 = region.f45489b;
        if (j6 > j7) {
            Region region4 = new Region(j7 + 1, j6);
            region4.f45490c = region2.f45490c;
            this.f45487b.add(region4);
        }
    }

    @Override // androidx.media3.datasource.cache.Cache.Listener
    public void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }
}

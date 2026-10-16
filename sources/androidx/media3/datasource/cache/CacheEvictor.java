package androidx.media3.datasource.cache;

import androidx.media3.datasource.cache.Cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface CacheEvictor extends Cache.Listener {
    void c(Cache cache, String str, long j3, long j4);

    void e();
}

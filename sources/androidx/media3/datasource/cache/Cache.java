package androidx.media3.datasource.cache;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Cache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);

        void b(Cache cache, CacheSpan cacheSpan);

        void d(Cache cache, CacheSpan cacheSpan);
    }

    File a(String str, long j3, long j4);

    ContentMetadata b(String str);

    long c(String str, long j3, long j4);

    void d(CacheSpan cacheSpan);

    CacheSpan e(String str, long j3, long j4);

    long f(String str, long j3, long j4);

    long g();

    void h(CacheSpan cacheSpan);

    CacheSpan i(String str, long j3, long j4);

    void j(File file, long j3);

    void k(String str);

    void l(String str, ContentMetadataMutations contentMetadataMutations);
}

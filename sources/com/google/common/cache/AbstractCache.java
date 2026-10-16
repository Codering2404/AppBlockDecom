package com.google.common.cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SimpleStatsCounter implements StatsCounter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LongAddable f83436a = LongAddables.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LongAddable f83437b = LongAddables.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LongAddable f83438c = LongAddables.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final LongAddable f83439d = LongAddables.a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final LongAddable f83440e = LongAddables.a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final LongAddable f83441f = LongAddables.a();

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void a(int i3) {
            this.f83436a.add(i3);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b(int i3) {
            this.f83437b.add(i3);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void c() {
            this.f83441f.a();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void d(long j3) {
            this.f83439d.a();
            this.f83440e.add(j3);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void e(long j3) {
            this.f83438c.a();
            this.f83440e.add(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface StatsCounter {
        void a(int i3);

        void b(int i3);

        void c();

        void d(long j3);

        void e(long j3);
    }
}

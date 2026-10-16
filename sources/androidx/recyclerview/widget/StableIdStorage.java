package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
interface StableIdStorage {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class IsolatedStableIdStorage implements StableIdStorage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f52010a = 0;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class WrapperStableIdLookup implements StableIdLookup {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final LongSparseArray f52011a = new LongSparseArray();

            WrapperStableIdLookup() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long a(long j3) {
                Long lValueOf = (Long) this.f52011a.g(j3);
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(IsolatedStableIdStorage.this.b());
                    this.f52011a.m(j3, lValueOf);
                }
                return lValueOf.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup a() {
            return new WrapperStableIdLookup();
        }

        long b() {
            long j3 = this.f52010a;
            this.f52010a = 1 + j3;
            return j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoStableIdStorage implements StableIdStorage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StableIdLookup f52013a = new StableIdLookup() { // from class: androidx.recyclerview.widget.StableIdStorage.NoStableIdStorage.1
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long a(long j3) {
                return -1L;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup a() {
            return this.f52013a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SharedPoolStableIdStorage implements StableIdStorage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StableIdLookup f52015a = new StableIdLookup() { // from class: androidx.recyclerview.widget.StableIdStorage.SharedPoolStableIdStorage.1
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long a(long j3) {
                return j3;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup a() {
            return this.f52015a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface StableIdLookup {
        long a(long j3);
    }

    StableIdLookup a();
}

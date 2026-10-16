package androidx.constraintlayout.core;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Pools {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Pool<T> {
        Object a();

        boolean b(Object obj);

        void c(Object[] objArr, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SimplePool<T> implements Pool<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f31219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f31220b;

        SimplePool(int i3) {
            if (i3 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f31219a = new Object[i3];
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public Object a() {
            int i3 = this.f31220b;
            if (i3 <= 0) {
                return null;
            }
            int i4 = i3 - 1;
            Object[] objArr = this.f31219a;
            Object obj = objArr[i4];
            objArr[i4] = null;
            this.f31220b = i3 - 1;
            return obj;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean b(Object obj) {
            int i3 = this.f31220b;
            Object[] objArr = this.f31219a;
            if (i3 >= objArr.length) {
                return false;
            }
            objArr[i3] = obj;
            this.f31220b = i3 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void c(Object[] objArr, int i3) {
            if (i3 > objArr.length) {
                i3 = objArr.length;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                Object obj = objArr[i4];
                int i5 = this.f31220b;
                Object[] objArr2 = this.f31219a;
                if (i5 < objArr2.length) {
                    objArr2[i5] = obj;
                    this.f31220b = i5 + 1;
                }
            }
        }
    }
}

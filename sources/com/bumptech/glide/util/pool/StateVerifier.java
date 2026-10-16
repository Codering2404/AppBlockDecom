package com.bumptech.glide.util.pool;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class StateVerifier {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DebugStateVerifier extends StateVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile RuntimeException f67305a;

        @Override // com.bumptech.glide.util.pool.StateVerifier
        void b(boolean z2) {
            if (z2) {
                this.f67305a = new RuntimeException("Released");
            } else {
                this.f67305a = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void c() {
            if (this.f67305a != null) {
                throw new IllegalStateException("Already released", this.f67305a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DefaultStateVerifier extends StateVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f67306a;

        DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void b(boolean z2) {
            this.f67306a = z2;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void c() {
            if (this.f67306a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static StateVerifier a() {
        return new DefaultStateVerifier();
    }

    abstract void b(boolean z2);

    public abstract void c();

    private StateVerifier() {
    }
}

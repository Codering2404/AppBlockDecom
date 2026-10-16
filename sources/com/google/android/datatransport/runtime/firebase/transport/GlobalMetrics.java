package com.google.android.datatransport.runtime.firebase.transport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalMetrics {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final GlobalMetrics f69414b = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StorageMetrics f69415a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private StorageMetrics f69416a = null;

        Builder() {
        }

        public GlobalMetrics a() {
            return new GlobalMetrics(this.f69416a);
        }

        public Builder b(StorageMetrics storageMetrics) {
            this.f69416a = storageMetrics;
            return this;
        }
    }

    GlobalMetrics(StorageMetrics storageMetrics) {
        this.f69415a = storageMetrics;
    }

    public static Builder b() {
        return new Builder();
    }

    public StorageMetrics a() {
        return this.f69415a;
    }
}

package com.google.android.datatransport.runtime.firebase.transport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class StorageMetrics {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final StorageMetrics f69436c = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f69438b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f69439a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f69440b = 0;

        Builder() {
        }

        public StorageMetrics a() {
            return new StorageMetrics(this.f69439a, this.f69440b);
        }

        public Builder b(long j3) {
            this.f69439a = j3;
            return this;
        }

        public Builder c(long j3) {
            this.f69440b = j3;
            return this;
        }
    }

    StorageMetrics(long j3, long j4) {
        this.f69437a = j3;
        this.f69438b = j4;
    }

    public static Builder c() {
        return new Builder();
    }

    public long a() {
        return this.f69437a;
    }

    public long b() {
        return this.f69438b;
    }
}

package com.google.android.datatransport.runtime.firebase.transport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class TimeWindow {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TimeWindow f69441c = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f69443b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f69444a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f69445b = 0;

        Builder() {
        }

        public TimeWindow a() {
            return new TimeWindow(this.f69444a, this.f69445b);
        }

        public Builder b(long j3) {
            this.f69445b = j3;
            return this;
        }

        public Builder c(long j3) {
            this.f69444a = j3;
            return this;
        }
    }

    TimeWindow(long j3, long j4) {
        this.f69442a = j3;
        this.f69443b = j4;
    }

    public static Builder c() {
        return new Builder();
    }

    public long a() {
        return this.f69443b;
    }

    public long b() {
        return this.f69442a;
    }
}

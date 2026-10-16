package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_EventStoreConfig extends EventStoreConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f69539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f69540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f69541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f69542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f69543f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends EventStoreConfig.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f69544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f69545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f69546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f69547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f69548e;

        Builder() {
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig a() {
            String str = "";
            if (this.f69544a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f69545b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f69546c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f69547d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f69548e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventStoreConfig(this.f69544a.longValue(), this.f69545b.intValue(), this.f69546c.intValue(), this.f69547d.longValue(), this.f69548e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder b(int i3) {
            this.f69546c = Integer.valueOf(i3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder c(long j3) {
            this.f69547d = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder d(int i3) {
            this.f69545b = Integer.valueOf(i3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder e(int i3) {
            this.f69548e = Integer.valueOf(i3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        EventStoreConfig.Builder f(long j3) {
            this.f69544a = Long.valueOf(j3);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int b() {
        return this.f69541d;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long c() {
        return this.f69542e;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int d() {
        return this.f69540c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    int e() {
        return this.f69543f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EventStoreConfig) {
            EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
            if (this.f69539b == eventStoreConfig.f() && this.f69540c == eventStoreConfig.d() && this.f69541d == eventStoreConfig.b() && this.f69542e == eventStoreConfig.c() && this.f69543f == eventStoreConfig.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    long f() {
        return this.f69539b;
    }

    public int hashCode() {
        long j3 = this.f69539b;
        int i3 = (((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.f69540c) * 1000003) ^ this.f69541d) * 1000003;
        long j4 = this.f69542e;
        return ((i3 ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ this.f69543f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f69539b + ", loadBatchSize=" + this.f69540c + ", criticalSectionEnterTimeoutMs=" + this.f69541d + ", eventCleanUpAge=" + this.f69542e + ", maxBlobByteSizePerRow=" + this.f69543f + "}";
    }

    private AutoValue_EventStoreConfig(long j3, int i3, int i4, long j4, int i5) {
        this.f69539b = j3;
        this.f69540c = i3;
        this.f69541d = i4;
        this.f69542e = j4;
        this.f69543f = i5;
    }
}

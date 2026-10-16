package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f69470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f69471c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends SchedulerConfig.ConfigValue.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f69472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f69473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set f69474c;

        Builder() {
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue a() {
            String str = "";
            if (this.f69472a == null) {
                str = " delta";
            }
            if (this.f69473b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f69474c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.f69472a.longValue(), this.f69473b.longValue(), this.f69474c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder b(long j3) {
            this.f69472a = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f69474c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder d(long j3) {
            this.f69473b = Long.valueOf(j3);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    long b() {
        return this.f69469a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    Set c() {
        return this.f69471c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    long d() {
        return this.f69470b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig.ConfigValue) {
            SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
            if (this.f69469a == configValue.b() && this.f69470b == configValue.d() && this.f69471c.equals(configValue.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j3 = this.f69469a;
        int i3 = (((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003;
        long j4 = this.f69470b;
        return ((i3 ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ this.f69471c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f69469a + ", maxAllowedDelay=" + this.f69470b + ", flags=" + this.f69471c + "}";
    }

    private AutoValue_SchedulerConfig_ConfigValue(long j3, long j4, Set set) {
        this.f69469a = j3;
        this.f69470b = j4;
        this.f69471c = set;
    }
}

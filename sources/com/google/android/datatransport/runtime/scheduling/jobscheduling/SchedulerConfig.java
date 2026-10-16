package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SchedulerConfig {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Clock f69478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f69479b = new HashMap();

        public Builder a(Priority priority, ConfigValue configValue) {
            this.f69479b.put(priority, configValue);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f69478a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f69479b.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f69479b;
            this.f69479b = new HashMap();
            return SchedulerConfig.d(this.f69478a, map);
        }

        public Builder c(Clock clock) {
            this.f69478a = clock;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ConfigValue {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class Builder {
            public abstract ConfigValue a();

            public abstract Builder b(long j3);

            public abstract Builder c(Set set);

            public abstract Builder d(long j3);
        }

        public static Builder a() {
            return new AutoValue_SchedulerConfig_ConfigValue.Builder().c(Collections.EMPTY_SET);
        }

        abstract long b();

        abstract Set c();

        abstract long d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i3, long j3) {
        return (long) (Math.pow(3.0d, i3 - 1) * j3 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j3 > 1 ? j3 : 2L) * ((long) r7))));
    }

    public static Builder b() {
        return new Builder();
    }

    static SchedulerConfig d(Clock clock, Map map) {
        return new AutoValue_SchedulerConfig(clock, map);
    }

    public static SchedulerConfig f(Clock clock) {
        return b().a(Priority.DEFAULT, ConfigValue.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, ConfigValue.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, ConfigValue.a().b(86400000L).d(86400000L).c(i(Flag.DEVICE_IDLE)).a()).c(clock).b();
    }

    private static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    private void j(JobInfo.Builder builder, Set set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j3, int i3) {
        builder.setMinimumLatency(g(priority, j3, i3));
        j(builder, ((ConfigValue) h().get(priority)).c());
        return builder;
    }

    abstract Clock e();

    public long g(Priority priority, long j3, int i3) {
        long jA = j3 - e().a();
        ConfigValue configValue = (ConfigValue) h().get(priority);
        return Math.min(Math.max(a(i3, configValue.b()), jA), configValue.d());
    }

    abstract Map h();
}

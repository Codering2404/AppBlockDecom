package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SchedulerConfig extends SchedulerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f69467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f69468b;

    AutoValue_SchedulerConfig(Clock clock, Map map) {
        if (clock == null) {
            throw new NullPointerException("Null clock");
        }
        this.f69467a = clock;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f69468b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Clock e() {
        return this.f69467a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig) {
            SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
            if (this.f69467a.equals(schedulerConfig.e()) && this.f69468b.equals(schedulerConfig.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Map h() {
        return this.f69468b;
    }

    public int hashCode() {
        return ((this.f69467a.hashCode() ^ 1000003) * 1000003) ^ this.f69468b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f69467a + ", values=" + this.f69468b + "}";
    }
}

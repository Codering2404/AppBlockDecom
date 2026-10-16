package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69457a;

    public SchedulingConfigModule_ConfigFactory(Provider provider) {
        this.f69457a = provider;
    }

    public static SchedulerConfig a(Clock clock) {
        return (SchedulerConfig) Preconditions.d(SchedulingConfigModule.a(clock));
    }

    public static SchedulingConfigModule_ConfigFactory b(Provider provider) {
        return new SchedulingConfigModule_ConfigFactory(provider);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a((Clock) this.f69457a.get());
    }
}

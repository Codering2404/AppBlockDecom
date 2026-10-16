package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f69461d;

    public SchedulingModule_WorkSchedulerFactory(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.f69458a = provider;
        this.f69459b = provider2;
        this.f69460c = provider3;
        this.f69461d = provider4;
    }

    public static SchedulingModule_WorkSchedulerFactory a(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        return new SchedulingModule_WorkSchedulerFactory(provider, provider2, provider3, provider4);
    }

    public static WorkScheduler c(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.d(SchedulingModule.a(context, eventStore, schedulerConfig, clock));
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public WorkScheduler get() {
        return c((Context) this.f69458a.get(), (EventStore) this.f69459b.get(), (SchedulerConfig) this.f69460c.get(), (Clock) this.f69461d.get());
    }
}

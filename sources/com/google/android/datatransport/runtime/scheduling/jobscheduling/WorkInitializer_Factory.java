package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f69509d;

    public WorkInitializer_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.f69506a = provider;
        this.f69507b = provider2;
        this.f69508c = provider3;
        this.f69509d = provider4;
    }

    public static WorkInitializer_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkInitializer c(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public WorkInitializer get() {
        return c((Executor) this.f69506a.get(), (EventStore) this.f69507b.get(), (WorkScheduler) this.f69508c.get(), (SynchronizationGuard) this.f69509d.get());
    }
}

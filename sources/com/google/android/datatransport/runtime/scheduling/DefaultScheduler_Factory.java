package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f69455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f69456e;

    public DefaultScheduler_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.f69452a = provider;
        this.f69453b = provider2;
        this.f69454c = provider3;
        this.f69455d = provider4;
        this.f69456e = provider5;
    }

    public static DefaultScheduler_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        return new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DefaultScheduler c(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DefaultScheduler get() {
        return c((Executor) this.f69452a.get(), (BackendRegistry) this.f69453b.get(), (WorkScheduler) this.f69454c.get(), (EventStore) this.f69455d.get(), (SynchronizationGuard) this.f69456e.get());
    }
}

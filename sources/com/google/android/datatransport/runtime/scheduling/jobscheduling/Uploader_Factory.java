package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Uploader_Factory implements Factory<Uploader> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f69496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f69497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Provider f69498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Provider f69499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Provider f69500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Provider f69501i;

    public Uploader_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7, Provider provider8, Provider provider9) {
        this.f69493a = provider;
        this.f69494b = provider2;
        this.f69495c = provider3;
        this.f69496d = provider4;
        this.f69497e = provider5;
        this.f69498f = provider6;
        this.f69499g = provider7;
        this.f69500h = provider8;
        this.f69501i = provider9;
    }

    public static Uploader_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7, Provider provider8, Provider provider9) {
        return new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Uploader c(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Uploader get() {
        return c((Context) this.f69493a.get(), (BackendRegistry) this.f69494b.get(), (EventStore) this.f69495c.get(), (WorkScheduler) this.f69496d.get(), (Executor) this.f69497e.get(), (SynchronizationGuard) this.f69498f.get(), (Clock) this.f69499g.get(), (Clock) this.f69500h.get(), (ClientHealthMetricsStore) this.f69501i.get());
    }
}

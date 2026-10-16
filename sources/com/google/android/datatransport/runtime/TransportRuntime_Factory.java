package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f69367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f69368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f69369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f69370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f69371e;

    public TransportRuntime_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.f69367a = provider;
        this.f69368b = provider2;
        this.f69369c = provider3;
        this.f69370d = provider4;
        this.f69371e = provider5;
    }

    public static TransportRuntime_Factory a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime c(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TransportRuntime get() {
        return c((Clock) this.f69367a.get(), (Clock) this.f69368b.get(), (Scheduler) this.f69369c.get(), (Uploader) this.f69370d.get(), (WorkInitializer) this.f69371e.get());
    }
}

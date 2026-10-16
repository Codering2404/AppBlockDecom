package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultScheduler implements Scheduler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f69446f = Logger.getLogger(TransportRuntime.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkScheduler f69447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f69448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BackendRegistry f69449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EventStore f69450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SynchronizationGuard f69451e;

    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f69448b = executor;
        this.f69449c = backendRegistry;
        this.f69447a = workScheduler;
        this.f69450d = eventStore;
        this.f69451e = synchronizationGuard;
    }

    public static /* synthetic */ Object b(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        defaultScheduler.f69450d.p2(transportContext, eventInternal);
        defaultScheduler.f69447a.a(transportContext, 1);
        return null;
    }

    public static /* synthetic */ void c(final DefaultScheduler defaultScheduler, final TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        defaultScheduler.getClass();
        try {
            TransportBackend transportBackendA = defaultScheduler.f69449c.a(transportContext.b());
            if (transportBackendA == null) {
                String str = String.format("Transport backend '%s' is not registered", transportContext.b());
                f69446f.warning(str);
                transportScheduleCallback.a(new IllegalArgumentException(str));
            } else {
                final EventInternal eventInternalA = transportBackendA.a(eventInternal);
                defaultScheduler.f69451e.b(new SynchronizationGuard.CriticalSection() { // from class: t.b
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object d() {
                        return DefaultScheduler.b(this.f147442a, transportContext, eventInternalA);
                    }
                });
                transportScheduleCallback.a(null);
            }
        } catch (Exception e3) {
            f69446f.warning("Error scheduling event " + e3.getMessage());
            transportScheduleCallback.a(e3);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public void a(final TransportContext transportContext, final EventInternal eventInternal, final TransportScheduleCallback transportScheduleCallback) {
        this.f69448b.execute(new Runnable() { // from class: t.a
            @Override // java.lang.Runnable
            public final void run() {
                DefaultScheduler.c(this.f147438a, transportContext, transportScheduleCallback, eventInternal);
            }
        });
    }
}

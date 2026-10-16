package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f69502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventStore f69503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WorkScheduler f69504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SynchronizationGuard f69505d;

    WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f69502a = executor;
        this.f69503b = eventStore;
        this.f69504c = workScheduler;
        this.f69505d = synchronizationGuard;
    }

    public static /* synthetic */ Object a(WorkInitializer workInitializer) {
        Iterator it = workInitializer.f69503b.i0().iterator();
        while (it.hasNext()) {
            workInitializer.f69504c.a((TransportContext) it.next(), 1);
        }
        return null;
    }

    public void c() {
        this.f69502a.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.n
            @Override // java.lang.Runnable
            public final void run() {
                WorkInitializer workInitializer = this.f69537a;
                workInitializer.f69505d.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.o
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object d() {
                        return WorkInitializer.a(workInitializer);
                    }
                });
            }
        });
    }
}

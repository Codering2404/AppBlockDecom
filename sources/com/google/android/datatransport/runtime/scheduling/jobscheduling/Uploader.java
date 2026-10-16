package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Uploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f69484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BackendRegistry f69485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EventStore f69486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WorkScheduler f69487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f69488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SynchronizationGuard f69489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Clock f69490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Clock f69491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ClientHealthMetricsStore f69492i;

    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f69484a = context;
        this.f69485b = backendRegistry;
        this.f69486c = eventStore;
        this.f69487d = workScheduler;
        this.f69488e = executor;
        this.f69489f = synchronizationGuard;
        this.f69490g = clock;
        this.f69491h = clock2;
        this.f69492i = clientHealthMetricsStore;
    }

    public static /* synthetic */ Object b(Uploader uploader, Iterable iterable, TransportContext transportContext, long j3) {
        uploader.f69486c.e1(iterable);
        uploader.f69486c.b0(transportContext, uploader.f69490g.a() + j3);
        return null;
    }

    public static /* synthetic */ Object c(Uploader uploader) {
        uploader.f69492i.a();
        return null;
    }

    public static /* synthetic */ Object e(Uploader uploader, Iterable iterable) {
        uploader.f69486c.P(iterable);
        return null;
    }

    public static /* synthetic */ Object f(Uploader uploader, TransportContext transportContext, int i3) {
        uploader.f69487d.a(transportContext, i3 + 1);
        return null;
    }

    public static /* synthetic */ Object g(Uploader uploader, TransportContext transportContext, long j3) {
        uploader.f69486c.b0(transportContext, uploader.f69490g.a() + j3);
        return null;
    }

    public static /* synthetic */ Object h(Uploader uploader, Map map) {
        uploader.getClass();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            uploader.f69492i.f(((Integer) r0.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    public static /* synthetic */ void i(final Uploader uploader, final TransportContext transportContext, final int i3, Runnable runnable) {
        uploader.getClass();
        try {
            try {
                SynchronizationGuard synchronizationGuard = uploader.f69489f;
                final EventStore eventStore = uploader.f69486c;
                Objects.requireNonNull(eventStore);
                synchronizationGuard.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.e
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object d() {
                        return Integer.valueOf(eventStore.I());
                    }
                });
                if (uploader.k()) {
                    uploader.l(transportContext, i3);
                } else {
                    uploader.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.f
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object d() {
                            return Uploader.f(this.f69518a, transportContext, i3);
                        }
                    });
                }
                runnable.run();
            } catch (SynchronizationException unused) {
                uploader.f69487d.a(transportContext, i3 + 1);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public EventInternal j(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.f69489f;
        final ClientHealthMetricsStore clientHealthMetricsStore = this.f69492i;
        Objects.requireNonNull(clientHealthMetricsStore);
        return transportBackend.a(EventInternal.a().i(this.f69490g.a()).o(this.f69491h.a()).n("GDT_CLIENT_METRICS").h(new EncodedPayload(Encoding.b("proto"), ((ClientMetrics) synchronizationGuard.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.d
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object d() {
                return clientHealthMetricsStore.c();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f69484a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public BackendResponse l(final TransportContext transportContext, int i3) {
        BackendResponse backendResponseB;
        TransportBackend transportBackendA = this.f69485b.a(transportContext.b());
        BackendResponse backendResponseE = BackendResponse.e(0L);
        final long j3 = 0;
        while (((Boolean) this.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.g
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object d() {
                return Boolean.valueOf(this.f69521a.f69486c.c1(transportContext));
            }
        })).booleanValue()) {
            final Iterable iterable = (Iterable) this.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.h
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object d() {
                    return this.f69523a.f69486c.y1(transportContext);
                }
            });
            if (!iterable.iterator().hasNext()) {
                return backendResponseE;
            }
            if (transportBackendA == null) {
                Logging.a("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponseB = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PersistedEvent) it.next()).b());
                }
                if (transportContext.e()) {
                    arrayList.add(j(transportBackendA));
                }
                backendResponseB = transportBackendA.b(BackendRequest.a().b(arrayList).c(transportContext.c()).a());
            }
            backendResponseE = backendResponseB;
            if (backendResponseE.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                final TransportContext transportContext2 = transportContext;
                this.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.i
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object d() {
                        return Uploader.b(this.f69525a, iterable, transportContext2, j3);
                    }
                });
                this.f69487d.b(transportContext2, i3 + 1, true);
                return backendResponseE;
            }
            TransportContext transportContext3 = transportContext;
            this.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.j
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object d() {
                    return Uploader.e(this.f69529a, iterable);
                }
            });
            if (backendResponseE.c() == BackendResponse.Status.OK) {
                long jMax = Math.max(j3, backendResponseE.b());
                if (transportContext3.e()) {
                    this.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.k
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object d() {
                            return Uploader.c(this.f69531a);
                        }
                    });
                }
                j3 = jMax;
            } else if (backendResponseE.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                final HashMap map = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String strN = ((PersistedEvent) it2.next()).b().n();
                    if (map.containsKey(strN)) {
                        map.put(strN, Integer.valueOf(((Integer) map.get(strN)).intValue() + 1));
                    } else {
                        map.put(strN, 1);
                    }
                }
                this.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.l
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object d() {
                        return Uploader.h(this.f69532a, map);
                    }
                });
            }
            transportContext = transportContext3;
        }
        final TransportContext transportContext4 = transportContext;
        this.f69489f.b(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.m
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object d() {
                return Uploader.g(this.f69534a, transportContext4, j3);
            }
        });
        return backendResponseE;
    }

    public void m(final TransportContext transportContext, final int i3, final Runnable runnable) {
        this.f69488e.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.c
            @Override // java.lang.Runnable
            public final void run() {
                Uploader.i(this.f69512a, transportContext, i3, runnable);
            }
        });
    }
}

package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import java.lang.ref.WeakReference;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ServiceManager implements ServiceManagerBridge {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LazyLogger f85930b = new LazyLogger(ServiceManager.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85931c = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.1
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Listener listener) {
            listener.b();
        }

        public String toString() {
            return "healthy()";
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85932d = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.2
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Listener listener) {
            listener.c();
        }

        public String toString() {
            return "stopped()";
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f85933a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EmptyServiceManagerWarning extends Throwable {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FailedService extends Throwable {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NoOpService extends AbstractService {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ServiceListener extends Service.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Service f85934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WeakReference f85935b;

        @Override // com.google.common.util.concurrent.Service.Listener
        public void a(Service.State state, Throwable th) throws Exception {
            ServiceManagerState serviceManagerState = (ServiceManagerState) this.f85935b.get();
            if (serviceManagerState != null) {
                if ((!(this.f85934a instanceof NoOpService)) & (state != Service.State.STARTING)) {
                    ServiceManager.f85930b.a().log(Level.SEVERE, "Service " + this.f85934a + " has failed in the " + state + " state.", th);
                }
                serviceManagerState.e(this.f85934a, state, Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void b() throws Exception {
            ServiceManagerState serviceManagerState = (ServiceManagerState) this.f85935b.get();
            if (serviceManagerState != null) {
                serviceManagerState.e(this.f85934a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void c() throws Exception {
            ServiceManagerState serviceManagerState = (ServiceManagerState) this.f85935b.get();
            if (serviceManagerState != null) {
                serviceManagerState.e(this.f85934a, Service.State.NEW, Service.State.STARTING);
                if (this.f85934a instanceof NoOpService) {
                    return;
                }
                ServiceManager.f85930b.a().log(Level.FINE, "Starting {0}.", this.f85934a);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void d(Service.State state) throws Exception {
            ServiceManagerState serviceManagerState = (ServiceManagerState) this.f85935b.get();
            if (serviceManagerState != null) {
                serviceManagerState.e(this.f85934a, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void e(Service.State state) throws Exception {
            ServiceManagerState serviceManagerState = (ServiceManagerState) this.f85935b.get();
            if (serviceManagerState != null) {
                if (!(this.f85934a instanceof NoOpService)) {
                    ServiceManager.f85930b.a().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f85934a, state});
                }
                serviceManagerState.e(this.f85934a, state, Service.State.TERMINATED);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ServiceManagerState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Monitor f85936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SetMultimap f85937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Multiset f85938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final IdentityHashMap f85939d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f85940e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f85941f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f85942g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ListenerCallQueue f85943h;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.ServiceManager$ServiceManagerState$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Function<Map.Entry<Service, Long>, Long> {
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long apply(Map.Entry entry) {
                return (Long) entry.getValue();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class AwaitHealthGuard extends Monitor.Guard {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ServiceManagerState f85946c;

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean a() {
                int iY1 = this.f85946c.f85938c.Y1(Service.State.RUNNING);
                ServiceManagerState serviceManagerState = this.f85946c;
                return iY1 == serviceManagerState.f85942g || serviceManagerState.f85938c.contains(Service.State.STOPPING) || this.f85946c.f85938c.contains(Service.State.TERMINATED) || this.f85946c.f85938c.contains(Service.State.FAILED);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class StoppedGuard extends Monitor.Guard {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ServiceManagerState f85947c;

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean a() {
                return this.f85947c.f85938c.Y1(Service.State.TERMINATED) + this.f85947c.f85938c.Y1(Service.State.FAILED) == this.f85947c.f85942g;
            }
        }

        void a() throws Exception {
            Preconditions.A(!this.f85936a.b(), "It is incorrect to execute listeners with the monitor held.");
            this.f85943h.b();
        }

        void b(final Service service) {
            this.f85943h.c(new ListenerCallQueue.Event<Listener>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.2

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ ServiceManagerState f85945b;

                {
                    this.f85945b = this;
                }

                @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(Listener listener) {
                    listener.a(service);
                }

                public String toString() {
                    return "failed({service=" + service + "})";
                }
            });
        }

        void c() {
            this.f85943h.c(ServiceManager.f85931c);
        }

        void d() {
            this.f85943h.c(ServiceManager.f85932d);
        }

        void e(Service service, Service.State state, Service.State state2) throws Exception {
            Preconditions.t(service);
            Preconditions.d(state != state2);
            this.f85936a.a();
            try {
                this.f85941f = true;
                if (this.f85940e) {
                    Preconditions.E(this.f85937b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    Preconditions.E(this.f85937b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    Stopwatch stopwatchC = (Stopwatch) this.f85939d.get(service);
                    if (stopwatchC == null) {
                        stopwatchC = Stopwatch.c();
                        this.f85939d.put(service, stopwatchC);
                    }
                    Service.State state3 = Service.State.RUNNING;
                    if (state2.compareTo(state3) >= 0 && stopwatchC.g()) {
                        stopwatchC.j();
                        if (!(service instanceof NoOpService)) {
                            ServiceManager.f85930b.a().log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatchC});
                        }
                    }
                    Service.State state4 = Service.State.FAILED;
                    if (state2 == state4) {
                        b(service);
                    }
                    if (this.f85938c.Y1(state3) == this.f85942g) {
                        c();
                    } else if (this.f85938c.Y1(Service.State.TERMINATED) + this.f85938c.Y1(state4) == this.f85942g) {
                        d();
                    }
                }
                this.f85936a.d();
                a();
            } catch (Throwable th) {
                this.f85936a.d();
                a();
                throw th;
            }
        }
    }

    public String toString() {
        return MoreObjects.b(ServiceManager.class).d("services", Collections2.d(this.f85933a, Predicates.j(Predicates.h(NoOpService.class)))).toString();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Listener {
        public void b() {
        }

        public void c() {
        }

        public void a(Service service) {
        }
    }
}

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractService implements Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85675d = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.1
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.Listener listener) {
            listener.c();
        }

        public String toString() {
            return "starting()";
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85676e = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.2
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.Listener listener) {
            listener.b();
        }

        public String toString() {
            return "running()";
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ListenerCallQueue.Event f85682k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Monitor f85683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListenerCallQueue f85684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile StateSnapshot f85685c;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractService$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f85691a;

        static {
            int[] iArr = new int[Service.State.values().length];
            f85691a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f85691a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f85691a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f85691a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f85691a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f85691a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class HasReachedRunningGuard extends Monitor.Guard {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractService f85692c;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return this.f85692c.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class IsStartableGuard extends Monitor.Guard {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractService f85693c;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return this.f85693c.state() == Service.State.NEW;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class IsStoppableGuard extends Monitor.Guard {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractService f85694c;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return this.f85694c.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class IsStoppedGuard extends Monitor.Guard {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractService f85695c;

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return this.f85695c.state().compareTo(Service.State.TERMINATED) >= 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StateSnapshot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Service.State f85696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f85697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Throwable f85698c;

        StateSnapshot(Service.State state, boolean z2, Throwable th) {
            Preconditions.m(!z2 || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.o((th != null) == (state == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.f85696a = state;
            this.f85697b = z2;
            this.f85698c = th;
        }

        Service.State a() {
            return (this.f85697b && this.f85696a == Service.State.STARTING) ? Service.State.STOPPING : this.f85696a;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        f85677f = d(state);
        Service.State state2 = Service.State.RUNNING;
        f85678g = d(state2);
        f85679h = e(Service.State.NEW);
        f85680i = e(state);
        f85681j = e(state2);
        f85682k = e(Service.State.STOPPING);
    }

    private void a() throws Exception {
        if (this.f85683a.b()) {
            return;
        }
        this.f85684b.b();
    }

    private void b(final Service.State state, final Throwable th) {
        this.f85684b.c(new ListenerCallQueue.Event<Service.Listener>(this) { // from class: com.google.common.util.concurrent.AbstractService.5

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AbstractService f85690c;

            {
                this.f85690c = this;
            }

            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Service.Listener listener) {
                listener.a(state, th);
            }

            public String toString() {
                return "failed({from = " + state + ", cause = " + th + "})";
            }
        });
    }

    private static ListenerCallQueue.Event d(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.4
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Service.Listener listener) {
                listener.d(state);
            }

            public String toString() {
                return "stopping({from = " + state + "})";
            }
        };
    }

    private static ListenerCallQueue.Event e(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.3
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Service.Listener listener) {
                listener.e(state);
            }

            public String toString() {
                return "terminated({from = " + state + "})";
            }
        };
    }

    protected final void c(Throwable th) throws Exception {
        Preconditions.t(th);
        this.f85683a.a();
        try {
            Service.State state = state();
            int i3 = AnonymousClass6.f85691a[state.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 || i3 == 3 || i3 == 4) {
                    this.f85685c = new StateSnapshot(Service.State.FAILED, false, th);
                    b(state, th);
                } else if (i3 != 5) {
                }
                return;
            }
            throw new IllegalStateException("Failed while in state:" + state, th);
        } finally {
            this.f85683a.d();
            a();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f85685c.a();
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }
}

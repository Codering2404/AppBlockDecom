package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractScheduledService implements Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LazyLogger f85656b = new LazyLogger(AbstractScheduledService.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractService f85657a;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends Service.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScheduledExecutorService f85658a;

        @Override // com.google.common.util.concurrent.Service.Listener
        public void a(Service.State state, Throwable th) {
            this.f85658a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void e(Service.State state) {
            this.f85658a.shutdown();
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$1ThreadFactoryImpl, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class C1ThreadFactoryImpl implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractScheduledService f85659a;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return MoreExecutors.f(this.f85659a.c(), runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Cancellable {
        void cancel(boolean z2);

        boolean isCancelled();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class CustomScheduler extends Scheduler {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private final class ReschedulableCallable implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Runnable f85660a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ScheduledExecutorService f85661b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final AbstractService f85662c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final ReentrantLock f85663d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private SupplantableFuture f85664f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ CustomScheduler f85665g;

            private Cancellable b(Schedule schedule) {
                SupplantableFuture supplantableFuture = this.f85664f;
                if (supplantableFuture == null) {
                    SupplantableFuture supplantableFuture2 = new SupplantableFuture(this.f85663d, d(schedule));
                    this.f85664f = supplantableFuture2;
                    return supplantableFuture2;
                }
                if (!supplantableFuture.f85669b.isCancelled()) {
                    this.f85664f.f85669b = d(schedule);
                }
                return this.f85664f;
            }

            private ScheduledFuture d(Schedule schedule) {
                return this.f85661b.schedule(this, schedule.f85666a, schedule.f85667b);
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                this.f85660a.run();
                c();
                return null;
            }

            public Cancellable c() throws Exception {
                Cancellable futureAsCancellable;
                try {
                    Schedule scheduleA = this.f85665g.a();
                    this.f85663d.lock();
                    try {
                        futureAsCancellable = b(scheduleA);
                        this.f85663d.unlock();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            futureAsCancellable = new FutureAsCancellable(Futures.d());
                        } finally {
                            this.f85663d.unlock();
                        }
                    }
                    if (th != null) {
                        this.f85662c.c(th);
                    }
                    return futureAsCancellable;
                } catch (Throwable th2) {
                    Platform.b(th2);
                    this.f85662c.c(th2);
                    return new FutureAsCancellable(Futures.d());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        protected static final class Schedule {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f85666a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final TimeUnit f85667b;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class SupplantableFuture implements Cancellable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ReentrantLock f85668a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Future f85669b;

            SupplantableFuture(ReentrantLock reentrantLock, Future future) {
                this.f85668a = reentrantLock;
                this.f85669b = future;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public void cancel(boolean z2) {
                this.f85668a.lock();
                try {
                    this.f85669b.cancel(z2);
                } finally {
                    this.f85668a.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public boolean isCancelled() {
                this.f85668a.lock();
                try {
                    return this.f85669b.isCancelled();
                } finally {
                    this.f85668a.unlock();
                }
            }
        }

        protected abstract Schedule a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FutureAsCancellable implements Cancellable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Future f85670a;

        FutureAsCancellable(Future future) {
            this.f85670a = future;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public void cancel(boolean z2) {
            this.f85670a.cancel(z2);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public boolean isCancelled() {
            return this.f85670a.isCancelled();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Scheduler {

        /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$Scheduler$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends Scheduler {
        }

        /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$Scheduler$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 extends Scheduler {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ServiceDelegate extends AbstractService {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private volatile Cancellable f85671l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final ReentrantLock f85672m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ AbstractScheduledService f85673n;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class Task implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ServiceDelegate f85674a;

            @Override // java.lang.Runnable
            public void run() {
                this.f85674a.f85672m.lock();
                try {
                    Cancellable cancellable = this.f85674a.f85671l;
                    Objects.requireNonNull(cancellable);
                    if (!cancellable.isCancelled()) {
                        this.f85674a.f85673n.b();
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.f85673n.toString();
        }
    }

    protected abstract void b();

    protected String c() {
        return getClass().getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f85657a.state();
    }

    public String toString() {
        return c() + " [" + state() + "]";
    }

    protected void d() {
    }
}

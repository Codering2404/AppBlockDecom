package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class MoreExecutors {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.MoreExecutors$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f85891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ListenableFuture f85892b;

        @Override // java.lang.Runnable
        public void run() {
            this.f85891a.add(this.f85892b);
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.MoreExecutors$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f85893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Supplier f85894b;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f85893a.execute(Callables.c(runnable, this.f85894b));
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.MoreExecutors$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends WrappingExecutorService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Supplier f85895b;

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        protected Runnable b(Runnable runnable) {
            return Callables.c(runnable, this.f85895b);
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        protected Callable c(Callable callable) {
            return Callables.d(callable, this.f85895b);
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.MoreExecutors$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends WrappingScheduledExecutorService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Supplier f85896c;

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        protected Runnable b(Runnable runnable) {
            return Callables.c(runnable, this.f85896c);
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        protected Callable c(Callable callable) {
            return Callables.d(callable, this.f85896c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Application {

        /* JADX INFO: renamed from: com.google.common.util.concurrent.MoreExecutors$Application$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ExecutorService f85899a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f85900b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ TimeUnit f85901c;

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f85899a.shutdown();
                    this.f85899a.awaitTermination(this.f85900b, this.f85901c);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ListeningDecorator extends AbstractListeningExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f85902a;

        ListeningDecorator(ExecutorService executorService) {
            this.f85902a = (ExecutorService) Preconditions.t(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j3, TimeUnit timeUnit) {
            return this.f85902a.awaitTermination(j3, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f85902a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f85902a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f85902a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f85902a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List shutdownNow() {
            return this.f85902a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f85902a + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ScheduledExecutorService f85903b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ScheduledFuture f85904b;

            public ListenableScheduledTask(ListenableFuture listenableFuture, ScheduledFuture scheduledFuture) {
                super(listenableFuture);
                this.f85904b = scheduledFuture;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.f85904b.compareTo(delayed);
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z2) {
                boolean zCancel = super.cancel(z2);
                if (zCancel) {
                    this.f85904b.cancel(z2);
                }
                return zCancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f85904b.getDelay(timeUnit);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final Runnable f85905i;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.f85905i = (Runnable) Preconditions.t(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f85905i.run();
                } catch (Throwable th) {
                    C(th);
                    throw th;
                }
            }

            @Override // com.google.common.util.concurrent.AbstractFuture
            protected String y() {
                return "task=[" + this.f85905i + "]";
            }
        }

        ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f85903b = (ScheduledExecutorService) Preconditions.t(scheduledExecutorService);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture scheduleAtFixedRate(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f85903b.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j3, j4, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f85903b.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j3, j4, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture schedule(Runnable runnable, long j3, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskI = TrustedListenableFutureTask.I(runnable, null);
            return new ListenableScheduledTask(trustedListenableFutureTaskI, this.f85903b.schedule(trustedListenableFutureTaskI, j3, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture schedule(Callable callable, long j3, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskJ = TrustedListenableFutureTask.J(callable);
            return new ListenableScheduledTask(trustedListenableFutureTaskJ, this.f85903b.schedule(trustedListenableFutureTaskJ, j3, timeUnit));
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    private static boolean b() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            Class.forName("com.google.appengine.api.utils.SystemProperty");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", null).invoke(null, null) != null;
    }

    public static ListeningExecutorService c(ExecutorService executorService) {
        return executorService instanceof ListeningExecutorService ? (ListeningExecutorService) executorService : executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
    }

    public static ListeningScheduledExecutorService d(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new ScheduledListeningDecorator(scheduledExecutorService);
    }

    public static Executor e(Executor executor) {
        return new SequentialExecutor(executor);
    }

    static Thread f(String str, Runnable runnable) {
        Preconditions.t(str);
        Preconditions.t(runnable);
        Thread threadNewThread = g().newThread(runnable);
        Objects.requireNonNull(threadNewThread);
        try {
            threadNewThread.setName(str);
        } catch (SecurityException unused) {
        }
        return threadNewThread;
    }

    public static ThreadFactory g() {
        if (!b()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", null).invoke(null, null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (InvocationTargetException e4) {
            throw Throwables.k(e4.getCause());
        }
    }

    static Executor h(final Executor executor, final AbstractFuture abstractFuture) {
        Preconditions.t(executor);
        Preconditions.t(abstractFuture);
        return executor == a() ? executor : new Executor() { // from class: com.google.common.util.concurrent.MoreExecutors.5
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RejectedExecutionException e3) {
                    abstractFuture.C(e3);
                }
            }
        };
    }
}

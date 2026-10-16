package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SchedulerWhen extends Scheduler implements Disposable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Disposable f139073f = new SubscribedDisposable();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Disposable f139074g = Disposables.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Scheduler f139075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FlowableProcessor f139076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Disposable f139077d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Scheduler.Worker f139078a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class WorkerCompletable extends Completable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ScheduledAction f139079a;

            WorkerCompletable(ScheduledAction scheduledAction) {
                this.f139079a = scheduledAction;
            }

            @Override // io.reactivex.Completable
            protected void c(CompletableObserver completableObserver) {
                completableObserver.a(this.f139079a);
                this.f139079a.a(CreateWorkerFunction.this.f139078a, completableObserver);
            }
        }

        CreateWorkerFunction(Scheduler.Worker worker) {
            this.f139078a = worker;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Completable apply(ScheduledAction scheduledAction) {
            return new WorkerCompletable(scheduledAction);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DelayedAction extends ScheduledAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f139081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f139082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f139083c;

        DelayedAction(Runnable runnable, long j3, TimeUnit timeUnit) {
            this.f139081a = runnable;
            this.f139082b = j3;
            this.f139083c = timeUnit;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.c(new OnCompletedAction(this.f139081a, completableObserver), this.f139082b, this.f139083c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ImmediateAction extends ScheduledAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f139084a;

        ImmediateAction(Runnable runnable) {
            this.f139084a = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.b(new OnCompletedAction(this.f139084a, completableObserver));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class OnCompletedAction implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f139085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f139086b;

        OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
            this.f139086b = runnable;
            this.f139085a = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f139086b.run();
            } finally {
                this.f139085a.onComplete();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class QueueWorker extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f139087a = new AtomicBoolean();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FlowableProcessor f139088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Scheduler.Worker f139089c;

        QueueWorker(FlowableProcessor flowableProcessor, Scheduler.Worker worker) {
            this.f139088b = flowableProcessor;
            this.f139089c = worker;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.f139088b.h(immediateAction);
            return immediateAction;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j3, timeUnit);
            this.f139088b.h(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f139087a.compareAndSet(false, true)) {
                this.f139088b.onComplete();
                this.f139089c.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139087a.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        ScheduledAction() {
            super(SchedulerWhen.f139073f);
        }

        void a(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable;
            Disposable disposable2 = get();
            if (disposable2 != SchedulerWhen.f139074g && disposable2 == (disposable = SchedulerWhen.f139073f)) {
                Disposable disposableB = b(worker, completableObserver);
                if (compareAndSet(disposable, disposableB)) {
                    return;
                }
                disposableB.dispose();
            }
        }

        protected abstract Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver);

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable;
            Disposable disposable2 = SchedulerWhen.f139074g;
            do {
                disposable = get();
                if (disposable == SchedulerWhen.f139074g) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != SchedulerWhen.f139073f) {
                disposable.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get().e();
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        Scheduler.Worker workerB = this.f139075b.b();
        FlowableProcessor flowableProcessorA = UnicastProcessor.C().A();
        Flowable flowableJ = flowableProcessorA.j(new CreateWorkerFunction(workerB));
        QueueWorker queueWorker = new QueueWorker(flowableProcessorA, workerB);
        this.f139076c.h(flowableJ);
        return queueWorker;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f139077d.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f139077d.e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscribedDisposable implements Disposable {
        SubscribedDisposable() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableIntervalRange extends Flowable<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f135884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f135886d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f135887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f135888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final TimeUnit f135889h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f135892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f135893d = new AtomicReference();

        IntervalRangeSubscriber(Subscriber subscriber, long j3, long j4) {
            this.f135890a = subscriber;
            this.f135892c = j3;
            this.f135891b = j4;
        }

        public void a(Disposable disposable) {
            DisposableHelper.g(this.f135893d, disposable);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.a(this.f135893d);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f135893d.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                long j3 = get();
                if (j3 == 0) {
                    this.f135890a.onError(new MissingBackpressureException("Can't deliver value " + this.f135892c + " due to lack of requests"));
                    DisposableHelper.a(this.f135893d);
                    return;
                }
                long j4 = this.f135892c;
                this.f135890a.h(Long.valueOf(j4));
                if (j4 == this.f135891b) {
                    if (this.f135893d.get() != disposableHelper) {
                        this.f135890a.onComplete();
                    }
                    DisposableHelper.a(this.f135893d);
                } else {
                    this.f135892c = j4 + 1;
                    if (j3 != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this, j3);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.f135885c, this.f135886d);
        subscriber.g(intervalRangeSubscriber);
        Scheduler scheduler = this.f135884b;
        if (!(scheduler instanceof TrampolineScheduler)) {
            intervalRangeSubscriber.a(scheduler.g(intervalRangeSubscriber, this.f135887f, this.f135888g, this.f135889h));
            return;
        }
        Scheduler.Worker workerB = scheduler.b();
        intervalRangeSubscriber.a(workerB);
        workerB.d(intervalRangeSubscriber, this.f135887f, this.f135888g, this.f135889h);
    }
}

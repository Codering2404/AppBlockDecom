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
public final class FlowableInterval extends Flowable<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f135877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f135879d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TimeUnit f135880f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f135882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f135883c = new AtomicReference();

        IntervalSubscriber(Subscriber subscriber) {
            this.f135881a = subscriber;
        }

        public void a(Disposable disposable) {
            DisposableHelper.g(this.f135883c, disposable);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.a(this.f135883c);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f135883c.get() != DisposableHelper.DISPOSED) {
                if (get() != 0) {
                    Subscriber subscriber = this.f135881a;
                    long j3 = this.f135882b;
                    this.f135882b = j3 + 1;
                    subscriber.h(Long.valueOf(j3));
                    BackpressureHelper.e(this, 1L);
                    return;
                }
                this.f135881a.onError(new MissingBackpressureException("Can't deliver value " + this.f135882b + " due to lack of requests"));
                DisposableHelper.a(this.f135883c);
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
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(subscriber);
        subscriber.g(intervalSubscriber);
        Scheduler scheduler = this.f135877b;
        if (!(scheduler instanceof TrampolineScheduler)) {
            intervalSubscriber.a(scheduler.g(intervalSubscriber, this.f135878c, this.f135879d, this.f135880f));
            return;
        }
        Scheduler.Worker workerB = scheduler.b();
        intervalSubscriber.a(workerB);
        workerB.d(intervalSubscriber, this.f135878c, this.f135879d, this.f135880f);
    }
}

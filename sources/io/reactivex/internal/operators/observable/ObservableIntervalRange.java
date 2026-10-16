package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableIntervalRange extends Observable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Scheduler f137852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f137854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f137855d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f137856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final TimeUnit f137857g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f137860c;

        IntervalRangeObserver(Observer observer, long j3, long j4) {
            this.f137858a = observer;
            this.f137860c = j3;
            this.f137859b = j4;
        }

        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e()) {
                return;
            }
            long j3 = this.f137860c;
            this.f137858a.h(Long.valueOf(j3));
            if (j3 != this.f137859b) {
                this.f137860c = j3 + 1;
            } else {
                DisposableHelper.a(this);
                this.f137858a.onComplete();
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
    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.f137853b, this.f137854c);
        observer.a(intervalRangeObserver);
        Scheduler scheduler = this.f137852a;
        if (!(scheduler instanceof TrampolineScheduler)) {
            intervalRangeObserver.a(scheduler.g(intervalRangeObserver, this.f137855d, this.f137856f, this.f137857g));
            return;
        }
        Scheduler.Worker workerB = scheduler.b();
        intervalRangeObserver.a(workerB);
        workerB.d(intervalRangeObserver, this.f137855d, this.f137856f, this.f137857g);
    }
}

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
public final class ObservableInterval extends Observable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Scheduler f137846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f137848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f137849d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f137851b;

        IntervalObserver(Observer observer) {
            this.f137850a = observer;
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
            if (get() != DisposableHelper.DISPOSED) {
                Observer observer = this.f137850a;
                long j3 = this.f137851b;
                this.f137851b = 1 + j3;
                observer.h(Long.valueOf(j3));
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
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.a(intervalObserver);
        Scheduler scheduler = this.f137846a;
        if (!(scheduler instanceof TrampolineScheduler)) {
            intervalObserver.a(scheduler.g(intervalObserver, this.f137847b, this.f137848c, this.f137849d));
            return;
        }
        Scheduler.Worker workerB = scheduler.b();
        intervalObserver.a(workerB);
        workerB.d(intervalObserver, this.f137847b, this.f137848c, this.f137849d);
    }
}

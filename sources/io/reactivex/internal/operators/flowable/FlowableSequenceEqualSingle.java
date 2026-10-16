package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f136291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f136292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiPredicate f136293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f136294d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiPredicate f136296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final FlowableSequenceEqual.EqualSubscriber f136297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final FlowableSequenceEqual.EqualSubscriber f136298d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f136299f = new AtomicThrowable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f136300g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f136301h;

        EqualCoordinator(SingleObserver singleObserver, int i3, BiPredicate biPredicate) {
            this.f136295a = singleObserver;
            this.f136296b = biPredicate;
            this.f136297c = new FlowableSequenceEqual.EqualSubscriber(this, i3);
            this.f136298d = new FlowableSequenceEqual.EqualSubscriber(this, i3);
        }

        void a() {
            this.f136297c.a();
            this.f136297c.b();
            this.f136298d.a();
            this.f136298d.b();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void b(Throwable th) {
            if (this.f136299f.a(th)) {
                c();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                SimpleQueue simpleQueue = this.f136297c.f136288f;
                SimpleQueue simpleQueue2 = this.f136298d.f136288f;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (!e()) {
                        if (this.f136299f.get() != null) {
                            a();
                            this.f136295a.onError(this.f136299f.b());
                            return;
                        }
                        boolean z2 = this.f136297c.f136289g;
                        Object objPoll = this.f136300g;
                        if (objPoll == null) {
                            try {
                                objPoll = simpleQueue.poll();
                                this.f136300g = objPoll;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                a();
                                this.f136299f.a(th);
                                this.f136295a.onError(this.f136299f.b());
                                return;
                            }
                        }
                        boolean z3 = objPoll == null;
                        boolean z4 = this.f136298d.f136289g;
                        Object objPoll2 = this.f136301h;
                        if (objPoll2 == null) {
                            try {
                                objPoll2 = simpleQueue2.poll();
                                this.f136301h = objPoll2;
                            } catch (Throwable th2) {
                                Exceptions.b(th2);
                                a();
                                this.f136299f.a(th2);
                                this.f136295a.onError(this.f136299f.b());
                                return;
                            }
                        }
                        boolean z5 = objPoll2 == null;
                        if (z2 && z4 && z3 && z5) {
                            this.f136295a.onSuccess(Boolean.TRUE);
                            return;
                        }
                        if (z2 && z4 && z3 != z5) {
                            a();
                            this.f136295a.onSuccess(Boolean.FALSE);
                            return;
                        }
                        if (!z3 && !z5) {
                            try {
                                if (!this.f136296b.test(objPoll, objPoll2)) {
                                    a();
                                    this.f136295a.onSuccess(Boolean.FALSE);
                                    return;
                                } else {
                                    this.f136300g = null;
                                    this.f136301h = null;
                                    this.f136297c.c();
                                    this.f136298d.c();
                                }
                            } catch (Throwable th3) {
                                Exceptions.b(th3);
                                a();
                                this.f136299f.a(th3);
                                this.f136295a.onError(this.f136299f.b());
                                return;
                            }
                        }
                    }
                    this.f136297c.b();
                    this.f136298d.b();
                    return;
                }
                if (e()) {
                    this.f136297c.b();
                    this.f136298d.b();
                    return;
                } else if (this.f136299f.get() != null) {
                    a();
                    this.f136295a.onError(this.f136299f.b());
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void d(Publisher publisher, Publisher publisher2) {
            publisher.i(this.f136297c);
            publisher2.i(this.f136298d);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136297c.a();
            this.f136298d.a();
            if (getAndIncrement() == 0) {
                this.f136297c.b();
                this.f136298d.b();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136297c.get() == SubscriptionHelper.CANCELLED;
        }
    }

    @Override // io.reactivex.Single
    public void c(SingleObserver singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f136294d, this.f136293c);
        singleObserver.a(equalCoordinator);
        equalCoordinator.d(this.f136291a, this.f136292b);
    }
}

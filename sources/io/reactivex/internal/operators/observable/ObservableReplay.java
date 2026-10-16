package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import com.google.android.gms.common.api.Api;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ResettableConnectable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final BufferSupplier f138043f = new UnBoundedFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f138044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f138045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BufferSupplier f138046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ObservableSource f138047d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface BufferSupplier<T> {
        ReplayBuffer call();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DisposeConsumer<R> implements Consumer<Disposable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObserverResourceWrapper f138050a;

        DisposeConsumer(ObserverResourceWrapper observerResourceWrapper) {
            this.f138050a = observerResourceWrapper;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Disposable disposable) {
            this.f138050a.b(disposable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReplayObserver f138051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Observer f138052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f138054d;

        InnerDisposable(ReplayObserver replayObserver, Observer observer) {
            this.f138051a = replayObserver;
            this.f138052b = observer;
        }

        Object a() {
            return this.f138053c;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138054d) {
                return;
            }
            this.f138054d = true;
            this.f138051a.c(this);
            this.f138053c = null;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138054d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MulticastReplay<R, U> extends Observable<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Callable f138055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f138056b;

        @Override // io.reactivex.Observable
        protected void u(Observer observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.d(this.f138055a.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138056b.apply(connectableObservable), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.b(observerResourceWrapper);
                connectableObservable.A(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.i(th, observer);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f138057a;

        Node(Object obj) {
            this.f138057a = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Replay<T> extends ConnectableObservable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConnectableObservable f138058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Observable f138059b;

        @Override // io.reactivex.observables.ConnectableObservable
        public void A(Consumer consumer) {
            this.f138058a.A(consumer);
        }

        @Override // io.reactivex.Observable
        protected void u(Observer observer) {
            this.f138059b.b(observer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ReplayBuffer<T> {
        void a(Throwable th);

        void b();

        void e(Object obj);

        void g(InnerDisposable innerDisposable);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f138060a;

        ReplayBufferSupplier(int i3) {
            this.f138060a = i3;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer call() {
            return new SizeBoundReplayBuffer(this.f138060a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final InnerDisposable[] f138061f = new InnerDisposable[0];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final InnerDisposable[] f138062g = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReplayBuffer f138063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f138064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f138065c = new AtomicReference(f138061f);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f138066d = new AtomicBoolean();

        ReplayObserver(ReplayBuffer replayBuffer) {
            this.f138063a = replayBuffer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                d();
            }
        }

        boolean b(InnerDisposable innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f138065c.get();
                if (innerDisposableArr == f138062g) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!h.a(this.f138065c, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        void c(InnerDisposable innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f138065c.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    } else if (innerDisposableArr[i3].equals(innerDisposable)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f138061f;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i3);
                    System.arraycopy(innerDisposableArr, i3 + 1, innerDisposableArr3, i3, (length - i3) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!h.a(this.f138065c, innerDisposableArr, innerDisposableArr2));
        }

        void d() {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f138065c.get()) {
                this.f138063a.g(innerDisposable);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138065c.set(f138062g);
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138065c.get() == f138062g;
        }

        void f() {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f138065c.getAndSet(f138062g)) {
                this.f138063a.g(innerDisposable);
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138064b) {
                return;
            }
            this.f138063a.e(obj);
            d();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138064b) {
                return;
            }
            this.f138064b = true;
            this.f138063a.b();
            f();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138064b) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138064b = true;
            this.f138063a.a(th);
            f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplaySource<T> implements ObservableSource<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicReference f138067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferSupplier f138068b;

        ReplaySource(AtomicReference atomicReference, BufferSupplier bufferSupplier) {
            this.f138067a = atomicReference;
            this.f138068b = bufferSupplier;
        }

        @Override // io.reactivex.ObservableSource
        public void b(Observer observer) {
            ReplayObserver replayObserver;
            while (true) {
                replayObserver = (ReplayObserver) this.f138067a.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver replayObserver2 = new ReplayObserver(this.f138068b.call());
                if (h.a(this.f138067a, null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable innerDisposable = new InnerDisposable(replayObserver, observer);
            observer.a(innerDisposable);
            replayObserver.b(innerDisposable);
            if (innerDisposable.e()) {
                replayObserver.c(innerDisposable);
            } else {
                replayObserver.f138063a.g(innerDisposable);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f138069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f138070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f138071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Scheduler f138072d;

        ScheduledReplaySupplier(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            this.f138069a = i3;
            this.f138070b = j3;
            this.f138071c = timeUnit;
            this.f138072d = scheduler;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer call() {
            return new SizeAndTimeBoundReplayBuffer(this.f138069a, this.f138070b, this.f138071c, this.f138072d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Scheduler f138073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f138074d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final TimeUnit f138075f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f138076g;

        SizeAndTimeBoundReplayBuffer(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            this.f138073c = scheduler;
            this.f138076g = i3;
            this.f138074d = j3;
            this.f138075f = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object d(Object obj) {
            return new Timed(obj, this.f138073c.c(this.f138075f), this.f138075f);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Node f() {
            Node node;
            long jC = this.f138073c.c(this.f138075f) - this.f138074d;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                Timed timed = (Timed) node2.f138057a;
                if (NotificationLite.j(timed.b()) || NotificationLite.k(timed.b()) || timed.a() > jC) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object h(Object obj) {
            return ((Timed) obj).b();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void l() {
            Node node;
            long jC = this.f138073c.c(this.f138075f) - this.f138074d;
            Node node2 = get();
            Node node3 = node2.get();
            int i3 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i4 = this.f138049b;
                    if (i4 <= this.f138076g) {
                        if (((Timed) node2.f138057a).a() > jC) {
                            break;
                        }
                        i3++;
                        this.f138049b--;
                        node3 = node2.get();
                    } else {
                        i3++;
                        this.f138049b = i4 - 1;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i3 != 0) {
                j(node);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void m() {
            Node node;
            long jC = this.f138073c.c(this.f138075f) - this.f138074d;
            Node node2 = get();
            Node node3 = node2.get();
            int i3 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.f138049b <= 1 || ((Timed) node2.f138057a).a() > jC) {
                    break;
                }
                i3++;
                this.f138049b--;
                node3 = node2.get();
            }
            if (i3 != 0) {
                j(node);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f138077c;

        SizeBoundReplayBuffer(int i3) {
            this.f138077c = i3;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void l() {
            if (this.f138049b > this.f138077c) {
                i();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile int f138078a;

        UnboundedReplayBuffer(int i3) {
            super(i3);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void a(Throwable th) {
            add(NotificationLite.g(th));
            this.f138078a++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void b() {
            add(NotificationLite.e());
            this.f138078a++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void e(Object obj) {
            add(NotificationLite.l(obj));
            this.f138078a++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void g(InnerDisposable innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer observer = innerDisposable.f138052b;
            int iAddAndGet = 1;
            while (!innerDisposable.e()) {
                int i3 = this.f138078a;
                Integer num = (Integer) innerDisposable.a();
                int iIntValue = num != null ? num.intValue() : 0;
                while (iIntValue < i3) {
                    if (NotificationLite.a(get(iIntValue), observer) || innerDisposable.e()) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
                innerDisposable.f138053c = Integer.valueOf(iIntValue);
                iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    private ObservableReplay(ObservableSource observableSource, ObservableSource observableSource2, AtomicReference atomicReference, BufferSupplier bufferSupplier) {
        this.f138047d = observableSource;
        this.f138044a = observableSource2;
        this.f138045b = atomicReference;
        this.f138046c = bufferSupplier;
    }

    public static ConnectableObservable B(ObservableSource observableSource, int i3) {
        return i3 == Integer.MAX_VALUE ? F(observableSource) : E(observableSource, new ReplayBufferSupplier(i3));
    }

    public static ConnectableObservable C(ObservableSource observableSource, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return D(observableSource, j3, timeUnit, scheduler, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static ConnectableObservable D(ObservableSource observableSource, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3) {
        return E(observableSource, new ScheduledReplaySupplier(i3, j3, timeUnit, scheduler));
    }

    static ConnectableObservable E(ObservableSource observableSource, BufferSupplier bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.q(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static ConnectableObservable F(ObservableSource observableSource) {
        return E(observableSource, f138043f);
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void A(Consumer consumer) {
        ReplayObserver replayObserver;
        while (true) {
            replayObserver = (ReplayObserver) this.f138045b.get();
            if (replayObserver != null && !replayObserver.e()) {
                break;
            }
            ReplayObserver replayObserver2 = new ReplayObserver(this.f138046c.call());
            if (h.a(this.f138045b, replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z2 = !replayObserver.f138066d.get() && replayObserver.f138066d.compareAndSet(false, true);
        try {
            consumer.accept(replayObserver);
            if (z2) {
                this.f138044a.b(replayObserver);
            }
        } catch (Throwable th) {
            if (z2) {
                replayObserver.f138066d.compareAndSet(true, false);
            }
            Exceptions.b(th);
            throw ExceptionHelper.e(th);
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void c(Disposable disposable) {
        h.a(this.f138045b, (ReplayObserver) disposable, null);
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f138047d.b(observer);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Node f138048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f138049b;

        BoundedReplayBuffer() {
            Node node = new Node(null);
            this.f138048a = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void a(Throwable th) {
            c(new Node(d(NotificationLite.g(th))));
            m();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void b() {
            c(new Node(d(NotificationLite.e())));
            m();
        }

        final void c(Node node) {
            this.f138048a.set(node);
            this.f138048a = node;
            this.f138049b++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void e(Object obj) {
            c(new Node(d(NotificationLite.l(obj))));
            l();
        }

        Node f() {
            return get();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void g(InnerDisposable innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                Node nodeF = (Node) innerDisposable.a();
                if (nodeF == null) {
                    nodeF = f();
                    innerDisposable.f138053c = nodeF;
                }
                while (!innerDisposable.e()) {
                    Node node = nodeF.get();
                    if (node == null) {
                        innerDisposable.f138053c = nodeF;
                        iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                    } else {
                        if (NotificationLite.a(h(node.f138057a), innerDisposable.f138052b)) {
                            innerDisposable.f138053c = null;
                            return;
                        }
                        nodeF = node;
                    }
                }
                innerDisposable.f138053c = null;
                return;
            } while (iAddAndGet != 0);
        }

        final void i() {
            this.f138049b--;
            j(get().get());
        }

        final void j(Node node) {
            set(node);
        }

        final void k() {
            Node node = get();
            if (node.f138057a != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        abstract void l();

        void m() {
            k();
        }

        Object d(Object obj) {
            return obj;
        }

        Object h(Object obj) {
            return obj;
        }
    }
}

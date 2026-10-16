package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ReplaySubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final ReplayDisposable[] f139456d = new ReplayDisposable[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ReplayDisposable[] f139457f = new ReplayDisposable[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object[] f139458g = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ReplayBuffer f139459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f139461c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f139462a;

        Node(Object obj) {
            this.f139462a = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ReplayBuffer<T> {
        void a(Object obj);

        void add(Object obj);

        void b(ReplayDisposable replayDisposable);

        boolean compareAndSet(Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f139463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ReplaySubject f139464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f139465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f139466d;

        ReplayDisposable(Observer observer, ReplaySubject replaySubject) {
            this.f139463a = observer;
            this.f139464b = replaySubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f139466d) {
                return;
            }
            this.f139466d = true;
            this.f139464b.C(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139466d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f139467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f139468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f139469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f139470d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f139471f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile TimedNode f139472g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        TimedNode f139473h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f139474i;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void a(Object obj) {
            TimedNode timedNode = new TimedNode(obj, Long.MAX_VALUE);
            TimedNode timedNode2 = this.f139473h;
            this.f139473h = timedNode;
            this.f139471f++;
            timedNode2.lazySet(timedNode);
            e();
            this.f139474i = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(Object obj) {
            TimedNode timedNode = new TimedNode(obj, this.f139470d.c(this.f139469c));
            TimedNode timedNode2 = this.f139473h;
            this.f139473h = timedNode;
            this.f139471f++;
            timedNode2.set(timedNode);
            d();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void b(ReplayDisposable replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer observer = replayDisposable.f139463a;
            TimedNode<T> timedNodeC = (TimedNode) replayDisposable.f139465c;
            if (timedNodeC == null) {
                timedNodeC = c();
            }
            int iAddAndGet = 1;
            while (!replayDisposable.f139466d) {
                while (!replayDisposable.f139466d) {
                    TimedNode<T> timedNode = timedNodeC.get();
                    if (timedNode != null) {
                        Object obj = timedNode.f139480a;
                        if (this.f139474i && timedNode.get() == null) {
                            if (NotificationLite.j(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.h(obj));
                            }
                            replayDisposable.f139465c = null;
                            replayDisposable.f139466d = true;
                            return;
                        }
                        observer.h(obj);
                        timedNodeC = timedNode;
                    } else if (timedNodeC.get() == null) {
                        replayDisposable.f139465c = timedNodeC;
                        iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.f139465c = null;
                return;
            }
            replayDisposable.f139465c = null;
        }

        TimedNode c() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.f139472g;
            long jC = this.f139470d.c(this.f139469c) - this.f139468b;
            TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.f139481b > jC) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        void d() {
            int i3 = this.f139471f;
            if (i3 > this.f139467a) {
                this.f139471f = i3 - 1;
                this.f139472g = this.f139472g.get();
            }
            long jC = this.f139470d.c(this.f139469c) - this.f139468b;
            TimedNode<T> timedNode = this.f139472g;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.f139472g = timedNode;
                    return;
                } else {
                    if (timedNode2.f139481b > jC) {
                        this.f139472g = timedNode;
                        return;
                    }
                    timedNode = timedNode2;
                }
            }
        }

        void e() {
            long jC = this.f139470d.c(this.f139469c) - this.f139468b;
            TimedNode<T> timedNode = this.f139472g;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.f139480a == null) {
                        this.f139472g = timedNode;
                        return;
                    }
                    TimedNode timedNode3 = new TimedNode(null, 0L);
                    timedNode3.lazySet(timedNode.get());
                    this.f139472g = timedNode3;
                    return;
                }
                if (timedNode2.f139481b > jC) {
                    if (timedNode.f139480a == null) {
                        this.f139472g = timedNode;
                        return;
                    }
                    TimedNode timedNode4 = new TimedNode(null, 0L);
                    timedNode4.lazySet(timedNode.get());
                    this.f139472g = timedNode4;
                    return;
                }
                timedNode = timedNode2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f139475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f139476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile Node f139477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f139478d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f139479f;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void a(Object obj) {
            Node node = new Node(obj);
            Node node2 = this.f139478d;
            this.f139478d = node;
            this.f139476b++;
            node2.lazySet(node);
            d();
            this.f139479f = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(Object obj) {
            Node node = new Node(obj);
            Node node2 = this.f139478d;
            this.f139478d = node;
            this.f139476b++;
            node2.set(node);
            c();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void b(ReplayDisposable replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer observer = replayDisposable.f139463a;
            Node<T> node = (Node) replayDisposable.f139465c;
            if (node == null) {
                node = this.f139477c;
            }
            int iAddAndGet = 1;
            while (!replayDisposable.f139466d) {
                Node<T> node2 = node.get();
                if (node2 != null) {
                    Object obj = node2.f139462a;
                    if (this.f139479f && node2.get() == null) {
                        if (NotificationLite.j(obj)) {
                            observer.onComplete();
                        } else {
                            observer.onError(NotificationLite.h(obj));
                        }
                        replayDisposable.f139465c = null;
                        replayDisposable.f139466d = true;
                        return;
                    }
                    observer.h(obj);
                    node = node2;
                } else if (node.get() != null) {
                    continue;
                } else {
                    replayDisposable.f139465c = node;
                    iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            replayDisposable.f139465c = null;
        }

        void c() {
            int i3 = this.f139476b;
            if (i3 > this.f139475a) {
                this.f139476b = i3 - 1;
                this.f139477c = this.f139477c.get();
            }
        }

        public void d() {
            Node node = this.f139477c;
            if (node.f139462a != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                this.f139477c = node2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f139480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f139481b;

        TimedNode(Object obj, long j3) {
            this.f139480a = obj;
            this.f139481b = j3;
        }
    }

    boolean B(ReplayDisposable replayDisposable) {
        ReplayDisposable[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.f139460b.get();
            if (replayDisposableArr == f139457f) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!h.a(this.f139460b, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    void C(ReplayDisposable replayDisposable) {
        ReplayDisposable[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.f139460b.get();
            if (replayDisposableArr == f139457f || replayDisposableArr == f139456d) {
                return;
            }
            int length = replayDisposableArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (replayDisposableArr[i3] == replayDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                replayDisposableArr2 = f139456d;
            } else {
                ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i3);
                System.arraycopy(replayDisposableArr, i3 + 1, replayDisposableArr3, i3, (length - i3) - 1);
                replayDisposableArr2 = replayDisposableArr3;
            }
        } while (!h.a(this.f139460b, replayDisposableArr, replayDisposableArr2));
    }

    ReplayDisposable[] D(Object obj) {
        return this.f139459a.compareAndSet(null, obj) ? (ReplayDisposable[]) this.f139460b.getAndSet(f139457f) : f139457f;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (this.f139461c) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139461c) {
            return;
        }
        ReplayBuffer replayBuffer = this.f139459a;
        replayBuffer.add(obj);
        for (ReplayDisposable replayDisposable : (ReplayDisposable[]) this.f139460b.get()) {
            replayBuffer.b(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f139461c) {
            return;
        }
        this.f139461c = true;
        Object objE = NotificationLite.e();
        ReplayBuffer replayBuffer = this.f139459a;
        replayBuffer.a(objE);
        for (ReplayDisposable replayDisposable : D(objE)) {
            replayBuffer.b(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139461c) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139461c = true;
        Object objG = NotificationLite.g(th);
        ReplayBuffer replayBuffer = this.f139459a;
        replayBuffer.a(objG);
        for (ReplayDisposable replayDisposable : D(objG)) {
            replayBuffer.b(replayDisposable);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        ReplayDisposable replayDisposable = new ReplayDisposable(observer, this);
        observer.a(replayDisposable);
        if (replayDisposable.f139466d) {
            return;
        }
        if (B(replayDisposable) && replayDisposable.f139466d) {
            C(replayDisposable);
        } else {
            this.f139459a.b(replayDisposable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f139482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile boolean f139483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile int f139484c;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void a(Object obj) {
            this.f139482a.add(obj);
            c();
            this.f139484c++;
            this.f139483b = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(Object obj) {
            this.f139482a.add(obj);
            this.f139484c++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void b(ReplayDisposable replayDisposable) {
            int iIntValue;
            int i3;
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            List list = this.f139482a;
            Observer observer = replayDisposable.f139463a;
            Integer num = (Integer) replayDisposable.f139465c;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = 0;
                replayDisposable.f139465c = 0;
            }
            int iAddAndGet = 1;
            while (!replayDisposable.f139466d) {
                int i4 = this.f139484c;
                while (i4 != iIntValue) {
                    if (replayDisposable.f139466d) {
                        replayDisposable.f139465c = null;
                        return;
                    }
                    Object obj = list.get(iIntValue);
                    if (this.f139483b && (i3 = iIntValue + 1) == i4 && i3 == (i4 = this.f139484c)) {
                        if (NotificationLite.j(obj)) {
                            observer.onComplete();
                        } else {
                            observer.onError(NotificationLite.h(obj));
                        }
                        replayDisposable.f139465c = null;
                        replayDisposable.f139466d = true;
                        return;
                    }
                    observer.h(obj);
                    iIntValue++;
                }
                if (iIntValue == this.f139484c) {
                    replayDisposable.f139465c = Integer.valueOf(iIntValue);
                    iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            replayDisposable.f139465c = null;
        }

        public void c() {
        }
    }
}

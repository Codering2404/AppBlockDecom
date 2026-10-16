package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BehaviorSubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object[] f139420h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final BehaviorDisposable[] f139421i = new BehaviorDisposable[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final BehaviorDisposable[] f139422j = new BehaviorDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Lock f139425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Lock f139426d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicReference f139427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f139428g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f139429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BehaviorSubject f139430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f139431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f139432d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        AppendOnlyLinkedArrayList f139433f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f139434g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f139435h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f139436i;

        BehaviorDisposable(Observer observer, BehaviorSubject behaviorSubject) {
            this.f139429a = observer;
            this.f139430b = behaviorSubject;
        }

        void a() {
            if (this.f139435h) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f139435h) {
                        return;
                    }
                    if (this.f139431c) {
                        return;
                    }
                    BehaviorSubject behaviorSubject = this.f139430b;
                    Lock lock = behaviorSubject.f139425c;
                    lock.lock();
                    this.f139436i = behaviorSubject.f139428g;
                    Object obj = behaviorSubject.f139423a.get();
                    lock.unlock();
                    this.f139432d = obj != null;
                    this.f139431c = true;
                    if (obj == null || test(obj)) {
                        return;
                    }
                    b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void b() {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
            while (!this.f139435h) {
                synchronized (this) {
                    try {
                        appendOnlyLinkedArrayList = this.f139433f;
                        if (appendOnlyLinkedArrayList == null) {
                            this.f139432d = false;
                            return;
                        }
                        this.f139433f = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                appendOnlyLinkedArrayList.d(this);
            }
        }

        void c(Object obj, long j3) {
            if (this.f139435h) {
                return;
            }
            if (!this.f139434g) {
                synchronized (this) {
                    try {
                        if (this.f139435h) {
                            return;
                        }
                        if (this.f139436i == j3) {
                            return;
                        }
                        if (this.f139432d) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139433f;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                                this.f139433f = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(obj);
                            return;
                        }
                        this.f139431c = true;
                        this.f139434g = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f139435h) {
                return;
            }
            this.f139435h = true;
            this.f139430b.C(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139435h;
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return this.f139435h || NotificationLite.a(obj, this.f139429a);
        }
    }

    boolean B(BehaviorDisposable behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f139424b.get();
            if (behaviorDisposableArr == f139422j) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!h.a(this.f139424b, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    void C(BehaviorDisposable behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f139424b.get();
            int length = behaviorDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (behaviorDisposableArr[i3] == behaviorDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                behaviorDisposableArr2 = f139421i;
            } else {
                BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i3);
                System.arraycopy(behaviorDisposableArr, i3 + 1, behaviorDisposableArr3, i3, (length - i3) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!h.a(this.f139424b, behaviorDisposableArr, behaviorDisposableArr2));
    }

    void D(Object obj) {
        this.f139426d.lock();
        this.f139428g++;
        this.f139423a.lazySet(obj);
        this.f139426d.unlock();
    }

    BehaviorDisposable[] E(Object obj) {
        AtomicReference atomicReference = this.f139424b;
        BehaviorDisposable[] behaviorDisposableArr = f139422j;
        BehaviorDisposable[] behaviorDisposableArr2 = (BehaviorDisposable[]) atomicReference.getAndSet(behaviorDisposableArr);
        if (behaviorDisposableArr2 != behaviorDisposableArr) {
            D(obj);
        }
        return behaviorDisposableArr2;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (this.f139427f.get() != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139427f.get() != null) {
            return;
        }
        Object objL = NotificationLite.l(obj);
        D(objL);
        for (BehaviorDisposable behaviorDisposable : (BehaviorDisposable[]) this.f139424b.get()) {
            behaviorDisposable.c(objL, this.f139428g);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (h.a(this.f139427f, null, ExceptionHelper.f139204a)) {
            Object objE = NotificationLite.e();
            for (BehaviorDisposable behaviorDisposable : E(objE)) {
                behaviorDisposable.c(objE, this.f139428g);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!h.a(this.f139427f, null, th)) {
            RxJavaPlugins.s(th);
            return;
        }
        Object objG = NotificationLite.g(th);
        for (BehaviorDisposable behaviorDisposable : E(objG)) {
            behaviorDisposable.c(objG, this.f139428g);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        BehaviorDisposable behaviorDisposable = new BehaviorDisposable(observer, this);
        observer.a(behaviorDisposable);
        if (B(behaviorDisposable)) {
            if (behaviorDisposable.f139435h) {
                C(behaviorDisposable);
                return;
            } else {
                behaviorDisposable.a();
                return;
            }
        }
        Throwable th = (Throwable) this.f139427f.get();
        if (th == ExceptionHelper.f139204a) {
            observer.onComplete();
        } else {
            observer.onError(th);
        }
    }
}

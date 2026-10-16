package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Subject f139485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f139486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    AppendOnlyLinkedArrayList f139487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f139488d;

    SerializedSubject(Subject subject) {
        this.f139485a = subject;
    }

    void B() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f139487c;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f139486b = false;
                        return;
                    }
                    this.f139487c = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            appendOnlyLinkedArrayList.d(this);
        }
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        boolean z2 = true;
        if (!this.f139488d) {
            synchronized (this) {
                try {
                    if (!this.f139488d) {
                        if (this.f139486b) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139487c;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                                this.f139487c = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.f(disposable));
                            return;
                        }
                        this.f139486b = true;
                        z2 = false;
                    }
                } finally {
                }
            }
        }
        if (z2) {
            disposable.dispose();
        } else {
            this.f139485a.a(disposable);
            B();
        }
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (this.f139488d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f139488d) {
                    return;
                }
                if (!this.f139486b) {
                    this.f139486b = true;
                    this.f139485a.h(obj);
                    B();
                } else {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139487c;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f139487c = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.c(NotificationLite.l(obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f139488d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f139488d) {
                    return;
                }
                this.f139488d = true;
                if (!this.f139486b) {
                    this.f139486b = true;
                    this.f139485a.onComplete();
                    return;
                }
                AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139487c;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                    this.f139487c = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.e());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f139488d) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z2 = true;
                if (!this.f139488d) {
                    this.f139488d = true;
                    if (this.f139486b) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139487c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f139487c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.e(NotificationLite.g(th));
                        return;
                    }
                    this.f139486b = true;
                    z2 = false;
                }
                if (z2) {
                    RxJavaPlugins.s(th);
                } else {
                    this.f139485a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        return NotificationLite.c(obj, this.f139485a);
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f139485a.b(observer);
    }
}

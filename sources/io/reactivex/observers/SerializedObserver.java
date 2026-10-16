package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observer f139257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f139258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Disposable f139259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f139260d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    AppendOnlyLinkedArrayList f139261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f139262g;

    public SerializedObserver(Observer observer) {
        this(observer, false);
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (DisposableHelper.i(this.f139259c, disposable)) {
            this.f139259c = disposable;
            this.f139257a.a(this);
        }
    }

    void b() {
        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.f139261f;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f139260d = false;
                        return;
                    }
                    this.f139261f = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!appendOnlyLinkedArrayList.a(this.f139257a));
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f139259c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f139259c.e();
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (this.f139262g) {
            return;
        }
        if (obj == null) {
            this.f139259c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f139262g) {
                    return;
                }
                if (!this.f139260d) {
                    this.f139260d = true;
                    this.f139257a.h(obj);
                    b();
                } else {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139261f;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f139261f = appendOnlyLinkedArrayList;
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
        if (this.f139262g) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f139262g) {
                    return;
                }
                if (!this.f139260d) {
                    this.f139262g = true;
                    this.f139260d = true;
                    this.f139257a.onComplete();
                } else {
                    AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139261f;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                        this.f139261f = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.c(NotificationLite.e());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f139262g) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z2 = true;
                if (!this.f139262g) {
                    if (this.f139260d) {
                        this.f139262g = true;
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139261f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                            this.f139261f = appendOnlyLinkedArrayList;
                        }
                        Object objG = NotificationLite.g(th);
                        if (this.f139258b) {
                            appendOnlyLinkedArrayList.c(objG);
                        } else {
                            appendOnlyLinkedArrayList.e(objG);
                        }
                        return;
                    }
                    this.f139262g = true;
                    this.f139260d = true;
                    z2 = false;
                }
                if (z2) {
                    RxJavaPlugins.s(th);
                } else {
                    this.f139257a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public SerializedObserver(Observer observer, boolean z2) {
        this.f139257a = observer;
        this.f139258b = z2;
    }
}

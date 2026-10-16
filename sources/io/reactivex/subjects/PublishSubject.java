package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class PublishSubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final PublishDisposable[] f139450c = new PublishDisposable[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final PublishDisposable[] f139451d = new PublishDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139452a = new AtomicReference(f139451d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f139453b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f139454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final PublishSubject f139455b;

        PublishDisposable(Observer observer, PublishSubject publishSubject) {
            this.f139454a = observer;
            this.f139455b = publishSubject;
        }

        public void a() {
            if (get()) {
                return;
            }
            this.f139454a.onComplete();
        }

        public void b(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f139454a.onError(th);
            }
        }

        public void c(Object obj) {
            if (get()) {
                return;
            }
            this.f139454a.h(obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f139455b.D(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get();
        }
    }

    PublishSubject() {
    }

    public static PublishSubject C() {
        return new PublishSubject();
    }

    boolean B(PublishDisposable publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f139452a.get();
            if (publishDisposableArr == f139450c) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!h.a(this.f139452a, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    void D(PublishDisposable publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f139452a.get();
            if (publishDisposableArr == f139450c || publishDisposableArr == f139451d) {
                return;
            }
            int length = publishDisposableArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (publishDisposableArr[i3] == publishDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = f139451d;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i3);
                System.arraycopy(publishDisposableArr, i3 + 1, publishDisposableArr3, i3, (length - i3) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!h.a(this.f139452a, publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (this.f139452a.get() == f139450c) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable publishDisposable : (PublishDisposable[]) this.f139452a.get()) {
            publishDisposable.c(obj);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Object obj = this.f139452a.get();
        Object obj2 = f139450c;
        if (obj == obj2) {
            return;
        }
        for (PublishDisposable publishDisposable : (PublishDisposable[]) this.f139452a.getAndSet(obj2)) {
            publishDisposable.a();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj = this.f139452a.get();
        Object obj2 = f139450c;
        if (obj == obj2) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139453b = th;
        for (PublishDisposable publishDisposable : (PublishDisposable[]) this.f139452a.getAndSet(obj2)) {
            publishDisposable.b(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.a(publishDisposable);
        if (B(publishDisposable)) {
            if (publishDisposable.e()) {
                D(publishDisposable);
            }
        } else {
            Throwable th = this.f139453b;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        }
    }
}

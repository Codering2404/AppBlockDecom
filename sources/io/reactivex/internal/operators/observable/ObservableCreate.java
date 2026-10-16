package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableCreate<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableOnSubscribe f137534a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137535a;

        CreateEmitter(Observer observer) {
            this.f137535a = observer;
        }

        public void a(Throwable th) {
            if (b(th)) {
                return;
            }
            RxJavaPlugins.s(th);
        }

        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (e()) {
                return false;
            }
            try {
                this.f137535a.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SerializedEmitter<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ObservableEmitter f137536a;

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.f137536a.toString();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.a(createEmitter);
        try {
            this.f137534a.a(createEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            createEmitter.a(th);
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137587b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f137590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f137591d;

        DematerializeObserver(Observer observer, Function function) {
            this.f137588a = observer;
            this.f137589b = function;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137591d, disposable)) {
                this.f137591d = disposable;
                this.f137588a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137591d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137591d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137590c) {
                if (obj instanceof Notification) {
                    Notification notification = (Notification) obj;
                    if (notification.g()) {
                        RxJavaPlugins.s(notification.d());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Notification notification2 = (Notification) ObjectHelper.d(this.f137589b.apply(obj), "The selector returned a null Notification");
                if (notification2.g()) {
                    this.f137591d.dispose();
                    onError(notification2.d());
                } else if (!notification2.f()) {
                    this.f137588a.h(notification2.e());
                } else {
                    this.f137591d.dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137591d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137590c) {
                return;
            }
            this.f137590c = true;
            this.f137588a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137590c) {
                RxJavaPlugins.s(th);
            } else {
                this.f137590c = true;
                this.f137588a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new DematerializeObserver(observer, this.f137587b));
    }
}

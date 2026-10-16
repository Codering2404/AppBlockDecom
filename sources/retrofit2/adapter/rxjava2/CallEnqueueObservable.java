package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class CallEnqueueObservable<T> extends Observable<Response<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Call f147027a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CallCallback<T> implements Disposable, Callback<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Call f147028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Observer f147029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f147030c = false;

        CallCallback(Call call, Observer observer) {
            this.f147028a = call;
            this.f147029b = observer;
        }

        @Override // retrofit2.Callback
        public void a(Call call, Throwable th) {
            if (call.C()) {
                return;
            }
            try {
                this.f147029b.onError(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
            }
        }

        @Override // retrofit2.Callback
        public void b(Call call, Response response) {
            if (call.C()) {
                return;
            }
            try {
                this.f147029b.h(response);
                if (call.C()) {
                    return;
                }
                this.f147030c = true;
                this.f147029b.onComplete();
            } catch (Throwable th) {
                if (this.f147030c) {
                    RxJavaPlugins.s(th);
                    return;
                }
                if (call.C()) {
                    return;
                }
                try {
                    this.f147029b.onError(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.s(new CompositeException(th, th2));
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f147028a.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f147028a.C();
        }
    }

    CallEnqueueObservable(Call call) {
        this.f147027a = call;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        Call callClone = this.f147027a.clone();
        CallCallback callCallback = new CallCallback(callClone, observer);
        observer.a(callCallback);
        callClone.A0(callCallback);
    }
}

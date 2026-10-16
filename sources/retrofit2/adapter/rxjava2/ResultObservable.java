package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class ResultObservable<T> extends Observable<Result<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Observable f147035a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResultObserver<R> implements Observer<Response<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Observer f147036a;

        ResultObserver(Observer observer) {
            this.f147036a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f147036a.a(disposable);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void h(Response response) {
            this.f147036a.h(Result.b(response));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f147036a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                this.f147036a.h(Result.a(th));
                this.f147036a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f147036a.onError(th2);
                } catch (Throwable th3) {
                    Exceptions.b(th3);
                    RxJavaPlugins.s(new CompositeException(th2, th3));
                }
            }
        }
    }

    ResultObservable(Observable observable) {
        this.f147035a = observable;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f147035a.b(new ResultObserver(observer));
    }
}

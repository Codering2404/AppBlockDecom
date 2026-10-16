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
final class BodyObservable<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Observable f147024a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BodyObserver<R> implements Observer<Response<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Observer f147025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f147026b;

        BodyObserver(Observer observer) {
            this.f147025a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f147025a.a(disposable);
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void h(Response response) {
            if (response.e()) {
                this.f147025a.h(response.a());
                return;
            }
            this.f147026b = true;
            HttpException httpException = new HttpException(response);
            try {
                this.f147025a.onError(httpException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(httpException, th));
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f147026b) {
                return;
            }
            this.f147025a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f147026b) {
                this.f147025a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.s(assertionError);
        }
    }

    BodyObservable(Observable observable) {
        this.f147024a = observable;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f147024a.b(new BodyObserver(observer));
    }
}

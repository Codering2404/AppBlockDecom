package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class CallExecuteObservable<T> extends Observable<Response<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Call f147031a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CallDisposable implements Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Call f147032a;

        CallDisposable(Call call) {
            this.f147032a = call;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f147032a.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f147032a.C();
        }
    }

    CallExecuteObservable(Call call) {
        this.f147031a = call;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        Call callClone = this.f147031a.clone();
        observer.a(new CallDisposable(callClone));
        boolean z2 = false;
        try {
            Response responseD = callClone.d();
            if (!callClone.C()) {
                observer.h(responseD);
            }
            if (callClone.C()) {
                return;
            }
            try {
                observer.onComplete();
            } catch (Throwable th) {
                th = th;
                z2 = true;
                Exceptions.b(th);
                if (z2) {
                    RxJavaPlugins.s(th);
                    return;
                }
                if (callClone.C()) {
                    return;
                }
                try {
                    observer.onError(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.s(new CompositeException(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}

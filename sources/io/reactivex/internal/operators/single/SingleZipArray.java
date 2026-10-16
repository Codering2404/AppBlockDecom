package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleZipArray<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource[] f138957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138958b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return ObjectHelper.d(SingleZipArray.this.f138958b.apply(new Object[]{obj}), "The zipper returned a null value");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ZipSingleObserver[] f138962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object[] f138963d;

        ZipCoordinator(SingleObserver singleObserver, int i3, Function function) {
            super(i3);
            this.f138960a = singleObserver;
            this.f138961b = function;
            ZipSingleObserver[] zipSingleObserverArr = new ZipSingleObserver[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                zipSingleObserverArr[i4] = new ZipSingleObserver(this, i4);
            }
            this.f138962c = zipSingleObserverArr;
            this.f138963d = new Object[i3];
        }

        void a(int i3) {
            ZipSingleObserver[] zipSingleObserverArr = this.f138962c;
            int length = zipSingleObserverArr.length;
            for (int i4 = 0; i4 < i3; i4++) {
                zipSingleObserverArr[i4].b();
            }
            while (true) {
                i3++;
                if (i3 >= length) {
                    return;
                } else {
                    zipSingleObserverArr[i3].b();
                }
            }
        }

        void b(Throwable th, int i3) {
            if (getAndSet(0) <= 0) {
                RxJavaPlugins.s(th);
            } else {
                a(i3);
                this.f138960a.onError(th);
            }
        }

        void c(Object obj, int i3) {
            this.f138963d[i3] = obj;
            if (decrementAndGet() == 0) {
                try {
                    this.f138960a.onSuccess(ObjectHelper.d(this.f138961b.apply(this.f138963d), "The zipper returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f138960a.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver zipSingleObserver : this.f138962c) {
                    zipSingleObserver.b();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() <= 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ZipCoordinator f138964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138965b;

        ZipSingleObserver(ZipCoordinator zipCoordinator, int i3) {
            this.f138964a = zipCoordinator;
            this.f138965b = i3;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void b() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138964a.b(th, this.f138965b);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138964a.c(obj, this.f138965b);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        SingleSource[] singleSourceArr = this.f138957a;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].b(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.f138958b);
        singleObserver.a(zipCoordinator);
        for (int i3 = 0; i3 < length && !zipCoordinator.e(); i3++) {
            SingleSource singleSource = singleSourceArr[i3];
            if (singleSource == null) {
                zipCoordinator.b(new NullPointerException("One of the sources is null"), i3);
                return;
            }
            singleSource.b(zipCoordinator.f138962c[i3]);
        }
    }
}

package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeZipArray<T, R> extends Maybe<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource[] f137040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137041b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return ObjectHelper.d(MaybeZipArray.this.f137041b.apply(new Object[]{obj}), "The zipper returned a null value");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ZipMaybeObserver[] f137045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object[] f137046d;

        ZipCoordinator(MaybeObserver maybeObserver, int i3, Function function) {
            super(i3);
            this.f137043a = maybeObserver;
            this.f137044b = function;
            ZipMaybeObserver[] zipMaybeObserverArr = new ZipMaybeObserver[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                zipMaybeObserverArr[i4] = new ZipMaybeObserver(this, i4);
            }
            this.f137045c = zipMaybeObserverArr;
            this.f137046d = new Object[i3];
        }

        void a(int i3) {
            ZipMaybeObserver[] zipMaybeObserverArr = this.f137045c;
            int length = zipMaybeObserverArr.length;
            for (int i4 = 0; i4 < i3; i4++) {
                zipMaybeObserverArr[i4].b();
            }
            while (true) {
                i3++;
                if (i3 >= length) {
                    return;
                } else {
                    zipMaybeObserverArr[i3].b();
                }
            }
        }

        void b(int i3) {
            if (getAndSet(0) > 0) {
                a(i3);
                this.f137043a.onComplete();
            }
        }

        void c(Throwable th, int i3) {
            if (getAndSet(0) <= 0) {
                RxJavaPlugins.s(th);
            } else {
                a(i3);
                this.f137043a.onError(th);
            }
        }

        void d(Object obj, int i3) {
            this.f137046d[i3] = obj;
            if (decrementAndGet() == 0) {
                try {
                    this.f137043a.onSuccess(ObjectHelper.d(this.f137044b.apply(this.f137046d), "The zipper returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f137043a.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipMaybeObserver zipMaybeObserver : this.f137045c) {
                    zipMaybeObserver.b();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() <= 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ZipCoordinator f137047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f137048b;

        ZipMaybeObserver(ZipCoordinator zipCoordinator, int i3) {
            this.f137047a = zipCoordinator;
            this.f137048b = i3;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void b() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f137047a.b(this.f137048b);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f137047a.c(th, this.f137048b);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f137047a.d(obj, this.f137048b);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        MaybeSource[] maybeSourceArr = this.f137040a;
        int length = maybeSourceArr.length;
        if (length == 1) {
            maybeSourceArr[0].b(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.f137041b);
        maybeObserver.a(zipCoordinator);
        for (int i3 = 0; i3 < length && !zipCoordinator.e(); i3++) {
            MaybeSource maybeSource = maybeSourceArr[i3];
            if (maybeSource == null) {
                zipCoordinator.c(new NullPointerException("One of the sources is null"), i3);
                return;
            }
            maybeSource.b(zipCoordinator.f137045c[i3]);
        }
    }
}

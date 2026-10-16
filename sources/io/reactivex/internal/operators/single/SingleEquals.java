package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleEquals<T> extends Single<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SingleSource f138825b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InnerObserver<T> implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f138826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompositeDisposable f138827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object[] f138828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SingleObserver f138829d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicInteger f138830f;

        InnerObserver(int i3, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver singleObserver, AtomicInteger atomicInteger) {
            this.f138826a = i3;
            this.f138827b = compositeDisposable;
            this.f138828c = objArr;
            this.f138829d = singleObserver;
            this.f138830f = atomicInteger;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138827b.b(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            int i3;
            do {
                i3 = this.f138830f.get();
                if (i3 >= 2) {
                    RxJavaPlugins.s(th);
                    return;
                }
            } while (!this.f138830f.compareAndSet(i3, 2));
            this.f138827b.dispose();
            this.f138829d.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138828c[this.f138826a] = obj;
            if (this.f138830f.incrementAndGet() == 2) {
                SingleObserver singleObserver = this.f138829d;
                Object[] objArr = this.f138828c;
                singleObserver.onSuccess(Boolean.valueOf(ObjectHelper.c(objArr[0], objArr[1])));
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.a(compositeDisposable);
        this.f138824a.b(new InnerObserver(0, compositeDisposable, objArr, singleObserver, atomicInteger));
        this.f138825b.b(new InnerObserver(1, compositeDisposable, objArr, singleObserver, atomicInteger));
    }
}

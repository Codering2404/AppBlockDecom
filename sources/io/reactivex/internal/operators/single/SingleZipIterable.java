package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleZipArray;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleZipIterable<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable f138966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138967b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return ObjectHelper.d(SingleZipIterable.this.f138967b.apply(new Object[]{obj}), "The zipper returned a null value");
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            int i3 = 0;
            for (SingleSource singleSource : this.f138966a) {
                if (singleSource == null) {
                    EmptyDisposable.j(new NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i3 == singleSourceArr.length) {
                    singleSourceArr = (SingleSource[]) Arrays.copyOf(singleSourceArr, (i3 >> 2) + i3);
                }
                int i4 = i3 + 1;
                singleSourceArr[i3] = singleSource;
                i3 = i4;
            }
            if (i3 == 0) {
                EmptyDisposable.j(new NoSuchElementException(), singleObserver);
                return;
            }
            if (i3 == 1) {
                singleSourceArr[0].b(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
                return;
            }
            SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(singleObserver, i3, this.f138967b);
            singleObserver.a(zipCoordinator);
            for (int i5 = 0; i5 < i3 && !zipCoordinator.e(); i5++) {
                singleSourceArr[i5].b(zipCoordinator.f138962c[i5]);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}

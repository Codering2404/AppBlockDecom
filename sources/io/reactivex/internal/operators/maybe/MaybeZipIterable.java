package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeZipIterable<T, R> extends Maybe<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable f137049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137050b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return ObjectHelper.d(MaybeZipIterable.this.f137050b.apply(new Object[]{obj}), "The zipper returned a null value");
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i3 = 0;
            for (MaybeSource maybeSource : this.f137049a) {
                if (maybeSource == null) {
                    EmptyDisposable.h(new NullPointerException("One of the sources is null"), maybeObserver);
                    return;
                }
                if (i3 == maybeSourceArr.length) {
                    maybeSourceArr = (MaybeSource[]) Arrays.copyOf(maybeSourceArr, (i3 >> 2) + i3);
                }
                int i4 = i3 + 1;
                maybeSourceArr[i3] = maybeSource;
                i3 = i4;
            }
            if (i3 == 0) {
                EmptyDisposable.b(maybeObserver);
                return;
            }
            if (i3 == 1) {
                maybeSourceArr[0].b(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
                return;
            }
            MaybeZipArray.ZipCoordinator zipCoordinator = new MaybeZipArray.ZipCoordinator(maybeObserver, i3, this.f137050b);
            maybeObserver.a(zipCoordinator);
            for (int i5 = 0; i5 < i3 && !zipCoordinator.e(); i5++) {
                maybeSourceArr[i5].b(zipCoordinator.f137045c[i5]);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, maybeObserver);
        }
    }
}

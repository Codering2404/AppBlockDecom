package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class ScalarXMapZHelper {
    static boolean a(Object obj, Function function, CompletableObserver completableObserver) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) obj).call();
            CompletableSource completableSource = objCall != null ? (CompletableSource) ObjectHelper.d(function.apply(objCall), "The mapper returned a null CompletableSource") : null;
            if (completableSource == null) {
                EmptyDisposable.a(completableObserver);
            } else {
                completableSource.b(completableObserver);
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.g(th, completableObserver);
            return true;
        }
    }

    static boolean b(Object obj, Function function, Observer observer) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) obj).call();
            MaybeSource maybeSource = objCall != null ? (MaybeSource) ObjectHelper.d(function.apply(objCall), "The mapper returned a null MaybeSource") : null;
            if (maybeSource == null) {
                EmptyDisposable.c(observer);
            } else {
                maybeSource.b(MaybeToObservable.A(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
            return true;
        }
    }

    static boolean c(Object obj, Function function, Observer observer) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) obj).call();
            SingleSource singleSource = objCall != null ? (SingleSource) ObjectHelper.d(function.apply(objCall), "The mapper returned a null SingleSource") : null;
            if (singleSource == null) {
                EmptyDisposable.c(observer);
            } else {
                singleSource.b(SingleToObservable.A(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
            return true;
        }
    }
}

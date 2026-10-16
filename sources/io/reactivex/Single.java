package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Single<T> implements SingleSource<T> {
    @Override // io.reactivex.SingleSource
    public final void b(SingleObserver singleObserver) {
        ObjectHelper.d(singleObserver, "subscriber is null");
        SingleObserver singleObserverZ = RxJavaPlugins.z(this, singleObserver);
        ObjectHelper.d(singleObserverZ, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            c(singleObserverZ);
        } catch (NullPointerException e3) {
            throw e3;
        } catch (Throwable th) {
            Exceptions.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void c(SingleObserver singleObserver);
}

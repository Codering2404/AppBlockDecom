package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Completable implements CompletableSource {
    private static NullPointerException d(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // io.reactivex.CompletableSource
    public final void b(CompletableObserver completableObserver) {
        ObjectHelper.d(completableObserver, "s is null");
        try {
            CompletableObserver completableObserverW = RxJavaPlugins.w(this, completableObserver);
            ObjectHelper.d(completableObserverW, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            c(completableObserverW);
        } catch (NullPointerException e3) {
            throw e3;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
            throw d(th);
        }
    }

    protected abstract void c(CompletableObserver completableObserver);
}

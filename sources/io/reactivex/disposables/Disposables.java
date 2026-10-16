package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Disposables {
    public static Disposable a() {
        return EmptyDisposable.INSTANCE;
    }

    public static Disposable b() {
        return c(Functions.f134906b);
    }

    public static Disposable c(Runnable runnable) {
        ObjectHelper.d(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}

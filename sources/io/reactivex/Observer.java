package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface Observer<T> {
    void a(Disposable disposable);

    void h(Object obj);

    void onComplete();

    void onError(Throwable th);
}

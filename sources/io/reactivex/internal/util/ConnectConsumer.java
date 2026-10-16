package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ConnectConsumer implements Consumer<Disposable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f139197a;

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Disposable disposable) {
        this.f139197a = disposable;
    }
}

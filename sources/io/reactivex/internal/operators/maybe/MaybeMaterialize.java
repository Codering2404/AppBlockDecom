package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeMaterialize<T> extends Single<Notification<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Maybe f136928a;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f136928a.b(new MaterializeSingleObserver(singleObserver));
    }
}

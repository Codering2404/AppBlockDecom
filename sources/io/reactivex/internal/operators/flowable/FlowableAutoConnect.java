package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableAutoConnect<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ConnectableFlowable f135256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f135257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f135258d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicInteger f135259f;

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        this.f135256b.i(subscriber);
        if (this.f135259f.incrementAndGet() == this.f135257c) {
            this.f135256b.A(this.f135258d);
        }
    }
}

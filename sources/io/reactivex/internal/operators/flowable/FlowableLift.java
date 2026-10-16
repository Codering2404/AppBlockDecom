package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final FlowableOperator f135927c;

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        try {
            Subscriber subscriberA = this.f135927c.a(subscriber);
            if (subscriberA != null) {
                this.f135196b.i(subscriberA);
                return;
            }
            throw new NullPointerException("Operator " + this.f135927c + " returned a null Subscriber");
        } catch (NullPointerException e3) {
            throw e3;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}

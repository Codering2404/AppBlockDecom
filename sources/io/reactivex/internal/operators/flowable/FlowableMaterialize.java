package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        MaterializeSubscriber(Subscriber subscriber) {
            super(subscriber);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Notification notification) {
            if (notification.g()) {
                RxJavaPlugins.s(notification.d());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f139163d++;
            this.f139160a.h(Notification.c(obj));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            b(Notification.a());
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            b(Notification.b(th));
        }
    }

    public FlowableMaterialize(Flowable flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new MaterializeSubscriber(subscriber));
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatArray<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher[] f135417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f135418c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Subscriber f135419j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Publisher[] f135420k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final boolean f135421l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final AtomicInteger f135422m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f135423n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        List f135424o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        long f135425p;

        ConcatArraySubscriber(Publisher[] publisherArr, boolean z2, Subscriber subscriber) {
            super(false);
            this.f135419j = subscriber;
            this.f135420k = publisherArr;
            this.f135421l = z2;
            this.f135422m = new AtomicInteger();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135425p++;
            this.f135419j.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135422m.getAndIncrement() == 0) {
                Publisher[] publisherArr = this.f135420k;
                int length = publisherArr.length;
                int i3 = this.f135423n;
                while (i3 != length) {
                    Publisher publisher = publisherArr[i3];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.f135421l) {
                            this.f135419j.onError(nullPointerException);
                            return;
                        }
                        List arrayList = this.f135424o;
                        if (arrayList == null) {
                            arrayList = new ArrayList((length - i3) + 1);
                            this.f135424o = arrayList;
                        }
                        arrayList.add(nullPointerException);
                        i3++;
                    } else {
                        long j3 = this.f135425p;
                        if (j3 != 0) {
                            this.f135425p = 0L;
                            i(j3);
                        }
                        publisher.i(this);
                        i3++;
                        this.f135423n = i3;
                        if (this.f135422m.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List list = this.f135424o;
                if (list == null) {
                    this.f135419j.onComplete();
                } else if (list.size() == 1) {
                    this.f135419j.onError((Throwable) list.get(0));
                } else {
                    this.f135419j.onError(new CompositeException(list));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135421l) {
                this.f135419j.onError(th);
                return;
            }
            List arrayList = this.f135424o;
            if (arrayList == null) {
                arrayList = new ArrayList((this.f135420k.length - this.f135423n) + 1);
                this.f135424o = arrayList;
            }
            arrayList.add(th);
            onComplete();
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.f135417b, this.f135418c, subscriber);
        subscriber.g(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}

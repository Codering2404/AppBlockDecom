package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f135212b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Object f135213b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class Iterator implements java.util.Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Object f135214a;

            Iterator() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f135214a = MostRecentSubscriber.this.f135213b;
                return !NotificationLite.j(r0);
            }

            @Override // java.util.Iterator
            public Object next() {
                try {
                    if (this.f135214a == null) {
                        this.f135214a = MostRecentSubscriber.this.f135213b;
                    }
                    if (NotificationLite.j(this.f135214a)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.k(this.f135214a)) {
                        throw ExceptionHelper.e(NotificationLite.h(this.f135214a));
                    }
                    Object objI = NotificationLite.i(this.f135214a);
                    this.f135214a = null;
                    return objI;
                } catch (Throwable th) {
                    this.f135214a = null;
                    throw th;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentSubscriber(Object obj) {
            this.f135213b = NotificationLite.l(obj);
        }

        public Iterator c() {
            return new Iterator();
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135213b = NotificationLite.l(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135213b = NotificationLite.e();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135213b = NotificationLite.g(th);
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.f135212b);
        this.f135211a.w(mostRecentSubscriber);
        return mostRecentSubscriber.c();
    }
}

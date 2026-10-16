package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f137280b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MostRecentObserver<T> extends DefaultObserver<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Object f137281b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class Iterator implements java.util.Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Object f137282a;

            Iterator() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f137282a = MostRecentObserver.this.f137281b;
                return !NotificationLite.j(r0);
            }

            @Override // java.util.Iterator
            public Object next() {
                try {
                    if (this.f137282a == null) {
                        this.f137282a = MostRecentObserver.this.f137281b;
                    }
                    if (NotificationLite.j(this.f137282a)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.k(this.f137282a)) {
                        throw ExceptionHelper.e(NotificationLite.h(this.f137282a));
                    }
                    Object objI = NotificationLite.i(this.f137282a);
                    this.f137282a = null;
                    return objI;
                } catch (Throwable th) {
                    this.f137282a = null;
                    throw th;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentObserver(Object obj) {
            this.f137281b = NotificationLite.l(obj);
        }

        public Iterator c() {
            return new Iterator();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137281b = NotificationLite.l(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137281b = NotificationLite.e();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137281b = NotificationLite.g(th);
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.f137280b);
        this.f137279a.b(mostRecentObserver);
        return mostRecentObserver.c();
    }
}

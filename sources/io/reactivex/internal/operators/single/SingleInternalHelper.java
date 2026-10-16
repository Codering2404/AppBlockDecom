package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleInternalHelper {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NoSuchElementException call() {
            return new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum ToFlowable implements Function<SingleSource, Publisher> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher apply(SingleSource singleSource) {
            return new SingleToFlowable(singleSource);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToFlowableIterable<T> implements Iterable<Flowable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterable f138886a;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new ToFlowableIterator(this.f138886a.iterator());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToFlowableIterator<T> implements Iterator<Flowable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f138887a;

        ToFlowableIterator(Iterator it) {
            this.f138887a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Flowable next() {
            return new SingleToFlowable((SingleSource) this.f138887a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f138887a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum ToObservable implements Function<SingleSource, Observable> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable apply(SingleSource singleSource) {
            return new SingleToObservable(singleSource);
        }
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableInternalHelper {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferedReplayCallable<T> implements Callable<ConnectableFlowable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Flowable f135849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f135850b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableFlowable call() {
            return this.f135849a.t(this.f135850b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferedTimedReplay<T> implements Callable<ConnectableFlowable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Flowable f135851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f135852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f135853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TimeUnit f135854d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Scheduler f135855f;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableFlowable call() {
            return this.f135851a.u(this.f135852b, this.f135853c, this.f135854d, this.f135855f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f135856a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher apply(Object obj) {
            return new FlowableFromIterable((Iterable) ObjectHelper.d(this.f135856a.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BiFunction f135857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f135858b;

        FlatMapWithCombinerInner(BiFunction biFunction, Object obj) {
            this.f135857a = biFunction;
            this.f135858b = obj;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return this.f135857a.apply(this.f135858b, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BiFunction f135859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f135860b;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher apply(Object obj) {
            return new FlowableMapPublisher((Publisher) ObjectHelper.d(this.f135860b.apply(obj), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.f135859a, obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function f135861a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher apply(Object obj) {
            return new FlowableTakePublisher((Publisher) ObjectHelper.d(this.f135861a.apply(obj), "The itemDelay returned a null Publisher"), 1L).j(Functions.b(obj)).b(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayCallable<T> implements Callable<ConnectableFlowable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Flowable f135862a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableFlowable call() {
            return this.f135862a.s();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayFunction<T, R> implements Function<Flowable<T>, Publisher<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f135863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Scheduler f135864b;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher apply(Flowable flowable) {
            return Flowable.d((Publisher) ObjectHelper.d(this.f135863a.apply(flowable), "The selector returned a null Publisher")).l(this.f135864b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) {
            subscription.y(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BiConsumer f135867a;

        @Override // io.reactivex.functions.BiFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, Emitter emitter) {
            this.f135867a.accept(obj, emitter);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Consumer f135868a;

        @Override // io.reactivex.functions.BiFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, Emitter emitter) {
            this.f135868a.accept(emitter);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscriberOnComplete<T> implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135869a;

        @Override // io.reactivex.functions.Action
        public void run() {
            this.f135869a.onComplete();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscriberOnError<T> implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135870a;

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            this.f135870a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscriberOnNext<T> implements Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135871a;

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            this.f135871a.h(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimedReplay<T> implements Callable<ConnectableFlowable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Flowable f135872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f135873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f135874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Scheduler f135875d;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableFlowable call() {
            return this.f135872a.v(this.f135873b, this.f135874c, this.f135875d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f135876a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Publisher apply(List list) {
            return Flowable.z(list, this.f135876a, false, Flowable.a());
        }
    }
}

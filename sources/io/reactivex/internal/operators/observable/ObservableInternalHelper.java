package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableInternalHelper {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Observable f137818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f137819b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableObservable call() {
            return this.f137818a.n(this.f137819b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Observable f137820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f137821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f137822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TimeUnit f137823d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Scheduler f137824f;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableObservable call() {
            return this.f137820a.o(this.f137821b, this.f137822c, this.f137823d, this.f137824f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f137825a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource apply(Object obj) {
            return new ObservableFromIterable((Iterable) ObjectHelper.d(this.f137825a.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BiFunction f137826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f137827b;

        FlatMapWithCombinerInner(BiFunction biFunction, Object obj) {
            this.f137826a = biFunction;
            this.f137827b = obj;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return this.f137826a.apply(this.f137827b, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BiFunction f137828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f137829b;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource apply(Object obj) {
            return new ObservableMap((ObservableSource) ObjectHelper.d(this.f137829b.apply(obj), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.f137828a, obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function f137830a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource apply(Object obj) {
            return new ObservableTake((ObservableSource) ObjectHelper.d(this.f137830a.apply(obj), "The itemDelay returned a null ObservableSource"), 1L).i(Functions.b(obj)).e(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserverOnComplete<T> implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137833a;

        @Override // io.reactivex.functions.Action
        public void run() {
            this.f137833a.onComplete();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserverOnError<T> implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137834a;

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            this.f137834a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserverOnNext<T> implements Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137835a;

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            this.f137835a.h(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Observable f137836a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableObservable call() {
            return this.f137836a.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f137837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Scheduler f137838b;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource apply(Observable observable) {
            return Observable.y((ObservableSource) ObjectHelper.d(this.f137837a.apply(observable), "The selector returned a null ObservableSource")).k(this.f137838b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BiConsumer f137839a;

        @Override // io.reactivex.functions.BiFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, Emitter emitter) {
            this.f137839a.accept(obj, emitter);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Consumer f137840a;

        @Override // io.reactivex.functions.BiFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, Emitter emitter) {
            this.f137840a.accept(emitter);
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Observable f137841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f137842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f137843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Scheduler f137844d;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectableObservable call() {
            return this.f137841a.p(this.f137842b, this.f137843c, this.f137844d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f137845a;

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource apply(List list) {
            return Observable.z(list, this.f137845a, false, Observable.d());
        }
    }
}

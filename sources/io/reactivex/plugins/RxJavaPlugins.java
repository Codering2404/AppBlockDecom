package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class RxJavaPlugins {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile Consumer f139273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile Function f139274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile Function f139275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile Function f139276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile Function f139277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile Function f139278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile Function f139279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static volatile Function f139280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static volatile Function f139281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static volatile Function f139282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static volatile Function f139283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static volatile Function f139284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static volatile Function f139285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static volatile Function f139286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static volatile Function f139287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static volatile BiFunction f139288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static volatile BiFunction f139289q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static volatile BiFunction f139290r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static volatile BiFunction f139291s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static volatile BiFunction f139292t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static volatile BooleanSupplier f139293u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static volatile boolean f139294v;

    public static Subscriber A(Flowable flowable, Subscriber subscriber) {
        BiFunction biFunction = f139288p;
        return biFunction != null ? (Subscriber) a(biFunction, flowable, subscriber) : subscriber;
    }

    static void B(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    static Object a(BiFunction biFunction, Object obj, Object obj2) {
        try {
            return biFunction.apply(obj, obj2);
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }

    static Object b(Function function, Object obj) {
        try {
            return function.apply(obj);
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }

    static Scheduler c(Function function, Callable callable) {
        return (Scheduler) ObjectHelper.d(b(function, callable), "Scheduler Callable result can't be null");
    }

    static Scheduler d(Callable callable) {
        try {
            return (Scheduler) ObjectHelper.d(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }

    public static Scheduler e(Callable callable) {
        ObjectHelper.d(callable, "Scheduler Callable can't be null");
        Function function = f139275c;
        return function == null ? d(callable) : c(function, callable);
    }

    public static Scheduler f(Callable callable) {
        ObjectHelper.d(callable, "Scheduler Callable can't be null");
        Function function = f139277e;
        return function == null ? d(callable) : c(function, callable);
    }

    public static Scheduler g(Callable callable) {
        ObjectHelper.d(callable, "Scheduler Callable can't be null");
        Function function = f139278f;
        return function == null ? d(callable) : c(function, callable);
    }

    public static Scheduler h(Callable callable) {
        ObjectHelper.d(callable, "Scheduler Callable can't be null");
        Function function = f139276d;
        return function == null ? d(callable) : c(function, callable);
    }

    static boolean i(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static boolean j() {
        return f139294v;
    }

    public static Completable k(Completable completable) {
        Function function = f139287o;
        return function != null ? (Completable) b(function, completable) : completable;
    }

    public static Flowable l(Flowable flowable) {
        Function function = f139281i;
        return function != null ? (Flowable) b(function, flowable) : flowable;
    }

    public static Maybe m(Maybe maybe) {
        Function function = f139285m;
        return function != null ? (Maybe) b(function, maybe) : maybe;
    }

    public static Observable n(Observable observable) {
        Function function = f139283k;
        return function != null ? (Observable) b(function, observable) : observable;
    }

    public static Single o(Single single) {
        Function function = f139286n;
        return function != null ? (Single) b(function, single) : single;
    }

    public static ConnectableFlowable p(ConnectableFlowable connectableFlowable) {
        Function function = f139282j;
        return function != null ? (ConnectableFlowable) b(function, connectableFlowable) : connectableFlowable;
    }

    public static ConnectableObservable q(ConnectableObservable connectableObservable) {
        Function function = f139284l;
        return function != null ? (ConnectableObservable) b(function, connectableObservable) : connectableObservable;
    }

    public static boolean r() {
        BooleanSupplier booleanSupplier = f139293u;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.a();
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }

    public static void s(Throwable th) {
        Consumer consumer = f139273a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                B(th2);
            }
        }
        th.printStackTrace();
        B(th);
    }

    public static Scheduler t(Scheduler scheduler) {
        Function function = f139280h;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    public static Runnable u(Runnable runnable) {
        ObjectHelper.d(runnable, "run is null");
        Function function = f139274b;
        return function == null ? runnable : (Runnable) b(function, runnable);
    }

    public static Scheduler v(Scheduler scheduler) {
        Function function = f139279g;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    public static CompletableObserver w(Completable completable, CompletableObserver completableObserver) {
        BiFunction biFunction = f139292t;
        return biFunction != null ? (CompletableObserver) a(biFunction, completable, completableObserver) : completableObserver;
    }

    public static MaybeObserver x(Maybe maybe, MaybeObserver maybeObserver) {
        BiFunction biFunction = f139289q;
        return biFunction != null ? (MaybeObserver) a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    public static Observer y(Observable observable, Observer observer) {
        BiFunction biFunction = f139290r;
        return biFunction != null ? (Observer) a(biFunction, observable, observer) : observer;
    }

    public static SingleObserver z(Single single, SingleObserver singleObserver) {
        BiFunction biFunction = f139291s;
        return biFunction != null ? (SingleObserver) a(biFunction, single, singleObserver) : singleObserver;
    }
}

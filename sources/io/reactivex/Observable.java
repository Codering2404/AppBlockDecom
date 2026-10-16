package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Observable<T> implements ObservableSource<T> {

    /* JADX INFO: renamed from: io.reactivex.Observable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f134852a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f134852a = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f134852a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f134852a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f134852a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int d() {
        return Flowable.a();
    }

    public static Observable y(ObservableSource observableSource) {
        ObjectHelper.d(observableSource, "source is null");
        return observableSource instanceof Observable ? RxJavaPlugins.n((Observable) observableSource) : RxJavaPlugins.n(new ObservableFromUnsafeSource(observableSource));
    }

    public static Observable z(Iterable iterable, Function function, boolean z2, int i3) {
        ObjectHelper.d(function, "zipper is null");
        ObjectHelper.d(iterable, "sources is null");
        ObjectHelper.e(i3, "bufferSize");
        return RxJavaPlugins.n(new ObservableZip(null, iterable, function, i3, z2));
    }

    @Override // io.reactivex.ObservableSource
    public final void b(Observer observer) {
        ObjectHelper.d(observer, "observer is null");
        try {
            Observer observerY = RxJavaPlugins.y(this, observer);
            ObjectHelper.d(observerY, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            u(observerY);
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

    public final Observable e(Object obj) {
        ObjectHelper.d(obj, "defaultItem is null");
        return w(g(obj));
    }

    public final Completable f() {
        return RxJavaPlugins.k(new ObservableIgnoreElementsCompletable(this));
    }

    public final Observable i(Function function) {
        ObjectHelper.d(function, "mapper is null");
        return RxJavaPlugins.n(new ObservableMap(this, function));
    }

    public final Observable j() {
        return RxJavaPlugins.n(new ObservableMaterialize(this));
    }

    public final Observable k(Scheduler scheduler) {
        return l(scheduler, false, d());
    }

    public final Observable l(Scheduler scheduler, boolean z2, int i3) {
        ObjectHelper.d(scheduler, "scheduler is null");
        ObjectHelper.e(i3, "bufferSize");
        return RxJavaPlugins.n(new ObservableObserveOn(this, scheduler, z2, i3));
    }

    public final ConnectableObservable m() {
        return ObservableReplay.F(this);
    }

    public final ConnectableObservable n(int i3) {
        ObjectHelper.e(i3, "bufferSize");
        return ObservableReplay.B(this, i3);
    }

    public final ConnectableObservable o(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(i3, "bufferSize");
        ObjectHelper.d(timeUnit, "unit is null");
        ObjectHelper.d(scheduler, "scheduler is null");
        return ObservableReplay.D(this, j3, timeUnit, scheduler, i3);
    }

    public final ConnectableObservable p(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.d(timeUnit, "unit is null");
        ObjectHelper.d(scheduler, "scheduler is null");
        return ObservableReplay.C(this, j3, timeUnit, scheduler);
    }

    public final Maybe q() {
        return RxJavaPlugins.m(new ObservableSingleMaybe(this));
    }

    public final Single r() {
        return RxJavaPlugins.o(new ObservableSingleSingle(this, null));
    }

    public final Disposable s(Consumer consumer, Consumer consumer2) {
        return t(consumer, consumer2, Functions.f134907c, Functions.a());
    }

    public final Disposable t(Consumer consumer, Consumer consumer2, Action action, Consumer consumer3) {
        ObjectHelper.d(consumer, "onNext is null");
        ObjectHelper.d(consumer2, "onError is null");
        ObjectHelper.d(action, "onComplete is null");
        ObjectHelper.d(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        b(lambdaObserver);
        return lambdaObserver;
    }

    protected abstract void u(Observer observer);

    public final Observable v(Scheduler scheduler) {
        ObjectHelper.d(scheduler, "scheduler is null");
        return RxJavaPlugins.n(new ObservableSubscribeOn(this, scheduler));
    }

    public final Observable w(ObservableSource observableSource) {
        ObjectHelper.d(observableSource, "other is null");
        return RxJavaPlugins.n(new ObservableSwitchIfEmpty(this, observableSource));
    }

    public final Flowable x(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i3 = AnonymousClass1.f134852a[backpressureStrategy.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? flowableFromObservable.n() : RxJavaPlugins.l(new FlowableOnBackpressureError(flowableFromObservable)) : flowableFromObservable : flowableFromObservable.r() : flowableFromObservable.q();
    }

    public static Observable g(Object obj) {
        ObjectHelper.d(obj, HcgZcEUYo.IZEFe);
        return RxJavaPlugins.n(new ObservableJust(obj));
    }
}

package io.reactivex;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Flowable<T> implements Publisher<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f134849a = Math.max(1, Integer.getInteger("rx2.buffer-size", ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).intValue());

    public static int a() {
        return f134849a;
    }

    public static Flowable d(Publisher publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.l((Flowable) publisher);
        }
        ObjectHelper.d(publisher, "publisher is null");
        return RxJavaPlugins.l(new FlowableFromPublisher(publisher));
    }

    public static Flowable f(Object obj) {
        ObjectHelper.d(obj, "item is null");
        return RxJavaPlugins.l(new FlowableJust(obj));
    }

    public static Flowable z(Iterable iterable, Function function, boolean z2, int i3) {
        ObjectHelper.d(function, "zipper is null");
        ObjectHelper.d(iterable, "sources is null");
        ObjectHelper.e(i3, "bufferSize");
        return RxJavaPlugins.l(new FlowableZip(null, iterable, function, i3, z2));
    }

    public final Flowable b(Object obj) {
        ObjectHelper.d(obj, "item is null");
        return y(f(obj));
    }

    @Override // org.reactivestreams.Publisher
    public final void i(Subscriber subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            w((FlowableSubscriber) subscriber);
        } else {
            ObjectHelper.d(subscriber, "s is null");
            w(new StrictSubscriber(subscriber));
        }
    }

    public final Flowable j(Function function) {
        ObjectHelper.d(function, "mapper is null");
        return RxJavaPlugins.l(new FlowableMap(this, function));
    }

    public final Flowable k() {
        return RxJavaPlugins.l(new FlowableMaterialize(this));
    }

    public final Flowable l(Scheduler scheduler) {
        return m(scheduler, false, a());
    }

    public final Flowable m(Scheduler scheduler, boolean z2, int i3) {
        ObjectHelper.d(scheduler, "scheduler is null");
        ObjectHelper.e(i3, "bufferSize");
        return RxJavaPlugins.l(new FlowableObserveOn(this, scheduler, z2, i3));
    }

    public final Flowable n() {
        return p(a(), false, true);
    }

    public final Flowable p(int i3, boolean z2, boolean z3) {
        ObjectHelper.e(i3, "bufferSize");
        return RxJavaPlugins.l(new FlowableOnBackpressureBuffer(this, i3, z3, z2, Functions.f134907c));
    }

    public final Flowable q() {
        return RxJavaPlugins.l(new FlowableOnBackpressureDrop(this));
    }

    public final Flowable r() {
        return RxJavaPlugins.l(new FlowableOnBackpressureLatest(this));
    }

    public final ConnectableFlowable s() {
        return FlowableReplay.F(this);
    }

    public final ConnectableFlowable t(int i3) {
        ObjectHelper.e(i3, "bufferSize");
        return FlowableReplay.B(this, i3);
    }

    public final ConnectableFlowable u(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.e(i3, "bufferSize");
        ObjectHelper.d(timeUnit, "unit is null");
        ObjectHelper.d(scheduler, "scheduler is null");
        ObjectHelper.e(i3, "bufferSize");
        return FlowableReplay.D(this, j3, timeUnit, scheduler, i3);
    }

    public final ConnectableFlowable v(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.d(timeUnit, "unit is null");
        ObjectHelper.d(scheduler, "scheduler is null");
        return FlowableReplay.C(this, j3, timeUnit, scheduler);
    }

    public final void w(FlowableSubscriber flowableSubscriber) {
        ObjectHelper.d(flowableSubscriber, "s is null");
        try {
            Subscriber subscriberA = RxJavaPlugins.A(this, flowableSubscriber);
            ObjectHelper.d(subscriberA, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            x(subscriberA);
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

    protected abstract void x(Subscriber subscriber);

    public final Flowable y(Publisher publisher) {
        ObjectHelper.d(publisher, "other is null");
        return RxJavaPlugins.l(new FlowableSwitchIfEmpty(this, publisher));
    }
}

package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Schedulers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Scheduler f139391a = RxJavaPlugins.h(new SingleTask());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Scheduler f139392b = RxJavaPlugins.e(new ComputationTask());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Scheduler f139393c = RxJavaPlugins.f(new IOTask());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Scheduler f139394d = TrampolineScheduler.h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Scheduler f139395e = RxJavaPlugins.g(new NewThreadTask());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ComputationHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Scheduler f139396a = new ComputationScheduler();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler call() {
            return ComputationHolder.f139396a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler call() {
            return IoHolder.f139397a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IoHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Scheduler f139397a = new IoScheduler();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NewThreadHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Scheduler f139398a = new NewThreadScheduler();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler call() {
            return NewThreadHolder.f139398a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Scheduler f139399a = new SingleScheduler();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler call() {
            return SingleHolder.f139399a;
        }
    }

    public static Scheduler a() {
        return RxJavaPlugins.t(f139393c);
    }

    public static Scheduler b() {
        return RxJavaPlugins.v(f139391a);
    }
}

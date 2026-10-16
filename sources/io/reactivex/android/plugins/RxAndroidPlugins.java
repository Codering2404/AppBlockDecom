package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class RxAndroidPlugins {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Function f134869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Function f134870b;

    static Object a(Function function, Object obj) {
        try {
            return function.apply(obj);
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    static Scheduler b(Function function, Callable callable) {
        Scheduler scheduler = (Scheduler) a(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static Scheduler c(Callable callable) {
        try {
            Scheduler scheduler = (Scheduler) callable.call();
            if (scheduler != null) {
                return scheduler;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    public static Scheduler d(Callable callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function function = f134869a;
        return function == null ? c(callable) : b(function, callable);
    }

    public static Scheduler e(Scheduler scheduler) {
        if (scheduler == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function function = f134870b;
        return function == null ? scheduler : (Scheduler) a(function, scheduler);
    }
}

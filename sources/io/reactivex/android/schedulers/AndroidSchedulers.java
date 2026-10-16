package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidSchedulers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Scheduler f134871a = RxAndroidPlugins.d(new Callable<Scheduler>() { // from class: io.reactivex.android.schedulers.AndroidSchedulers.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler call() {
            return MainHolder.f134872a;
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MainHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Scheduler f134872a = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);
    }

    public static Scheduler a() {
        return RxAndroidPlugins.e(f134871a);
    }
}

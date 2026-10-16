package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final BackgroundDetector f71553f = new BackgroundDetector();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f71554a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f71555b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f71556c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f71557d = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BackgroundStateChangeListener {
        void a(boolean z2);
    }

    private BackgroundDetector() {
    }

    public static BackgroundDetector b() {
        return f71553f;
    }

    public static void c(Application application) {
        BackgroundDetector backgroundDetector = f71553f;
        synchronized (backgroundDetector) {
            try {
                if (!backgroundDetector.f71557d) {
                    application.registerActivityLifecycleCallbacks(backgroundDetector);
                    application.registerComponentCallbacks(backgroundDetector);
                    backgroundDetector.f71557d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void f(boolean z2) {
        synchronized (f71553f) {
            try {
                ArrayList arrayList = this.f71556c;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((BackgroundStateChangeListener) obj).a(z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f71553f) {
            this.f71556c.add(backgroundStateChangeListener);
        }
    }

    public boolean d() {
        return this.f71554a.get();
    }

    public boolean e(boolean z2) {
        AtomicBoolean atomicBoolean = this.f71555b;
        if (!atomicBoolean.get()) {
            if (ProcessUtils.b()) {
                return z2;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!atomicBoolean.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f71554a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f71555b;
        boolean zCompareAndSet = this.f71554a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f71555b;
        boolean zCompareAndSet = this.f71554a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        if (i3 == 20 && this.f71554a.compareAndSet(false, true)) {
            this.f71555b.set(true);
            f(true);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}

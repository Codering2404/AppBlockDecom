package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ActivityRecreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Class f33578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Field f33579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f33580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f33581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f33582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f33583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Handler f33584g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: androidx.core.app.ActivityRecreator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LifecycleCheckCallbacks f33585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f33586b;

        @Override // java.lang.Runnable
        public void run() {
            this.f33585a.f33591a = this.f33586b;
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.ActivityRecreator$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f33587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LifecycleCheckCallbacks f33588b;

        @Override // java.lang.Runnable
        public void run() {
            this.f33587a.unregisterActivityLifecycleCallbacks(this.f33588b);
        }
    }

    static {
        Class clsA = a();
        f33578a = clsA;
        f33579b = b();
        f33580c = f();
        f33581d = d(clsA);
        f33582e = c(clsA);
        f33583f = e(clsA);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class cls2 = Integer.TYPE;
                Class cls3 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, cls2, cls3, Configuration.class, Configuration.class, cls3, cls3);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        return false;
    }

    protected static boolean h(Object obj, int i3, Activity activity) {
        try {
            final Object obj2 = f33580c.get(activity);
            if (obj2 == obj && activity.hashCode() == i3) {
                final Object obj3 = f33579b.get(activity);
                f33584g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Method method = ActivityRecreator.f33581d;
                            if (method != null) {
                                method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                            } else {
                                ActivityRecreator.f33582e.invoke(obj3, obj2, Boolean.FALSE);
                            }
                        } catch (RuntimeException e3) {
                            if (e3.getClass() == RuntimeException.class && e3.getMessage() != null && e3.getMessage().startsWith("Unable to stop")) {
                                throw e3;
                            }
                        } catch (Throwable th) {
                            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f33591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Activity f33592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f33593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f33594d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f33595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f33596g;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f33592b == activity) {
                this.f33592b = null;
                this.f33595f = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f33595f || this.f33596g || this.f33594d || !ActivityRecreator.h(this.f33591a, this.f33593c, activity)) {
                return;
            }
            this.f33596g = true;
            this.f33591a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f33592b == activity) {
                this.f33594d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}

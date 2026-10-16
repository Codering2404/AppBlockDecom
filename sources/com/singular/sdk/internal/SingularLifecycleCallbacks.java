package com.singular.sdk.internal;

import android.app.Application;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularLifecycleCallbacks implements InvocationHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SingularLog f92730b = SingularLog.f(SingularLifecycleCallbacks.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SessionManager f92731a;

    SingularLifecycleCallbacks(SessionManager sessionManager) {
        this.f92731a = sessionManager;
        sessionManager.v();
    }

    void a(Application application) {
        Method method;
        try {
            Object objNewProxyInstance = Proxy.newProxyInstance(Application.class.getClassLoader(), new Class[]{Application.ActivityLifecycleCallbacks.class}, this);
            Method[] methods = Application.class.getMethods();
            int length = methods.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    method = null;
                    break;
                }
                method = methods[i3];
                if (method.getName().equals("registerActivityLifecycleCallbacks")) {
                    break;
                } else {
                    i3++;
                }
            }
            if (method == null) {
                f92730b.c("ActivityLifecycleCallbacks registration not available, Automatic session management will not work");
            } else {
                method.invoke(application, objNewProxyInstance);
                f92730b.a("ActivityLifecycleCallbacks registration successful, Automatic session management will work.");
            }
        } catch (Throwable th) {
            f92730b.d("ActivityLifecycleCallbacks registration failed, Automatic session management will not work", th);
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if ("onActivityResumed".equals(method.getName())) {
            this.f92731a.m(Utils.y());
            return null;
        }
        if (!"onActivityPaused".equals(method.getName())) {
            return null;
        }
        this.f92731a.n(Utils.y());
        return null;
    }
}

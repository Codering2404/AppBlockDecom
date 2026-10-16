package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RouteException extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f93407b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOException f93408a;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        f93407b = declaredMethod;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f93408a = iOException;
    }

    private void b(IOException iOException, IOException iOException2) {
        Method method = f93407b;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public void a(IOException iOException) {
        b(iOException, this.f93408a);
        this.f93408a = iOException;
    }

    public IOException c() {
        return this.f93408a;
    }
}

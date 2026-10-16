package com.applovin.impl;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f61959a;

    public static IBinder a(Bundle bundle, String str) {
        return xp.f65027a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    private static IBinder b(Bundle bundle, String str) {
        Method method = f61959a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f61959a = method2;
                method2.setAccessible(true);
                method = f61959a;
            } catch (NoSuchMethodException e3) {
                oc.b("BundleUtil", "Failed to retrieve getIBinder method", e3);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e4) {
            oc.b("BundleUtil", "Failed to invoke getIBinder via reflection", e4);
            return null;
        }
    }
}

package com.singular.sdk.internal;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class OAIDHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92616a = SingularLog.f(OAIDHelper.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f92617b = {1008610, 1008611, 1008612, 1008613, 1008614, 1008615};

    private static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e3) {
            f92616a.a("Class not found: " + str + " - " + Utils.l(e3));
            return null;
        }
    }

    private static String c(Context context) {
        try {
            Class clsB = b("com.huawei.hms.ads.identifier.AdvertisingIdClient");
            if (((Boolean) clsB.getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, context)).booleanValue()) {
                Object objInvoke = clsB.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
                return (String) objInvoke.getClass().getDeclaredMethod("getId", null).invoke(objInvoke, null);
            }
        } catch (Throwable th) {
            f92616a.a("Failed to get Huawei OAID: " + Utils.l(th));
        }
        return null;
    }

    private static String d(Context context) {
        if (!k()) {
            f92616a.a("getMsaOAID: MSA OAID not supported, SDK classes not found");
            return null;
        }
        try {
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            g(context);
            Class clsB = b("com.bun.miitmdid.core.IIdentifierListener");
            if (clsB == null) {
                f92616a.a("getMsaOAID: callback class is null, cannot get OAID");
                return null;
            }
            int iH = h(context, Proxy.newProxyInstance(clsB.getClassLoader(), new Class[]{clsB}, new InvocationHandler() { // from class: com.singular.sdk.internal.OAIDHelper.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (objArr == null || objArr.length <= 1) {
                        linkedBlockingQueue.offer("");
                    }
                    linkedBlockingQueue.offer(OAIDHelper.e(objArr[1]));
                    return null;
                }
            }), clsB);
            if (!j(iH)) {
                String str = (String) linkedBlockingQueue.poll(1L, TimeUnit.SECONDS);
                if (Utils.U(str)) {
                    return null;
                }
                return str;
            }
            f92616a.a("getMsaOAID: MSA SDK initialization failed with error code: " + iH);
            return null;
        } catch (Throwable th) {
            f92616a.a("Failed to get MSA OAID: " + Utils.l(th));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return (String) obj.getClass().getMethod("getOAID", null).invoke(obj, null);
        } catch (Throwable th) {
            f92616a.a("Failed to get OAID from supplier: " + Utils.l(th));
            return "";
        }
    }

    static String f(Context context) {
        return i() ? c(context) : d(context);
    }

    private static void g(Context context) throws IllegalAccessException, InvocationTargetException {
        b("com.bun.miitmdid.core.JLibrary").getMethod("InitEntry", Context.class).invoke(null, context);
    }

    private static int h(Context context, Object obj, Class cls) {
        try {
            return ((Integer) b("com.bun.miitmdid.core.MdidSdkHelper").getMethod("InitSdk", Context.class, Boolean.TYPE, cls).invoke(null, context, Boolean.FALSE, obj)).intValue();
        } catch (Throwable th) {
            f92616a.a("Failed to initialize MSA SDK: " + Utils.l(th));
            return f92617b[0];
        }
    }

    private static boolean i() {
        return Build.MANUFACTURER.equalsIgnoreCase("huawei") && b("com.huawei.hms.ads.identifier.AdvertisingIdClient") != null;
    }

    private static boolean j(int i3) {
        return Arrays.asList(f92617b).contains(Integer.valueOf(i3));
    }

    private static boolean k() {
        return b("com.bun.miitmdid.core.MdidSdkHelper") != null;
    }
}

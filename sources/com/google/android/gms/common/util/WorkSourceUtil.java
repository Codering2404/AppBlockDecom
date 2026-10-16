package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkSourceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f72286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f72287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f72288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f72289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f72290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Method f72291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Method f72292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Method f72293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Method f72294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Boolean f72295j;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8;
        Class cls = Integer.TYPE;
        f72286a = Process.myUid();
        try {
            method = WorkSource.class.getMethod("add", cls);
        } catch (Exception unused) {
            method = null;
        }
        f72287b = method;
        try {
            method2 = WorkSource.class.getMethod("add", cls, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f72288c = method2;
        try {
            method3 = WorkSource.class.getMethod("size", null);
        } catch (Exception unused3) {
            method3 = null;
        }
        f72289d = method3;
        try {
            method4 = WorkSource.class.getMethod("get", cls);
        } catch (Exception unused4) {
            method4 = null;
        }
        f72290e = method4;
        try {
            method5 = WorkSource.class.getMethod("getName", cls);
        } catch (Exception unused5) {
            method5 = null;
        }
        f72291f = method5;
        if (PlatformVersion.f()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", null);
            } catch (Exception e3) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e3);
                method6 = null;
            }
        } else {
            method6 = null;
        }
        f72292g = method6;
        if (PlatformVersion.f()) {
            try {
                method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", cls, String.class);
            } catch (Exception e4) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e4);
                method7 = null;
            }
        } else {
            method7 = null;
        }
        f72293h = method7;
        if (PlatformVersion.f()) {
            try {
                method8 = WorkSource.class.getMethod("isEmpty", null);
                try {
                    method8.setAccessible(true);
                } catch (Exception unused6) {
                }
            } catch (Exception unused7) {
                method8 = null;
            }
        } else {
            method8 = null;
        }
        f72294i = method8;
        f72295j = null;
    }

    public static void a(WorkSource workSource, int i3, String str) {
        Method method = f72288c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i3), str);
                return;
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                return;
            }
        }
        Method method2 = f72287b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i3));
            } catch (Exception e4) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
            }
        }
    }

    public static synchronized boolean c(Context context) {
        Boolean bool = f72295j;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
        f72295j = Boolean.valueOf(z2);
        return z2;
    }

    public static boolean d(WorkSource workSource) {
        Method method = f72294i;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, null);
                Preconditions.m(objInvoke);
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e3) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e3);
            }
        }
        return e(workSource) == 0;
    }

    public static int e(WorkSource workSource) {
        Method method = f72289d;
        if (method == null) {
            return 0;
        }
        try {
            Object objInvoke = method.invoke(workSource, null);
            Preconditions.m(objInvoke);
            return ((Integer) objInvoke).intValue();
        } catch (Exception e3) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            return 0;
        }
    }

    public static WorkSource b(Context context, String str) {
        String str2 = vxrlPPpdv.jRSVrlaDxDkL;
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfoC = Wrappers.a(context).c(str, 0);
                if (applicationInfoC == null) {
                    Log.e(str2, "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i3 = applicationInfoC.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i3, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e(str2, "Could not find package: ".concat(str));
            }
        }
        return null;
    }
}

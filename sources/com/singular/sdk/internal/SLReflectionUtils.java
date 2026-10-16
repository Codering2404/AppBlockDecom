package com.singular.sdk.internal;

import android.content.res.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLReflectionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92649a = SingularLog.f(SLReflectionUtils.class.getSimpleName());

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            f92649a.a("Failed to find class " + str + " via reflection: " + Utils.l(th));
            return null;
        }
    }

    static String b() {
        try {
            return (String) i("android.os.Build", "CPU_ABI");
        } catch (Throwable th) {
            f92649a.a("Failed to get CPU ABI via reflection: " + Utils.l(th));
            return null;
        }
    }

    static Locale c(Configuration configuration) {
        try {
            return (Locale) j("android.content.res.Configuration", "locale", configuration);
        } catch (Throwable th) {
            f92649a.a("Failed to get locale from field via reflection: " + Utils.l(th));
            return null;
        }
    }

    static Locale d(Configuration configuration) {
        try {
            Object objF = f(configuration, "getLocales", null, new Object[0]);
            if (objF != null) {
                return (Locale) f(objF, "get", new Class[]{Integer.TYPE}, 0);
            }
            f92649a.a("getLocaleFromLocaleList: locales list is null");
            return null;
        } catch (Throwable th) {
            f92649a.a("Failed to get locale from locale list via reflection: " + Utils.l(th));
            return null;
        }
    }

    static String[] e() {
        try {
            return (String[]) i("android.os.Build", "SUPPORTED_ABIS");
        } catch (Throwable th) {
            f92649a.a("Failed to get supported ABIs via reflection: " + Utils.l(th));
            return null;
        }
    }

    public static Object f(Object obj, String str, Class[] clsArr, Object... objArr) {
        return g(obj.getClass(), str, obj, clsArr, objArr);
    }

    static Object g(Class cls, String str, Object obj, Class[] clsArr, Object... objArr) throws NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (method != null) {
            return method.invoke(obj, objArr);
        }
        f92649a.a("invokeMethod: method object is null for method: " + str);
        return null;
    }

    public static Object h(String str, String str2, Class[] clsArr, Object... objArr) {
        return g(Class.forName(str), str2, null, clsArr, objArr);
    }

    static Object i(String str, String str2) {
        return j(str, str2, null);
    }

    static Object j(String str, String str2, Object obj) throws NoSuchFieldException {
        Class clsA = a(str);
        if (clsA == null) {
            f92649a.a("readField: class object is null for class: " + str);
            return null;
        }
        Field field = clsA.getField(str2);
        if (field != null) {
            return field.get(obj);
        }
        f92649a.a("readField: field object is null for field: " + str2 + " in class: " + str);
        return null;
    }
}

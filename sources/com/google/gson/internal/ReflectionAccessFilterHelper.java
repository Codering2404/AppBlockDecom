package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ReflectionAccessFilterHelper {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class AccessChecker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AccessChecker f90384a;

        static {
            AccessChecker accessChecker;
            if (JavaVersion.d()) {
                try {
                    final Method declaredMethod = AccessibleObject.class.getDeclaredMethod("canAccess", Object.class);
                    accessChecker = new AccessChecker() { // from class: com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super();
                        }

                        @Override // com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker
                        public boolean a(AccessibleObject accessibleObject, Object obj) {
                            try {
                                return ((Boolean) declaredMethod.invoke(accessibleObject, obj)).booleanValue();
                            } catch (Exception e3) {
                                throw new RuntimeException("Failed invoking canAccess", e3);
                            }
                        }
                    };
                } catch (NoSuchMethodException unused) {
                    accessChecker = null;
                }
            } else {
                accessChecker = null;
            }
            if (accessChecker == null) {
                accessChecker = new AccessChecker() { // from class: com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker.2
                    @Override // com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker
                    public boolean a(AccessibleObject accessibleObject, Object obj) {
                        return true;
                    }
                };
            }
            f90384a = accessChecker;
        }

        private AccessChecker() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return AccessChecker.f90384a.a(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult b(List list, Class cls) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult filterResultA = ((ReflectionAccessFilter) it.next()).a(cls);
            if (filterResultA != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return filterResultA;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }

    public static boolean c(Class cls) {
        return d(cls.getName());
    }

    private static boolean d(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || g(str);
    }

    public static boolean e(Class cls) {
        String name = cls.getName();
        return d(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static boolean f(Class cls) {
        return g(cls.getName());
    }

    private static boolean g(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }
}

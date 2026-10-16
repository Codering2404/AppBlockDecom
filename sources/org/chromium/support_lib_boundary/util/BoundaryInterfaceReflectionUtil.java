package org.chromium.support_lib_boundary.util;

import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BoundaryInterfaceReflectionUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InvocationHandlerWithDelegateGetter implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f145355a;

        public InvocationHandlerWithDelegateGetter(Object obj) {
            this.f145355a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return BoundaryInterfaceReflectionUtil.d(method, this.f145355a.getClass().getClassLoader()).invoke(this.f145355a, objArr);
            } catch (InvocationTargetException e3) {
                throw e3.getTargetException();
            } catch (ReflectiveOperationException e4) {
                throw new RuntimeException("Reflection failed for method " + method, e4);
            }
        }
    }

    public static Object a(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static boolean b(Collection collection, String str) {
        if (collection.contains(str)) {
            return true;
        }
        if (!e()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":dev");
        return collection.contains(sb.toString());
    }

    public static InvocationHandler c(Object obj) {
        if (obj == null) {
            return null;
        }
        return new InvocationHandlerWithDelegateGetter(obj);
    }

    public static Method d(Method method, ClassLoader classLoader) throws ClassNotFoundException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    private static boolean e() {
        String str = Build.TYPE;
        return "eng".equals(str) || "userdebug".equals(str);
    }
}

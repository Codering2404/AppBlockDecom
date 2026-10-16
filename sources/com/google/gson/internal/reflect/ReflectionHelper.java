package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ReflectionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RecordHelper f90525a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class RecordHelper {
        private RecordHelper() {
        }

        public abstract Method a(Class cls, Field field);

        abstract Constructor b(Class cls);

        abstract String[] c(Class cls);

        abstract boolean d(Class cls);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RecordNotSupportedHelper extends RecordHelper {
        private RecordNotSupportedHelper() {
            super();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean d(Class cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RecordSupportedHelper extends RecordHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f90526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f90527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f90528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f90529d;

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), null);
            } catch (ReflectiveOperationException e3) {
                throw ReflectionHelper.d(e3);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f90527b.invoke(cls, null);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    clsArr[i3] = (Class) this.f90529d.invoke(objArr[i3], null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e3) {
                throw ReflectionHelper.d(e3);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f90527b.invoke(cls, null);
                String[] strArr = new String[objArr.length];
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    strArr[i3] = (String) this.f90528c.invoke(objArr[i3], null);
                }
                return strArr;
            } catch (ReflectiveOperationException e3) {
                throw ReflectionHelper.d(e3);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean d(Class cls) {
            try {
                return ((Boolean) this.f90526a.invoke(cls, null)).booleanValue();
            } catch (ReflectiveOperationException e3) {
                throw ReflectionHelper.d(e3);
            }
        }

        private RecordSupportedHelper() throws NoSuchMethodException {
            super();
            this.f90526a = Class.class.getMethod("isRecord", null);
            Method method = Class.class.getMethod("getRecordComponents", null);
            this.f90527b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f90528c = componentType.getMethod("getName", null);
            this.f90529d = componentType.getMethod("getType", null);
        }
    }

    static {
        RecordHelper recordNotSupportedHelper;
        try {
            recordNotSupportedHelper = new RecordSupportedHelper();
        } catch (NoSuchMethodException unused) {
            recordNotSupportedHelper = new RecordNotSupportedHelper();
        }
        f90525a = recordNotSupportedHelper;
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i3].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static Method h(Class cls, Field field) {
        return f90525a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f90525a.b(cls);
    }

    public static String[] j(Class cls) {
        return f90525a.c(cls);
    }

    public static boolean k(Class cls) {
        return f90525a.d(cls);
    }

    public static void l(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e3) {
            throw new JsonIOException("Failed making " + g(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e3);
        }
    }

    public static String m(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e3) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e3.getMessage();
        }
    }

    public static String g(AccessibleObject accessibleObject, boolean z2) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = MrGIhy.UvlaXaY + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z2 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}

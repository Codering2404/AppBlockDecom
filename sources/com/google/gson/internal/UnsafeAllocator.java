package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class UnsafeAllocator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UnsafeAllocator f90390a = c();

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Class cls) {
        String strA = ConstructorConstructor.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }

    private static UnsafeAllocator c() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    final Object obj = declaredField.get(null);
                    final Method method = cls.getMethod("allocateInstance", Class.class);
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public Object d(Class cls2) {
                            UnsafeAllocator.b(cls2);
                            return method.invoke(obj, cls2);
                        }
                    };
                } catch (Exception unused) {
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.4
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public Object d(Class cls2) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls2 + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
                        }
                    };
                }
            } catch (Exception unused2) {
                final Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                    @Override // com.google.gson.internal.UnsafeAllocator
                    public Object d(Class cls2) {
                        UnsafeAllocator.b(cls2);
                        return declaredMethod.invoke(null, cls2, Object.class);
                    }
                };
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            final int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            final Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                @Override // com.google.gson.internal.UnsafeAllocator
                public Object d(Class cls2) {
                    UnsafeAllocator.b(cls2);
                    return declaredMethod3.invoke(null, cls2, Integer.valueOf(iIntValue));
                }
            };
        }
    }

    public abstract Object d(Class cls);
}

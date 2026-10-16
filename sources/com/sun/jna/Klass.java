package com.sun.jna;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
abstract class Klass {
    private Klass() {
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor(null).newInstance(null);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (IllegalArgumentException e4) {
            e = e4;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (InstantiationException e5) {
            e = e5;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (SecurityException e7) {
            e = e7;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e8, e8);
        }
    }
}

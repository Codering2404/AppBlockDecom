package com.facebook.stetho.common;

import java.lang.reflect.Field;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    @Nullable
    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Nullable
    public static Class<?> tryGetClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public static Field tryGetDeclaredField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e3) {
            LogUtil.d(e3, "Could not retrieve %s field from %s", str, cls);
            return null;
        }
    }
}

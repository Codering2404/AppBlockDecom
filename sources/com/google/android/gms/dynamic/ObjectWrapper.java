package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f72377a;

    private ObjectWrapper(Object obj) {
        this.f72377a = obj;
    }

    public static Object h5(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).f72377a;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i3 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i3++;
                field = field2;
            }
        }
        if (i3 != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 53);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        Preconditions.m(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
        } catch (NullPointerException e4) {
            throw new IllegalArgumentException("Binder object is null.", e4);
        }
    }

    public static IObjectWrapper i5(Object obj) {
        return new ObjectWrapper(obj);
    }
}

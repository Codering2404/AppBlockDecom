package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ObjectArrays {
    static Object a(Object obj, int i3) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i3);
    }

    static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    static Object[] c(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            a(objArr[i4], i4);
        }
        return objArr;
    }

    public static Object[] d(Object[] objArr, Object[] objArr2, Class cls) {
        Object[] objArrF = f(cls, objArr.length + objArr2.length);
        System.arraycopy(objArr, 0, objArrF, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArrF, objArr.length, objArr2.length);
        return objArrF;
    }

    private static Object[] e(Iterable iterable, Object[] objArr) {
        Iterator it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return objArr;
    }

    public static Object[] f(Class cls, int i3) {
        return (Object[]) Array.newInstance((Class<?>) cls, i3);
    }

    public static Object[] g(Object[] objArr, int i3) {
        return Platform.b(objArr, i3);
    }

    static Object[] h(Collection collection) {
        return e(collection, new Object[collection.size()]);
    }

    static Object[] i(Collection collection, Object[] objArr) {
        int size = collection.size();
        if (objArr.length < size) {
            objArr = g(objArr, size);
        }
        e(collection, objArr);
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    static Object[] j(Object[] objArr, int i3, int i4, Object[] objArr2) {
        Preconditions.y(i3, i3 + i4, objArr.length);
        if (objArr2.length < i4) {
            objArr2 = g(objArr2, i4);
        } else if (objArr2.length > i4) {
            objArr2[i4] = null;
        }
        System.arraycopy(objArr, i3, objArr2, 0, i4);
        return objArr2;
    }
}

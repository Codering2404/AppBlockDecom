package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class fg {
    static Object a(Object obj, int i3) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i3);
    }

    public static Object[] b(Object[] objArr, int i3) {
        return mh.a(objArr, i3);
    }

    static Object[] a(Object... objArr) {
        return a(objArr, objArr.length);
    }

    static Object[] a(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            a(objArr[i4], i4);
        }
        return objArr;
    }
}

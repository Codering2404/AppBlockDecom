package com.applovin.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class mh {
    static Object[] a(Object[] objArr, int i3, int i4, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i3, i4, objArr2.getClass());
    }

    static Object[] a(Object[] objArr, int i3) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i3);
    }

    static Map a() {
        return w3.a();
    }
}

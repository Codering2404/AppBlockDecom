package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    static Object[] a(Object[] objArr, int i3, int i4, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i3, i4, objArr2.getClass());
    }

    static Object[] b(Object[] objArr, int i3) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, 0);
        }
        return Arrays.copyOf(objArr, i3);
    }

    static Map c(int i3) {
        return CompactHashMap.w(i3);
    }

    static Set d(int i3) {
        return CompactHashSet.h(i3);
    }

    static Map e(int i3) {
        return CompactLinkedHashMap.d0(i3);
    }

    static Set f(int i3) {
        return CompactLinkedHashSet.I(i3);
    }

    static Map g() {
        return CompactHashMap.r();
    }

    static MapMaker h(MapMaker mapMaker) {
        return mapMaker.l();
    }
}

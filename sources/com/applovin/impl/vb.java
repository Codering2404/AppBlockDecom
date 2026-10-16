package com.applovin.impl;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class vb {
    private static Collection a(Iterable iterable) {
        return iterable instanceof Collection ? (Collection) iterable : hc.a(iterable.iterator());
    }

    public static Object b(Iterable iterable) {
        if (!(iterable instanceof List)) {
            return wb.b(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return a(list);
    }

    static Object[] c(Iterable iterable) {
        return a(iterable).toArray();
    }

    public static String d(Iterable iterable) {
        return wb.d(iterable.iterator());
    }

    public static Object a(Iterable iterable, Object obj) {
        return wb.a(iterable.iterator(), obj);
    }

    private static Object a(List list) {
        return list.get(list.size() - 1);
    }
}

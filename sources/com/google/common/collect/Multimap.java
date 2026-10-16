package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public interface Multimap<K, V> {
    Collection a(Object obj);

    Map a1();

    Collection b();

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    Collection get(Object obj);

    int hashCode();

    boolean isEmpty();

    Set keySet();

    Multiset keys();

    boolean put(Object obj, Object obj2);

    boolean remove(Object obj, Object obj2);

    int size();

    Collection values();

    boolean w1(Object obj, Object obj2);
}

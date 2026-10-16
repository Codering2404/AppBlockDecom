package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public interface Multiset<E> extends Collection<E> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Entry<E> {
        Object a();

        int getCount();

        String toString();
    }

    boolean L1(Object obj, int i3, int i4);

    int Y1(Object obj);

    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection collection);

    int e0(Object obj, int i3);

    Set entrySet();

    boolean equals(Object obj);

    int hashCode();

    Set i();

    Iterator iterator();

    int o1(Object obj, int i3);

    boolean remove(Object obj);

    int size();

    int t1(Object obj, int i3);
}

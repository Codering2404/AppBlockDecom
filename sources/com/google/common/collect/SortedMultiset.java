package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public interface SortedMultiset<E> extends SortedMultisetBridge<E>, SortedIterable<E> {
    SortedMultiset A1();

    SortedMultiset Q1(Object obj, BoundType boundType);

    Comparator comparator();

    @Override // com.google.common.collect.Multiset
    Set entrySet();

    Multiset.Entry firstEntry();

    SortedMultiset h2(Object obj, BoundType boundType);

    @Override // com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset
    NavigableSet i();

    SortedMultiset i1(Object obj, BoundType boundType, Object obj2, BoundType boundType2);

    Multiset.Entry lastEntry();

    Multiset.Entry pollFirstEntry();

    Multiset.Entry pollLastEntry();
}

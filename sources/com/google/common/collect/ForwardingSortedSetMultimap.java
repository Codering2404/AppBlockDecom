package com.google.common.collect;

import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSetMultimap
    /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract SortedSetMultimap I1();

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedSet a(Object obj) {
        return o2().a(obj);
    }

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedSet get(Object obj) {
        return o2().get(obj);
    }
}

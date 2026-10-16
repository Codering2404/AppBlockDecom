package com.google.common.collect;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public interface SetMultimap<K, V> extends Multimap<K, V> {
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    Set a(Object obj);

    @Override // com.google.common.collect.Multimap
    Set b();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    Set get(Object obj);
}

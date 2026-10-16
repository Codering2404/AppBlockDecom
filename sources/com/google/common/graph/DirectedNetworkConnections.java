package com.google.common.graph;

import com.google.common.collect.BiMap;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    @Override // com.google.common.graph.NetworkConnections
    public Set a() {
        return Collections.unmodifiableSet(((BiMap) this.f84910b).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set b() {
        return Collections.unmodifiableSet(((BiMap) this.f84909a).values());
    }
}

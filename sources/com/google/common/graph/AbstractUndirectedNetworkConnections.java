package com.google.common.graph;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map f84918a;

    @Override // com.google.common.graph.NetworkConnections
    public Set a() {
        return c();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set b() {
        return c();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object d(Object obj) {
        Object obj2 = this.f84918a.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }
}

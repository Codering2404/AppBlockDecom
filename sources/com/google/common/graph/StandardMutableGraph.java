package com.google.common.graph;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableValueGraph f84993a;

    @Override // com.google.common.graph.ForwardingGraph
    BaseGraph t() {
        return this.f84993a;
    }
}

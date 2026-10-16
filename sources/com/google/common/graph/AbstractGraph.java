package com.google.common.graph;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractGraph<N> extends AbstractBaseGraph<N> implements Graph<N> {
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set b() {
        return super.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Graph)) {
            return false;
        }
        Graph graph = (Graph) obj;
        return d() == graph.d() && f().equals(graph.f()) && b().equals(graph.b());
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int g(Object obj) {
        return super.g(obj);
    }

    public final int hashCode() {
        return b().hashCode();
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int i(Object obj) {
        return super.i(obj);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int j(Object obj) {
        return super.j(obj);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set k(Object obj) {
        return super.k(obj);
    }

    public String toString() {
        return "isDirected: " + d() + ", allowsSelfLoops: " + e() + ", nodes: " + f() + ", edges: " + b();
    }
}

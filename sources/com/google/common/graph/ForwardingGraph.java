package com.google.common.graph;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class ForwardingGraph<N> extends AbstractGraph<N> {
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set c(Object obj) {
        return t().c(obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean d() {
        return t().d();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean e() {
        return t().e();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set f() {
        return t().f();
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int g(Object obj) {
        return t().g(obj);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set h(Object obj) {
        return t().h(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int i(Object obj) {
        return t().i(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int j(Object obj) {
        return t().j(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public Set k(Object obj) {
        return t().k(obj);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long q() {
        return t().b().size();
    }

    abstract BaseGraph t();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set a(Object obj) {
        return t().a(obj);
    }
}

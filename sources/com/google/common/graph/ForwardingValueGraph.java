package com.google.common.graph;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set c(Object obj) {
        return v().c(obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean d() {
        return v().d();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean e() {
        return v().e();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set f() {
        return v().f();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int g(Object obj) {
        return v().g(obj);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set h(Object obj) {
        return v().h(obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int i(Object obj) {
        return v().i(obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int j(Object obj) {
        return v().j(obj);
    }

    @Override // com.google.common.graph.ValueGraph
    public Object m(Object obj, Object obj2, Object obj3) {
        return v().m(obj, obj2, obj3);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long q() {
        return v().b().size();
    }

    abstract ValueGraph v();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set a(Object obj) {
        return v().a(obj);
    }
}

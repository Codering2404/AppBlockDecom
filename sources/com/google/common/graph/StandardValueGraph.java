package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f84999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f85000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final MapIteratorCache f85001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f85002d;

    private final GraphConnections v(Object obj) {
        GraphConnections graphConnections = (GraphConnections) this.f85001c.d(obj);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.t(obj);
        throw new IllegalArgumentException("Node " + obj + " is not an element of this graph.");
    }

    private final Object w(Object obj, Object obj2, Object obj3) {
        GraphConnections graphConnections = (GraphConnections) this.f85001c.d(obj);
        Object objD = graphConnections == null ? null : graphConnections.d(obj2);
        return objD == null ? obj3 : objD;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set c(Object obj) {
        return s(v(obj).b(), obj);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean d() {
        return this.f84999a;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean e() {
        return this.f85000b;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set f() {
        return this.f85001c.g();
    }

    @Override // com.google.common.graph.BaseGraph
    public Set h(Object obj) {
        return s(v(obj).c(), obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public Set k(Object obj) {
        final GraphConnections graphConnectionsV = v(obj);
        return s(new IncidentEdgeSet<N>(this, this, obj) { // from class: com.google.common.graph.StandardValueGraph.1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ StandardValueGraph f85004d;

            {
                this.f85004d = this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return graphConnectionsV.e(this.f84975a);
            }
        }, obj);
    }

    public Object m(Object obj, Object obj2, Object obj3) {
        return w(Preconditions.t(obj), Preconditions.t(obj2), obj3);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long q() {
        return this.f85002d;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set a(Object obj) {
        return s(v(obj).a(), obj);
    }
}

package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.graph.Graphs;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Graphs extends GraphsBridgeMethods {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NodeAndRemainingSuccessors<N> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransposedGraph<N> extends ForwardingGraph<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Graph f84970a;

        /* JADX INFO: renamed from: com.google.common.graph.Graphs$TransposedGraph$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends IncidentEdgeSet<N> {
            AnonymousClass1(BaseGraph baseGraph, Object obj) {
                super(baseGraph, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Iterators.N(TransposedGraph.this.t().k(this.f84975a).iterator(), new Function() { // from class: com.google.common.graph.n
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        EndpointPair endpointPair = (EndpointPair) obj;
                        return EndpointPair.g(Graphs.TransposedGraph.this.t(), endpointPair.f(), endpointPair.e());
                    }
                });
            }
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set c(Object obj) {
            return t().a(obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int g(Object obj) {
            return t().i(obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int i(Object obj) {
            return t().g(obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set k(Object obj) {
            return new AnonymousClass1(this, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.graph.ForwardingGraph
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Graph t() {
            return this.f84970a;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set a(Object obj) {
            return t().c(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Network f84972a;

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set c(Object obj) {
            return s().a(obj);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair n(Object obj) {
            EndpointPair endpointPairN = s().n(obj);
            return EndpointPair.h(this.f84972a, endpointPairN.f(), endpointPairN.e());
        }

        @Override // com.google.common.graph.ForwardingNetwork
        Network s() {
            return this.f84972a;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set a(Object obj) {
            return s().c(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ValueGraph f84973a;

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set c(Object obj) {
            return v().a(obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int g(Object obj) {
            return v().i(obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int i(Object obj) {
            return v().g(obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        public Object m(Object obj, Object obj2, Object obj3) {
            return v().m(obj2, obj, obj3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        ValueGraph v() {
            return this.f84973a;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set a(Object obj) {
            return v().c(obj);
        }
    }
}

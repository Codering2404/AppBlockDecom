package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.graph.AbstractNetwork;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends AbstractGraph<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractNetwork f84913a;

        /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C01601 extends AbstractSet<EndpointPair<Object>> {
            C01601() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                return AnonymousClass1.this.r(endpointPair) && AnonymousClass1.this.f().contains(endpointPair.e()) && AnonymousClass1.this.a(endpointPair.e()).contains(endpointPair.f());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Iterators.N(AnonymousClass1.this.f84913a.b().iterator(), new Function() { // from class: com.google.common.graph.i
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return AbstractNetwork.AnonymousClass1.this.f84913a.n(obj);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AnonymousClass1.this.f84913a.b().size();
            }
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set b() {
            return this.f84913a.l() ? super.b() : new C01601();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set c(Object obj) {
            return this.f84913a.c(obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean d() {
            return this.f84913a.d();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean e() {
            return this.f84913a.e();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set f() {
            return this.f84913a.f();
        }

        @Override // com.google.common.graph.BaseGraph
        public Set h(Object obj) {
            return this.f84913a.h(obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set a(Object obj) {
            return this.f84913a.a(obj);
        }
    }

    /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Predicate<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f84915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f84916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractNetwork f84917c;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.f84917c.n(obj).a(this.f84915a).equals(this.f84916b);
        }
    }

    private static Map q(final Network network) {
        return Maps.h(network.b(), new Function() { // from class: com.google.common.graph.h
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return network.n(obj);
            }
        });
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        return d() == network.d() && f().equals(network.f()) && q(this).equals(q(network));
    }

    public final int hashCode() {
        return q(this).hashCode();
    }

    protected final Set r(Set set, final Object obj) {
        return InvalidatableSet.o2(set, new Supplier() { // from class: com.google.common.graph.f
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return Boolean.valueOf(this.f85035a.f().contains(obj));
            }
        }, new Supplier() { // from class: com.google.common.graph.g
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return String.format("Node %s that was used to generate this set is no longer in the graph.", obj);
            }
        });
    }

    public String toString() {
        return "isDirected: " + d() + ", allowsParallelEdges: " + l() + ", allowsSelfLoops: " + e() + ", nodes: " + f() + ", edges: " + q(this);
    }
}

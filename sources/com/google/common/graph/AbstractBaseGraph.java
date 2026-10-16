package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    /* JADX INFO: renamed from: com.google.common.graph.AbstractBaseGraph$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends IncidentEdgeSet<N> {
        AnonymousClass2(BaseGraph baseGraph, Object obj) {
            super(baseGraph, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return this.f84976b.d() ? Iterators.O(Iterators.g(Iterators.N(this.f84976b.c(this.f84975a).iterator(), new Function() { // from class: com.google.common.graph.c
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return EndpointPair.l(obj, this.f85032a.f84975a);
                }
            }), Iterators.N(Sets.a(this.f84976b.a(this.f84975a), ImmutableSet.A(this.f84975a)).iterator(), new Function() { // from class: com.google.common.graph.d
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return EndpointPair.l(this.f85033a.f84975a, obj);
                }
            }))) : Iterators.O(Iterators.N(this.f84976b.h(this.f84975a).iterator(), new Function() { // from class: com.google.common.graph.e
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return EndpointPair.p(this.f85034a.f84975a, obj);
                }
            }));
        }
    }

    @Override // com.google.common.graph.BaseGraph
    public Set b() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public UnmodifiableIterator iterator() {
                return EndpointPairIterator.e(AbstractBaseGraph.this);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.r(endpointPair) && AbstractBaseGraph.this.f().contains(endpointPair.e()) && AbstractBaseGraph.this.a(endpointPair.e()).contains(endpointPair.f());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.m(AbstractBaseGraph.this.q());
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph
    public int g(Object obj) {
        return d() ? a(obj).size() : j(obj);
    }

    @Override // com.google.common.graph.BaseGraph
    public int i(Object obj) {
        return d() ? c(obj).size() : j(obj);
    }

    @Override // com.google.common.graph.BaseGraph
    public int j(Object obj) {
        if (d()) {
            return IntMath.i(c(obj).size(), a(obj).size());
        }
        Set setH = h(obj);
        return IntMath.i(setH.size(), (e() && setH.contains(obj)) ? 1 : 0);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set k(Object obj) {
        Preconditions.t(obj);
        Preconditions.m(f().contains(obj), "Node %s is not an element of this graph.", obj);
        return s(new AnonymousClass2(this, obj), obj);
    }

    protected long q() {
        Iterator it = f().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += (long) j(it.next());
        }
        Preconditions.z((1 & j3) == 0);
        return j3 >>> 1;
    }

    protected final boolean r(EndpointPair endpointPair) {
        return endpointPair.b() == d();
    }

    protected final Set s(Set set, final Object obj) {
        return InvalidatableSet.o2(set, new Supplier() { // from class: com.google.common.graph.a
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return Boolean.valueOf(this.f85029a.f().contains(obj));
            }
        }, new Supplier() { // from class: com.google.common.graph.b
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return String.format("Node %s that was used to generate this set is no longer in the graph.", obj);
            }
        });
    }
}

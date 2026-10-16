package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public abstract class EndpointPair<N> implements Iterable<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f84958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f84959b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Ordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean b() {
            return true;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            return b() == endpointPair.b() && n().equals(endpointPair.n()) && o().equals(endpointPair.o());
        }

        public int hashCode() {
            return Objects.b(n(), o());
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public Object n() {
            return e();
        }

        @Override // com.google.common.graph.EndpointPair
        public Object o() {
            return f();
        }

        public String toString() {
            return "<" + n() + " -> " + o() + ">";
        }

        private Ordered(Object obj, Object obj2) {
            super(obj, obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Unordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean b() {
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (b() != endpointPair.b()) {
                return false;
            }
            return e().equals(endpointPair.e()) ? f().equals(endpointPair.f()) : e().equals(endpointPair.f()) && f().equals(endpointPair.e());
        }

        public int hashCode() {
            return e().hashCode() + f().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public Object n() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public Object o() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            return "[" + e() + ", " + f() + "]";
        }

        private Unordered(Object obj, Object obj2) {
            super(obj, obj2);
        }
    }

    static EndpointPair g(Graph graph, Object obj, Object obj2) {
        return graph.d() ? l(obj, obj2) : p(obj, obj2);
    }

    static EndpointPair h(Network network, Object obj, Object obj2) {
        return network.d() ? l(obj, obj2) : p(obj, obj2);
    }

    public static EndpointPair l(Object obj, Object obj2) {
        return new Ordered(obj, obj2);
    }

    public static EndpointPair p(Object obj, Object obj2) {
        return new Unordered(obj2, obj);
    }

    public final Object a(Object obj) {
        if (obj.equals(this.f84958a)) {
            return this.f84959b;
        }
        if (obj.equals(this.f84959b)) {
            return this.f84958a;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + obj);
    }

    public abstract boolean b();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final UnmodifiableIterator iterator() {
        return Iterators.s(this.f84958a, this.f84959b);
    }

    public final Object e() {
        return this.f84958a;
    }

    public final Object f() {
        return this.f84959b;
    }

    public abstract Object n();

    public abstract Object o();

    private EndpointPair(Object obj, Object obj2) {
        this.f84958a = Preconditions.t(obj);
        this.f84959b = Preconditions.t(obj2);
    }
}

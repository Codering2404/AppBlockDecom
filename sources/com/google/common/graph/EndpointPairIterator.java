package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BaseGraph f84960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Iterator f84961d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f84962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Iterator f84963g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Directed<N> extends EndpointPairIterator<N> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public EndpointPair a() {
            while (!this.f84963g.hasNext()) {
                if (!d()) {
                    return (EndpointPair) b();
                }
            }
            Object obj = this.f84962f;
            Objects.requireNonNull(obj);
            return EndpointPair.l(obj, this.f84963g.next());
        }

        private Directed(BaseGraph baseGraph) {
            super(baseGraph);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Undirected<N> extends EndpointPairIterator<N> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Set f84964h;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public EndpointPair a() {
            do {
                Objects.requireNonNull(this.f84964h);
                while (this.f84963g.hasNext()) {
                    Object next = this.f84963g.next();
                    if (!this.f84964h.contains(next)) {
                        Object obj = this.f84962f;
                        Objects.requireNonNull(obj);
                        return EndpointPair.p(obj, next);
                    }
                }
                this.f84964h.add(this.f84962f);
            } while (d());
            this.f84964h = null;
            return (EndpointPair) b();
        }

        private Undirected(BaseGraph baseGraph) {
            super(baseGraph);
            this.f84964h = Sets.j(baseGraph.f().size() + 1);
        }
    }

    static EndpointPairIterator e(BaseGraph baseGraph) {
        return baseGraph.d() ? new Directed(baseGraph) : new Undirected(baseGraph);
    }

    final boolean d() {
        Preconditions.z(!this.f84963g.hasNext());
        if (!this.f84961d.hasNext()) {
            return false;
        }
        Object next = this.f84961d.next();
        this.f84962f = next;
        this.f84963g = this.f84960c.a(next).iterator();
        return true;
    }

    private EndpointPairIterator(BaseGraph baseGraph) {
        this.f84962f = null;
        this.f84963g = ImmutableSet.z().iterator();
        this.f84960c = baseGraph;
        this.f84961d = baseGraph.f().iterator();
    }
}

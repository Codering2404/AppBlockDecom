package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f84975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BaseGraph f84976b;

    IncidentEdgeSet(BaseGraph baseGraph, Object obj) {
        this.f84976b = baseGraph;
        this.f84975a = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        if (this.f84976b.d()) {
            if (!endpointPair.b()) {
                return false;
            }
            Object objN = endpointPair.n();
            Object objO = endpointPair.o();
            return (this.f84975a.equals(objN) && this.f84976b.a(this.f84975a).contains(objO)) || (this.f84975a.equals(objO) && this.f84976b.c(this.f84975a).contains(objN));
        }
        if (endpointPair.b()) {
            return false;
        }
        Set setH = this.f84976b.h(this.f84975a);
        Object objE = endpointPair.e();
        Object objF = endpointPair.f();
        return (this.f84975a.equals(objF) && setH.contains(objE)) || (this.f84975a.equals(objE) && setH.contains(objF));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f84976b.d() ? (this.f84976b.i(this.f84975a) + this.f84976b.g(this.f84975a)) - (this.f84976b.a(this.f84975a).contains(this.f84975a) ? 1 : 0) : this.f84976b.h(this.f84975a).size();
    }
}

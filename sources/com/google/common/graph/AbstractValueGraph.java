package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {

    /* JADX INFO: renamed from: com.google.common.graph.AbstractValueGraph$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends AbstractGraph<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractValueGraph f84919a;

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set b() {
            return this.f84919a.b();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set c(Object obj) {
            return this.f84919a.c(obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean d() {
            return this.f84919a.d();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean e() {
            return this.f84919a.e();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set f() {
            return this.f84919a.f();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int g(Object obj) {
            return this.f84919a.g(obj);
        }

        @Override // com.google.common.graph.BaseGraph
        public Set h(Object obj) {
            return this.f84919a.h(obj);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int i(Object obj) {
            return this.f84919a.i(obj);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int j(Object obj) {
            return this.f84919a.j(obj);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set a(Object obj) {
            return this.f84919a.a(obj);
        }
    }

    public static /* synthetic */ Object t(ValueGraph valueGraph, EndpointPair endpointPair) {
        Object objM = valueGraph.m(endpointPair.e(), endpointPair.f(), null);
        Objects.requireNonNull(objM);
        return objM;
    }

    private static Map u(final ValueGraph valueGraph) {
        return Maps.h(valueGraph.b(), new Function() { // from class: com.google.common.graph.j
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return AbstractValueGraph.t(valueGraph, (EndpointPair) obj);
            }
        });
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set b() {
        return super.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        return d() == valueGraph.d() && f().equals(valueGraph.f()) && u(this).equals(u(valueGraph));
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int g(Object obj) {
        return super.g(obj);
    }

    public final int hashCode() {
        return u(this).hashCode();
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
        return "isDirected: " + d() + ", allowsSelfLoops: " + e() + ", nodes: " + f() + ", edges: " + u(this);
    }
}

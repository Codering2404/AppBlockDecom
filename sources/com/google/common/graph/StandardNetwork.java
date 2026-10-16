package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class StandardNetwork<N, E> extends AbstractNetwork<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f84994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f84995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f84996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final MapIteratorCache f84997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final MapIteratorCache f84998e;

    @Override // com.google.common.graph.Network
    public Set b() {
        return this.f84998e.g();
    }

    @Override // com.google.common.graph.Network
    public Set c(Object obj) {
        return r(s(obj).b(), obj);
    }

    @Override // com.google.common.graph.Network
    public boolean d() {
        return this.f84994a;
    }

    @Override // com.google.common.graph.Network
    public boolean e() {
        return this.f84996c;
    }

    @Override // com.google.common.graph.Network
    public Set f() {
        return this.f84997d.g();
    }

    @Override // com.google.common.graph.Network
    public Set h(Object obj) {
        return r(s(obj).c(), obj);
    }

    @Override // com.google.common.graph.Network
    public boolean l() {
        return this.f84995b;
    }

    @Override // com.google.common.graph.Network
    public EndpointPair n(Object obj) {
        Object objT = t(obj);
        NetworkConnections networkConnections = (NetworkConnections) this.f84997d.d(objT);
        Objects.requireNonNull(networkConnections);
        return EndpointPair.h(this, objT, networkConnections.d(obj));
    }

    final NetworkConnections s(Object obj) {
        NetworkConnections networkConnections = (NetworkConnections) this.f84997d.d(obj);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.t(obj);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", obj));
    }

    final Object t(Object obj) {
        Object objD = this.f84998e.d(obj);
        if (objD != null) {
            return objD;
        }
        Preconditions.t(obj);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", obj));
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set a(Object obj) {
        return r(s(obj).a(), obj);
    }
}

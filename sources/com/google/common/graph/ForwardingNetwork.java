package com.google.common.graph;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    @Override // com.google.common.graph.Network
    public Set b() {
        return s().b();
    }

    @Override // com.google.common.graph.Network
    public Set c(Object obj) {
        return s().c(obj);
    }

    @Override // com.google.common.graph.Network
    public boolean d() {
        return s().d();
    }

    @Override // com.google.common.graph.Network
    public boolean e() {
        return s().e();
    }

    @Override // com.google.common.graph.Network
    public Set f() {
        return s().f();
    }

    @Override // com.google.common.graph.Network
    public Set h(Object obj) {
        return s().h(obj);
    }

    @Override // com.google.common.graph.Network
    public boolean l() {
        return s().l();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair n(Object obj) {
        return s().n(obj);
    }

    abstract Network s();

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set a(Object obj) {
        return s().a(obj);
    }
}
